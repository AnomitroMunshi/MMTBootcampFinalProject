package PageFlow;

import BO.Constants;
import BO.TestDatasBO;
import FileReader.JSONReader;
import Pages.LandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SearchConfigureFlow {

    static  Logger logger= LogManager.getLogger(SearchConfigureFlow.class);

    static TestDatasBO testDatas=JSONReader.readJOSN();
    static LandingPage landingPage=new LandingPage();

    public static boolean verifyCurrentURL(){
        return landingPage.verifyCurrentUrl(Constants.pageURL);
    }

    public static boolean clickMenuTab() {
        System.out.println(testDatas.getPageMenu());
        return landingPage.goToPagetab(testDatas.getPageMenu());

    }

    public static boolean EnterLocation(){

        logger.info("City to be entered entered :"+testDatas.getLocation());
        String city=landingPage.goToLocation(testDatas.getLocation());
        logger.info("City entered :"+city);

        return (city!=null);

    }

    public static boolean enterDates(){
        logger.info("Entering checkin and checkout dates");
        return landingPage.selectDate(testDatas.getCheckInDate(),testDatas.getCheckOutDate());
    }


       /* selectLocation(testDatasBO.getLocation());
        selectCheckinDate();
        selectCheckoutDate();*/

}
