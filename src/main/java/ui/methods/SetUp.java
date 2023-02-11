package ui.methods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.Driver;

public interface SetUp {
    WebDriver driver = Driver.getDriver();

    @BeforeSuite
    static void openChrome(){
        driver.get(ConfigReader.getProperty("environment"));
    }

    @AfterSuite
    static void closeChrome(){
        driver.close();
        driver.quit();
    }

    public static void open(String url){
        driver.get(url);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

}
