package com.advyteam.weavin.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class setUp {

    private static final Logger logger = LoggerFactory.getLogger(setUp.class);
    public static Map<String, String> datastore = new HashMap<>();
    static Actions actions;
    @Managed
    WebDriver driver;

    @Before
    public static void startUp() {
        if (!datastore.isEmpty()) {
            datastore.clear();
        }
    }

    @After
    public void reportingfailuresScreenshots(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "failurescreenshot.png");
        }
    }
}