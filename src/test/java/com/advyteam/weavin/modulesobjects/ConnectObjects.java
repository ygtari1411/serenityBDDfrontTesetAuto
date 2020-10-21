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



    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> CN_map = new HashMap<>();
        Field[] allFields = ConnectObjects.class.getFields();
        for (Field field : allFields) {
            CN_map.put(field.getName(), (WebElement) field.get(field));
        }
        return CN_map;
    }


}
