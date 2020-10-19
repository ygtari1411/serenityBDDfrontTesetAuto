package utilities;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Utilitie {

    @Managed
    WebDriver driver;

    public Utilitie (WebDriver driver){
        this.driver = driver;
    }
    public void pause(WebDriver driver, int time) throws InterruptedException {
        synchronized (driver) {
            driver.wait(time);
        }
    }
}
