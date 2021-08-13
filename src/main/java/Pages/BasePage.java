package Pages;

import DriverManager.DriverFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage() {
        this.driver = DriverFactory.getCurrentDriver();
        wait = new WebDriverWait(this.driver, 5);
    }

    public BasePage(int waitTime) {
        this();
        wait = new WebDriverWait(this.driver, waitTime);
    }

    protected void openPage(String url) {
        logger.info("Navigating to Page:: " + url);
        driver.get(url);
    }

    protected String getTitle(){
        return driver.getTitle();
    }

    protected void fillText(By by, String value) {
        WebElement ele = waitForElementToBePresent(by);
        ele.clear();
        ele.sendKeys(value);
    }

    protected void fillTextwithdownEnter(By by, String value){
        WebElement ele=waitForElementToBePresent(by);
        ele.sendKeys(value);
        String act= Keys.chord(Keys.ARROW_DOWN,Keys.ENTER);
        ele.sendKeys(act);
    }

    protected void click(By by) {
        waitForElementToBePresent(by).click();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getText(By by) {
        return waitForElementToBePresent(by).getText();
    }

    protected  WebElement getElement(By by){
        return waitForElementToBePresent(by);
    }

    private WebElement waitForElementToBePresent(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitForElementVisibleWithCustomTimeOut(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected boolean waitForUrlWithCustomTimeOut(int timeOut, String url) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.urlContains(url));
    }


    protected WebElement waitForElementToBeClickableWithCustomTimeOut(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    private WebElement waitForElementToBeClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }


    /*==== WINDOW HANDLES====*/
    public void switchToWindow(String windowId) {
        driver.switchTo().window(windowId);
    }
    public String getCurrentWindow(){
       return driver.getWindowHandle();
    }
    public Set<String> getAllWindows(){
       return driver.getWindowHandles();
    }


    /*======Dropdown=====*/

    protected void doSelectDropDownByVisibleText(By by, String visibletext) {
        Select select = new Select(waitForElementToBePresent(by));
        select.selectByVisibleText(visibletext);
    }



    /*=====Action classes====*/

    public void doActionsMoveToElement(By by) {
        Actions act = new Actions(driver);
        act.moveToElement(waitForElementToBeClickable(by)).perform();
    }

    public void doActionsMoveToElementAndClick(By by) {
        doActionsMoveToElement(by);
        waitForElementToBeClickable(by).click();

    }

    public void doActionsMoveByOffset(){
        Actions act = new Actions(driver);
        act.moveByOffset(100,300).click().perform();
    }

    public void doActionsDragAndDrop(By by,int offset){
        Actions act = new Actions(driver);
        act.dragAndDropBy(waitForElementToBePresent(by),offset,0).perform();
    }




    /*=====Javascript Executors=====*/

    protected void waitForPageLoad() {
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }


    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public void scrollIntoView(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", by);
    }


    public void scrollIntoViewByPixels(String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    public void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickElementByJS(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", by);
    }


    public String getPageInnerText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.documentElement.innerText;").toString();
    }



    /*====Refresh page====*/

    public void refreshBrowser(){
        driver.navigate().refresh();
    }

}
