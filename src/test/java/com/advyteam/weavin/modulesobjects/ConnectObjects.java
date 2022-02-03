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

    @FindBy(xpath = "//*[@id=\"newsfeed-items-grid\"]/div[1]/app-post/article/div[2]")
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

    @FindBy(css = "#dropdownBasic2")
    public static WebElement Bouton_option_derniere_ideation;

    @FindBy(css = ".dropdown-menu.show .dropdown-item:nth-child(1)")
    public static WebElement Bouton_modifier_ideation;

    @FindBy(css = ".dropdown-menu.show .dropdown-item:nth-child(2)")
    public static WebElement Bouton_supprimer_ideation;

    @FindBy(css = "*> app-news-administration > div > div > div > span:nth-child(5)")
    public static WebElement  Modal_ajout_news;

    @FindBy(css = ".photo-album-item.create-album.cursor")
    public static WebElement Bouton_Ajout_News;

    @FindBy(css = "div.containerFormNews > div.fieldsTxt > div:nth-child(1) > input")
    public static WebElement Champ_Input_Titre_News;

    @FindBy(css = "div.ql-editor.ql-blank > p")
    public static WebElement Champ_Input_Description_News;

    @FindBy(xpath = "//app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[1]/div/app-floating-label-form/div/div/input")
    public static WebElement Champ_Input_Date_News;

    @FindBy(css = "button[id=\"btnSubmit\"]")
    public static WebElement Bouton_Sauvegarder_Creation_News;

    @FindBy(css = "input[formcontrolname=\"beginningHourNews\"]")
    public static WebElement Champ_Input_Heure_Debut_News;

    @FindBy(xpath = "//app-news-administration/div/div/news-form/div/div/form/div[2]/button[1]")
    public static WebElement Bouton_Publier_News;

    @FindBy(css = "div:nth-child(2) > app-post-card-news > div > article > div.post-content > a")
    public static WebElement Titre_Premiere_News_publier;

    @FindBy(xpath = "//div/div[2]/app-post-card-news/div/article/div[2]/div[1]/a")
    public static WebElement Statut_Premiere_News_publier;

    @FindBy(xpath = "//div[2]/app-post-card-news/div/article/div[2]/div[2]/div/div[1]")
    public static WebElement Bouton_Options_Premiere_News_Afficher;

    @FindBy(css = "div.dropdown-menu.show > button:nth-child(1)")
    public static WebElement Bouton_Editer_News;

    @FindBy(xpath = "//div[1]/div[1]/form[1]/div[2]/button[1]")
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

    @FindBy(css = "*> div > div:nth-child(2) > div > ng-select > div")
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

    @FindBy(css = ".ql-container .ql-editor")
    public static WebElement  Champ_Input_Description_Article;

    @FindBy(css = "div.add-options-message > button.btn.btn-primary.btn-md-2")
    public static WebElement  Bouton_sauvegarder_article;

    @FindBy(css = "div:nth-child(2) > div > app-post-card-useful-information > div > article > div.post-content > a")
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

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-useful-information/section/app-useful-information-detail/div/div/div[1]/div/article/div[6]/app-post-statistics/div/ul/li/a")
    public static WebElement Icone_Commentaire_Article;
    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-useful-information/section/app-useful-information-detail/div/div/div[1]/div/article/div[1]/app-post-parent-reactions/div/div/div[2]")
    public static WebElement Bouton_Commentaire_Article;
    @FindBy(xpath = "div.comments-shared:nth-child(1)")
    public static WebElement Bouton_Repondre_Article;

    @FindBy(css = "li > div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_Article_Afficher;

    @FindBy(css = "form > div > div:nth-child(1) > div > input")
    public static WebElement Champ_Input_Rechercher_Article_Par_Titre;

    @FindBy(css = "div:nth-child(2) > div > app-post-card-useful-information > div")
    public static WebElement Premier_Article_Afficher_Utilisateur;

    @FindBy(css = "div > div.like-action.mr-lg")
    public static WebElement Bouton_Interaction_Article;

    @FindBy(css = ".list-group > li:nth-child(1) > div:nth-child(1)")
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

    @FindBy(xpath = "//div[2]/app-floating-label-form/div/input")
    public static WebElement Champ_Input_Temoin_Nouveau_Duree;

    @FindBy(css = "div:nth-child(2) > app-post-card > div > article > div.post-content > div.tags-container > a")
    public static WebElement Temoin_Premiere_News_Affichee;

    @FindBy(css = "app-news-administration > section > div > div:nth-child(2)")
    public static WebElement Derniere_News_Ajoutee;

    @FindBy(css ="body > ngb-modal-window:nth-child(27) > div > div > app-modal-post > div > div > div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(2) > div > a")
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

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")
    public static WebElement icon_commentaire_news;

    @FindBy(css = "*>div:nth-child(3) > div > div:nth-child(2) > app-post-card-news > div")
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

    @FindBy(css = "div > app-text-input > div > input")
    public static WebElement Champ_Input_Rechercher_Article_Par_titre;

    @FindBy(css = "div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > button.btn.btn-sm.btn-blue.mt-0.btn-post")
    public static WebElement Envoyer_Commenteraire_Modifier_News;

    @FindBy(css = "div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div > div > button:nth-child(2)")
    public static WebElement Bouton_Praise_News;

    @FindBy(xpath ="//div/div[4]/div/app-datepicker/div/div/button")
    public static WebElement Calendrier_recherche_article_par_date_debut;

    @FindBy(xpath ="//span[@class='ng-arrow-wrapper']")
    public static WebElement rechercher_article_categorie;

    @FindBy(xpath ="//div/div[5]/div/app-datepicker/div/div/button")
    public static WebElement Calendrier_recherche_article_par_date_Fin;

    @FindBy(css ="div:nth-child(5) > div > app-datepicker > div > input")
    public static WebElement Champ_Input_Calendrier_article_par_date_Fin;

    // Locators Calendreir et évenements

    @FindBy(css = "div.control-block-button")
    public static WebElement Bouton_Ajout_Evenement;

    @FindBy(css = "body > ngb-modal-window > div > div > app-event-form > div > div.modal-header")
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

    @FindBy(css = "div.default-filter > div:nth-child(1) > div > app-text-input > div > input")
    public static WebElement Champ_Input_invites_interne_evenement;

    @FindBy(css = "div.birthday-author-name")
    public static WebElement Invite_interne_evenement_selectionne;

    @FindBy(xpath = "//button[contains(text(),'Ajouter')]")
    public static WebElement Bouton_Ajouter_Invite_interne_evenement;

    @FindBy(xpath = "//button[contains(text(),'Chercher')]")
    public static WebElement Bouton_Chercher_Invite_interne_evenement;

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

    @FindBy(css = "div.more > ul > li:nth-child(2) > a")
    public static WebElement Bouton_supprimer_evenement;

    @FindBy(css = "div > div.comments-shared > a")
    public static WebElement Bouton_commentaire_evenement;

    @FindBy(css = " div:nth-child(1) > app-post > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(2) > div > a > span")
    public static WebElement Bouton_commentaire_publication;

    @FindBy(css = "div > weavin-emoji-editor > div > quill-editor > div > div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Commentaire_Publication;

    @FindBy(css ="div.form-group.with-icon-right > div > button")
    public static WebElement Bouton_Envoyer_Commentaire_Publication;

    @FindBy(css ="div:nth-child(6) > div > div.row.col-11.ml-1.mt-1 > div:nth-child(5) > a:nth-child(2) > i")
    public static WebElement Bouton_Restaurer_Element;

    @FindBy(css = "div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Commentaire_Evenement;

    @FindBy(css = "div.form-group.with-icon-right > div > button")
    public static WebElement Envoyer_Commentaire_Evenement;

    @FindBy(css = "article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > a > svg")
    public static WebElement Icone_Commentaire_Evenement;

    @FindBy(css = "li > div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_Evenement_Afficher;

    @FindBy(css = "div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div")
    public static WebElement Bouton_Interaction_Evenement;

    @FindBy(css = "div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div > div > button:nth-child(1) > span.reactions-icon-md-LIKE.reactions-menu__icon")
    public static WebElement Bouton_Like_Evenement;

    @FindBy(css = "article > div.post-additional-info.inline-items > app-post-statistics > div > ul > li:nth-child(1) > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Evenement;

    @FindBy(css = "span.inline-svg-icon.reactions-icon-statistic-LIKE.reactions-menu__icon")
    public static WebElement Nombre_Like_Album;

    @FindBy(css = "div.post__author.author.vcard.inline-items > app-more-dropdown > div")
    public static WebElement Bouton_Option_Commentaire;

    @FindBy(css = " div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(1) > a")
    public static WebElement Bouton_Editer_Commentaire;

    @FindBy(xpath = "//li/div[1]/app-post-comment-form/form/div/div[2]/div/div/weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement Champ_Input_Modification_Commenteraire;

    @FindBy(css = "div.parent-item-comment > app-post-comment-form > form > div > div.form-group.with-icon-right > div > button.btn.btn-sm.btn-blue.mt-0.btn-post")
    public static WebElement Envoyer_Commenteraire_Modifier_Evenement;

    @FindBy(css = "div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div > div > button:nth-child(2) > span.reactions-icon-md-PRAISE.reactions-menu__icon")
    public static WebElement Bouton_Praise_Evenement;

    @FindBy(css = "div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Commentaire;

    @FindBy(css = "div.row > div > div > div > ul > li:nth-child(3)")
    public static WebElement Onglet_Mes_Evenements;

    @FindBy(css = "div.author-thumb > span > span:nth-child(2)")
    public static WebElement Bouton_supprimer_photo_profil;

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

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-profile/div/div[2]/app-home/div/div[3]/div[1]/span[1]")
    public static WebElement Citation_Afficher_Profil;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public static WebElement Champ_Input_Profil_Phone;

    @FindBy(css = "div.col.col-xl-3.order-xl-1.col-lg-6.order-lg-2.col-md-6.col-sm-6.col-12 > div > div:nth-child(1) > div.ui-block-content > ul > li:nth-child(2) > span")
    public static WebElement Phone_Afficher_Profil;

    @FindBy(css = "div:nth-child(2) > div.form-group.col-md-4 > app-floating-label-form > div > input")
    public static WebElement Champ_Input_Profil_Auteur;

    @FindBy(xpath = "//input[@id='theField']")
    public static WebElement Champ_Input_Profil_Anniversaire;

    @FindBy(css = " div.ui-block-content > ul > li > span")
    public static WebElement Anniversaire_Afficher_Profil;
    @FindBy(css = "span.authorQuote")
    public static WebElement Auteur_Afficher_Profil;

    @FindBy(xpath = "//a[contains(text(),'Photos')]")
    public static WebElement Menu_photos_profil;

    @FindBy(xpath = "//a[contains(text(),'Vidéos')]")
    public static WebElement Menu_vidéos_profil;

    @FindBy(css = "div.row > div:nth-child(1) > ul > li")
    public static WebElement Menu_Accueil_Profil;

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

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public static WebElement Bouton_OK_Suppression_utilisateur;

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
    public static WebElement Bouton_Supprimer_Connaissance;

    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag-input-form > form > input")
    public static WebElement Champ_Input_Loisirs;

    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag > div > div > div")
    public static WebElement Tag_Loisirs;

    @FindBy(css = "tag-input > div > div > tag:nth-child(2)")
    public static WebElement Tag_Loisirss;


    @FindBy(css = "app-tag-management.hobbies.ng-star-inserted > div > div:nth-child(2) > tag-input > div > div > tag > div > div > delete-icon > span > svg")
    public static WebElement Bouton_Supprimer_loisir;

    @FindBy(css = "#sidebar-right > div > a > svg > use")
    public static WebElement Bouton_Ouvrir_List_Chat;

    @FindBy(css = "div.mCustomScrollbar > perfect-scrollbar > div > div.ps-content > div > div")
    public static WebElement Liste_utilisateurs_Favoris;

    @FindBy(css = "#sidebar-right-1 > div.search-friend.inline-items > div > div > input")
    public static WebElement Champ_Input_Chercher_vos_amis;

    @FindBy(css = " div.author-status > a")
    public static WebElement Utilisateur_Chercher;

    @FindBy(css = " div.w-100.mt-3.actions-filter > button")
    public static WebElement Bouton_chercher_membre_brainstorming;

    @FindBy(css = "div.col-lg-12.p0.chat-input-container > weavin-emoji-editor > div > quill-editor > div > div.ql-editor.ql-blank > p")
    public static WebElement Champ_Input_Message_Chat;

    @FindBy(css = "#media-chat")
    public static WebElement Champ_Input_Image_Chat;

    @FindBy(css = "#file-chat")
    public static WebElement Champ_Input_Fichier_Chat;

    @FindBy(css = "div.options-chat-item.col-lg-12.p0.pull-left > div > button")
    public static WebElement Bouton_Envoyer_Chat;

    @FindBy(css = "span.chat-message-item")
    public static WebElement Message_reçu;


    @FindBy(css = "app-speed-access-user-item > li > div.more")
    public static WebElement Bouton_Ajouter_utilisateur_Favoris;

    @FindBy(css = "app-speed-access-user-item:nth-child(1) > li > div.more > div > svg")
    public static WebElement Bouton_Supprimer_utilisateur_Favoris;

    @FindBy(css = "app-speed-access-user-item:nth-child(1) > li > div.author-status > a")
    public static WebElement Premier_utilisateur_Favoris;

    @FindBy(css = " ul.account-settings > li:nth-child(2) > a")
    public static WebElement Bouton_Configuration_utilisateur;

    @FindBy(xpath = "//a[contains(text(),'Utilisateurs')]")
    public static WebElement Rubrique_utilisateurs;



    @FindBy(css = "div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div.ui-block-title")
    public static WebElement Modal_Gestion_utilisateurs;

    @FindBy(css = "button.btn.btn-primary.mb-0.ml-2.add-user")
    public static WebElement Bouton_Ajouter_Nouvel_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Email_Nouvel_utilisateur;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[5]/div[1]/form[1]/div[1]/div[3]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Email_Modifier_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Prenom_Nouvel_utilisateur;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[5]/div[1]/form[1]/div[1]/div[1]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Prenom_Modifier_utilisateur;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[5]/div[1]/form[1]/div[1]/div[2]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Nom_Modifier_utilisateur;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-registration-user-modal[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-floating-label-form[1]/div[1]/input[1]")
    public static WebElement Champ_Input_Nom_Nouvel_utilisateur;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-registration-user-modal/div/form/div[2]/button[3]")
    public static WebElement Bouton_enregistrer_Nouvel_utilisateur;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[5]/div[1]/form[1]/div[1]/div[5]/button[2]")
    public static WebElement Bouton_enregistrer_Modifier_utilisateur;

    @FindBy(css = "app-text-input > div > input")
    public static WebElement Champ_Input_Chercher_des_membres;

    @FindBy(css = "div.members-settings-container > div > div > div > ul > li:nth-child(3) > a")
    public static WebElement invites_utilisateurs;

    @FindBy(css = "#deactivated")
    public static WebElement inactifs_utilisateurs;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[4]/i[1]")
    public static WebElement Bouton_Modifier_utilisateur;

    @FindBy(css = "i.fas.fa-user-minus")
    public static WebElement Bouton_Remove_Utilisateur;

    @FindBy(css = "app-invited-users div.table-container.edition-mode > div.flex-table.flex-table-header > div.inline-items.inline-icon.nav-hidden > div.checkbox.checkbox-users > label > span > span")
    public static WebElement Bouton_Selectionner_Tous_Utilisateurs;

    @FindBy(css = "app-activated-users > div > div.table-container.edition-mode > div.flex-table.flex-table-header > div.inline-items.inline-icon.nav-hidden > div.checkbox.checkbox-users > label > span > span")
    public static WebElement Bouton_Selectionner_Tous_Utilisateurs_actifs;

    @FindBy(css = "div.inline-items.inline-icon.nav-not-hidden-invited > div:nth-child(2) > i.fad.fa-trash-alt.mr-1")
    public static WebElement Bouton_Remove_Tous_Utilisateurs;

    @FindBy(css = "div.inline-items.inline-icon.nav-not-hidden > div:nth-child(2) > i.fas.fa-cloud-download")
    public static WebElement Bouton_Rapport_Utilisateurs;

    @FindBy(css = "app-invited-users > div > div.table-container.edition-mode > div.flex-table.flex-table-body > div.flex-row.first.position-relative > div.author-container > div.name-container > small")
    public static WebElement Email_Nouvel_utilisateur_Ajoute;

    @FindBy(xpath = "//small[contains(text(),'yassine.gtari@advyteam.com')]")
    public static WebElement Email_utilisateur_desactive;

    @FindBy(xpath = "//span[contains(text(),'Muhammad Karim Ben nasr')]")
    public static WebElement Nom_utilisateur_Modifiee;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-users-settings[1]/div[1]/div[3]/app-invited-users[1]/div[1]/div[1]/div[2]/div[5]/div[1]/form[1]/div[1]/div[4]/app-floating-label-form[1]/div[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
    public static WebElement role_utilisateur;

    @FindBy(css = "div:nth-child(4) > div.flex-row.flex-row-action > i.fas.fa-lock-alt.mr-1")
    public static WebElement Bouton_Désactiver_Utilisateur;

    @FindBy(css = "div.flex-row.flex-row-action > i.fas.fa-lock-open-alt.mr-1")
    public static WebElement Bouton_Activer_Utilisateur;

    @FindBy(css = "div.ql-editor.ql-blank")
    public static WebElement Champ_Input_Publication;

    @FindBy(css = "div.add-options-message > button")
    public static WebElement Bouton_publier_Publication;

    @FindBy(css = "#newsfeed-items-grid > div:nth-child(1) > app-post > article > div.overflow-content-post.container > p")
   public static WebElement Contenu_Publication_Publie;

    @FindBy(css = " div:nth-child(1) > app-post > article > div.post__author.author.vcard.inline-items > app-more-dropdown > div > svg > use")
    public static WebElement Bouton_Options_Publication;

    @FindBy(css = " div:nth-child(1) > app-post > article > div.post__author.author.vcard.inline-items > app-more-dropdown > div > ul > li:nth-child(2) > a")
    public static WebElement Bouton_Supprimer_Publication;

    @FindBy(xpath = "//a[contains(text(),'Corbeille')]")
    public static WebElement Rubrique_Corbeille;

    @FindBy(css = "div:nth-child(4) > div > div.row.col-11.ml-1.mt-1 > div:nth-child(5) > a:nth-child(1) > i")
    public static WebElement Bouton_Corbeille_Supprimer_Publication;

    @FindBy(xpath = "//button[contains(text(),'Oui, je confirme !')]")
    public static WebElement Bouton_Corbeille_Supprimer_Confirmation;

    @FindBy(css = "div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div.ui-block-title")
    public static WebElement Modal_Gestion_publications;

    @FindBy(css = "div:nth-child(4) > div > div.row.col-11.ml-1.mt-1 > div.col-2.mt-3.content-overflow > i")
    public static WebElement Icone_Dernière_element_supprimée;

    @FindBy(xpath = "//a[contains(text(),'Personnaliser')]")
    public static WebElement Rubrique_Personnaliser;

    @FindBy(xpath = "//a[contains(text(),'Gestion des liens utiles')]")
    public static WebElement Sous_Rubrique_Gestion_Liens_utiles;

    @FindBy(xpath = "//a[contains(text(),'Paramètres généraux')]")
    public static WebElement Sous_Rubrique_Parametres_generaux;

    @FindBy(xpath = "//a[contains(text(),'Gestion des catégories')]")
    public static WebElement Sous_Rubrique_Gestion_Catégories;

    @FindBy(css = "div:nth-child(3) > div > span.category-item.add-category-item > svg")
    public static WebElement Bouton_Ajout_Catégorie_Opportunité;

    @FindBy(css = "app-floating-label-form > div > input")
    public static WebElement Champ_Input_Catégorie_Opportunité;

    @FindBy(css = "button.btn.btn-primary.mb-0.ml-2")
    public static WebElement Bouton_Enregistrer_Catégorie_Opportunité;

    @FindBy(css = " li:nth-child(2) > div > a")
    public static WebElement Bouton_Repondre_Opportunité;

    @FindBy(css = "div:nth-child(3) > div > span.category-item.d-flex > div.actions-container.position-relative > svg")
    public static WebElement Bouton_Options_Catégorie_Opportunité;

    @FindBy(css = "div.actions-container.position-relative.acctions-open > div > span:nth-child(1)")
    public static WebElement Bouton_Modifier_Catégorie_Opportunité;

    @FindBy(css = "div.useful-link-settings-header > button")
    public static WebElement Bouton_Ajout_Lien_Utile;

    @FindBy(xpath = "//header/div[1]/div[1]/app-useful-link-list[1]/div[1]")
    public static WebElement Bouton_List_Lien_Utile;

    @FindBy(css = " app-useful-link-list > div > div > div > a > svg")
    public static WebElement Bouton_Ajouter_Lien_Utile_HB;

    @FindBy(css = "div:nth-child(3) > div > div.row.col-11.ml-1.mt-1 > div.row.col-2 > a > i")
    public static WebElement Bouton_Afficher_Commentaire_Publication;

    @FindBy(css = "div.row.col-2 > a > i")
    public static WebElement Icone_Commentaire_supprimée;

    @FindBy(css = "app-modal-useful-link > div.modal-header")
    public static WebElement Modal_ajout_Lien_Utile;

    @FindBy(css = "app-floating-label-form:nth-child(1) > div > input")
    public static WebElement Champ_Input_Titre_Lien_Utile;

    @FindBy(css = "app-modal-useful-link > div.modal-body > form > app-floating-label-form:nth-child(3) > div > input")
    public static WebElement Champ_Input_Lien_Lien_Utile;

    @FindBy(css = "button.btn.btn-md-2.btn-primary")
    public static WebElement Bouton_Modal_Ajouter_Lien_Utile;

    @FindBy(css = "div.useful-link-settings-header > form > div > input")
    public static WebElement Champ_Input_Rechercher_Lien_Utile;

    @FindBy(css = "div.name-container")
    public static WebElement Titre_Premiere_Lien_Utile;

    @FindBy(css = "li:nth-child(1) > span")
    public static WebElement Titre_Premiere_Lien_Utile_List;

    @FindBy(css = "div:nth-child(2) > div.flex-row.flex-row-action > i")
    public static WebElement Bouton_Supprimer_Lien_Utile;

    @FindBy(css = "div:nth-child(3) > div > a > svg")
    public static WebElement Bouton_Invités_Internes;

    @FindBy(css = "li.update-liste > span")
    public static WebElement Bouton_Modifier_Invités_Internes;

    @FindBy(css = "div.swal2-actions > button.swal2-confirm.btn.btn-success.ml-sm")
    public static WebElement Accepter_envoi_mail_evenement;

    @FindBy(css = "div:nth-child(4) > div.upload-controls > div > label > span")
    public static WebElement Bouton_Invités_Externes;

    @FindBy(css = "td:nth-child(1) > ng2-smart-table-cell > table-cell-edit-mode > div > table-cell-default-editor > div > input-editor > input")
    public static WebElement Champ_Input_Nom_User_Externe;

    @FindBy(css = "td:nth-child(2) > ng2-smart-table-cell > table-cell-edit-mode > div > table-cell-default-editor > div > input-editor > input")
    public static WebElement Champ_Input_Email_User_Externe;

    @FindBy(css = "a.ng2-smart-action.ng2-smart-action-add-create")
    public static WebElement Bouton_Ajouter_User_Externe;

    @FindBy(css = "#notifications-tab")
    public static WebElement Bouton_Mes_Invitations;

    @FindBy(css = "a.btn.btn-primary")
    public static WebElement Bouton_Accepter_Ajouter_au_calendrier;

    @FindBy(css = "div.col.col-lg-5.col-md-5.col-sm-12.col-12 > div > guests-by-event > div > div.list-guests > a")
    public static WebElement Bouton_Evenement_liste_Invités;

    @FindBy(css = "div.modal-header > a > svg")
    public static WebElement Bouton_Fermer_liste_Invités;

    @FindBy(css = "div.member.pull-right.avatar-member")
    public static WebElement Invité_Acceptation;

    @FindBy(css = "app-event-detail > div > a > svg")
    public static WebElement Bouton_Fermer_Evenement;

    @FindBy(css = "a.btn.btn-sm.btn-border-think.custom-color.c-grey")
    public static WebElement Bouton_Refuser_Ajouter_au_calendrier;

    @FindBy(css = "app-widget-activity-feed > div > ul > li:nth-child(1) > div > div")
    public static WebElement Premiere_Element_Flux_Activite_Afficher;

    @FindBy(css = "#ngb-nav-5")
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

    @FindBy(xpath = "//*[@id=\"collapseOne\"]/ul/li[2]/a")
    public static WebElement Rubrique_divers;

    @FindBy(css = "app-floating-label-form > div > input")
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

    @FindBy(css = "i.fas.fa-user-minus")
    public static WebElement Bouton_Supprimer_Utilisateur;

    @FindBy(css = "a[id=deactivated]")
    public static WebElement Onglet_inactif_utilisateur;

    @FindBy(css = "div.flex-row.flex-row-action > i.fas.fa-lock-open-alt.mr-1")
    public static WebElement Bouton_Reactiver_Utilisateur;

    @FindBy(css = "app-text-input > div > input")
    public static WebElement Champ_Input_Chercher_des_membres_Rubrique_Annuaire;

    @FindBy(css = "div.w-100.mt-3.text-right > button")
    public static WebElement Bouton_Chercher_des_membres_Annuaire;

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
    public static WebElement Champ_input_titre_Opportunite;

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

    @FindBy(xpath = "//div[2]/div/app-post-card-opportunity/div/article/div[2]/div[3]")
    public static WebElement Premiere_Opportunite_Afficher;

    @FindBy(css = "ul > li:nth-child(1) > div > a")
    public static WebElement Bouton_Like_Opportinite;

    @FindBy(css = "div:nth-child(2) > div > app-post-card-opportunity > div > article > div.post-content > div.post-additional-info.inline-items > app-post-statistics > div > ul > li > span.likes-number.ml-sm")
    public static WebElement Nombre_Like_Premiere_Opportunite_Afficher;

    @FindBy(xpath = "//weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement champ_commentaire_opportunite;

    @FindBy(xpath = "//app-post-comment-form/form/div/div[2]/div/button")
    public static WebElement Bouton_Envoyer_Commentaire_Opportinite;

    @FindBy(xpath = "//app-post-card-opportunity/div/article/div[2]/div[5]/app-post-statistics/div/ul/li/a/span")
    public static WebElement Nombre_Commentaire_Premiere_Opportunite_Afficher;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-opportunity/section/app-opportunity-list/div[3]/div[2]/div/app-post-card-opportunity/div/article/div[2]/div[2]/div/div[2]/button[1]")
    public static WebElement Bouton_Option_Supprimer_Opportunite;

    @FindBy(xpath = "//button[contains(text(),'Oui, je confirme !')]")
    public static WebElement Bouton_Confirmer_Supprimer_Opportunite;

    @FindBy(xpath = "//app-brainstorming-grid/div/div[1]/div")
    public static WebElement Bouton_Ajouter_Vote_Sondage;

    @FindBy(xpath = "//app-select-type-to-add/div[2]/div/a[2]")
    public static WebElement BrainStorming_Vote;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-form-new-vote/div[1]/div[1]/div/div[2]/form/div/div[1]/div/input")
    public static WebElement Champ_Input_Titre_BrainStorming;

    @FindBy(css = "div.field-settings.field-settings-date > div > div > input")
    public static WebElement Champ_Input_Date_BrainStorming;

    @FindBy(xpath = "//div[1]/div/ng-select/div")
    public static WebElement Liste_Affichage_BrainStorming;

    @FindBy(xpath = "//div[1]/div[2]/ul/li[1]")
    public static WebElement Bouton_Choix_Unique_BrainStorming;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div/div/div/div[3]/div[2]/div[1]/div[1]/div[1]/input")
    public static WebElement Champ_Input_Question_BrainStorming;

    @FindBy(xpath = "//div[1]/div[2]/div/textarea")
    public static WebElement Champ_Input_InfoSupp_BrainStorming;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div/div/input")
    public static WebElement Champ_Input_Premiere_Reponse_BrainStorming;

    @FindBy(xpath = "//div[1]/div[3]/a/span")
    public static WebElement Bouton_Ajouter_Reponse_BrainStorming;

    @FindBy(xpath = "//div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/input")
    public static WebElement Champ_Input_Deuxieme_Reponse_BrainStorming;

    @FindBy(xpath = "//app-form-new-vote/div[2]/div/button")
    public static WebElement Bouton_Enregistrer_Vote;

    @FindBy(xpath = "//div[1]/div/div[1]/div/a[2]")
    public static WebElement Onglet_BrainStorming;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[2]/div[2]/div/a")
    public static WebElement  Description_Premier_Vote_Afficher;

    @FindBy(xpath = "//div/div[1]/div[1]/div[2]/ul/li[2]")
    public static WebElement  Bouton_Choix_Multiple_BrainStorming;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[2]/div[1]/div[2]")
    public static WebElement  Bouton_Option_Vote;

    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div[1]/div[2]/ul/li[2]/a")
    public static WebElement  Bouton_Option_Editer_Vote;

    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div[1]/div[2]/ul/li[3]/a")
    public static WebElement  Bouton_Option_Supprimer_Vote;

    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div[3]/a")
    public static WebElement  Bonton_Lancer_Premier_Vote_Afficher;

    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div[1]/div[1]/span")
    public static WebElement  Etat_Premier_Vote_Afficher;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[2]/div[3]/a")
    public static WebElement  Bouton_Participez_Premier_Vote_Afficher;

    @FindBy(xpath = "//div/div/div[2]/div/div[1]/label/span[1]")
    public static WebElement  Premier_Choix_Vote_Brainstorming;

    @FindBy(xpath = "//div[2]/div[3]/form/div/div/button")
    public static WebElement  Envoyer_Vote_Brainstorming;

    @FindBy(css = "#pdfTable > p")
    public static WebElement  Accuser_De_reception_Brainstorming;

    @FindBy(xpath = "//div[2]/div/div[2]/label/span")
    public static WebElement  Deuxieme_Choix_Vote_Brainstorming;

    @FindBy(xpath = "//div[1]/div[2]/ul/li[1]/a")
    public static WebElement  Bouton_Option_Cloturer_Vote;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-form-new-vote/div[1]/div[1]/div/div[2]/form/div/div[2]/div[4]/div/button")
    public static WebElement  Bouton_Ajouter_Membre;

    @FindBy(xpath = "//div/app-text-input/div/input")
    public static WebElement  Filtrer_Par_Nom_BrainStorming;

    @FindBy(xpath = "//app-users-selection/div[2]/div[2]/div/div/div")
    public static WebElement  Membre_Afficher_Brainstorming;

    @FindBy(xpath = "//div/app-users-selection/div[3]/button[2]")
    public static WebElement  Bouton_Ajouter_Menbre_BrainStorming;

    @FindBy(xpath = "//div/div/div/button")
    public static WebElement  Calendrier_BrainStorming;

    @FindBy(xpath = "//div/app-widget-flash-infos/div/div/a")
    public static WebElement  Bouton_Ajouter_Flash_Info;

    @FindBy(xpath = "//div/form/app-floating-label-form[1]/div/input")
    public static WebElement  titre_flash_info;

    @FindBy(xpath = "//app-floating-label-form[2]/div/textarea")
    public static WebElement  description_flash_info;

    @FindBy(xpath = "//div/app-flash-infos-list/div/form/button[2]")
    public static WebElement  Bouton_Enregistrer_Flash_Info;

    @FindBy(xpath = "//ul/li/app-flash-infos-item/article/div")
    public static WebElement  Premiere_Flash_Info_Ajouter;

    @FindBy(css = "#aside-custom-left > div > app-widget-flash-infos > div > app-flash-infos-list > ul > a")
    public static WebElement  Bouton_Voir_Tous_Flash_Info;

    @FindBy(xpath = "//form/div/div/div[1]/div/app-text-input/div/input")
    public static WebElement  Rechercher_Flash_Info_Par_Titre;

    @FindBy(xpath = "//div[2]/div/div/article/div/span")
    public static WebElement  Flash_Info_Rechercher;

    @FindBy(xpath = "//li[1]/app-flash-infos-item/article/app-more-dropdown/div")
    public static WebElement  Bouton_Option_Flash_Info;

    @FindBy(xpath = "//li[1]/app-flash-infos-item/article/app-more-dropdown/div/ul/li[2]/a")
    public static WebElement  Bouton_Supprimer_Flash_Info;

    @FindBy(xpath = "//div[2]/div/app-datepicker/div/div/button")
    public static WebElement  Calendrier_Date_Debut_Flash_Info;

    @FindBy(xpath = "//div/div[3]/div/app-datepicker/div/div/button")
    public static WebElement  Calendrier_Date_Fin_Flash_Info;

    @FindBy(xpath = "//section/app-opportunity-list/div[2]/div/div/div/ul/span[1]/li/a")
    public static WebElement  Bouton_Premiere_Opportunite;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/app-stream-line-post-form/div/div/form/div[2]/div/a/input")
    public static WebElement  Input_Media_TImeLine;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-monetization/app-donation-compaign/section/app-donation-compaign-list/div[2]/div/div/div/button")
    public static WebElement  Bouton_Ajout_Compagne_De_Don;

    @FindBy(xpath = "//div/div/div/div/div/span[3]")
    public static WebElement  Modal_ajout_Don;

    @FindBy(xpath = "//div/form/div[1]/div[1]/div[1]/input")
    public static WebElement  Champ_Input_Titre_Don;

    @FindBy(xpath = "//div[2]/quill-editor/div[2]/div[1]/p")
    public static WebElement  Descriptif_Compagne_De_Don;

    @FindBy(xpath = "//app-floating-label-form/div/div/input")
    public static WebElement  Date_Cloture_Don;

    @FindBy(xpath = "//div/form/div[1]/div[1]/div[3]/div[2]/input")
    public static WebElement  Heure_Cloture_Don;

    @FindBy(xpath = "//div[1]/div/app-floating-label-form/div/input")
    public static WebElement  Objectif_Compagne_Don;

    @FindBy(xpath = "//div[5]/div[1]/div/div/div[1]/input")
    public static WebElement  Montant_Don;

    @FindBy(xpath = "//div[1]/div/label/app-floating-label-form/div/div/label/span")
    public static WebElement  Bouton_Montant_Libre;

    @FindBy(xpath = "//div[2]/div/label/app-floating-label-form/div/div/label")
    public static WebElement  Bouton_Montant_Collecter;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-monetization/app-donation-compaign/section/app-donation-compaign-list/app-donation-compaign-form/div/div/div/div/form/div[2]/button[1]\n")
    public static WebElement  Bouton_Sauvegarder_Don;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[2]/div/input")
    public static WebElement  H_Upload_photo_Don;

    @FindBy(xpath = "//div/table/tr[2]/td[1]/span")
    public static WebElement  Etat_Compagne_Don;

    @FindBy(xpath = "//div[2]/div[2]/div/a")
    public static WebElement  Bouton_Faire_Un_Don;

    @FindBy(xpath = "//form/div[2]/div[1]")
    public static WebElement  Montant_Du_Don;

    @FindBy(xpath = "//div/div/form/div[3]/input")
    public static WebElement  Titulaire_de_la_carte;

    @FindBy(css = "span + input.StripeField--fake")
    public static WebElement  Numero_Carte;

    @FindBy(xpath = "//app-donation-modal/div/div/form/button")
    public static WebElement  Bouton_Valider_Un_Don;

    @FindBy(css = "body > ngb-modal-window:nth-child(27) > div > div > app-modal-post > div > div > div.open-photo-content > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div")
    public static WebElement  Bouton_aime_News;

    @FindBy(css = "ul > li:nth-child(1) > div > a")
    public static WebElement  Bouton_aime_Album;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-rooms/div[1]/div/div[1]")
    public static WebElement  Boutton_Ajouter_Bulle;

    @FindBy(css = "#name")
    public static WebElement  Champ_Input_Name_Bulle;

    @FindBy(css = "#create-friend-group > div > div > div.modal-body > form > div:nth-child(2) > input")
    public static WebElement  Champ_Input_Sujet_Bulle;

    @FindBy(css = "form > div:nth-child(2) > input")
    public static WebElement Champ_Input_Modifier_Sujet_Bulle;

    @FindBy(css = "div:nth-child(3) > ng-select > div > div > div.ng-input")
    public static WebElement  Liste_Type_Bulle;

    @FindBy(css = "#update-room > div > div > div.modal-body > form > div:nth-child(5) > input")
    public static WebElement  Champ_Input_Apropos_Bulle;

    @FindBy(css = "#update-room > div > div > div.modal-body > form > div:nth-child(6) > input")
    public static WebElement  Champ_Input_Email_Bulle;

    @FindBy(css = "div:nth-child(5) > div > a")
    public static WebElement  Boutton_Inviter_Membres_Bulle;

    @FindBy(css = "#create-friend-group > div > div > div.modal-body > button")
    public static WebElement Bouton_Créer_Bulle;

    @FindBy(css = "div:nth-child(1) > div > app-text-input > div > input")
    public static WebElement Champ_input_Filtre_Nom_Bulle;

    @FindBy(css = ".card-container-list:nth-child(2) div.ui-block div.friend-item.friend-groups.position-relative div.friend-item-content.pb-0 div.friend-avatar.mb-1 div.author-content > a.h5.author-name")
    public static WebElement Titre_Bulle_Rechercher;

    @FindBy(css = "div.profile-section > div.control-block-button > div > a")
    public static WebElement Boutton_Modifier_Bulle;

    @FindBy(css = "div.top-header-thumb > a > label > i")
    public static WebElement Boutton_Modifier_photo_Bulle;

    @FindBy(css = "#modal-uplaod-photo > div > div > div.modal-body > a")
    public static WebElement H_Upload_photo_Bulle;

    @FindBy(css = "#modal-uplaod-photo > div > div > div.modal-body > div > a > svg")
    public static WebElement Boutton_Enregistre_photo_Bulle;

    @FindBy(css = "#update-room > div > div > div.modal-body > button.btn.btn-primary.btn-lg.btn--half-width.ml-3")
    public static WebElement Boutton_Enregistre_Modifier_Bulle;

    @FindBy(css = "div.top-header-author > div.author-content.room-details > a")
    public static WebElement  Titre_Bulle_Page;

    @FindBy(css = "#textInput")
    public static WebElement Champ_Input_Message_Bulle;

    @FindBy(css = "button.btn.btn-primary.btn-lg.btn--half-width.delete-button")
    public static WebElement Boutton_Supprimer_Bulle;

    @FindBy(css = "div.modal-footer > button.btn.btn-primary")
    public static WebElement Boutton_Confirmation_Supprimer_Bulle;

    @FindBy(css = "a > a > svg")
    public static WebElement Boutton_Reaction_Message_Bulle;

    @FindBy(css = "a > button.reaction-like")
    public static WebElement Boutton_aime_Message_Bulle;

    @FindBy(css = "ul > li:nth-child(2) > span")
    public static WebElement  Nombre_Like_Message_Bulle;

    @FindBy(css = "div > span:nth-child(3) > a > svg")
    public static WebElement Bouton_upload_photo_Bulle;

    @FindBy(css = "#create-photo-album > div > div > div.modal-body > a.btn.btn-primary.btn-lg.btn--half-width")
    public static WebElement Bouton_Publier_Album_Bulle;

    @FindBy(css = "span:nth-child(2) > a > svg")
    public static WebElement Bouton_Upload_Pièce_Jointe_Bulle;

    @FindBy(css = "#modal-uplaod-photo > div > div > div.modal-body > a")
    public static WebElement Champ_Input_Fichier_Message_Bulle;

    @FindBy(css = "a.btn.btn-primary.btn-lg.btn--half-width.btn-file")
    public static WebElement Bouton_Publier_Fichier_Bulle;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-chat-discussion/div[11]/div/div/div[2]/div/div/div/div/input")
    public static WebElement H_Upload_photo_Mesage_Bulle;

    @FindBy(css = "span:nth-child(1) > a > svg")
    public static WebElement  Bouton_Create_Sondage_Bulle;

    @FindBy(css = "div.modal-body.poll-modal > form > div.form-group.label-floating > input")
    public static WebElement  Champ_Input_Question_Sondage;

    @FindBy(css = "div.ng-untouched.ng-pristine.ng-invalid > div > div > input")
    public static WebElement  Champ_Input_Option1_Sondage;

    @FindBy(css = "#modal-add-sondage > div > div > div.modal-body.poll-modal > a > svg")
    public static WebElement  Bouton_Ajouter_Option_Sondage;

    @FindBy(css = "div.ng-dirty.ng-touched.ng-invalid > div:nth-child(2) > div > input")
    public static WebElement  Champ_Input_Option2_Sondage;

    @FindBy(css = " app-post-statistics > div > ul > li:nth-child(2) > a > svg")
    public static WebElement  Bouton_Modificaton_commentaire;

    @FindBy(css = "#modal-add-sondage > div > div > div.modal-body.poll-modal > div > button")
    public static WebElement  Bouton_Lancer_Sondage;

    @FindBy(css = "app-chat-conversations-message-item:nth-child(15) > li > div > div.reaction-chat > app-post-reactions > div > ul > li > div > div > button:nth-child(1) > span")
    public static WebElement  Bouton_Reaction_Message_Chat;

    @FindBy(xpath = "//div[1]/app-post[1]/article[1]/div[1]/app-more-dropdown[1]/div[1]")
    public static WebElement  bouton_option_premiere_publication_afficher;

    @FindBy(xpath = "//div[1]/app-post/article/div[1]/app-more-dropdown/div/ul/li[1]/a")
    public static WebElement  bouton_option_Editer_premiere_publication_afficher;

    @FindBy(xpath = "//div/div/app-modal-update-post/app-stream-line-post-form/div/div/form/weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement  champ_statut_modification;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-update-post/app-stream-line-post-form/div/div/form/div[2]/button")
    public static WebElement  bouton_publier_statut_modifer;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-update-post/app-stream-line-post-form/div/div/form/div[3]/button")
    public static WebElement  bouton_publier_statut_modiferr;

    @FindBy(xpath = "//div[1]/app-post/article/div[1]/app-more-dropdown/div/ul/li[2]/a")
    public static WebElement  bouton_option_Supprimer_premiere_publication_afficher;

    @FindBy(xpath = "//div/weavin-emoji-editor/div/quill-editor/div/div[1]")
    public static WebElement  champ_commentaire_statut;

    @FindBy(xpath = "//div[1]/app-post/article/div[5]/app-post-reactions/div/ul/li[2]/div/a/span")
    public static WebElement  bouton_commenter_statut;

    @FindBy(xpath = "//div[1]/app-post/app-post-comment-form/form/div/div[2]/div/button")
    public static WebElement  bouton_envoyer_commentaire_statut;

    @FindBy(xpath = "//app-post/article/div[5]/app-post-reactions/div/ul/li[1]/div/a/span[2]")
    public static WebElement  bouton_Liker_statut;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/div/div[1]/app-post/app-post-comment-form/form/div/div[2]/div/div/weavin-emoji-editor/div/quill-editor/div/div[3]/ul/li")
    public static WebElement  premier_membre_afficher;

    @FindBy(xpath = "//div[1]/app-post/article/div[5]/app-post-statistics/div/ul/li[2]/a")
    public static WebElement  bouton_commentaire_timeline;

    @FindBy(xpath = "//app-post-comment/li/div[1]/div[1]/app-more-dropdown/div")
    public static WebElement  bouton_option_commentaire;

    @FindBy(xpath = "//div[1]/div[1]/app-more-dropdown/div/ul/li[2]/a")
    public static WebElement  bouton_option_supprimer_commentaire;

    @FindBy(xpath = "//app-post/app-post-comments-list/div/ul/app-post-comment/li/div[1]/div[1]/app-more-dropdown/div/ul/li[1]/a")
    public static WebElement  bouton_option_editer_commentaire_timeline;

    @FindBy(xpath = "//app-post-comments-list/div/ul/app-post-comment/li/div[1]/app-post-comment-form/form/div/div[2]/div/div/weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement  champ_cemmentaire_modification_timeline;

    @FindBy(xpath = "//app-post/app-post-comments-list/div/ul/app-post-comment/li/div[1]/app-post-comment-form/form/div/div[2]/div/button[1]")
    public static WebElement  bouton_envoyer_commentaire_timeline_modifier;

    @FindBy(xpath = "//div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/div[1]/p")
    public static WebElement  premier_commentaire_afficher_time_line;

    @FindBy(css = " form > weavin-emoji-editor > div > quill-editor > div > div.ql-mention-list-container.ql-mention-list-container-bottom > ul > li:nth-child(1)")
    public static WebElement  premier_membre_afficher_TimeLine;

    @FindBy(css =  "div.ps-content > div > p")
    public static WebElement Texte_Publication_Popup ;

    @FindBy(css = " div > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(2) > div")
    public static WebElement Bouton_Repondre_Statut_Popup ;

    @FindBy(css =  "div > article > div.post-additional-info.inline-items > app-post-reactions > div > ul > li:nth-child(1) > div")
    public static WebElement Bouton_Like_Statut_Popup ;

    @FindBy(xpath = "//div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-comment-form/form/div/div[2]/div/div/weavin-emoji-editor/div/quill-editor/div/div[1]/p")
    public static WebElement champ_input_sous_commentaire_statut;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/div/div[1]/app-post/article/div[5]/app-post-statistics/div/ul/li/a/span")
    public static WebElement Logo_commentaire_statut;

    @FindBy(xpath = "//span[contains(text(),'Répondre')]")
    public static WebElement bouton_interagir_commentaire;

    @FindBy(xpath = "//div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-comment-form/form/div/div[2]/div/button")
    public static WebElement Envoyer_sous_commentaire;

    @FindBy(xpath = "//div/ul/app-post-comment/li/div[2]/app-post-statistics/div/ul/li/a/span")
    public static WebElement Logo_sous_commentaire_statut;

    @FindBy(xpath = "//*[@id=\"newsfeed-items-grid\"]/div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-sub-comments/ul/li/div[1]/div/div[1]/app-more-dropdown/div/ul/li[1]/a")
    public static WebElement Bouton_Editer_Sous_Commentaire;

    @FindBy(xpath = "//*[@id=\"newsfeed-items-grid\"]/div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-sub-comments/ul/li/div[1]/div/div[1]/app-more-dropdown/div")
    public static WebElement Bouton_Option_Sous_Commentaire;

    @FindBy(css = "div.row > div:nth-child(1) > ul > li > a")
    public static WebElement Bouton_Accueil ;

    @FindBy(css = "div.parent-item-comment > p")
    public static WebElement Premiere_Commentaire_album_Afficher;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post/div/div/div[2]/article/div[3]/app-post-reactions/div/ul/li[1]/div/div/button[2]/span[2]")
    public static WebElement  Bouton_reaction_praise ;

    @FindBy(xpath = "//*[@id=\"newsfeed-items-grid\"]/div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-sub-comments/ul/li/div[1]/div/div[1]/app-more-dropdown/div/ul/li[2]/a")
    public static WebElement Bouton_Supprimer_Sous_Commentaire;

    @FindBy(xpath = "//div[1]/app-post/article/div[1]/app-more-dropdown/div/ul/li/a")
    public static WebElement  bouton_option_Supprimer_premiere_publication_afficher_admin;

    @FindBy(xpath = "//main/app-stream-line-post/div/div[1]/app-post/article/div[5]/app-post-statistics/div/ul/li")
    public static WebElement  bouton_commentaire_timeline_administrateur;

    @FindBy(xpath = "//div/ul/app-post-comment/li/div[1]/div[1]/app-more-dropdown/div/ul/li/a")
    public static WebElement  bouton_option_supprimer_commentaire_administrateur;

    @FindBy(xpath = "//a[contains(text(),' App store ')]")
    public static WebElement  app_store;

    @FindBy(xpath = "/html/body/app-root/app-layout-administration/div[2]/app-panel-admin/div/div[1]/div/div[2]/app-app-store/div/div[1]/button")
    public static WebElement  Bouton_Configurer_youtube;

    @FindBy(xpath = "//*[contains(text(),' Enregistrer ')]")
    public static WebElement  Bouton_Enregistrer_Configuration_youtube;

    @FindBy(xpath = "//div/div[2]/app-app-store/app-youtube/form/div[1]/div[1]/div[3]/div[2]/label/app-floating-label-form/div/div")
    public static WebElement  Bouton_Desactiver_youtube;

    @FindBy(xpath = "//div/div[2]/app-app-store/app-youtube/form/div[1]/div[2]/app-tuto-slider/div/div[1]/a/div/div[1]")
    public static WebElement  Modal_Configuration_youtube;

    @FindBy(xpath = "//h3[contains(text(),'Étape 1:')]")
    public static WebElement  Titre_Modal_configuration_Youtube;

    @FindBy(css = "#aside-custom-right > div > app-widget-news > div > div > div.news-content-container > div > div.news-text-container > div:nth-child(1) > div.news-details > div.badge-small.mb-1 > small")
    public static WebElement Temoin_Premiere_News_Affichee_accueil;

    @FindBy(css = "#aside-custom-right")
    public static WebElement Barre_Temoin_Premiere_News_Affichee_accueil;

    @FindBy(css = "#aside-custom-right > div > app-widget-news > div > div > div.all-news")
    public static WebElement widget_News_Affichee_accueil;

    @FindBy(css = "div.container.wrapper-portal > app-all-news > div.row > div:nth-child(1) > app-post-card-news > div > article > div.post-content > a")
    public static WebElement Titre_derniere_news;

    @FindBy(css = "app-app-store > div > div:nth-child(5) > button")
    public static WebElement Bouton_Configurer_google_drive;

    @FindBy(css = "div > div.togglebutton.m0 > label > app-floating-label-form > div > div > label > span")
    public static WebElement Bouton_Desactiver_google_drive;

    @FindBy(xpath = "//*[contains(text(),' Enregistrer ')]")
    public static WebElement Bouton_Enregistrer_Configuration_google_drive;

    @FindBy(css = "app-app-store > div > div.app-card.item.item-one-drive > button")
    public static WebElement Bouton_Configurer_one_drive;

    @FindBy(css = "div.togglebutton.m0 > label > app-floating-label-form > div > div > label > span")
    public static WebElement Bouton_Desactiver_one_drive;

    @FindBy(xpath = "//*[contains(text(),' Enregistrer ')]")
    public static WebElement Bouton_Enregistrer_Configuration_one_drive;


    @FindBy(css = "app-invited-users > div >div.table-container.edition-mode > div:nth-child(2) > div.flex-row.first.position-relative > div.author-container > div.name-container > span")
    public static WebElement Nom_Nouvel_utilisateur_Ajoute;

    @FindBy(css = " div.container-fluid > app-panel-admin > div > div.col.col-xl-9.order-xl-2.col-lg-9.order-lg-2.col-md-12.order-md-1.col-sm-12.col-12 > div > div.ui-block-content.background-grey > app-deleted-publications > div > div:nth-child(4) > div > div.row.col-11.ml-1.mt-1 > div.col-2.mt-3.content-overflow")
    public static WebElement Contenu_Dernier_Element_Supprimé;

    @FindBy(css = "#newsfeed-items-grid > div:nth-child(1) > app-post > article > div.overflow-content-post.container > p > span > a")
    public static WebElement Premiere_publication_afficher;

    @FindBy(css = "div.ui-block-content.background-grey > app-app-store > div > div.app-card.item.item-vimeo > button")
    public static WebElement Bouton_Configurer_vimeo;

    @FindBy(css = "div.togglebutton.m0 > label > app-floating-label-form > div > div > label > span")
    public static WebElement Bouton_Desactiver_vimeo;

    @FindBy(xpath = "//*[contains(text(),' Enregistrer ')]")
    public static WebElement Bouton_Enregistrer_Configuration_vimeo;

    @FindBy(css = " div > div.ui-block-content.background-grey > app-app-store > div > div.app-card.item.item-twitter > button")
    public static WebElement Bouton_Configurer_twitter;

    @FindBy(css = "div.togglebutton.m0 > label > app-floating-label-form > div > div > label > span")
    public static WebElement Bouton_Desactiver_twitter;

    @FindBy(xpath = "//*[contains(text(),' Enregistrer ')]")
    public static WebElement Bouton_Enregistrer_Configuration_twitter;
    @FindBy(css = "#cdk-drop-list-1 > div > div > div > div.ui-block-content > div.not-collapsed-question > div.question-body > div.question-field.mb-3 > div.basic-info > input")
    public static WebElement Champ_Input_Modifie_Question_BrainStorming;

    @FindBy(css = "body > ngb-modal-window:nth-child(27) > div > div > app-acknowledgment-vote > div.close-modal")
    public static WebElement Bouton_fermer_popup_Brainstorming;

    @FindBy(css = "app-brainstorming-grid > div > div:nth-child(2) > div > div > div > div.card-content > div.control-block-button > a")
    public static WebElement resultat_vote;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div[1]/input")
    public static WebElement Champ_Input1_Question_BrainStorming;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/textarea")
    public static WebElement Champ_Input1_InfoSupp_BrainStorming;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div/div/input")
    public static WebElement Champ_Input1_Premiere_Reponse_BrainStorming;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[3]/a/span")
    public static WebElement Bouton_Ajouter1_Reponse_BrainStorming;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/input")
    public static WebElement Champ_Input1_Deuxieme_Reponse_BrainStorming;

    @FindBy(css = "div.containerFormNews > div.fieldsTxt > div.form-group.description > quill-editor > div.ql-container.ql-snow > div.ql-editor > p")
    public static WebElement Champ_Input_modifie_Description_News;

    @FindBy(css = "div.actions-container.position-relative.acctions-open > div > span:nth-child(2)")
    public static WebElement Bouton_Supprimer_Catégorie_Opportunité;

    @FindBy(css = ".ng-select  .ng-select-container")
    public static WebElement Liste_Deroulante_vimeo_TypeSource;

    @FindBy(css = "body > ngb-modal-window:nth-child(27) > div > div > app-modal-post > a > svg")
    public static WebElement Bouton_Fermer_News;

    @FindBy(css = ".sidebar--small [title=News]")
    public static WebElement Bouton_news2_menu_gauche;

    @FindBy(css = "app-floating-label-form:nth-child(2) > div > input")
    public static WebElement chaine_id_vimeo;

    @FindBy(css = "div.form-group.col.col-lg-6.col-md-6.col-sm-12.col-12 > app-floating-label-form:nth-child(4) > div > input")
    public static WebElement nombre_video_afficher_vimeo;

    @FindBy(css = "app-floating-label-form:nth-child(1) > div > input")
    public static WebElement nom_utilisateur_twitter;

    @FindBy(css = "app-floating-label-form:nth-child(2) > div > input")
    public static WebElement cle_consommateur_twitter;

    @FindBy(css = "app-floating-label-form:nth-child(3) > div > input")
    public static WebElement cle_securite_twitter;

    @FindBy(css = "app-floating-label-form:nth-child(4) > div > input")
    public static WebElement jeton_acces_twitter;

    @FindBy(css = "app-floating-label-form:nth-child(5) > div > input")
    public static WebElement jeton_secret_acces_twitter;

    @FindBy(css = "div.reaction-chat > app-post-reactions")
    public static WebElement  Icone_Reaction_Message_Chat;


    @FindBy(xpath = "//app-about/div/div/form/div[1]/div/div/div[2]/app-floating-label-form/div/div/input")
    public static WebElement profil_utilisateur_date_anniversaire;

    @FindBy(xpath = "//body/app-root[1]/app-layout-administration[1]/div[2]/app-panel-admin[1]/div[1]/div[1]/div[1]/div[2]/app-dynamic-fields[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")
    public static WebElement  Bouton_Ajouter_Champ_information;

    @FindBy(xpath = "//app-panel-admin/div/div[1]/div/div[2]/app-dynamic-fields/div/div/div[1]/form/div/div/div/div/div[2]/div[1]/input")
    public static WebElement  titre_nouveau_champ_profil_utilisateur;

    @FindBy(xpath = "//button[contains(text(),'Enregistrer')]")
    public static WebElement  Bouton_Enregistrer_information_supplementaire;

    @FindBy(css = ".far.fa-cog")
    public static WebElement  Ajouter_Restriction_Timeline;

    @FindBy(css = "div.row > div:nth-child(1) > div > ng-select > div")
    public static WebElement  Liste_Restriction_Timline_Par_Connaissance;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post-restriction/div[3]/button[2]")
    public static WebElement  Bouton_Ajouter_Restriction_Timeline;

    @FindBy(css = "#theField > div")
    public static WebElement  Liste_Restriction_Timline_Par_Loisir;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post-restriction/div[2]/div/div[3]")
    public static WebElement  Bouton_Autre_Critere_Timeline;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post-restriction/div[2]/div/div[4]/div/div/ng-select")
    public static WebElement  Liste_nouveau_filtre_timeline;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post-restriction/div[2]/div/div[4]/div/div/ng-select")
    public static WebElement  Bouton_ajouter_nouveau_filtre;

    @FindBy(xpath = "//textarea[@name='Résumé']")
    public static WebElement  Champ_Input_Profil_resume;

    @FindBy(xpath = "//a[contains(text(),'Réseaux sociaux')]")
    public static WebElement  rubrique_reseaux_sociaux;
    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/div/div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-sub-comments/ul/li/div[1]/div/div/div[2]/a")
    public static WebElement Nom_membres_sous_commentaire;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/div/div[1]/app-post/app-post-comments-list/div/ul/app-post-comment/li/app-post-sub-comments/ul/li/div[1]/div/app-post-comment-form/form/div/div[2]/div/div")
    public static WebElement  Input_Champs_Sous_commentaire_Modifie;

    @FindBy(css = "div:nth-child(2) > div > div > div > ul > li > a")
    public static WebElement  Boutton_Les_categorie;

    @FindBy(xpath = "//div[2]/div/div/form/div[1]/div[1]/app-floating-label-form/div/span/input")
    public static WebElement  Champ_reseau_facebook;

    @FindBy(xpath = "//*[@id=\"headingOne-1\"]/h5/a")
    public static WebElement Titre_Event_Affiche;

    @FindBy(xpath = "div:nth-child(1) > app-post > article > div.overflow-content-post.container > p > font > font")
    public static WebElement Derniere_Publication_publie;

    @FindBy(xpath = "#message201 > div.notification-event.min-width-7 > span")
    public static WebElement Sondage_Bulle_Teamlab;

    @FindBy(xpath = "//*[@id=\"bigContainer pb-2\"]/div[4]/div[2]/div[2]")
    public static WebElement Message_Bulle_Teamlab;

    @FindBy(xpath = "/html/body/app-root/app-layout-administration/div[2]/app-panel-admin/div/div[1]/div/div[2]/app-app-store/app-vimeo/form/div[1]/div[1]/app-floating-label-form[3]/div/input")
    public static WebElement  Champs_Token;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-portal/div/div/main/app-stream-line-post/div/div[1]/app-post/app-post-comment-form/form/div[1]/div[2]/div/button")
    public static WebElement  bouton_envoyer_commentaire_statutt;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-post/div/div/div[2]/article/div[3]/app-post-statistics/div/ul/li[2]")
    public static WebElement  Icone_Commentaire_Album;

    @FindBy(xpath = "//html/body/ngb-modal-window[2]/div/div/app-modal-post/div/div/div[2]/article/div[4]/app-post-reactions/div/ul/li[2]/div")
    public static WebElement  Bouton_Repondre_newss;

    @FindBy(xpath = "/html/body/ngb-modal-window[2]/div/div/app-modal-post/div/div/div[2]/article/div[4]/app-post-reactions/div/ul/li[1]/div")
    public static WebElement  Bouton_like_newss;

    @FindBy(xpath = "/html/body/ngb-modal-window[2]/div/div/app-modal-post/div/div/div[2]/article/div[4]/app-post-statistics/div/ul")
    public static WebElement  Bouton_Commentairee;

    @FindBy(css = " div.save-button.text-right.mt-5 > button")
    public static WebElement  Bouton_Enregistrer_Informations_Supp;

    @FindBy(css = "app-invited-users > div > div.table-container.edition-mode > div:nth-child(2) > div.flex-row.first.position-relative > div.author-container > div.name-container")
    public static WebElement  Nouvel_user_Ajoute;

    @FindBy(xpath = "//div[2]/app-about/div/div[1]/div/app-additional-information/div[2]/form/div[1]/div/app-floating-label-form/div/input")
    public static WebElement  Champ_Input_information_supplementaire;

    @FindBy(xpath = "//*[@id=\"collapseOne\"]/ul/li[2]/a")
    public static WebElement  rubrique_information_supplementaire;

    @FindBy(xpath = "//div[2]/app-about/div/div[1]/div/app-additional-information/div[2]/form/div[2]/button")
    public static WebElement  enregistrer_information_supplementaire;


    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> CN_map = new HashMap<>();
        Field[ ] allFields = ConnectObjects.class.getFields();
        for (Field field : allFields) {
            CN_map.put(field.getName(), (WebElement) field.get(field));
        }
        return CN_map;
    }


}
