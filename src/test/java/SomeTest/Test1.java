package SomeTest;

import BO.HotelDetailsBO;
import org.testng.annotations.Test;

public class Test1 extends Base{


    HotelDetailsBO detailsBO=dbo;

    @Test
    public void testt(){
        System.out.println(detailsBO.getNoOFAdults());
        System.out.println(detailsBO.getNoOfChildren());
    }
}
