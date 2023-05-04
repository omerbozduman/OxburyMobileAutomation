package com.bbc_news.step_definitions;

import com.bbc_news.driver.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        MobileDriver.setupDriver();
        System.out.println("Driver.getDriver() = " + MobileDriver.getDriver());
        MobileDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        MobileDriver.closeDriver();
    }
}
