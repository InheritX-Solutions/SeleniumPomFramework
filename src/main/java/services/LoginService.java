package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.ConfigReader;
import pages.LoginPage;

public class LoginService {
    private static final Logger log = LogManager.getLogger(LoginService.class);
    private final LoginPage loginPage;
    private final ConfigReader config;

    public LoginService(LoginPage loginPage, ConfigReader config) {
        this.loginPage = loginPage;
        this.config = config;
    }

    public LoginPage login(String email, String password) {
        log.info("Performing login with email: {}", email);
        return loginPage.enterEmail(email).enterPassword(password).clickSignIn();
    }
}
