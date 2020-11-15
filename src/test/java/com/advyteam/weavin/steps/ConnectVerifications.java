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

import static com.advyteam.weavin.runner.setUp.datastore;
import static com.advyteam.weavin.steps.CommonSteps.generalobjectsmap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectVerifications {

    @Managed
    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(ConnectVerifications.class);


    // Vérification Scénario publication d'un nouveau statut
    @Then("Vérifier que le statut est publié")
    public void vérifierQueLeStatutEstPublié() throws InterruptedException {

        logger.info("Vérification de la publication correct du statut");

        //Waiting for the first publication of timeline to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Texte_Premiere_Publication_Timeline"), "innerText",
                                datastore.get("champ_statut"))));

        //Waiting for the refreshed first publication to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first publication contains the text published in the scenario
        assertThat(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"), equalTo(datastore.get("champ_statut")));
    }

    //    Vérification pour Idéation
    @Then("vérifier que le modal de création d'une idée est affiché")
    public void vérifierQueLeModalDeCréationDUneIdéeEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'une idée");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_ideation"))));
        assertThat(generalobjectsmap.get("Modal_ajout_ideation").isDisplayed(), equalTo(true));
    }

    //    Vérification pour Idéation
    @Then("vérifier la publication correct de l idee")
    public void vérifierLaPublicationCorrectDeLIdee() {
        logger.info("vérification de la publication correct de la nouvelle idée");
        assertThat(!driver.findElements(By.xpath(("//a[contains(text(),\"")+datastore.get("Titre_nouvelle_idee")+("\")]"))).isEmpty(),equalTo(true));

    }
}
