package BO;

import com.github.javafaker.Faker;

public class Constants {

    static Faker faker=new Faker();

    public static final String pageURL="https://www.makemytrip.com/";
    public static final String WORK="Work";
    public static final String LEISURE="Leisure";
    public static final String LOCATION="LOCATION";
    public static final String CHECKINDATE="CHECKINDATE";
    public static final String CHECKOUTDATE="CHECKOUTDATE";
    public static final String GUESTS="GUESTS";
    public static final int MINSLIDER=25;
    public static final int MAXSLIDER=-35;
    public static final int CUSTOMTIMEOUT_10SEC=10;
    public static final int CUSTOMTIMEOUT_15SEC=15;
    public static final int CUSTOMTIMEOUT_20SEC=20;
    public static final String RATINGFILTER="4 & above";


    public static String hotelName="";
    public static int totatHotelCost=0;
    public static int totalRoomsBooked=0;


    public static String fakeFirstName=faker.name().firstName();
    public static String fakeLirstName=faker.name().lastName();
    public static String fakePhn=String.valueOf(faker.number().numberBetween(60000,99999))+String.valueOf(faker.number().numberBetween(60000,99999));
    public static String fakeEmail=faker.internet().emailAddress();



}
