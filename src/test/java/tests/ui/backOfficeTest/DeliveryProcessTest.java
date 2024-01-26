package tests.ui.backOfficeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DataBaseConnection.ConnectDataBaseTest;
import org.example.apiConnection.ApiConnection;
import org.example.ui.methods.BaseTest;
import org.testng.annotations.BeforeClass;
import tests.api.CcCaptureStepsTest;
import tests.api.SendEmailQueryTest;
import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.testng.annotations.Test;
import org.example.ui.methods.CalendarClass;
import org.example.ui.methods.HelperForWeb;
import org.example.ui.qabo.LoginPage;
import org.example.ui.qabo.OrderInfoQaBo;
import org.example.ui.qabo.OrdersListPageInQabo;
import org.example.ui.qabo.QaboDashBoardPage;

import java.sql.SQLException;
//@Listeners(TestListener.class)
public class DeliveryProcessTest extends BaseTest{
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
    public DeliveryProcessTest(){
        super("environmentBO");
    }
    @BeforeClass
    public void loginToBo(){
        try{
            if(Helper.isElementPresent(loginPage.iMovingManagementText)) {
                Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
                Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
                Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
                Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
                Helper.click(loginPage.signInButtonBo);
            }
        }catch (Exception e){
            logger.warn("BO in dashboard");
        }
    }
    @Test
    public void deliveryProcess() throws SQLException {
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
//        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "qatestimoving@gmail.com");
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
        cc_capture_steps.sendQueryForCaptureTest();
//        sendEmailQueryTest.sendQueryForSendsEmails();
        Helper.pause(2000);
//        Assert.assertTrue(orderInfoQaBo.pickupDateValue.getText().contains());
        driver.navigate().refresh();
        Helper.pause(2000);
        Helper.click(orderInfoQaBo.financeTab);
        orderInfoQaBo.capturedTextInStatusColumnTable.isDisplayed();
        orderInfoQaBo.successTextInStatusColumnTable.isDisplayed();
    }
}
