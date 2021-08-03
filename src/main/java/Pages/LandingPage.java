package Pages;

import FileReader.ConfigReader;
import Utils.DateFormatter;
import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LandingPage extends BasePage{

    Logger logger = LogManager.getLogger(LandingPage.class);

    private String pageUrl= ConfigReader.getProperty("baseUrl");


    //page locators
    By Popup = By.xpath("//div[contains(@class,'autopop')]");
    By LocationBox=By.xpath("//label[@for='city']");
    By LocationInput=By.xpath("//input[contains(@placeholder,'Enter city')]");
    By LocationName=By.cssSelector("#city");
    By RoomGuestCount=By.xpath("//p[contains(@data-cy,'roomGuestCount')]");


    //Dynamic Locators
    String menuList="//li[@class='menu_%replacable%']";
    String datePicker="//div[@aria-label='%replacable%' and @aria-disabled='false']";





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

    public String goToLocation(String city){

        try{
            click(LocationBox);
            fillTextwithdownEnter(LocationInput,city);

        }catch (Exception e){
            e.printStackTrace();
        }

        return getElement(LocationName).getAttribute("value");
    }

    public boolean selectDate(String chckInDate,String chckOutDate){
       // while ()
    try{
        click(DynamicXpath.get(datePicker, DateFormatter.formatDate(chckInDate)));
        click(DynamicXpath.get(datePicker,DateFormatter.formatDate(chckOutDate)));



    }catch (Exception e){
        throw new IllegalStateException("Date not foud");
    }
    return getElement(RoomGuestCount).isDisplayed();
    }


}
