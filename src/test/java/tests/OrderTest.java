package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @Test(priority = 1)
    public void placeOrderWithValidDetails() throws InterruptedException {
        test = extent.createTest("Place Order With Valid Details");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Login
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        // Add item
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // Open cart
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(3000);

        // Place order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);

        // Fill form
        driver.findElement(By.id("name")).sendKeys("Shiv K");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("card")).sendKeys("1234 5678 9012 3456");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(3000);

        boolean confirmationVisible = driver.findElements(By.xpath("//h2[text()='Thank you for your purchase!']")).size() > 0;
        Assert.assertTrue(confirmationVisible);
        test.pass("Order placed successfully with valid data.");
    }

    @Test(priority = 2)
    public void placeOrderWithEmptyForm() throws InterruptedException {
        test = extent.createTest("Place Order With Empty Form");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Login
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        // Add item
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // Open cart
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(3000);

        // Place order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);

        // Leave form empty
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000);

        boolean stillOnForm = driver.findElements(By.id("orderModalLabel")).size() > 0;
        Assert.assertTrue(stillOnForm);
        test.pass("Empty form did not proceed with order, validation correct.");
    }

    @Test(priority = 3)
    public void verifyOrderConfirmationPopup() throws InterruptedException {
        test = extent.createTest("Verify Order Confirmation Popup");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Login
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        // Add item
        driver.findElement(By.linkText("Sony xperia z5")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // Open cart
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(3000);

        // Place order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);

        // Fill form
        driver.findElement(By.id("name")).sendKeys("Shiv K");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("card")).sendKeys("1234 5678 9012 3456");
        driver.findElement(By.id("month")).sendKeys("11");
        driver.findElement(By.id("year")).sendKeys("2025");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(3000);

        String confirmationText = driver.findElement(By.cssSelector(".sweet-alert > h2")).getText();
        Assert.assertTrue(confirmationText.contains("Thank you for your purchase!"));
        test.pass("Order confirmation popup verified successfully.");
    }
} // END OrderTest

