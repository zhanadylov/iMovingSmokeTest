package org.example.ui.methods;

import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.example.utilities.Driver;

public interface SetUpBO {
    WebDriver driver = Driver.getDriver();

    @BeforeTest
    static void openChrome(){
        driver.get(ConfigReader.getProperty("environmentBO"));
    }

    @AfterTest
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
