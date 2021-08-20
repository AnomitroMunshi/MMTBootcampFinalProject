package PageFlow;


import BO.Constants;
import BO.TestDatasBO;
import Pages.SearchListing;
import Utils.DateFormatter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SearchListingFlow {

    static  Logger logger= LogManager.getLogger(SearchListingFlow.class);
    static SearchListing searchListingPage=new SearchListing();


    /*Verifying search criteria*/
    public static boolean assertSearchCriteria(TestDatasBO detailsBO){

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
            LocationInput= detailsBO.getLocation();
            logger.info("Location by user:"+ LocationInput);
            checkInInput= DateFormatter.formatDateWithComma(detailsBO.getCheckInDate());
            logger.info("Checkin date by user:"+ checkInInput);
            checkOutInput= DateFormatter.formatDateWithComma(detailsBO.getCheckOutDate());
            logger.info("Checkout date by user:"+ checkOutInput);
            noOfChildren=detailsBO.getNoOfChildren();

            if(Integer.parseInt(noOfChildren)>0){
                totalGuests=detailsBO.getNoOfRooms()+" Room, "+detailsBO.getNoOFAdults()+" Adults, " +
                        ""+detailsBO.getNoOfChildren()+" Children";
            }
            else {
                totalGuests=detailsBO.getNoOfRooms()+" Room, "+detailsBO.getNoOFAdults()+" Adults";
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

    /*Applying search filters*/
    public static boolean applySearchFilter(){

        searchListingPage.selectPriceRange();
        searchListingPage.selectUserRating();
        return searchListingPage.verifyFilters();
    }

    /*Selecting 5th Hotel or last hotel according to availability*/
    public static boolean selectHotel(){

       Constants.hotelName = searchListingPage.getHotelDetails();

       return searchListingPage.switchWindowTab(Constants.hotelName);
    }

}
