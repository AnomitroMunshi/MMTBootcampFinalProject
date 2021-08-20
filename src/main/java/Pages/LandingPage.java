package Pages;

import FileReader.ConfigReader;
import Utils.DateFormatter;
import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.List;

public class LandingPage extends BasePage{

    Logger logger = LogManager.getLogger(LandingPage.class);

    private String pageUrl= ConfigReader.getProperty("baseUrl");


    //page locators
    By Popup = By.xpath("//div[contains(@class,'autopop')]");
    By LOCATIONBOX=By.xpath("//label[@for='city']");
    By LOCATIONINPUT=By.xpath("//input[contains(@placeholder,'Enter city')]");
    By LOCATIONAME=By.cssSelector("#city");
    By NEXTDATES=By.xpath("//span[contains(@aria-label,'Next Month')]");
    By ROOMGUESTCOUNT=By.xpath("//p[contains(@data-cy,'roomGuestCount')]");
    By SUBMITROOMGUEST=By.xpath("//button[contains(@data-cy,'submitGuest')]");
    By CHILDAGELIST=By.xpath("//ul[contains(@class,'childAgeList')]/li");
    By TRAVELFOR=By.xpath("//div[contains(@class,'travelFor')]");
    By ADDNEWROOM=By.cssSelector(".btnAddRoom");
    By SEARCHBTN=By.xpath("//button[text()='Search']");





    //Dynamic Locators
    String MENULIST="//li[@class='menu_%replacable%']";
    String DATEPICKER="//div[@aria-label='%replacable%' and @aria-disabled='false']";
    String ADULTCOUNT= "//ul[@data-cy='adultCount']/li[@data-cy='adults-%replacable%']";
    String CHILDCOUNT= "//li[@data-cy='children-%replacable%']";
    String CHILDLISTEACH="//ul[contains(@class,'childAgeList')]/li[%replacable%]/label/select";
    String travelForOpt="//li[@data-cy='travelFor-%replacable%']";





    //page functions
    public void open(){
        logger.info("Navingating to "+pageUrl);
        openPage(pageUrl);
    }

    public boolean verifyCurrentUrl(String url){
        String currentURL=getCurrentUrl();
        logger.info("Current URL : "+currentURL);
        return currentURL.equals(url);
    }

    /*Function to click on HOTEL TAB*/
    public boolean goToPagetab(String pageTab){
        logger.info("Clicking on menu: "+pageTab);
        try{
            waitForPageLoad();
            click(DynamicXpath.get(MENULIST,pageTab));

        }catch (Exception e){
            logger.info("Popup found, clicking hotel menu link");
            doActionsMoveByOffset();
            click(DynamicXpath.get(MENULIST,pageTab));
        }
        return getCurrentUrl().contains("/hotels");
    }

    /*Function to input Hotel/travel Location*/
    public String goToLocation(String city){

        try{
            click(LOCATIONBOX);
            fillTextwithdownEnter(LOCATIONINPUT,city);

        }catch (Exception e){
            e.printStackTrace();
        }

        return getElement(LOCATIONAME).getAttribute("value");
    }

    /*Function to input Checkin & CheckOut Date*/
    public boolean selectDate(String chckInDate,String chckOutDate){
        while (getElement(NEXTDATES).isDisplayed()){
            logger.info("next date arrow displayed!");
            try{
                click(DynamicXpath.get(DATEPICKER, DateFormatter.formatDate(chckInDate)));
            }catch (TimeoutException e){
                click(NEXTDATES);
            }
            catch (Exception e){
                throw new IllegalStateException("Date not foud");
            }

            try{
                click(DynamicXpath.get(DATEPICKER,DateFormatter.formatDate(chckOutDate)));
                break;
            }catch (TimeoutException e){
                click(NEXTDATES);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    return getElement(ROOMGUESTCOUNT).isDisplayed();
    }

    /*Function to input No.of Guests and No.of Rooms*/
    public void inputRoomsAndGuest(String noOfRooms, String noOfAdults, String noOfChildren, List<String> childrenages){
        if(Integer.parseInt(noOfRooms)<1)
            throw  new IllegalStateException("No.of rooms cannot be less than 1");

             click(ROOMGUESTCOUNT);
             inputAdultAndChildren(noOfAdults,noOfChildren,childrenages);

        if(Integer.parseInt(noOfRooms)>1){
            //implementation when no.of rooms >1
        }
        click(SUBMITROOMGUEST);
    }

    /*Function to input adult adn children*/
    private void inputAdultAndChildren(String noOfAdults,String noOfChildren,List<String> childrenages){
        System.out.println("no.of adults="+noOfAdults);
        click(DynamicXpath.get(ADULTCOUNT,noOfAdults));

        if(Integer.parseInt(noOfChildren)>0){
            click(DynamicXpath.get(CHILDCOUNT,noOfChildren));
            inputChildrenAge(childrenages);
        }else{
            click(DynamicXpath.get(CHILDCOUNT,noOfChildren));
        }
    }

    /*Function to input children age*/
    private void inputChildrenAge(List<String> childrenages){
        List<WebElement> childAgeDropdown=getElements(CHILDAGELIST);
        for(int i=0;i<childAgeDropdown.size();i++){

            doSelectDropDownByVisibleText(DynamicXpath.get(CHILDLISTEACH,String.valueOf(i+1)),childrenages.get(i));

        }
    }

    /*Function to input Travel For */
    public void inputTravelFor(String travelFor){
        click(TRAVELFOR);
        click(DynamicXpath.get(travelForOpt,travelFor));
    }

    /*Function to search hotels*/
    public boolean submitSearch(){
        click(SEARCHBTN);
        waitForPageLoad();
        return getCurrentUrl().contains("/hotel-listing");
    }

}
