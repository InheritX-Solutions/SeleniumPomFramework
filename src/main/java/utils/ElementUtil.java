package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import exceptions.FrameworkException;

public class ElementUtil {
    private static final Logger log = LogManager.getLogger(ElementUtil.class);
    private final WebDriver driver;
    private final int timeout;

    public ElementUtil(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.timeout = timeoutSeconds;
    }

    public void click(By locator) {
        try {
            log.info("Clicking element: {}", locator);
            WebElement element = WaitUtil.waitForClickable(driver, locator, timeout);
            element.click();
        } catch (Exception e) {
            throw new FrameworkException("Unable to click element: " + locator, e);
        }
    }

    public void sendKeys(By locator, String text) {
        try {
            log.info("Typing text into element {}: {}", locator, text);
            WebElement element = WaitUtil.waitForVisibility(driver, locator, timeout);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new FrameworkException("Unable to enter text into element: " + locator, e);
        }
    }

    public String getText(By locator) {
        try {
            log.info("Getting text from element: {}", locator);
            return WaitUtil.waitForVisibility(driver, locator, timeout).getText();
        } catch (Exception e) {
            throw new FrameworkException("Unable to get text from element: " + locator, e);
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            return WaitUtil.waitForVisibility(driver, locator, timeout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
