package tests.ui.backOfficeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.example.hooks.Hooks;
import org.example.ui.methods.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.example.ui.qabo.LoginPage;
import org.example.ui.qabo.OrderInfoQaBo;
import org.example.ui.qabo.OrdersListPageInQabo;
import org.example.ui.qabo.QaboDashBoardPage;
//@Listeners(TestListener.class)
public class ChangeAddressTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ChangeAddressTest.class);

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    CalendarClass calendarClass = new CalendarClass();
    HelperForWeb helperForWeb = new HelperForWeb();
    String newAddressValue;
    String newAdddedAddressValue;
    String moverPassword = "Star12@";

    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    public ChangeAddressTest(){
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
    public void changeAddress() throws InterruptedException {
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
        Helper.click(orderInfoQaBo.changePickUpAddressButton);
        newAddressValue = "12333 West Olympic Boulevard, Los Angeles, CA, USA";
        newAdddedAddressValue = "12333 W Olympic Blvd, Los Angeles, CA 90064";
        SetAddress.testMethod(newAddressValue, orderInfoQaBo.changeAddressInputInPopup);
        Helper.click(orderInfoQaBo.changeAddressButtonInPopup);
//        Helper.pause(2000);
        Thread.sleep(4000);
        Helper.waitForElementVisibilityOf(orderInfoQaBo.pickUpAddress);
        logger.info("pickup address: "+orderInfoQaBo.pickUpAddress.getText());
        Assert.assertTrue(orderInfoQaBo.pickUpAddress.getText().contains(newAdddedAddressValue));

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
        Helper.pause(4000);
        String actualStatus = orderInfoQaBo.orderStatus.getText();
        boolean statusMatches = actualStatus.equals("Booked By Client") || actualStatus.equals("Vendor Approved New Order")|| actualStatus.equals("Vendor Approved Final Date");
        System.out.println("Res is "+statusMatches);
        Assert.assertTrue(statusMatches, "Status doesn't meet expected result.");
        String addressPickValueCarrierSide = "Los Angeles, CA";
        Assert.assertTrue(orderInfoQaBo.pickUpAddress.getText().contains(addressPickValueCarrierSide));
        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
