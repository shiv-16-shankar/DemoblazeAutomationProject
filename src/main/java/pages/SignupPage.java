package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    By signupLink = By.id("signin2");
    By username = By.id("sign-username");
    By password = By.id("sign-password");
    By signupBtn = By.xpath("//button[text()='Sign up']");

    public void signUp(String user, String pass) throws InterruptedException {
        driver.findElement(signupLink).click();
        Thread.sleep(2000);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signupBtn).click();
        Thread.sleep(2000);
    }
}
