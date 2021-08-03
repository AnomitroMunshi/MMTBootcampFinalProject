package Testcases;

import DriverManager.DriverFactory;
import FileReader.ConfigReader;
import FileReader.JSONReader;
import PageFlow.GoToLandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;


public class BaseTest {

	Logger logger= LogManager.getLogger(BaseTest.class);

	@BeforeSuite
	public void setPrerequisites() {
		// read all config file
		logger.info("Reading all config file");
		new ConfigReader();
		logger.info("Config file read & loaded");

		// initialize log properties
		logger.info("Initializing log properties");
		PropertyConfigurator.configure("src/main/resources/Properties/log4j.properties");
		logger.info("Log properties initialized");
	}

	@BeforeTest
	public void browserOpen() {
		DriverFactory.initDriver();
		logger.info("Browser opened");
		System.out.println("Driver opened on Thread ID::" + Thread.currentThread().getId());
		GoToLandingPage.go();

	}

	@AfterTest
	public void closeBrowser() {
		//DriverFactory.getCurrentDriver().quit();
	}
}
