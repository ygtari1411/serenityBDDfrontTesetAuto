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

    @FindBy(css = "#site-header")
    public static WebElement Acceuil_header;

    @FindBy(css = "div.author-title")
    public static WebElement Username_menu;




    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> COMMON_map = new HashMap<>();
        Field[] allFields = CommonObjects.class.getFields();
        for (Field field : allFields) {
            COMMON_map.put(field.getName(), (WebElement) field.get(field));
        }
        return COMMON_map;
    }
}
