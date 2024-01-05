package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(WebDriver.class);

    private static Properties properties;

    static {
        try {
            String path = "src/test/configuration.properties.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();

        } catch (IOException e) {
            logger.error("Error occurred while reading configuration: " + e.getMessage());
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key).trim();
    }
}
