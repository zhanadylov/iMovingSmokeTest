package tests.ui;

import helper.AssertThat;
import helper.BrowserHelper;
import helper.Helper;
import hooks.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.ui.backOfficeTest.QaboOptionsTest;
import ui.methods.*;
import ui.pageObjectModel.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.*;

//@Listeners(TestStatusListener.class)
public class CreateOrderTest extends Hooks{
    private static final Logger logger = LogManager.getLogger(CreateOrderTest.class);

    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    PopUpsPage popUpsPage = new PopUpsPage();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
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
    private WebDriver driver;

    @BeforeClass
    public void openChrome(){
        try {
            if (driver == null) {
                logger.info("Trying to open browser and url");
                driver = Driver.getDriver();
                driver.get(ConfigReader.getProperty("environment"));
            }
        } catch (Exception e) {
            logger.error("Error occurred while opening browser and url: " + e.getMessage());
        }
        logger.info("browser and url opened "+driver.getCurrentUrl());
    }
    @AfterClass
    public void tearDownClass() {
        logger.info("Closing driver after method CreateOrderTest started "+driver.getCurrentUrl()+driver.getTitle());
        Driver.closeDriver();
    }
    @Test
    public void chooseMoveOption() {
        selectRandom.selectRandomOptionFromDropDown(homePage.moveOptionList);
        selectRandom.selectRandomOptionFromDropDown(homePage.sizeOptionList);
        Helper.pause(1000);
        System.out.println("Order is "+selectRandom.list);
        Helper.click(homePage.compareQuotes);
        boolean condition = selectRandom.list.contains("My Storage");
        if(condition){
            orderStorage();
        }
        else{
            orderHouseApartment();
        }
        Helper.pause(3000);
    }

    @Test(enabled = false)
    public void orderHouseApartment(){
        Helper.click(popUpsPage.continueButton);
        Helper.click(popUpsPage.xButtonSecond);
        Helper.click(popUpsPage.okButtonThird);
        AddItemsMethod.addItems(full_inventory.imageElement, 3);
        Helper.click(full_inventory.completeOrder);
        Helper.navigateToElement(boxCalculatingPopUp.addAndContinueButton);
        Helper.click(boxCalculatingPopUp.addAndContinueButton);
        if (Helper.isElementPresent(boxCalculatingPopUp.skipButton)) {
            Helper.click(boxCalculatingPopUp.skipButton);
        }
//        Helper.clickButtonIfDisplayed(boxCalculatingPopUp.skipButton);
    }

    @Test(enabled = false)
    public void orderStorage(){
        Helper.pause(2000);
        // Both slider clicker works
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine2, 10, 100);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine, 0, 100);
//        Helper.pause(2000);
        Helper.click(full_inventory.completeOrder);
    }

    @Test
    public void details_Page() {
        Helper.pause(2000);
        calendarClass.getRandomDate(detail_page.datePicker, detail_page.monthInDate);
//        getDate.getRandomDate(detail_page.datePicker, detail_page.monthInDate);
        Helper.pause(2000);
        String pickUp = "12334 Cantura Street, Los Angeles, CA 91604";
        String dropOff = "12340 Boggy Creek Road, Orlando, FL 32824";
        SetAddress.testMethod(pickUp, detail_page.pickUpFromInputField);
        performActionOnElements.setValuesToFillFields("Remark auto test pickUp");
        performActionOnElements.fillCCFieldsElementTest(detail_page.anyRemarksInputField, detail_page.flightOfStairsPlusButtonPickup,
                detail_page.longCarryPlusButtonPickup);
        Helper.click(detail_page.elevatorYesPickup);
        Helper.click(detail_page.NeedShuttleYesPickup);
        Helper.click(detail_page.BuildingInsuranceYesPickup);

        SetAddress.testMethod2(dropOff, detail_page.dropOffAtInputField);
        performActionOnElements.setValuesToFillFields("Remark auto test dropOff");
        performActionOnElements.fillCCFieldsElementTest(detail_page.anyRemarksInputFieldDropOff, detail_page.flightOfStairsPlusButtonDropOff,
                detail_page.longCarryPlusButtonDropOff);
        Helper.click(detail_page.dropOffElevatorYes);
        Helper.click(detail_page.dropOffNeedShuttleYes);
        Helper.click(detail_page.dropOffBuildingInsuranceYes);
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
        Assert.assertEquals(marketplace_page.myInventoryIcon.getAttribute("class"), "greenImg");
        marketplace_page.tripDetailsLink.isDisplayed();
        marketplace_page.tripDetailsLink.isEnabled();
        Assert.assertEquals(marketplace_page.tripDetailsLink.getAttribute("class"), "past");
        Assert.assertEquals(marketplace_page.tripDetailsIcon.getAttribute("class"), "greenImg");
        marketplace_page.myPricesLink.isDisplayed();
        Assert.assertEquals(marketplace_page.myPricesLink.getAttribute("class"), "active");
        Assert.assertEquals(marketplace_page.myPricesIcon.getAttribute("class"), "circle active");
        marketplace_page.confirmationLink.isDisplayed();
        Assert.assertEquals(marketplace_page.confirmationLink.getAttribute("class"), "future");
        Assert.assertEquals(marketplace_page.confirmationIcon.getAttribute("class"), "circle");
        marketplace_page.paymentLink.isDisplayed();
        Assert.assertEquals(marketplace_page.paymentLink.getAttribute("class"), "future");
        Assert.assertEquals(marketplace_page.paymentIcon.getAttribute("class"), "circle");
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
        saveOrderInfo.setOrderInfo(marketplace_page.labelInPickUpBox.getText(), marketplace_page.addressInPickUpBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInDropOffBox.getText(), marketplace_page.addressInDropOffBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInDateBox.getText(), marketplace_page.dateInDateBox.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.labelInInventoryBox.getText(), marketplace_page.itemsInInventory.getText());
        saveOrderInfo.setOrderInfo(marketplace_page.orderNumberLabel.getText(), marketplace_page.orderNumber.getText());
        saveOrderInfo.setOrderInfo("CarrierName", marketplace_page.carrierName.getText());
        saveOrderInfo.setOrderInfo("OrderPrice", marketplace_page.orderPrice.getText());
        System.out.println("Carrier name: "+marketplace_page.carrierName.getText());
        System.out.println("Order number: "+saveOrderInfo.orderInfo.get(summary_page.orderNumberLabel.getText()));
        //
        marketplace_page.movingInfoText.isDisplayed();
        AssertThat.assertText("Price includes tax, tolls, fuel, mileage, disassembly/reassembly, loading/unloading, blanket wrapping, basic liability.\n" +
                "You may review added services before checkout. Prices not final until purchase is completed.", marketplace_page.movingInfoText);
        //
        marketplace_page.whyBookWithIMovingTitle.isDisplayed();
        AssertThat.assertText("Why Book with iMoving?", marketplace_page.whyBookWithIMovingTitle);
        marketplace_page.bindingPriceText.isDisplayed();
        AssertThat.assertText("Binding Price", marketplace_page.bindingPriceText);
        marketplace_page.inventoryControlText.isDisplayed();
        AssertThat.assertText("Inventory Control", marketplace_page.inventoryControlText);
        marketplace_page.securePaymentText.isDisplayed();
        AssertThat.assertText("Secure Payment", marketplace_page.securePaymentText);
        marketplace_page.priceMatchText.isDisplayed();
        AssertThat.assertText("Price Match", marketplace_page.priceMatchText);
        marketplace_page.customerSupportText.isDisplayed();
        AssertThat.assertText("Customer Support", marketplace_page.customerSupportText);
        //
        marketplace_page.bindingPriceTooltipIcon.isDisplayed();
        marketplace_page.bindingPriceTooltipIcon.isEnabled();
        Helper.navigateToElement(marketplace_page.bindingPriceTooltipIcon);
        Helper.waitForElementVisibilityOf(marketplace_page.bindingPriceTooltipContent);
        AssertThat.assertText( "Guaranteed price based on items and services", marketplace_page.bindingPriceTooltipContent);
        marketplace_page.customerSupportTooltipIcon.isDisplayed();
        marketplace_page.customerSupportTooltipIcon.isEnabled();
        Helper.navigateToElement(marketplace_page.customerSupportTooltipIcon);
        Helper.waitForElementVisibilityOf(marketplace_page.customerSupportTooltipContent);
        AssertThat.assertText( "Live agents available for anything you need", marketplace_page.customerSupportTooltipContent);
        marketplace_page.inventoryControlTooltipIcon.isDisplayed();
        marketplace_page.inventoryControlTooltipIcon.isEnabled();
        Helper.navigateToElement(marketplace_page.inventoryControlTooltipIcon);
        Helper.waitForElementVisibilityOf(marketplace_page.inventoryControlTooltipContent);
        AssertThat.assertText( "Control your price by adding / removing items and services", marketplace_page.inventoryControlTooltipContent);
        marketplace_page.priceMatchTooltipIcon.isDisplayed();
        marketplace_page.priceMatchTooltipIcon.isEnabled();
        Helper.navigateToElement(marketplace_page.priceMatchTooltipIcon);
        Helper.waitForElementVisibilityOf(marketplace_page.priceMatchTooltipContent);
        AssertThat.assertText( "Price match guarantee", marketplace_page.priceMatchTooltipContent);
        marketplace_page.securePaymentTooltipIcon.isDisplayed();
        marketplace_page.securePaymentTooltipIcon.isEnabled();
        Helper.navigateToElement(marketplace_page.securePaymentTooltipIcon);
        Helper.waitForElementVisibilityOf(marketplace_page.securePaymentTooltipContent);
        AssertThat.assertText( "Your personal and financial information is confidential", marketplace_page.securePaymentTooltipContent);
        //

        Helper.pause(2000);
//        Helper.javascriptScrollIntoView(moving_result_page.packingServicesTitle);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.packingServicesCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.flexibilityCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomRadioButton(moving_result_page.deliveryWindowCheckboxSideBar);
        Helper.pause(1000);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckbox);
        Helper.navigateToElement(marketplace_page.selectButton);
        Helper.click(marketplace_page.selectButton);
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
        qaboOptionsTest.getOrderNumber(saveOrderInfo.orderInfo.get("Order No"));
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
        Helper.numberComparison(Helper.roundingsFee(totalPrice), Double.parseDouble(paymentPage.totalPrice.getText().replaceAll("[$,]","")));

        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
        performActionOnElements.fillCCFieldsElementTest(paymentPage.signInButton, paymentPage.emailFieldLogin, paymentPage.passwordFieldLogin, paymentPage.loginButton);
        Helper.pause(2000);

        performActionOnElements.setValuesToFillFields("clientFirstName","May","5424 0000 0000 0015","2027","123");
//        performActionOnElements.fillCCFieldsElementTest(paymentPage.newPaymentCard,paymentPage.expiryMonthSelectField, paymentPage.cardNameInputField, paymentPage.cardNumberInputField,paymentPage.cardNumberInputField,
//                paymentPage.expiryYearSelectField,paymentPage.cvvNumberInputField, paymentPage.billingAddressCheckBox);
        performActionOnElements.fillCCFieldsInPayment();
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
