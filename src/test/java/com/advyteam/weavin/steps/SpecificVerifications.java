package com.advyteam.weavin.steps;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.advyteam.weavin.runner.setUp.datastore;
import static com.advyteam.weavin.steps.CommonSteps.generalobjectsmap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpecificVerifications {

    @Managed
    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(SpecificVerifications.class);

    @Then("vérifier le résultat de la connexion")
    public void vérifierLeRésultatDeLaConnexion() {
        logger.info("Vérification du résultat de la connexion");

        switch (datastore.get("champ_username")) {

            case "admin": {

                if (datastore.get("champ_password").equals(datastore.get("champ_username"))) {
                    WebElement specialwait = (new WebDriverWait(driver, 40)).until(
                            (ExpectedConditions
                                    .visibilityOf(generalobjectsmap.get("Acceuil_header"))));
                    assertThat(generalobjectsmap.get("Acceuil_header").isDisplayed(), equalTo(true));
                } else {
                    assertThat(generalobjectsmap.get("login_button").isDisplayed(), equalTo(true));
                    //TODO adapt this assertion when notification on wrong username or password is added

                }
                break;
            }

            case "ssss": {

                assertThat(generalobjectsmap.get("login_button").isDisplayed(), equalTo(true));
                //TODO adapt this assertion when notification on wrong username or password is added
                break;
            }

        }


    }

}
