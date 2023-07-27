package ui.methods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.Driver;

public interface SetUpBO {
    WebDriver driver = Driver.getDriver();

    @BeforeSuite
    static void openChrome(){
        driver.get(ConfigReader.getProperty("environmentBO"));
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
