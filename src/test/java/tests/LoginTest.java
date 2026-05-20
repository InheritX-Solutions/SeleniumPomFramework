package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverFactory;
import listeners.RetryAnalyzer;
import pages.LoginPage;
import services.LoginService;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {config.getString("user.email"), config.getString("user.password")}
        };
    }

    @Test(groups = {"smoke", "regression"}, retryAnalyzer = RetryAnalyzer.class, dataProvider = "loginData")
    public void loginWithValidCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver(), config.getInt("timeout"));
        LoginService loginService = new LoginService(loginPage, config);

        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible before login.");
        loginService.login(email, password);

        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in after valid credentials.");
    }
}
