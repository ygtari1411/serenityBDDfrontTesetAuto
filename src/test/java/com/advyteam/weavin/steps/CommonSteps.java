package com.advyteam.weavin.steps;

import com.advyteam.weavin.modulesobjects.CommonObjects;
import com.advyteam.weavin.modulesobjects.ConnectObjects;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
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
import java.util.List;
import java.util.Map;

import static com.advyteam.weavin.runner.setUp.datastore;
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
        datastore.put("champ_username", username);
        generalobjectsmap.get("champ_username").clear();
        generalobjectsmap.get("champ_username").sendKeys(username);
        generalobjectsmap.get("champ_password").clear();
        generalobjectsmap.get("champ_password").sendKeys(CredentialProvider.pwProvider(username));
        generalobjectsmap.get("login_button").click();
    }

    @When("l utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String elementtoclick) {
        logger.info("l'utilisateur clique sur " + elementtoclick);
        actions.moveToElement(generalobjectsmap.get(elementtoclick)).perform();
        specialwait = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(generalobjectsmap.get(elementtoclick)));
        generalobjectsmap.get(elementtoclick).click();
    }

    @And("l utilisateur saisit {string} dans le champs {string}")
    public void lUtilisateurSaisitDansLeChamps(String text, String textbox) {
        logger.info("l'utilisateur saisit " + text + " dans " + textbox);
        datastore.put(textbox, text);
        specialwait = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOf(generalobjectsmap.get(textbox)));
        generalobjectsmap.get(textbox).clear();
        generalobjectsmap.get(textbox).sendKeys(text);
    }

    @And("l utilisateur selectionne {string} dans la liste deroulante {string}")
    public void lUtilisateurSelectionneDansLaListeDeroulante(String option, String dropdownlist) throws InterruptedException {
        logger.info("l'utilisateur sélectionne l'option " + option + " dans la " + dropdownlist);
        datastore.put(dropdownlist, option);
        generalobjectsmap.get(dropdownlist).click();
        synchronized (driver) {
            driver.wait(1000);
        }
        for (WebElement element : driver.findElements(By.cssSelector(".ng-dropdown-panel .ng-option-label"))) {
            actions.moveToElement(element).perform();
            if (element.getText().equalsIgnoreCase(option)) {
                element.click();
            }
        }

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
    public void lUtilisateurSeDeconnecte() throws InterruptedException {
        logger.info("Déconexion de l'utilisateur " + datastore.get("champ_username"));
        actions.moveToElement(generalobjectsmap.get("Username_menu")).perform();
        synchronized (driver) {
            driver.wait(1000);
        }
        generalobjectsmap.get("logout_button").click();
    }

    @And("l utilisateur selectionne {string} dans la liste {string}")
    public void lUtilisateurSelectionneDansLaListe(String option, String liste) {
        logger.info("l'utilisateur selectionne l'option " + option + " dans la " + liste);

    }

    @And("l utilisateur modifie {string} dans le champs {string}")
    public void lUtilisateurModifieDansLeChamps(String nouveautext, String champtext) {
        logger.info("Saisie du nouveau texte : " + nouveautext + " dans le champs " + champtext);
        if (datastore.containsKey(champtext)) {
            datastore.replace(champtext, nouveautext);
        } else {
            datastore.put(champtext, nouveautext);
        }
        generalobjectsmap.get(champtext).clear();
        generalobjectsmap.get(champtext).sendKeys(nouveautext);
    }

    @When("l utilisateur effectue un hover sur {string}")
    public void lUtilisateurEffectueUnHoverSur(String element) {
        logger.info("l'utilisateur effectue un hover sur " + element);
        actions.moveToElement(generalobjectsmap.get(element)).perform();
    }

    //    Add "H_" in the start of the WebElement variable name to use the first condition: Hidden attribute remove
    //    Otherwise if the target for the upload is not hidden don't use the "H_" to use the second condition for the upload
    @And("l utilisateur upload {string} dans le champs {string}")
    public void lUtilisateurUploadDansLeChamps(String fichier, String champsupload) throws Exception {
        logger.info("uploading " + fichier + " dans le champs " + champsupload);

        switch (fichier) {
            case "image1":
                if (champsupload.startsWith("H_")) {
                    jsDriver.executeScript("document.getElementById('bg-cover-file').removeAttribute('hidden');");
                    driver.findElement(By.id("bg-cover-file")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg");
                    synchronized (driver) {
                        driver.wait(1000);
                    }
                    jsDriver.executeScript("arguments[0].click();", generalobjectsmap.get("Bouton_enregistrer_upload_image"));
                } else {
                    driver.findElement(By.id("shareBoxImages")).clear();
                    driver.findElement(By.id("shareBoxImages")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg");
                    synchronized (driver) {
                        driver.wait(1000);
                    }
                    List<WebElement> specialwait = (new WebDriverWait(driver, 30)).until(
                            (ExpectedConditions.numberOfElementsToBe(By.cssSelector(".data-sharing-container [class=ng-star-inserted]:last-child [role=progressbar]"), 0)));
                }
                break;
            case "image2":
                if (champsupload.startsWith("H_")) {
                    jsDriver.executeScript("document.getElementById('bg-cover-file').removeAttribute('hidden');");
                    driver.findElement(By.id("bg-cover-file")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest2.jpg");
                    synchronized (driver) {
                        driver.wait(1000);
                    }
                    jsDriver.executeScript("arguments[0].click();", generalobjectsmap.get("Bouton_enregistrer_upload_image"));
                } else {
                    driver.findElement(By.id("shareBoxImages")).clear();
                    driver.findElement(By.id("shareBoxImages")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest2.jpg");
                    synchronized (driver) {
                        driver.wait(1000);
                    }
                    List<WebElement> specialwait = (new WebDriverWait(driver, 30)).until(
                            (ExpectedConditions.numberOfElementsToBe(By.cssSelector(".data-sharing-container [class=ng-star-inserted]:last-child [role=progressbar]"), 0)));
                }
                break;
            case "vidéo":
                if (champsupload.startsWith("H_")) {
                    jsDriver.executeScript("document.getElementById('bg-cover-file').removeAttribute('hidden');");
                    driver.findElement(By.id("bg-cover-file")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest.mp4");
                } else {
                    driver.findElement(By.id("shareBoxImages")).clear();
                    driver.findElement(By.id("shareBoxImages")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest.mp4");
                    synchronized (driver) {
                        driver.wait(1000);
                    }
                    List<WebElement> specialwait = (new WebDriverWait(driver, 100)).until(
                            (ExpectedConditions.numberOfElementsToBe(By.cssSelector(".data-sharing-container [class=ng-star-inserted]:last-child [role=progressbar]"), 0)));
                }
                break;
            default:
                throw new Exception("Le fichier choisi pour l'upload est incorrect!");
        }
    }

    @Then("vérifier que le message {string} s'affiche dans la notification")
    public void vérifierQueLeMessageSAfficheDansLaNotification(String textnotif) {
        logger.info("vérification de l'affichage du message " + textnotif);

        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Message_resultat_action"))));

        assertThat(generalobjectsmap.get("Message_resultat_action").getText().equals(textnotif), equalTo(true));

    }
}
