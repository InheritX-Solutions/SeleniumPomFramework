package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtil {
    private final WebDriver driver;

    public JSUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        WebElement element = WaitUtil.waitForVisibility(driver, locator, 10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(By locator) {
        WebElement element = WaitUtil.waitForVisibility(driver, locator, 10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
