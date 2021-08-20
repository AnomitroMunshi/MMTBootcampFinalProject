package FileReader;

import BO.TestDatasBO;

public class DataReader {

    public static void getValuesFromFile(TestDatasBO testDatasBO){

        testDatasBO.setLocation(ConfigReader.getProperty("Location"));
        testDatasBO.setNoOFAdults(ConfigReader.getProperty("NoOfAdults"));
        testDatasBO.setNoOfChildren(ConfigReader.getProperty("NoOfChildren"));
        testDatasBO.setChildrenAge(ConfigReader.getProperty("ChildrenAge"));
        testDatasBO.setCheckInDate(ConfigReader.getProperty("CheckInDate"));
        testDatasBO.setCheckOutDate(ConfigReader.getProperty("CheckOutDate"));
        testDatasBO.setNoOfRooms(ConfigReader.getProperty("NoOfRooms"));
        testDatasBO.setTravellingFor(ConfigReader.getProperty("TravellingFor"));

    }
}
