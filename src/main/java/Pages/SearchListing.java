package Pages;

import BO.Constants;

import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Set;

public class SearchListing extends BasePage{

    Logger logger = LogManager.getLogger(SearchListing.class);
    public   String FILTERMAXPRICE="";
    public   String FILTERMINPRICE="";

    //Page Locators
    By LOCATIONBOX= By.id("city");
    By CHECKINDATE=By.id("checkin");
    By CHECKOUTDATE=By.id("checkout");
    By GUESTBOX=By.id("guest");


    By MINVALUE=By.xpath("//span[@class='minValue']");
    By MAXVALUE=By.xpath("//span[@class='maxValue']");
    By MINSLIDER=By.xpath("//div[@id='PRICE']//span[1]//div[1]");
    By MAXSLIDER=By.xpath("//div[@id='PRICE']//span[2]//div[1]");

    By USERRATINGS=By.xpath("//div[@id='USER_RATING']//ul[contains(@class,'filterList')]");
    By USERRATINGLIST=By.xpath("//div[@id='USER_RATING']//ul[contains(@class,'filterList')]/li");
    By APPLIEDFILTERS=By.xpath("//ul[contains(@class,'appliedFilters')]/li");

    By HOTELLIST=By.xpath("//div[contains(@id,'Listing_hotel')]");



    //Dynamic Locators
    String HOTELNAME="//div[@id='Listing_hotel_%replacable%']/a//p[contains(@id,'hotel_name')]/span[1]";


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

    /*Selecting price range*/
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

    /*Selecting user rating*/
    public void selectUserRating(){
        doActionsMoveToElement(USERRATINGS);
        List<WebElement> userRatings=  getElements(USERRATINGLIST);
        System.out.println(userRatings.size());

        for(WebElement e:userRatings){
            if(e.getText().contains(Constants.RATINGFILTER))
                try{
                    e.click();
                    break;
                }catch (ElementClickInterceptedException exception){
                    logger.info("Lets wait for 10 sec");
                    doActionsMoveToElement(USERRATINGLIST);
                    waitForElementToBeClickableWithCustomTimeOut(USERRATINGS,Constants.CUSTOMTIMEOUT_10SEC);
                    e.click();
                    break;
                }

        }

    }

    /*Verifying filters*/
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

    /*get hotel details*/
    public String getHotelDetails(){

        waitForElementVisibleWithCustomTimeOut(HOTELLIST,Constants.CUSTOMTIMEOUT_10SEC);
        List<WebElement> hotelList=getElements(HOTELLIST);
        String hotelName;
        if(hotelList.size()>0){
            By XPATH;
            if(hotelList.size()>5){
                XPATH=DynamicXpath.get(HOTELNAME,"4");
                doActionsMoveToElement(XPATH);
                hotelName= getText(XPATH);
                click(XPATH);
            }
            else {
                XPATH=DynamicXpath.get(HOTELNAME, String.valueOf(hotelList.size() - 1));
                doActionsMoveToElement(XPATH);
                hotelName = getText(XPATH);
                click(XPATH);
            }

        }else
            throw new IllegalStateException("No hotels found");

        logger.info("Hotel Name :"+hotelName);
        Constants.hotelName=hotelName;
        return hotelName;
    }

    /*Switching window*/
    public boolean switchWindowTab(String hotelName){

        String currentWindowID=getCurrentWindow();
        Set<String> allWindowhandles=getAllWindows();
        for(String windowId:allWindowhandles){
            if(!windowId.equals(currentWindowID))
                switchToWindow(windowId);
        }
        logger.info(hotelName);
        return getTitle().contains(hotelName);
    }



}
