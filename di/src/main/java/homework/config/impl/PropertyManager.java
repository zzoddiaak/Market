package homework.config.impl;


import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final PropertyManager instance = new PropertyManager();
    private final Properties appProps = new Properties();

    private PropertyManager() {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: application.properties");
            }
            appProps.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }

    public static PropertyManager getInstance() {
        return instance;
    }

    public String getProperty(String key) {
        return appProps.getProperty(key);
    }
}
