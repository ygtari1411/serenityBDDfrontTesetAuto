package com.advyteam.weavin.steps;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Utilitie;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

    @Then("vérifier l'affichage correct de tous les sous-menu")
    public void vérifierLAffichageCorrectDeTousLesSousMenu() throws InterruptedException {
        logger.info("Vérification de la présence de tous les sous-menu");
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-close-icon.left-menu-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-home-icon.left-menu-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-user-menu-male")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-about")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-idea-2")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-calendar-icon.left-menu-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-news")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(1) .left-menu-title")).getText().equals("Fermer le menu"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(2) .left-menu-title")).getText().equals("Accueil"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(3) .left-menu-title")).getText().equals("Annuaire"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(4) .left-menu-title")).getText().equals("Know'store"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(5) .left-menu-title")).getText().equals("Idéation"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(6) .left-menu-title")).getText().equals("Calendrier & événements"), equalTo(true));
        assertThat(driver.findElement(By.cssSelector("li:nth-child(7) .left-menu-title")).getText().equals("News"), equalTo(true));
    }

    @Then("vérifer la fermeture du sous menu")
    public void vériferLaFermetureDuSousMenu() throws IOException {
        logger.info("Vérification de la fermeture du menu");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-close-icon.left-menu-icon")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-home-icon.left-menu-icon")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-user-menu-male")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-about")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-idea-2")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-calendar-icon.left-menu-icon")).isEmpty(), equalTo(true));
        assertThat(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-news")).isEmpty(), equalTo(true));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(Utilitie.readers().getProperty("webdriver.timeouts.implicitlywait")), TimeUnit.MILLISECONDS);
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-home-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-happy-faces-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .icons8-about")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .icons8-idea-2")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-calendar-icon")).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .icons8-news")).isDisplayed(), equalTo(true));
    }

    @Then("Vérifier que le menu s'affiche")
    public void vérifierQueLeMenuSAffiche() {
        logger.info("Vérification de l'affichage correct du menu des paramètres du compte");
        assertThat(driver.findElement(By.cssSelector(".account-settings")).isDisplayed(), equalTo(true));
    }

    @Then("vérifier que l'utilisateur est deconnecté")
    public void vérifierQueLUtilisateurEstDeconnecté() {
        logger.info("Vérification de la déconnexion correct de l'utilisateur");
        assertThat(generalobjectsmap.get("login_button").isDisplayed(), equalTo(true));
        assertThat(generalobjectsmap.get("champ_username").isDisplayed(), equalTo(true));
        assertThat(generalobjectsmap.get("champ_password").isDisplayed(), equalTo(true));
    }

    @Then("vérifier que le mot de passe est masqué")
    public void vérifierQueLeMotDePasseEstMasqué() {
        logger.info("Vérification que le mot de passe est masqué");
        assertThat(generalobjectsmap.get("champ_password").getAttribute("type").equals("password"),equalTo(true));
    }

    @Then("vérifier que le mot de passe est affiché")
    public void vérifierQueLeMotDePasseEstAffiché() {
        logger.info("Vérification que le mot de passe est affiché");
        assertThat(generalobjectsmap.get("champ_password").getAttribute("type").equals("text"),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page d'accueil")
    public void vérifierQueLaPageAffichéeEstLaPageDAccueil() {
        logger.info("Vérification que la page affichée est la page d'accueil");
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal"),equalTo(true));
        assertThat(generalobjectsmap.get("Widget_flux_activite").isDisplayed(),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page annuaire")
    public void vérifierQueLaPageAffichéeEstLaPageAnnuaire() {
        logger.info("Vérification que la page affichée est la page annuaire");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/collaborators")));
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal/collaborators"),equalTo(true));
        assertThat(generalobjectsmap.get("Balise_filtre_annuaire").isDisplayed(),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page knows store")
    public void vérifierQueLaPageAffichéeEstLaPageKnowsStore() {
        logger.info("vérification que la page affichée est la page know's store");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/usefulinformation/list")));
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal/usefulinformation/list"),equalTo(true));
        assertThat(generalobjectsmap.get("titre_page_knowstore").getText().equals("Know'store"),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page idéation")
    public void vérifierQueLaPageAffichéeEstLaPageIdéation() {
        logger.info("vérification que la page affichée est la page idéation");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/ideations/list")));
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal/ideations/list"),equalTo(true));
        assertThat(generalobjectsmap.get("titre_page_ideation").getText().equals("Idéation"),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page calendrier et évenement")
    public void vérifierQueLaPageAffichéeEstLaPageCalendrierEtÉvenement() {
        logger.info("vérification que la page affichée est la page calendrier et évenement");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/agenda")));
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal/agenda"),equalTo(true));
        assertThat(generalobjectsmap.get("titre_page_calendrier").getText().equals("Calendrier et événements"),equalTo(true));
    }

    @Then("vérifier que la page affichée est la page news")
    public void vérifierQueLaPageAffichéeEstLaPageNews() {
        logger.info("vérification que la page affichée est la page news");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/news")));
        assertThat(driver.getCurrentUrl().equals("https://weavin-qa.accretio.io/portal/news"),equalTo(true));
        assertThat(generalobjectsmap.get("titre_page_news").getText().equals("Actualités"),equalTo(true));
    }
}
