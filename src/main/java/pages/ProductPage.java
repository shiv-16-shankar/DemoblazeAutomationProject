package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By phones = By.linkText("Phones");
    By laptops = By.linkText("Laptops");
    By monitors = By.linkText("Monitors");
    By productLink = By.linkText("Apple monitor 24");

    public void browseCategories() throws InterruptedException {
        driver.findElement(laptops).click();
        Thread.sleep(2000);
        driver.findElement(phones).click();
        Thread.sleep(2000);
        driver.findElement(monitors).click();
        Thread.sleep(2000);
    }

    public void viewProductDetails() throws InterruptedException {
        driver.findElement(productLink).click();
        Thread.sleep(2000);
    }
}
