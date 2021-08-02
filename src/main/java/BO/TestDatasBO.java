package BO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TestDatasBO {

    Logger logger= LogManager.getLogger(TestDatasBO.class);
    private String PageMenu;
    private String Location;
    private String CheckInDate;
    private String CheckOutDate;
    private String NoOfRooms;
    private String NoOfAdults;
    private String NoOfChildren;
    private List<String> ChidrenAgeList=new ArrayList<>();
    private String TravellingFor;

    public String getPageMenu() {
        return PageMenu;
    }

    public void setPageMenu(String pageMenu) {
        if(pageMenu!=null) {
            PageMenu = pageMenu;
            System.out.println("Menu-->"+PageMenu);
        }
        else
            throw new IllegalStateException("PageMenu cannot be null");
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        if(location!=null) {
            Location = location;
            logger.info("Location :"+Location);
        }
        else
            throw new IllegalStateException("Location TestData is null");
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String checkInDate) {
        if(checkInDate!=null) {
            CheckInDate = checkInDate;
            logger.info("Check-In-Date :"+CheckInDate);
        }
        else
            throw new IllegalStateException("CheckInDate TestData is null");
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        if(checkOutDate!=null) {
            CheckOutDate = checkOutDate;
            logger.info("Check-out-Date :"+CheckOutDate);
        }
        else
            throw new IllegalStateException("CheckOutDate TestData is null");
    }

    public String getNoOfRooms() {
        return NoOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        if(Integer.parseInt(noOfRooms)>0) {
            NoOfRooms = noOfRooms;
            logger.info("no.of Rooms :"+NoOfRooms);
        }
        else
            throw new IllegalStateException("No.of rooms should be greater than 0");
    }

    public String getNoOfAdults() {
        return NoOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        if(Integer.parseInt(noOfAdults)>0) {
            NoOfAdults = noOfAdults;
            logger.info("no.of adults :"+NoOfAdults);
        }
        else
            throw new IllegalStateException("No.of adults should be atleast 1");
    }

    public String getNoOfChildren() {
        return NoOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        if(Integer.parseInt(noOfChildren)>0)
            NoOfChildren = noOfChildren;
        else if(Integer.parseInt(noOfChildren)==0)
            NoOfChildren="0";
        else
            throw new IllegalStateException("No.of children cannot be less than 0");
        logger.info("No.of childern:"+NoOfChildren);
    }

    public List<String> getChidrenAge() {
        return ChidrenAgeList;
    }

    public void setChidrenAge(List<String> chidrenAge) {
        if(!chidrenAge.isEmpty()){
            for(String age:chidrenAge) {

                if (Integer.parseInt(age) > 0 && Integer.parseInt(age) <= 12) {
                    ChidrenAgeList.add(age);
                }
                else
                    throw new IllegalStateException("Children age cannot be more than 12");
            }
        }
        else
            ChidrenAgeList=null;
        logger.info("Children age list :"+ChidrenAgeList);
    }

    public String getTravellingFor() {
        return TravellingFor;
    }

    public void setTravellingFor(String travellingFor) {
        if(travellingFor!=null){
            logger.info("Travelling forDate :"+travellingFor);
            TravellingFor = travellingFor;
        }
        else
            throw new IllegalStateException("Travelling for TestData is null");

    }

    @Override
    public String toString() {
        return "TestDatasBO{" +
                "PageMenu='" + PageMenu + '\'' +
                ", Location='" + Location + '\'' +
                ", CheckInDate='" + CheckInDate + '\'' +
                ", CheckOutDate='" + CheckOutDate + '\'' +
                ", NoOfRooms='" + NoOfRooms + '\'' +
                ", NoOfAdults='" + NoOfAdults + '\'' +
                ", NoOfChildren='" + NoOfChildren + '\'' +
                ", ChidrenAgeList=" + ChidrenAgeList +
                ", TravellingFor='" + TravellingFor + '\'' +
                '}';
    }
}
