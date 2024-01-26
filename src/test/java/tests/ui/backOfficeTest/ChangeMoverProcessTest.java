package tests.ui.backOfficeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.example.ui.methods.BaseTest;
import org.example.ui.methods.CalendarClass;
import org.example.ui.methods.HelperForWeb;
import org.example.ui.qabo.LoginPage;
import org.example.ui.qabo.OrderInfoQaBo;
import org.example.ui.qabo.OrdersListPageInQabo;
import org.example.ui.qabo.QaboDashBoardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeMoverProcessTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ChangeDateTest.class);
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
    public ChangeMoverProcessTest(){
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
    public void changeMoverProcess(){
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
        Helper.waitForElementToBeDisplayed(orderInfoQaBo.selectMoverButton);
        Helper.click(orderInfoQaBo.selectMoverButton);

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

        Assert.assertTrue(orderInfoQaBo.pickupDateValue.getText().contains(newDateValue));
        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
