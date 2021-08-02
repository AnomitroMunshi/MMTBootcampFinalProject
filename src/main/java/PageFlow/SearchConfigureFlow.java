package PageFlow;

import BO.Constants;
import BO.TestDatasBO;
import FileReader.ConfigReader;
import FileReader.JSONReader;
import Pages.LandingPage;

import java.io.FileReader;

public class SearchConfigureFlow {

    static TestDatasBO testDatasBO=JSONReader.readJOSN();
    static LandingPage landingPage=new LandingPage();

    public static boolean verifyCurrentURL(){
        return landingPage.verifyCurrentUrl(Constants.pageURL);
    }

    public static boolean clickMenuTab() {
        System.out.println(testDatasBO.getPageMenu());
        return landingPage.goToPagetab(testDatasBO.getPageMenu());

    }
       /* selectLocation(testDatasBO.getLocation());
        selectCheckinDate();
        selectCheckoutDate();*/

}
