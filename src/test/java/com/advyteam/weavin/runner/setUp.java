package com.advyteam.weavin.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Utilitie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.advyteam.weavin.steps.CommonSteps.generalobjectsmap;


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
    public void ArretScenarioTest(Scenario scenario) throws InterruptedException, IOException {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "failurescreenshot.png");
        }
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        if (driver.findElements(By.cssSelector("div.author-title")).size() != 0) {
            logger.info("Déconexion de l'utilisateur " + datastore.get("champ_username"));
            actions = new Actions(driver);
            actions.moveToElement(generalobjectsmap.get("Username_menu")).perform();
            synchronized (driver) {
                driver.wait(3000);
            }
            generalobjectsmap.get("logout_button").click();
        }

        if (!datastore.isEmpty()) {
            datastore.clear();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(Utilitie.readers().getProperty("webdriver.timeouts.implicitlywait")), TimeUnit.MILLISECONDS);
    }
}