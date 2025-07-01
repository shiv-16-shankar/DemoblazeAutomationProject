// ✅ File: tests/ProductNavigationTest.java
package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductBrowsingTest extends BaseTest {

    @Test(priority = 1)
    public void browsePhonesCategory() throws InterruptedException {
        test = extent.createTest("Browse Phones Category");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Phones")).click();
        Thread.sleep(2000);

        boolean phonesVisible = driver.findElements(By.xpath("//a[contains(text(),'Samsung') or contains(text(),'Nexus') or contains(text(),'Iphone')]")).size() > 0;
        Assert.assertTrue(phonesVisible);
        test.pass("Phones category displayed successfully.");
    }

   

    @Test(priority = 2)
    public void viewProductDetails() throws InterruptedException {
        test = extent.createTest("View Product Details");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000);

        boolean detailVisible = driver.findElements(By.xpath("//h2[contains(text(),'Samsung galaxy s6')]")).size() > 0;
        Assert.assertTrue(detailVisible);
        test.pass("Product detail page loaded successfully.");
    }

    @Test(priority = 3)
    public void navigateToHomeFromNavbar() throws InterruptedException {
        test = extent.createTest("Navigate to Home from Navbar");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Home ']")).click();
        Thread.sleep(2000);

        boolean homepageLoaded = driver.findElements(By.id("nava")).size() > 0;
        Assert.assertTrue(homepageLoaded);
        test.pass("Successfully navigated to homepage using navbar.");
    }

    @Test(priority = 4)
    public void navigateUsingNavbarLinks() throws InterruptedException {
        test = extent.createTest("Navigate Using Navbar Links");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("nava")).click(); // Click brand to go back home
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
        Thread.sleep(2000);

        boolean contactVisible = driver.findElements(By.id("exampleModalLabel")).size() > 0;
        Assert.assertTrue(contactVisible);
        test.pass("Navigation through navbar links verified successfully.");
    }
} // END ProductNavigationTest
