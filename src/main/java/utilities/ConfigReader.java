package utilities;

import hooks.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

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
