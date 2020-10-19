package com.advyteam.weavin.steps;

import com.advyteam.weavin.modulesobjects.CommonObjects;
import com.advyteam.weavin.modulesobjects.ConnectObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.CredentialProvider;
import utilities.Utilitie;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonSteps {

    @Managed
    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
        CommonObjects commonObjects;
    ConnectObjects connectObjects;
    public static Map<String, WebElement> generalobjectsmap = new HashMap<>();
    Utilitie utilitie;


    @BeforeScenario
    public void start() throws IllegalAccessException {
        if (generalobjectsmap.isEmpty()) {
            generalobjectsmap.putAll(CommonObjects.objectsMapper());
            generalobjectsmap.putAll(ConnectObjects.objectsMapper());
        }
    }


    @Given("le navigateur est ouvert et la page d'acceuil est affichée")
    public void leNavigateurEstOuvertEtLaPageDAcceuilEstAffichée() {

        //        Starting browser on the default webdriver URL
       commonObjects.open();
        WebElement specialwait = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.visibilityOf(generalobjectsmap.get("login_button")));
        assertThat(generalobjectsmap.get("login_button").isDisplayed(), equalTo(true));
    }

    @And("l'utilisateur {string} est connecté")
    public void lUtilisateurEstConnecté(String username) throws JAXBException, InterruptedException {
        Actions actions = new Actions(driver);
        generalobjectsmap.get("champ_username").clear();
        generalobjectsmap.get("champ_username").sendKeys(username);
        generalobjectsmap.get("champ_password").clear();
        generalobjectsmap.get("champ_password").sendKeys(CredentialProvider.pwProvider(username));
//        utilitie.pause(driver, 1500);
        actions.pause(10000);
        actions.moveToElement(generalobjectsmap.get("login_button")).perform();
        generalobjectsmap.get("login_button").click();
    }

    @When("l utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String elementtoclick) {
        generalobjectsmap.get(elementtoclick).click();

    }

    @And("l utilisateur saisit {string} dans le champs {string}")
    public void lUtilisateurSaisitDansLeChamps(String text, String textbox) {
        generalobjectsmap.get(textbox).clear();
        generalobjectsmap.get(textbox).sendKeys(text);
    }

    @And("l utilisateur selectionne {string} dans la liste deroulante {string}")
    public void lUtilisateurSelectionneDansLaListeDeroulante(String option, String dropdownlist) {
    }


}
