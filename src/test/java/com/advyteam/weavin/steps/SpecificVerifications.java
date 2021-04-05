package com.advyteam.weavin.steps;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
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
                    Assert.assertTrue(generalobjectsmap.get("Acceuil_header").isDisplayed());
                } else {
                    Assert.assertTrue(generalobjectsmap.get("login_button").isDisplayed());
                    //TODO adapt this assertion when notification on wrong username or password is added

                }
                break;
            }

            case "ssss": {
                Assert.assertTrue(generalobjectsmap.get("login_button").isDisplayed());
                //TODO adapt this assertion when notification on wrong username or password is added
                break;
            }

        }


    }

    @Then("vérifier l'affichage correct de tous les sous-menu")
    public void vérifierLAffichageCorrectDeTousLesSousMenu() {
        logger.info("Vérification de la présence de tous les sous-menu");
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-close-icon.left-menu-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-home-icon.left-menu-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#sidebar-left-1 > div > ul > li:nth-child(3)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#sidebar-left-1 > div > ul > li:nth-child(5)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".sidebar--small:nth-child(1) div.mCustomScrollbar ul.left-menu li:nth-child(6) > a.ideation-link")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-calendar-icon.left-menu-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#sidebar-left-1 > div > ul > li:nth-child(8)")).isDisplayed());
        Assert.assertEquals("Fermer le menu", driver.findElement(By.cssSelector("li:nth-child(1) .left-menu-title")).getText());
        Assert.assertEquals("Accueil", driver.findElement(By.cssSelector("li:nth-child(2) .left-menu-title")).getText());
        Assert.assertEquals("Annuaire", driver.findElement(By.cssSelector("li:nth-child(3) .left-menu-title")).getText());
        Assert.assertEquals("Know'store", driver.findElement(By.cssSelector("li:nth-child(5) .left-menu-title")).getText());
        Assert.assertEquals("Idéation", driver.findElement(By.cssSelector("li:nth-child(6) .left-menu-title")).getText());
        Assert.assertEquals("Calendrier & événements", driver.findElement(By.cssSelector("li:nth-child(7) .left-menu-title")).getText());
        Assert.assertEquals("News", driver.findElement(By.cssSelector("li:nth-child(8) .left-menu-title")).getText());
    }

    @Then("vérifer la fermeture du sous menu")
    public void vériferLaFermetureDuSousMenu() throws IOException {
        logger.info("Vérification de la fermeture du menu");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-close-icon.left-menu-icon")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-home-icon.left-menu-icon")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-user-menu-male")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-about")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-idea-2")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .olymp-calendar-icon.left-menu-icon")).isEmpty());
        Assert.assertTrue(driver.findElements(By.cssSelector(".fixed-sidebar.open .sidebar--large .left-menu-icon.icons8-news")).isEmpty());
        driver.manage().timeouts().implicitlyWait(Long.parseLong(Utilitie.readers().getProperty("webdriver.timeouts.implicitlywait")), TimeUnit.MILLISECONDS);
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-home-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-collabs-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-knowstore-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-ideation-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-calendar-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".fixed-sidebar .sidebar--small .olymp-newspaper-icon")).isDisplayed());
    }

    @Then("Vérifier que le menu s'affiche")
    public void vérifierQueLeMenuSAffiche() {
        logger.info("Vérification de l'affichage correct du menu des paramètres du compte");
        Assert.assertTrue(driver.findElement(By.cssSelector(".account-settings")).isDisplayed());
    }

    @Then("vérifier que l'utilisateur est deconnecté")
    public void vérifierQueLUtilisateurEstDeconnecté() {
        logger.info("Vérification de la déconnexion correct de l'utilisateur");
        Assert.assertTrue(generalobjectsmap.get("login_button").isDisplayed());
        Assert.assertTrue(generalobjectsmap.get("champ_username").isDisplayed());
        Assert.assertTrue(generalobjectsmap.get("champ_password").isDisplayed());
    }

    @Then("vérifier que le mot de passe est masqué")
    public void vérifierQueLeMotDePasseEstMasqué() {
        logger.info("Vérification que le mot de passe est masqué");
        Assert.assertEquals("password", generalobjectsmap.get("champ_password").getAttribute("type"));
    }

    @Then("vérifier que le mot de passe est affiché")
    public void vérifierQueLeMotDePasseEstAffiché() {
        logger.info("Vérification que le mot de passe est affiché");
        Assert.assertEquals("text", generalobjectsmap.get("champ_password").getAttribute("type"));
    }

    @Then("vérifier que la page affichée est la page d'accueil")
    public void vérifierQueLaPageAffichéeEstLaPageDAccueil() {
        logger.info("Vérification que la page affichée est la page d'accueil");
        Assert.assertEquals("https://weavin-qa.accretio.io/portal", driver.getCurrentUrl());
        Assert.assertTrue(generalobjectsmap.get("Widget_flux_activite").isDisplayed());
    }

    @Then("vérifier que la page affichée est la page annuaire")
    public void vérifierQueLaPageAffichéeEstLaPageAnnuaire() {
        logger.info("Vérification que la page affichée est la page annuaire");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/collaborators")));
        Assert.assertEquals("https://weavin-qa.accretio.io/portal/collaborators", driver.getCurrentUrl());
        Assert.assertTrue(generalobjectsmap.get("Balise_filtre_annuaire").isDisplayed());
    }

    @Then("vérifier que la page affichée est la page knows store")
    public void vérifierQueLaPageAffichéeEstLaPageKnowsStore() {
        logger.info("vérification que la page affichée est la page know's store");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.bubbleyou.com/portal/knowstore/list")));
        Assert.assertEquals("https://weavin-qa.bubbleyou.com/portal/knowstore/list", driver.getCurrentUrl());
        Assert.assertEquals("Know'store", generalobjectsmap.get("titre_page_knowstore").getText());
    }

    @Then("vérifier que la page affichée est la page idéation")
    public void vérifierQueLaPageAffichéeEstLaPageIdéation() {
        logger.info("vérification que la page affichée est la page idéation");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.bubbleyou.com/portal/ideations/list")));
        Assert.assertEquals("https://weavin-qa.bubbleyou.com/portal/ideations/list", driver.getCurrentUrl());
        Assert.assertEquals("Idéation", generalobjectsmap.get("titre_page_ideation").getText());
    }

    @Then("vérifier que la page affichée est la page calendrier et évenement")
    public void vérifierQueLaPageAffichéeEstLaPageCalendrierEtÉvenement() {
        logger.info("vérification que la page affichée est la page calendrier et évenement");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/agenda")));
        Assert.assertEquals("https://weavin-qa.accretio.io/portal/agenda", driver.getCurrentUrl());
        Assert.assertEquals("Calendrier et évènements", generalobjectsmap.get("titre_page_calendrier").getText());
    }

    @Then("vérifier que la page affichée est la page news")
    public void vérifierQueLaPageAffichéeEstLaPageNews() {
        logger.info("vérification que la page affichée est la page news");
        boolean specialwait = (new WebDriverWait(driver, 40)).until(
                (ExpectedConditions
                        .urlMatches("https://weavin-qa.accretio.io/portal/news")));
        Assert.assertEquals("https://weavin-qa.accretio.io/portal/news", driver.getCurrentUrl());
        Assert.assertEquals("Actualités", generalobjectsmap.get("titre_page_news").getText());
    }
}
