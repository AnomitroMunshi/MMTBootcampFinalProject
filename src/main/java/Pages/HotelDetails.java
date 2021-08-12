package Pages;

import Utils.DynamicXpath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HotelDetails extends BasePage{

    Logger logger = LogManager.getLogger(HotelDetails.class);


    //pageLocators
    By ROOMTAB=By.xpath("//a[contains(@id,'hotel_rooms')]");
    By RECOMMENDATIONBOX=By.xpath("//section[@id='RoomType']//div[contains(@class,'comboWrap')]");
    By RECOMMENDEDROOMTITLES=By.xpath("//section[@id='RoomType']//div[contains(@class,'comboTitle')]");



    //Dynamic xpath
    String SPECIFICRECOMMENDBOX="//section[@id='RoomType']/div/div[%replacable%]";
    String GUESTCOUNTINRECOMMBOX="//section[@id='RoomType']/div/div[%replacable%]//div[contains(@class,'roomRow')]//p[2]";


    //page functions

    public boolean checkRecommendTitle(String adultsCount,String childernCount){
        String title="";
        int flag=0;
        doActionsMoveToElementAndClick(ROOMTAB);
        List<WebElement> recommendTitleList=getElements(RECOMMENDEDROOMTITLES);
        logger.info("No.of recommendation : "+recommendTitleList.size());
        logger.info("Traversing recommended Title List");
        for(WebElement e:recommendTitleList){
            title=e.getText();
            logger.info("Title:"+title);
            if(Integer.parseInt(childernCount)>0) {
                if (title.equalsIgnoreCase("Recommended for " + adultsCount + " Adults & " + childernCount + " Children"))
                    logger.info("Title matched, increasing flag counter by 1 . Current flagCtr value ="+flag++);
            }
            else {
                if (title.equalsIgnoreCase("Recommended for " + adultsCount + " Adults"))
                    logger.info("Title matched, increasing flag counter by 1 . Current flagCtr value ="+flag++);
            }
        }
        logger.info("Value of flag count = "+flag);
        return (flag==recommendTitleList.size());
    }

    public boolean calculateTotalGuests(String adultsCount,String childernCount){
        int totalAdult=0;
        int totalChildren=0;
        int flag=0;
        Map<String,Integer> guestMap=new HashMap<>();
        List<WebElement> recommendationBoxList=getElements(RECOMMENDATIONBOX);
        logger.info("No.of recommendations ="+recommendationBoxList.size());

        for(int i=0;i<recommendationBoxList.size();i++){
            WebElement e=getElement(DynamicXpath.get(SPECIFICRECOMMENDBOX,String.valueOf(i+1)));
            guestMap=findTotalCountOfRecommnedBox(i+1);
            totalAdult=guestMap.get("Adults");
            totalChildren=guestMap.get("Children");
            if(totalAdult==Integer.parseInt(adultsCount) && totalChildren==Integer.parseInt(childernCount))
                flag++;
        }
        return (flag==recommendationBoxList.size());
    }


    private Map<String,Integer> findTotalCountOfRecommnedBox(int recommendBoxIndex){

        Map<String,Integer> totalMap=new HashMap<>();
        List<WebElement> roomsList=getElements(DynamicXpath.get(GUESTCOUNTINRECOMMBOX,String.valueOf(recommendBoxIndex)));
        logger.info("No.of rooms in this Recommendation box= "+roomsList.size());
        int roomCount=0;
        for(WebElement e:roomsList){
            String guests=e.getText();
            logger.info("Guests in Room"+roomCount+1+" is = "+guests);
            //converting guests to map
            Map<String,Integer> guestMap=addTotalAdultsChildren(guests);
            System.out.println(guestMap);//Adults=2 Children=1

            for (Map.Entry<String,Integer> entry : guestMap.entrySet()){
                if(totalMap.containsKey(entry.getKey())){
                    totalMap.put(entry.getKey(),totalMap.get(entry.getKey())+entry.getValue());
                }else
                    totalMap.put(entry.getKey(),entry.getValue());
            }

        }
        System.out.println(totalMap);
        return totalMap;
    }

    private Map<String,Integer> addTotalAdultsChildren(String countAdultCildren){ //2 Adults + 1 Child
        Map<String,Integer> adultchildrenMap=new HashMap<>();
        int[] ageArray = new int[2];
        logger.info("Extrating adult and children");
        int ageArrayindex=0;
        String[] adultChildAgeinArray=countAdultCildren.split(" ");
        for(int i=0;i<adultChildAgeinArray.length;i++){
            //System.out.println("adultChildAgeinArray["+i+"]="+adultChildAgeinArray[i]);
            if(adultChildAgeinArray[i].charAt(0)>47 && adultChildAgeinArray[i].charAt(0)<59){
                ageArray[ageArrayindex]=Integer.parseInt(adultChildAgeinArray[i]);
                ageArrayindex++;
            }
        }
        if(ageArray.length>1){
            adultchildrenMap.put("Adults",ageArray[0]);
            adultchildrenMap.put("Children",ageArray[1]);
        }
        else {
            adultchildrenMap.put("Adults",ageArray[0]);
            adultchildrenMap.put("Children",0);
        }

        //System.out.println("AdultChildren count Map="+adultchildrenMap);
        return adultchildrenMap;
    }

}