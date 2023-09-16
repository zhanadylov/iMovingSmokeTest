package tests.ui.backOfficeTest;

import DataBaseConnection.ConnectDataBaseTest;
import apiConnection.ApiConnection;
import tests.api.CcCaptureStepsTest;
import tests.api.SendEmailQueryTest;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.methods.CalendarClass;
import ui.methods.HelperForWeb;
import ui.qabo.LoginPage;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersListPageInQabo;
import ui.qabo.QaboDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.SQLException;

public class DeliveryProcessTest extends Hooks{
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DeliveryProcessTest.class);

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    CalendarClass calendarClass = new CalendarClass();
    HelperForWeb helperForWeb = new HelperForWeb();
    SendEmailQueryTest sendEmailQueryTest = new SendEmailQueryTest();
    CcCaptureStepsTest cc_capture_steps = new CcCaptureStepsTest();
    String newAddressValue;
    String newAdddedAddressValue;
    String moverPassword = "Star12@";

    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    @BeforeClass
    public void loginToQaBO(){
        try {
            if (driver == null) {
                logger.info("Trying to open browser and url");
                driver = Driver.getDriver();
                driver.get(ConfigReader.getProperty("environmentBO"));
                Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
                Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
                Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
                Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
                Helper.click(loginPage.signInButtonBo);
            }
        } catch (Exception e) {
            logger.error("Error occurred while opening browser and url: " + e.getMessage());
        }
        logger.info("browser and url opened "+driver.getCurrentUrl());
    }

    @Test
    public void deliveryProcess() throws SQLException {
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "qatestimoving@gmail.com");
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.pause(1000);
        orderNumber = ordersListPageInQabo.orderNumberLink.getText();
        moverName = ordersListPageInQabo.branchNameCarrier.getText();
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.orderNumberLink);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        ConnectDataBaseTest.getNumber(orderNumber);
        ConnectDataBaseTest.setUp();
        ConnectDataBaseTest.updateOneDayEarlier();
        ConnectDataBaseTest.changeCaptureDate();
        ConnectDataBaseTest.tearDown();
        ApiConnection.setUp();
        cc_capture_steps.query_send_test();
        cc_capture_steps.status_code_is_returned_for_response();
        sendEmailQueryTest.query_send();
        sendEmailQueryTest.status_code_is_returned_for_response();
        Helper.pause(2000);
//        Assert.assertTrue(orderInfoQaBo.pickupDateValue.getText().contains());
        driver.navigate().refresh();
        Helper.pause(2000);
        Helper.click(orderInfoQaBo.financeTab);
        orderInfoQaBo.capturedTextInStatusColumnTable.isDisplayed();
        orderInfoQaBo.successTextInStatusColumnTable.isDisplayed();
    }
}
