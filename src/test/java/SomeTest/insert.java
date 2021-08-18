package SomeTest;

import BO.HotelDetailsBO;
import FileReader.ConfigReader;

public class insert {
    public static void insertToBo(HotelDetailsBO bo){
        bo.setNoOfChildren(ConfigReader.getProperty("NoOfChildren"));
        bo.setNoOFAdults(ConfigReader.getProperty("NoOfAdults"));
    }
}
