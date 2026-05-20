package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constants.FrameworkConstants;
import exceptions.FrameworkException;

public class ConfigReader {
    private final Properties properties = new Properties();
    private final String environment;

    public ConfigReader() {
        // Accept -Denv or -Denvironment; fall back to constant default
        environment = System.getProperty("env",
                      System.getProperty("environment", FrameworkConstants.DEFAULT_ENV))
                      .trim().toLowerCase();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream base = getClass().getClassLoader().getResourceAsStream(FrameworkConstants.CONFIG_FILE)) {
            if (base == null) throw new FrameworkException("Cannot find " + FrameworkConstants.CONFIG_FILE);
            properties.load(base);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load base config", e);
        }

        String envFile = FrameworkConstants.CONFIG_ENV_PREFIX + environment + FrameworkConstants.CONFIG_ENV_SUFFIX;
        try (InputStream env = getClass().getClassLoader().getResourceAsStream(envFile)) {
            if (env != null) properties.load(env);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load env config: " + environment, e);
        }
    }

    public String getString(String key) {
        String value = properties.getProperty(key);
        if (value == null) throw new FrameworkException("Missing config key: " + key);
        return value.trim();
    }

    public int getInt(String key)         { return Integer.parseInt(getString(key)); }
    public boolean getBoolean(String key) { return Boolean.parseBoolean(getString(key)); }
    public String getEnvironment()        { return environment; }
}
