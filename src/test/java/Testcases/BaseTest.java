package Testcases;

import BO.TestDatasBO;
import DriverManager.DriverFactory;
import FileReader.ConfigReader;
import FileReader.DataReader;
import PageFlow.GoToLandingPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;


public class BaseTest {

	Logger logger= LogManager.getLogger(BaseTest.class);
	TestDatasBO testDatasBO =new TestDatasBO();

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

		//initialzing Driver
		DriverFactory.initDriver();
		logger.info("Browser opened");
		System.out.println("Driver opened on Thread ID::" + Thread.currentThread().getId());
		logger.info("Traversing to landing page");
		GoToLandingPage.go();

	}

	@BeforeClass
	public void getDatas(){
		//Mapping testdatas to BO class
		logger.info("Mapping datas from properties to BO class");
		DataReader.getValuesFromFile(testDatasBO);
	}

	@AfterTest
	public void closeBrowser() {
		//quitting the current Driver
		DriverFactory.getCurrentDriver().quit();
	}
}
