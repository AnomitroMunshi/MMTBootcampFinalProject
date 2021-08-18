package PageFlow;

import BO.Constants;
import FileReader.ConfigReader;
import Pages.Reviewpage;
import Utils.DateFormatter;
import com.github.javafaker.Faker;
import org.apache.commons.io.output.ClosedOutputStream;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class reviewbookingFlow {

    static Logger logger= LogManager.getLogger(reviewbookingFlow.class);
    static Reviewpage reviewpage=new Reviewpage();

    public static boolean reviewHoteldetails(){

        String hotelName=reviewpage.gethotelNameInReviewPage();
        logger.info("Hotel Name saved earlier="+Constants.hotelName);
        String checkInDate=reviewpage.getDateInReviewpage(Constants.CHECKINDATE);
        String checkOutDate=reviewpage.getDateInReviewpage(Constants.CHECKOUTDATE);
        String totalGuestCount=reviewpage.getguestCountInReviewPage();
        logger.info("Total guest & room count from review page="+totalGuestCount);

        String totalAdultsInput=ConfigReader.getProperty("NoOfAdults");
        String totalChildren=ConfigReader.getProperty("NoOfChildren");
        String guestCountFromInput=totalAdultsInput+" Adults, "+totalChildren+" Children | "+Constants.totalRoomsBooked+" Rooms";
        logger.info("Guest & room count from input="+guestCountFromInput);
        try {
            if(hotelName.equalsIgnoreCase(Constants.hotelName)
            && checkInDate.equalsIgnoreCase(DateFormatter.formatDateForReviewPage(ConfigReader.getProperty("CheckInDate"))) &&
                    checkOutDate.equalsIgnoreCase(DateFormatter.formatDateForReviewPage(ConfigReader.getProperty("CheckOutDate")))
             && totalGuestCount.equalsIgnoreCase(guestCountFromInput)){
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void inputGuestDetailsAndPay(){
        reviewpage.enterGuestDetails();
    }


}
