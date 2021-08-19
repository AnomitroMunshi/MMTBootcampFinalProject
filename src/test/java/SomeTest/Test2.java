package SomeTest;

import BO.HotelDetailsBO;
import org.testng.annotations.Test;

public class Test2 extends Base{
    HotelDetailsBO detailsBO1=dbo;

    @Test
    public void print(){
        System.out.println(detailsBO1);
        System.out.println(detailsBO1.getNoOFAdults());
    }
}
