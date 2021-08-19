package Testcases;

import BO.HotelDetailsBO;
import PageFlow.CheckOutFlow;
import PageFlow.reviewbookingFlow;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ReviewBookingTest extends BaseTest{

    HotelDetailsBO guestsDetailsBO=hotelDetailsBO;

    @Test
    public void reviewDetailsTest(){
        Assert.assertTrue(reviewbookingFlow.reviewHoteldetails(guestsDetailsBO));
    }

    @Test
    public void enterguestDetailsandPay(){
        Assert.assertTrue(reviewbookingFlow.inputGuestDetailsAndPay());
    }

    @Test
    public void verifyCheckOutPage(){
        Assert.assertTrue(CheckOutFlow.verifyCheckOut(guestsDetailsBO));
    }
}
