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

    @FindBy(css = "div:nth-child(2) > app-post-card-news > div > article > div.post-content > a")
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

    @FindBy(css = "div:nth-child(3) > ng-select > div > div > div.ng-input > input[type=text]")
    public static WebElement  categorie_article;

    @FindBy(css = "div:nth-child(2) > quill-editor > div.ql-container.ql-snow > div.ql-editor.ql-blank")
    public static WebElement  Champ_Input_Description_Article;

    @FindBy(css = "div.add-options-message > button.btn.btn-primary.btn-md-2")
    public static WebElement  Bouton_sauvegarder_article;

    @FindBy(css = " div:nth-child(2) > div > app-post-card-useful-information > div > article > div.post-content > a")
    public static WebElement  Titre_Premier_Article_publier;

    @FindBy(css = "div:nth-child(2) > div > app-post-card-useful-information > div > article > div.post-content > div.d-inline-block.card-action > div")
    public static WebElement  Bouton_options_article;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(1)")
    public static WebElement  Bouton_modifier_article;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(2)")
    public static WebElement  Bouton_supprimer_article;

    @FindBy(css = "div.dropdown-menu.show > button")
    public static WebElement  Bouton_supprimer_article_autre_admin;

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

    @FindBy(xpath ="//div[4]/div[1]/app-datepicker[1]/div[1]/div[1]/button[1]")
    public static WebElement Calendrier_recherche_article_par_date_debut;

    @FindBy(xpath ="//span[@class='ng-arrow-wrapper']")
    public static WebElement rechercher_article_categorie;

    @FindBy(xpath ="//div[3]/div[1]/app-datepicker[1]/div[1]/div[1]/button[1]")
    public static WebElement Calendrier_recherche_article_par_date_Fin;

    @FindBy(css ="div:nth-child(5) > div > app-datepicker > div > input")
    public static WebElement Champ_Input_Calendrier_article_par_date_Fin;

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

    @FindBy(xpath = "//input[@id='shareBoxImages']")
    public static WebElement Fichier_attache_nouveau_evenement;

    @FindBy(css = "div.form-group.label-floating.m0 > app-text-input > div > input")
    public static WebElement Champ_Input_invites_interne_evenement;

    @FindBy(css = "div.birthday-author-name")
    public static WebElement Invite_interne_evenement_selectionne;

    @FindBy(css = "button.btn.btn-md-2.btn-primary.mb-0.ml-3")
    public static WebElement Bouton_Ajouter_Invite_interne_evenement;

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

    @FindBy(css = "div.private-event-head.inline-items > div.more > ul > li:nth-child(1) > a")
    public static WebElement Bouton_supprimer_evenement_autre_adminstrateur;

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

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public static WebElement Champ_Input_Profil_Phone;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-6.order-lg-2.col-md-6.col-sm-6.col-12 > div > div:nth-child(1) > div.ui-block-content > ul > li:nth-child(2) > span")
    public static WebElement Phone_Afficher_Profil;

    @FindBy(css = "div:nth-child(2) > div.form-group.col-md-4 > app-floating-label-form > div > input")
    public static WebElement Champ_Input_Profil_Auteur;

    @FindBy(css = "span.authorQuote")
    public static WebElement Auteur_Afficher_Profil;

    @FindBy(xpath = "//a[contains(text(),'Photos')]")
    public static WebElement Menu_photos_profil;

    @FindBy(xpath = "//a[contains(text(),'Vidéos')]")
    public static WebElement Menu_vidéos_profil;

    @FindBy(css = "div.align-right > button")
    public static WebElement Bouton_Télécharger_vidéo;

    @FindBy(css = "app-floating-label-form > div > input")
    public static WebElement Champ_Input_Description_Vidéo;

    @FindBy(css = "div.d-flex.justify-content-end > button")
    public static WebElement Bouton_Sauvgarder_Vidéo;

    @FindBy(css = " div.ui-block-content.video-content")
    public static WebElement Derniere_Vidéo;

    @FindBy(css = "div:nth-child(2) > div > input")
    public static WebElement Champ_Input_Telecharger_video;

    @FindBy(css = "div.overflow-content > perfect-scrollbar > div > div.ps-content > div")
    public static WebElement Description_Premier_vidéo;

    @FindBy(css = "#album-page > div > div:nth-child(1) > div > div > button")
    public static WebElement Bouton_Ajout_Album;

    @FindBy(css = "div.align-right > a")
    public static WebElement Bouton_Ajout_photos;

    @FindBy(css = "button > input")
    public static WebElement Champ_Input_Ajout_photos;

    @FindBy(css = "div.d-flex.justify-content-end > button")
    public static WebElement Bouton_telecharger_photo;

    @FindBy(css = "div:nth-child(1) > app-floating-label-form > div > input")
    public static WebElement Champ_Input_Titre_Album;

    @FindBy(css = "div:nth-child(2) > app-floating-label-form > div > input")
    public static WebElement Champ_Input_Description_Album;

    @FindBy(css = "div:nth-child(1) > div > div > button > input")
    public static WebElement Photo_attache_nouvel_Album;

    @FindBy(xpath = "//button[contains(text(),'Publier un album')]")
    public static WebElement Bouton_Publier_Album;

    @FindBy(css = "#album-page > div > div:nth-child(2)")
    public static WebElement Derniere_Album;

    @FindBy(css = "div.overflow-content > perfect-scrollbar > div > div.ps-content > div")
    public static WebElement Description_Premier_Album;

    @FindBy(css = "body > ngb-modal-window > div > div > app-modal-post > a")
    public static WebElement Bouton_Fermer_Derniere_Album;

    @FindBy(xpath = "//*[@id=\"album-page\"]/div/div[2]/div/div[1]/a/app-more-dropdown/div")
    public static WebElement Bouton_Options_Album;

    @FindBy(xpath = "//*[@id=\"album-page\"]/div/div[2]/div/div[1]/a/app-more-dropdown/div/ul/li[1]/a")
    public static WebElement Bouton_Mettre_Ajour_Album;

    @FindBy(css = "#album-page > div > div:nth-child(2) > div > div.photo-item > a > app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Album;

    @FindBy(css = "button.swal2-confirm.btn.btn-success.ml-sm")
    public static WebElement Bouton_Confirmation_Suppression_Album;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public static WebElement Bouton_OK_Suppression_Album;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-post-picture-modal[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]")
    public static WebElement Photo_d_Album;

    @FindBy(css = "div > div > div > div > div.img.ng-star-inserted > svg")
    public static WebElement Bouton_annuler_photo;

    @FindBy(css = "app-post-reactions > div > ul > li:nth-child(2) > div")
    public static WebElement Bouton_Repondre_Album;

    @FindBy(css = "div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Commenter_Album;

    @FindBy(css = "div.form-group.with-icon-right > div > button")
    public static WebElement Envoyer_Commenteraire_Album;

    @FindBy(css = "app-tag-management.knowledge.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_Connaissances;

    @FindBy(css = "app-tag-management.knowledge.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag > div > div > div")
    public static WebElement Tag_Connaissances;

    @FindBy(css = "app-tag-management.knowledge.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag:nth-child(1) > div > div > delete-icon > span")
    public static WebElement Bouton_Supprimer_Connaissance
;
    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_Loisirs;

    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag > div > div > div")
    public static WebElement Tag_Loisirs;

    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag > div > div > delete-icon > span > svg")
    public static WebElement Bouton_Supprimer_loisir;

    @FindBy(css = "#sidebar-right > div")
    public static WebElement Bouton_Ouvrir_List_Chat;

    @FindBy(css = "div.mCustomScrollbar > perfect-scrollbar > div > div.ps-content > div > div")
    public static WebElement Liste_utilisateurs_Favoris;

    @FindBy(css = "#sidebar-right-1 > div.search-friend.inline-items > div > div > input")
    public static WebElement Champ_Input_Chercher_vos_amis;

    @FindBy(css = "app-speed-access-user-item > li > div.author-status > a")
    public static WebElement Utilisateur_Chercher;

    @FindBy(css = "div.col-lg-12.p0.chat-input-container > weavin-emoji-editor > div > quill-editor > div > div.ql-editor.ql-blank > p")
    public static WebElement Champ_Input_Message_Chat;

    @FindBy(css = "#media-chat")
    public static WebElement Champ_Input_Image_Chat;

    @FindBy(css = "#file-chat")
    public static WebElement Champ_Input_Fichier_Chat;

    @FindBy(css = "div.options-chat-item.col-lg-12.p0.pull-left > div > button > svg > path")
    public static WebElement Bouton_Envoyer_Chat;

    @FindBy(css = "span.chat-message-item")
    public static WebElement Message_reçu;

    @FindBy(css = "app-speed-access-user-item > li > div.more")
    public static WebElement Bouton_Options_utilisateur;

    @FindBy(css = "div.more > ul > li:nth-child(2)")
    public static WebElement Bouton_Ajouter_utilisateur_Favoris;

    @FindBy(css = "app-speed-access-user-item:nth-child(1) > li > div.more > ul > li:nth-child(2)")
    public static WebElement Bouton_Supprimer_utilisateur_Favoris;

    @FindBy(css = "app-speed-access-user-item:nth-child(1) > li > div.author-status > a")
    public static WebElement Premier_utilisateur_Favoris;

    @FindBy(xpath = "//span[contains(text(),'Configuration')]")
    public static WebElement Bouton_Configuration_utilisateur;

    @FindBy(xpath = "//a[contains(text(),'Utilisateurs')]")
    public static WebElement Rubrique_utilisateurs;

    @FindBy(css = "div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div.ui-block-title")
    public static WebElement Modal_Gestion_utilisateurs;

    @FindBy(css = "button.btn.btn-primary.mb-0.ml-2.add-user")
    public static WebElement Bouton_Ajouter_Nouvel_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Email_Nouvel_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Prenom_Nouvel_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Nom_Nouvel_utilisateur;

    @FindBy(css = "div.modal-footer.mt-4 > button.btn.btn-primary.mb-0.ml-2")
    public static WebElement Bouton_enregistrer_Nouvel_utilisateur;

    @FindBy(css = "app-text-input > div > input")
    public static WebElement Champ_Input_Chercher_des_membres;

    @FindBy(css = "div.members-settings-container > div > div > div > ul > li:nth-child(3) > a")
    public static WebElement invites_utilisateurs;

    @FindBy(xpath = "//small[contains(text(),'karim.bennasr@yopmail.com')]")
    public static WebElement Email_Nouvel_utilisateur_Ajoute;

    @FindBy(css = "div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Publication;

    @FindBy(css = "div.add-options-message > button")
    public static WebElement Bouton_publier_Publication;

    @FindBy(css = "#newsfeed-items-grid > div:nth-child(1) > app-post > article > div.overflow-content-post.container > p")
    public static WebElement Contenu_Publication_Publié;

    @FindBy(css = "div:nth-child(1) > app-post > article > div.post__author.author.vcard.inline-items > app-more-dropdown > div > svg")
    public static WebElement Bouton_Options_Publication;

    @FindBy(css = "div:nth-child(1) > app-post > article > div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Publication;

    @FindBy(xpath = "//a[contains(text(),'Journalisation')]")
    public static WebElement Rubrique_Journalisation;

    @FindBy(css = "div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div.ui-block-title")
    public static WebElement Modal_Gestion_publications;

    @FindBy(css = "div:nth-child(3) > div > div.row.col-11.ml-1.mt-1 > div.row.col-2 > i")
    public static WebElement Icone_Dernière_element_supprimée;

    @FindBy(xpath = "//a[contains(text(),'Personnaliser')]")
    public static WebElement Rubrique_Personnaliser;

    @FindBy(xpath = "//a[contains(text(),'Gestion des liens utiles')]")
    public static WebElement Sous_Rubrique_Gestion_Liens_utiles;

    @FindBy(css = "div.useful-link-settings-header > button")
    public static WebElement Bouton_Ajout_Lien_Utile;

    @FindBy(css = "app-modal-useful-link > div.modal-header")
    public static WebElement Modal_ajout_Lien_Utile;

    @FindBy(css = "app-floating-label-form:nth-child(1) > div > input")
    public static WebElement Champ_Input_Titre_Lien_Utile;

    @FindBy(css = "app-floating-label-form:nth-child(2) > div > input")
    public static WebElement Champ_Input_Lien_Lien_Utile;

    @FindBy(css = "button.btn.btn-md-2.btn-primary")
    public static WebElement Bouton_Modal_Ajouter_Lien_Utile;

    @FindBy(css = "div.useful-link-settings-header > form > div > input")
    public static WebElement Champ_Input_Rechercher_Lien_Utile;

    @FindBy(css = "div.name-container")
    public static WebElement Titre_Premiere_Lien_Utile;

    @FindBy(css = "div.flex-row.flex-row-action > i")
    public static WebElement Bouton_Supprimer_Lien_Utile;

    @FindBy(css = "div:nth-child(3) > div > a > svg")
    public static WebElement Bouton_Invités_Internes;

    @FindBy(css = "div.swal2-actions > button.swal2-confirm.btn.btn-success.ml-sm")
    public static WebElement Accepter_envoi_mail_evenement;

    @FindBy(css = "div.togglebutton > label > span")
    public static WebElement Bouton_Invités_Externes;

    @FindBy(css = "td:nth-child(1) > ng2-smart-table-cell > table-cell-edit-mode > div > table-cell-default-editor > div > input-editor > input")
    public static WebElement Champ_Input_Nom_User_Externe;

    @FindBy(css = "td:nth-child(2) > ng2-smart-table-cell > table-cell-edit-mode > div > table-cell-default-editor > div > input-editor > input")
    public static WebElement Champ_Input_Email_User_Externe;

    @FindBy(css = "a.ng2-smart-action.ng2-smart-action-add-create")
    public static WebElement Bouton_Ajouter_User_Externe;

    @FindBy(css = "#notifications-tab")
    public static WebElement Bouton_Mes_Invitations;

    @FindBy(css = "a.btn.btn-breez.btn-sm")
    public static WebElement Bouton_Accepter_Ajouter_au_calendrier;

    @FindBy(css = "div.col.col-lg-5.col-md-5.col-sm-12.col-12 > div > guests-by-event > div > div.list-guests > a")
    public static WebElement Bouton_Evenement_liste_Invités;

    @FindBy(css = "div.member.pull-right.avatar-member")
    public static WebElement Invité_Acceptation;

    @FindBy(css = "ngb-modal-window > div > div > app-event-detail > a")
    public static WebElement Bouton_Fermer_Evenement;

    @FindBy(css = "a.btn.btn-sm.btn-border-think.custom-color.c-grey")
    public static WebElement Bouton_Refuser_Ajouter_au_calendrier;

    @FindBy(css = "app-widget-activity-feed > div > ul > li:nth-child(1) > div > div")
    public static WebElement Premiere_Element_Flux_Activite_Afficher;

    @FindBy(xpath = "//a[@id='ngb-nav-1']")
    public static WebElement Bouton_Ajouter_Formulaire;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(1)")
    public static WebElement Bouton_Ajouter_champ_titre;

    @FindBy(css = "#title-field-0")
    public static WebElement Champ_Input_champ_titre;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(2)")
    public static WebElement Bouton_Ajouter_champ_zone_text;

    @FindBy(css = "#title-field-1")
    public static WebElement Champ_Input_champ_zone_text;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(3)")
    public static WebElement Bouton_Ajouter_champ_nombre;

    @FindBy(css = "#title-field-2")
    public static WebElement Champ_Input_champ_nombre;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(4)")
    public static WebElement Bouton_Ajouter_champ_Date;

    @FindBy(css = "#title-field-3")
    public static WebElement Champ_Input_champ_date;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(5)")
    public static WebElement Bouton_Ajouter_champ_Liste_choix;

    @FindBy(css = "#title-field-4")
    public static WebElement Champ_Input_champ_Liste_choix;

    @FindBy(css = "tag-input-form > form > input")
    public static WebElement Champ_Input_choix_Liste_choix;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(6)")
    public static WebElement Bouton_Ajouter_champ_cases_coucher;

    @FindBy(css = "#title-field-5")
    public static WebElement Champ_Input_champ_cases_coucher;

    @FindBy(css = "#options-value5 > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_case_cases_coucher;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(7)")
    public static WebElement Bouton_Ajouter_champ_radio;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-3.order-lg-1.col-md-12.order-md-2.col-sm-12.col-12 > ul > li:nth-child(8)")
    public static WebElement Bouton_Ajouter_champ_Document;

    @FindBy(css = "#title-field-6")
    public static WebElement Champ_Input_champ_Document;

    @FindBy(css = "div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div > button")
    public static WebElement Bouton_Valider_formulaire;

    @FindBy(css = "app-floating-label-form > div > div > div > button")
    public static WebElement Date_de_naissance;

    @FindBy(xpath = "//form[1]/div[3]/div[1]/app-floating-label-form[1]/div[1]/textarea[1]")
    public static WebElement Champ_Input_Resume;

    @FindBy(xpath = "//a[contains(text(),'Divers')]")
    public static WebElement rubrique_divers;

    @FindBy(css = "div.col.col-xl-6.order-xl-36.col-lg-6.order-lg-3.col-md-6.col-sm-6.col-12.ng-star-inserted > app-tag-management > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_Divers_Loisirs;

    @FindBy(css = "div.col.col-xl-6.order-xl-6.col-lg-6.order-lg-3.col-md-6.col-sm-6.col-12.ng-star-inserted > app-tag-management > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_Divers_Connaissances;

    @FindBy(xpath = "//a[contains(text(),'Réseaux sociaux')]")
    public static WebElement rubrique_Reseaux_sociaux;

    @FindBy(xpath = "//div[1]/div[1]/app-floating-label-form[1]/div[1]/span[1]/input[1]")
    public static WebElement Champ_Input_facebook;

    @FindBy(xpath = "//div[1]/div[3]/app-floating-label-form[1]/div[1]/span[1]/input[1]")
    public static WebElement Champ_Input_linkedin;

    @FindBy(css = ".fas.fa-lock-alt.mr-1:nth-child(2)")
    public static WebElement Bouton_Desactiver_Utilisateur;

    @FindBy(css = ".fas.fa-lock-alt.mr-1:nth-child(3)")
    public static WebElement Bouton_Supprimer_Utilisateur;

    @FindBy(css = "a[id=deactivated]")
    public static WebElement Onglet_inactif_utilisateur;

    @FindBy(css = "div.flex-row.flex-row-action > i.fas.fa-lock-open-alt.mr-1")
    public static WebElement Bouton_Reactiver_Utilisateur;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Chercher_des_membres_Rubrique_Annuaire;

    @FindBy(xpath = "//div[1]/div/div/div/div[2]/div[1]/a")
    public static WebElement Nom_premier_utilisateur_Afficher_Annuaire;

    @FindBy(css = "ul > li:nth-child(8) > a")
    public static WebElement Gestion_Categorie;

    @FindBy(css = "div > div:nth-child(3) > div > span.category-item.add-category-item")
    public static WebElement Bouton_Ajouter_CAtegorie_Opportunite;

    @FindBy(css = "form > app-floating-label-form > div > input")
    public static WebElement Nom_Categorie_Opportunite;

    @FindBy(xpath = "//button[contains(text(),'Enregistrer')]")
    public static WebElement Enregistrer_Gestion_Categorie;

    @FindBy(css = "app-opportunity-list > div:nth-child(3) > div:nth-child(1) > div")
    public static WebElement Publier_Une_Opportnite;

    @FindBy(css = "div.fieldsTxt > div:nth-child(1) > input")
    public static WebElement Nom_Categorie_Opportunite_Menu_Gauche;

    @FindBy(css = "quill-editor > div.ql-container.ql-snow > div.ql-editor")
    public static WebElement Description_Categorie_Opportunite;

    @FindBy(xpath = "//body/app-root[1]/app-layout-portal[1]/div[2]/app-opportunity[1]/section[1]/app-opportunity-list[1]/div[1]/div[1]/app-opportunity-form[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/tag-input[1]/div[1]/div[1]/tag-input-form[1]/form[1]/input[1]")
    public static WebElement Liste_tag_Opportunite;

    @FindBy(xpath = "//div/div/form/div[1]/div[1]/div[5]/div[1]/input")
    public static WebElement email_Opportunite;

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    public static WebElement tel_Opportunite;

    @FindBy(xpath = "//div[2]/div/app-post-card-opportunity/div/article/div[2]/a")
    public static WebElement titre_premiere_opportunite_afficher;

    @FindBy(xpath = "//div/app-opportunity-form/div/div/form/div[2]/button[1]")
    public static WebElement Sauvegarder_Opportunite;

    @FindBy(xpath = "//div[2]/div[1]/app-post-card-opportunity[1]/div[1]/article[1]/div[2]/div[2]/div[1]/div[1]")
    public static WebElement Bouton_Option_Opportunite;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-opportunity/section/app-opportunity-list/div[3]/div[2]/div/app-post-card-opportunity/div/article/div[2]/div[2]/div/div[2]/button[1]")
    public static WebElement Bouton_Option_Editer_Opportunite;

    @FindBy(xpath = "//div[2]/div/app-post-card-opportunity/div/article/div[2]/div[3]")
    public static WebElement Description_Categorie_Opportunite_Menu_Gauche;

    @FindBy(xpath = "//div[3]/div[2]/div/app-post-card-opportunity/div")
    public static WebElement Premiere_Opportunite_Afficher;

    @FindBy(css = "body > app-root > app-layout-portal > div.container.wrapper-portal > app-opportunity > section > app-opportunity-detail > div > div > div.col.col-xl-8.col-lg-12.col-md-12.col-sm-12.col-12.ng-star-inserted > div > article > div.post-additional-info.inline-items.mt0 > app-post-reactions > div > ul > li:nth-child(1) > div > a > span.ml-2.ng-star-inserted")
    public static WebElement Bouton_Like_Opportinite;

    @FindBy(css = "div:nth-child(2) > div > app-post-card-opportunity > div > article > div.post-content > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Premiere_Opportunite_Afficher;


    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> CN_map = new HashMap<>();
        Field[ ] allFields = ConnectObjects.class.getFields();
        for (Field field : allFields) {
            CN_map.put(field.getName(), (WebElement) field.get(field));
        }
        return CN_map;
    }


}
