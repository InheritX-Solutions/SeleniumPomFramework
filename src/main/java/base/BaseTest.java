package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import config.ConfigReader;
import listeners.TestListener;
import utils.ReporterUtil;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected final ConfigReader config = new ConfigReader();
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result) {
        log.info("[{}] Setting up test: {}", Thread.currentThread().getId(), result.getName());
        ReporterUtil.step("Setup", "Initialising driver for: " + result.getName());
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(config.getString("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                ReporterUtil.step("TearDown", "Test FAILED: " + result.getName());
            }
        } finally {
            log.info("[{}] Tearing down: {}", Thread.currentThread().getId(), result.getName());
            DriverFactory.quitDriver();
        }
    }
}
