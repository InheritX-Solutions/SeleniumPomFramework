package utils;

import java.nio.file.Files;
import java.nio.file.Path;

import io.qameta.allure.Allure;

public class ReporterUtil {

    public static void step(String title, String message) {
        Allure.step(title + ": " + message);
    }

    public static void attachScreenshot(String screenshotPath) {
        Path path = Path.of(screenshotPath);
        if (!Files.exists(path)) return;
        try (var in = Files.newInputStream(path)) {
            Allure.addAttachment("Screenshot", "image/png", in, "png");
        } catch (Exception ignored) {}
    }

    public static void attachText(String title, String message) {
        Allure.addAttachment(title, message);
    }
}
