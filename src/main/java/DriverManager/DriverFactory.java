package DriverManager;

import DriverManager.BrowserType.ChromeDriverManager;
import DriverManager.BrowserType.FirefoxDriverManager;
import EventListener.WebEventListener;
import FileReader.ConfigReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class DriverFactory {

   static Logger logger= LogManager.getLogger(DriverFactory.class);

    public static ThreadLocal<WebDriver> thDriver=new ThreadLocal<WebDriver>();

    public static void initDriver(){
        WebDriver driver=null;
        String browserType= ConfigReader.getProperty("browser");
        logger.info("BrowserType selected = "+browserType);
        switch (BrowserTypeConstants.valueOf(browserType.toUpperCase())){
            case CHROME:
                driver=new ChromeDriverManager().getDriver();
                break;
            case FIREFOX:
                driver=new FirefoxDriverManager().getDriver();
                break;
            default:
                throw new IllegalStateException("Unsupported BrowserType Provided!");
        }

        EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(driver);
        WebEventListener eventListener=new WebEventListener();

        eventFiringWebDriver.register(eventListener);

        thDriver.set(eventFiringWebDriver);
        logger.info("Browser set into threadlocal!");
        getCurrentDriver().manage().window().maximize();


    }

    public static WebDriver getCurrentDriver(){
        logger.info("Getting current driver");
        return thDriver.get();
    }

}
