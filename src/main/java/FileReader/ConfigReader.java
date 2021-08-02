package FileReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Logger logger= LogManager.getLogger(ConfigReader.class);

	private static Properties properties = new Properties();
	private String configFilePath = "src/main/resources/Properties/config.properties";
	private String envFilePath = "src/main/resources/Enviornments/%s.properties";

	public ConfigReader() {
		logger.info("Trying to read property file");
		readProperties(configFilePath);
		logger.info("Property file reading done!");

		String environmentToRun = getProperty("environment");
		logger.info("Selecting "+environmentToRun+" enviornment to run the tests!");
		readProperties(String.format(envFilePath, environmentToRun));
	}

	private void readProperties(String filePath) {
		try {

			FileReader reader = new FileReader(new File(filePath));
			properties.load(reader);
			logger.info("Property file loaded!");

		} catch (FileNotFoundException e) {
			logger.info("File Not found !");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
