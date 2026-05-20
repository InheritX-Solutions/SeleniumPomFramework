package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationEngine.ApplicationSetup;
import businesslogic.HomepageLogoD;
import utilities.CommonUtilities;
import utilities.ExtentReportBuilder;

public class HomepageTC extends ApplicationSetup {

    HomepageLogoD home = new HomepageLogoD();
    CommonUtilities commonutilities = new CommonUtilities();

    @SuppressWarnings("deprecation")
    @Test(groups = { "Smoke", "Regression" }, priority = 1)
    @Parameters({ "browser" })
    public void validateLogoTC(String browser) throws Exception {
        ExtentReportBuilder.ReportInitialization("Validate Logo - " + browser);
        try {
            commonutilities.browserTCcounter(browser);
            home.validateLogo(driver);
            ExtentReportBuilder.ReportTestStep("validateLogoTC Passed", "PASS", commonutilities.generateRandomNumericString());
            ExtentReportBuilder.CompleteTest();
        } catch (Exception e) {
            ExtentReportBuilder.ReportTestStep("Error in validateLogoTC", "ERROR", e.getMessage());
            ExtentReportBuilder.CompleteTest();
            Assert.fail();
        }
    }

    @SuppressWarnings("deprecation")
    @Test(groups = { "Smoke", "Regression" }, priority = 2)
    @Parameters({ "browser" })
    public void selectDollarTC(String browser) throws Exception {
        ExtentReportBuilder.ReportInitialization("Select Currency - " + browser);
        try {
            commonutilities.browserTCcounter(browser);
            home.selectDollar(driver);
            ExtentReportBuilder.ReportTestStep("selectDollarTC Passed", "PASS", commonutilities.generateRandomNumericString());
            ExtentReportBuilder.CompleteTest();
        } catch (Exception e) {
            ExtentReportBuilder.ReportTestStep("Error in selectDollarTC", "ERROR", e.getMessage());
            ExtentReportBuilder.CompleteTest();
            Assert.fail();
        }
    }

    @SuppressWarnings("deprecation")
    @Test(groups = { "Smoke", "Regression" }, priority = 3)
    @Parameters({ "browser" })
    public void registerUserTC(String browser) throws Exception {
        ExtentReportBuilder.ReportInitialization("Register User - " + browser);
        try {
            commonutilities.browserTCcounter(browser);
            home.registerUser(driver, "Vijendra", "Raika", "vijendra@test.com", "9876543210", "Test@123");
            ExtentReportBuilder.ReportTestStep("registerUserTC Passed", "PASS", commonutilities.generateRandomNumericString());
            ExtentReportBuilder.CompleteTest();
        } catch (Exception e) {
            ExtentReportBuilder.ReportTestStep("Error in registerUserTC", "ERROR", e.getMessage());
            ExtentReportBuilder.CompleteTest();
            Assert.fail();
        }
    }

    @SuppressWarnings("deprecation")
    @Test(groups = { "Smoke", "Regression" }, priority = 4)
    @Parameters({ "browser" })
    public void searchProductsTC(String browser) throws Exception {
        ExtentReportBuilder.ReportInitialization("Search Products - " + browser);
        try {
            commonutilities.browserTCcounter(browser);
            home.searchAllProducts(driver);
            ExtentReportBuilder.ReportTestStep("searchProductsTC Passed", "PASS", commonutilities.generateRandomNumericString());
            ExtentReportBuilder.CompleteTest();
        } catch (Exception e) {
            ExtentReportBuilder.ReportTestStep("Error in searchProductsTC", "ERROR", e.getMessage());
            ExtentReportBuilder.CompleteTest();
            Assert.fail();
        }
    }

    @SuppressWarnings("deprecation")
    @Test(groups = { "Smoke", "Regression" }, priority = 5)
    @Parameters({ "browser" })
    public void checkoutHP_TC(String browser) throws Exception {
        ExtentReportBuilder.ReportInitialization("Checkout HP - " + browser);
        try {
            commonutilities.browserTCcounter(browser);
            home.checkoutHP(driver);
            ExtentReportBuilder.ReportTestStep("checkoutHP_TC Passed", "PASS", commonutilities.generateRandomNumericString());
            ExtentReportBuilder.CompleteTest();
        } catch (Exception e) {
            ExtentReportBuilder.ReportTestStep("Error in checkoutHP_TC", "ERROR", e.getMessage());
            ExtentReportBuilder.CompleteTest();
            Assert.fail();
        }
    }
}
