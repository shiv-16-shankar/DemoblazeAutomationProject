package tests;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponsiveDesignTest extends BaseTest {

    @Test
    public void verifyNoHorizontalScroll() throws InterruptedException {
        test = extent.createTest("Responsive Design - No Horizontal Scroll");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        // Resize window to mobile size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812)); // iPhone X size
        Thread.sleep(2000);

        // Execute JavaScript to detect horizontal scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scrollWidth = (Long) js.executeScript("return document.documentElement.scrollWidth;");
        Long clientWidth = (Long) js.executeScript("return document.documentElement.clientWidth;");

        if (scrollWidth > clientWidth) {
            test.fail("Page is NOT responsive. Horizontal scroll detected.");
            Assert.fail("Horizontal scroll exists. Page is not responsive.");
        } else {
            test.pass("Page is responsive. No horizontal scroll.");
        }
    }
} // END ResponsiveDesignTest
