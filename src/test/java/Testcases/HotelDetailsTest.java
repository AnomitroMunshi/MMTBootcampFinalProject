package Testcases;

import BO.HotelDetailsBO;
import PageFlow.HotelDetailsFlow;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelDetailsTest extends BaseTest{

    HotelDetailsBO guestDetails=hotelDetailsBO;

    @Test
    public void verifyRecommendedRoomsTest(){

       Assert.assertTrue(HotelDetailsFlow.verifyRecommendedTitle(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));
       Assert.assertTrue(HotelDetailsFlow.verifyTotalGuestInAllRoom(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));
    }


    @Test
    public void addRoomsToCartAndVerifyTest(){
       Assert.assertTrue(HotelDetailsFlow.addToCartVerify(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));

    }

}
