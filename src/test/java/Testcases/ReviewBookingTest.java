package Testcases;

import PageFlow.reviewbookingFlow;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ReviewBookingTest extends BaseTest{

    @Test
    public void reviewDetailsTest(){
        Assert.assertTrue(reviewbookingFlow.reviewHoteldetails());
    }

    @Test
    public void enterguestDetailsandPay(){
        reviewbookingFlow.inputGuestDetailsAndPay();
    }
}
