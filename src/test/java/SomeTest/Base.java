package SomeTest;

import BO.HotelDetailsBO;
import FileReader.ConfigReader;
import org.testng.annotations.BeforeSuite;

public class Base {
    HotelDetailsBO dbo=new HotelDetailsBO();
    @BeforeSuite
    public void beforeSUIT(){
        new ConfigReader();
        insert.insertToBo(dbo);
    }



}
