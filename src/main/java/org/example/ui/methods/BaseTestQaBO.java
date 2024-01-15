package org.example.ui.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.Helper;
import org.example.ui.qabo.LoginPage;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.example.utilities.Driver;

public class BaseTestQaBO {
    private WebDriver driver = Driver.getDriver();
    static final Logger logger = LogManager.getLogger(BaseTestQaBO.class);
    static LoginPage loginPage = new LoginPage();

    @BeforeSuite
    static void setup(){
        logger.info("Creating driver QaBo");
        Driver.getDriver();
    }

    @BeforeClass
    void openBrowser(){
        logger.info("Opening environmentBO");
        driver.get(ConfigReader.getProperty("environmentBO"));
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @AfterSuite
    static void tearDown(){
        logger.info("Closing driver ");
        Driver.closeDriver();
    }

//    @BeforeClass
//    static void openChrome(){
//        logger.info("Opening environmentBO");
//        driver.get(ConfigReader.getProperty("environmentBO"));
//        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
//        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
//        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
//        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
//        Helper.click(loginPage.signInButtonBo);
//    }
//
//    @AfterClass
//    static void closeChrome(){
//        logger.info("Closing environmentBO");
//        WebDriverManager.chromedriver().quit();
//    }

    public void open(String url){
        driver.get(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}