package org.example.ui.methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.Helper;
import org.example.ui.qabo.LoginPage;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.example.utilities.Driver;

public interface SetUpBO {
    WebDriver driver = Driver.getDriver();
    static final Logger logger = LogManager.getLogger(SetUpBO.class);
    static LoginPage loginPage = new LoginPage();

    @BeforeClass
    static void openChrome(){
        logger.info("Opening environmentBO");
        driver.get(ConfigReader.getProperty("environmentBO"));
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @AfterClass
    static void closeChrome(){
        logger.info("Closing environmentBO");
        WebDriverManager.chromedriver().quit();
    }

    public static void open(String url){
        driver.get(url);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }
}
