package utilities;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilitie {

    @Managed
    WebDriver driver;

    public static Properties readers() throws IOException {

        Properties config = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/serenity.properties");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        assert fis != null;
        fis.close();
        return config;
    }
}
