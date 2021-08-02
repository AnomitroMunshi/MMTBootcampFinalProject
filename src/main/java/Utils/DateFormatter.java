package Utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static void main(String[] args) throws ParseException {
        String s;
        Format formatter;
       /* Date date = new Date();
        System.out.println(date);*/
        
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);

        formatter = new SimpleDateFormat("E, dd MMM yyyy");
        s = formatter.format(date1);
        System.out.println(s);
    }
}
