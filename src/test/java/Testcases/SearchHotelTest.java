package Testcases;

import BO.TestDatasBO;
import PageFlow.SearchConfigureFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchHotelTest extends BaseTest{

    @Test
    public void gotoHoteltabTest(){
        Assert.assertTrue(SearchConfigureFlow.clickMenuTab());
    }

    @Test
    public void enterLocationTest(){
        Assert.assertTrue(SearchConfigureFlow.enterLocation());
    }

    @Test
    public void selectDates(){
        Assert.assertTrue(SearchConfigureFlow.enterDates());
    }

    @Test
    public void selectRoomsAndGuestsTest(){
        SearchConfigureFlow.enterRoomsAndGuests();
    }

    @Test
    public void selectTravelFor(){
        SearchConfigureFlow.enterTravelFor();
    }
}
