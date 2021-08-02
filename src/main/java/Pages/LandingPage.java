package Pages;

import FileReader.ConfigReader;
import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LandingPage extends BasePage{

    Logger logger = LogManager.getLogger(LandingPage.class);

    private String pageUrl= ConfigReader.getProperty("baseUrl");


    //page locators
    By logo=By.xpath("//img[@alt='Make My Trip']");
    By popup = By.xpath("//div[contains(@class,'autopop')]");


    //Dynamic Locators
    String menuList="//li[@class='menu_%replacable%']";





    //page functions
    public void open(){
        logger.info("Navingating to "+pageUrl);
        openPage(pageUrl);
    }

    public boolean verifyCurrentUrl(String url){
        String currentURL=getCurrentUrl();
        logger.info("Current URL : "+currentURL);
        return currentURL.equals(url);
    }

    public boolean goToPagetab(String pageTab){
        logger.info("Clicking on menu: "+pageTab);
        try{
            waitForPageLoad();
            click(DynamicXpath.get(menuList,pageTab));

        }catch (Exception e){
            logger.info("Popup found, clicking hotel menu link");
            doActionsMoveByOffset();
            click(DynamicXpath.get(menuList,pageTab));
        }
        return getCurrentUrl().contains("/hotels");
    }


}
