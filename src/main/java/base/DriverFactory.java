package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import config.ConfigReader;
import exceptions.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static final Logger log = LogManager.getLogger(DriverFactory.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {}

    public static void initDriver() {
        if (DRIVER.get() != null) {
            return;
        }
        ConfigReader config = new ConfigReader();
        String browserProp = System.getProperty("browser", "").trim();
        String browser = browserProp.isEmpty() ? config.getString("browser") : browserProp.toLowerCase();
        String headlessProp = System.getProperty("headless", "").trim();
        boolean headless = headlessProp.isEmpty() ? config.getBoolean("headless") : Boolean.parseBoolean(headlessProp);
        int timeout = config.getInt("timeout");

        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--disable-gpu", "--remote-allow-origins=*");
                if (headless) opts.addArguments("--headless=new", "--window-size=1920,1080");
                driver = new ChromeDriver(opts);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions opts = new FirefoxOptions();
                if (headless) opts.addArguments("-headless");
                driver = new FirefoxDriver(opts);
            }
            default -> throw new FrameworkException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        DRIVER.set(driver);
        log.info("Driver initialised [thread={}, browser={}, headless={}]",
                Thread.currentThread().getId(), browser, headless);
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new FrameworkException("WebDriver not initialised for thread: " + Thread.currentThread().getId());
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
                log.info("Driver quit [thread={}]", Thread.currentThread().getId());
            } catch (Exception e) {
                log.warn("Error quitting driver: {}", e.getMessage());
            } finally {
                DRIVER.remove();
            }
        }
    }

    public static boolean isDriverActive() {
        return DRIVER.get() != null;
    }
}
