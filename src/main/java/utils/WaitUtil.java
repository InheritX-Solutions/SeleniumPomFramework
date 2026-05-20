package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptions.ElementNotFoundException;

public class WaitUtil {
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new ElementNotFoundException("Element not visible: " + locator, e);
        }
    }

    public static WebElement waitForClickable(WebDriver driver, By locator, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            throw new ElementNotFoundException("Element not clickable: " + locator, e);
        }
    }
}
