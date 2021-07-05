package com.advyteam.weavin.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
        Assert.assertEquals("Annoncer une actualité",generalobjectsmap.get("Modal_ajout_news").getAttribute("innerText"));
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
        Assert.assertEquals(
                0,
                driver.findElements(
                        By.cssSelector(
                                " li > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon.ng-star-inserted"
                        )
                ).size());
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
        assertThat(generalobjectsmap.get("Modal_ajout_Article").getAttribute("innerText"), equalTo("Publier un article"));



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

    //Vérification pour calendrier et événement
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

    //Vérification pour calendrier et événement
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

    //Vérification pour calendrier et événement
    @And("l utilisateur clique sur le bouton Envoyer_Commenteraire_Modifier_Evenemeent")
    public void lUtilisateurCliqueSurLeBoutonEnvoyer_Commenteraire_Modifier_Evenemeent() {
        logger.info("l'utilisateur clique sur le bouton Envoyer_Commentaire_Modifier_Evenement");

        WebElement element = generalobjectsmap.get("Envoyer_Commenteraire_Modifier_Evenement");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }

    //Vérification pour calendrier et événement
    @Then("verifier que le commentaire de l evenement est modifié")
    public void verifierQueLeCommentaireDeLEvenementEstModifié() {
        logger.info("vérifier que le commentaire a été modifié avec succés");

        Assert.assertEquals(datastore.get("Champ_Input_Modification_Commenteraire_Evenement"),generalobjectsmap.get("Premiere_Commentaire_Evenement_Afficher").getAttribute("innerText"));


    }

    //Vérification pour calendrier et événement
    @Then("verifier que l'interaction de l évenement a été modifiée avec succés")
    public void verifierQueLInteractionDeLÉvenementAÉtéModifiéeAvecSuccés() {
        logger.info("vérifier que l'interaction a été modifiée avec succés");

        //Vérifier que l icone praise s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.inline-svg-icon.reactions-icon-statistic-PRAISE.reactions-menu__icon")).size(),0);


    }

    //Vérification pour calendrier et événement
    @Then("verifier que le commentaire de l evenement est supprimé")
    public void verifierQueLeCommentaireDeLEvenementEstSupprimé() {

        logger.info("vérifier que le commentaire a été supprimé");

        //Vérifier que l'icone commentaire ne s'affiche plus

        Assert.assertEquals(0,driver.findElements(By.cssSelector("article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")).size());

    }

    //Vérification pour calendrier et événement
    @Then("vérifier  que le like evenement a été supprimé")
    public void vérifierQueLeLikeEvenementAÉtéSupprimé() {
        logger.info("vérifier que le liké a été supprimé");

        //Vérifier que l icone LIKE ne  s'affiche
        Assert.assertEquals(driver.findElements(By.cssSelector(" article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon")).size(), 0);

    }

    // Vérification pour profil utilisateur
    @Then("vérifier que le profil de l utilisateur est affiché")
    public void vérifierQueLeProfilDeLUtilisateurEstAffiché() {

        logger.info("vérifier que le profil de l utilisateur est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Profil_username"))));
        Assert.assertTrue(generalobjectsmap.get("Profil_username").isDisplayed());
        Assert.assertEquals("Weavin Admin",generalobjectsmap.get("Profil_username").getAttribute("innerText"));

    }

    // Vérification pour profil utilisateur
    @And("l utilisateur upload photo de profil {string} dans le champs {string}")
    public void lUtilisateurUploadPhotoDeProfilDansLeChamps(String arg0, String arg1) {

        logger.info("l utilisateur upload photo de profil");

        driver.findElement(By.cssSelector(" div.author-thumb > span > span.edit-avatar > input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg"
        );

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", generalobjectsmap.get("Bouton_enregistrer_upload_image"));

        List<WebElement> specialwait = (new WebDriverWait(driver, 30)).until(
                (
                        ExpectedConditions.numberOfElementsToBe(
                                By.cssSelector(".data-sharing-container [class=ng-star-inserted]:last-child [role=progressbar]"),
                                0)
                )
        );

    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l'image est ajoutée")
    public void vérifierQueLImageEstAjoutée() {
        logger.info("vérifier que l'image est ajoutée");
        Assert.assertNotEquals(
                generalobjectsmap.get("Photo_profil_user").getAttribute("currentSrc"),
                ""
        );
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur upload photo de couverture {string} dans le champs {string}")
    public void lUtilisateurUploadPhotoDeCouvertureDansLeChamps(String arg0, String arg1) {

        logger.info("l utilisateur upload photo de couverture ");

        driver.findElement(By.cssSelector("div.top-header-thumb > span > span.edit-avatar > input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest2.jpg"
        );

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", generalobjectsmap.get("Bouton_enregistrer_upload_image"));

        List<WebElement> specialwait = (new WebDriverWait(driver, 30)).until(
                (
                        ExpectedConditions.numberOfElementsToBe(
                                By.cssSelector(".data-sharing-container [class=ng-star-inserted]:last-child [role=progressbar]"),
                                0)
                )
        );
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l'image de couverture est ajoutée")
    public void vérifierQueLImageDeCouvertureEstAjoutée() {

        logger.info("vérifier que l'image de couverture est ajoutée");
        Assert.assertNotEquals(
                generalobjectsmap.get("Photo_couverture_user").getAttribute("currentSrc"),
                ""
        );
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que la citaiton a été ajouté")
    public void vérifierQueLaCitaitonAÉtéAjouté() {
        logger.info("verifier que la citation a été ajouté");

        Assert.assertEquals(
                datastore.get("Champ_Input_Profil_Citation"),
                generalobjectsmap.get("Citation_Afficher_Profil").getAttribute("innerText")
        );

    }

    // Vérification pour profil utilisateur
    @Then("verifier que la citation a été modifiée")
    public void verifierQueLaCitationAÉtéModifiée() {
        logger.info("verifier que la citation a été modifiée");
        Assert.assertEquals(
                datastore.get("Champ_Input_Profil_Citation"),
                generalobjectsmap.get("Citation_Afficher_Profil").getAttribute("innerText")
        );

    }

    // Vérification pour profil utilisateur
    @Then("vérifier que le numéro de téléphone a été ajouté")
    public void vérifierQueLeNuméroDeTéléphoneAÉtéAjouté() {
        logger.info("verifier que le numéro de téléphone a été ajouté");
        Assert.assertEquals(
                " +216 "+datastore.get("Champ_Input_Profil_Phone"),
                generalobjectsmap.get("Phone_Afficher_Profil").getAttribute("innerText")
        );
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l auteur a été ajouté")
    public void vérifierQueLAuteurAÉtéAjouté() {
        logger.info("vérifier que l auteur a été ajouté");
        Assert.assertEquals(
                datastore.get("Champ_Input_Profil_Auteur"),
                generalobjectsmap.get("Auteur_Afficher_Profil").getAttribute("innerText")
        );
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur upload photo {string} dans l album' {string}")
    public void lUtilisateurUploadPhotoDansLAlbum(String arg0, String arg1) {

        logger.info("l utilisateur upload photo dans l album ");

        driver.findElement(By.cssSelector(" button > input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest2.jpg"
        );

    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l album a été ajouté")
    public void vérifierQueLAlbumAÉtéAjouté() throws InterruptedException {

        logger.info("vérifier que l album a été ajouté");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Description_Premier_Album"), "innerText",
                                datastore.get("Champ_Input_Description_Album"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Description_Premier_Album").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Description_Album")));
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l album a été modifié")
    public void vérifierQueLAlbumAÉtéModifié() throws InterruptedException {

        logger.info("vérifier que l album a été modifié");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Description_Premier_Album"), "innerText",
                                datastore.get("Champ_Input_Description_Album"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Description_Premier_Album").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Description_Album")));
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l album a été supprimé")
    public void vérifierQueLAlbumAÉtéSupprimé() throws InterruptedException {
        logger.info("vérifier que l album a été supprimé");

        Assert.assertNotEquals(
                datastore.get("Champ_Input_Description_Album"),
                generalobjectsmap.get("Description_Premier_Album").getAttribute("innerText")
        );
    }

    // Vérification pour profil utilisateur
    @Then("vérifier l ajout  correct du commentaire album")
    public void vérifierLAjoutCorrectDuCommentaireAlbum() throws InterruptedException {

        logger.info("vérifier l ajout  correct du commentaire album");
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

    // Vérification pour profil utilisateur
    @And("l utilisateur clique sur Entree pour l ajout de Connaissance")
    public void lUtilisateurCliqueSurEntreePourConnaissance() {
        logger.info("l utilisateur clique sur Entree pour Connaissance");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "app-tag-management.knowledge.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que connaissance a été ajouté")
    public void vérifierQueConnaissanceAÉtéAjouté() throws InterruptedException {

        logger.info("vérifier que connaissance a été ajouté");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Tag_Connaissances"), "innerText",
                                datastore.get("Champ_Input_Connaissances"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Tag_Connaissances").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Connaissances")));
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur clique sur Entree pour Loisirs")
    public void lUtilisateurCliqueSurEntreePourLoisirs() {
        logger.info("l utilisateur clique sur Entree pour Loisirs");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que loisir a été ajouté")
    public void vérifierQueLoisirsAÉtéAjouté() throws InterruptedException {
        logger.info("vérifier que loisir a été ajouté");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Tag_Loisirs"), "innerText",
                                datastore.get("Champ_Input_Loisirs"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Tag_Loisirs").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Loisirs")));
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que connaissance a été supprimé")
    public void vérifierQueConnaissanceAÉtéSupprimé() throws InterruptedException {

        logger.info("vérifier que connaissance a été supprimé");
        Assert.assertNotEquals(
                datastore.get("Champ_Input_Connaissances"),
                generalobjectsmap.get("Champ_Input_Connaissances").getAttribute("ariaLabel")
        );

    }

    // Vérification pour profil utilisateur
    @Then("vérifier que loisir a été supprimé")
    public void vérifierQueLoisirAÉtéSupprimé() {
        logger.info("vérifier que loisir a été supprimé");
        Assert.assertNotEquals(
                datastore.get("Champ_Input_Loisirs"),
                generalobjectsmap.get("Champ_Input_Loisirs").getAttribute("ariaLabel")
        );
    }


    // Vérification pour chat
    @Then("vérifier que l utilisateur a été ajouté à la liste des favoris")
    public void vérifierQueLUtilisateurAÉtéAjoutéÀLaListeDesFavoris() throws InterruptedException {
        logger.info("vérifier que l utilisateur a été ajouté à la liste des favoris");

        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Premier_utilisateur_Favoris"), "innerText",
                                "Nasser QA")));
        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Premier_utilisateur_Favoris").getAttribute("innerText"),
                equalTo("Nasser QA"));
    }

    // Vérification pour Annuaire
    @Then("vérifier que le modal de Gestion des comptes est affiché")
    public void vérifierQueLeModalDeGestionDesComptesEstAffiché() {

        logger.info("vérifier que le modal de Gestion des comptes est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Gestion_utilisateurs"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_Gestion_utilisateurs").isDisplayed());
        Assert.assertEquals("Administration > Gestion des comptes",generalobjectsmap.get("Modal_Gestion_utilisateurs").getAttribute("innerText"));

    }

    // Vérification pour Annuaire
    @Then("vérifier que le nouvel utilisateur a été ajouté")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjouté() {

        logger.info("vérifier que le nouvel utilisateur a été ajouté");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute").isDisplayed());
        Assert.assertEquals("karim.bennasr@yopmail.com",generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute").getAttribute("innerText"));

    }

    // Vérification pour Journalisation
    @And("vérifier que la publication est publié")
    public void vérifierQueLaPublicationEstPublié() throws InterruptedException {

        logger.info("vérifier que la publication est publié");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Contenu_Publication_Publié"), "innerText",
                                datastore.get("Champ_Input_Publication"))));
        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }
        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Contenu_Publication_Publié").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Publication")));
    }

    // Vérification pour Journalisation
    @Then("vérifier que le modal de Gestion des publications est affiché")
    public void vérifierQueLeModalDeGestionDesPublicationsEstAffiché() {

        logger.info("vérifier que le modal de Gestion des publications est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Gestion_publications"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_Gestion_publications").isDisplayed());
        Assert.assertEquals("Journalisation > Publications",generalobjectsmap.get("Modal_Gestion_publications").getAttribute("innerText"));

    }

    // Vérification pour Journalisation
    @Then("vérifier que la publication supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLLaPublicationSuppriméEstAffichéDansLaListeJournalisationPublications() {

        logger.info("vérifier que l la publication supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("Publication",generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));

    }

    // Vérification pour Journalisation
    @Then("vérifier que l article supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLLArticleSuppriméEstAffichéDansLaListeJournalisationPublications() {

        logger.info("vérifier que l article supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("Know'store",generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));

    }

    // Vérification pour Journalisation
    @Then("vérifier que l idée supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLIdéeSuppriméEstAffichéDansLaListeJournalisationPublications() {

        logger.info("vérifier que l article supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("Idéation",generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));


    }

    // Vérification pour Lien utile
    @Then("vérifier que le modal de création d'un lien utile est affiché")
    public void vérifierQueLeModalDeCréationDUnLienUtileEstAffiché() {

        logger.info("vérifier que le modal de création d'un lien utile est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_Lien_Utile"))));
        assertThat(generalobjectsmap.get("Modal_ajout_Lien_Utile").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_ajout_Lien_Utile").getAttribute("outerText"), equalTo("Ajouter un lien utile"));

    }

    // Vérification pour Lien utile
    @Then("Vérifier que le lien utile est publié")
    public void vérifierQueLeLienUtileEstPublié() throws InterruptedException {

        logger.info("Vérification de la publication correct du lien utile");

        //Waiting for the first publication of timeline to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_Lien_Utile"), "outerText",
                                datastore.get("Champ_Input_Titre_Lien_Utile")
                        )
                )
        );

        //Waiting for the refreshed first publication to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first publication contains the text published in the scenario
        Assert.assertEquals(
                generalobjectsmap.get("Titre_Premiere_Lien_Utile").getAttribute("outerText"),
                datastore.get("Champ_Input_Titre_Lien_Utile")
        );

    }

    // Vérification pour Lien utile
    @Then("Vérifier que le lien utile est supprimé")
    public void vérifierQueLeLienUtileEstSupprimé() throws InterruptedException {

        logger.info("Vérification de la publication correct du lien utile");

        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Titre_Premiere_Lien_Utile"))));
        assertThat(generalobjectsmap.get("Titre_Premiere_Lien_Utile").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Titre_Premiere_Lien_Utile").getAttribute("outerText"), not(equalTo(datastore.get("Champ_Input_Titre_Lien_Utile"))));

    }

    // Vérification pour Lien utile
    @And("l utilisateur Vider le champ de rechercher Lien utile")
    public void lUtilisateurViderLeChampDeRechercherLienUtile() {

        logger.info("l utilisateur Vider le champ de rechercher Lien utile");

        WebElement RechercheLienUtile = driver.findElement(
                By.cssSelector(
                        "div.useful-link-settings-header > form > div > input"
                )
        );
        RechercheLienUtile.sendKeys(Keys.ENTER);
    }

    // Vérification pour News
    @Then("Vérifier que l actualité ne s'affiche pas")
    public void vérifierQueLActualitéNeSAffichePas() throws InterruptedException {

        logger.info("Vérifier que la news rechercher ne s'affiche pas");

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
        Assert.assertNotEquals(datastore.get("Champ_Input_Titre_News"),generalobjectsmap.get("Titre_Premiere_News_publier").getAttribute("innerText"));

    }

    // Vérification pour Know'Store
    @Then("Vérifier que seulement l option supprimer existe")
    public void vérifierQueSeulementLOptionSupprimerExiste() throws InterruptedException {

        logger.info("Vérifier que seulement l option supprimer existe");

        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Bouton_supprimer_article_autre_admin"), "innerText",
                                "Supprimer")));

        synchronized (driver) {
            driver.wait(3000);
        }

        assertThat(generalobjectsmap.get("Bouton_supprimer_article_autre_admin").getAttribute("innerText"),
                equalTo("Supprimer"));
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur Vider le champ de citation")
    public void lUtilisateurViderLeChampDeCitation() {

        logger.info("l utilisateur Vider le champ de citation");

        WebElement ChampCitation = driver.findElement(
                By.xpath(
                        "//div[2]/div[1]/app-floating-label-form[1]/div[1]/textarea[1]"
                )
        );
        ChampCitation.sendKeys(Keys.NULL);
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que l input auteur ne s affiche pas")
    public void vérifierQueLInputAuteurNeSAffichePas() {

        logger.info("vérifier que l input auteur ne s affiche pasé");

        //Verifier que l'input auteur ne s'affiche
        Assert.assertEquals(
                0,
                driver.findElements(
                        By.cssSelector(
                                "div:nth-child(2) > div.form-group.col-md-4 > app-floating-label-form > div > input"
                        )
                ).size());
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur valide citation vide")
    public void lUtilisateurCliqueSurEntreePourCitation() {
        logger.info("l utilisateur valide citation vide");
        WebElement InputCitation = driver.findElement(
                By.xpath(
                        "//div[2]/div[1]/app-floating-label-form[1]/div[1]/textarea[1]"
                )
        );
        InputCitation.sendKeys(Keys.ENTER);
        InputCitation.sendKeys(Keys.BACK_SPACE);
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec envoi mail")
    public void vérifierLaCréationDuNouveauEvenementAvecEnvoiMail() {
        logger.info("vérifier la création du nouveau evenement avec envoi mail");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création evenement avec envoi de mail"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec user externe")
    public void vérifierLaCréationDuNouveauEvenementAvecUserExterne() {
        logger.info("vérifier la création du nouveau evenement avec user externe");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création évènement avec user externe"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec user externe avec envoi mail")
    public void vérifierLaCréationDuNouveauEvenementAvecUserExterneAvecEnvoiMail() {
        logger.info("vérifier la création du nouveau evenement avec user externe avec envoi de mail");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création évènement avec user externe avec envoi de mail"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement de modifcation avec user externe avec envoi mail")
    public void vérifierLaCréationDuNouveauEvenementDeModifcationAvecUserExterneAvecEnvoiMail() {
        logger.info("vérifier la création du nouveau evenement de modifcation avec user externe avec envoi mail");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Modification évènement avec user externe avec envoi de mail"));

    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement d'acceptaion")
    public void vérifierLaCréationDuNouveauEvenementDAcceptaion() {
        logger.info("vérifier la création du nouveau evenement d'acceptaion");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Accepter un évènement"));

    }

    // Vérification pour calendrier et evenements
    @Then("vérifier l acceptation de l evenement")
    public void vérifierLAcceptationDeLEvenement() {

        logger.info("vérifier l acceptation de l evenement");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Invité_Acceptation"))));
        assertThat(generalobjectsmap.get("Invité_Acceptation").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Invité_Acceptation").getAttribute("innerText"), equalTo("Accepté"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement de Refus")
    public void vérifierLaCréationDuNouveauEvenementDeRefus() {
        logger.info("vérifier la création du nouveau evenement de Refus");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Refuser un évènement"));

    }

    // Vérification pour calendrier et evenements
    @Then("vérifier le Refus de l evenement")
    public void vérifierLeRefusDeLEvenement() {
        logger.info("vérifier le Refus de l evenement");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Invité_Acceptation"))));
        assertThat(generalobjectsmap.get("Invité_Acceptation").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Invité_Acceptation").getAttribute("innerText"), equalTo("A refusé"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement d'acceptaion à partir de la notification")
    public void vérifierLaCréationDuNouveauEvenementDAcceptaionÀPartirDeLaNotification() {
        logger.info("vérifier la création du nouveau evenement d'acceptaion à partir de la notification");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Accepter un évènement à partir de la notification"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement dans le flux d'activité")
    public void vérifierLaCréationDuNouveauEvenementDansLeFluxDActivité() {
        logger.info("vérifier la création du nouveau evenement dans le flux d'activité");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Ajouter un évènement dans le flux d'activité"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier l ajout de l evenement dans le flux d'activité")
    public void vérifierLAjoutDeLEvenementDansLeFluxDActivité() {
        logger.info("vérifier l ajout de l evenement dans le flux d'activité");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Premiere_Element_Flux_Activite_Afficher"))));
        assertThat(generalobjectsmap.get("Premiere_Element_Flux_Activite_Afficher").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Premiere_Element_Flux_Activite_Afficher").getAttribute("innerText"), equalTo("Marc Parenteau vous a envoyé une invitation à un évènement ."));

    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement pour la suppression par un autre administrateur")
    public void vérifierLaCréationDuNouveauEvenementPourLaSuppressionParUnAutreAdministrateur() {
        logger.info("vérifier la création du nouveau evenement pour la suppression par un autre administrateur");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Supprimer un événement par un autre administrateur"));
    }

    // Vérification pour chat
    @Then("vérifier que la liste des favoris est vide")
    public void vérifierQueLaListeDesFavorisEstVide() throws InterruptedException {
        logger.info("vérifier que la liste des favoris est vide");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Liste_utilisateurs_Favoris"), "innerText",
                                "MEMBRES FAVORIS")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Liste_utilisateurs_Favoris").getAttribute("innerText"),
                equalTo("MEMBRES FAVORIS"));

    }

    // Vérification pour chat
    @Then("vérifier que l utilisateur chercher affiche")
    public void vérifierQueLUtilisateurChercherAffiche() throws InterruptedException {
        logger.info("vérifier que l utilisateur chercher affiche");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Utilisateur_Chercher"), "innerText",
                                "Nasser QA")));
        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Utilisateur_Chercher").getAttribute("innerText"),
                equalTo("Nasser QA"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement de refus à partir de la notification")
    public void vérifierLaCréationDuNouveauEvenementDeRefusÀPartirDeLaNotification() {
        logger.info("vérifier la création du nouveau evenement de refus à partir de la notification");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Refuser un évènement à partir de la notification"));
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que la vidéo a été ajoutée")
    public void vérifierQueLaVidéoAÉtéAjoutée() throws InterruptedException {
        logger.info("vérifier que la vidéo a été ajoutée");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Description_Premier_vidéo"), "innerText",
                                datastore.get("Champ_Input_Description_Vidéo"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Description_Premier_vidéo").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Description_Vidéo")));
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur upload video {string} dans le champs {string}")
    public void lUtilisateurUploadVideoDansLeChamps(String arg0, String arg1) {
        logger.info("l utilisateur upload video dans profil utilisateur ");
        driver.findElement(By.cssSelector("div:nth-child(2) > div > input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest2.mp4"
        );
        List<WebElement> specialwait = (new WebDriverWait(driver, 100)).until(
                (ExpectedConditions.numberOfElementsToBe(
                        By.cssSelector("div.d-inline-block.pull-right.progress-video-bar.ng-star-inserted > div"),
                        0)
                )
        );
    }

    // Vérification pour profil utilisateur
    @Then("vérifier que la photo a été ajouté")
    public void vérifierQueLaPhotoAÉtéAjouté() throws InterruptedException {
        logger.info("vérifier que la photo a été ajouté");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Description_Premier_vidéo"), "innerText",
                               "Marc Parenteau Album")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Description_Premier_vidéo").getAttribute("innerText"),
                equalTo("Marc Parenteau Album"));
    }

    // Vérification pour profil utilisateur
    @And("l utilisateur ajoute la photo {string} dans le champs {string}")
    public void lUtilisateurAjouteLaPhotoDansLeChamps(String arg0, String arg1) {
        logger.info("l utilisateur upload photo dans profil utilisateur ");
        driver.findElement(By.cssSelector("button > input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg"
        );
    }

    // Vérification pour chat
    @Then("vérifier que le message a été reçu avec succes")
    public void vérifierQueLeMessageAÉtéReçuAvecSucces() throws InterruptedException {
        logger.info("vérifier que le message a été reçu avec succes");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Message_reçu"), "innerText",
                                "Message Texte de Test")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Message_reçu").getAttribute("innerText"),
                equalTo("Message Texte de Test"));
    }

    // Vérification pour chat
    @And("l utilisateur upload photo {string} dans le chat {string}")
    public void lUtilisateurUploadPhotoDansLeChat(String arg0, String arg1) {
        logger.info("l utilisateur upload photo dans le chat");

        driver.findElement(By.cssSelector("#media-chat")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest4.jpg"
        );
    }


    // Vérification pour chat
    @Then("vérifier que le message image a été reçu avec succes")
    public void vérifierQueLeMessageImageAÉtéReçuAvecSucces() throws InterruptedException {
        logger.info("vérifier que le message image a été reçu avec succes");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Message_reçu"), "innerText",
                                "Message Image de Test")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Message_reçu").getAttribute("innerText"),
                equalTo("Message Image de Test"));
    }

    // Vérification pour chat
    @And("l utilisateur upload fichier {string} dans le chat {string}")
    public void lUtilisateurUploadFichierDansLeChat(String arg0, String arg1) {
        logger.info("l utilisateur upload fichier dans le chat");
        driver.findElement(By.cssSelector("#file-chat")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/FichierTest.pdf"
        );
    }

    // Vérification pour chat
    @Then("vérifier que le message fichier a été reçu avec succes")
    public void vérifierQueLeMessageFichierAÉtéReçuAvecSucces() throws InterruptedException {
        logger.info("vérifier que le message fichier a été reçu avec succes");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Message_reçu"), "innerText",
                                "Message Fichier de Test")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Message_reçu").getAttribute("innerText"),
                equalTo("Message Fichier de Test"));
    }

    // Vérification pour chat
    @Then("vérifier que le message video a été reçu avec succes")
    public void vérifierQueLeMessageVideoAÉtéReçuAvecSucces() throws InterruptedException {
        logger.info("vérifier que le message video a été reçu avec succes");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Message_reçu"), "innerText",
                                "Message Vidéo de Test")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Message_reçu").getAttribute("innerText"),
                equalTo("Message Vidéo de Test"));
    }

    // Vérification pour chat
    @And("l utilisateur upload video {string} dans le chat {string}")
    public void lUtilisateurUploadVideoDansLeChat(String arg0, String arg1) {
        logger.info("l utilisateur upload video dans chat ");
        driver.findElement(By.cssSelector("#media-chat")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest2.mp4"
        );
        /* List<WebElement> specialwait = (new WebDriverWait(driver, 100)).until(
                (ExpectedConditions.numberOfElementsToBe(
                        By.cssSelector("div.d-inline-block.pull-right.progress-video-bar.ng-star-inserted > div"),
                        0)
                )
        );*/
    }

    // Vérification pour calendrier et evenements
    @And("l utilisateur clique sur Entree pour l ajout de choix")
    public void lUtilisateurCliqueSurEntreePourLAjoutDeChoix() {

        logger.info("l utilisateur clique sur Entree pour l ajout de choix");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour calendrier et evenements
    @And("l utilisateur clique sur Entree pour l ajout de case")
    public void lUtilisateurCliqueSurEntreePourLAjoutDeCase() {
        logger.info("l utilisateur clique sur Entree pour l ajout de case");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "#options-value5 > div > div > tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec formulaire")
    public void vérifierLaCréationDuNouveauEvenementAvecFormulaire() {
        logger.info("vérifier la création du nouveau evenement avec formulaire");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création evenement avec formulaire d'inscription pour utilisateur interne"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la réception de l'invitation")
    public void vérifierLaRéceptionDeLInvitation() throws InterruptedException {
        logger.info("vérifier la réception de l'invitation");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Premiere_Notification_Evenement_Afficher"), "innerText",
                                "Marc Parenteau vous a envoyé une invitation à un événement ")));

        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Premiere_Notification_Evenement_Afficher").getAttribute("innerText"),
                equalTo("Marc Parenteau vous a envoyé une invitation à un événement "));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement de refus avec formulaire")
    public void vérifierLaCréationDuNouveauEvenementDeRefusAvecFormulaire() {
        logger.info("vérifier la création du nouveau evenement de refus avec formulaire");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique refus evenement avec formulaire d'inscription pour utilisateur interne"));
    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec formulaire pour user externe")
    public void vérifierLaCréationDuNouveauEvenementAvecFormulairePourUserExterne() {
        logger.info("vérifier la création du nouveau evenement avec formulaire pour user externe");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique création evenement avec formulaire d'inscription pour utilisateur externe"));

    }

    // Vérification pour annuaire
    @And("l utilisateur clique sur Entree pour ajout Loisirs")
    public void lUtilisateurCliqueSurEntreePourAjoutLoisirs() {
        logger.info("l utilisateur clique sur Entree pour ajout Loisirs");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "div.col.col-xl-6.order-xl-36.col-lg-6.order-lg-3.col-md-6.col-sm-6.col-12.ng-star-inserted > app-tag-management > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour annuaire
    @And("l utilisateur clique sur Entree pour ajout de Connaissance")
    public void lUtilisateurCliqueSurEntreePourAjoutDeConnaissance() {
        logger.info("l utilisateur clique sur Entree pour ajout Connaissance");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "div.col.col-xl-6.order-xl-6.col-lg-6.order-lg-3.col-md-6.col-sm-6.col-12.ng-star-inserted > app-tag-management > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour annuaire
    @And("l utilisateur clique sur Entree pour le champ recherche")
    public void lUtilisateurCliqueSurEntreePourLeChampRecherche() {
        logger.info("l utilisateur clique sur Entree pour le champ recherche");
        WebElement TagConnaissance = driver.findElement(
                By.cssSelector(
                        "app-text-input > div > input"
                )
        );
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour Know'Store
    @Then("verifier que pas d article rechercher a afficher par date de fin inférieure à date de début")
    public void verifierQuePasDArticleRechercherAAfficherParDateDeFinInférieureÀDateDeDébut() {
        logger.info("verifier que pas d article rechercher a afficher par date de fin inférieure à date de début");
    }

    // Vérification pour annuaire
    @Then("verifier que la carte visite de l'utilisateur{string} n apparait pas dans l annuaire")
    public void verifierQueLaCarteVisiteDeLUtilisateurNApparaitPasDansLAnnuaire(String nom) {
        logger.info("vérifier que la carte visite de l'utilisateur "+nom+" n'apparait pas dans l'annuaire");

        //La liste des cartes de visite doit etre null

        Assert.assertEquals(0,driver.findElements(By.xpath("//div[2]/div[1]/div/div/div/div[2]/div[1]/a")).size());

    }

    // Vérification pour annuaire
    @Then("verifier que la carte visite de l'utilisateur {string} s affiche")
    public void verifierQueLaCarteVisiteDeLUtilisateurSAffiche(String nom) {
        logger.info("verifier que la carte visite s'affiche");

        Assert.assertTrue(generalobjectsmap.get("Nom_premier_utilisateur_Afficher_Annuaire").getAttribute("innerText").contains(nom));


    }

    // Vérification pour opportunite
    @Then("verifier que l opportunite a ete ajoute")
    public void verifierQueLOpportuniteAEteAjoute() {
        logger.info("verifier que l'opportnité a été ajoutée");

        Assert.assertEquals(datastore.get("Nom_Categorie_Opportunite_Menu_Gauche"),generalobjectsmap.get("titre_premiere_opportunite_afficher").getAttribute("innerText"));

    }

    // Vérification pour opportunite
    @Then("verifier que l opportunite a ete modifie")
    public void verifierQueLOpportuniteAEteModifie() {
        logger.info("verifier que l'opportnité a été modifie");


        Assert.assertEquals(datastore.get("Description_Categorie_Opportunite"),generalobjectsmap.get("Description_Categorie_Opportunite_Menu_Gauche").getAttribute("innerText"));


    }

    // Vérification pour opportunite
    @Then("vérifer que L admin ne peut pas modifier l oportunité")
    public void vériferQueLAdminNePeutPasModifierLOportunité() {
        logger.info("verifier l'admin ne peut pas modifier l'opportunité");

        Boolean trouve=false;

        for (WebElement element : driver.findElements(By.cssSelector("div.dropdown-menu.show > button"))) {

            if (element.getText().equalsIgnoreCase(" Éditer ")) {
                trouve=true;
                break;
            }
        }

        Assert.assertFalse(trouve);

    }

}
