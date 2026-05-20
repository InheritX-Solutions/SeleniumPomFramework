package constants;

public final class FrameworkConstants {
    public static final String CONFIG_FILE         = "config.properties";
    public static final String CONFIG_ENV_PREFIX   = "config-";
    public static final String CONFIG_ENV_SUFFIX   = ".properties";
    public static final String REPORT_PATH         = System.getProperty("user.dir") + "/target/reports";
    public static final String SCREENSHOT_PATH     = System.getProperty("user.dir") + "/target/screenshots";
    public static final String LOG_PATH            = System.getProperty("user.dir") + "/logs/framework.log";
    public static final String DEFAULT_ENV         = "dev";
    public static final String DEFAULT_BROWSER     = "chrome";

    private FrameworkConstants() {}
}
