package com.bbc_news.driver;

import com.bbc_news.utilities.ConfigurationReader;
import com.bbc_news.utilities.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import jdk.jfr.Timespan;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Time;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class MobileDriver {

    private static AppiumDriver driver;


    public static void setupDriver(Scenario scenario){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        String platform= System.getProperty("platform");
        if(platform==null){
            platform= ConfigurationReader.get("platform");
            System.out.println("platform = " + platform);
            System.out.println("deviceName = " + ConfigurationReader.get("deviceName"));
        }
        System.out.println("MobileUtils.GetAppFilePathAddress() = " + MobileUtils.GetAppFilePathAddress());
        //String appPath = "/Users/omerbozduman/IdeaProjects/OxburyTask/src/test/java/com/bbc_news/AppFiles/bbc.mobile.news.uk_6.2.41-6024105_minAPI21(arm64-v8a,armeabi,armeabi-v7a,mips,mips64,x86,x86_64)(nodpi)_apkmirror.com.apk";
        String appPath = MobileUtils.GetAppFilePathAddress();
        platform=platform.toLowerCase();
        switch (platform) {
            case "android" -> {
                System.out.println(" Test running on local Android devices..........");
                desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(PLATFORM_VERSION, ConfigurationReader.get("version"));
                desiredCapabilities.setCapability(DEVICE_NAME, ConfigurationReader.get("deviceName"));
                desiredCapabilities.setCapability(AUTOMATION_NAME, ConfigurationReader.get("automationName"));
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                //desiredCapabilities.setCapability("fullReset", true);
                //desiredCapabilities.setCapability("appPackage", ConfigurationReader.get("appPackage"));
                //desiredCapabilities.setCapability("appActivity", ConfigurationReader.get("appActivity"));
                desiredCapabilities.setCapability(APP, appPath);
                try {
                    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "android_sauce_labs" -> {
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(DEVICE_NAME, "Samsung_Galaxy_S9_free");
                desiredCapabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
                desiredCapabilities.setCapability("appium:app" ,"storage:aed2c210-c400-4b72-98e5-a3c2a6e876c0");
                //desiredCapabilities.setCapability("adbExecTimeout", "20000");
                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("appiumVersion", "1.22.0");
               // sauceOptions.setCapability("phoneOnly", true);
                sauceOptions.setCapability("name", scenario.getName());
                desiredCapabilities.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new AndroidDriver(new URL("https://oauth-bozdumanomer-63bef:0ca50448-27de-4f4b-a786-77296f04f258@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
                            desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "ios" -> {
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platform", "iOS");
                desiredCapabilities.setCapability("platformVersion", "12.0");
                desiredCapabilities.setCapability("deviceName", "iPhone 8");
                desiredCapabilities.setCapability("automationName", "XCUITest");
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                desiredCapabilities.setCapability(APP, appPath);
                try {
                    driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "ios_sauce_labs" -> {
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platform", "iOS");
                desiredCapabilities.setCapability("platformVersion", "12.0");
                desiredCapabilities.setCapability("deviceName", "iPhone 8");
                desiredCapabilities.setCapability("automationName", "XCUITest");
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                desiredCapabilities.setCapability("testobject_api_key", " unknow.....");
                try {
                    driver = new AppiumDriver(new URL("https:saucelabs testobject url"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static AppiumDriver getDriver(){
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }

    }
}
