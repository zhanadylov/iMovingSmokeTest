package tests;

import helper.Helper;
import hooks.Hooks;
import hooks.TestStatusListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.*;

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
    public void createOrder(){
        selectRandom.selectRandomOptionFromDropDown(homePage.moveOptionList);
//        selectRandom.selectUsingVisibleText(homePage.moveOptionList,"My Storage");
//        selectRandom.selectUsingVisibleText(homePage.sizeOptionList,"200 CF Storage (5' x 5' x 8')");
//        Helper.pause(1000);
        selectRandom.selectRandomOptionFromDropDown(homePage.sizeOptionList);
        Helper.pause(1000);
        System.out.println("list is "+selectRandom.list);
        if(selectRandom.list.contains("My Storage")){
            orderStorage();
        }
        else{
            orderHouseApartment();
        }
//        Helper.click(homePage.compareQuotes);
        Helper.pause(3000);
    }

//    @Test(dependsOnMethods = {"createOrder"})
    public void orderHouseApartment(){
        Helper.click(homePage.compareQuotes);
        Helper.click(popUps.continueButton);
        Helper.click(popUps.xButtonSecond);
        Helper.click(popUps.okButtonThird);
        TestRandom.addRandomItemsToAllImages6(full_inventory.imageElement, 3);
        Helper.click(full_inventory.completeOrder);
        Helper.navigateToElement(boxCalculatingPopUp.addAndContinueButton);
        Helper.click(boxCalculatingPopUp.addAndContinueButton);
        if(boxCalculatingPopUp.skipButton.isDisplayed()){
            Helper.click(boxCalculatingPopUp.skipButton);
        }
        moving_Details_Page();
    }

//    @Test(dependsOnMethods = {"createOrder"})
    public void orderStorage(){
        Helper.click(homePage.compareQuotes);
        Helper.pause(2000);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine2, 10, 100);
//        storageOrder.selectRandomValueFromSlider(storage_full_inventory_page.sliderLine, 0, 100);
//        Helper.pause(2000);
        Helper.click(full_inventory.completeOrder);
        moving_Details_Page();
    }

//    @Test(dependsOnMethods = {"orderStorage","orderHouseApartment"})
    public void moving_Details_Page(){
        Helper.pause(3000);
//        calendarClass.selectRandomDate(driver, moving_detail_page.calendarButton, moving_detail_page.calendarList);

        Helper.click(moving_detail_page.pickUpInput);
        Helper.sendKeys(moving_detail_page.pickUpInput, "1234 Wilshire Boulevard, Los Angeles, CA, 90017");

        Helper.click(moving_detail_page.dropOffInput);
        Helper.sendKeys(moving_detail_page.dropOffInput, "12340 Boggy Creek Road, Orlando, FL, 32824");

//        Helper.pause(2000);
        Helper.navigateToElement(moving_detail_page.chooseMoversButton);
        Helper.click(moving_detail_page.chooseMoversButton);
        Helper.pause(3000);
        moving_Result_Page();
    }

//    @Test(dependsOnMethods = {"orderStorage","orderHouseApartment"})
    public void moving_Result_Page(){
        Helper.pause(3000);
        for (WebElement in : moving_result_page.moverNameAndPrice) {
            System.out.println(in.getText());
        }
    }

}
