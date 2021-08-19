package Utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DateFormatter {
    public static String formatDate(String dateString) throws ParseException {
        String formattedDate;
        Format formatter;

        Date newdate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        //System.out.println(dateString+"->"+newdate);

        formatter = new SimpleDateFormat("E MMM dd yyyy");
        formattedDate = formatter.format(newdate);
        System.out.println(formattedDate);

        return formattedDate;
    }
    public static String formatDateWithComma(String dateString) throws ParseException {
        String formattedDate;
        Format formatter;

        Date newdate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        formatter = new SimpleDateFormat("E, dd MMM yyyy");
        formattedDate = formatter.format(newdate);
        System.out.println(formattedDate);

        return formattedDate;
    }

    public static String formatDateForReviewPage(String dateString) throws ParseException {
        String formattedDate;
        Format formatter;

        Date newdate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        formatter = new SimpleDateFormat("dd MMM yyyy");
        formattedDate = formatter.format(newdate);
        System.out.println(formattedDate);

        return formattedDate;
    }


    public static String formatDateForCheckOutPage(String dateString) throws ParseException {
        String formattedDate;
        Format formatter;

        Date newdate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        formatter = new SimpleDateFormat("E, dd MMM yy");
        formattedDate = formatter.format(newdate);

        String[] dateFormat=formattedDate.split(" ");
        String newDate=dateFormat[0]+" "+dateFormat[1]+" "+dateFormat[2]+"'"+dateFormat[3];
        System.out.println(newDate);
        return newDate;
    }


    /*public static void main(String[] args) throws ParseException {
        formatDateForCheckOutPage("25/09/2021");
        //Sat, 25 Sep'21
    }*/
}
