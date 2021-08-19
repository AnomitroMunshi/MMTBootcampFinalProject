package PageFlow;

import FileReader.ConfigReader;
import Pages.HotelDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HotelDetailsFlow {

    static Logger logger= LogManager.getLogger(HotelDetailsFlow.class);
    static HotelDetails hotelDetails=new HotelDetails();


    public static boolean verifyRecommendedTitle(String noOfadults,String noOfChildren){
        return hotelDetails.checkRecommendTitle(noOfadults,noOfChildren);
    }

    public static boolean verifyTotalGuestInAllRoom(String noOfadults,String noOfChildren){

        return hotelDetails.calculateTotalGuests(noOfadults,noOfChildren);
    }

    public static boolean addToCartVerify(String noOfadults,String noOfChildren){
        hotelDetails.addToCart(Integer.parseInt(noOfadults),Integer.parseInt(noOfChildren));
      return hotelDetails.verifyCart(noOfadults,noOfChildren);
    }
}
