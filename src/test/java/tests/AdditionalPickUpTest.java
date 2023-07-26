package tests;

import helper.AlertHelper;
import helper.AssertThat;
import helper.BrowserHelper;
import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.backOfficeTest.QaboOptionsTest;
import ui.methods.*;
import ui.pageObjectModel.*;

public class AdditionalPickUpTest extends Hooks implements SetUp {

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
    BrowserHelper browserHelper = new BrowserHelper(driver);
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();
    GetOrderInfo getOrderInfo = new GetOrderInfo();
    AlertHelper alertHelper = new AlertHelper(driver);

    @Test
    public void addAdditionalPickUpPayByCC(){
//        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
//        performActionOnElements.fillCCFieldsElementTest(homePage.SignInButton,homePage.inputEmail, homePage.inputPassword, homePage.loginButtonInSignIn);
        Helper.pause(2000);
//        alertHelper.AcceptAlert();
        browserHelper.refresh();
        homePage.userNameAfterLogin.isDisplayed();
        Helper.click(homePage.userNameAfterLogin);
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
        full_inventory_page.roomNameText.isDisplayed();
        Helper.click(full_inventory_page.editRoomsButton);
        full_inventory_page.theseAreRecommendedRoomsForaText.isDisplayed();
        full_inventory_page.pleaseAddRemoveAndConfirmText.isDisplayed();
        full_inventory_page.addAdditionalPickupLocationLink.isDisplayed();
        Helper.click(full_inventory_page.addAdditionalPickupLocationLink);
        full_inventory_page.additionalStorage.isDisplayed();
        full_inventory_page.additionalBoxes.isDisplayed();
        full_inventory_page.additionalItems.isDisplayed();
        Helper.click(full_inventory_page.additionalItems);
        Helper.click(full_inventory_page.continueButtonPopup);
        popUpsTest.passPopInSlashOne();
        full_inventory_page.additionalItemsRoomHeader.isDisplayed();
        Helper.click(full_inventory_page.additionalItemsRoomHeader);
        AddItemsMethod.addItems(full_inventory_page.imageElement, 10);
        Helper.click(full_inventory_page.completeOrder);

        Helper.clickButtonIfDisplayed(boxCalculatingPopUp.addAndContinueButton);
        Helper.clickButtonIfDisplayed(boxCalculatingPopUp.skipButton);
        Helper.pause(2000);
        String dropOff = "1245 Wilshire Boulevard, Los Angeles, CA, 90017";
        SetAddress.testMethod2(dropOff, _detail_page.dropOffAtInputField);
        Helper.javascriptScrollIntoView(_detail_page.confirmButton);
        Helper.click(_detail_page.confirmButton);
        Helper.javascriptScrollIntoView(summary_page.checkOutButton);
        Helper.click(summary_page.checkOutButton);
        Helper.click(paymentPage.cCRadioButton);
        Helper.pause(2000);
        Helper.javascriptScrollIntoView(paymentPage.completeBookingButton);
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(2000);
    }

    @Test
    public void addAdditionalPickUpPayByCheck(){
//        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
//        performActionOnElements.fillCCFieldsElementTest(homePage.SignInButton,homePage.inputEmail, homePage.inputPassword, homePage.loginButtonInSignIn);
        Helper.pause(2000);
        browserHelper.refresh();
        homePage.userNameAfterLogin.isDisplayed();
        Helper.click(homePage.userNameAfterLogin);
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
        full_inventory_page.roomNameText.isDisplayed();
        Helper.click(full_inventory_page.editRoomsButton);
        full_inventory_page.theseAreRecommendedRoomsForaText.isDisplayed();
        full_inventory_page.pleaseAddRemoveAndConfirmText.isDisplayed();
        full_inventory_page.addAdditionalPickupLocationLink.isDisplayed();
        full_inventory_page.additionalStorage.isDisplayed();
        full_inventory_page.additionalBoxes.isDisplayed();
        full_inventory_page.additionalItems.isDisplayed();
        Helper.click(full_inventory_page.additionalBoxes);
        Helper.click(full_inventory_page.continueButtonPopup);
        popUpsTest.passPopInSlashOne();
        full_inventory_page.additionalBoxesRoomHeader.isDisplayed();
        Helper.click(full_inventory_page.additionalBoxesRoomHeader);
        boxCalculatingPopUp.additionalPickupBoxesTitle.isDisplayed();
        Helper.click(boxCalculatingPopUp.largeBoxPlusButton);
        AssertThat.assertText("1", boxCalculatingPopUp.largeBoxQuantity);
        Helper.multipleClick(boxCalculatingPopUp.lampBoxPlusButton, 5);
        AssertThat.assertText("5", boxCalculatingPopUp.lampBoxQuantity);
        Helper.click(boxCalculatingPopUp.tvBoxPlusButton);
        AssertThat.assertText("1", boxCalculatingPopUp.tvBoxQuantity);
        Helper.click(full_inventory_page.completeOrder);
        Helper.clickButtonIfDisplayed(boxCalculatingPopUp.addAndContinueButton);
        Helper.clickButtonIfDisplayed(boxCalculatingPopUp.skipButton);
//        if(boxCalculatingPopUp.addAndContinueButton.isDisplayed()){
//            Helper.click(boxCalculatingPopUp.addAndContinueButton);
//        }
//        if(boxCalculatingPopUp.skipButton.isDisplayed()){
//            Helper.click(boxCalculatingPopUp.skipButton);
//        }else{
//            System.out.println("Skip button not displayed");
//        }
        String dropOff = "1245 Wilshire Boulevard, Los Angeles, CA, 90017";
        SetAddress.testMethod2(dropOff, _detail_page.dropOffAtInputField);
        Helper.javascriptScrollIntoView(_detail_page.confirmButton);
        Helper.click(_detail_page.confirmButton);
        browserHelper.newWindow();
        qaboOptionsTest.getOrderNumber(summary_page.orderNumber.getText());
        browserHelper.getWindowHandles();
        browserHelper.SwitchToWindow(1);
        qaboOptionsTest.loginToQaBO();
        qaboOptionsTest.openPriceInBO();
        getOrderInfo.comparePriceWebBo(saveOrderInfo.priceListBo, saveOrderInfo.inventoryListInfo);
        qaboOptionsTest.financeTabPayByCheck();
    }

}
