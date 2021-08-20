package Testcases;

import BO.TestDatasBO;
import PageFlow.HotelDetailsFlow;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelDetailsTest extends BaseTest{

    TestDatasBO guestDetails= testDatasBO;

    @Test
    @Epic("Hotel Details Component")
    @Story("Test to verify Recommended Room Title and Guest Count in each recommended box")
    public void verifyRecommendedRoomsTest(){

       Assert.assertTrue(HotelDetailsFlow.verifyRecommendedTitle(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));
       Assert.assertTrue(HotelDetailsFlow.verifyTotalGuestInAllRoom(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));
    }


    @Test
    @Epic("Hotel Details Component")
    @Story("Test to add required rooms to cart")
    public void addRoomsToCartAndVerifyTest(){
       Assert.assertTrue(HotelDetailsFlow.addToCartVerify(guestDetails.getNoOFAdults(),guestDetails.getNoOfChildren()));

    }

}
