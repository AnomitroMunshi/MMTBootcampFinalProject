package Utils;


import DriverManager.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class Screenshot {
    public static void capture(String imageName) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File screenshot = ((TakesScreenshot) DriverFactory.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(
                    "output/"+imageName+timestamp.getTime()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
