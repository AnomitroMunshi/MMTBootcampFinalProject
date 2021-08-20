package Pages;

import BO.Constants;
import PageFlow.reviewbookingFlow;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Reviewpage extends BasePage{

    static Logger logger= LogManager.getLogger(Reviewpage.class);
    By HOTELNAME=By.xpath("//div[@class='reviewContainer']//h3");
    By GUESTDETAILS=By.xpath("//div[@class='reviewContainer']//div[@class='chkCont']//p");
    By CHECKINDATE=By.xpath("//div[@class='reviewContainer']//div[@class='chkCont']//span[text()='CHECK IN']/following-sibling::span[1]");
    By CHECKOUTDATE=By.xpath("//div[@class='reviewContainer']//div[@class='chkCont']//span[text()='CHECK OUT']/following-sibling::span[1]");

    By FNAME=By.id("fName");
    By LNAME=By.id("lName");
    By PHONE=By.xpath("//input[@placeholder='Contact Number']");
    By EMAIL=By.xpath("//input[@placeholder='Email ID']");
    By BOOKBTN=By.xpath("//a[contains(@class,'Payment')]");



    /*Getting HotelName in review page */
    public String gethotelNameInReviewPage(){
        return getText(HOTELNAME);
    }

    /*Getting fate in review page */
    public String getDateInReviewpage(String dateType){
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

    /*Getting guestCount in review page */
    public String getguestCountInReviewPage(){

        return getText(GUESTDETAILS);

    }

    /*Entering guest details in review page */
    public boolean enterGuestDetails(){

        doActionsMoveToElement(PHONE);

        fillText(FNAME, Constants.fakeFirstName);
        fillText(LNAME,Constants.fakeLirstName);
        fillText(PHONE,Constants.fakePhn);
        fillText(EMAIL,Constants.fakeEmail);
        doActionsMoveToElementAndClick(BOOKBTN);
        return waitForUrlWithCustomTimeOut(Constants.CUSTOMTIMEOUT_10SEC,"/checkout");
    }

}
