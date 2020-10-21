package com.advyteam.weavin.steps;

import com.advyteam.weavin.modulesobjects.CommonObjects;
import com.advyteam.weavin.modulesobjects.ConnectObjects;
import com.advyteam.weavin.runner.setUp;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.JavascriptExecutor;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonSteps {

    @Managed
    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
    CommonObjects commonObjects;
    ConnectObjects connectObjects;
    public static Map<String, WebElement> generalobjectsmap = new HashMap<>();
    static WebElement specialwait;
    Utilitie utilitie;
    static Actions actions;
    static JavascriptExecutor jsDriver;
    static NgWebDriver ngDriver;


    @BeforeScenario
    public void objectsMapper() throws IllegalAccessException {
        if (generalobjectsmap.isEmpty()) {
            generalobjectsmap.putAll(CommonObjects.objectsMapper());
            generalobjectsmap.putAll(ConnectObjects.objectsMapper());
        }
    }


    @Given("le navigateur est ouvert et la page d'acceuil est affichée")
    public void leNavigateurEstOuvertEtLaPageDAcceuilEstAffichée() throws IOException {
        logger.info("Ouverture de la plateforme " + Utilitie.readers().getProperty("webdriver.base.url"));
        // Starting browser on the default webdriver URL
        commonObjects.open();
        actions = new Actions(driver);
        jsDriver = (JavascriptExecutor) driver;
        ngDriver = new NgWebDriver(jsDriver);
        specialwait = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.visibilityOf(generalobjectsmap.get("login_button")));
        assertThat(generalobjectsmap.get("login_button").isDisplayed(), equalTo(true));
    }

    @And("l'utilisateur {string} est connecté")
    public void lUtilisateurEstConnecté(String username) throws JAXBException {
        logger.info("l'utilisateur " + username + " est en cours de connexion");
        generalobjectsmap.get("champ_username").clear();
        generalobjectsmap.get("champ_username").sendKeys(username);
        generalobjectsmap.get("champ_password").clear();
        generalobjectsmap.get("champ_password").sendKeys(CredentialProvider.pwProvider(username));
        actions.moveToElement(generalobjectsmap.get("login_button")).perform();
        generalobjectsmap.get("login_button").click();
    }

    @When("l utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String elementtoclick) {
        logger.info("l'utilisateur clique sur " + elementtoclick);
        specialwait = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(generalobjectsmap.get(elementtoclick)));
        generalobjectsmap.get(elementtoclick).click();
    }

    @And("l utilisateur saisit {string} dans le champs {string}")
    public void lUtilisateurSaisitDansLeChamps(String text, String textbox) {
        logger.info("l'utilisateur saisit " + text + " dans " + textbox);
        setUp.datastore.put(textbox, text);
        specialwait = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOf(generalobjectsmap.get(textbox)));
        generalobjectsmap.get(textbox).clear();
        generalobjectsmap.get(textbox).sendKeys(text);
    }

    @And("l utilisateur selectionne {string} dans la liste deroulante {string}")
    public void lUtilisateurSelectionneDansLaListeDeroulante(String option, String dropdownlist) {
        logger.info("l'utilisateur sélectionne l'option " + option + " dans la " + dropdownlist);
        setUp.datastore.put(dropdownlist, option);

    }

    @And("pause {int} secondes")
    public void pauseSecondes(int waittime) throws InterruptedException {
        logger.info("pause de " + waittime + " secondes");
        WebDriver driver = this.driver;
        synchronized (driver) {
            driver.wait(waittime * 1000);
        }
    }

    @Then("l utilisateur se deconnecte")
    public void lUtilisateurSeDeconnecte() throws IOException {
        driver.manage().deleteAllCookies();
        driver.get(Utilitie.readers().getProperty("webdriver.base.url"));
    }

    @And("l utilisateur selectionne {string} dans la liste {string}")
    public void lUtilisateurSelectionneDansLaListe(String option, String liste) {
        logger.info("l'utilisateur selectionne l'option " + option + " dans la " + liste);

    }

    @And("vérifier que le message {string} s affiche")
    public void vérifierQueLeMessageSAffiche(String message) {
        logger.info("Vérification de l'affichage du message " + message);
    }

    @And("l utilisateur modifie {string} dans le champs {string}")
    public void lUtilisateurModifieDansLeChamps(String nouveautext, String champtext) {
    }
}
