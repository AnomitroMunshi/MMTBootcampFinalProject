package Pages;

import FileReader.ConfigReader;
import Utils.DateFormatter;
import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.text.ParseException;

public class LandingPage extends BasePage{

    Logger logger = LogManager.getLogger(LandingPage.class);

    private String pageUrl= ConfigReader.getProperty("baseUrl");


    //page locators
    By Popup = By.xpath("//div[contains(@class,'autopop')]");
    By LOCATIONBOX=By.xpath("//label[@for='city']");
    By LOCATIONINPUT=By.xpath("//input[contains(@placeholder,'Enter city')]");
    By LOCATIONAME=By.cssSelector("#city");
    By NEXTDATES=By.xpath("//span[contains(@aria-label,'Next Month')]");
    By ROOMGUESTCOUNT=By.xpath("//p[contains(@data-cy,'roomGuestCount')]");



    //Dynamic Locators
    String MENULIST="//li[@class='menu_%replacable%']";
    String DATEPICKER="//div[@aria-label='%replacable%' and @aria-disabled='false']";





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
            click(DynamicXpath.get(MENULIST,pageTab));

        }catch (Exception e){
            logger.info("Popup found, clicking hotel menu link");
            doActionsMoveByOffset();
            click(DynamicXpath.get(MENULIST,pageTab));
        }
        return getCurrentUrl().contains("/hotels");
    }

    public String goToLocation(String city){

        try{
            click(LOCATIONBOX);
            fillTextwithdownEnter(LOCATIONINPUT,city);

        }catch (Exception e){
            e.printStackTrace();
        }

        return getElement(LOCATIONAME).getAttribute("value");
    }

    public boolean selectDate(String chckInDate,String chckOutDate){
        while (getElement(NEXTDATES).isDisplayed()){
            logger.info("next date arrow displayed!");
            try{
                click(DynamicXpath.get(DATEPICKER, DateFormatter.formatDate(chckInDate)));
            }catch (TimeoutException e){
                click(NEXTDATES);
            }
            catch (Exception e){
                throw new IllegalStateException("Date not foud");
            }

            try{
                click(DynamicXpath.get(DATEPICKER,DateFormatter.formatDate(chckOutDate)));
                break;
            }catch (TimeoutException e){
                click(NEXTDATES);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    return getElement(ROOMGUESTCOUNT).isDisplayed();
    }


}
