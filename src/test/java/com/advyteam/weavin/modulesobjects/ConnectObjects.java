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

    @FindBy(css = ".btn.btn-success")
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

    @FindBy(css = "input[ng-reflect-name=\"titleNews\"]")
    public static WebElement Champ_Input_Titre_News;

    @FindBy(xpath = "/html/body/app-root/app-layout-portal/div[2]/app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[2]/div/weavin-editor/div/quill-editor/div[2]/div[1]/p")
    public static WebElement Champ_Input_Description_News;

    @FindBy(xpath = "//app-news-administration/div/div/news-form/div/div/form/div[1]/div[1]/div[3]/div[1]/div/app-floating-label-form/div/div/input")
    public static WebElement Champ_Input_Date_News;





    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> CN_map = new HashMap<>();
        Field[] allFields = ConnectObjects.class.getFields();
        for (Field field : allFields) {
            CN_map.put(field.getName(), (WebElement) field.get(field));
        }
        return CN_map;
    }


}
