package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.*;
import org.example.hooks.TestListener;
import org.example.ui.methods.*;
import org.example.ui.pageObjectModel.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.ui.backOfficeTest.QaboOptionsTest;

//@Listeners(TestListener.class)
@Feature("Additional pickup process and by CC and check")
public class AdditionalPickUpTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(AdditionalPickUpTest.class);
private static final Logger logger = LogManager.getLogger(AdditionalPickUpTest.class);
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    HomePage homePage = new HomePage();
    UserZonePage userZonePage = new UserZonePage();
    Full_inventory_Page full_inventory_page = new Full_inventory_Page();
    Detail_Page _detail_page = new Detail_Page();
    Summary_Page summary_page = new Summary_Page();
    PopUpsTest popUpsTest = new PopUpsTest();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
    PaymentPage paymentPage = new PaymentPage();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    BrowserHelper browserHelper = new BrowserHelper();
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();
    GetOrderInfo getOrderInfo = new GetOrderInfo();
    GetInventoryValues getInventoryValues = new GetInventoryValues();
    AlertHelper alertHelper = new AlertHelper(driver);
    public AdditionalPickUpTest(){
        super("environment");
    }

    @Test
    @Description("Additional pickup paying with CC")
    public void addAdditionalPickUpPayByCC() throws InterruptedException {
//        popUpsTest.continueOrderPopUp();
        browserHelper.refresh(driver);
        Thread.sleep(3000);
            if(Helper.isElementPresent(homePage.userNameAfterLogin)){
                logger.info("user name exists");
                Helper.click(homePage.userNameAfterLogin);
            }else{
                logger.info("User name not exists going to login");
        performActionOnElements.setValuesToFillFields("qatestimoving@gmail.com","QATest-2022");
        performActionOnElements.fillCCFieldsElementTest(homePage.SignInButton,homePage.inputEmail, homePage.inputPassword, homePage.loginButtonInSignIn);
                Helper.click(homePage.userNameAfterLogin);
            }
        userZonePage.myLastMovePlansTitle.isDisplayed();
        Helper.click(userZonePage.firstOrderLink);
        userZonePage.movingJourneyTitle.isDisplayed();
        userZonePage.inventoryInformationTitle.isDisplayed();
        Helper.click(userZonePage.manageOrderButton);
        Helper.navigateToElement(userZonePage.EditInventoryButton);
        Helper.click(userZonePage.EditInventoryButton);
        userZonePage.EditInventoryPopupTitle.isDisplayed();
        userZonePage.warningIcon.isDisplayed();
        Helper.click(userZonePage.editButtonPopup);
        Helper.pause(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/full-inventory/#!/");
        full_inventory_page.fullInventoryTitle.isDisplayed();
        Helper.javascriptScrollIntoView(full_inventory_page.manageRoomsButton);
        full_inventory_page.addAdditionalPickupLocationLink.isDisplayed();
        Helper.click(full_inventory_page.manageRoomsButton);
        full_inventory_page.theseAreRecommendedRoomsForaText.isDisplayed();
        full_inventory_page.addOrRemoveAsYouNeedText.isDisplayed();
        Helper.click(full_inventory_page.confirmButtonInManageRoomPopup);
        Helper.javascriptScrollIntoView(full_inventory_page.confirmButtonInManageRoomPopup);
        Helper.click(full_inventory_page.addAdditionalPickupLocationLink);
        full_inventory_page.additionalStorage.isDisplayed();
        full_inventory_page.additionalBoxes.isDisplayed();
        full_inventory_page.additionalItems.isDisplayed();
        Helper.click(full_inventory_page.additionalItems);
        full_inventory_page.additionalItemsRoomHeader.isDisplayed();
        AddItemsMethod.addItemElements(full_inventory_page.imageElement, 10);
        Helper.click(full_inventory_page.nextRoomButtonPopup);
        Helper.javascriptScrollIntoView(full_inventory_page.addAdditionalPickupLocationLink);
        Helper.click(full_inventory_page.completeOrder);
//        Helper.javascriptScrollDownThePage();
//        if (Helper.isElementPresent(boxCalculatingPopUp.continueButton)) {
        Helper.pause(1000);
            Helper.javascriptScrollIntoView(boxCalculatingPopUp.continueButton);
            Helper.click(boxCalculatingPopUp.continueButton);
//        }
        Helper.pause(1000);
        try {
            if (Helper.isElementPresent(boxCalculatingPopUp.skipButton)) {
                Helper.click(boxCalculatingPopUp.skipButton);
            }
        } catch (NoSuchElementException e) {
            logger.info("Skip button not appeared");
        }
        String dropOff = "1245 Wilshire Boulevard, Los Angeles, CA, 90017";
        SetAddress.testMethod2(dropOff, _detail_page.dropOffAtInputField);
        Helper.javascriptScrollIntoView(_detail_page.confirmButton);
        Helper.click(_detail_page.confirmButton);
        Helper.javascriptScrollIntoView(summary_page.checkOutButton);
        Helper.click(summary_page.checkOutButton);
        Helper.pause(2000);
//        performActionOnElements.setValuesToFillFields("clientFirstName","05","5424 0000 0000 0015","27","123");
//        performActionOnElements.fillCCFieldsElementTest(paymentPage.newPaymentCard, paymentPage.cardNameInputField, paymentPage.cardNumberInputField,paymentPage.cardNumberInputField,
//                paymentPage.expiryYearSelectField,paymentPage.cvvNumberInputField, paymentPage.billingAddressCheckBox);
        performActionOnElements.clickRandomCreditCard(paymentPage.visaDebitCardCheckBoxList);
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(paymentPage.completeBookingButton);
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
    }

    @Test
    @Description("Additional pickup paying with check")
    public void addAdditionalPickUpPayByCheck() throws InterruptedException {
        browserHelper.refresh(driver);
        Helper.pause(2000);
            if(Helper.isElementPresent(homePage.userNameAfterLogin)){
                logger.info("Going to click user name");
                Helper.click(homePage.userNameAfterLogin);
            }else{
                logger.info("Going to signin");
                performActionOnElements.setValuesToFillFields("qatestimoving@gmail.com","QATest-2022");
                performActionOnElements.fillCCFieldsElementTest(homePage.SignInButton,homePage.inputEmail, homePage.inputPassword, homePage.loginButtonInSignIn);
                Helper.click(homePage.userNameAfterLogin);
            }

        userZonePage.myLastMovePlansTitle.isDisplayed();
//        String xpath = userZonePage.orderLinkByNumber.toString().replace("INDEX", saveOrderInfo.orderInfo.get("Order #")).replaceAll("Proxy element for: DefaultElementLocator 'By.xpath: (.+)'", "$1");
//        WebElement orderLink = driver.findElement(By.xpath(xpath));
        Helper.click(userZonePage.firstOrderLink);
        userZonePage.movingJourneyTitle.isDisplayed();
        userZonePage.inventoryInformationTitle.isDisplayed();
        Helper.click(userZonePage.manageOrderButton);
        Helper.navigateToElement(userZonePage.EditInventoryButton);
        Helper.click(userZonePage.EditInventoryButton);
        userZonePage.EditInventoryPopupTitle.isDisplayed();
        userZonePage.warningIcon.isDisplayed();
        Helper.click(userZonePage.editButtonPopup);
        Helper.pause(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/full-inventory/#!/");
        full_inventory_page.fullInventoryTitle.isDisplayed();
        Helper.javascriptScrollIntoView(full_inventory_page.addAdditionalPickupLocationLink);
        Helper.click(full_inventory_page.addAdditionalPickupLocationLink);
        full_inventory_page.additionalStorage.isDisplayed();
        full_inventory_page.additionalBoxes.isDisplayed();
        full_inventory_page.additionalItems.isDisplayed();
        Helper.click(full_inventory_page.additionalBoxes);
//        Helper.click(full_inventory_page.nextRoomButtonPopup);
//        popUpsTest.passPopInSlashOne();
        full_inventory_page.additionalBoxesRoomHeader.isDisplayed();

        AddItem.hoverOverAndClickMinusPlusManageRooms("Medium Box", "+", 1);
        Assert.assertEquals(GetInventoryValues.getBoxesQuantity("Medium Box"), "1");
        AddItem.hoverOverAndClickMinusPlusManageRooms("Lamp Box", "+", 5);
        Assert.assertEquals(GetInventoryValues.getBoxesQuantity("Lamp Box"), "5");
        AddItem.hoverOverAndClickMinusPlusManageRooms("Wardrobe Box", "+", 3);
        Assert.assertEquals(GetInventoryValues.getBoxesQuantity("Wardrobe Box"),"3");
        Helper.click(full_inventory_page.nextRoomButtonPopup);
        Helper.javascriptScrollIntoView(full_inventory_page.completeOrder);
        Helper.click(full_inventory_page.completeOrder);
        Helper.pause(1000);
        if (Helper.isElementPresent(boxCalculatingPopUp.continueButton)) {
            Helper.javascriptScrollIntoView(boxCalculatingPopUp.continueButton);
            Helper.click(boxCalculatingPopUp.continueButton);
        }

        try {
            if (Helper.isElementPresent(boxCalculatingPopUp.skipButton)) {
                Helper.click(boxCalculatingPopUp.skipButton);
            }
        } catch (NoSuchElementException e) {
            logger.info("Skip button not appeared");
        }
        Helper.pause(2000);
        saveOrderInfo.setOrderInfo(_detail_page.orderNumberLabel.getText(), _detail_page.orderNumber.getText().replaceAll("Order #", ""));
        logger.info("Get order number from page "+_detail_page.orderNumber.getText());
        logger.info("Get order number from list "+saveOrderInfo.orderInfo.get("Order #"));
        String dropOff = "1245 Wilshire Boulevard, Los Angeles, CA, 90017";
        SetAddress.testMethod2(dropOff, _detail_page.dropOffAtInputField);
        Helper.javascriptScrollIntoView(_detail_page.confirmButton);
        Helper.click(_detail_page.confirmButton);
        Helper.pause(2000);
        browserHelper.newWindow(driver);
        qaboOptionsTest.getOrderNumber(saveOrderInfo.orderInfo.get("Order #"));
        browserHelper.getWindowHandles(driver);
        browserHelper.SwitchToWindow(1,driver);
        qaboOptionsTest.loginToQaBO();
        qaboOptionsTest.openPriceInBO();
        getOrderInfo.comparePriceWebBo(saveOrderInfo.priceListBo, saveOrderInfo.inventoryListInfo);
        qaboOptionsTest.financeTabPayByCheck();
        browserHelper.switchToParentWithChildClose(driver);
        Helper.pause(3000);
    }

}
