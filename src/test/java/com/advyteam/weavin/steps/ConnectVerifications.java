package com.advyteam.weavin.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
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
import static org.hamcrest.CoreMatchers.*;
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

    //Vérification pour  News
    @Then("vérifier la création de la nouvelle news")
    public void vérifierLaCréationDeLaNouvelleNews() throws InterruptedException {

        logger.info("Vérification de la publication correct de la news");

        //Waiting for the first news to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_News_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_News"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_News")));

    }

    //Vérification pour  News
    @And("l utilisateur saisit une heure supérieure à l'heure systéme")
    public void lUtilisateurSaisitUneHeureSupérieureÀLHeureSystéme() {
        logger.info("saisit de l'heure de  début de la publication de la news");

       //récuperer l'heure systéme et l'incrémenter

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 1); //here n is no.of hour you want to increase
        SimpleDateFormat format1 = new SimpleDateFormat("hh:mm");


        String formatted = format1.format(cal.getTime());

        generalobjectsmap.get("Champ_Input_Heure_Debut_News").sendKeys(formatted);




    }

    //Vérification pour  News
    @Then("Vérifier que l actualité ne s affiche que si l heure  est égale à l heure de date de début de l'actualité")
    public void vérifierQueLActualitéNeSAfficheQueSiLHeureEstÉgaleÀLHeureDeDateDeDébutDeLActualité() {

        logger.info("vérification du statut de la news");

        assertThat(generalobjectsmap.get("Statut_Premiere_News_publier").getAttribute("innerText"), equalTo("PROGRAMMÉ"));

    }

    //Vérification pour  News
    @And("l utilisitateur saisit la date du jour dans le champs fin date news")
    public void lUtilisitateurSaisitLaDateDuJourDansLeChampsFinDateNews() {
        logger.info("saisit de la date de fin de publication de la news par l'utilisateur");


        //récupérer le jour actuel


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");


        String formattedDate = format1.format(cal.getTime());

        //activer le calendrier
        WebElement element = driver.findElement(By.xpath("//div/div/form/div[1]/div[1]/div[3]/div[3]/div/app-floating-label-form/div/div/div/button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


        //Parcour le calendrier afficher

        List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-root/app-layout-portal/div[2]/app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[3]/div/app-floating-label-form/div/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div[*]/div[*]"));
        for (WebElement element1 : elements) {

            String str1 = element1.getAttribute("ariaLabel");
            if(str1.equals(formattedDate)){

                executor.executeScript("arguments[0].click();", element1);
                break;

            }

        }



    }

    //Vérification pour  News
    @Then("Vérifier que l'actualité a été modifiée avec succés")
    public void vérifierQueLActualitéAÉtéModifiéeAvecSuccés() throws InterruptedException {

        logger.info("Vérification de la modification correct de la news");

        //Waiting for the first news to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_News_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_News"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_News")));



    }

    //Vérification pour  News
    @Then("Vérifier que l'actualité a été spprimer avec succés")
    public void vérifierQueLActualitéAÉtéSpprimerAvecSuccés() throws InterruptedException {

        logger.info("Vérification de la suppression correct de la news");


        //Waiting for the first news to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions.not(
                        ExpectedConditions .attributeContains(generalobjectsmap.get("Titre_Premiere_News_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_News")))) );

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news  do not contains the text published in the scenario

        assertThat(generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"), is(not(equalTo(  datastore.get("Champ_Input_Titre_News")  ))))     ;

    }

    //Vérification pour  News
    @Then("Vérifier que l'actualité affiche")
    public void vérifierQueLActualitéAffiche() throws InterruptedException {

        logger.info("Vérifier que la news rechercher s'affiche");

        //Waiting for the first news to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_News_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_News"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_News")));

    }

    //Vérification pour  News
    @Then("Vérifier que seuls les actualités {string} s'affichent")
    public void vérifierQueSeulsLesActualitésSAffichent(String statut) {

        Boolean result=true;

        //Parcourir la liste des tous les statut affichés

        List<WebElement> elements = driver.findElements(By.cssSelector(".post-category"));
        for (WebElement element1 : elements) {

            String str1 =element1.getAttribute("innerText");
            if(!str1.equalsIgnoreCase(statut)){
                result=false;
                break;
            }
        }
        Assert.assertTrue(result);
    }



}
