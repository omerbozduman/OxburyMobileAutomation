package com.bbc_news.pages.actions;

import com.bbc_news.driver.MobileDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CommonActions {

    protected AppiumDriver driver;
    public CommonActions(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.getDriver()), this);
        driver = MobileDriver.getDriver();
    }

    public void clickButton(By locator){
        waitFor(20).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getTextOfElement(By locator){
        waitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public List<WebElement> getListOfElement(By locator){
        waitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public List<String> getListOfText(By locator){
        waitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> listOfElement = driver.findElements(locator);
        List<String> listOfText = new ArrayList<>();
        for (WebElement element : listOfElement) {
            listOfText.add(element.getText());
        }
        return listOfText;
    }

    public void enterTextToField(By locator , String text){
        waitFor(20).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public WebElement getElement(By locator){
        waitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public WebElement scrollDownToElementByAndroidUIAutomator(String elementText){
        return MobileDriver.getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"));
    }


    public WebDriverWait waitFor(int seconds){
        return new WebDriverWait(driver , Duration.ofSeconds(seconds));
    }

    public static void waitForWhile(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(String direction ){
        Dimension size = driver.manage().window().getSize();
        int startX;
        int endX ;
        int startY ;
        int endY ;

        switch (direction.toLowerCase()) {
            case "down" -> {
                startX = (int) (size.getWidth() * 0.5);
                startY = (int) (size.getHeight() * 0.80);
                endY = (int) (size.getHeight() * 0.20);
                swipe(startX, startY, startX, endY);
            }
            case "up" -> {
                startX = (int) (size.getWidth() * 0.5);
                startY = (int) (size.getHeight() * 0.20);
                endY = (int) (size.getHeight() * 0.80);
                swipe(startX, startY, startX, endY);
            }
            case "left" -> {
                startX = (int) (size.getWidth() * 0.90);
                endX = (int) (size.getWidth() * 0.10);
                startY = (int) (size.getHeight() * 0.50);
                swipe(startX, startY, endX, startY);
            }
            case "right" -> {
                startX = (int) (size.getWidth() * 0.90);
                endX = (int) (size.getWidth() * 0.10);
                startY = (int) (size.getHeight() * 0.50);
                swipe(endX, startY, startX, startY);
            }
        }
    }

    public void scrollWithElementHeight(String direction , int elementHeight){
        Dimension size = driver.manage().window().getSize();
        int startX;
        int endX ;
        int startY ;
        int endY ;

        switch (direction.toLowerCase()) {
            case "down" -> {
                startX = (int) (size.getWidth() * 0.5);
                startY = (int) (size.getHeight() * 0.80);
                endY = (int) (size.getHeight() * 0.10);
                swipe(startX, startY, startX, endY);
            }
            case "up" -> {
                startX = (int) (size.getWidth() * 0.5);
                startY = (int) (size.getHeight() * 0.10);
                endY = (int) (size.getHeight() * 0.80);
                swipe(startX, startY, startX, endY);
            }
            case "left" -> {
                startX = (int) (size.getWidth() * 0.80);
                endX = (int) (size.getWidth() * 0.20);
                startY = elementHeight;
                swipe(startX, startY, endX, startY);
            }
            case "right" -> {
                startX = (int) (size.getWidth() * 0.90);
                endX = (int) (size.getWidth() * 0.10);
                startY = elementHeight;
                swipe(startX, startY, endX, startY);
            }
        }
    }


    public void swipe(int startX , int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(100)));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));

    }


}
