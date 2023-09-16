package ui.methods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

public interface SetUp {
    WebDriver driver = Driver.getDriver();

    @BeforeClass
    static void openChrome(){
        driver.get(ConfigReader.getProperty("environment"));
    }

    @AfterClass
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
