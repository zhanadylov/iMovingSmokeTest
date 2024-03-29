package tests.ui.backOfficeTest;

import com.github.javafaker.Faker;
import helper.AssertThat;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.SaveOrderInfo;
import ui.methods.SetUpBO;
import ui.qabo.LoginPage;
import ui.qabo.ManualPayment.AddPaymentPopUp;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersListPageInQabo;
import ui.qabo.QaboDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;


public class QaboOptionsTest extends Hooks{
    private WebDriver driver;

    String orderNumber = "";
    String sum = "";
    String grandTotalInBO = "";

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    DropDownHelper dropDownHelper = new DropDownHelper();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    BrowserHelper browserHelper = new BrowserHelper();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    AddPaymentPopUp addPaymentPopUp = new AddPaymentPopUp();
    Faker faker = new Faker();

    /*
    * All test from here used in other test class.
    * That's why it's not called in testng.xml file
    * */

//    @AfterTest
//    public void closeChrome(){
//        Driver.closeDriver();
//    }

    public void getOrderNumber(String number){
        this.orderNumber = number;
    }

    @BeforeTest
    public void loginToQaBO(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("environmentBO"));
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }


    @Test
    public void openPriceInBO(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
        Helper.pause(1000);
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.waitForElementVisibilityOf(ordersListPageInQabo.orderNumberLink);
        Helper.waitForElementToBeClickable(ordersListPageInQabo.orderNumberLink);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        Helper.navigateToElement(orderInfoQaBo.pricingTab);
        Helper.click(orderInfoQaBo.pricingTab);

//        List<WebElement> listItems = parentDiv.findElements(By.xpath("//div[@class='panel box box-primary']"));
        List<WebElement> listItems = orderInfoQaBo.pricingTabOrderInventoryList.findElements(By.xpath("//div[@class='box-title'][@style='float:right;']"));

        for (WebElement item : listItems) {
            String data = item.getText().replaceAll("[Price: ]", "");
            saveOrderInfo.priceListBo.add(data);
        }
    }
    @Test
    public void financeTabPayByCheck(){
        Helper.click(orderInfoQaBo.financeTab);
        Helper.click(orderInfoQaBo.addPaymentButton);
        Helper.pause(2000);
        Assert.assertTrue(addPaymentPopUp.addPaymentPopUpText.isDisplayed());
        Assert.assertEquals(sum, addPaymentPopUp.inputSumInPopUp.getText());
        Helper.click(addPaymentPopUp.approveTheSum);
        String firstName = faker.name().firstName();
        Helper.sendKeys(addPaymentPopUp.nameOnCheck,firstName);
        String number = faker.number().digit();
        Helper.sendKeys(addPaymentPopUp.checkNumber,number);
        String number2 = faker.number().digit();
        Helper.sendKeys(addPaymentPopUp.bankAuthNumber,number2);
        String number3 = faker.number().digit();
        Helper.sendKeys(addPaymentPopUp.bankAuthNumber,number3);
        String word = "Paying with one check";
        Helper.sendKeys(addPaymentPopUp.detailsfield,word);
        String imagePath =  System.getProperty("user.dir") +"\\src\\main\\java\\picture\\Monkey.jpg";
        Helper.sendKeys(addPaymentPopUp.uploadCheck2, imagePath);
        Helper.click(addPaymentPopUp.addPaymentBtnInPopUp);
        Helper.pause(2000);
        AssertThat.assertText("Booked By Client", orderInfoQaBo.orderStatus);
    }

    @Test
    public Boolean endOfMonthFee(){
        Helper.navigateToElement(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(ordersListPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersListPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersListPageInQabo.ordersStatusFilter, "Draft");
//        Helper.sendKeys(ordersListPageInQabo.orderNumFilterField, orderNumber);
        Helper.click(ordersListPageInQabo.filterButton);
        Helper.pause(2000);
        Helper.waitForElementVisibilityOf(ordersListPageInQabo.orderNumberLink);
        Helper.waitForElementToBeClickable(ordersListPageInQabo.orderNumberLink);
        Helper.click(ordersListPageInQabo.orderNumberLink);
        Helper.navigateToElement(orderInfoQaBo.pricingTab);
        Helper.click(orderInfoQaBo.pricingTab);
        grandTotalInBO = orderInfoQaBo.grandTotalValue.getText();
        Helper.navigateToElement(orderInfoQaBo.fees);
        Helper.click(orderInfoQaBo.fees);
        String feeText = orderInfoQaBo.endOfMonthFeeInFee.getText();
        return feeText.contains("End of Month fee");
    }

    @Test
    public void changeCarrierProcess(){
        browserHelper.refresh(driver);
        AssertThat.assertText("Booked By Client", orderInfoQaBo.orderStatus);
        Helper.click(orderInfoQaBo.ordersDetailsTab);
        Helper.click(orderInfoQaBo.selectMoverButton);
        orderInfoQaBo.selectAnotherCarrierTitle.isDisplayed();
        orderInfoQaBo.notAvailableDropdownButton.isDisplayed();
        orderInfoQaBo.notAvailableDropdownButton.isEnabled();
        orderInfoQaBo.selectThisCarrierButton.isDisplayed();
        orderInfoQaBo.selectThisCarrierButton.isEnabled();
        orderInfoQaBo.availableCarrierAirOneButton.isDisplayed();
        orderInfoQaBo.startChangeCarrierButton.isDisplayed();
        Helper.navigateToElement(orderInfoQaBo.availableCarrierAirOneButton);
        Helper.click(orderInfoQaBo.availableCarrierAirOneButton);
        Helper.click(orderInfoQaBo.startChangeCarrierButton);
        Helper.pause(2000);
        AssertThat.assertText("In Change Mover Process", orderInfoQaBo.orderStatus);
        getOrderNumber(orderInfoQaBo.orderNumberInBO.getText().substring(8));
        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
