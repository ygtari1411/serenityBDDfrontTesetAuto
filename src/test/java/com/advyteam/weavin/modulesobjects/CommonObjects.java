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
    @CacheLookup
    public static WebElement login_button;

    @FindBy(css = "#username")
    @CacheLookup
    public static WebElement champ_username;

    @FindBy(css = "#password")
    @CacheLookup
    public static WebElement champ_password;




    public static Map<String, WebElement> objectsMapper() throws IllegalAccessException {
        Map<String, WebElement> COMMON_map = new HashMap<>();
        Field[] allFields = CommonObjects.class.getFields();
        for (Field field : allFields) {
            COMMON_map.put(field.getName(), (WebElement) field.get(field));
        }
        return COMMON_map;
    }
}
