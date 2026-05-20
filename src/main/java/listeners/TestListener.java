package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.DriverFactory;
import utils.ReporterUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        ReporterUtil.step("Test Start", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReporterUtil.step("Test Passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        Throwable cause = result.getThrowable();
        log.error("[FAIL] {} - {}", testName, cause != null ? cause.getMessage() : "unknown");
        ReporterUtil.step("Failure Context",
                "Test: " + testName + " | Thread: " + Thread.currentThread().getId() +
                " | Cause: " + (cause != null ? cause.toString() : "unknown"));
        try {
            if (DriverFactory.isDriverActive()) {
                String path = ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), testName);
                ReporterUtil.attachScreenshot(path);
            }
        } catch (Exception e) {
            log.warn("Screenshot capture failed: {}", e.getMessage());
            ReporterUtil.attachText("Screenshot Error", e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReporterUtil.step("Test Skipped", result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Suite started: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Suite finished: {}", context.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
