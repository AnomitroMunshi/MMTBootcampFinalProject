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

   /* public static void main(String[] args) throws ParseException {
        formatDate("03/12/2021");
    }*/
}
