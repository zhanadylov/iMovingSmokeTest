package tests;

import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import hooks.TestStatusListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.*;

import java.util.Random;

@Listeners(TestStatusListener.class)
public class CreateOrder extends Hooks implements SetUp {
    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    PopUps popUps = new PopUps();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    Moving_Detail_Page moving_detail_page = new Moving_Detail_Page();
    Moving_Result_Page moving_result_page = new Moving_Result_Page();
    CalendarClass calendarClass = new CalendarClass();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();

    @Test
    public void chooseMoveOption() throws InterruptedException {
        selectRandom.selectRandomOptionFromDropDown(homePage.moveOptionList);
        selectRandom.selectRandomOptionFromDropDown(homePage.sizeOptionList);
        Helper.pause(1000);
        System.out.println("list is "+selectRandom.list);
        if(selectRandom.list.contains("My Storage")){
            orderStorage();
        }
        else{
            orderHouseApartment();
        }
        Helper.pause(3000);
    }

//    @Test(dependsOnMethods = {"createOrder"})
    public void orderHouseApartment() throws InterruptedException {
        Helper.click(homePage.compareQuotes);
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
        moving_Details_Page();
    }

//    @Test(dependsOnMethods = {"createOrder"})
    public void orderStorage() throws InterruptedException {
        Helper.click(homePage.compareQuotes);
        Helper.pause(2000);
        // Both slider clicker works
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine2, 10, 100);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine, 0, 100);
//        Helper.pause(2000);
        Helper.click(full_inventory.completeOrder);
        moving_Details_Page();
    }

    @Test
    public void moving_Details_Page() throws InterruptedException {
        Helper.pause(2000);
        calendarClass.getDate(moving_detail_page.datePicker, moving_detail_page.monthInDate);

///////////////
//        Helper.click(moving_detail_page.datePicker);
//        WebElement tdButton = moving_detail_page.datePicker.findElement(By.xpath("//td[text()='9']"));
//        Helper.click(tdButton);
        //////////////////
        Helper.pause(2000);
        String pickUp = "1234 Wilshire Boulevard, Los Angeles, CA, 90017";
        String dropOff = "12340 Boggy Creek Road, Orlando, FL, 32824";
        SetAddress.testMethod(pickUp, moving_detail_page.pickUpInput);
        SetAddress.testMethod2(dropOff, moving_detail_page.dropOffInput);
        Helper.pause(2000);
        Helper.javascriptScrollDownThePage();
//        Helper.javascriptScrollIntoView(moving_detail_page.checkRatesButton);
        Helper.navigateToElement(moving_detail_page.checkRatesButton);
        Helper.click(moving_detail_page.checkRatesButton);
        Helper.pause(2000);
        moving_Result_Page();
        Helper.pause(4000);
    }

    @Test(dependsOnMethods = {"moving_Details_Page"})
    public void moving_Result_Page(){
        Helper.pause(3000);
        selectRandom.clickOnRandomCheckBox(moving_result_page.packingServicesCheckboxSideBar);
        Helper.pause(1000);
        selectRandom.clickOnRandomCheckBox(moving_result_page.flexibilityCheckboxSideBar);
        Helper.pause(1000);
        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckboxSideBar);
        Helper.pause(1000);
        selectRandom.clickOnRandomCheckBox(moving_result_page.deliveryWindowCheckbox);
        int ran =  new Random().nextInt(3);
        DropDownHelper.selectUsingIndex(moving_result_page.flexibilityDropDown2, ran);
        for (WebElement in : moving_result_page.moverNameAndPrice) {
            System.out.println(in.getText());
        }
    }

}
