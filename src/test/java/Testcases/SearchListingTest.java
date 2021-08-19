package Testcases;

import BO.HotelDetailsBO;
import PageFlow.SearchListingFlow;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchListingTest extends BaseTest{

    HotelDetailsBO searchListpageBO=hotelDetailsBO;;

    @Test
    @Epic("Hotel Search Listing Component")
    @Story("Test to verify seacrh criteria")
    public void checkSearchCriteriaTest(){
        System.out.println(searchListpageBO);
        Assert.assertTrue(SearchListingFlow.assertSearchCriteria(searchListpageBO));
    }

    @Test
    @Epic("Hotel Search Listing Component")
    @Story("Test to verify filters")
    public void setAndVerifyFilterTest(){
        Assert.assertTrue(SearchListingFlow.applySearchFilter());
    }

    @Test
    @Epic("Hotel Search Listing Component")
    @Story("Test to select 5th hotel / last hotel in the list")
    public void selectHotelTest(){
       Assert.assertTrue(SearchListingFlow.selectHotel());

    }

}
