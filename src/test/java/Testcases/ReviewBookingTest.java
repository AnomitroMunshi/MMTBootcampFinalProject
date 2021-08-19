package Testcases;

import BO.HotelDetailsBO;
import PageFlow.CheckOutFlow;
import PageFlow.reviewbookingFlow;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ReviewBookingTest extends BaseTest{

    HotelDetailsBO guestsDetailsBO=hotelDetailsBO;

    @Test
    @Epic("ReviewBooking Page Component")
    @Story("Test to verify details in Reveiw Page")
    public void reviewDetailsTest(){
        Assert.assertTrue(reviewbookingFlow.reviewHoteldetails(guestsDetailsBO));
    }

    @Test
    @Epic("ReviewBooking Page Component")
    @Story("Test to input random guest details")
    public void enterguestDetailsandPayTest(){
        Assert.assertTrue(reviewbookingFlow.inputGuestDetailsAndPay());
    }

    @Test
    @Epic("ReviewBooking Page Component")
    @Story("Test to verify checkout details")
    public void verifyCheckOutPageTest(){
        Assert.assertTrue(CheckOutFlow.verifyCheckOut(guestsDetailsBO));
    }
}
