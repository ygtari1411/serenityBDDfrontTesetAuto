package com.advyteam.weavin.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    //Vérification pour  News
    @Then("vérifier que le modal de création d'une news est affiché")
    public void vérifierQueLeModalDeCréationDUneNewsEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'une news");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_news"))));
        assertThat(generalobjectsmap.get("Modal_ajout_news").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_ajout_news").getAttribute("innerText"), equalTo("Annoncez une actualité"));


    }


    //Vérification pour  News
    @And("l utilisitateur saisit la date du jour dans le champs debut date news")
    public void lUtilisitateurSaisitLaDateDuJourDansLeChampsDebutDateNews() {
        logger.info("saisit de la date de la publication de la news par l'utilisateur");

        //récupérer le jour actuel
        Calendar cal = Calendar.getInstance( );  // date du jour
        int jourActuel=cal.get(Calendar.DAY_OF_MONTH);
        //Convertir le jour en String
        String jourActuelS = String.valueOf(jourActuel);


        //activer le calendrier
        WebElement element = driver.findElement(By.xpath("//div[2]/app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[1]/div/app-floating-label-form/div/div/div/button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


        //Parcour le calendrier afficher

        List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-root/app-layout-portal/div[2]/app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[1]/div/app-floating-label-form/div/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div[*]/div[*]"));
        for (WebElement element1 : elements) {

            String str1 = element1.getAttribute("innerText");
            String str2 = element1.getAttribute("className");
            if(str1.equals(jourActuelS) && str2.equals("ngb-dp-day ngb-dp-today")){

                executor.executeScript("arguments[0].click();", element1);
                break;

            }


        }


    }




}
