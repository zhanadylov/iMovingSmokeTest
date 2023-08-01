package tests.backOfficeTest;

import com.github.javafaker.Faker;
import helper.AssertThat;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.SaveOrderInfo;
import ui.methods.SetUpBO;
import ui.qabo.LoginPage;
import ui.qabo.ManualPayment.AddPaymentPopUp;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersPageInQabo;
import ui.qabo.QaboDashBoardPage;

import java.util.List;

import static ui.methods.SetUp.driver;


public class QaboOptionsTest extends Hooks implements SetUpBO {
    String orderNumber = "";
    String sum = "";

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersPageInQabo ordersPageInQabo = new OrdersPageInQabo();
    DropDownHelper dropDownHelper = new DropDownHelper();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    AddPaymentPopUp addPaymentPopUp = new AddPaymentPopUp();
    Faker faker = new Faker();

//    @BeforeTest
//    public void openQaBoWeb(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open('https://qabo.imoving.com/', '_blank');");
//    }

    public void getOrderNumber(String number){
        this.orderNumber = number;
    }

    @BeforeTest
    public void loginToQaBO(){
        driver.get("https://qabo.imoving.com/Account/Login");
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
        Helper.waitForElementToBeDisplayed(ordersPageInQabo.ordersTitleText);
        Helper.navigateToElement(ordersPageInQabo.ordersStatusFilter);
        DropDownHelper.selectUsingVisibleText(ordersPageInQabo.ordersStatusFilter, "All");
        Helper.sendKeys(ordersPageInQabo.orderNumFilterField, orderNumber);
        Helper.pause(1000);
        Helper.click(ordersPageInQabo.filterButton);
        Helper.waitForElementVisibilityOf(ordersPageInQabo.orderNumberLink);
        Helper.waitForElementToBeClickable(ordersPageInQabo.orderNumberLink);
        Helper.click(ordersPageInQabo.orderNumberLink);
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

}
