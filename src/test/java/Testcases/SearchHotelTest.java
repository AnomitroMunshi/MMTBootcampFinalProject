package Testcases;

import BO.HotelDetailsBO;
import BO.TestDatasBO;
import PageFlow.SearchConfigureFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchHotelTest extends BaseTest{

    HotelDetailsBO hotelDetails=hotelDetailsBO;

    @Test
    public void gotoHoteltabTest(){
        Assert.assertTrue(SearchConfigureFlow.clickMenuTab());
    }

    @Test
    public void enterLocationTest(){
        Assert.assertTrue(SearchConfigureFlow.enterLocation(hotelDetails.getLocation()));
    }

    @Test
    public void selectDates(){
        Assert.assertTrue(SearchConfigureFlow.enterDates(hotelDetails.getCheckInDate(),hotelDetails.getCheckOutDate()));
    }

    @Test
    public void selectRoomsAndGuestsTest(){
        SearchConfigureFlow.enterRoomsAndGuests(hotelDetails.getNoOfRooms(),hotelDetails.getNoOFAdults(),hotelDetails.getNoOfChildren(),hotelDetails.getChildrenAge());
    }

    @Test
    public void selectTravelFor(){
        SearchConfigureFlow.enterTravelFor(hotelDetails.getTravellingFor());
    }

    @Test
    public void enterSearch(){
        Assert.assertTrue(SearchConfigureFlow.search());
    }
}
