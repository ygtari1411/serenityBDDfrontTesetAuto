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
/*
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
        //Assert.assertEquals(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"),datastore.get("champ_statut"));
        Assert.assertTrue(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText").contains(datastore.get("champ_statut")));
*/

        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Texte_Premiere_Publication_Timeline"), "innerText",
                                datastore.get("champ_statut")+"\n")));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news contains the text published in the scenario
        Assert.assertEquals(datastore.get("champ_statut")+"\n",generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"));



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
        Boolean specialwait = (new WebDriverWait(driver, 300)).until(ExpectedConditions.refreshed
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
        Assert.assertNotEquals(driver.findElements(By.cssSelector("span.likes-number.ml-sm")).size(),0);

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
    @Then("vérifier que le dislike a été effectué")
    public void vérifierQueLeDislikeAÉtéEffectué() {
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

        int   LastValue  =Integer.parseInt( (driver.findElement(By.xpath("//section/app-list/div[3]/div[3]/app-post-card-ideation/div/article/div[2]/div[5]/div/span")).getAttribute("innerText")).trim() ) ;
        List<WebElement> elements = driver.findElements(By.xpath("//section/app-list/div[3]/div[*]/app-post-card-ideation/div/article/div[2]/div[5]/div/span"));
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

        int   LastValue  =Integer.parseInt( (driver.findElement(By.xpath("//section/app-list/div[3]/div[3]/app-post-card-ideation/div/article/div[2]/div[5]/div/span")).getAttribute("innerText")).trim() ) ;
        List<WebElement> elements = driver.findElements(By.xpath("//section/app-list/div[3]/div[*]/app-post-card-ideation/div/article/div[2]/div[5]/div/span"));
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

        Assert.assertEquals(driver.findElements(By.cssSelector(".invalid-feedback .error-box")).size(),3);

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
        Assert.assertNotEquals(driver.findElements(By.cssSelector(".page-has-right-panels app-root app-layout-portal div.container.wrapper-portal app-useful-information section.blog-post-wrap app-useful-information-detail div.container div.row.mt20 div.col.col-xl-8.col-lg-12.col-md-12.col-sm-12.col-12 div.ui-block article.hentry.blog-post.single-post.single-post-v3 div.post-additional-info.inline-items app-post-statistics div.lists-reactions-statistic ul li.pl-lg a")).size(),0);
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

        Assert.assertTrue(generalobjectsmap.get("Premiere_Notification_Afficher").getAttribute("innerText").contains("a réagi a votre article"));
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
        Assert.assertNotEquals(driver.findElements(By.cssSelector("div > a > span.reactions-icon-md-PRAISE.reactions-menu__icon")).size(),0);


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
        Assert.assertEquals("Nouveau", generalobjectsmap.get("Temoin_Premiere_News_Affichee_accueil").getAttribute("innerText"));
    }

    // Vérification pour News
    @And("l utilisateur clique sur la derniere news ajoutee")
    public void lUtilisateurCliqueSurLaDerniereNewsAjoutee() {
        logger.info("l utilisateur clique sur la derniere news ajoutee");
        String str= datastore.get("Champ_Input_Titre_News");
        Boolean modules = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(
                        By.cssSelector("*>div:nth-child(3) > div > div:nth-child(2) > app-post-card-news > div"),
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
        Assert.assertEquals(0,driver.findElements(By.cssSelector("l > li:nth-child(1) > div > a > span.reactions-menu__icon.reactions-icon-md-LIKE")).size());



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
        Assert.assertNotEquals(driver.findElements(By.cssSelector(" span.inline-svg-icon.reactions-icon-statistic-PRAISE.reactions-menu__icon")).size(),0);


    }

    //Vérification pour calendrier et événement
    @Then("verifier que le commentaire de l evenement est supprimé")
    public void verifierQueLeCommentaireDeLEvenementEstSupprimé() {

        logger.info("vérifier que le commentaire a été supprimé");

        //Vérifier que l'icone commentaire ne s'affiche plus

        Assert.assertEquals(0,driver.findElements(By.cssSelector("article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")).size());

    }

    //Vérification pour calendrier et événement
    @Then("vérifier  que le like a été supprimé")
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
        Assert.assertEquals("Marc Parenteau",generalobjectsmap.get("Profil_username").getAttribute("innerText"));

    }

    // Vérification pour profil utilisateur
    //Upload Method
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
    //Upload Method
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
    //Upload Method
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
                                "Mohamed Ennaceur Ben Yedder")));
        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Premier_utilisateur_Favoris").getAttribute("innerText"),
                equalTo("Mohamed Ennaceur Ben Yedder"));
    }

    // Vérification pour Annuaire
    @Then("vérifier que le modal de Gestion des comptes est affiché")
    public void vérifierQueLeModalDeGestionDesComptesEstAffiché() {

        logger.info("vérifier que le modal de Gestion des comptes est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Gestion_utilisateurs"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_Gestion_utilisateurs").isDisplayed());
        Assert.assertEquals("Utilisateurs > Gestion des comptes",generalobjectsmap.get("Modal_Gestion_utilisateurs").getAttribute("innerText"));

    }

    // Vérification pour Annuaire nom
    @Then("vérifier que le nouvel utilisateur a été ajouté par nom")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjoutéParNom() {

        logger.info("vérifier que le nouvel utilisateur a été ajouté");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").isDisplayed());
        //Assert.assertEquals("Bennasr",generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText"));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText").contains("Bennasr"));
    }
    // Vérification pour Annuaire Prénom
    @Then("vérifier que le nouvel utilisateur a été ajouté par prénom")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjoutéParPrenom() {

        logger.info("vérifier que le nouvel utilisateur a été ajouté");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").isDisplayed());
        //Assert.assertEquals("Bennasr",generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText"));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText").contains("Karim"));

    }
    // Vérification pour Annuaire nom et prénom
    @Then("vérifier que le nouvel utilisateur a été ajouté par nom et prénom")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjoutéParNomEtPrenom() {

        logger.info("vérifier que le nouvel utilisateur a été ajouté");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").isDisplayed());
        //Assert.assertEquals("Bennasr",generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText"));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText").contains("Karim Bennasr"));
    }

    // Vérification pour Journalisation
    @And("vérifier que la publication est publié")
    public void vérifierQueLaPublicationEstPublié() throws InterruptedException {

        logger.info("vérifier que la publication est publié");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Contenu_Publication_Publié"), "innerText",
                                datastore.get("Champ_Input_Publication")+"\n")));
        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }
        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Contenu_Publication_Publié").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Publication")+"\n"));
    }

    // Vérification pour Journalisation
    @Then("vérifier que le modal de Gestion des publications est affiché")
    public void vérifierQueLeModalDeGestionDesPublicationsEstAffiché() {

        logger.info("vérifier que le modal de Gestion des publications est affiché");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Gestion_publications"))));
        Assert.assertTrue(generalobjectsmap.get("Modal_Gestion_publications").isDisplayed());
        Assert.assertEquals("Corbeille > Publications",generalobjectsmap.get("Modal_Gestion_publications").getAttribute("innerText"));

    }

    // Vérification pour Journalisation
    @Then("vérifier que la publication supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLLaPublicationSuppriméEstAffichéDansLaListeJournalisationPublications() {

        logger.info("vérifier que l la publication supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé"))));
        Assert.assertTrue(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé").isDisplayed());
        Assert.assertTrue(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé").getAttribute("innerText").contains("test automatisé Supprimer une publication\n"));

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
                                "Mohamed Ennaceur Ben Yedder")));
        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Utilisateur_Chercher").getAttribute("innerText"),
                equalTo("Mohamed Ennaceur Ben Yedder"));
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
    //Upload Method
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
    //Upload Method
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
     /*   Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Message_reçu"), "innerText",
                                "Vu Message Texte par destinataire")));
  */
        synchronized (driver) {
            driver.wait(3000);
        }
        assertThat(generalobjectsmap.get("Message_reçu").getAttribute("innerText"),
                equalTo("Message Texte de Test"));
    }



    // Vérification pour chat
    //Upload Method
    @And("l utilisateur upload photo {string} dans le chat {string}")
    public void lUtilisateurUploadPhotoDansLeChat(String arg0, String arg1) {
        logger.info("l utilisateur upload photo dans le chat");

       /* driver.findElement(By.cssSelector("div.options-chat-item.col-lg-12.p0.pull-left > div > div > a:nth-child(2) > svg > use")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg"
        );*/
        driver.findElement(By.cssSelector("#media-chat")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg"
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
    //Upload Method
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
    //Upload Method
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

        Assert.assertEquals(
                datastore.get("Champ_input_titre_Opportunite"),
                generalobjectsmap.get("titre_premiere_opportunite_afficher").getAttribute("innerText")
        );

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

    // Vérification pour opportunite
    @Then("vérifier que le like a ete comptabilise")
    public void vérifierQueLeLikeAEteComptabilise() {
        logger.info("verifier que le like a été comptabilisé");

        Assert.assertEquals("1",generalobjectsmap.get("Nombre_Like_Premiere_Opportunite_Afficher").getAttribute("innerText"));

    }

    // Vérification pour opportunite
    @Then("vérifier que le commentaire a ete comptabilise")
    public void vérifierQueLeCommentaireAEteComptabilise() {
        logger.info("verifier que le commentaire a été comptabilisé");

        Assert.assertEquals(" 1",generalobjectsmap.get("Nombre_Commentaire_Premiere_Opportunite_Afficher").getAttribute("innerText"));


    }

    // Vérification pour opportunite
    @Then("verifier que l opportunite a ete supprime")
    public void verifierQueLOpportuniteAEteSupprime() {
        logger.info("verifier que l'opportnité a été supprimée");

        Assert.assertNotEquals(datastore.get("Description_Categorie_Opportunite"),generalobjectsmap.get("Description_Categorie_Opportunite_Menu_Gauche").getAttribute("innerText"));


    }

    // Vérification pour opportunite
    @Then("verifier que le role utilisateur ne peut pas supprimer une opportunite")
    public void verifierQueLeRoleUtilisateurNePeutPasSupprimerUneOpportunite() {
        logger.info("verifier que le role utilisateur ne peut pas supprimer une opportunite");

        Boolean trouve=false;

        for (WebElement element : driver.findElements(By.cssSelector("div.dropdown-menu.show > button"))) {

            if (element.getText().equalsIgnoreCase("Supprimer")) {
                trouve=true;
                break;
            }
        }

        Assert.assertFalse(trouve);

    }

    // Vérification pour anniversaire
    @Then("vérifier que la date d anniversaire a été ajoutée")
    public void vérifierQueLaDateDAnniversaireAÉtéAjoutée() {
        logger.info("verifier que la date d anniversaire  a été ajoutée");
        Assert.assertEquals(
                "6 Août 1996",
                generalobjectsmap.get("Anniversaire_Afficher_Profil").getAttribute("innerText")
        );
    }

    // Vérification pour BrainStorming
    @Then("verifier que le vote a ete ajoute avec succes")
    public void verifierQueLeVoteAEteAjouteAvecSucces() {
        logger.info("verifier que le vote a été ajouté");

        Assert.assertEquals(datastore.get("Champ_Input_Titre_BrainStorming"),generalobjectsmap.get("Description_Premier_Vote_Afficher").getAttribute("innerText"));

    }

    // Vérification pour BrainStorming
    @Then("verefier que le vote a ete modifier")
    public void verefierQueLeVoteAEteModifier() {
        logger.info("verifier que le vote a été modifié");
        Assert.assertEquals(datastore.get("Champ_Input_Titre_BrainStorming"),generalobjectsmap.get("Description_Premier_Vote_Afficher").getAttribute("innerText"));
    }

    // Vérification pour BrainStorming
    @Then("verifier que le vote a ete supprime")
    public void verifierQueLeVoteAEteSupprime() {
        logger.info("verifier que le vote a été supprimé");

        Assert.assertNotEquals(datastore.get("Champ_Input_Titre_BrainStorming"),generalobjectsmap.get("Description_Premier_Vote_Afficher").getAttribute("innerText"));
    }

    // Vérification pour BrainStorming
    @Then("verifier que le vote est lance")
    public void verifierQueLeVoteEstLance() {
        logger.info("verifier que le vote a été lancé");
        Assert.assertEquals("Ouvert",generalobjectsmap.get("Etat_Premier_Vote_Afficher").getAttribute("innerText"));
    }

    // Vérification pour BrainStorming
    @Then("verifier que le vote est comptabilse")
    public void verifierQueLeVoteEstComptabilse() {
        logger.info("verifier que le vote a été comptabilisé");
        Assert.assertEquals("Nous vous remercions pour votre participation au vote",generalobjectsmap.get("Accuser_De_reception_Brainstorming").getAttribute("innerText"));
    }

    // Vérification pour BrainStorming
    @Then("verifier que le cote a ete cloture")
    public void verifierQueLeCoteAEteCloture() {
        logger.info("verifier que le vote a été cloturé");
        Assert.assertEquals("Clôturé",generalobjectsmap.get("Etat_Premier_Vote_Afficher").getAttribute("innerText"));



    }

    // Vérification pour Flash Info
    @And("verifier que la flash info apparait pour les autre utilisateur")
    public void verifierQueLaFlashInfoApparaitPourLesAutreUtilisateur() {
        logger.info("verifier que la flash info apparait pour les autres utilisateurs");
        Assert.assertEquals(datastore.get("titre_flash_info"),generalobjectsmap.get("Premiere_Flash_Info_Ajouter").getAttribute("innerText"));

    }

    // Vérification pour Flash Info
    @Then("verifier que la flash info afficher est c elle qui est rechercher")
    public void verifierQueLaFlashInfoAfficherEstCElleQuiEstRechercher() {
        logger.info("verifier que la flash Afficher qui est rechercher");
        Assert.assertEquals(datastore.get("titre_flash_info"),generalobjectsmap.get("Flash_Info_Rechercher").getAttribute("innerText"));


    }

    // Vérification pour Flash Info
    @Then("verifier que la flash info a ete supprime")
    public void verifierQueLaFlashInfoAEteSupprime() {
        logger.info("verifier que la flash info a ete supprime");
        Assert.assertNotEquals(datastore.get("titre_flash_info"),generalobjectsmap.get("Premiere_Flash_Info_Ajouter").getAttribute("innerText"));

    }


    // Vérification pour gestion des utilisateurs
    @Then("vérifier que l utilisateur a été modifié")
    public void vérifierQueLUtilisateurAÉtéModifié() {

        logger.info("vérifier que l utilisateur a été modifié");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Nom_utilisateur_Modifiee"))));
        Assert.assertTrue(generalobjectsmap.get("Nom_utilisateur_Modifiee").isDisplayed());
        Assert.assertEquals("Muhammad Karim Ben nasr",generalobjectsmap.get("Nom_utilisateur_Modifiee").getAttribute("innerText"));

    }

    // Vérification pour gestion des utilisateurs
    @Then("vérifier que l email d utilisateur a été modifié")
    public void vérifierQueLEmailDUtilisateurAÉtéModifié() {

        logger.info("vérifier que l email d utilisateur a été modifié");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute").isDisplayed());
        Assert.assertEquals("muhammadkarim.bennasr@yopmail.com",generalobjectsmap.get("Email_Nouvel_utilisateur_Ajoute").getAttribute("innerText"));

    }

    // Vérification pour gestion des utilisateurs
    @Then("vérifier que le utilisateur a été desactivé")
    public void vérifierQueLeUtilisateurAÉtéDesactivé() {

        logger.info("vérifier que le utilisateur a été desactivé");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Email_utilisateur_desactive"))));
        Assert.assertTrue(generalobjectsmap.get("Email_utilisateur_desactive").isDisplayed());
        Assert.assertEquals("yassine.gtari@advyteam.com",generalobjectsmap.get("Email_utilisateur_desactive").getAttribute("innerText"));

    }

    //Verfification pour opportunité
    @Then("verifier que les catégories afficher sont c elles qui sont choisis")
    public void verifierQueLesCatégoriesAfficherSontCEllesQuiSontChoisis() {
        logger.info("verifier que les catégories afficher sont c elles qui sont choisis");

        List<WebElement> list = driver.findElements(By.xpath("//app-post-card-opportunity/div/article/div[2]/div[1]/a[1]"));

        boolean trouve = true;

        for (WebElement element : list) {

            if (element.getAttribute("innerText").equalsIgnoreCase("OPPORTUNITÉ")) {
                trouve = true;
            } else {
                trouve = false;
            }

        }

        Assert.assertTrue(trouve);
    }

    //Journalisation
    @Then("vérifier que l evenement supprimé est affiché dans la liste corbeille publications")
    public void vérifierQueLEvenementSuppriméEstAffichéDansLaListeJournalisationPublications() {
        logger.info("vérifier que l evenement supprimé est affiché dans la liste corbeille publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("Calendrier et évènements",generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));

    }

    //Timeline
    //Upload Method
    @And("l utilisateur ajoute une photo a la time line")
    public void lUtilisateurAjouteUnePhotoALaTimeLine() throws InterruptedException {
        logger.info("l utilisateur ajoute une photo a la time line");

        //generalobjectsmap.get("Input_Media_TImeLine").sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg") ;
        driver.findElement(By.xpath("//*[@id=\"streamlineShareBoxImages\"]")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg");
    }

    //Timeline
    //Upload Method
    @And("l utilisateur ajoute une video a la time line")
    public void lUtilisateurAjouteUneVideoALaTimeLine() {
        logger.info("l utilisateur ajoute une video a la time line");
        //generalobjectsmap.get("Input_Media_TImeLine").sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest2.mp4") ;
        driver.findElement(By.xpath("/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/app-stream-line-post-form/div/div/form/div[2]/div/a/input")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest2.mp4");
    }

    //Compagne de Don
    @Then("vérifier que le modal de création d'un don est affiché")
    public void vérifierQueLeModalDeCréationDUnDonEstAffiché() {
        logger.info("Vérification de l'affichage du modal de création d'un don");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_ajout_Don"))));
        assertThat(generalobjectsmap.get("Modal_ajout_Don").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_ajout_Don").getAttribute("innerText"), equalTo("Créez votre campagne de dons"));



    }

    //Compagne de Don
    @And("l utilisateur ajoute une photo de couverture pour la compagne de don")
    public void lUtilisateurAjouteUnePhotoDeCouverturePourLaCompagneDeDon() throws InterruptedException {
        logger.info("L'utilisateur ajoute une photo de couverture a la compagne de don");

        JavascriptExecutor executor = (JavascriptExecutor)driver;


        executor.executeScript("document.getElementById('bg-cover-file-compaign').removeAttribute('hidden');");
        driver.findElement(By.id("bg-cover-file-compaign")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg");
        synchronized (driver) {
            driver.wait(1000);
        }
        executor.executeScript("arguments[0].click();", generalobjectsmap.get("Bouton_enregistrer_upload_image"));


    }

    //Compagne de Don
    @Then("verifier que la campagne de don et creer et lancer")
    public void verifierQueLaCampagneDeDonEtCreerEtLancer() {
        logger.info("Vérifier que la campagne e don est créer et lancer");

        Assert.assertEquals(generalobjectsmap.get("Etat_Compagne_Don").getAttribute("innerText"),"Collectés:");

    }

    //TimeLine
    //Upload Method
    @And("l utilisateur ajoute une piece jointe a la time line")
    public void lUtilisateurAjouteUnePieceJointeALaTimeLine() {
        logger.info("l utilisateur ajoute une piece jointe a la time line");

        //generalobjectsmap.get("Input_Media_TImeLine").sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imageTest4.jpg") ;
        driver.findElement(By.xpath("//*[@id=\"streamlineShareBoxImages\"]")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/FichierTest.pdf");


    }

    // Vérification pour calendrier et evenements
    @Then("vérifier la création du nouveau evenement avec formulaire pour l acceptation")
    public void vérifierLaCréationDuNouveauEvenementAvecFormulairePourLAcceptation() {
        logger.info("vérifier la création du nouveau evenement avec formulaire pour user externe");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Modal_Evenement"))));
        assertThat(generalobjectsmap.get("Modal_Evenement").isDisplayed(), IsEqual.equalTo(true));
        assertThat(generalobjectsmap.get("Modal_Evenement").getAttribute("innerText"), equalTo("Test automatique Acceptation evenement avec formulaire d'inscription pour utilisateur interne"));

    }

    // Vérification pour team lab
    @Then("verifier que la bulle a ete ajoutee")
    public void verifierQueLaBulleAEteAjoutee() throws InterruptedException {

        logger.info("verifier que la bulle a ete ajoutee");

        //Waiting for the first album to refresh
       /* Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Bulle_Rechercher"), "innerText",
                                datastore.get("Champ_Input_Name_Bulle"))));
         */
        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Bulle_Rechercher").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Name_Bulle")));
    }

    // Vérification pour team lab
    @Then("verifier que la bulle a ete modifie")
    public void verifierQueLaBulleAEteModifie() throws InterruptedException {
        logger.info("verifier que la bulle a ete modifie");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Bulle_Page"), "innerText",
                                datastore.get("Champ_Input_Name_Bulle"))));

        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Titre_Bulle_Page").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Name_Bulle")));
    }

    // Vérification pour team lab
    @And("l utilisateur clique sur Entree pour l envoi de message")
    public void lUtilisateurCliqueSurEntreePourLEnvoiDeMessage() {
        logger.info("l utilisateur clique sur Entree pour l envoi de message");

        WebElement TagConnaissance = driver.findElement(By.cssSelector("#textInput"));
        TagConnaissance.sendKeys(Keys.ENTER);
    }

    // Vérification pour team lab
    @Then("vérifier l ajout correct du Like Bulle")
    public void vérifierLAjoutCorrectDuLikeBulle() {

        logger.info("vérifier l ajout correct du Like Bulle");
        //Vérifier que l icone (y) s'affiche
        Assert.assertNotEquals(driver.findElements(By.cssSelector("#reaction62 > ul > li:nth-child(1) > img")).size(),0);
        //Vérifier que le like a été comptabilisé
        Assert.assertEquals(generalobjectsmap.get("Nombre_Like_Message_Bulle").getAttribute("innerText"),"1");

    }

    // Vérification pour team lab
    @And("l utilisateur upload fichier {string} dans le messgae Bulle {string}")
    public void lUtilisateurUploadFichierDansLeMessgaeBulle(String arg0, String arg1) {
        logger.info("l utilisateur upload fichier dans le message bulle");
        driver.findElement(By.cssSelector("#modal-uplaod-photo > div > div > div.modal-body > a")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/FichierTest.pdf"
        );
    }

    // Vérification pour team lab
    @And("l utilisateur upload video {string} dans le message Bulle {string}")
    public void lUtilisateurUploadVideoDansLeMessageBulle(String arg0, String arg1) {
        logger.info("l utilisateur upload video dans le message Bulle ");
        driver.findElement(By.cssSelector("#create-photo-album > div > div > div.modal-body > div > div > div > div > a > svg")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/VideoTest2.mp4"
        );
    }

    // verifications profil utilisateur
    @Then("vérifier l ajout correct du Like album")
    public void vérifierLAjoutCorrectDuLikeAlbum() {
        logger.info("vérifier  que le like evenement a été ajouté");
        //Vérifier que l icone LIKE s'affiche
        Assert.assertNotEquals(
                driver.findElements(
                        By.cssSelector(
                                "span.likes-number.ml-sm"
                        )
                ).size(), 0
        );
        //Vérifier que le like a été comptabilisé
        Assert.assertEquals(
                generalobjectsmap.get("Nombre_Like_Album").getAttribute("innerText"),
                "1"
        );
    }

    @Then("vérifier que la photo de profil supprimé est affiché dans la liste corbeille publications")
    public void vérifierQueLaPhotoSuppriméEstAffichéDansLaListeCorbeillePublications() {

        logger.info("vérifier que la photo de profil supprimé est affiché dans la liste corbeille publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("publication",generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));

    }

    //Vérification pour TimeLine
    @Then("Vérifier que le statut est modifié")
    public void vérifierQueLeStatutEstModifié() throws InterruptedException {
        logger.info("vérifier que le statut est modifié");

        //Waiting for the first publication of timeline to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Texte_Premiere_Publication_Timeline"), "innerText",
                                datastore.get("champ_statut_modification"))));

        //Waiting for the refreshed first publication to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first publication contains the text published in the scenario
        //Assert.assertEquals(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"),datastore.get("champ_statut"));
        Assert.assertTrue(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText").contains(datastore.get("champ_statut_modification")));



    }

    //Vérification pour TimeLine
    @Then("Vérifier que le statut est supprime")
    public void vérifierQueLeStatutEstSupprime() throws InterruptedException {
        logger.info("vérifier que le statut est supprimé");

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
        //Assert.assertEquals(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText"),datastore.get("champ_statut"));
        Assert.assertFalse(generalobjectsmap.get("Texte_Premiere_Publication_Timeline").getAttribute("innerText").contains(datastore.get("champ_statut")));



    }

    //Vérification pour TimeLine
    @Then("verifier que le commentaire et le like du statut on ete ajoute")
    public void verifierQueLeCommentaireEtLeLikeDuStatutOnEteAjoute() {
        logger.info("vérifier que le commentaire et le like on été ajouté");

        Assert.assertEquals(driver.findElements(By.cssSelector("div:nth-child(1) > app-post > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(2) > a > svg > use")).size(),1);
        //Assert.assertEquals(driver.findElements(By.cssSelector("inline-svg-icon reactions-icon-statistic-LIKE reactions-menu__icon")).size(),1);

    }

    // Vérification pour TimeLine
    @Then("verifier que le tag a ete ajoute")
    public void verifierQueLeTagAEteAjoute() {
        logger.info("vérifier que le tag est ajoute");

        Assert.assertEquals(driver.findElements(By.cssSelector("#newsfeed-items-grid > div:nth-child(1) > app-post > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")).size(),1);

        //Assert.assertEquals(driver.findElements(By.cssSelector("div:nth-child(1) > app-post > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(2) > a > svg > use")).size(),1);
    }

    //Vérification pour TimeLine
    @Then("verifier que le commentaire a ete supprime avec success")
    public void verifierQueLeCommentaireAEteSupprimeAvecSuccess() {
        logger.info("vérifier que le commentaire a été supprimé");

        Assert.assertEquals(driver.findElements(By.cssSelector("olymp-chat---messages-icon inline-svg-icon")).size(),0);

    }

    //Vérification pour TimeLine
    //Upload Method
    @And("l utilisateur change le format de publication")
    public void lUtilisateurChangeLeFormatDePublication() {
        logger.info("l'utilisateur change le format de la publication");

        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-modal-update-post/app-stream-line-post-form/div/div/form/div[2]/div[1]/a/input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg"
        );



    }

    //Vérification pour TimeLine
    @Then("verifier que le commentaire a ete modifier avec success")
    public void verifierQueLeCommentaireAEteModifierAvecSuccess() {
        logger.info("verifier le changement de l'interaction");

        Assert.assertTrue(generalobjectsmap.get("premier_commentaire_afficher_time_line").getAttribute("innerText").contains(datastore.get("champ_cemmentaire_modification_timeline")));

    }

    //Vérification pour TimeLine
    @Then("Vérifier que le tag apparait dans le  statut  publié")
    public void vérifierQueLeTagApparaitDansLeStatutPublié() {

        logger.info("verifier que le tag apparait dans le statut ");

        Assert.assertTrue(generalobjectsmap.get("Premiere_publication_afficher").getAttribute("innerText").contains("Yassine Gtari "));

    }

    // Vérification pour TimeLine
    //Upload Method
    @And("l utilisateur saisit une photo dans le commentaire")
    public void lUtilisateurSaisitUnePhotoDansLeCommentaire() {
        logger.info("l utilisateur partage une photo dans le commentaire");

        driver.findElement(By.xpath("//app-post/app-post-comment-form/form/div/div[2]/div/div/div/a/input")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest.jpg"
        );

    }

    // Vérification pour journalisation
    @And("vérifier que les commentaires du publication supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLesCommentairesDuPublicationSuppriméEstAffichéDansLaListeJournalisationPublications() {
        logger.info("vérifier que les commentaires du publication supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Icone_Commentaire_supprimée"))));
        Assert.assertTrue(generalobjectsmap.get("Icone_Commentaire_supprimée").isDisplayed());
        Assert.assertEquals("Commantaire",generalobjectsmap.get("Icone_Commentaire_supprimée").getAttribute("title"));

    }

    // Vérification pour journalisation
    @And("vérifier que la publication est restauré")
    public void vérifierQueLaPublicationEstRestauré() throws InterruptedException {

        logger.info("vérifier que la publication est restauré");

        //Waiting for the first album to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Contenu_Publication_Publié"), "innerText",
                                datastore.get("Champ_Input_Publication")+"\n")));
        //Waiting for the refreshed first album to render
        synchronized (driver) {
            driver.wait(3000);
        }
        //Asserting that first article contains the text published in the scenario
        assertThat(generalobjectsmap.get("Contenu_Publication_Publié").getAttribute("innerText"),
                equalTo(datastore.get("Champ_Input_Publication")+"\n"));
    }

    // Vérification pour lien utile
    @Then("vérifier que le lien utile est visible")
    public void vérifierQueLeLienUtileEstVisible() throws InterruptedException {
        logger.info("Vérification de la visualisation correct du lien utile");

        //Waiting for the first publication of timeline to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_Lien_Utile_List"), "outerText",
                                "Test automatisé Visualiser le lien utile"
                        )
                )
        );

        //Waiting for the refreshed first publication to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first publication contains the text published in the scenario
        Assert.assertEquals(
                generalobjectsmap.get("Titre_Premiere_Lien_Utile_List").getAttribute("outerText"),
                "Test automatisé Visualiser le lien utile"
        );

    }

    // Vérification pour lien utile
    @Then("vérifier que le lien utile est ajouté")
    public void vérifierQueLeLienUtileEstAjouté() throws InterruptedException {
        logger.info("Vérification de l'ajout correct du lien utile");

        //Waiting for the first publication of timeline to refresh
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Titre_Premiere_Lien_Utile_List"), "outerText",
                                "Test automatisé Ajout Lien Utile SONEDE"
                        )
                )
        );

        //Waiting for the refreshed first publication to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first publication contains the text published in the scenario
        Assert.assertEquals(
                generalobjectsmap.get("Titre_Premiere_Lien_Utile_List").getAttribute("outerText"),
                "Test automatisé Ajout Lien Utile SONEDE"
        );

    }

    // Vérification pour journalisation
    @Then("vérifier que la nouvelle supprimée est affiché dans la liste journalisation publications")
    public void vérifierQueLaNouvelleSuppriméeEstAffichéDansLaListeJournalisationPublications() {

        logger.info("vérifier que la nouvelle supprimée est affiché dans la liste journalisation publications");

        WebElement specialwait = (
                new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOf(generalobjectsmap.get("Icone_Dernière_element_supprimée"))
                )
        );
        Assert.assertTrue(generalobjectsmap.get("Icone_Dernière_element_supprimée").isDisplayed());
        Assert.assertEquals("News", generalobjectsmap.get("Icone_Dernière_element_supprimée").getAttribute("title"));
    }

    // Vérification pour teamlab
    @And("l utilisateur upload {string} dans le champs Bulle {string}")
    public void lUtilisateurUploadDansLeChampsBulle(String arg0, String arg1) {

        logger.info("l utilisateur upload photo dans la bulle");

        driver.findElement(By.cssSelector("#modal-uplaod-photo > div > div > div.modal-body > a")).sendKeys(
                System.getProperty("user.dir") + "/src/test/resources/TestData/Uploads/imagetest4.jpg"
        );

    }

    //Vérification pour timeline
    @Then("Vérifier que le statut affiché est le statut publié")
    public void vérifierQueLeStatutAffichéEstLeStatutPublié() throws InterruptedException {
        logger.info("Vérifier que le statut affiché est le statut publié");
        Boolean specialwait = (new WebDriverWait(driver, 100)).until(ExpectedConditions.refreshed
                (ExpectedConditions
                        .attributeContains(generalobjectsmap.get("Texte_Publication_Popup"), "innerText",
                                datastore.get("champ_statut")+"\n")));

        //Waiting for the refreshed first news to render
        synchronized (driver) {
            driver.wait(3000);
        }

        //Asserting that first news contains the text published in the scenario
        Assert.assertEquals(datastore.get("champ_statut")+"\n",generalobjectsmap.get("Texte_Publication_Popup").getAttribute("innerText"));

    }

    //Vérification pour timeline
    @Then("verifier que le commentaire et le like du statut popup on ete ajoute")
    public void verifierQueLeCommentaireEtLeLikeDuStatutPopupOnEteAjoute() {

        logger.info("vérifier que le commentaire et le like on été ajouté");

        Assert.assertEquals(driver.findElements(
                By.cssSelector("div > app-modal-post > div > div > div > div > div > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(2) > a > svg")).size(),
                1
        );
       Assert.assertEquals(driver.findElements(
                By.cssSelector("body > ngb-modal-window > div > div > app-modal-post > div > div > div > div > div > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon")).size(),
                1
        );

    }

    //Vérification pour timeline
    @Then("verifier que le sous commentaire a ete comptabilise")
    public void verifierQueLeSousCommentaireAEteComptabilise() {
        logger.info("vérifier que le sous commentaire a ete comptabilise");

        Assert.assertNotEquals(driver.findElements(By.xpath("//app-post-comment/li/div[2]/app-post-statistics/div/ul/li/a/span")),0);

    }

    //Vérification profile utilisateur
    @Then("verifier que le commentaire de l album est modifié")
    public void verifierQueLeCommentaireDeLAlbumEstModifié() {
        logger.info("vérifier que le commentaire est modifié");
        Assert.assertEquals(datastore.get("Champ_Input_Modification_Commenteraire"),generalobjectsmap.get("premiere_Commentaire_album_Afficher").getAttribute("innerText"));

    }
    //vérificationn profile utilisateur
    @And("l utilisateur clique sur Envoyer_commentaire_Album")
    public void lUtilisateurCliqueSurEnvoyer_commentaire_Album() {
        logger.info("l utilisateur clique sur Envoyer_commentaire_Album");
        WebElement element = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-modal-post/div/div/div[2]/app-post-comment-form/form/div/div[2]/div/button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    //Vérification pour TimeLine
    @Then("vérifier que le sous commentaire a ete supprime")
    public void vérifierQueLeSousCommentaireAEteSupprime() {
        logger.info("Verifier que le sous commentaire a ete supprime ");

        Assert.assertEquals(driver.findElements(By.xpath("//app-post-comment/li/div[2]/app-post-statistics/div/ul/li/a/span")).size(),0);

    }

    @And("etape test")
    public void etapeTest() {
        //driver.switchTo().frame(2);
        driver.findElement(By.name("cardnumber")).click();
        driver.findElement(By.xpath("//div[@id=\'root\']/form/div/div[2]/span/span[2]/div/div[2]/span/input")).sendKeys("2445 45");
    }

    //Vérification pour BubbleStore
    @Then("verifier que le modal d'instruciton de configuration youtube s affiche")
    public void verifierQueLeModalDInstrucitonDeConfigurationYoutubeSAffiche() {
        logger.info("vérifier que le modal d'instruciton de configuration youtube s affiche ");

        Assert.assertEquals(generalobjectsmap.get("Titre_Modal_configuration_Youtube").getAttribute("innerText"),"Étape 1:");

    }
    //Vérification pour annuaire
    @Then("vérifier que le nouvel utilisateur a été ajouté Prenom erroné")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjoutéPrenomErroné() {
        logger.info("vérifier que le nouvel utilisateur a été ajouté Prenom erroné");
        Assert.assertEquals(driver.findElements(By.xpath("/span[contains(text(),'Karim Bennasr')]")).size(),0);

    }
    // Vérification pour Annuaire
    @Then("vérifier que le nouvel utilisateur a été ajouté")
    public void vérifierQueLeNouvelUtilisateurAÉtéAjouté() {

        logger.info("vérifier que le nouvel utilisateur a été ajouté");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute"))));
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").isDisplayed());
        Assert.assertTrue(generalobjectsmap.get("Nom_Nouvel_utilisateur_Ajoute").getAttribute("innerText").contains(datastore.get("Champ_Input_Chercher_des_membres")));

    }
    // Vérification pour Journalisation
    @Then("vérifier que la publication de la courbeille supprimé est affiché dans la liste journalisation publications")
    public void vérifierQueLaPublicationDeLaCourbeilleSuppriméEstAffichéDansLaListeJournalisationPublications() {
        logger.info("vérifier que la publication de la courbeille supprimé est affiché dans la liste journalisation publications");
        WebElement specialwait = (new WebDriverWait(driver, 10)).until(
                (ExpectedConditions
                        .visibilityOf(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé"))));
        Assert.assertTrue(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé").isDisplayed());
        Assert.assertTrue(generalobjectsmap.get("Contenu_Dernier_Element_Supprimé").getAttribute("innerText").contains("test automatisé Supprimer une publication de la corbeille\n"));
    }
    // Vérification pour Know'store
    @Then("vérifier que seuls les articles de categorie Article saffiche")
    public void vérifierQueSeulsLesArticlesDeCategorieArticleSaffiche() {
        logger.info("vérifier que seuls les articles de categorie Article saffiche");
        WebElement element= driver.findElement(By.cssSelector("div:nth-child(2) > div > app-post-card-useful-information > div > article > div.post-content > div.tags-container > a"));
        Assert.assertEquals(element.getAttribute("innerText"),"ARTICLE");
    }
}
