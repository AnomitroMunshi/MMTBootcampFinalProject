package FileReader;

import BO.HotelDetailsBO;

public class DataReader {

    public static void getValuesFromFile(HotelDetailsBO hotelDetailsBO){

        hotelDetailsBO.setLocation(ConfigReader.getProperty("Location"));
        hotelDetailsBO.setNoOFAdults(ConfigReader.getProperty("NoOfAdults"));
        hotelDetailsBO.setNoOfChildren(ConfigReader.getProperty("NoOfChildren"));
        hotelDetailsBO.setChildrenAge(ConfigReader.getProperty("ChildrenAge"));
        hotelDetailsBO.setCheckInDate(ConfigReader.getProperty("CheckInDate"));
        hotelDetailsBO.setCheckOutDate(ConfigReader.getProperty("CheckOutDate"));
        hotelDetailsBO.setNoOfRooms(ConfigReader.getProperty("NoOfRooms"));
        hotelDetailsBO.setTravellingFor(ConfigReader.getProperty("TravellingFor"));

    }
}
