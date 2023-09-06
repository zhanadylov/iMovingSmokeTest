package tests.backOfficeTest;

import DataBaseConnection.ConnectDataBaseTest;
import apiConnection.CC_Capture_StepsTest;
import apiConnection.SendEmailQueryTest;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.CalendarClass;
import ui.methods.HelperForWeb;
import ui.methods.SetUpBO;
import ui.qabo.LoginPage;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersListPageInQabo;
import ui.qabo.QaboDashBoardPage;

public class DeliveryProcessTest extends Hooks implements SetUpBO{
    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    CalendarClass calendarClass = new CalendarClass();
    HelperForWeb helperForWeb = new HelperForWeb();
    SendEmailQueryTest sendEmailQueryTest = new SendEmailQueryTest();
    CC_Capture_StepsTest cc_capture_steps = new CC_Capture_StepsTest();
    String newAddressValue;
    String newAdddedAddressValue;
    String moverPassword = "Star12@";

    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    @BeforeTest
    public void loginToQaBO(){
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void deliveryProcess(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "qatestimoving@gmail.com");
        Helper.click(ordersListPageInQabo.filterButton);
        orderNumber = ordersListPageInQabo.orderNumberLink.getText();
        moverName = ordersListPageInQabo.branchNameCarrier.getText();
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.orderNumberLink);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        ConnectDataBaseTest.getNumber(orderNumber);
        ConnectDataBaseTest.updateOneDayEarlier();
        ConnectDataBaseTest.changeCaptureDate();
        sendEmailQueryTest.query_send();
        sendEmailQueryTest.status_code_is_returned_for_response();
        cc_capture_steps.query_sended();
        cc_capture_steps.status_code_is_returned_for_response();
        Helper.pause(2000);
//        Assert.assertTrue(orderInfoQaBo.pickupDateValue.getText().contains());
        driver.navigate().refresh();
        Helper.pause(2000);
        Helper.click(orderInfoQaBo.financeTab);
        orderInfoQaBo.capturedTextInStatusColumnTable.isDisplayed();
        orderInfoQaBo.successTextInStatusColumnTable.isDisplayed();
//        helperForWeb.setCarrierNewPassword(moverName, moverPassword, orderNumber);

//        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
//        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
//        Helper.sendKeys(loginPage.emailInputFieldBo, helperForWeb.email);
//        Helper.sendKeys(loginPage.passwordInputFieldBo, moverPassword);
//        Helper.click(loginPage.signInButtonBo);
//        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
//        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
//        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
//        Helper.click(ordersListPageInQabo.filterButton);
//        Helper.click(ordersListPageInQabo.orderNumberLink);
//        Helper.pause(2000);
//        String actualStatus = orderInfoQaBo.orderStatus.getText();
//        boolean statusMatches = actualStatus.equals("Booked By Client") || actualStatus.equals("Vendor Approved New Order");
//        Assert.assertTrue(statusMatches, "Status doesn't meet expected result");
//        String addressPickValueCarrierSide = "Los Angeles, CA";
//        Assert.assertTrue(orderInfoQaBo.pickUpAddress.getText().contains(addressPickValueCarrierSide));
//        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
