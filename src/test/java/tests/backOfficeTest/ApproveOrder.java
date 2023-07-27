package tests.backOfficeTest;

import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.GetMoverNameInBO;
import ui.methods.SetUpBO;
import ui.qabo.LoginPage;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersPageInQabo;
import ui.qabo.QaboDashBoardPage;

import static ui.methods.SetUp.driver;

public class ApproveOrder extends Hooks implements SetUpBO {
    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    String moverPassword = "Star12@";


    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersPageInQabo ordersPageInQabo = new OrdersPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    GetMoverNameInBO getMoverNameInBO = new GetMoverNameInBO();

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
        Helper.waitForElementToBeDisplayed(ordersPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersPageInQabo.filterButton);
        Helper.waitForElementToBeDisplayed(ordersPageInQabo.orderNumberLink);
        Helper.click(ordersPageInQabo.orderNumberLink);
        moverName = GetMoverNameInBO.substringMoverName(orderInfoQaBo.carrierName.getText());
        moverEmail = orderInfoQaBo.carrierEmail.getText();
        System.out.println(moverName);
        System.out.println(moverEmail);
    }
}
