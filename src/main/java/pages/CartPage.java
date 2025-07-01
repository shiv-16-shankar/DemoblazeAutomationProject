package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By productLink = By.linkText("Samsung galaxy s6");
    By addToCartButton = By.xpath("//a[text()='Add to cart']");
    By cartNavLink = By.id("cartur");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000); // Wait for products to load
    }

    public void selectProduct() throws InterruptedException {
        driver.findElement(productLink).click();
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        driver.findElement(addToCartButton).click();
        Thread.sleep(2000);

        // Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void goToCart() throws InterruptedException {
        driver.findElement(cartNavLink).click();
        Thread.sleep(2000);
    }

    public boolean isProductInCart(String productName) {
        try {
            return driver.findElement(By.xpath("//td[text()='" + productName + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
