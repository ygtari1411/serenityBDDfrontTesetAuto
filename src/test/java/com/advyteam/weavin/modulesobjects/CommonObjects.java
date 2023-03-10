package com.advyteam.weavin.modulesobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class CommonObjects extends PageObject {


    @FindBy(css = ".submit")
    public static WebElement login_button;

    @FindBy(css = "#username")
    public static WebElement champ_username;

    @FindBy(css = "#password")
    public static WebElement champ_password;

    @FindBy(xpath = "//span[contains(text(),'Se déconnecter')]")
    public static WebElement logout_button;

    @FindBy(css = "#v")
    public static WebElement Bouton_afficher_mdp;

    @FindBy(css = "#site-header")
    public static WebElement Acceuil_header;

    @FindBy(css = "div.author-title")
    public static WebElement Username_menu;

    @FindBy(css = ".account-settings")
    public static WebElement Menu_parametres_comptes;

    @FindBy(xpath = "//a[@title='Ouvrir le menu']")
    public static WebElement Bouton_ouvrir_menu_gauche;

    @FindBy(css = ".olymp-close-icon.left-menu-icon")
    public static WebElement Bouton_fermer_menu_gauche;

    @FindBy(css = ".sidebar--small [title=Accueil]")
    public static WebElement Bouton_accueil_menu_gauche;

    @FindBy(css = ".sidebar--small [title=Annuaire]")
    public static WebElement Bouton_annuaire_menu_gauche;

    @FindBy(css = "#sidebar-left > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(4) > a > div > svg > use")
    public static WebElement Bouton_knowstore_menu_gauche;

    @FindBy(css = ".sidebar--small [title=Idéations]")
    public static WebElement Bouton_ideation_menu_gauche;

    @FindBy(css = "#sidebar-left > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(7) > a > div > svg")
    public static WebElement Bouton_Teamlab_menu_gauche;

    @FindBy(css = "#sidebar-left > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(6) > a > div > svg")
    public static WebElement Bouton_calendrier_menu_gauche;

    @FindBy(css = "#sidebar-left > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(11) > a > div > svg")
    public static WebElement Bouton_news_menu_gauche;

    @FindBy(css = "#sidebar-left-1 > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(1) > a > div")
    public static WebElement Bouton_Fermer_menu_gauche;

    @FindBy(css = ".sidebar--small [title=Dashboard] ")
    public static WebElement Bouton_Dashboard_menu_gauche;


    @FindBy(xpath = "//h6[contains(text(),\"Flux d'activité\")]")
    public static WebElement Widget_flux_activite;

    @FindBy(xpath = "//label[contains(text(),'Filtrer par membre')]")
    public static WebElement Balise_filtre_annuaire;

    @FindBy(css = ".h4")
    public static WebElement titre_page_knowstore;

    @FindBy(css = ".h4")
    public static WebElement titre_page_ideation;

    @FindBy(css = "div.row > div > div > div > ul > li:nth-child(1)")
    public static WebElement titre_page_calendrier;

    @FindBy(css = "div.title-section.mb-4 > span")
    public static WebElement titre_page_news;

    @FindBy(css = "#swal2-title")
    public static WebElement Message_resultat_action;

    @FindBy(css = ".swal2-confirm.btn")
    public static WebElement Bouton_confirmer_action;

    @FindBy(css = "#site-header > div > div > app-notification-list > div")
    public static WebElement Bouton_Notifications;

    @FindBy(css = "app-notification-list > div > div > ngb-tabset > ul > li:nth-child(2)")
    public static WebElement Bouton_Notifications_Evenement;

    @FindBy(css = "ul > li:nth-child(1) > div.notification-event > div")
    public static WebElement Premiere_Notification_Afficher;

    @FindBy(css = "#T2-panel > perfect-scrollbar > div > div.ps-content > div > ul > li:nth-child(1) > div.notification-event > div")
    public static WebElement Premiere_Notification_Evenement_Afficher;

    @FindBy(xpath = "//*[@id=\"T1-panel\"]/perfect-scrollbar/div/div[1]/div/ul/li[2]")
    public static WebElement Deuxieme_Notification_Afficher;

    @FindBy(css = "#site-header > div > div > div:nth-child(1) > app-chat-notification-list > div")
    public static WebElement Bouton_Notifications_Chat;

    @FindBy(css = "app-chat-notification-item > li > div.notification-event")
    public static WebElement Premiere_Notification_chat_Afficher;

    @FindBy(xpath = "//span[contains(text(),'Paramètres du Profil')]")
    public static WebElement Menu_parametres_profil;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]")
    public static WebElement Rubrique_Personnaliser;

    @FindBy(css = ".sidebar--small [title=Opportunités]")
    public static WebElement Bouton_Opportunite_menu_gauche;

    @FindBy(xpath = "//div[3]/ng-select/div/span")
    public static WebElement Liste_Category_Opportunite;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/app-main-menu/div/div[1]/div/perfect-scrollbar/div/div[1]/ul/div/li[9]")
    public static WebElement Bouton_BrainStorming_Menu_Gauche;

    @FindBy(xpath = "//*[@id=\"aside-custom-left\"]/div/app-widget-flash-infos/div/div/h6")
    public static WebElement widget_flash_info;

    @FindBy(css = "#sidebar-left > div > perfect-scrollbar > div > div.ps-content > ul > div > li:nth-child(10) > a")
    public static WebElement Bouton_Don_menu_gauche;

    @FindBy(xpath = "//label[contains(text(),'Filtrer par nom')]")
    public static WebElement Balise_filtre_teamlab;

    @FindBy(css = " div.title-section.mb-4 > span")
    public static WebElement titre_page_opportunite;

    @FindBy(css = "div.title-section.mb-4 > span")
    public static WebElement titre_page_campagnes_dons;

    @FindBy(css = "div:nth-child(1) > div.text-center.mt-3.mb-4 > h5")
    public static WebElement titre_Statistique_dashboard;

    @FindBy(xpath = "//*[@id=\"sidebar-left-1\"]/div/perfect-scrollbar/div/div[1]/ul/div/li[9]")
    public static WebElement Bouton_BrainStorming_Menu_Gauche_Ouvert;

    @FindBy(xpath = "//*[@id=\"sidebar-left-1\"]/div/perfect-scrollbar/div/div[1]/ul/div/li[9]")
    public static WebElement Statistique_connexion_dashboard;

    @FindBy(xpath = "//a[contains(text(),'Profil utilisateur')]")
    public static WebElement Sous_Rubrique_Parametres_Profil_Utilisateur;




    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> COMMON_map = new HashMap<>();
        Field[] allFields = CommonObjects.class.getFields();
        for (Field field : allFields) {
            COMMON_map.put(field.getName(), (WebElement) field.get(field));
        }
        return COMMON_map;
    }
}
