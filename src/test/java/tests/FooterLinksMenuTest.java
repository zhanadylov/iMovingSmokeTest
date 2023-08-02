package tests;

import helper.Helper;
import hooks.Hooks;
import hooks.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.methods.CalendarClass;
import ui.methods.PerformActionOnElements;
import ui.methods.SetAddress;
import ui.methods.SetUp;
import ui.pageObjectModel.Cost_Calculating_Page;
import ui.pageObjectModel.FooterLinksPages;

public class FooterLinksMenuTest extends Hooks implements SetUp{

    FooterLinksPages footerLinksPages = new FooterLinksPages();
    Cost_Calculating_Page cost_calculating_page = new Cost_Calculating_Page();
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    CalendarClass calendarClass = new CalendarClass();
    SetAddress setAddress = new SetAddress();

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
        Helper.click(cost_calculating_page.moveSizeOption);
        Helper.click(cost_calculating_page.additionalServicesElevator);
        Helper.click(cost_calculating_page.additionalServicesShuttle);
        Helper.click(cost_calculating_page.showCostEstimationButton);
        Helper.pause(1000);
        cost_calculating_page.yourCostForaTitle.isDisplayed();
        Assert.assertTrue(cost_calculating_page.yourCostForaTitle.getText().contains("Your Cost for a"));
        cost_calculating_page.priceBoxShouldDisplayed.isDisplayed();
        cost_calculating_page.textUnderPrice.isDisplayed();
        Assert.assertTrue(cost_calculating_page.textUnderPrice.getText().contains("This estimate is based on your home size."));
        Helper.click(cost_calculating_page.continueButton);
        Helper.pause(1000);

    }
}
