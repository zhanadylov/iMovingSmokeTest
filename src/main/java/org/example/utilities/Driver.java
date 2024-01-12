package org.example.utilities;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
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
                return ChromeWebDriver.loadChromeDriver();
            case "firefox":
                return FirefoxWebDriver.loadFirefoxDriver();
            // Другие варианты браузеров...
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    });

    @BeforeSuite
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @AfterSuite(alwaysRun = true, description = "Closing driver")
    public static void closeDriver() {
        try {
            WebDriver driver = driverThreadLocal.get();
            if (driver != null) {
                driver.quit();
                driverThreadLocal.remove();
            }
        } catch (Exception e) {
            logger.error("Error occurred while closing the driver: " + e.getMessage());
        }
        logger.info("Closing Driver");
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
////    private static EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
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
////            eventDriver = new EventFiringWebDriver(driver);
//            registerEventListener();
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
//    private static void registerEventListener() {
//        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
//        eventDriver.register(new Hooks());
//        driver = eventDriver;
//    }
//}