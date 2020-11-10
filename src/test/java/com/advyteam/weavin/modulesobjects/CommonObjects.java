package com.advyteam.weavin.modulesobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

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

    @FindBy(css = ".sidebar--small [title=\"Know'store\"]")
    public static WebElement Bouton_knowstore_menu_gauche;

    @FindBy(css = ".sidebar--small [title=Idéation]")
    public static WebElement Bouton_ideation_menu_gauche;

    @FindBy(css = ".sidebar--small [title='Calendrier & événements']")
    public static WebElement Bouton_calendrier_menu_gauche;

    @FindBy(css = ".sidebar--small [title=News]")
    public static WebElement Bouton_news_menu_gauche;

    @FindBy(xpath = "//h6[contains(text(),\"Flux d'activité\")]")
    public static WebElement Widget_flux_activite;

    @FindBy(xpath = "//label[contains(text(),'Filtrer par mot-clé')]")
    public static WebElement Balise_filtre_annuaire;

    @FindBy(css = ".h4")
    public static WebElement titre_page_knowstore;

    @FindBy(css = ".h4")
    public static WebElement titre_page_ideation;

    @FindBy(css = "#events-tab")
    public static WebElement titre_page_calendrier;

    @FindBy(css = ".h4")
    public static WebElement titre_page_news;

    @FindBy(css = "#swal2-title")
    public static WebElement Message_resultat_action;





    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> COMMON_map = new HashMap<>();
        Field[] allFields = CommonObjects.class.getFields();
        for (Field field : allFields) {
            COMMON_map.put(field.getName(), (WebElement) field.get(field));
        }
        return COMMON_map;
    }
}
