package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
        test = extent.createTest("Login with Valid Credentials");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("Password@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        boolean isLoggedIn = driver.findElements(By.id("logout2")).size() > 0;
        Assert.assertTrue(isLoggedIn);
        test.pass("Logged in successfully with valid credentials.");
    }

    @Test(priority = 2)
    public void loginWithWrongPassword() throws InterruptedException {
        test = extent.createTest("Login with Incorrect Password");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("Kumar6868");
        driver.findElement(By.id("loginpassword")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Wrong password"));
        driver.switchTo().alert().accept();
        test.pass("Correctly handled wrong password alert: " + alertText);
    }

    @Test(priority = 3)
    public void loginWithEmptyFields() throws InterruptedException {
        test = extent.createTest("Login with Empty Fields");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password."));
        driver.switchTo().alert().accept();
        test.pass("Empty field validation handled correctly: " + alertText);
    }

    @Test(priority = 4)
    public void loginWithInvalidEmailFormat() throws InterruptedException {
        test = extent.createTest("Login with Invalid Email Format");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("user.com");
        driver.findElement(By.id("loginpassword")).sendKeys("password123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.length() > 0);
        driver.switchTo().alert().accept();
        test.pass("Invalid email format correctly raised alert: " + alertText);
    }

    @Test(priority = 5)
    public void verifyPasswordIsMasked() throws InterruptedException {
        test = extent.createTest("Verify Password Field is Masked");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);

        String inputType = driver.findElement(By.id("loginpassword")).getAttribute("type");
        Assert.assertEquals(inputType, "password");
        test.pass("Password input is properly masked with type='password'.");
    }
}
