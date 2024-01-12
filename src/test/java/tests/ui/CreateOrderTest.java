package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.AssertThat;
import org.example.helper.BrowserHelper;
import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.example.hooks.TestListener;
import org.example.hooks.logs.Log;
import org.example.ui.methods.*;
import org.example.ui.pageObjectModel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.ui.backOfficeTest.QaboOptionsTest;
import org.example.utilities.ConfigReader;
import org.example.utilities.Driver;

import java.util.*;

//@Listeners(TestListener.class)
@Feature("Checking that create order process works properly")
public class CreateOrderTest implements SetUp{
    private static final Logger logger = LogManager.getLogger(CreateOrderTest.class);
    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    DropDownHelper dropDownHelper = new DropDownHelper();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    FullInventoryPage fullInventoryPage = new FullInventoryPage();
    Detail_Page detail_page = new Detail_Page();
    Marketplace_Page marketplace_page = new Marketplace_Page();
    Summary_Page summary_page = new Summary_Page();
    CalendarClass calendarClass = new CalendarClass();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    PaymentPage paymentPage = new PaymentPage();
    BrowserHelper browserHelper = new BrowserHelper();
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();
    GetOrderInfo getOrderInfo = new GetOrderInfo();
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    Success_Page success_page = new Success_Page();
    GetDate getDate = new GetDate();
//    private static WebDriver driver = Driver.getDriver();


//    @BeforeTest
//    @Description("Setup in CreateOrderTest")
//    public static void setUp(){
////        if (driver == null) {
//            logger.info("Trying to open browser and url in openChromeCreateOrder");
////            driver = Driver.getDriver();
//            driver.get(ConfigReader.getProperty("environment"));
//        }
//        else{
//            driver.get(ConfigReader.getProperty("environment"));
//        }
//    }
//        @AfterTest
//    public void tearDown() {
//        logger.info("Closing driver after method CreateOrderTest started "+driver.getCurrentUrl()+driver.getTitle());
//        driver.close();
//    }

    @Test
    public void chooseMoveOption() {
        Helper.click(homePage.itemizedQuoteButtonHomePage);
        DropDownHelper.chooseMoveFrom(driver, "addInventory", 0);
        DropDownHelper.chooseMoveSize(driver, "addInventory", 0);
//        selectRandom.selectRandomOptionFromDropDown(homePage.moveOptionList);
//        selectRandom.selectRandomOptionFromDropDown(homePage.sizeOptionList);
        Helper.pause(1000);
        System.out.println("Order is "+ DropDownHelper.list);
        Helper.click(homePage.addItemsButton);
        boolean condition = DropDownHelper.list.contains("My Storage");
        if(condition){
            orderStorage();
//            System.out.println("Storage");
        }
        else{
            orderHouseApartment();
//            System.out.println("House");
        }
        Helper.pause(3000);
    }

    @Test
    public void orderHouseApartment(){
        System.out.println("Regular order chosen");
        System.out.println("Order number " + fullInventoryPage.currentOrderNumber.getText());
//        AddItemsMethod.addItems(full_inventory.imageElement, 3);
        AddItemsMethod.addRandomItemsMethod(fullInventoryPage.imgItemLocators,3);
        Helper.javascriptScrollIntoView(fullInventoryPage.completeButton);
        Helper.click(fullInventoryPage.completeButton);
    }

    @Test
    public void orderStorage(){
        Helper.pause(2000);
        System.out.println("Storage order chosen");
        System.out.println("Order number " + fullInventoryPage.currentOrderNumber.getText());
        Helper.click(fullInventoryPage.continueButton);
    }

    @Test(dependsOnMethods = "chooseMoveOption")
    public void boxCalculatingPage(){
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(boxCalculatingPopUp.continueButton);
//            Helper.navigateToElement(boxCalculatingPopUp.continueButton);
        Helper.click(boxCalculatingPopUp.continueButton);
    }

    @Test(dependsOnMethods = {"boxCalculatingPage", "chooseMoveOption"})
    public void details_Page() {
        Helper.pause(2000);
        calendarClass.getRandomDate(detail_page.datePicker, detail_page.monthInDate);
//        getDate.getRandomDate(detail_page.datePicker, detail_page.monthInDate);
        Helper.pause(2000);
        String pickUp = "12334 Cantura Street, Los Angeles, CA 91604";
        String dropOff = "12340 Boggy Creek Road, Orlando, FL 32824";
        SetAddress.testMethod(pickUp, detail_page.pickUpFromInputField);

//        performActionOnElements.setValuesToFillFields("Remark auto test pickUp");
//        performActionOnElements.fillCCFieldsElementTest(detail_page.anyRemarksInputField, detail_page.anyRestrictionTextButtonPickUp,detail_page.flightOfStairsPlusButtonPickup,
//                detail_page.longCarryPlusButtonPickup);
//        Helper.click(detail_page.elevatorYesPickup);
//        Helper.click(detail_page.NeedShuttleYesPickup);
//        Helper.click(detail_page.BuildingInsuranceYesPickup);

        SetAddress.testMethod2(dropOff, detail_page.dropOffAtInputField);
//        performActionOnElements.setValuesToFillFields("Remark auto test dropOff");
//        performActionOnElements.fillCCFieldsElementTest(detail_page.anyRemarksInputFieldDropOff, detail_page.flightOfStairsPlusButtonDropOff,
//                detail_page.longCarryPlusButtonDropOff);
//        Helper.click(detail_page.dropOffElevatorYes);
//        Helper.click(detail_page.dropOffNeedShuttleYes);
//        Helper.click(detail_page.dropOffBuildingInsuranceYes);
        Helper.pause(2000);
        Helper.javascriptScrollDownThePage();
        Helper.navigateToElement(detail_page.checkRatesButton);
        Helper.click(detail_page.checkRatesButton);

        Helper.pause(4000);
    }

    @Test(dependsOnMethods = {"details_Page"})
    public void marketplace_Page(){
//        int ran =  new Random().nextInt(3);
//        System.out.println("Random number is "+ran);
//        DropDownHelper.selectUsingIndex(moving_result_page.flexibilityDropDown2, ran);
        Helper.pause(3000);

        marketplace_page.myInventoryLink.isDisplayed();
        marketplace_page.myInventoryLink.isEnabled();
        Assert.assertEquals(marketplace_page.myInventoryLink.getAttribute("class"), "past");
        Assert.assertTrue(marketplace_page.myInventoryIcon.getAttribute("class").contains("active"));
        marketplace_page.tripDetailsLink.isDisplayed();
        marketplace_page.tripDetailsLink.isEnabled();
        Assert.assertEquals(marketplace_page.tripDetailsLink.getAttribute("class"), "past");
        Assert.assertTrue(marketplace_page.tripDetailsIcon.getAttribute("class").contains("active"));
        marketplace_page.marketplaceLink.isDisplayed();
        Assert.assertEquals(marketplace_page.marketplaceLink.getAttribute("class"), "active");
        Assert.assertTrue(marketplace_page.marketplaceIcon.getAttribute("class").contains("active"));
        marketplace_page.summaryLink.isDisplayed();
        Assert.assertEquals(marketplace_page.summaryLink.getAttribute("class"), "future");
        Assert.assertEquals(marketplace_page.summaryIcon.getAttribute("class").trim(), "circle");
        marketplace_page.paymentLink.isDisplayed();
        Assert.assertEquals(marketplace_page.paymentLink.getAttribute("class"), "future");
        Assert.assertEquals(marketplace_page.paymentIcon.getAttribute("class").trim(), "circle");
//        Helper.click(moving_result_page.tripDetailsLink);
//        Helper.pause(1000);
//        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/full-inventory/#!/moving-details");
//        Helper.click(moving_result_page.myInventoryLink);
//        Helper.pause(1000);
//        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/full-inventory/#!/");
//        Helper.click(full_inventory.completeOrder);
//        if(boxCalculatingPopUp.addAndContinueButton.isDisplayed()){
//            Helper.navigateToElement(boxCalculatingPopUp.addAndContinueButton);
//            Helper.click(boxCalculatingPopUp.addAndContinueButton);
//        }
//        if(boxCalculatingPopUp.skipButton.isDisplayed()){
//            Helper.click(boxCalculatingPopUp.skipButton);
//        }
//        Helper.javascriptScrollDownThePage();
//        Helper.navigateToElement(moving_detail_page.checkRatesButton);
//        Helper.click(moving_detail_page.checkRatesButton);
        marketplace_page.addressInPickUpBox.isDisplayed();
        marketplace_page.addressInDropOffBox.isDisplayed();
        marketplace_page.dateInDateBox.isDisplayed();
        marketplace_page.itemsInInventory.isDisplayed();
        marketplace_page.orderNumber.isDisplayed();
        Helper.pause(2000);
        saveOrderInfo.orderInfo.clear();
        saveOrderInfo.setOrderInfo(marketplace_page.labelInPickUpBox.getText(), marketplace_page.addressInPickUpBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInDropOffBox.getText(), marketplace_page.addressInDropOffBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInDateBox.getText(), marketplace_page.dateInDateBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInInventoryBox.getText(), marketplace_page.itemsInInventory.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.orderNumberLabel.getText(), marketplace_page.orderNumber.getText());
        saveOrderInfo.setOrderInfo("CarrierName", marketplace_page.firstCarrierButton.getText());
        saveOrderInfo.setOrderInfo("OrderPrice", getOrderInfo.getOrderPriceByCarrierName(marketplace_page.firstCarrierButton.getText()));
        System.out.println("Carrier name: "+marketplace_page.firstCarrierButton.getText());
        System.out.println("Order number: "+saveOrderInfo.orderInfo.get(summary_page.orderNumberLabel.getText()));
        //
        marketplace_page.movingInfoText.isDisplayed();
        AssertThat.assertText("Guaranteed price based on inventory and services, including tax, tolls, fuel, mileage, disassembly/reassembly, " +
                "loading/unloading, blanket wrapping, and basic liability coverage. Prices are not final until purchase is completed.", marketplace_page.movingInfoText);
        //

//        Helper.javascriptScrollIntoView(moving_result_page.packingServicesTitle);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.packingServicesCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.flexibilityCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.deliveryWindowCheckboxSideBar);
        Helper.pause(3000);
        Helper.waitForElementToBeDisplayed(marketplace_page.firstCarrierButton);
        Helper.navigateToElement(marketplace_page.firstCarrierButton);
        Helper.click(marketplace_page.firstCarrierButton);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckbox);
        Helper.navigateToElement(marketplace_page.selectButtonInPopup);
        Helper.click(marketplace_page.selectButtonInPopup);
    }

    @Test(dependsOnMethods = {"marketplace_Page"})
    public void summary_Page(){
        Helper.pause(2000);

        Assert.assertEquals(summary_page.addressInPickUpBox.getText(),saveOrderInfo.orderInfo.get(summary_page.labelInPickUpBox.getText()));
        Assert.assertEquals(summary_page.addressInDropOffBox.getText(),saveOrderInfo.orderInfo.get(summary_page.labelInDropOffBox.getText()));
        Assert.assertEquals(summary_page.dateInDateBox.getText().replaceAll("[.,]",""),saveOrderInfo.orderInfo.get(summary_page.labelInDateBox.getText()));
        Assert.assertEquals(summary_page.itemsInInventory.getText(),saveOrderInfo.orderInfo.get(summary_page.labelInInventoryBox.getText()));
//        Assert.assertEquals(summary_page.orderNumber.getText(),saveOrderInfo.orderInfo.get(summary_page.orderNumberLabel.getText()));
        Helper.pause(2000);
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.movingJourneyLabel.getText().substring(0,14), moving_confirm_page.movingJourneyMiles.getText().substring(17));
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.addressesRestrictionsLabel.getText(), moving_confirm_page.addressesRestrictionsPrice.getText());
//        Helper.navigateToElement(moving_confirm_page.inventoryItemsLabel);
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.inventoryItemsLabel.getText(), moving_confirm_page.inventoryItemsPrice.getText());
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.inventoryBoxesLabel.getText(), moving_confirm_page.inventoryBoxesPrice.getText());
//        Helper.navigateToElement(moving_confirm_page.additionalServicesLabel);
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.additionalServicesLabel.getText(), moving_confirm_page.additionalServicesPrice.getText());
//        Helper.navigateToElement(moving_confirm_page.feesLabel);
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.feesLabel.getText(), moving_confirm_page.feesPrice.getText());
//        saveOrderInfo.setInventoryListInfo(moving_confirm_page.totalPriceLabel.getText(), moving_confirm_page.totalPrice.getText());


        // Получение всех элементов li из списка
        List<WebElement> listItems = summary_page.ulListOfElements.findElements(By.tagName("a"));

//        saveOrderInfo.setInventoryListInfo3(listItems);

        for (WebElement item : listItems) {
            String data = item.getText();
            String word = SaveOrderInfo.extractLabel(data);
            String number = SaveOrderInfo.extractValue(data);
            saveOrderInfo.setInventoryListInfo(word,number);
        }

//        System.out.println(saveOrderInfo.inventoryListInfo);
        browserHelper.newWindow(driver);
        qaboOptionsTest.getOrderNumber(saveOrderInfo.orderInfo.get("Order #"));
        browserHelper.getWindowHandles(driver);
        browserHelper.SwitchToWindow(1,driver);
        qaboOptionsTest.loginToQaBO();
        qaboOptionsTest.openPriceInBO();
        getOrderInfo.comparePriceWebBo(saveOrderInfo.priceListBo, saveOrderInfo.inventoryListInfo);

        browserHelper.switchToParentWithChildClose(driver);
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(summary_page.addPremiumPackingButton);
        Helper.click(summary_page.addPremiumPackingButton);
        Helper.javascriptScrollIntoView(summary_page.checkOutButton);
        Helper.click(summary_page.checkOutButton);
    }


    @Test(dependsOnMethods = {"summary_Page"})
    public void payment_Page(){
        Helper.pause(3000);
        getOrderInfo.getOrderInfoMulti(saveOrderInfo.inventoryListInfo);
        String price = String.valueOf(saveOrderInfo.inventoryListInfo.get("Total"));
//        Assert.assertEquals(paymentPage.orderPrice.getText(), price.substring(1, price.length()-1));
//        String num1 = paymentPage.orderPrice.getText().replaceAll("[$,]", "");
//        String num2 = paymentPage.serviceFeePrice.getText();
//        System.out.println("num1 "+num1);
//        System.out.println("num2 "+num2);
//        Assert.assertEquals(paymentPage.serviceFeePrice.getText(), String.valueOf(Helper.roundingsFee(Helper.calculatePercent(paymentPage.orderPrice, 5))));
        double totalPrice = Double.parseDouble(paymentPage.orderPrice.getText().replaceAll("[$,]","")) + Double.parseDouble(paymentPage.serviceFeePrice.getText().replaceAll("[$,]",""));
//        Assert.assertEquals(String.valueOf(Helper.roundingsFee(totalPrice)), paymentPage.totalPrice.getText().replaceAll("[$,]",""));
//        Helper.numberComparison(Helper.roundingsFee(totalPrice), Double.parseDouble(paymentPage.totalPrice.getText().replaceAll("[$,]","")));

        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
        performActionOnElements.fillCCFieldsElementTest(paymentPage.signInButton, paymentPage.emailFieldLogin, paymentPage.passwordFieldLogin, paymentPage.loginButton);
        Helper.pause(2000);

        performActionOnElements.setValuesToFillFields("clientFirstName","05","5424 0000 0000 0015","27","123");
//        performActionOnElements.fillCCFieldsElementTest(paymentPage.newPaymentCard,paymentPage.expiryMonthSelectField, paymentPage.cardNameInputField, paymentPage.cardNumberInputField,paymentPage.cardNumberInputField,
//                paymentPage.expiryYearSelectField,paymentPage.cvvNumberInputField, paymentPage.billingAddressCheckBox);
//        performActionOnElements.fillCCFieldsInPayment();
        performActionOnElements.clickRandomCreditCard(paymentPage.visaDebitCardCheckBoxList);
        Helper.javascriptScrollDownThePage();
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
    }

    @Test(dependsOnMethods = {"payment_Page"})
    public void success_Page_Test(){
        success_page.thankYouText.isDisplayed();
        success_page.customerName.isDisplayed();
        AssertThat.assertText("Thank You", success_page.thankYouText);
        AssertThat.assertText(success_page.text, success_page.textInSuccessPage);
        Helper.pause(2000);
    }
}
