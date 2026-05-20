package businesslogic;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automationEngine.ApplicationSetup;
import utilities.CommonUtilities;
import objectRepository.LoginPageOR;
import utilities.CommonMethods;
import utilities.ExtentReportBuilder;

public class LoginBL extends ExtentReportBuilder {

	String mthName;
	CommonMethods commonmethods = new CommonMethods();
	LoginPageOR loginpageor = new LoginPageOR();
	Duration due = Duration.ofSeconds(30);
	CommonUtilities objCU = new CommonUtilities();

	// To launch the application

	public void launchApplication(WebDriver driver, String url) throws IOException, ParseException {
		try {
			mthName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			if (commonmethods.launchURL(driver, url)) {
				ExtentReportBuilder.ReportTestStep("PASS", "Launching url in browser.",
						"Application launched successfully", mthName);
				
			} else {
				Assert.assertTrue(false);
				ExtentReportBuilder.ReportTestStep("FAILED", "Launching url in browser.",
						"Application is NOT launched successfully", mthName);
			}
		} catch (Exception e) {
			ExtentReportBuilder.ReportTestStep("Error in", "Launching url in browser.",
					"Exception while launching url.", mthName);
			Assert.fail();
		}

	}

	// enter username method

	public void enterEmail(WebDriver driver) throws IOException, ParseException {
		try {
			mthName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			commonmethods.click(driver, By.xpath("//a[@title='My Account']"));
			commonmethods.click(driver, By.linkText("Login"));
			commonmethods.setText(driver, loginpageor.email, ApplicationSetup.UID);

			if (commonmethods.isElementPresent(driver, loginpageor.email)) {
				ExtentReportBuilder.ReportTestStep("PASSED", "PASS", "User entered the username", mthName);
			} else {
				ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is NOT enter the username", mthName);
			}
		} catch (Exception e) {
			ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is NOT entered the username" + e, mthName);
			e.printStackTrace();
			Assert.fail();
		}

	}

	// user enter the password method

	public void enterPassword(WebDriver driver) throws IOException, ParseException {
		try {
			mthName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			commonmethods.setText(driver, loginpageor.password, ApplicationSetup.PAS);

			if (commonmethods.isElementPresent(driver, loginpageor.password)) {
				ExtentReportBuilder.ReportTestStep("PASSED", "PASS", "Used entered the password", mthName);
			} else {
				ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is NOT entered the password", mthName);
			}
		} catch (Exception e) {
			ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is NOT entered the password" + e, mthName);
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	

	
	
	
	
	// to check the remember me 
	
/*	public void rememberme(WebDriver driver) throws IOException, ParseException {
		try {
			mthName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			
			commonmethods.waitUntillVisibilityOfElement(driver, loginpageor.rememberme,due);
			commonmethods.JSButtonClick(driver, loginpageor.rememberme);

			if (commonmethods.isElementPresent(driver, loginpageor.rememberme)) {
				ExtentReportBuilder.ReportTestStep("PASSED", "PASS", "Used checked the remember me", mthName);
			} else {
				ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "Used not checked the remember me", mthName);
			}
		} catch (Exception e) {
			ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "Used not checked the remember me" + e, mthName);
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	*/
	
	
	public void clickonsigninButton(WebDriver driver) throws IOException, ParseException {
		try {
			mthName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			commonmethods.JSButtonClick(driver, loginpageor.signin);

			if (commonmethods.isElementPresent(driver, loginpageor.signin)) {
				ExtentReportBuilder.ReportTestStep("PASSED", "PASS", "User clicked on signin button", mthName);
			} else {
				ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is not click on signin button", mthName);
			}
		} catch (Exception e) {
			ExtentReportBuilder.ReportTestStep("FAILED", "FAIL", "User is not click on signin button" + e, mthName);
			e.printStackTrace();
			Assert.fail();
		}

	}

	
	
}
