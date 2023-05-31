package tests;

import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.SaveOrderInfo;
import ui.qabo.LoginPage;
import ui.qabo.OrdersPageInQabo;
import ui.qabo.QaboDashBoardPage;

import static ui.methods.SetUp.driver;


public class QaboOptionsTest extends Hooks{
    String orderNumber = "";

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersPageInQabo ordersPageInQabo = new OrdersPageInQabo();
    DropDownHelper dropDownHelper = new DropDownHelper();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    BrowserHelper browserHelper = new BrowserHelper(driver);

//    @BeforeTest
//    public void openQaBoWeb(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open('https://qabo.imoving.com/', '_blank');");
//    }

    public void getOrderNumber(String number){
        this.orderNumber = number;
    }

    @Test
    public void loginToQaBO(){
        driver.get("https://qabo.imoving.com/Account/Login");
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void checkPriceInBO(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersPageInQabo.filterButton);
        Helper.waitForElementToBeDisplayed(ordersPageInQabo.orderNumberLink);
        Helper.click(ordersPageInQabo.orderNumberLink);
    }
}
