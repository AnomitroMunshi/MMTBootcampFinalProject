package Pages;

import BO.Constants;
import FileReader.ConfigReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchListing extends BasePage{

    Logger logger = LogManager.getLogger(SearchListing.class);
    public   String FILTERMAXPRICE="";
    public   String FILTERMINPRICE="";

    //Page Locators
    By LOCATIONBOX= By.id("city");
    By CHECKINDATE=By.id("checkin");
    By CHECKOUTDATE=By.id("checkout");
    By GUESTBOX=By.id("guest");

    By FIRSTHOTEL=By.xpath("Listing_hotel_0");
    By MINVALUE=By.xpath("//span[@class='minValue']");
    By MAXVALUE=By.xpath("//span[@class='maxValue']");
   // By MINSLIDER=By.xpath("//div[@role='slider' and @aria-valuemin='0']");
    By MINSLIDER=By.xpath("//div[@id='PRICE']//span[1]//div[1]");
  //  By MAXSLIDER=By.xpath("//div[@role='slider' and @aria-valuemin='1']");
    By MAXSLIDER=By.xpath("//div[@id='PRICE']//span[2]//div[1]");

    By USERRATINGLIST=By.xpath("//div[@id='USER_RATING']//ul[contains(@class,'filterList')]/li");
    By APPLIEDFILTERS=By.xpath("//ul[contains(@class,'appliedFilters')]/li");



    //Dynamic Locators
    String MENULIST="//li[@class='menu_%replacable%']";


    //page functions
    public String getAttributeValue(String option){
        waitForPageLoad();
        By XPATH;
        switch (option){
            case "LOCATION":
                XPATH=LOCATIONBOX;
                break;
            case "CHECKINDATE":
                XPATH=CHECKINDATE;
                break;
            case "CHECKOUTDATE":
                XPATH=CHECKOUTDATE;
                break;
            case "GUESTS":
                XPATH=GUESTBOX;
                break;

            default:
                throw new IllegalStateException("No such option present");

        }
        return getElement(XPATH).getAttribute("value");
    }

    public void selectPriceRange(){

        doActionsMoveToElement(MAXVALUE);
        doActionsDragAndDrop(MAXSLIDER,Constants.MAXSLIDER);
        System.out.println(getText(MAXVALUE));
        String[] maxprice=getText(MAXVALUE).split(" ");
        FILTERMAXPRICE=maxprice[1];
        System.out.println(FILTERMAXPRICE);
        refreshBrowser();
        doActionsMoveToElement(MINSLIDER);
        doActionsDragAndDrop(MINSLIDER, Constants.MINSLIDER);
        System.out.println(getText(MINVALUE));
        FILTERMINPRICE=getText(MINVALUE);


    }

    public void selectUserRating(){
        doActionsMoveToElement(USERRATINGLIST);
        List<WebElement> userRatings=  getElements(USERRATINGLIST);
        System.out.println(userRatings.size());
        for(WebElement e:userRatings){
            if(e.getText().contains(Constants.RATINGFILTER))
                e.click();
        }

    }

    public boolean verifyFilters(){
        List<WebElement> appliedFiltersList=getElements(APPLIEDFILTERS);
        logger.info(appliedFiltersList);
        if(appliedFiltersList.size()==2){
            int flag=-1;
            for(WebElement e:appliedFiltersList){
                System.out.println(e.getText().equals(FILTERMINPRICE+"-"+FILTERMAXPRICE));
                if(e.getText().contains(Constants.RATINGFILTER) || e.getText().equals(FILTERMINPRICE+"-"+FILTERMAXPRICE))
                    logger.info("filter->"+e.getText());
                    flag++;

            }
                return (flag==1);
        }
        else
            return false;
    }




}
