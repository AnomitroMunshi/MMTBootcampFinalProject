package FileReader;

import BO.TestDatasBO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONReader {
    private static String jsonFilePath="src/test/resources/testdata.json";
    public static TestDatasBO readJOSN() {
       return read(jsonFilePath);
    }

    private static TestDatasBO read(String filepath) {
        JSONObject jsonObject;
        TestDatasBO testDatasBO = new TestDatasBO();
        FileReader reader = null;
        List<String> childrenAge = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            reader=new FileReader(filepath);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            jsonObject = (JSONObject) parser.parse(reader);
            String PageMenu = (String) jsonObject.get("PageMenu");
            testDatasBO.setPageMenu(PageMenu);

            String Location = (String) jsonObject.get("Location");
            testDatasBO.setLocation(Location);

            String CheckInDate = (String) jsonObject.get("CheckInDate");
            testDatasBO.setCheckInDate(CheckInDate);

            String CheckOutDate = (String) jsonObject.get("CheckOutDate");
            testDatasBO.setCheckOutDate(CheckOutDate);

            String NoOfRooms = (String) jsonObject.get("NoOfRooms");
            testDatasBO.setNoOfRooms(NoOfRooms);

            String NoOfAdults = (String) jsonObject.get("NoOfAdults");
            testDatasBO.setNoOfAdults(NoOfAdults);

            String NoOfChildren = (String) jsonObject.get("NoOfChildren");
            testDatasBO.setNoOfChildren(NoOfChildren);


            String TravellingFor = (String) jsonObject.get("TravellingFor");
            testDatasBO.setTravellingFor(TravellingFor);


            if(Integer.parseInt(NoOfChildren)>0) {
                JSONArray jsonArray = (JSONArray) jsonObject.get("ChidrenAge");
                Iterator<String> iterator = jsonArray.iterator();
                while (iterator.hasNext()) {
                    String age=iterator.next();
                    System.out.println("Age:"+age);
                    childrenAge.add(age);
                }
                System.out.println(childrenAge.size());
                testDatasBO.setChidrenAge(childrenAge);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return testDatasBO;
    }

}
