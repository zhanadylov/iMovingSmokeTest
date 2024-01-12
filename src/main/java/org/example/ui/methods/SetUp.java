package org.example.ui.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.example.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public interface SetUp {
    WebDriver driver = Driver.getDriver();
    static final Logger logger = LogManager.getLogger(SetUp.class);

    @BeforeClass
    static void openChrome(){
        logger.info("Opening environment ");
        driver.get(ConfigReader.getProperty("environment"));
    }

    @AfterClass
    static void closeChrome(){
        logger.info("Closing environment");
                WebDriverManager.chromedriver().quit();
    }

    public static void open(String url){
        driver.get(url);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

}
