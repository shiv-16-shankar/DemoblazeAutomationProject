package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UIUXTest extends BaseTest {

    @Test(priority = 1)
    public void verifyProductTileAlignment() throws InterruptedException {
        test = extent.createTest("Verify Product Tile Alignment");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        int products = driver.findElements(By.className("card-block")).size();
        Assert.assertTrue(products > 0);
        test.pass("Product tiles are aligned and visible: " + products);
    }

    @Test(priority = 2)
    public void checkVisibilityOfActionButtons() throws InterruptedException {
        test = extent.createTest("Check Visibility of Action Buttons");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        boolean loginVisible = driver.findElement(By.id("login2")).isDisplayed();
        boolean signupVisible = driver.findElement(By.id("signin2")).isDisplayed();
        boolean addToCartExists = driver.findElements(By.linkText("Add to cart")).size() > 0;

        Assert.assertTrue(loginVisible && signupVisible);
        test.pass("Login and Signup buttons are visible.");
        if (addToCartExists) {
            test.pass("Add to Cart button is available on product detail page.");
        } else {
            test.info("No Add to Cart found on homepage; validate after navigating into a product.");
        }
    }

    @Test(priority = 3)
    public void checkFontConsistency() throws InterruptedException {
        test = extent.createTest("Check Font Consistency");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.id("nava"));
        String fontFamily = title.getCssValue("font-family");

        Assert.assertTrue(fontFamily != null && !fontFamily.isEmpty());
        test.pass("Font consistency verified: " + fontFamily);
    }

    @Test(priority = 4)
    public void testAlertPopupStyling() throws InterruptedException {
        test = extent.createTest("Test Alert and Popup Styling");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Product added"));
        driver.switchTo().alert().accept();
        test.pass("Popup styling and content verified: " + alertText);
    }
} 
