package tests.backOfficeTest;

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

public class ChangeDateTest extends Hooks implements SetUpBO{
    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    CalendarClass calendarClass = new CalendarClass();
    HelperForWeb helperForWeb = new HelperForWeb();

    String newDateValue;

    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    String moverPassword = "Star12@";

    @BeforeTest
    public void loginToQaBO(){
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void changeDate(){
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
        Helper.click(orderInfoQaBo.changeDateButton);
        calendarClass.getRandomDateInMonthQABO(orderInfoQaBo.changeDateButtonDatePicker);
        newDateValue = String.valueOf(calendarClass.dayInMonthRange);
        Helper.click(orderInfoQaBo.changeDateButtonInPopup);
        orderInfoQaBo.cancelChangeDateButtonInPopup.isDisplayed();
        orderInfoQaBo.cancelChangeDateButtonInPopup.isEnabled();
        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "In Change Move Date Process");

        helperForWeb.setCarrierNewPassword(moverName, moverPassword, orderNumber);

        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, helperForWeb.email);
        Helper.sendKeys(loginPage.passwordInputFieldBo, moverPassword);
        Helper.click(loginPage.signInButtonBo);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.click(ordersListPageInQabo.orderNumberLink);

        Helper.click(orderInfoQaBo.approveChangeDateButton);
        Helper.pause(2000);
        String actualStatus = orderInfoQaBo.orderStatus.getText();
        boolean statusMatches = actualStatus.equals("Booked By Client") || actualStatus.equals("Vendor Approved New Order");
        Assert.assertTrue(statusMatches, "Status doesn't meet expected result");
        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
