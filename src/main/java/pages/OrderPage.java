package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    By placeOrder = By.xpath("//button[text()='Place Order']");
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By card = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By purchase = By.xpath("//button[text()='Purchase']");

    public void placeOrder() throws InterruptedException {
        driver.findElement(placeOrder).click();
        Thread.sleep(1000);
        driver.findElement(name).sendKeys("Shiv");
        driver.findElement(country).sendKeys("India");
        driver.findElement(city).sendKeys("Chennai");
        driver.findElement(card).sendKeys("123456");
        driver.findElement(month).sendKeys("06");
        driver.findElement(year).sendKeys("2025");
        driver.findElement(purchase).click();
        Thread.sleep(2000);
    }
}
