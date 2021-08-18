package PageFlow;


import BO.Constants;
import FileReader.ConfigReader;
import Pages.SearchListing;
import Utils.DateFormatter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SearchListingFlow {

    static  Logger logger= LogManager.getLogger(SearchListingFlow.class);
    static SearchListing searchListingPage=new SearchListing();


    public static boolean assertSearchCriteria(){

        String LocationInput="";
        String checkInInput="";
        String checkOutInput="";
        String noOfChildren="";
        String totalGuests="";

        logger.info("Printing details from application");
        String locationInApp=searchListingPage.getAttributeValue(Constants.LOCATION);
        String checkInDateInApp=searchListingPage.getAttributeValue(Constants.CHECKINDATE);
        String checkOutDateInApp=searchListingPage.getAttributeValue(Constants.CHECKOUTDATE);
        String guestCountInApp=searchListingPage.getAttributeValue(Constants.GUESTS);
        logger.info("Location from app:"+ locationInApp);
        logger.info("CheckInDate from app:"+ checkInDateInApp);
        logger.info("checkOutDateInApp from app:"+ checkOutDateInApp);
        logger.info("GuestsInApp from app:"+ guestCountInApp);


        logger.info("Printing details which user gave");
        try {
            LocationInput= ConfigReader.getProperty("Location");
            checkInInput= DateFormatter.formatDateWithComma(ConfigReader.getProperty("CheckInDate"));
            checkOutInput= DateFormatter.formatDateWithComma(ConfigReader.getProperty("CheckOutDate"));
            noOfChildren=ConfigReader.getProperty("NoOfChildren");

            if(Integer.parseInt(noOfChildren)>0){
                totalGuests=ConfigReader.getProperty("NoOfRooms")+" Room, "+ConfigReader.getProperty("NoOfAdults")+" Adults, " +
                        ""+ConfigReader.getProperty("NoOfChildren")+" Children";
            }
            else {
                totalGuests=ConfigReader.getProperty("NoOfRooms")+" Room, "+ConfigReader.getProperty("NoOfAdults")+" Adults";
            }

            logger.info("Location by user:"+ LocationInput);
            logger.info("CheckInDate by user:"+ checkInInput);
            logger.info("checkOutDateInApp by user:"+ checkOutInput);
            logger.info("GuestsInApp by user:"+ totalGuests);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return (locationInApp.startsWith(LocationInput) && checkInDateInApp.equalsIgnoreCase(checkInInput)
        && checkOutDateInApp.equalsIgnoreCase(checkOutInput) && guestCountInApp.equalsIgnoreCase(totalGuests));
    }

    public static boolean applySearchFilter(){

        searchListingPage.selectPriceRange();
        searchListingPage.selectUserRating();
        return searchListingPage.verifyFilters();
    }

    public static boolean selectHotel(){

       Constants.hotelName = searchListingPage.getHotelDetails();

       return searchListingPage.switchWindowTab(Constants.hotelName);
    }

}
