package utilities;

import helper.Helper;
import hooks.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    // Singleton pattern

    //if true = clear cookie
    public static final Boolean clear_Cookies_And_Storage = true;
    private static final Logger logger = LogManager.getLogger(Driver.class);

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                default -> driver = ChromeWebDriver.loadChromeDriver();
                case "firefox" -> driver = FirefoxWebDriver.loadFirefoxDriver();
                case "safari" -> {
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                }
                case "edge" -> driver = EdgeWebDriver.loadEdgeDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (Driver.driver != null) {
                driver.close();
                driver.quit();
                Driver.driver = null;
            }
        } catch (Exception e) {
            logger.error("Error occurred while closing the driver: " + e.getMessage());
        }
        logger.info("Closing Driver");
    }
}
/////////////////////////////////
//public class Driver {
//    // Singleton pattern
//    private Driver() {
//    }
//    //if true = clear cookie
//    public static final Boolean clear_Cookies_And_Storage = true;
//
//    public static WebDriver getDriver() {
//        WebDriver driver = null;
//
//        switch (ConfigReader.getProperty("browser").toLowerCase()) {
//            default:
//                driver = ChromeWebDriver.loadChromeDriver();
//                break;
//            case "firefox":
//                driver = FirefoxWebDriver.loadFirefoxDriver();
//                break;
//            case "safari":
//                driver = new SafariDriver();
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//                break;
//            case "edge":
//                driver = EdgeWebDriver.loadEdgeDriver();
//                break;
//        }
//
//        return driver;
//    }
//
//    public static void closeDriver(WebDriver driver) {
//        try {
//            if (driver != null) {
//                driver.close();
//                driver.quit();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Helper.color("green") + "Closing Driver" + Helper.color("reset"));
//    }
//}