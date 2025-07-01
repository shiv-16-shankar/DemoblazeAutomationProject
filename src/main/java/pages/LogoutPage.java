package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By logout = By.id("logout2");

    public void logout() throws InterruptedException {
        driver.findElement(logout).click();
        Thread.sleep(2000);
    }
}
