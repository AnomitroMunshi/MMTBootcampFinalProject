package Testcases;

import PageFlow.SearchListingFlow;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchListingTest extends BaseTest{

    @Test
    public void checkSearchCriteriaTest(){
        Assert.assertTrue(SearchListingFlow.assertSearchCriteria());
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
