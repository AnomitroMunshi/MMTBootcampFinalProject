package Testcases;

import PageFlow.HotelDetailsFlow;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelDetailsTest extends BaseTest{

    @Test
    public void verifyRecommendedRoomsTest(){

       Assert.assertTrue(HotelDetailsFlow.verifyRecommendedTitle());
       Assert.assertTrue(HotelDetailsFlow.verifyTotalGuestInAllRoom());
    }


    @Test
    public void addRoomsToCartAndVerifyTest(){
       Assert.assertTrue(HotelDetailsFlow.addToCartVerify());

    }

}
