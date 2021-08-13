package Utils;

import org.openqa.selenium.By;

public class DynamicXpath {
	
	//creates dynamic xpath by replacing %replacable% with required data
	public static By get(String xpath,String data)
	{
		String rawXpath=xpath.replaceAll("%replacable%", data);
		System.out.println("From DynamicXpath class="+rawXpath);
		return By.xpath(rawXpath);
	}

}
