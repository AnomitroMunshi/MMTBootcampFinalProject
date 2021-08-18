package BO;

public class HotelDetailsBO {
    private String noOFAdults;
    private String noOfChildren;
    private String Location;
    private String CheckInDate;
    private String CheckOutDate;
    private String NoOfRooms;
    private String childrenAge;
    private String TravellingFor;


    public String getChildrenAge() {
        return childrenAge;
    }

    public void setChildrenAge(String childrenAge) {
        this.childrenAge = childrenAge;
    }

    public String getNoOFAdults() {
        return noOFAdults;
    }

    public void setNoOFAdults(String noOFAdults) {
        this.noOFAdults = noOFAdults;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String checkInDate) {
        CheckInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public String getNoOfRooms() {
        return NoOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        NoOfRooms = noOfRooms;
    }

    public String getTravellingFor() {
        return TravellingFor;
    }

    public void setTravellingFor(String travellingFor) {
        TravellingFor = travellingFor;
    }

    @Override
    public String toString() {
        return "HotelDetailsBO{" +
                "noOFAdults='" + noOFAdults + '\'' +
                ", noOfChildren='" + noOfChildren + '\'' +
                ", Location='" + Location + '\'' +
                ", CheckInDate='" + CheckInDate + '\'' +
                ", CheckOutDate='" + CheckOutDate + '\'' +
                ", NoOfRooms='" + NoOfRooms + '\'' +
                ", childrenAge='" + childrenAge + '\'' +
                ", TravellingFor='" + TravellingFor + '\'' +
                '}';
    }
}
