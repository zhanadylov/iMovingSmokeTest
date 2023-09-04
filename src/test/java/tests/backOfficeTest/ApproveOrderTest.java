package tests.backOfficeTest;

import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.HelperForWeb;
import ui.methods.SetUpBO;
import ui.qabo.*;

public class ApproveOrderTest extends Hooks implements SetUpBO {
    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    String moverPassword = "Star12@";


    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    HelperForWeb helperForWeb = new HelperForWeb();
    UsersQabo usersQabo = new UsersQabo();
    public void getOrderNumber(String number){
        this.orderNumber = number;
    }

    @BeforeTest
    public void loginToQaBO(){
//        driver.get("https://qabo.imoving.com/Account/Login");
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void approveOrderInBO(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "shirley.orn@gmail.com");
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.orderNumberLink);
        orderNumber = ordersListPageInQabo.orderNumberLink.getText();
        moverName = ordersListPageInQabo.branchNameCarrier.getText();
        Helper.click(qaboDashBoardPage.usersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(usersQabo.usersTitle);
        Helper.sendKeys(usersQabo.companyNameInputField, moverName);
        Helper.click(usersQabo.updateFilterButton);
        Helper.pause(2000);
        helperForWeb.navigateToSupplierEmail(usersQabo.emailsWithRoleSupplier);
        Helper.waitForElementToBeDisplayed(usersQabo.changePasswordButton);
        Helper.javascriptScrollIntoView(usersQabo.changePasswordButton);
        Helper.click(usersQabo.changePasswordButton);
        Helper.waitForElementToBeDisplayed(usersQabo.newPasswordInputField);
        Helper.sendKeys(usersQabo.newPasswordInputField, moverPassword);
        Helper.click(usersQabo.saveButton);
        usersQabo.changePasswordButton.isDisplayed();
        Helper.click(qaboDashBoardPage.logOffButton);
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
        Helper.click(orderInfoQaBo.approveOrderButton);
        Helper.click(orderInfoQaBo.approveOrderButtonInPopUp);
        Helper.pause(3000);
//        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "Vendor Approved New Order");
        Helper.click(qaboDashBoardPage.logOffButton);
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "Vendor Approved New Order");
    }

    @Test
    public void cancelOrderInBo(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "qatestimoving@gmail.com");
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.orderNumberLink);
        orderNumber = ordersListPageInQabo.orderNumberLink.getText();
        moverName = ordersListPageInQabo.branchNameCarrier.getText();
        helperForWeb.setCarrierNewPassword(moverName, moverPassword, orderNumber);
//        Helper.click(qaboDashBoardPage.usersLabelInSideBar);
//        Helper.waitForElementToBeDisplayed(usersQabo.usersTitle);
//        Helper.sendKeys(usersQabo.companyNameInputField, moverName);
//        Helper.click(usersQabo.updateFilterButton);
//        Helper.pause(2000);
//        helperForWeb.navigateToSupplierEmail(usersQabo.emailsWithRoleSupplier);
//        Helper.waitForElementToBeDisplayed(usersQabo.changePasswordButton);
//        Helper.javascriptScrollIntoView(usersQabo.changePasswordButton);
//        Helper.click(usersQabo.changePasswordButton);
//        Helper.waitForElementToBeDisplayed(usersQabo.newPasswordInputField);
//        Helper.sendKeys(usersQabo.newPasswordInputField, moverPassword);
//        Helper.click(usersQabo.saveButton);
//        usersQabo.changePasswordButton.isDisplayed();
//        Helper.click(qaboDashBoardPage.logOffButton);
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
        Helper.click(orderInfoQaBo.declineOrderButton);
        Helper.click(orderInfoQaBo.declineOrderButtonInPopUp);
        Helper.pause(3000);
        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "In Change Mover Process");
        Helper.click(qaboDashBoardPage.logOffButton);
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "In Change Mover Process");
    }
}
