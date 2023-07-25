package tests;

import helper.AssertThat;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import hooks.TestStatusListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.backOfficeTest.QaboOptionsTest;
import ui.methods.*;
import ui.pageObjectModel.*;

import java.util.*;

@Listeners(TestStatusListener.class)
public class CreateOrder extends Hooks implements SetUp {
    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    PopUpsPage popUpsPage = new PopUpsPage();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    Moving_Detail_Page moving_detail_page = new Moving_Detail_Page();
    Moving_Result_Page moving_result_page = new Moving_Result_Page();
    Moving_Confirm_Page moving_confirm_page = new Moving_Confirm_Page();
    CalendarClass calendarClass = new CalendarClass();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    PaymentPage paymentPage = new PaymentPage();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();
    GetOrderInfo getOrderInfo = new GetOrderInfo();
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    Success_Page success_page = new Success_Page();
    AdditionalPickUpTest additionalPickUpTest = new AdditionalPickUpTest();

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
        if(boxCalculatingPopUp.skipButton.isDisplayed()){
            Helper.click(boxCalculatingPopUp.skipButton);
        }else{
            System.out.println("Skip button not displayed");
        }
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
    public void moving_Details_Page() {
        Helper.pause(2000);
        calendarClass.getRandomDate(moving_detail_page.datePicker, moving_detail_page.monthInDate);
        Helper.pause(2000);
        String pickUp = "1234 Wilshire Boulevard, Los Angeles, CA, 90017";
        String dropOff = "12340 Boggy Creek Road, Orlando, FL, 32824";
        SetAddress.testMethod(pickUp, moving_detail_page.pickUpFromInputField);
        performActionOnElements.setValuesToFillFields("atp-2", "Remark auto test pickUp");
        performActionOnElements.fillCCFieldsElementTest(moving_detail_page.aptNumInputField, moving_detail_page.anyRemarksInputField, moving_detail_page.flightOfStairsPlusButtonPickup,
                moving_detail_page.longCarryPlusButtonPickup);
        Helper.click(moving_detail_page.elevatorYesPickup);
        Helper.click(moving_detail_page.NeedShuttleYesPickup);
        Helper.click(moving_detail_page.BuildingInsuranceYesPickup);

        SetAddress.testMethod2(dropOff, moving_detail_page.dropOffAtInputField);
        performActionOnElements.setValuesToFillFields("atp-3", "Remark auto test dropOff");
        performActionOnElements.fillCCFieldsElementTest(moving_detail_page.aptNumInputFieldDropOff, moving_detail_page.anyRemarksInputFieldDropOff, moving_detail_page.flightOfStairsPlusButtonDropOff,
                moving_detail_page.longCarryPlusButtonDropOff);
        Helper.click(moving_detail_page.dropOffElevatorYes);
        Helper.click(moving_detail_page.dropOffNeedShuttleYes);
        Helper.click(moving_detail_page.dropOffBuildingInsuranceYes);
        Helper.pause(2000);
        Helper.javascriptScrollDownThePage();
        Helper.navigateToElement(moving_detail_page.checkRatesButton);
        Helper.click(moving_detail_page.checkRatesButton);
        Helper.pause(2000);
//        String borderStyle = moving_detail_page.datePicker.getCssValue("border");
//        if(borderStyle.contains("#ff4f5d")){
//            moving_detail_page.datePicker.clear();
//            calendarClass.getRandomDate(moving_detail_page.datePicker, moving_detail_page.monthInDate);
//        }

        Helper.pause(4000);
    }

    @Test(dependsOnMethods = {"moving_Details_Page"})
    public void moving_Result_Page(){
        int ran =  new Random().nextInt(3);
        System.out.println("Random number is "+ran);
//        DropDownHelper.selectUsingIndex(moving_result_page.flexibilityDropDown2, ran);
        Helper.pause(3000);

        moving_result_page.myInventoryLink.isDisplayed();
        moving_result_page.myInventoryLink.isEnabled();
        Assert.assertEquals(moving_result_page.myInventoryLink.getAttribute("class"), "past");
        Assert.assertEquals(moving_result_page.myInventoryIcon.getAttribute("class"), "greenImg");
        moving_result_page.tripDetailsLink.isDisplayed();
        moving_result_page.tripDetailsLink.isEnabled();
        Assert.assertEquals(moving_result_page.tripDetailsLink.getAttribute("class"), "past");
        Assert.assertEquals(moving_result_page.tripDetailsIcon.getAttribute("class"), "greenImg");
        moving_result_page.myPricesLink.isDisplayed();
        Assert.assertEquals(moving_result_page.myPricesLink.getAttribute("class"), "active");
        Assert.assertEquals(moving_result_page.myPricesIcon.getAttribute("class"), "circle active");
        moving_result_page.confirmationLink.isDisplayed();
        Assert.assertEquals(moving_result_page.confirmationLink.getAttribute("class"), "future");
        Assert.assertEquals(moving_result_page.confirmationIcon.getAttribute("class"), "circle");
        moving_result_page.paymentLink.isDisplayed();
        Assert.assertEquals(moving_result_page.paymentLink.getAttribute("class"), "future");
        Assert.assertEquals(moving_result_page.paymentIcon.getAttribute("class"), "circle");
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
        moving_result_page.addressInPickUpBox.isDisplayed();
        moving_result_page.addressInDropOffBox.isDisplayed();
        moving_result_page.dateInDateBox.isDisplayed();
        moving_result_page.itemsInInventory.isDisplayed();
        moving_result_page.orderNumber.isDisplayed();
        saveOrderInfo.setOrderInfo(moving_result_page.labelInPickUpBox.getText(), moving_result_page.addressInPickUpBox.getText());
        saveOrderInfo.setOrderInfo(moving_result_page.labelInDropOffBox.getText(), moving_result_page.addressInDropOffBox.getText());
        saveOrderInfo.setOrderInfo(moving_result_page.labelInDateBox.getText(), moving_result_page.dateInDateBox.getText());
        saveOrderInfo.setOrderInfo(moving_result_page.labelInInventoryBox.getText(), moving_result_page.itemsInInventory.getText());
        saveOrderInfo.setOrderInfo(moving_result_page.orderNumberLabel.getText(), moving_result_page.orderNumber.getText());
        saveOrderInfo.setOrderInfo("CarrierName", moving_result_page.carrierName.getText());
        saveOrderInfo.setOrderInfo("OrderPrice", moving_result_page.orderPrice.getText());
        //
        moving_result_page.movingInfoText.isDisplayed();
        AssertThat.assertText("Price includes tax, tolls, fuel, mileage, disassembly/reassembly, loading/unloading, blankets wrapping, basic liability.\n" +
                "You may review added services before checkout. Prices not final until purchase is completed.", moving_result_page.movingInfoText);
        //
        moving_result_page.needHelpTitle.isDisplayed();
        AssertThat.assertText("Need Help?", moving_result_page.needHelpTitle);
        moving_result_page.callNowText.isDisplayed();
        AssertThat.assertText("Call Now", moving_result_page.callNowText);
        moving_result_page.scheduleMeetingText.isDisplayed();
        moving_result_page.scheduleMeetingText.isEnabled();
        AssertThat.assertText("Schedule a Meeting", moving_result_page.scheduleMeetingText);
        //
        moving_result_page.whyBookWithIMovingTitle.isDisplayed();
        AssertThat.assertText("Why Book with iMoving?", moving_result_page.whyBookWithIMovingTitle);
        moving_result_page.bindingPriceText.isDisplayed();
        AssertThat.assertText("Binding Price", moving_result_page.bindingPriceText);
        moving_result_page.inventoryControlText.isDisplayed();
        AssertThat.assertText("Inventory Control", moving_result_page.inventoryControlText);
        moving_result_page.securePaymentText.isDisplayed();
        AssertThat.assertText("Secure Payment", moving_result_page.securePaymentText);
        moving_result_page.priceMatchText.isDisplayed();
        AssertThat.assertText("Price Match", moving_result_page.priceMatchText);
        moving_result_page.customerSupportText.isDisplayed();
        AssertThat.assertText("Customer Support", moving_result_page.customerSupportText);
        //
        moving_result_page.bindingPriceTooltipIcon.isDisplayed();
        moving_result_page.bindingPriceTooltipIcon.isEnabled();
        Helper.navigateToElement(moving_result_page.bindingPriceTooltipIcon);
        Helper.waitForElementVisibilityOf(moving_result_page.bindingPriceTooltipContent);
        AssertThat.assertText( "Guaranteed price based on items and services", moving_result_page.bindingPriceTooltipContent);
        moving_result_page.customerSupportTooltipIcon.isDisplayed();
        moving_result_page.customerSupportTooltipIcon.isEnabled();
        Helper.navigateToElement(moving_result_page.customerSupportTooltipIcon);
        Helper.waitForElementVisibilityOf(moving_result_page.customerSupportTooltipContent);
        AssertThat.assertText( "Live agents available for anything you need", moving_result_page.customerSupportTooltipContent);
        moving_result_page.inventoryControlTooltipIcon.isDisplayed();
        moving_result_page.inventoryControlTooltipIcon.isEnabled();
        Helper.navigateToElement(moving_result_page.inventoryControlTooltipIcon);
        Helper.waitForElementVisibilityOf(moving_result_page.inventoryControlTooltipContent);
        AssertThat.assertText( "Control your price by adding / removing items and services", moving_result_page.inventoryControlTooltipContent);
        moving_result_page.priceMatchTooltipIcon.isDisplayed();
        moving_result_page.priceMatchTooltipIcon.isEnabled();
        Helper.navigateToElement(moving_result_page.priceMatchTooltipIcon);
        Helper.waitForElementVisibilityOf(moving_result_page.priceMatchTooltipContent);
        AssertThat.assertText( "Price match guarantee", moving_result_page.priceMatchTooltipContent);
        moving_result_page.securePaymentTooltipIcon.isDisplayed();
        moving_result_page.securePaymentTooltipIcon.isEnabled();
        Helper.navigateToElement(moving_result_page.securePaymentTooltipIcon);
        Helper.waitForElementVisibilityOf(moving_result_page.securePaymentTooltipContent);
        AssertThat.assertText( "Your personal and financial information is confidential", moving_result_page.securePaymentTooltipContent);
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
        Helper.navigateToElement(moving_result_page.selectButton);
        Helper.click(moving_result_page.selectButton);
    }

    @Test(dependsOnMethods = {"moving_Result_Page"})
    public void moving_Confirm_Page(){
        Helper.pause(2000);

        Assert.assertEquals(moving_confirm_page.addressInPickUpBox.getText(),saveOrderInfo.orderInfo.get(moving_confirm_page.labelInPickUpBox.getText()));
        Assert.assertEquals(moving_confirm_page.addressInDropOffBox.getText(),saveOrderInfo.orderInfo.get(moving_confirm_page.labelInDropOffBox.getText()));
        Assert.assertEquals(moving_confirm_page.dateInDateBox.getText().replaceAll("[.,]",""),saveOrderInfo.orderInfo.get(moving_confirm_page.labelInDateBox.getText()));
        Assert.assertEquals(moving_confirm_page.itemsInInventory.getText(),saveOrderInfo.orderInfo.get(moving_confirm_page.labelInInventoryBox.getText()));
        Assert.assertEquals(moving_confirm_page.orderNumber.getText(),saveOrderInfo.orderInfo.get(moving_confirm_page.orderNumberLabel.getText()));
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
        List<WebElement> listItems = moving_confirm_page.ulListOfElements.findElements(By.tagName("li"));

//        saveOrderInfo.setInventoryListInfo3(listItems);

        for (WebElement item : listItems) {
            String data = item.getText();
            String word = SaveOrderInfo.extractLabel(data);
            String number = SaveOrderInfo.extractValue(data);
            saveOrderInfo.setInventoryListInfo(word,number);
        }

//        System.out.println(saveOrderInfo.inventoryListInfo);
        browserHelper.newWindow();
        qaboOptionsTest.getOrderNumber(saveOrderInfo.orderInfo.get("Order #"));
        browserHelper.getWindowHandles();
        browserHelper.SwitchToWindow(1);
        qaboOptionsTest.loginToQaBO();
        qaboOptionsTest.openPriceInBO();
        getOrderInfo.comparePriceWebBo(saveOrderInfo.priceListBo, saveOrderInfo.inventoryListInfo);
//        browserHelper.SwitchToWindow(0);
        browserHelper.switchToParentWithChildClose();

        Helper.javascriptScrollIntoView(moving_confirm_page.checkOutButton);
        Helper.click(moving_confirm_page.checkOutButton);
    }


    @Test(dependsOnMethods = {"moving_Confirm_Page"})
    public void payment_Page(){
        Helper.pause(3000);
        getOrderInfo.getOrderInfoMulti(saveOrderInfo.inventoryListInfo);
        String price = String.valueOf(saveOrderInfo.inventoryListInfo.get("Total"));
        Assert.assertEquals(paymentPage.orderPrice.getText(), price.substring(1, price.length()-1));
//        String num1 = paymentPage.orderPrice.getText().replaceAll("[$,]", "");
//        String num2 = paymentPage.serviceFeePrice.getText();
//        System.out.println("num1 "+num1);
//        System.out.println("num2 "+num2);
//        Assert.assertEquals(paymentPage.serviceFeePrice.getText(), String.valueOf(Helper.roundingsFee(Helper.calculatePercent(paymentPage.orderPrice, 5))));
        double totalPrice = Double.parseDouble(paymentPage.orderPrice.getText().replaceAll("[$,]","")) + Double.parseDouble(paymentPage.serviceFeePrice.getText().replaceAll("[$,]",""));
        Assert.assertEquals(String.valueOf(Helper.roundingsFee(totalPrice)), paymentPage.totalPrice.getText().replaceAll("[$,]",""));

        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
        performActionOnElements.fillCCFieldsElementTest(paymentPage.signInButton, paymentPage.emailFieldLogin, paymentPage.passwordFieldLogin, paymentPage.loginButton);
        Helper.pause(2000);

        performActionOnElements.setValuesToFillFields("clientFirstName","5424 0000 0000 0015","123","2027");
        performActionOnElements.fillCCFieldsElementTest(paymentPage.newPaymentCard, paymentPage.cardNameInputField, paymentPage.cardNumberInputField,paymentPage.cardNumberInputField,
                paymentPage.cvvNumberInputField, paymentPage.expiryYearSelectField, paymentPage.billingAddressCheckBox);

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
        additionalPickUpTest.addAdditionalPickUpPayByCC();
        additionalPickUpTest.addAdditionalPickUpPayByCheck();
    }
}
