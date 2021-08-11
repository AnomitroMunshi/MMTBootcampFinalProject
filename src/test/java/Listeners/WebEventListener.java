package Listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

    Logger logger= LogManager.getLogger(WebEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        logger.info("Accepting alert");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        logger.info("Alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        logger.info("Dismissing alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        logger.info("Alert Dismissed");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Navigating to :: "+url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigated to :: "+url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("trying to Click on :: "+element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicked on :: "+element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        logger.info("Trying to switch to window :: "+windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        logger.info("Swtched to window :: "+windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.info("Exception occured ::"+throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        logger.info("Trying to capture Screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        logger.info("Captured Screenshot!! Check output folder");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        logger.info("Trying to get Text on "+element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        logger.info("Text found on "+element+" :: "+text);
    }
}
