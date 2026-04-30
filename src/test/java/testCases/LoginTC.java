package testCases;

import java.time.Duration;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import automationEngine.ApplicationSetup;
import businesslogic.LoginBL;
import utilities.CommonUtilities;
import utilities.ExtentReportBuilder;
import utilities.JsonReader;

public class LoginTC extends ApplicationSetup {
	LoginBL loginbl = new LoginBL();
	CommonUtilities commonutilities = new CommonUtilities();
	

	@SuppressWarnings("deprecation")
	@Test(groups = { "Smoke", "Regression" }, priority = 1)
	@Parameters({ "browser" })
	public void enteremailTC(String browser) throws Exception {
	    ExtentReportBuilder.ReportInitialization("Login TC" + " - " + browser);
	    try {
	        commonutilities.browserTCcounter(browser);

	        loginbl.enterEmail(driver);

	        ExtentReportBuilder.ReportTestStep("Console Messages:  ", "Pass",
	                "" + commonutilities.printTheConsoleMessage());
	        ExtentReportBuilder.ReportTestStep(
	                "Login Function Passed " + Thread.currentThread().getStackTrace()[2].getMethodName(), "PASS",
	                commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	    } catch (Exception e) {
	        Thread thread = new Thread();
	        thread.interrupt();
	        log.info(e.getMessage());
	        ExtentReportBuilder.ReportTestStep("Error in " + Thread.currentThread().getStackTrace()[2].getMethodName(),
	                "ERROR", commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	        Assert.fail();
	    }
	}



	@SuppressWarnings("deprecation")
	@Test(groups = { "Smoke", "Regression" }, priority = 2)
	@Parameters({ "browser" })
	public void enterpasswordTC(String browser) throws Exception {
	    ExtentReportBuilder.ReportInitialization("Login TC" + " - " + browser);
	    try {
	        commonutilities.browserTCcounter(browser);

	        loginbl.enterPassword(driver);

	        ExtentReportBuilder.ReportTestStep("Console Messages:  ", "Pass",
	                "" + commonutilities.printTheConsoleMessage());
	        ExtentReportBuilder.ReportTestStep(
	                "Login Function Passed " + Thread.currentThread().getStackTrace()[2].getMethodName(), "PASS",
	                commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	    } catch (Exception e) {
	        Thread thread = new Thread();
	        thread.interrupt();
	        log.info(e.getMessage());
	        ExtentReportBuilder.ReportTestStep("Error in " + Thread.currentThread().getStackTrace()[2].getMethodName(),
	                "ERROR", commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	        Assert.fail();
	    }
	}



	@SuppressWarnings("deprecation")
	@Test(groups = { "Smoke", "Regression" }, priority = 3)
	@Parameters({ "browser" })
	public void enterPhoneNo(String browser) throws Exception {

	    ExtentReportBuilder.ReportInitialization("Login TC" + " - " + browser);
	    try {
	        System.out.print("phone number method start here");
	        commonutilities.browserTCcounter(browser);

	        // FIXED: earlier wrong → loginbl.enterPassword(driver)
	        loginbl.enterPhoneNo(driver);

	        ExtentReportBuilder.ReportTestStep("Console Messages:  ", "Pass",
	                "" + commonutilities.printTheConsoleMessage());
	        ExtentReportBuilder.ReportTestStep(
	                "Login Function Passed " + Thread.currentThread().getStackTrace()[2].getMethodName(), "PASS",
	                commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	        System.out.print("method run but not click on the phone number text");
	    } catch (Exception e) {
	        Thread thread = new Thread();
	        thread.interrupt();
	        log.info(e.getMessage());
	        ExtentReportBuilder.ReportTestStep("Error in " + Thread.currentThread().getStackTrace()[2].getMethodName(),
	                "ERROR", commonutilities.generateRandomNumericString());
	        ExtentReportBuilder.CompleteTest();
	        Assert.fail();
	    }
	}
}