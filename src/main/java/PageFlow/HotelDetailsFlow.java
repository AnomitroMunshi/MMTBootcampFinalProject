package PageFlow;

import FileReader.ConfigReader;
import Pages.HotelDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HotelDetailsFlow {

    static Logger logger= LogManager.getLogger(HotelDetailsFlow.class);
    static HotelDetails hotelDetails=new HotelDetails();
    static String noOfadults=ConfigReader.getProperty("NoOfAdults");
    static String noOfChildren=ConfigReader.getProperty("NoOfChildren");

    public static boolean verifyRecommendedTitle(){
        return hotelDetails.checkRecommendTitle(noOfadults,noOfChildren);
    }

    public static boolean verifyTotalGuestInAllRoom(){

        return hotelDetails.calculateTotalGuests(noOfadults,noOfChildren);
    }

    public static boolean addToCartVerify(){
        hotelDetails.addToCart();
      return hotelDetails.verifyCart(noOfadults,noOfChildren);
    }
}
