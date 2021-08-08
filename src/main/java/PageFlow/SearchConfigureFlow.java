package PageFlow;

import BO.Constants;

import FileReader.ConfigReader;
import FileReader.JSONReader;
import Pages.LandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchConfigureFlow {

    static  Logger logger= LogManager.getLogger(SearchConfigureFlow.class);
    static LandingPage landingPage=new LandingPage();

    public static boolean verifyCurrentURL(){
        return landingPage.verifyCurrentUrl(Constants.pageURL);
    }

    public static boolean clickMenuTab() {
        System.out.println(ConfigReader.getProperty("PageMenu"));
        return landingPage.goToPagetab(ConfigReader.getProperty("PageMenu"));

    }

    public static boolean enterLocation(){

        logger.info("City to be entered entered :"+ConfigReader.getProperty("Location"));
        String city=landingPage.goToLocation(ConfigReader.getProperty("Location"));
        logger.info("City entered :"+city);

        return (city!=null);

    }

    public static boolean enterDates(){
        logger.info("Entering checkin and checkout dates");
        return landingPage.selectDate(ConfigReader.getProperty("CheckInDate"),ConfigReader.getProperty("CheckOutDate"));
    }


    public static void enterRoomsAndGuests(){
      logger.info("Entering ROoms ,guests and children");
        List<String> childrenages = new ArrayList<>();
        String noOfRooms=ConfigReader.getProperty("NoOfRooms");
        String noOfAdults=ConfigReader.getProperty("NoOfAdults");
        String noOfChildren=ConfigReader.getProperty("NoOfChildren");

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







        /*if(Integer.parseInt(noOfChildren)>0 && Integer.parseInt(noOfChildren)==childrenages.length){
            if(ConfigReader.getProperty("ChildrenAge")!=null){
                System.out.println("Child array="+ Arrays.toString(childrenages));
                landingPage.inputRoomsAndGuest(noOfRooms,noOfAdults,noOfChildren,childrenages);


            }

            else
                throw new IllegalStateException("ChildrenAge cannot be null ,less or more than no.of children");

        }else if(Integer.parseInt(noOfChildren)==0 && childrenages==null){

        }*/



       // return true;
    }

    public static void enterTravelFor(){
        String travelFor=ConfigReader.getProperty("TravellingFor");
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

    public static boolean search(){
        return landingPage.submitSearch();
    }

}
