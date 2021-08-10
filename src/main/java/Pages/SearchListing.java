package Pages;

import FileReader.ConfigReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SearchListing extends BasePage{

    Logger logger = LogManager.getLogger(SearchListing.class);

    //Page Locators
    By LOCATIONBOX= By.id("city");
    By CHECKINDATE=By.id("checkin");
    By CHECKOUTDATE=By.id("checkout");
    By GUESTBOX=By.id("guest");


    //Dynamic Locators
    String MENULIST="//li[@class='menu_%replacable%']";


    //page functions

    public String getAttributeValue(String option){
        waitForPageLoad();
        By XPATH;
        switch (option){
            case "LOCATION":
                XPATH=LOCATIONBOX;
                break;
            case "CHECKINDATE":
                XPATH=CHECKINDATE;
                break;
            case "CHECKOUTDATE":
                XPATH=CHECKOUTDATE;
                break;
            case "GUESTS":
                XPATH=GUESTBOX;
                break;

            default:
                throw new IllegalStateException("No such option present");

        }
        return getElement(XPATH).getAttribute("value");
    }




}
