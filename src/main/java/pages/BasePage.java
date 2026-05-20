package pages;

import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final ElementUtil elementUtil;

    protected BasePage(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver, timeoutSeconds);
    }
}
