package utilities;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    // Singleton pattern
    private Driver() {
    }
    //if true = clear cookie
    public static final Boolean clear_Cookies_And_Storage = true;

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Helper.color("green")+"Closing Driver"+Helper.color("reset"));
    }
}
