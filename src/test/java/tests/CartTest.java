package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(priority = 1)
    public void addProductToCart() throws InterruptedException {
        test = extent.createTest("Add Product to Cart");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Login first
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Product added"));
        driver.switchTo().alert().accept();
        test.pass("Product successfully added to cart.");
    }

    @Test(priority = 2)
    public void viewCartWithAddedProducts() throws InterruptedException {
        test = extent.createTest("View Cart With Added Products");
        driver.get("https://www.demoblaze.com/cart.html");
        Thread.sleep(2000);

        boolean productVisible = driver.findElements(By.xpath("//td[text()='Samsung galaxy s6']")).size() > 0;
        Assert.assertTrue(productVisible);
        test.pass("Cart displays the added product.");
    }

    @Test(priority = 3)
    public void removeProductFromCart() throws InterruptedException {
        test = extent.createTest("Remove Product From Cart");
        driver.get("https://www.demoblaze.com/cart.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Delete']")).click();
        Thread.sleep(3000);

        boolean productStillVisible = driver.findElements(By.xpath("//td[text()='Samsung galaxy s6']")).size() > 0;
        Assert.assertFalse(productStillVisible);
        test.pass("Product removed from cart successfully.");
    }

    @Test(priority = 4)
    public void addMultipleProductsToCart() throws InterruptedException {
        test = extent.createTest("Add Multiple Products to Cart");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Add first product
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("nava")).click();
        Thread.sleep(2000);

        // Add second product
        driver.findElement(By.linkText("Sony xperia z5")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Go to cart
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(3000);

        boolean product1 = driver.getPageSource().contains("Nokia lumia 1520");
        boolean product2 = driver.getPageSource().contains("Sony xperia z5");
        Assert.assertTrue(product1 && product2);
        test.pass("Both products added and visible in the cart.");
    }
} 
