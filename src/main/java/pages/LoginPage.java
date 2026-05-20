package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By signInButton = By.cssSelector("input[type='submit'][value='Login']");

    public LoginPage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public LoginPage enterEmail(String email) {
        log.info("Entering email");
        elementUtil.sendKeys(emailInput, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Entering password");
        elementUtil.sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage clickSignIn() {
        log.info("Clicking sign in button");
        elementUtil.click(signInButton);
        return this;
    }

    public boolean isLoginFormVisible() {
        log.info("Checking login form visibility");
        return elementUtil.isDisplayed(emailInput);
    }

    public boolean isLoggedIn() {
        log.info("Checking if login was successful");
        return elementUtil.isDisplayed(By.linkText("Edit your account information"));
    }
}
