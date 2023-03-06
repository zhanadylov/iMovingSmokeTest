package tests;

import helper.Helper;
import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.*;

import java.util.List;

public class CreateOrder extends Hooks implements SetUp {
    HomePage homePage = new HomePage();
    SelectRandom selectRandom = new SelectRandom();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    PopUps popUps = new PopUps();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    TestRandom testRandom = new TestRandom();
    Storage_Full_Inventory_Page storage_full_inventory_page = new Storage_Full_Inventory_Page();
    StorageOrder storageOrder = new StorageOrder();
    Moving_Detail_Page moving_detail_page = new Moving_Detail_Page();
    Moving_Result_Page moving_result_page = new Moving_Result_Page();

    @Test
    public void createOrder(){
        selectRandom.getOptionFromDropDown(homePage.moveOptionList);
//        selectRandom.selectUsingVisibleText(homePage.moveOptionList,"My Storage");
//        selectRandom.selectUsingVisibleText(homePage.sizeOptionList,"200 CF Storage (5' x 5' x 8')");
//        Helper.pause(1000);
        selectRandom.getOptionFromDropDown(homePage.sizeOptionList);
        Helper.pause(1000);
        if(selectRandom.list.contains("What are You moving?") || selectRandom.list.contains("Move Size")){
            selectRandom.getOptionFromDropDown(homePage.moveOptionList);
            selectRandom.getOptionFromDropDown(homePage.sizeOptionList);
        }else if(selectRandom.list.contains("My Storage")){
            orderStorage();
        }
        else{
            orderHouseApartment();
        }
//        Helper.click(homePage.compareQuotes);

        Helper.pause(3000);
    }

    @Test(testName = "HouseApartment")
    public void orderHouseApartment(){
        Helper.click(homePage.compareQuotes);
//        Helper.click(popUps.continueButton);
//        Helper.click(popUps.xButtonSecond);
//        Helper.click(popUps.okButtonThird);
        System.out.println("house type ");
    }

    @Test(testName = "Storage")
    public void orderStorage(){
        Helper.click(homePage.compareQuotes);
        Helper.pause(2000);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine2, 10, 100);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine, 0, 100);
//        Helper.pause(2000);
        Helper.click(full_inventory.completeOrder);
        moving_Details_Page();
    }

    @Test
    public void moving_Details_Page(){
        Helper.pause(3000);
        Helper.click(moving_detail_page.pickUpInput);
        Helper.sendKeys(moving_detail_page.pickUpInput, "1234 Wilshire Boulevard, Los Angeles, CA, 90017");
        Helper.click(moving_detail_page.approveButton);
        Helper.click(moving_detail_page.dropOffInput);
        Helper.sendKeys(moving_detail_page.dropOffInput, "12340 Boggy Creek Road, Orlando, FL, 32824");
        Helper.click(moving_detail_page.approveButton2);
        Helper.pause(2000);
        Helper.click(moving_detail_page.confirmButton);
        Helper.pause(2000);
        Helper.navigateToElement(moving_detail_page.chooseMoversButton);
        Helper.click(moving_detail_page.chooseMoversButton);
        moving_Result_Page();
    }

    @Test
    public void moving_Result_Page(){
        Helper.pause(3000);
        for (WebElement in : moving_result_page.moverNameAndPrice) {
            System.out.println(in.getText());
        }
    }

}
