package PageFlow;

import BO.Constants;
import BO.HotelDetailsBO;
import Pages.CheckOut;
import Utils.DateFormatter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class CheckOutFlow {

    static Logger logger= LogManager.getLogger(CheckOutFlow.class);
    static CheckOut checkOut=new CheckOut();

    public static boolean verifyCheckOut(HotelDetailsBO detailsBO){

        String checkInDate=checkOut.getDateFromCheckOutPage(Constants.CHECKINDATE);
        String checkOutDate=checkOut.getDateFromCheckOutPage(Constants.CHECKOUTDATE);
        String hotelName=checkOut.getHotelNameFromCheckOutPage();
        String travellerName=checkOut.getTravellerNameFromCheckoutPage();
        String travellerContact=checkOut.getTravellerContactInfoFromCheckOutPage();


        String travellerContactInput=Constants.fakeEmail+" | +91-"+Constants.fakePhn;

        boolean flag=false;
        try {
            if(checkInDate.equals(DateFormatter.formatDateForCheckOutPage(detailsBO.getCheckInDate())) &&
            checkOutDate.equals(DateFormatter.formatDateForCheckOutPage(detailsBO.getCheckOutDate())) &&
                    hotelName.equals(Constants.hotelName) && travellerName.equals(Constants.fakeFirstName+" "+Constants.fakeLirstName)
                    && travellerContact.equals(travellerContactInput))
                flag=true;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return flag;
    }


}
