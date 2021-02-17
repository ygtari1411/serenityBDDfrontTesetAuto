package com.advyteam.weavin.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.SerenityActions;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.advyteam.weavin.runner.setUp.datastore;
import static com.advyteam.weavin.steps.CommonSteps.generalobjectsmap;


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
        Assert.assertEquals(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"),datastore.get("champ_statut"));
    }

    //    Vérification pour Idéation
    @Then("vérifier que le modal de création d'une idée est affiché")
    public void vérifierQueLeModalDeCréationDUneIdéeEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'une idée");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_ideation"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_ajout_ideation").isDisplayed());
    }

    //    Vérification pour Idéation
    @Then("vérifier la publication correct de l idee")
    public void vérifierLaPublicationCorrectDeLIdee() {
        logger.info("vérification de la publication correct de la nouvelle idée");
        Assert.assertFalse(driver.findElements(By.xpath(("//a[contains(text(),\"") + datastore.get("Titre_nouvelle_idee") + ("\")]"))).isEmpty());
    }

    //Vérification pour  News
    @Then("vérifier que le modal de création d'une news est affiché")
    public void vérifierQueLeModalDeCréationDUneNewsEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'une news");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_news"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_ajout_news").isDisplayed());
        Assert.assertEquals("Annoncez une actualité",generalobjectsmap.get("Modal_ajout_news").getAttribute("innerText"));
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
        Assert.assertEquals(datastore.get("Champ_Input_Titre_News"),generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"));
    }

    //Vérification pour  News
    @And("l utilisateur saisit une heure supérieure à l'heure systéme")
    public void lUtilisateurSaisitUneHeureSupérieureÀLHeureSystéme() {
        logger.info("saisit de l'heure de  début de la publication de la news");

       //récuperer l'heure systéme et l'incrémenter


        //DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 1); //here n is no.of hour you want to increase
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");


        String formatted = format1.format(cal.getTime());

        generalobjectsmap.get("Champ_Input_Heure_Debut_News").sendKeys(formatted);




    }

    //Vérification pour  News
    @Then("Vérifier que l actualité ne s affiche que si l heure  est égale à l heure de date de début de l'actualité")
    public void vérifierQueLActualitéNeSAfficheQueSiLHeureEstÉgaleÀLHeureDeDateDeDébutDeLActualité() {

        logger.info("vérification du statut de la news");
        Assert.assertEquals("PROGRAMMÉ",generalobjectsmap.get("Statut_Premiere_News_publier").getAttribute("innerText"));
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
        Assert.assertEquals(datastore.get("Champ_Input_Titre_News"),generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"));


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
        Assert.assertNotEquals(datastore.get("Champ_Input_Titre_News"),generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"));
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
        Assert.assertEquals(datastore.get("Champ_Input_Titre_News"),generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"));
    }

    //Vérification pour News
    @Then("Vérifier que seuls les actualités {string} s'affichent")
    public void vérifierQueSeulsLesActualitésSAffichent(String statut) {

        logger.info("Vérifier le statut des news affichées");

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

    //   Vérification pour Idéation
    @Then("vérifier l ajout  correct du commentaire")
    public void vérifierLAjoutCorrectDuCommentaire() throws InterruptedException {

        logger.info("Vérifier que le commentaire a été ajouté");


        //Vérifier que le nombre de commentaire s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("div.post-additional-info.inline-items.ng-star-inserted > app-post-statistics > div > ul > li > a > span")).size(),0);
        //cliquer sur l icone commentaire
        generalobjectsmap.get("Icone_Commenteraire_Ideation").click();
        //Waiting
        synchronized (driver) {
            driver.wait(3000);
        }
        //Vérifier que le commentaire est celui qu'on a introduit
        //Assert.assertTrue(datastore.get("Champ_Input_Commenter_Ideation").contains(generalobjectsmap.get("Premiere_Commentaire_Ideation_Afficher").getAttribute("innerText")));
        Assert.assertEquals(datastore.get("Champ_Input_Commenter_Ideation"),generalobjectsmap.get("Premiere_Commentaire_Ideation_Afficher").getAttribute("innerText"));
    }

    //   Vérification pour Idéation
    @Then("vérifier l ajout  correct du Like")
    public void vérifierLAjoutCorrectDuLike() {

        logger.info("Vérifier que le like a été ajouté");

        //Vérifier que l icone <3 s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("span.inline-svg-icon.reactions-icon-statistic-EMPATHY.reactions-menu__icon")).size(),0);

        //Vérifier que le like a été comptabilisé

        Assert.assertEquals(generalobjectsmap.get("Nombre_Like_Ideation").getAttribute("innerText"),"1");

    }

    //   Vérification pour Idéation
    @And("l utilisateur clique sur le bouton Envoyer_Commenteraire_Modifier_Ideation")
    public void lUtilisateurCliqueSurLeBoutonEnvoyer_Commenteraire_Modifier_Ideation() {
        logger.info("l'utilisateur clique sur le bouton Envoyer_Commentaire_Modifier_Ideation ");

        WebElement element = generalobjectsmap.get("Envoyer_Commenteraire_Modifier_Ideation");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }

    //   Vérification pour Idéation
    @Then("verifier que le commentaire est modifié")
    public void verifierQueLeCommentaireEstModifié() {
        logger.info("vérifier que le commentaire a été modifié avec succés");

        Assert.assertEquals(datastore.get("Champ_Input_Modification_Commenteraire_Ideation"),generalobjectsmap.get("Premiere_Commentaire_Ideation_Afficher").getAttribute("innerText"));

    }

    //   Vérification pour Idéation
    @Then("verifier que l'interaction a été modifiée avec succés")
    public void verifierQueLInteractionAÉtéModifiéeAvecSuccés() {
        logger.info("vérifier que l'interaction a été modifiée avec succés");

        //Vérifier que l icone praise s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("span.inline-svg-icon.reactions-icon-statistic-EMPATHY.reactions-menu__icon")).size(),0);

    }

    //   Vérification pour Idéation
    @Then("verifier que le commentaire est supprimé")
    public void verifierQueLeCommentaireEstSupprimé() {
        logger.info("vérifier que le commentaire a été supprimé");

      //Vérifier que l'icone commentaire ne s'affiche plus

        Assert.assertEquals(0,driver.findElements(By.cssSelector("div.post-additional-info.inline-items.ng-star-inserted > app-post-statistics > div > ul > li > a")).size());

    }
    //   Vérification pour Idéation
    @Then("verifier que le like a été ajouté")
    public void verifierQueLeLikeAÉtéAjouté() {
        logger.info("vérifier que le like a été ajouté");

        //Verifier que l'icone Like s'affiche
        Assert.assertNotEquals(0,driver.findElements(By.cssSelector(" li > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon.ng-star-inserted")).size());

    }

    //   Vérification pour Idéation
    @Then("vérifier que le dilike a été effectué")
    public void vérifierQueLeDilikeAÉtéEffectué() {
        logger.info("vérifier que le Dislike a été effectué");

        //Verifier que l'icone Like ne s'affiche
        Assert.assertEquals(0,driver.findElements(By.cssSelector(" li > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon.ng-star-inserted")).size());


    }

    //   Vérification pour Idéation
    @Then("vérifier que l idée afficher est l'idée recherchée")
    public void vérifierQueLIdéeAfficherEstLIdéeRecherchée() {
        logger.info("vérifier que l'idée rechercher s'affiche");

        Assert.assertTrue(generalobjectsmap.get("Derniere_Idee_Ajoutee").getAttribute("innerText").contains(datastore.get("Titre_nouvelle_idee")));


    }

    //   Vérification pour Idéation
    @Then("vérifier que les idées affichées contiennent le tag{string}")
    public void vérifierQueLesIdéesAffichéesContiennentLeTag(String tag) {

        logger.info("Vérifier que le tag s'affiche ");

        Boolean result=true;


        //Parcourir la liste des tous les tags affichés

        List<WebElement> elements = driver.findElements(By.cssSelector("div.post-content > div.tags-container > a"));
        for (WebElement element1 : elements) {

            String str1 =element1.getAttribute("innerText");
            if(!str1.equalsIgnoreCase(tag)){
                result=false;
                break;
            }
        }
        Assert.assertTrue(result);
    }

    //   Vérification pour Idéation
    @Then("verifier que les idées sont affichées par ordre ascendant")
    public void verifierQueLesIdéesSontAffichéesParOrdreAscendant() {

        logger.info("Vérifier l'ordre de tri ascendant");

        Boolean triOK=true;

        //Parcourir la liste des notes

        int   LastValue  =Integer.parseInt( (driver.findElement(By.xpath("//div[2]/app-post-card/div/article/div[2]/div[5]/div/span")).getAttribute("innerText")).trim() ) ;
        List<WebElement> elements = driver.findElements(By.xpath("//div[*]/app-post-card/div/article/div[2]/div[5]/div/span"));
        for (WebElement element1 : elements) {

            int ActualValue =Integer.parseInt((element1.getAttribute("innerText")).trim())   ;
            if( LastValue>ActualValue){
                triOK=false;
                break;
            }
            else{
                LastValue=ActualValue;
            }

        }
        Assert.assertTrue(triOK);


    }

    //   Vérification pour Idéation
    @Then("verifier que les idées sont affichées par ordre descendant")
    public void verifierQueLesIdéesSontAffichéesParOrdreDescendant() {


        logger.info("Vérifier l'ordre de tri descendant");

        Boolean triOK=true;

        //Parcourir la liste des notes

        int   LastValue  =Integer.parseInt( (driver.findElement(By.xpath("//div[2]/app-post-card/div/article/div[2]/div[5]/div/span")).getAttribute("innerText")).trim() ) ;
        List<WebElement> elements = driver.findElements(By.xpath("//div[*]/app-post-card/div/article/div[2]/div[5]/div/span"));
        for (WebElement element1 : elements) {

            int ActualValue =Integer.parseInt((element1.getAttribute("innerText")).trim())   ;
            if( LastValue<ActualValue){
                triOK=false;
                break;
            }
            else{
                LastValue=ActualValue;
            }

        }
        Assert.assertTrue(triOK);


    }

    //   Vérification pour Idéation
    @And("vérifier qu un message d'erreur s affiche pour chaque champs requis")
    public void vérifierQuUnMessageDErreurSAffichePourChaqueChampsRequis() {

        logger.info("Vérifier que les messages champs requis s'affichent");

        Assert.assertEquals(driver.findElements(By.cssSelector(".invalid-feedback .error-box")).size(),4);

    }

    //   Vérification pour Know'Store
    @Then("vérifier que le modal de création d'un article est affiché")
    public void vérifierQueLeModalDeCréationDUnArticleEstAffiché() {

        logger.info("Vérification de l'affichage du modal de création d'un article");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_Article"))));
        assertThat(generalobjectsmap.get("Modal_ajout_Article").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_ajout_Article").getAttribute("innerText"), equalTo("Publiez un article"));



    }

    //   Vérification pour Know'Store
    @Then("vérifier la création du nouveau article")
    public void vérifierLaCréationDuNouveauArticle() throws InterruptedException {
        logger.info("Vérification de la publication correct de l'article");


        //Waiting for the first article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));


    }

    //   Vérification pour Know'Store
    @Then("Vérifier que l'article a été modifié avec succés")
    public void vérifierQueLArticleAÉtéModifiéAvecSuccés() throws InterruptedException {

        logger.info("Vérification de la modification correct de l'article");

        //Waiting for the first news to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }
        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));
    }

    //   Vérification pour Know'Store
    @Then("Vérifier que l'article a été supprimé avec succés")
    public void vérifierQueLArticleAÉtéSuppriméAvecSuccés() throws InterruptedException {




        logger.info("Vérification de la suppression correct de l'article");


        //Waiting for the first Article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions.not(
                        ExpectedConditions .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article")))) );

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first Article  do not contains the text published in the scenario

        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), is(not(equalTo(  datastore.get("Champ_Input_Titre_Article")  ))))     ;


    }

    //   Vérification pour Know'Store
    @Then("vérifier que le commentaire a été ajouté")
    public void vérifierQueLeCommentaireAÉtéAjouté() throws InterruptedException {
        logger.info("Vérifier que le commentaire a été ajouté");



        //Vérifier que l'icone commentaire s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("app-post-statistics > div > ul > li > a > span")).size(),0);
        //cliquer sur l icone commentaire
        generalobjectsmap.get("Icone_Commentaire_Article").click();
        //Waiting
        synchronized (driver) {
            driver.wait(3000);
        }
        //Vérifier que le commentaire est celui qu'on a introduit

        Assert.assertEquals(datastore.get("Champ_Input_Commenter_Article"),generalobjectsmap.get("Premiere_Commentaire_Article_Afficher").getAttribute("innerText"));


    }

    //   Vérification pour Know'Store
    @Then("vérifier  que le like  a été ajouté")
    public void vérifierQueLeLikeAÉtéAjouté() {

        logger.info("Vérifier que le like a été ajouté");

        //Vérifier que l icone LIKE s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon")).size(),0);

        //Vérifier que le like a été comptabilisé

        Assert.assertEquals(generalobjectsmap.get("Nombre_Like_Article").getAttribute("innerText"),"1");


    }

    //   Vérification pour Know'Store
    @Then("vérifier que l admin a reçu une notification pour l intercation et une notification pour le commentaire")
    public void vérifierQueLAdminAReçuUneNotificationPourLIntercationEtUneNotificationPourLeCommentaire() {

        Assert.assertTrue(generalobjectsmap.get("Premiere_Notification_Afficher").getAttribute("innerText").contains("réagi à votre publication"));
        Assert.assertTrue(generalobjectsmap.get("Deuxieme_Notification_Afficher").getAttribute("innerText").contains("a commenté votre"));

    }

    //   Vérification pour Know'Store
    @Then("verifier que le commentaire de l article est modifié")
    public void verifierQueLeCommentaireDeLArticleEstModifié() {
        logger.info("vérifier que le commentaire a été modifié avec succés");

        Assert.assertEquals(datastore.get("Champ_Input_Modification_Commenteraire_Article"),generalobjectsmap.get("Premiere_Commentaire_Article_Afficher").getAttribute("innerText"));


    }

    //   Vérification pour Know'Store
    @Then("verifier que l interaction de l article a été modifiée avec succés")
    public void verifierQueLInteractionDeLArticleAÉtéModifiéeAvecSuccés() {

        logger.info("vérifier que l'interaction a été modifiée avec succés");

        //Vérifier que l icone praise s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("span.inline-svg-icon.reactions-icon-statistic-PRAISE.reactions-menu__icon")).size(),0);


    }

    //   Vérification pour Know'Store
    @And("l utilisateur clique sur le bouton Envoyer_Commenteraire_Modifier_Article")
    public void lUtilisateurCliqueSurLeBoutonEnvoyer_Commenteraire_Modifier_Article() {

        logger.info("l'utilisateur clique sur le bouton Envoyer_Commentaire_Modifier_Article ");

        WebElement element = generalobjectsmap.get("Envoyer_Commenteraire_Modifier_Article");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }


    // Vérification pour News
    @And("vérifier que le témoin nouveau est affiché")
    public void vérifierQueLeTémoinNouveauEstAffiché() {
        logger.info("vérifier que le témoin nouveau est affiché");
        Assert.assertEquals("NOUVEAU", generalobjectsmap.get("Temoin_Premiere_News_Affichee").getAttribute("innerText"));
    }

    // Vérification pour News
    @And("l utilisateur clique sur la derniere news ajoutee")
    public void lUtilisateurCliqueSurLaDerniereNewsAjoutee() {
        logger.info("l utilisateur clique sur la derniere news ajoutee");
        String str= datastore.get("Champ_Input_Titre_News");
        Boolean modules = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(
                        By.cssSelector("div:nth-child(1) > div.news-details > h3"),
                        "innerText",
                        str)));
        generalobjectsmap.get("Premiere_News_In_Home_List_News").click();
    }

    // Vérification pour News
    @Then("vérifier l ajout  correct du commentaire news")
    public void vérifierLAjoutCorrectDuCommentaireNews() throws InterruptedException {
        logger.info("vérifier l ajout  correct du commentaire news");
        //Vérifier que le nombre de commentaire s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector(
                " div.open-photo-content > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > span")).size(),
                0);
        //cliquer sur l icone commentaire
        generalobjectsmap.get("Icone_Commenteraire_News").click();
        //Waiting
        synchronized (driver) {
            driver.wait(3000);
        }
        //Vérifier que le commentaire est celui qu'on a introduit
        Assert.assertEquals(datastore.get("Champ_Input_Commenter_News"),generalobjectsmap.get("Premiere_Commentaire_News_Afficher").getAttribute("innerText"));
    }

    // Vérification pour News
    @And("vérifier qu un message d'erreur s affiche pour chaque champs requis pour news")
    public void vérifierQuUnMessageDErreurSAffichePourChaqueChampsRequisPourNews() {
        logger.info("Vérifier que les messages champs requis s'affichent pour news");
        Assert.assertEquals(
                driver.findElements(By.cssSelector(".invalid-feedback .error-box")).size(),
                3
        );
    }

    // Vérification pour News
    @Then("vérifier l ajout  correct du Like news")
    public void vérifierLAjoutCorrectDuLikeNews() {
        logger.info("vérifier l ajout  correct du Like news");
        //Vérifier que l icone like s'affiche
        Assert.assertNotEquals(
                driver.findElements(By.cssSelector("a > span.reactions-icon-md-LIKE.reactions-menu__icon")).size(),
                0
        );
        //Vérifier que le like a été comptabilisé
        Assert.assertEquals(generalobjectsmap.get("Nombre_Like_News").getAttribute("innerText"),"1");
    }


    //   Vérification pour News
    @And("l utilisateur clique sur le bouton Envoyer commenteraire Modifiee")
    public void lUtilisateurCliqueSurLeBoutonEnvoyerCommenteraireModifiee() {
        logger.info("l utilisateur clique sur le bouton Envoyer commenteraire Modifiee");
        WebElement element = generalobjectsmap.get("Envoyer_Commenteraire_Modifier_News");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    //   Vérification pour News
    @Then("verifier que le commentaire news est modifié")
    public void verifierQueLeCommentaireNewsEstModifié() {
        logger.info("verifier que le commentaire est modifié");
        Assert.assertEquals(
                datastore.get("Champ_Input_Modification_Commenteraire_News"),
                generalobjectsmap.get("Premiere_Commentaire_News_Afficher").getAttribute("innerText")
        );
    }

    //   Vérification pour News
    @Then("verifier que l'interaction news a été modifiée avec succés")
    public void verifierQueLInteractionNewsAÉtéModifiéeAvecSuccés() {
        logger.info("verifier que l'interaction news a été modifiée avec succés");

        //Vérifier que l icone praise s'affiche
        Assert.assertNotEquals(driver.findElements(
                By.cssSelector("span.inline-svg-icon.reactions-icon-statistic-PRAISE.reactions-menu__icon")).size(),
                0
        );

    }

    //   Vérification pour News
    @Then("verifier que le commentaire news est supprimé")
    public void verifierQueLeCommentaireNewsEstSupprimé() {
        logger.info("verifier que le commentaire news est supprimé");
        //Vérifier que l icone commentaires ne s'affiche pas
        Assert.assertEquals(driver.findElements(
                By.cssSelector("div.open-photo-content > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(2) > a > svg")).size(),
                0
        );

    }

    //   Vérification pour News
    @Then("verifier que l'interaction news a été supprimée avec succés")
    public void verifierQueLInteractionNewsAÉtéSuppriméeAvecSuccés() {
        logger.info("verifier que l'interaction news a été supprimée avec succés");
        //Vérifier que l icone interaction ne s'affiche pas
        Assert.assertEquals(driver.findElements(
                By.cssSelector("a > span.reactions-icon-md-LIKE.reactions-menu__icon")).size(),
                0
        );
    }
    //   Vérification pour Know'Store
    @Then("verifier que le like a été supprimé")
    public void verifierQueLeLikeAÉtéSupprimé(){

        logger.info("Vérifier que le like a été supprimé");

        //Vérifier que l icone LIKE ne s'affiche plus
        Assert.assertEquals(0,driver.findElements(By.cssSelector("ul > li:nth-child(1) > div > a > span.reactions-menu__icon.reactions-icon-md-LIKE")).size());



    }

    //   Vérification pour Know'Store
    @And("verifier que le commentaire a été supprimé")
    public void verifierQueLeCommentaireAÉtéSupprimé() {
        logger.info("Vérifier que le commentaire a été supprimé");

        Assert.assertEquals(0,driver.findElements(By.cssSelector("div.post-additional-info.inline-items.ng-star-inserted > app-post-statistics > div > ul > li > a")).size());


    }

    @Then("vérifier que l'article rechercher par titre s affiche")
    public void vérifierQueLArticleRechercherParTitreSAffiche() throws InterruptedException {
        logger.info("Vérifier que l'article ajouté s'affiche");


        //Waiting for the first article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));



    }

    //   Vérification pour Know'Store
    @Then("vérifier que l'article rechercher par date de debut s affiche")
    public void vérifierQueLArticleRechercherParDateDeDebutSAffiche() throws InterruptedException {

        logger.info("vérifier que l'article rechercher par date de debut s affiche");

        //Waiting for the first article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));



    }

    //   Vérification pour Know'Store
    @Then("vérifier que seul les articles de {string} s affichent")
    public void vérifierQueSeulLesArticlesDeSAffichent(String category) {
        logger.info("vérifier que seul les articles de "+category+" s'affichent");

        //recupérer la liste des catégories

         List<WebElement> elements = driver.findElements(By.cssSelector(".post-category"));

        //parcourir la liste des catégories
        boolean trouve=false;

        for(int i=1;i<elements.size();i++){

            String str = (elements.get(i)).getAttribute("innerText");
            if( !str.equals(category) ){
                System.out.println(str);
                trouve=true;
            }

        }
     //Vérifier si il y a une categorie différente de c'elle rechercher

        Assert.assertFalse(trouve);

    }

    //   Vérification pour Know'Store
    @Then("vérifier que l'article rechercher par date de fin s affiche")
    public void vérifierQueLArticleRechercherParDateDeFinSAffiche() throws InterruptedException {

        logger.info("vérifier que l'article rechercher par date de fin s affiche");

        //Waiting for the first article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));



    }

    //   Vérification pour Know'Store
    @Then("verifier que l article rechercher par date de debut et date de fin s affiche")
    public void verifierQueLArticleRechercherParDateDeDebutEtDateDeFinSAffiche() throws InterruptedException {

        logger.info("vérifier que l'article rechercher par date de début et date de fin s affiche");

        //Waiting for the first article to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premier_Article_publier"), "innerText",
                                datastore.get("Champ_Input_Titre_Article"))));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Premier_Article_publier").getAttribute("innerText"), equalTo(datastore.get("Champ_Input_Titre_Article")));


    }


    //   Vérification pour Know'Store
    @And("vérifier qu un message d'erreur s affiche pour chaque champs requis pour article")
    public void vérifierQuUnMessageDErreurSAffichePourChaqueChampsRequisPourArticle() {
        logger.info("vérifier qu un message d'erreur s affiche pour chaque champs requis pour news");
        Assert.assertEquals(
                driver.findElements(By.cssSelector(".invalid-feedback .error-box")).size(),
                4
        );
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier que le modal de création d'un evenement est affiché")
    public void vérifierQueLeModalDeCréationDUnEvenementEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'un evenement");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_ajout_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_ajout_Evenement").getAttribute("innerText"), equalTo("Créer un évènement"));

    }
    

    // Vérification pour calendrier et evenements
    @And("l utilisateur selectionne {string} dans la liste deroulante des invites interne {string}")
    public void lUtilisateurSelectionneDansLaListeDeroulanteDesInvitesInterne(String option, String dropdownlist) throws InterruptedException {
        logger.info("l'utilisateur sélectionne l'option " + option + " dans la " + dropdownlist);
        datastore.put(dropdownlist, option);
        generalobjectsmap.get(dropdownlist).click();
        synchronized (driver) {
            driver.wait(1000);
        }
        Actions actions;
        actions = new Actions(driver);
        for (WebElement element : driver.findElements(By.cssSelector(".ng-dropdown-panel-items .ng-option"))) {
            actions.moveToElement(element).perform();
            if (element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }

    }
    
    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement")
    public void vérifierLaCréationDuNouveauEvenement() {
        logger.info("vérifier la création du nouveau evenement");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création evenement"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la modification de l evenement ajoute")
    public void vérifierLaModificationDeLEvenementAjoute() {
        logger.info("vérifier la modification de l evenement ajoute");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique modification evenement"));
    }

    @Then("vérifier que le commentaire evenement a été ajouté")
    public void vérifierQueLeCommentaireEvenementAÉtéAjouté() throws InterruptedException {

        logger.info("vérifier que le commentaire evenement a été ajouté");

        //Vérifier que l'icone commentaire s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("app-post-statistics > div > ul > li > a > span")).size(),0);
        //cliquer sur l icone commentaire
        generalobjectsmap.get("Icone_Commentaire_Evenement").click();
        //Waiting
        synchronized (driver) {
            driver.wait(3000);
        }
        //Vérifier que le commentaire est celui qu'on a introduit
        Assert.assertEquals(
                datastore.get("Champ_Input_Commentaire_Evenement"),
                generalobjectsmap.get("Premiere_Commentaire_Evenement_Afficher").getAttribute("innerText"));


    }

    @Then("vérifier  que le like evenement a été ajouté")
    public void vérifierQueLeLikeEvenementAÉtéAjouté() {

        logger.info("vérifier  que le like evenement a été ajouté");
        //Vérifier que l icone LIKE s'affiche
        Assert.assertNotEquals(
                driver.findElements(
                        By.cssSelector(
                                " article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon"
                        )
                ).size(), 0
        );
        //Vérifier que le like a été comptabilisé
        Assert.assertEquals(
                generalobjectsmap.get("Nombre_Like_Evenement").getAttribute("innerText"),
                "1"
        );

    }
}
