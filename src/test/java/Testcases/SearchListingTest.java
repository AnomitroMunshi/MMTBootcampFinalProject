package Testcases;

import BO.HotelDetailsBO;
import PageFlow.SearchListingFlow;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchListingTest extends BaseTest{

    HotelDetailsBO searchListpageBO=hotelDetailsBO;;

    @Test
    public void checkSearchCriteriaTest(){
        System.out.println(searchListpageBO);
        Assert.assertTrue(SearchListingFlow.assertSearchCriteria(searchListpageBO));
    }

    @Test
    public void setAndVerifyFilterTest(){
        Assert.assertTrue(SearchListingFlow.applySearchFilter());
    }

    @Test
    public void selectHotelTest(){
       Assert.assertTrue(SearchListingFlow.selectHotel());

    }

}
