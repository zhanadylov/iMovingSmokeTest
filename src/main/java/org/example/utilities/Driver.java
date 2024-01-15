package org.example.utilities;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Driver {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static final Boolean clear_Cookies_And_Storage = true;
    ///////
//    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private Driver() {
    }

    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> {
        switch (ConfigReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                logger.info("Loading chrome driver...");
                return ChromeWebDriver.loadChromeDriver();
            case "firefox":
                logger.info("Loading firefox driver...");
                return FirefoxWebDriver.loadFirefoxDriver();
            // Другие варианты браузеров...
            default:
                logger.warn("Loading browser failed...");
                throw new IllegalArgumentException("Unsupported browser");
        }
    });

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void closeDriver() {
            WebDriver driver = driverThreadLocal.get();
            if (driver != null) {
                driver.quit();
                driverThreadLocal.remove();
            }
    }
    /////////

//    @BeforeClass(alwaysRun = true)
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            synchronized (Driver.class) {
//                if (driver == null) {
//                    switch (ConfigReader.getProperty("browser").toLowerCase()) {
//                        case "chrome":
//                            driver = ChromeWebDriver.loadChromeDriver();
//                            break;
//                        case "firefox":
//                            driver = FirefoxWebDriver.loadFirefoxDriver();
//                            break;
//                        // Другие варианты браузеров...
//                        default:
//                            throw new IllegalArgumentException("Unsupported browser");
//                    }
//                }
//            }
//        }
//        return driver;
//    }
////    @AfterSuite(alwaysRun = true)
//    public static void closeDriver() {
//        try {
//            if (driver != null) {
//                driver.quit();
//            }
//        } catch (Exception e) {
//            logger.error("Error occurred while closing the driver: " + e.getMessage());
//        }
//        logger.info("Closing Driver");
//    }
}

//abstract public class Driver {
//    // Singleton pattern
//
//    //if true = clear cookie
//    public static final Boolean clear_Cookies_And_Storage = true;
//    private static final Logger logger = LoggerFactory.getLogger(WebDriver.class);
//
//    public static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            switch (ConfigReader.getProperty("browser").toLowerCase()) {
//                case "chrome":
//                    driver = ChromeWebDriver.loadChromeDriver();
//                    break;
//                case "firefox":
//                    driver = FirefoxWebDriver.loadFirefoxDriver();
//                    break;
//                case "safari":
//                    driver = new SafariDriver();
//                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//                    break;
//                case "edge":
//                    driver = EdgeWebDriver.loadEdgeDriver();
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unsupported browser");
//            }
//        }
//        return driver;
//    }
//
//    public static void closeDriver() {
//        try {
//            if (Driver.driver != null) {
//                driver.close();
//                driver.quit();
//                Driver.driver = null;
//            }
//        } catch (Exception e) {
//            logger.error("Error occurred while closing the driver: " + e.getMessage());
//        }
//        logger.info("Closing Driver");
//    }
//}