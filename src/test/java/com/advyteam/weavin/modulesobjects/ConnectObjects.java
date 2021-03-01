package com.advyteam.weavin.modulesobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ConnectObjects extends PageObject {

    @FindBy(css = ".ql-editor.ql-blank")
    public static WebElement champ_statut;

    @FindBy(xpath = "//button[contains(text(),'Publier')]")
    public static WebElement bouton_publier_statut;

    @FindBy(css = "#newsfeed-items-grid .ui-block:nth-child(1) .d-inline")
    public static WebElement Texte_Premiere_Publication_Timeline;

    @FindBy(css = ".photo-album-item.create-album.cursor")
    public static WebElement Buton_ajout_ideation;

    @FindBy(css = ".blog-post-wrap")
    public static WebElement  Modal_ajout_ideation;

    @FindBy(xpath = "//input[@formcontrolname=\"title\"]")
    public static WebElement Titre_nouvelle_idee;

    @FindBy(xpath = "//input[@formcontrolname=\"item\"]")
    public static WebElement Tag_nouvelle_idee;

    @FindBy(css = ".ql-editor")
    public static WebElement Description_nouvelle_idee;

    @FindBy(css = "#bg-cover-file")
    public static WebElement H_Upload_photo_nouvelle_idee;

    @FindBy(css = "#shareBoxImages")
    public static WebElement Fichier_attache_nouvelle_idee;

    @FindBy(css = ".add-options-message .btn-primary")
    public static WebElement Bouton_publier_nouvelle_idee;

    @FindBy(css = "div.modal-footer > button")
    public static WebElement Bouton_enregistrer_upload_image;

    @FindBy(css = ".btn.btn-primary.btn-md-2")
    public static WebElement Bouton_enregistrer_nouvelle_idee;

    @FindBy(css = ".calendar")
    public static WebElement Calendrier_recherche_publication_par_date;

    @FindBy(css = ".ngb-dp-today")
    public static WebElement Case_aujoudhui_Calendrier;

    @FindBy(css = ".card-container-list:last-child .dropdown")
    public static WebElement Bouton_option_derniere_ideation;

    @FindBy(css = ".dropdown-menu.show .dropdown-item:nth-child(1)")
    public static WebElement Bouton_modifier_ideation;

    @FindBy(css = ".dropdown-menu.show .dropdown-item:nth-child(2)")
    public static WebElement Bouton_supprimer_ideation;

    @FindBy(css = "*> app-news-administration > div > div > div > span:nth-child(5)")
    public static WebElement  Modal_ajout_news;

    @FindBy(css = ".photo-album-item.create-album.cursor")
    public static WebElement Bouton_Ajout_News;

    @FindBy(css = "app-floating-label-form > div > input")
    public static WebElement Champ_Input_Titre_News;

    @FindBy(css = ".ql-container.ql-snow > div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Description_News;

    @FindBy(xpath = "//app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[1]/div/app-floating-label-form/div/div/input")
    public static WebElement Champ_Input_Date_News;

    @FindBy(css = "button[id=\"btnSubmit\"]")
    public static WebElement Bouton_Sauvegarder_Creation_News;

    @FindBy(css = "input[formcontrolname=\"beginningHourNews\"]")
    public static WebElement Champ_Input_Heure_Debut_News;

    @FindBy(xpath = "//app-news-administration/div/div/news-form/div/div/form/div[2]/button")
    public static WebElement Bouton_Publier_News;

    @FindBy(xpath = "//section/div/div[2]/app-post-card/div/article/div[2]/a")
    public static WebElement Titre_Premiere_News_publier;

    @FindBy(xpath = "//section/div/div[2]/app-post-card/div/article/div[2]/div[1]/a")
    public static WebElement Statut_Premiere_News_publier;


    @FindBy(xpath = "//app-news-administration/section/div/div[2]/app-post-card/div/article/div[2]/div[2]/div/div[1]")
    public static WebElement Bouton_Options_Premiere_News_Afficher;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(1)")
    public static WebElement Bouton_Editer_News;


    @FindBy(xpath = "//button[contains(text(),'Editer')]")
    public static WebElement Bouton_Editer_Modification_News;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(2)")
    public static WebElement Bouton_Supprimer_News;

    @FindBy(css = "input[placeholder=\"Rechercher par titre\"]")
    public static WebElement Champ_Input_Rechercher_News_Par_Titre;

    @FindBy(xpath= "/html/body/app-root/app-layout-portal/div[2]/app-news-administration/div[2]/div/div/div/div[2]/div/ng-select/div/span")
    public static WebElement Liste_Deroulante_Statut_News;

    @FindBy(css = "app-ideations > section > app-list > div.row > div:nth-child(2)")
    public static WebElement Derniere_Idee_Ajoutee;

    @FindBy(css = " div.row > div:nth-child(2) > app-post-card > div > article > div.post-content > a")
    public static WebElement Titre_Derniere_Idee_Ajoutee;

    @FindBy(css = "input[placeholder=\"Titre de l'idée\"]")
    public static WebElement Champ_Input_Rechercher_Ideation_Par_Titre;

    @FindBy(css = " div > div.comments-shared.ng-star-inserted > a")
    public static WebElement Bouton_Commenter_Ideation;

    @FindBy(css = " div > div.ql-editor.ql-blank > p")
    public static WebElement Champ_Input_Commenter_Ideation;

    @FindBy(css = "button[title=\"Envoyer\"]")
    public static WebElement Envoyer_Commenteraire_Ideation;

    @FindBy(css = "div.post-additional-info.inline-items.ng-star-inserted > app-post-statistics > div > ul > li > a")
    public static WebElement Icone_Commenteraire_Ideation;

    @FindBy(css = "ul > app-post-comment > li > div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_Ideation_Afficher;

    @FindBy(css = "div > div > div > a:nth-child(3)")
    public static WebElement Onglet_Liste_Des_News;

    @FindBy(css = "div > div.like-action.mr-lg")
    public static WebElement Bouton_Interaction_Ideation;

    @FindBy(css = " div > div.like-action.mr-lg > div > button:nth-child(3)")
    public static WebElement Bouton_Jadore_Ideation;

    @FindBy(css = "article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Ideation;

    @FindBy(css = "li > div.parent-item-comment > div.post__author.author.vcard.inline-items > app-more-dropdown > div")
    public static WebElement Bouton_Option_Commentaire_Ideation;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(1) > a")
    public static WebElement Bouton_Editer_Commentaire_Ideation;

    @FindBy(css = "li > div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > div > weavin-emoji-editor > div > quill-editor > div > div.ql-editor > p")
    public static WebElement Champ_Input_Modification_Commenteraire_Ideation;

    @FindBy(xpath = "//li/div[1]/app-post-comment-form/form/div/div[2]/div/button[1]")
    public static WebElement Envoyer_Commenteraire_Modifier_Ideation;

    @FindBy(css = " div > div.like-action.mr-lg > div > button:nth-child(2)")
    public static WebElement Bouton_Praise_Ideation;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Commentaire_Ideation;

    @FindBy(css = "*> div > ul > li:nth-child(1) > div > a > span.ml-2.ng-star-inserted")
    public static WebElement Bouton_Like_Ideation;

    @FindBy(css = "*> div:nth-child(3) > div > ng-select > div > span")
    public static WebElement Liste_Deroulante_Tags_Ideation;

    @FindBy(css = "div.col.col-xl-2.col-lg-2.col-md-2.col-sm-2 > button")
    public static WebElement Bouton_Trier_Ideation;

    @FindBy(css = "div.popover-body > div > div > ng-select > div")
    public static WebElement Liste_Deroulante_Choix_Tri_Ideation;

    @FindBy(css = "div.form-group.label-floating.mt-2.mb-0 > ng-select > div")
    public static WebElement Liste_Deroulante_Tri_ASC_DES;

    @FindBy(css = "div > span:nth-child(5)")
    public static WebElement  Modal_ajout_Article;

    @FindBy(css = ".photo-album-item.create-album.cursor")
    public static WebElement  Bouton_Ajout_Article;

    @FindBy(css = "div.fieldsTxt > div:nth-child(1) > input")
    public static WebElement  Champ_Input_Titre_Article;

    @FindBy(css = "div:nth-child(2) > ng-select > div > div")
    public static WebElement  categorie_article;

    @FindBy(xpath = "//div/div/form/div[1]/div[2]/div[1]/quill-editor/div[2]/div[1]")
    public static WebElement  Champ_Input_Description_Article;

    @FindBy(css = "div.add-options-message > button.btn.btn-primary.btn-md-2")
    public static WebElement  Bouton_sauvegarder_article;

    @FindBy(css = "div:nth-child(2) > div > app-post-card > div > article > div.post-content > a")
    public static WebElement  Titre_Premier_Article_publier;

    @FindBy(xpath = "//div[2]/div/app-post-card/div/article/div[2]/div[2]/div")
    public static WebElement  Bouton_options_article;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(1)")
    public static WebElement  Bouton_modifier_article;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(2)")
    public static WebElement  Bouton_supprimer_article;

    @FindBy(css = "div > div.ql-editor.ql-blank > p")
    public static WebElement  Champ_Input_Commenter_Article;

    @FindBy(css = "button[title=\"Envoyer\"]")
    public static WebElement Envoyer_Commenteraire_Article;

    @FindBy(xpath = "//div/article/div[6]/app-post-statistics/div/ul/li/a")
    public static WebElement Icone_Commentaire_Article;

    @FindBy(css = "li > div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_Article_Afficher;

    @FindBy(css = "form > div > div:nth-child(1) > div > input")
    public static WebElement Champ_Input_Rechercher_Article_Par_Titre;

    @FindBy(css = "div:nth-child(1) > div > app-post-card > div > article > div.post-content > a")
    public static WebElement Premier_Article_Afficher_Utilisateur;

    @FindBy(css = "div > div.like-action.mr-lg")
    public static WebElement Bouton_Interaction_Article;

    @FindBy(css = "div > div.like-action.mr-lg > div > button:nth-child(1)")
    public static WebElement Bouton_Like_Article;

    @FindBy(css = "li:nth-child(1) > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Article;

    @FindBy(css = "li > div.parent-item-comment > div.post__author.author.vcard.inline-items > app-more-dropdown > div")
    public static WebElement Bouton_Option_Commentaire_Article;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(1) > a")
    public static WebElement Bouton_Editer_Commentaire_Article;

    @FindBy(css = "li > div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > div > weavin-emoji-editor > div > quill-editor > div > div.ql-editor > p")
    public static WebElement Champ_Input_Modification_Commenteraire_Article;

    @FindBy(xpath = "//li/div[1]/app-post-comment-form/form/div/div[2]/div/button[1]")
    public static WebElement Envoyer_Commenteraire_Modifier_Article;

    @FindBy(css = " div > div.like-action.mr-lg > div > button:nth-child(2)")
    public static WebElement Bouton_Praise_Article;

    @FindBy(css = "span.toggle")
    public static WebElement Bouton_Temoin_Nouveau;

    @FindBy(css = "div.flagNew > div.form-group > input")
    public static WebElement Champ_Input_Temoin_Nouveau_Duree;

    @FindBy(css = "div:nth-child(2) > app-post-card > div > article > div.post-content > div.tags-container > a")
    public static WebElement Temoin_Premiere_News_Affichee;

    @FindBy(css = "app-news-administration > section > div > div:nth-child(2)")
    public static WebElement Derniere_News_Ajoutee;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(2) > div > a")
    public static WebElement Bouton_Repondre_News;

    @FindBy(css = "div > weavin-emoji-editor > div > quill-editor > div > div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Commenter_News;

    @FindBy(css = " div.form-group.with-icon-right > div > button")
    public static WebElement Envoyer_Commenteraire_News;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1)")
    public static WebElement Bouton_Interaction_News;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")
    public static WebElement Icone_Commenteraire_News;

    @FindBy(css = "div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_News_Afficher;

    @FindBy(css = "div:nth-child(1) > div.news-details > h3")
    public static WebElement Premiere_News_In_Home_List_News;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_News;

    @FindBy(css = "div.parent-item-comment > div.post__author.author.vcard.inline-items > app-more-dropdown > div > svg")
    public static WebElement Bouton_Option_Commentaire_News;

    @FindBy(css = "div.parent-item-comment > div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(1)")
    public static WebElement Bouton_Editer_Commentaire_News;

    @FindBy(css = "div.parent-item-comment > div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(2)")
    public static WebElement Bouton_Supprimer_Commeaire_News;

    @FindBy(css = "div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > div > weavin-emoji-editor > div > quill-editor > div > div.ql-editor")
    public static WebElement Champ_Input_Modification_Commenteraire_News;
    @FindBy(css = "li:nth-child(1) > div > a > span.ml-2")
    public static WebElement Bouton_Like_Article_Down_Page;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Editer_Supprimer_Article;

    @FindBy(css = "form > div > div:nth-child(1) > div > input")
    public static WebElement Champ_Input_Rechercher_Article_Par_titre;

    @FindBy(css = "div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > button.btn.btn-sm.btn-blue.mt-0.btn-post")
    public static WebElement Envoyer_Commenteraire_Modifier_News;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div > div > button:nth-child(2)")
    public static WebElement Bouton_Praise_News;

    @FindBy(xpath ="//div[@class='row']//div[2]//div[1]//app-datepicker[1]//div[1]//div[1]//button[1]")
    public static WebElement Calendrier_recherche_article_par_date_debut;

    @FindBy(xpath ="//span[@class='ng-arrow-wrapper']")
    public static WebElement rechercher_article_categorie;

    @FindBy(xpath ="//div[3]/div[1]/app-datepicker[1]/div[1]/div[1]/button[1]")
    public static WebElement Calendrier_recherche_article_par_date_Fin;

    // Locators Calendreir et évenements

    @FindBy(css = "div.control-block-button")
    public static WebElement Bouton_Ajout_Evenement;

    @FindBy(css = "div.modal-header")
    public static WebElement Modal_ajout_Evenement;

    @FindBy(css = "div:nth-child(1) > ng-select > div")
    public static WebElement Calendrier;

    @FindBy(css = "div:nth-child(2) > ng-select > div")
    public static WebElement Type_Evenement;

    @FindBy(css = "div.text-items > div:nth-child(2) > input")
    public static WebElement Champ_Input_Titre_Evenement;

    @FindBy(css = "div.ql-editor")
    public static WebElement Champ_Input_Description_Evenement;

    @FindBy(css = "div:nth-child(4) > input")
    public static WebElement Champ_Input_Lieu_Evenement;

    @FindBy(css = "div:nth-child(5) > div:nth-child(1) > div > div > button")
    public static WebElement Date_Debut_Evenement;

    @FindBy(css = "div:nth-child(6) > div:nth-child(1) > div > div > button")
    public static WebElement Date_Fin_Evenement;

    @FindBy(xpath ="//input[@id='bg-cover-file']")
    public static WebElement H_Upload_photo_nouveau_evenement;

    @FindBy(xpath ="//input[@id='shareBoxImages']")
    public static WebElement Fichier_attache_nouveau_evenement;

    @FindBy(css =" div:nth-child(3) > ng-select")
    public static WebElement invites_interne_evenement;

    @FindBy(xpath ="//button[contains(text(),'Créer un évènement')]")
    public static WebElement Bouton_creer_evenement;

    @FindBy(xpath ="//button[contains(text(),'Décliner')]")
    public static WebElement Non_envoi_mail_evenement;

    @FindBy(css ="div:nth-child(5) > div:nth-child(2) > input")
    public static WebElement Heure_Debut_Evenement;

    @FindBy(css ="div:nth-child(6) > div:nth-child(2) > input")
    public static WebElement Heure_Fin_Evenement;

    @FindBy(css ="td > a > div > span.fc-title")
    public static WebElement Evenement_Dans_Calendrier;

    @FindBy(css = "div.private-event-head.inline-items > div.author-date > a")
    public static WebElement Modal_Evenement;

    @FindBy(css = "div.private-event-head.inline-items > div.more > svg")
    public static WebElement Bouton_options_evenement;

    @FindBy(css = "div.private-event-head.inline-items > div.more > ul > li:nth-child(1)")
    public static WebElement Option_modifier_evenement;

    @FindBy(xpath = "//button[contains(text(),'Modifier un évènement')]")
    public static WebElement Bouton_modifier_evenement;

    @FindBy(css = "div > div.comments-shared > a")
    public static WebElement Bouton_commentaire_evenement;

    @FindBy(css = "div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Commentaire_Evenement;

    @FindBy(css = "div.form-group.with-icon-right > div > button")
    public static WebElement Envoyer_Commentaire_Evenement;

    @FindBy(css = "article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")
    public static WebElement Icone_Commentaire_Evenement;

    @FindBy(css = "li > div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_Evenement_Afficher;

    @FindBy(css = "li:nth-child(1) > div > a > span.ml-2")
    public static WebElement Bouton_Interaction_Evenement;

    @FindBy(css = "li:nth-child(1) > div > div > button:nth-child(1) > span.reactions-icon-md-LIKE.reactions-menu__icon")
    public static WebElement Bouton_Like_Evenement;

    @FindBy(css = "article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Evenement;

    @FindBy(css = "app-more-dropdown > div")
    public static WebElement Bouton_Option_Commentaire_Evenement;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(1) > a")
    public static WebElement Bouton_Editer_Commentaire_Evenement;

    @FindBy(xpath = "//li/div[1]/app-post-comment-form/form/div/div[2]/div/div/weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement Champ_Input_Modification_Commenteraire_Evenement;

    @FindBy(css = "div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > button.btn.btn-sm.btn-blue.mt-0.btn-post")
    public static WebElement Envoyer_Commenteraire_Modifier_Evenement;

    @FindBy(xpath = "//div[4]/app-post-reactions[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/button[2]/span[2]")
    public static WebElement Bouton_Praise_Evenement;

    @FindBy(css = "app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Commentaire_Evenement;

    @FindBy(css = "div.row > div > div > div > ul > li:nth-child(3)")
    public static WebElement Onglet_Mes_Evenements;

    @FindBy(css = ".photo-album-item.create-album.cursor")
    public static WebElement Bouton_Ajout_Mes_Evenements;

    @FindBy(css = "div.row > div > div > div > ul > li:nth-child(1)")
    public static WebElement Onglet_Calendrier_et_Evenement;

    @FindBy(css = "div.author-content > a")
    public static WebElement Profil_username;

    @FindBy(css = "div.author-thumb > span > span.edit-avatar > input")
    public static WebElement H_Upload_photo_de_profil;

    @FindBy(css = "div.top-header-author > div.author-thumb > img")
    public static WebElement Photo_profil_user;

    @FindBy(css = "div.top-header-thumb > span > span.edit-avatar > input")
    public static WebElement H_Upload_photo_de_couverture;

    @FindBy(css = "div.top-header-thumb > div > img")
    public static WebElement Photo_couverture_user;

    @FindBy(xpath = "//div[2]/div[1]/app-floating-label-form[1]/div[1]/textarea[1]")
    public static WebElement Champ_Input_Profil_Citation;

    @FindBy(xpath = "//button[contains(text(),'Enregistre')]")
    public static WebElement Bouton_Enregistrer_Parametre_Compte;

    @FindBy(xpath = "//app-home/div/div[3]/div[1]/span[1]")
    public static WebElement Citation_Afficher_Profil;


    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> CN_map = new HashMap<>();
        Field[ ] allFields = ConnectObjects.class.getFields();
        for (Field field : allFields) {
            CN_map.put(field.getName(), (WebElement) field.get(field));
        }
        return CN_map;
    }


}
