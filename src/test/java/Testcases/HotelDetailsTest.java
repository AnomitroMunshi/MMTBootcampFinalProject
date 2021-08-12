package Testcases;

import PageFlow.HotelDetailsFlow;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelDetailsTest extends BaseTest{

    @Test
    public void verifyRecommendedRooms(){

       Assert.assertTrue(HotelDetailsFlow.verifyRecommendedTitle());
       Assert.assertTrue(HotelDetailsFlow.verifyTotalGuestInAllRoom());

        //softAssert
       // Assert.assertTrue();
    }

}
