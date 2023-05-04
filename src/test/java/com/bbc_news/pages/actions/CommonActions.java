package com.bbc_news.pages.actions;

import com.bbc_news.driver.MobileDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CommonActions {

    protected AppiumDriver driver;
    public CommonActions(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.getDriver()), this);
        driver = MobileDriver.getDriver();
    }

    public void clickButton(By locator){
        WaitFor(20).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getTextOfElement(By locator){
        WaitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public List<WebElement> getListOfElement(By locator){
        WaitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public List<String> getListOfText(By locator){
        WaitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> listOfElement = driver.findElements(locator);
        List<String> listOfText = new ArrayList<>();
        for (WebElement element : listOfElement) {
            listOfText.add(element.getText());
        }
        return listOfText;
    }

    public void enterTextToField(By locator , String text){
        WaitFor(20).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public WebElement getElement(By locator){
        WaitFor(20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public WebElement scrollDownToElementByAndroidUIAutomator(String elementText){
        return MobileDriver.getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"));
    }


    public WebDriverWait WaitFor(int seconds){
        return new WebDriverWait(driver , Duration.ofSeconds(seconds));
    }

    public void scroll(String direction){
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.getWidth()/0.80);
        int endX = (int) (size.getWidth()/0.10);
        int startY = size.getHeight()/2;
        int endY = (int) (size.getHeight()*0.25);

        switch (direction.toLowerCase()){
            case "up" :
                swipe(startX, endY , endX, startY , Duration.ofMillis(500));
                break;
            case "down" :
                swipe(startX, startY , endX, startY , Duration.ofMillis(500));
                break;
            case "left" :
                swipe(startY, startX , endY, endX , Duration.ofMillis(500));
                break;
            case "right" :
                swipe(endY, startX , startY, endX , Duration.ofMillis(500));
                break;
        }
    }

    public void swipe(int startX , int startY, int endX, int endY , Duration duration){
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH , "finger");
        Sequence swipe = new Sequence(input , 1);
                swipe.addAction(input.createPointerMove(Duration.ZERO ,PointerInput.Origin.viewport(),startX , startY));
                swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(input.createPointerMove(duration ,PointerInput.Origin.viewport(),endX , endY));
                swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

    }

    public WebElement  scrollLeft(String text){
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\""+text+"\"))"));

    }

}
