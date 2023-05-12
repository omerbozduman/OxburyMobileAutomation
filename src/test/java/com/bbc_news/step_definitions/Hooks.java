package com.bbc_news.step_definitions;

import com.bbc_news.driver.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        MobileDriver.setupDriver(scenario);
        System.out.println("Driver.getDriver() = " + MobileDriver.getDriver());
        MobileDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

       // ((JavascriptExecutor) MobileDriver.getDriver()).executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
        MobileDriver.closeDriver();
    }
}
