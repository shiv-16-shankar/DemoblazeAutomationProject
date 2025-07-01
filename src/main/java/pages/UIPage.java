package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIPage {
    WebDriver driver;

    public UIPage(WebDriver driver) {
        this.driver = driver;
    }

    By login = By.id("login2");
    By signup = By.id("signin2");
    By cart = By.id("cartur");
    By cards = By.className("card");

    public boolean areButtonsVisible() {
        return driver.findElement(login).isDisplayed() &&
               driver.findElement(signup).isDisplayed() &&
               driver.findElement(cart).isDisplayed();
    }

    public int getCardCount() {
        return driver.findElements(cards).size();
    }

    public String getFont() {
        return driver.findElement(By.tagName("body")).getCssValue("font-family");
    }
}

