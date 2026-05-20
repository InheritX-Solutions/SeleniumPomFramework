package businesslogic;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import objectRepository.HomepageOR;
import utilities.CommonMethods;
import utilities.ExtentReportBuilder;

public class HomepageLogoD extends ExtentReportBuilder {

    CommonMethods cm = new CommonMethods();
    Duration due = Duration.ofSeconds(20);

    public void validateLogo(WebDriver driver) throws IOException, ParseException {
        try {
            cm.waitUntillVisibilityOfElement(driver, HomepageOR.LOGO, due);
            if (cm.isElementPresent(driver, HomepageOR.LOGO)) {
                ReportTestStep("QAfox logo validated", "PASS", "");
            } else {
                ReportTestStep("QAfox logo NOT visible", "FAIL", "");
            }
        } catch (Exception e) {
            ReportTestStep("Exception in validateLogo", "FAIL", e.getMessage());
            Assert.fail();
        }
    }

    public void selectDollar(WebDriver driver) throws IOException, ParseException {
        try {
            cm.click(driver, HomepageOR.CURRENCY_DROPDOWN);
            cm.click(driver, HomepageOR.CURRENCY_USD);
            ReportTestStep("USD currency selected", "PASS", "");
        } catch (Exception e) {
            ReportTestStep("Exception in selectDollar", "FAIL", e.getMessage());
            Assert.fail();
        }
    }

    public void registerUser(WebDriver driver, String fname, String lname, String email,
                             String phone, String pwd) throws IOException, ParseException {
        try {
            cm.click(driver, HomepageOR.MY_ACCOUNT);
            cm.click(driver, HomepageOR.REGISTER);
            cm.setText(driver, HomepageOR.FIRSTNAME, fname);
            cm.setText(driver, HomepageOR.LASTNAME, lname);
            cm.setText(driver, HomepageOR.EMAIL, "vijendra_" + System.currentTimeMillis() + "@test.com");
            cm.setText(driver, HomepageOR.TELEPHONE, phone);
            cm.setText(driver, HomepageOR.PASSWORD, pwd);
            cm.setText(driver, HomepageOR.CONFIRM_PASSWORD, pwd);
            cm.click(driver, HomepageOR.PRIVACY_CHECKBOX);
            cm.click(driver, HomepageOR.CONTINUE_BTN);

            if (cm.isElementPresent(driver, HomepageOR.SUCCESS_MSG)) {
                ReportTestStep("User Registered Successfully", "PASS", "");
            } else {
                ReportTestStep("Registration Failed", "FAIL", "");
            }
        } catch (Exception e) {
            ReportTestStep("Exception in registerUser", "FAIL", e.getMessage());
            Assert.fail();
        }
    }

    public void searchProduct(WebDriver driver, String product) throws IOException, ParseException {
        try {
            if (product == null || product.isEmpty()) return;
            cm.setText(driver, HomepageOR.SEARCH_BOX, product);
            cm.click(driver, HomepageOR.SEARCH_BUTTON);

            List<WebElement> names = driver.findElements(HomepageOR.PRODUCT_NAME);
            List<WebElement> prices = driver.findElements(HomepageOR.PRODUCT_PRICE);

            for (int i = 0; i < names.size(); i++) {
                ReportTestStep("Product Found", "PASS",
                        "Name: " + names.get(i).getText() + " | Price: " + prices.get(i).getText());
            }
        } catch (Exception e) {
            ReportTestStep("Exception in searchProduct", "FAIL", e.getMessage());
            Assert.fail();
        }
    }

    public void searchAllProducts(WebDriver driver) throws IOException, ParseException {
        try {
            searchProduct(driver, "MacBook");
            searchProduct(driver, "iPhone");
            searchProduct(driver, "Samsung");
        } catch (Exception e) {
            ReportTestStep("Exception in searchAllProducts", "FAIL", e.getMessage());
            Assert.fail();
        }
    }

    public void checkoutHP(WebDriver driver) throws IOException, ParseException {
        try {
            cm.setText(driver, HomepageOR.SEARCH_BOX, "HP LP3065");
            cm.click(driver, HomepageOR.SEARCH_BUTTON);
            cm.click(driver, HomepageOR.HP_PRODUCT);
            cm.click(driver, HomepageOR.ADD_TO_CART);
            cm.click(driver, HomepageOR.CHECKOUT);

            if (cm.isElementPresent(driver, HomepageOR.ORDER_SUCCESS)) {
                ReportTestStep("Order placed successfully", "PASS", "");
            } else {
                ReportTestStep("Order placement failed", "FAIL", "");
            }
        } catch (Exception e) {
            ReportTestStep("Exception in checkoutHP", "FAIL", e.getMessage());
            Assert.fail();
        }
    }
}
