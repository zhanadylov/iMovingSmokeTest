package tests.ui.backOfficeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.example.ui.methods.BaseTest;
import org.example.ui.methods.HelperForWeb;
import org.example.ui.qabo.LoginPage;
import org.example.ui.qabo.OrderInfoQaBo;
import org.example.ui.qabo.OrdersListPageInQabo;
import org.example.ui.qabo.QaboDashBoardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(TestListener.class)
public class CancelOrderTest extends BaseTest {
    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    String moverPassword = "Star12@";
    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    HelperForWeb helperForWeb = new HelperForWeb();
    private final Logger logger = LogManager.getLogger(CancelOrderTest.class);


    public CancelOrderTest(){
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
    public void cancelOrderInBo(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
//        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
//        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
//        Helper.sendKeys(ordersListPageInQabo.clientEmailFilterField, "qatestimoving@gmail.com");
//        Helper.click(ordersListPageInQabo.filterButton);
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
        Helper.pause(10000);
        Helper.waitForElementVisibilityOf(orderInfoQaBo.orderStatus);
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
        Helper.pause(5000);
        Assert.assertEquals(orderInfoQaBo.orderStatus.getText(), "In Change Mover Process");
    }

}
