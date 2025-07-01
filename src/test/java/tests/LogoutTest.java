// ✅ File: tests/LogoutTest.java
package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogoutAfterLogin() throws InterruptedException {
        test = extent.createTest("Logout After Login");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Log in first
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        // Click Logout
        driver.findElement(By.id("logout2")).click();
        Thread.sleep(2000);

        // Verify login button is visible again
        boolean loginVisible = driver.findElement(By.id("login2")).isDisplayed();
        Assert.assertTrue(loginVisible);
        test.pass("Successfully logged out and returned to homepage.");
    }
} // END LogoutTest
