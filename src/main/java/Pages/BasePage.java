package Pages;

import DriverManager.DriverFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    protected void fillText(By by, String value) {
        WebElement ele = waitForElementToBePresent(by);
        ele.clear();
        ele.sendKeys(value);
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

    protected List<String> getElementsTextList(By by) {
        List<String> eleTextList = new ArrayList<String>();

        List<WebElement> eleList = waitForAllElementsToBeVisible(by);
        for (WebElement e : eleList) {
            if (!e.getText().isEmpty()) {
                eleTextList.add(e.getText());
            }
        }

        return eleTextList;
    }

    protected  WebElement getElement(By by){
        return waitForElementToBePresent(by);
    }

    private WebElement waitForElementToBePresent(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private WebElement waitForElementToBeClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private List<WebElement> waitForAllElementsToBeVisible(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) by));
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

    public void drawBorder(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", by);
    }


    /*=====Javascript Utility=====*/

    public void flash(WebElement element) {
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 15; i++) {
            changeColor("rgb(0,200,0)", element);// 1
            changeColor(bgcolor, element);// 2
        }
    }

    private void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }


}
