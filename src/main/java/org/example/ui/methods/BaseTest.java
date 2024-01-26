package org.example.ui.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.Helper;
import org.example.ui.qabo.LoginPage;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.testng.annotations.*;
import org.example.utilities.Driver;

import java.util.Set;

public abstract class BaseTest {
    public static WebDriver driver = Driver.getDriver();
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    static LoginPage loginPage = new LoginPage();
    String environment;

    public BaseTest(String environment){
        this.environment = environment;
    }
    public BaseTest(){
    }
    public static final Boolean clear_Cookies_And_Storage = true;


    @BeforeSuite
    static void setup(){
        logger.info("Creating driver...");
        Driver.getDriver();
    }
    @BeforeClass
    public void openEnvironment() throws InterruptedException {
        logger.info("Opening environment " + environment);
        if(environment.equals("environment")){
            driver.get(ConfigReader.getProperty("environment"));
//            driver.manage().deleteAllCookies();
        }else{
            driver.get(ConfigReader.getProperty("environmentBO"));
//            driver.manage().deleteAllCookies();
            Thread.sleep(2000);
            if(!Helper.isElementPresent(loginPage.iMovingManagementText)) {
                Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
                Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
                Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
                Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
                Helper.click(loginPage.signInButtonBo);
            }
        }
    }
    @AfterClass
    void closeBrowser(){
        logger.info("Closing browser...");
        driver.close();
    }

    @AfterSuite
    void tearDown(){
        logger.info("Closing driver...");
        Driver.closeDriver();
    }

//
//    public void open(String url){
//        driver.get(url);
//    }
//
//    public void refresh() {
//        driver.navigate().refresh();
//    }

    //    @BeforeTest
    //    @Description("Setup in AdditionalPickUpTest")
    //    public static void setUp(){
    ////        if (driver == null) {
    //        logger.info("Trying to open browser and url in AdditionalPickUpTest");
    ////            driver = Driver.getDriver();
    //        driver.manage().deleteAllCookies();
    //        driver.get(ConfigReader.getProperty("environment"));
    ////        }else{
    ////            driver.get(ConfigReader.getProperty("environment"));
    ////        }
    //    }
    //    @AfterClass
    //    public void tearDown() {
    //        logger.info("Closing driver after method AdditionalPickUpTest started "+driver.getCurrentUrl()+driver.getTitle());
    //        driver.close();
    //    }
}
