package tests;

import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.methods.SetUp;
import ui.pageObjectModel.FooterLinksPages;

public class FooterLinksMenuTest extends Hooks implements SetUp{

    FooterLinksPages footerLinksPages = new FooterLinksPages();

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
}
