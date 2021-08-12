package PageFlow;

import FileReader.ConfigReader;
import Pages.HotelDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HotelDetailsFlow {

    static Logger logger= LogManager.getLogger(HotelDetailsFlow.class);
    static HotelDetails hotelDetails=new HotelDetails();


    public static boolean verifyRecommendedTitle(){
        return hotelDetails.checkRecommendTitle(ConfigReader.getProperty("NoOfAdults"),ConfigReader.getProperty("NoOfChildren"));
    }

    public static boolean verifyTotalGuestInAllRoom(){

        return hotelDetails.calculateTotalGuests(ConfigReader.getProperty("NoOfAdults"),ConfigReader.getProperty("NoOfChildren"));
    }
}
