package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class CheckOut extends BasePage{

    static Logger logger= LogManager.getLogger(Reviewpage.class);

    //Locators
    By CHECKINDATE=By.xpath("//p[text()='CHECK IN']/following-sibling::p/span[1]");
    By CHECKOUTDATE=By.xpath("//p[text()='CHECK OUT']/following-sibling::p/span[1]");
    By HOTELNAME=By.xpath("//div[contains(@class,'hotel__info')][2]/p");
    By TRAVELLERNAME=By.xpath("//ul[contains(@class,'travellers__details')]/li");
    By TRAVELLERDETAILS=By.xpath("//ul[contains(@class,'travellers__details')]/following-sibling::p");


    //page functions

    /*Getting date in checkout page */
    public String getDateFromCheckOutPage(String dateType){
        String dates="";
        switch (dateType){
            case "CHECKINDATE":
                dates= getText(CHECKINDATE);
                break;
            case "CHECKOUTDATE":
                dates=getText(CHECKOUTDATE);
                break;
            default:
                logger.info("Wrong input of dates");
        }

        return dates;

    }

    /*Getting hotelName in checkout page */
    public String getHotelNameFromCheckOutPage(){
        logger.info(getText(HOTELNAME));
        return getText(HOTELNAME);
    }

    /*Getting traveller in checkout page */
    public String getTravellerNameFromCheckoutPage(){
        logger.info(getText(TRAVELLERNAME));
        return getText(TRAVELLERNAME);
    }

    /*Getting traveller contact info in checkout page */
    public String getTravellerContactInfoFromCheckOutPage(){
        logger.info(getText(TRAVELLERDETAILS));
        return getText(TRAVELLERDETAILS);
    }

}
