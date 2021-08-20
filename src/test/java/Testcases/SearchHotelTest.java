package Testcases;

import BO.TestDatasBO;
import PageFlow.SearchConfigureFlow;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchHotelTest extends BaseTest{

    TestDatasBO hotelDetails= testDatasBO;

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to click to Hotel Tab")
    public void gotoHoteltabTest(){
        Assert.assertTrue(SearchConfigureFlow.clickMenuTab());
    }

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to enter Hotel Location")
    public void enterLocationTest(){
        Assert.assertTrue(SearchConfigureFlow.enterLocation(hotelDetails.getLocation()));
    }

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to select checkin and checkout date")
    public void selectDates(){
        Assert.assertTrue(SearchConfigureFlow.enterDates(hotelDetails.getCheckInDate(),hotelDetails.getCheckOutDate()));
    }

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to select rooms and guests")
    public void selectRoomsAndGuestsTest(){
        SearchConfigureFlow.enterRoomsAndGuests(hotelDetails.getNoOfRooms(),hotelDetails.getNoOFAdults(),hotelDetails.getNoOfChildren(),hotelDetails.getChildrenAge());
    }

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to select reason for travel")
    public void selectTravelFor(){
        SearchConfigureFlow.enterTravelFor(hotelDetails.getTravellingFor());
    }

    @Test
    @Epic("Search Hotel Component")
    @Story("Test to click Serach button")
    public void enterSearch(){
        Assert.assertTrue(SearchConfigureFlow.search());
    }
}
