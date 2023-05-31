package tests;

import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import hooks.TestStatusListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.*;
import ui.qabo.LoginPage;

import java.util.Random;
import java.util.Set;

@Listeners(TestStatusListener.class)
public class CreateOrder extends Hooks implements SetUp {
    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    PopUps popUps = new PopUps();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    Moving_Detail_Page moving_detail_page = new Moving_Detail_Page();
    Moving_Result_Page moving_result_page = new Moving_Result_Page();
    Moving_Confirm_Page moving_confirm_page = new Moving_Confirm_Page();
    CalendarClass calendarClass = new CalendarClass();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    PaymentPage paymentPage = new PaymentPage();
    LoginPage loginPage = new LoginPage();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();

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
        Helper.click(popUps.continueButton);
        Helper.click(popUps.xButtonSecond);
        Helper.click(popUps.okButtonThird);
        AddItemsMethod.addItems(full_inventory.imageElement, 3);
        Helper.click(full_inventory.completeOrder);
        Helper.navigateToElement(boxCalculatingPopUp.addAndContinueButton);
        Helper.click(boxCalculatingPopUp.addAndContinueButton);
        if(boxCalculatingPopUp.skipButton.isDisplayed()){
            Helper.click(boxCalculatingPopUp.skipButton);
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
        SetAddress.testMethod2(dropOff, moving_detail_page.dropOffAtInputField);
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
//        Helper.pause(3000);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.packingServicesCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.flexibilityCheckboxSideBar);
//        Helper.pause(1000);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckboxSideBar);
        Helper.pause(1000);
//        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckbox);
        int ran =  new Random().nextInt(3);
        System.out.println("Random number is "+ran);
        DropDownHelper.selectUsingIndex(moving_result_page.flexibilityDropDown2, ran);
        Helper.pause(3000);

            saveOrderInfo.setOrderInfo(moving_result_page.labelInPickUpBox.getText(), moving_result_page.addressInPickUpBox.getText());
            saveOrderInfo.setOrderInfo(moving_result_page.labelInDropOffBox.getText(), moving_result_page.addressInDropOffBox.getText());
            saveOrderInfo.setOrderInfo(moving_result_page.labelInDateBox.getText(), moving_result_page.dateInDateBox.getText());
            saveOrderInfo.setOrderInfo(moving_result_page.labelInInventoryBox.getText(), moving_result_page.itemsInInventory.getText());
            saveOrderInfo.setOrderInfo(moving_result_page.orderNumberLabel.getText(), moving_result_page.orderNumber.getText());
            saveOrderInfo.setOrderInfo("CarrierName", moving_result_page.carrierName.getText());
            saveOrderInfo.setOrderInfo("OrderPrice", moving_result_page.orderPrice.getText());

//        for (WebElement in : moving_result_page.moverNameAndPrice) {
//            System.out.println(in.getText());
//        }
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

//        WebElement listElement = driver.findElement(By.cssSelector("body > div > div > div > div.shuffle-animation > div > price-details > section > div > ul"));

        // Получение всех элементов li из списка
//        List<WebElement> listItems = listElement.findElements(By.tagName("li"));
//        List<WebElement> listItems = moving_confirm_page.ulListOfElements.findElements(By.tagName("li"));
//
////
//        for (WebElement listItem : listItems) {
//            String text = listItem.getText();
//            String word = text.replaceAll("[^a-zA-Z\\s-]", "").trim();
//            String number = text.replaceAll("[^\\d.,$]", "").trim();
//
//            saveOrderInfo.setInventoryListInfo(word, number);
////
////            System.out.println("Word: " + word + ", Number: " + number);
//        }
//        System.out.println(saveOrderInfo.inventoryListInfo);
        browserHelper.newWindow();
        qaboOptionsTest.getOrderNumber(saveOrderInfo.orderInfo.get("Order #"));
        browserHelper.getWindowHandles();
        browserHelper.SwitchToWindow(1);
        qaboOptionsTest.loginToQaBO();
        qaboOptionsTest.checkPriceInBO();

        Helper.javascriptScrollIntoView(moving_confirm_page.checkOutButton);
        Helper.click(moving_confirm_page.checkOutButton);
    }


    @Test(dependsOnMethods = {"moving_Confirm_Page"})
    public void payment_Page(){
        Helper.pause(3000);
//        Assert.assertEquals(paymentPage.orderPrice.getText(), saveOrderInfo.inventoryListInfo.get(paymentPage.totalPriceLabel.getText()));
//        Assert.assertEquals(paymentPage.serviceFeePrice.getText(), String.valueOf(Helper.roundingsFee(Helper.calculatePercent(paymentPage.orderPrice, 5))));
//        double totalPrice = Double.parseDouble(paymentPage.orderPrice.getText() + paymentPage.serviceFeePrice.getText());
//        Assert.assertEquals(String.valueOf(totalPrice), paymentPage.totalPrice.getText());

        paymentPage.signIn("shirley.orn@gmail.com", "Sj9QjDXR");
        Helper.pause(2000);
        Helper.javascriptScrollIntoView(paymentPage.newPaymentCard);
        Helper.click(paymentPage.newPaymentCard);
        Helper.sendKeys(paymentPage.cardNameInputField, "clientFirstName");
        Helper.javascriptScrollIntoView(paymentPage.cardNumberInputField);
        Helper.sendKeys(paymentPage.cardNumberInputField, "5424 0000 0000 0015");
        Helper.sendKeys(paymentPage.cvvNumberInputField, "123");
        DropDownHelper.selectUsingVisibleText(paymentPage.expiryYearSelectField, "2027");
        Helper.pause(3000);
        Helper.javascriptScrollIntoView(paymentPage.billingAddressCheckBox);
        Helper.javascriptClick(paymentPage.billingAddressCheckBox);
        Helper.pause(3000);

        Helper.javascriptScrollDownThePage();
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
    }
}
