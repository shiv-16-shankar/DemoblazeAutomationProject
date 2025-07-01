package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class SignupTest extends BaseTest {

    public String generateUniqueUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 5);
    }

    @Test(priority = 1)
    public void signUpWithUniqueCredentials() throws InterruptedException {
        test = extent.createTest("Signup with Unique Credentials");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        String username = generateUniqueUsername();
        driver.findElement(By.id("signin2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Sign up successful."));
        driver.switchTo().alert().accept();
        test.pass("User successfully signed up with username: " + username);
    }

    @Test(priority = 2)
    public void signUpWithExistingUsername() throws InterruptedException {
        test = extent.createTest("Signup with Existing Username");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("signin2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("sign-username")).sendKeys("Kumar6868");
        driver.findElement(By.id("sign-password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("This user already exist."));
        driver.switchTo().alert().accept();
        test.pass("Correctly handled existing username: 'shiv_2025'.");
    }

    @Test(priority = 3)
    public void signUpWithEmptyFields() throws InterruptedException {
        test = extent.createTest("Signup with Empty Fields");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("signin2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password."));
        driver.switchTo().alert().accept();
        test.pass("Correctly validated alert for empty signup fields.");
    }
}