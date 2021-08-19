package PageFlow;

import BO.Constants;

import BO.HotelDetailsBO;
import FileReader.ConfigReader;
import FileReader.JSONReader;
import Pages.LandingPage;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchConfigureFlow {

    static  Logger logger= LogManager.getLogger(SearchConfigureFlow.class);
    static LandingPage landingPage=new LandingPage();


    @Step("Clicking on Hotel Menu Tab")
    public static boolean clickMenuTab() {
        System.out.println(ConfigReader.getProperty("PageMenu"));
        return landingPage.goToPagetab(ConfigReader.getProperty("PageMenu"));

    }

    @Step("Entering {Location} in Location")
    public static boolean enterLocation(String Location){

        logger.info("City to be entered entered :"+Location);
        String city=landingPage.goToLocation(Location);
        logger.info("City entered :"+city);

        return (city!=null);

    }

    @Step("Entering {checkin} in CheckIn date and {checkout} in Checkout date")
    public static boolean enterDates(String checkin,String checkout){
        logger.info("Entering checkin and checkout dates");
        return landingPage.selectDate(checkin,checkout);
    }

    @Step("Entering {noOfRooms} in Rooms ,selecting {noOfAdults} Adults and {noOfChildren} children with ages [{ChildrenAge}]")
    public static void enterRoomsAndGuests(String noOfRooms,String noOfAdults,String noOfChildren,String ChildrenAge){
      logger.info("Entering ROoms ,guests and children");
        List<String> childrenages = new ArrayList<>();

        //segregating childeren ages based on no.of childeren
        if(Integer.parseInt(noOfChildren)>1){ 
            String[] ages=ConfigReader.getProperty("ChildrenAge").split(",");
            childrenages=Arrays.asList(ages);
        }
        else if(Integer.parseInt(noOfChildren)==1 || Integer.parseInt(noOfChildren)==0)
            childrenages.add(ConfigReader.getProperty("ChildrenAge"));

        else
            throw new IllegalStateException("No.of children cannot be less than 0");

        System.out.println(childrenages);


        if(Integer.parseInt(noOfRooms)>0 && Integer.parseInt(noOfAdults)>0){
            landingPage.inputRoomsAndGuest(noOfRooms,noOfAdults,noOfChildren,childrenages);
        }
        else {
            throw new IllegalStateException("No.of Rooms or No.of Rooms cannot be less than 1");
        }


    }

    @Step("Entering {travelFor} in TravelFor")
    public static void enterTravelFor(String travelFor){
        String option=null;
        switch (travelFor.toUpperCase()){
            case "WORK":
                option=Constants.WORK;
                break;
            case "LEISURE":
                option=Constants.LEISURE;
                break;
            default:
                throw new IllegalStateException("Travel for can be only WORK/LEISURE");
        }
        landingPage.inputTravelFor(option);
    }

    @Step("Searching")
    public static boolean search(){
        return landingPage.submitSearch();

    }

}
