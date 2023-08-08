package tests;

import helper.AssertThat;
import helper.Helper;
import helper.JavaFaker;
import hooks.Hooks;
import hooks.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.Cost_Calculating_Page;
import ui.pageObjectModel.FooterLinksPages;
import ui.pageObjectModel.Local_Moving_Page;
import ui.pageObjectModel.PaymentPage;

import java.util.List;
import java.util.Random;

public class FooterLinksMenuTest extends Hooks implements SetUp{

    FooterLinksPages footerLinksPages = new FooterLinksPages();
    Cost_Calculating_Page cost_calculating_page = new Cost_Calculating_Page();
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    CalendarClass calendarClass = new CalendarClass();
    SetAddress setAddress = new SetAddress();
    PaymentPage paymentPage = new PaymentPage();
    JavaFaker javaFaker = new JavaFaker();
    Local_Moving_Page local_moving_page = new Local_Moving_Page();
    SelectRandom selectRandom = new SelectRandom();
    @Log
    @Test
    public void footerMenuTest(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.aboutUsLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.aboutUsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/about-us/");
        footerLinksPages.iMovingInaNutshellTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.iMovingInaNutshellTitle.getText(), "iMoving in a Nutshell");
        Helper.javascriptScrollDownThePage();
        Helper.javascriptScrollIntoView(footerLinksPages.moversJoinUsLink);
        Helper.click(footerLinksPages.moversJoinUsLink);
        footerLinksPages.joiniMovingNetworkTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.joiniMovingNetworkTitle.getText(), "Join iMoving Network!");
        Helper.javascriptScrollIntoView(footerLinksPages.submitButton);
        Helper.click(footerLinksPages.submitButton);
        footerLinksPages.redRequiredreCaptchaMessage.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.customerSupportLink);
        Helper.click(footerLinksPages.customerSupportLink);
        footerLinksPages.letsKeepInTouchTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.letsKeepInTouchTitle.getText(), "Lets keep in touch!");
        footerLinksPages.WeWouldLoveToHearFromYouTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.WeWouldLoveToHearFromYouTitle.getText(), "We would love to hear from you");
        Helper.click(footerLinksPages.sendButton);
        Helper.click(footerLinksPages.faqTab);
        footerLinksPages.generalTitle.isDisplayed();
        footerLinksPages.generalTitle.isEnabled();
        footerLinksPages.howDoesItWorkTitle.isDisplayed();
        footerLinksPages.howDoesItWorkTitle.isEnabled();
        footerLinksPages.ourMoversTitle.isDisplayed();
        footerLinksPages.ourMoversTitle.isEnabled();
        footerLinksPages.bookingYourMoveTitle.isDisplayed();
        footerLinksPages.bookingYourMoveTitle.isEnabled();
        footerLinksPages.onceYourMoveIsBookedTitle.isDisplayed();
        footerLinksPages.onceYourMoveIsBookedTitle.isEnabled();
        footerLinksPages.postMoveTitle.isDisplayed();
        footerLinksPages.postMoveTitle.isEnabled();
        footerLinksPages.billingTitle.isDisplayed();
        footerLinksPages.billingTitle.isEnabled();
    }

    @Log
    @Test
    public void footerMovingPediaTest(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.movingPediaLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.movingPediaLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/blog");
        footerLinksPages.theiMovingBlogTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.theiMovingBlogTitle.getText(), "The iMoving Blog");
        footerLinksPages.movingTipsHeader.isDisplayed();
        Assert.assertEquals(footerLinksPages.movingTipsHeader.getText(), "Moving Tips");
        footerLinksPages.howToHeader.isDisplayed();
        Assert.assertEquals(footerLinksPages.howToHeader.getText(), "How To");
        footerLinksPages.beforeYourMoveHeader.isDisplayed();
        Assert.assertEquals(footerLinksPages.beforeYourMoveHeader.getText(), "Before Your Move");
        footerLinksPages.afterYourMoveHeader.isDisplayed();
        Assert.assertEquals(footerLinksPages.afterYourMoveHeader.getText(), "After Your Move");
        footerLinksPages.checklistsHeader.isDisplayed();
        Assert.assertEquals(footerLinksPages.checklistsHeader.getText(), "Checklists");
        footerLinksPages.inputSearchField.isDisplayed();
        Helper.click(footerLinksPages.movingTipsHeader);
        footerLinksPages.movingTipsTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.movingTipsTitle.getText(), "Moving tips");
        Helper.click(footerLinksPages.afterYourMoveHeader);
        footerLinksPages.afterYourMoveTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.afterYourMoveTitle.getText(), "After your move");
    }

    //TODO Not choose Carrier
    @Log
    @Test
    public void footerCostCalculatorTest(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.movingCostCalculatorLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.movingCostCalculatorLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/moving-cost-calculator/");
        cost_calculating_page.titleInCalculatingPage.isDisplayed();
        Assert.assertEquals(cost_calculating_page.titleInCalculatingPage.getText(), "Moving Cost Calculator - get your quote in 5 Clicks");
        SetAddress.testMethod("12334 Cantura Street, Los Angeles, CA, USA, 91604", cost_calculating_page.pickUpInputField);
        SetAddress.testMethod("12340 Boggy Creek Road, Orlando, FL, USA, 32824", cost_calculating_page.dropOffInputField);
        calendarClass.getGivenDate(cost_calculating_page.calendarIcon);
        selectRandom.randomRadioSelectionFromForm(cost_calculating_page.moveSizeOptions);
        selectRandom.randomRadioSelectionFromForm(cost_calculating_page.additionalServicesOptions);
        Helper.click(cost_calculating_page.showCostEstimationButton);
        Helper.pause(1000);
        cost_calculating_page.yourCostForaTitle.isDisplayed();
//        Assert.assertTrue(cost_calculating_page.yourCostForaTitle.getText().contains("Your Cost for a"));
        cost_calculating_page.priceBoxShouldDisplayed.isDisplayed();
        cost_calculating_page.textUnderPrice.isDisplayed();
        Assert.assertTrue(cost_calculating_page.textUnderPrice.getText().contains("This estimate is based on your home size."));
        Helper.click(cost_calculating_page.continueButton);
        Helper.pause(1000);
        AssertThat.assertText("Choose Your Carrier and Book Online", cost_calculating_page.chooseYourCarrierTitle);
        Helper.pause(2000);
            if (Helper.isElementPresent(cost_calculating_page.chooseCarrier)) {
                Helper.click(cost_calculating_page.chooseCarrier);
//                Helper.click(cost_calculating_page.chooseCarrier);
                Helper.click(cost_calculating_page.bookNowButton);
            }else
            {
                Helper.click(cost_calculating_page.leftArrowButton);
                Helper.click(cost_calculating_page.continueButton);
                Helper.click(cost_calculating_page.chooseCarrier);
                Helper.click(cost_calculating_page.bookNowButton);
            }
            AssertThat.assertText("Your Move Details", cost_calculating_page.yourMoveDetailsTitle);
            Assert.assertTrue(cost_calculating_page.textUnderdetails.getText().contains("Inventory is limited to the  CF size of Move and  number of items and as described in the process. Please make sure you ordered the right size. Additional inventory will not be delivered"));
            Helper.click(cost_calculating_page.checkboxOnText);
            Helper.click(cost_calculating_page.confirmButton);
            Helper.pause(1000);
            paymentPage.secureBookingText.isDisplayed();
            performActionOnElements.setValuesToFillFields(JavaFaker.fakeFirstName(), JavaFaker.fakeLastName(), JavaFaker.fakePhone(),
                    JavaFaker.fakeLogin(), "2223000010309703", "May", "2027", "123");
            performActionOnElements.fillCCFieldsElementTest(paymentPage.newPaymentCard, paymentPage.cardNameInputField, paymentPage.cardNumberInputField,paymentPage.cardNumberInputField,
                    paymentPage.expiryMonthSelectField, paymentPage.expiryYearSelectField,paymentPage.cvvNumberInputField, paymentPage.billingAddressCheckBox);

            Helper.javascriptScrollDownThePage();
            Helper.click(paymentPage.completeBookingButton);
            Helper.pause(3000);
        }

    //TODO Not choose CC on Split payment.
    @Log
    @Test
    public void footerLocalPageTest(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.localMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.localMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/local-moving-companies/");
        AssertThat.assertText("Find Local movers near you, Compare and Book Online", local_moving_page.mainTitleText);
        local_moving_page.textUnderTitle.isDisplayed();
        local_moving_page.startHereText.isDisplayed();
        AssertThat.assertText("Start here :", local_moving_page.startHereText);
        SetAddress.testMethod("12334 Cantura Street, Los Angeles, CA, USA, 91604",local_moving_page.firstInputField);
        Helper.click(local_moving_page.nextButton);
        local_moving_page.oneMoreText.isDisplayed();
        AssertThat.assertText("One more :", local_moving_page.oneMoreText);
        SetAddress.testMethod("1245 Wilshire Boulevard, Los Angeles, CA, USA, 90017",local_moving_page.secondInputField);
        Helper.click(local_moving_page.secondNextButton);
        local_moving_page.chooseCarrierText.isDisplayed();
        AssertThat.assertText("Choose 3 carriers and compare their quotes", local_moving_page.chooseCarrierText);
        local_moving_page.air1MoverName.isDisplayed();
        Helper.click(local_moving_page.air1MoverName);
        local_moving_page.air1MoverName.isSelected();
        Helper.click(local_moving_page.ldMovingName);
        local_moving_page.ldMovingName.isSelected();
        Helper.click(local_moving_page.blvdMoverName);
        local_moving_page.blvdMoverName.isSelected();
        Helper.click(local_moving_page.compareQuotesButton);
        local_moving_page.whenAreYouMovingTitle.isDisplayed();
        AssertThat.assertText("When Are You Moving?", local_moving_page.whenAreYouMovingTitle);
        calendarClass.getGivenDate(local_moving_page.datePicker);
        Helper.click(local_moving_page.fourthNextStep);
        local_moving_page.whatIsYourMoveSizeTitle.isDisplayed();
        AssertThat.assertText("What is your move size?", local_moving_page.whatIsYourMoveSizeTitle);
        selectRandom.randomRadioSelectionFromForm(local_moving_page.listOfSize);
        Helper.click(local_moving_page.fivesNextButton);
        local_moving_page.doYouNeedAdditionalTitle.isDisplayed();
        AssertThat.assertText("Do you need additional Moving Services?", local_moving_page.doYouNeedAdditionalTitle);
        selectRandom.randomRadioSelectionFromForm(local_moving_page.listOfAdditionalServices);
        Helper.click(local_moving_page.sixNextButton);
        local_moving_page.chooseYourCarrierBookOnlineTitle.isDisplayed();
        AssertThat.assertText("Choose Your Carrier and book online", local_moving_page.chooseYourCarrierBookOnlineTitle);
        selectRandom.randomRadioSelectionFromForm(local_moving_page.listOfThreeCarrier);
        Helper.click(local_moving_page.bookNowButton);
        performActionOnElements.setValuesToFillFields("qatestimoving@gmail.com","QATest-2022");
        performActionOnElements.fillCCFieldsElementTest(local_moving_page.signInButton, local_moving_page.loginEmailField, local_moving_page.loginPasswordField, local_moving_page.loginButton);
        local_moving_page.userProfile.isDisplayed();
        Helper.click(local_moving_page.checkboxUnderDetails);
        Helper.click(local_moving_page.confirmPayButton);
        Helper.waitForElementVisibilityOf(paymentPage.splitPaymentWithASecondCardButton);
        Helper.click(paymentPage.splitPaymentWithASecondCardButton);
        Helper.waitForElementVisibilityOf(paymentPage.firstCardPayment);
        Helper.navigateToElement(paymentPage.firstCardPayment);
        Helper.javascriptScrollIntoView(paymentPage.firstCardPayment);
        Helper.click(paymentPage.firstCardPayment);
        Helper.pause(1000);
        Helper.navigateToElement(paymentPage.firstCardPayment);
        Helper.javascriptScrollIntoView(paymentPage.secondCardPayment);
        Helper.click(paymentPage.secondCardPayment);
        double dividableSum = Double.parseDouble(paymentPage.totalPrice.getText());
        Helper.sendKeys(paymentPage.amountOfSplitSecond, String.valueOf(Helper.divideSum(dividableSum)));
        Helper.javascriptScrollIntoView(paymentPage.completeBookingButton);
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
    }

    @Log
    @Test
    public void footerChecklistPage(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.movingChecklistLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.movingChecklistLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/moving-checklist/");
        footerLinksPages.movingChecklistTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.movingChecklistTitle.getText(), "Moving Checklist");
        footerLinksPages.textUnderTitle.isDisplayed();
        footerLinksPages.downloadChecklistButton.isDisplayed();
        footerLinksPages.customizedChecklistButton.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.checklistOf2021);
        footerLinksPages.checklistOf2021.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.checklistForSixWeek);
        footerLinksPages.checklistForSixWeek.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.dayBeforeMove);
        footerLinksPages.dayBeforeMove.isDisplayed();
    }

    @Log
    @Test
    public void footerInterstatePage(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.interstateMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.interstateMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/interstate-moving-companies/");
        footerLinksPages.interstateTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.interstateTitle.getText(), "Interstate moving companies");
        footerLinksPages.moveOptionSelector.isDisplayed();
        footerLinksPages.moveOptionSelector.isEnabled();
        footerLinksPages.moveSizeSelector.isDisplayed();
        footerLinksPages.moveSizeSelector.isEnabled();
        footerLinksPages.compareQuotesButton.isDisplayed();
        footerLinksPages.compareQuotesButton.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.bestInterstateTitle);
        footerLinksPages.bestInterstateTitle.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.servicesOfferedByInterstateTitle);
        footerLinksPages.servicesOfferedByInterstateTitle.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.faqTitle);
        footerLinksPages.faqTitle.isDisplayed();
    }

    @Log
    @Test
    public void footerCrossCountryPage(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.crossCountryMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.crossCountryMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/cross-country-moving-companies/");
        footerLinksPages.crossCountryMoving.isDisplayed();
        Assert.assertEquals(footerLinksPages.crossCountryMoving.getText(), "Cross Country Moving Companies");
        footerLinksPages.moveOptionSelectorCross.isDisplayed();
        footerLinksPages.moveOptionSelectorCross.isEnabled();
        footerLinksPages.moveSizeSelectorCross.isDisplayed();
        footerLinksPages.moveSizeSelectorCross.isEnabled();
        footerLinksPages.compareQuotesButtonCross.isDisplayed();
        footerLinksPages.compareQuotesButtonCross.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.ourCrossCountryTitle);
        footerLinksPages.ourCrossCountryTitle.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.obtainMovingEstimateTitle);
        footerLinksPages.obtainMovingEstimateTitle.isDisplayed();
        Helper.javascriptScrollIntoView(footerLinksPages.faqTitleCross);
        footerLinksPages.faqTitleCross.isDisplayed();
    }

    @Log
    @Test
    public void footerBoxesPage(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.movingBoxesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.movingBoxesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/moving-boxes/");
        footerLinksPages.boxesMoving.isDisplayed();
        Assert.assertEquals(footerLinksPages.boxesMoving.getText(), "Moving Boxes");
        footerLinksPages.moveOptionSelectorBoxes.isDisplayed();
        footerLinksPages.moveOptionSelectorBoxes.isEnabled();
        footerLinksPages.moveSizeSelectorBoxes.isDisplayed();
        footerLinksPages.moveSizeSelectorBoxes.isEnabled();
        footerLinksPages.compareQuotesButtonBoxes.isDisplayed();
        footerLinksPages.compareQuotesButtonBoxes.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.boxesUpcomingTitle);
        footerLinksPages.boxesUpcomingTitle.isDisplayed();
    }

    @Log
    @Test
    public void footerLonDistancePage(){
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.longDistanceMovingLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.longDistanceMovingLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/long-distance-moving/");
        footerLinksPages.longDistanceTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.longDistanceTitle.getText(), "Long Distance Movers");
        footerLinksPages.moveOptionSelectorLong.isDisplayed();
        footerLinksPages.moveOptionSelectorLong.isEnabled();
        footerLinksPages.moveSizeSelectorLong.isDisplayed();
        footerLinksPages.moveSizeSelectorLong.isEnabled();
        footerLinksPages.compareQuotesButtonLong.isDisplayed();
        footerLinksPages.compareQuotesButtonLong.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.bestLongDistanceTitle);
        footerLinksPages.bestLongDistanceTitle.isDisplayed();
    }

}
