package homework.config.impl;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
    private static final PropertyManager instance = new PropertyManager();
    private final Properties appProps = new Properties();


    private PropertyManager() {
        String appConfigPath = Thread.currentThread().getContextClassLoader().getResource("application.properties").getPath();

        loadAppProperties(appConfigPath);
    }

    public static PropertyManager getInstance() {
        return instance;
    }

    @SneakyThrows
    private void loadAppProperties(String appConfigPath) {
        appProps.load(new FileInputStream(appConfigPath));
    }

    public String getProperty(String key) {
        return appProps.getProperty(key);
    }
}
