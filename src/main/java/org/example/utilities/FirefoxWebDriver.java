package org.example.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;


public class FirefoxWebDriver {

    public static WebDriver loadFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless")));
        options.addArguments("-headless");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        return driver;
    }
}