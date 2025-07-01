package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ResponsivePage {
    WebDriver driver;

    public ResponsivePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isResponsive() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scroll = (Long) js.executeScript("return document.body.scrollWidth;");
        Long client = (Long) js.executeScript("return document.documentElement.clientWidth;");
        return scroll <= client;
    }
}
