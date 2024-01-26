package tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.*;
import org.example.ui.methods.*;
import org.example.ui.pageObjectModel.*;
import org.example.ui.qabo.LoginPage;
import org.example.utilities.ChromeWebDriver;
import org.example.utilities.ConfigReader;
import org.example.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.ui.backOfficeTest.QaboOptionsTest;

import java.util.Random;

public class FooterLinksTest extends BaseTest{
//    private static WebDriver driver = ChromeWebDriver.loadChromeDriver();
    private static final Logger logger = LogManager.getLogger(FooterLinksTest.class);

    FooterLinksPages footerLinksPages = new FooterLinksPages();
    Cost_Calculating_Page cost_calculating_page = new Cost_Calculating_Page();
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    CalendarClass calendarClass = new CalendarClass();
    PaymentPage paymentPage = new PaymentPage();
    Local_Moving_Page local_moving_page = new Local_Moving_Page();
    SelectRandom selectRandom = new SelectRandom();
    Success_Page success_page = new Success_Page();
    BrowserHelper browserHelper = new BrowserHelper();
    QaboOptionsTest qaboOptionsTest = new QaboOptionsTest();
    HomePage homePage = new HomePage();
    Random random = new Random();
    static LoginPage loginPage = new LoginPage();
    AlertHelper alertHelper = new AlertHelper(driver);


    public FooterLinksTest(){
        super("environment");
    }

    @Test
    public void footerMenuTest() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(3000);
        Helper.javascriptScrollIntoView(footerLinksPages.aboutUsLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.aboutUsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/about-us/");
        footerLinksPages.aboutUsTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.aboutUsTitle.getText(), "We’re changing the way people think about moving");
        Helper.javascriptScrollDownThePage();
        Helper.javascriptScrollIntoView(footerLinksPages.moversJoinUsLink);
        Helper.javascriptClick(footerLinksPages.moversJoinUsLink);
        footerLinksPages.subTitleInContactUs.isDisplayed();
        Assert.assertEquals(footerLinksPages.subTitleInContactUs.getText(), "We would love to hear from you!");
        Helper.javascriptScrollIntoView(footerLinksPages.sendMessageButton);
        Helper.click(footerLinksPages.sendMessageButton);
        footerLinksPages.redRequiredreCaptchaMessage.isDisplayed();
        Assert.assertEquals(footerLinksPages.errorCaptchaMessage.getText(), "Please pass captcha");
        Helper.javascriptScrollIntoView(footerLinksPages.customerSupportLink);
        Helper.click(footerLinksPages.customerSupportLink);
        footerLinksPages.contactUsTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.contactUsTitle.getText(), "Contact Us");
        footerLinksPages.nameFieldContactUs.isDisplayed();
        footerLinksPages.nameFieldContactUs.isEnabled();
        footerLinksPages.emailFieldContactUs.isDisplayed();
        footerLinksPages.emailFieldContactUs.isEnabled();
        footerLinksPages.phoneNumberContactUs.isDisplayed();
        footerLinksPages.phoneNumberContactUs.isEnabled();
        footerLinksPages.issuesFieldContactUs.isDisplayed();
        footerLinksPages.issuesFieldContactUs.isEnabled();
        footerLinksPages.yourMessageContactUs.isDisplayed();
        footerLinksPages.yourMessageContactUs.isEnabled();
        footerLinksPages.faqTab.isDisplayed();
    }

    //Booking order with new user, one new CC
    @Test
    public void footerCostCalculatorTest() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.movingCostCalculatorLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.movingCostCalculatorLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/moving-cost-calculator/");
        cost_calculating_page.titleInCalculatingPage.isDisplayed();
        Assert.assertEquals(cost_calculating_page.titleInCalculatingPage.getText(), "Moving Cost Calculator");
        DropDownHelper.chooseMoveFrom(driver, "quickQuote", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "quickQuote", random.nextInt(5));
        footerLinksPages.continueButton.isDisplayed();
        footerLinksPages.continueButton.isEnabled();
        Helper.pause(2000);
        Helper.click(homePage.itemizedQuoteButtonHomePage);
        DropDownHelper.chooseMoveFrom(driver, "addInventory", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "addInventory", random.nextInt(5));
        footerLinksPages.addItemsButton.isDisplayed();
        footerLinksPages.addItemsButton.isEnabled();
        Helper.javascriptScrollIntoView(cost_calculating_page.dontMakeAnyCallsTitle);
        cost_calculating_page.dontMakeAnyCallsTitle.isDisplayed();
        Assert.assertTrue(cost_calculating_page.dontMakeAnyCallsTitle.getText().contains("Don’t make any calls. Get multiple quotes and book online with iMoving.com"));
        Helper.click(cost_calculating_page.videoButton);
        cost_calculating_page.xButtonInVideoPopup.isDisplayed();
        Helper.click(cost_calculating_page.xButtonInVideoPopup);
        Helper.javascriptScrollIntoView(cost_calculating_page.howMuchWillCostMoveTitle);
        cost_calculating_page.howMuchWillCostMoveTitle.isDisplayed();
//        Assert.assertEquals(cost_calculating_page.howMuchWillCostMoveTitle.getText(), "How Much Will it Cost to Move?");
        Helper.javascriptScrollIntoView(cost_calculating_page.factorsAffectMovingCostsTitle);
        cost_calculating_page.factorsAffectMovingCostsTitle.isDisplayed();
        Assert.assertEquals(cost_calculating_page.factorsAffectMovingCostsTitle.getText(), "Factors Affecting Moving Costs");
        Helper.javascriptScrollIntoView(cost_calculating_page.howSaveMoneyTitle);
        cost_calculating_page.howSaveMoneyTitle.isDisplayed();
        Assert.assertEquals(cost_calculating_page.howSaveMoneyTitle.getText(), "How to Save Money During Your Move");
    }

    //Booking order with exist user and paying with two exists CC
    @Test
    public void footerLocalPageTest() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.localMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.localMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/local-moving-companies/");
        AssertThat.assertText("Local Moving", local_moving_page.mainTitleText);
        local_moving_page.textUnderTitle.isDisplayed();
        DropDownHelper.chooseMoveFrom(driver, "quickQuote", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "quickQuote", random.nextInt(5));
        footerLinksPages.continueButton.isDisplayed();
        footerLinksPages.continueButton.isEnabled();
        Helper.pause(2000);
        Helper.click(homePage.itemizedQuoteButtonHomePage);
        DropDownHelper.chooseMoveFrom(driver, "addInventory", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "addInventory", random.nextInt(5));
        footerLinksPages.addItemsButton.isDisplayed();
        footerLinksPages.addItemsButton.isEnabled();
        Helper.javascriptScrollIntoView(local_moving_page.connectWithTopLocalMoversTitle);
        AssertThat.assertText("Connect with Top-Tier Local Movers", local_moving_page.connectWithTopLocalMoversTitle);
        Helper.javascriptScrollIntoView(local_moving_page.easilyBookLocalMoveTitle);
        AssertThat.assertText("Easily Book Your Local Move with iMoving", local_moving_page.easilyBookLocalMoveTitle);
        Helper.javascriptScrollIntoView(local_moving_page.faqTitle);
        AssertThat.assertText("Local Moving FAQ", local_moving_page.faqTitle);
        local_moving_page.howMuchLMCost.isDisplayed();
        Assert.assertTrue(local_moving_page.howMuchLMCostDataText.isDisplayed());
        Helper.click(local_moving_page.howMuchLMCost);
        local_moving_page.whatDifferentLMandLD.isDisplayed();
        Helper.click(local_moving_page.whatDifferentLMandLD);
        local_moving_page.whatDifferentLMandLDdataText.isDisplayed();
        local_moving_page.myMoversTransport.isDisplayed();
        Helper.click(local_moving_page.myMoversTransport);
        local_moving_page.myMoversTransportDataText.isDisplayed();
        local_moving_page.cheapestWayToMove.isDisplayed();
        Helper.click(local_moving_page.cheapestWayToMove);
        local_moving_page.cheapestWayToMoveDataText.isDisplayed();
        local_moving_page.whenShouldBookLM.isDisplayed();
        Helper.click(local_moving_page.whenShouldBookLM);
        local_moving_page.whenShouldBookLMDataText.isDisplayed();
    }

    @Test
    public void footerCrossCountryPage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.crossCountryMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.crossCountryMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/cross-country-moving-companies/");
        footerLinksPages.crossCountryMovingTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.crossCountryMovingTitle.getText(), "The Best Cross Country Movers");
        DropDownHelper.chooseMoveFrom(driver, "quickQuote", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "quickQuote", random.nextInt(5));
        footerLinksPages.continueButton.isDisplayed();
        footerLinksPages.continueButton.isEnabled();
        Helper.pause(2000);
//        Helper.javascriptScrollIntoView(homePage.itemizedQuoteButtonHomePage);
        Helper.click(homePage.itemizedQuoteButtonHomePage);
        DropDownHelper.chooseMoveFrom(driver, "addInventory", random.nextInt(3));
        DropDownHelper.chooseMoveSize(driver, "addInventory", random.nextInt(5));
        footerLinksPages.addItemsButton.isDisplayed();
        footerLinksPages.addItemsButton.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.iMovingMakesBookingSimpleTitle);
        footerLinksPages.iMovingMakesBookingSimpleTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.iMovingMakesBookingSimpleTitle.getText(), "iMoving Makes Booking Simple");
        Helper.javascriptScrollIntoView(footerLinksPages.topRatedCrossCountryMoversTitle);
        footerLinksPages.topRatedCrossCountryMoversTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.topRatedCrossCountryMoversTitle.getText(), "Top Rated Cross Country Movers");
        Helper.javascriptScrollIntoView(footerLinksPages.coastToCoastChooseiMovingTitle);
        footerLinksPages.coastToCoastChooseiMovingTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.coastToCoastChooseiMovingTitle.getText(), "Coast to Coast? Choose iMoving");
        Helper.javascriptScrollIntoView(footerLinksPages.faqTitleCross);
        footerLinksPages.faqTitleCross.isDisplayed();
    }

    @Test
    public void footerLaborPage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.bestMovingLaborCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.bestMovingLaborCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/best-moving-labor-companies/");
        footerLinksPages.laborTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.laborTitle.getText(), "Best Moving Labor Companies");
        footerLinksPages.textUnderTitleLabor.isDisplayed();
        footerLinksPages.moveAddressLabor.isDisplayed();
        footerLinksPages.moveAddressLabor.isEnabled();
        footerLinksPages.moveDatePickerLabor.isDisplayed();
        footerLinksPages.moveDatePickerLabor.isEnabled();
        footerLinksPages.getLaborButtonLabor.isDisplayed();
        footerLinksPages.getLaborButtonLabor.isEnabled();
        footerLinksPages.movingButtonOnLabor.isEnabled();
        Helper.click(footerLinksPages.movingButtonOnLabor);
        footerLinksPages.whatAreYouMovingTitle.isDisplayed();
        footerLinksPages.moveHouseTypeLabor.isDisplayed();
        footerLinksPages.moveHouseTypeLabor.isEnabled();
        footerLinksPages.moveApartmentTypeLabor.isDisplayed();
        footerLinksPages.moveApartmentTypeLabor.isEnabled();
        footerLinksPages.moveStorageTypeLabor.isDisplayed();
        footerLinksPages.moveStorageTypeLabor.isEnabled();
        Helper.click(footerLinksPages.moveStorageTypeLabor);
        footerLinksPages.moveOptionLaborLabor.isDisplayed();
        footerLinksPages.moveOptionLaborLabor.isEnabled();
        footerLinksPages.compareQuotesButtonLabor.isEnabled();
        footerLinksPages.compareQuotesButtonLabor.isEnabled();
    }

    @Test
    public void footerCaliforniaStatePage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.moversInCaliforniaLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.moversInCaliforniaLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/california-movers/");
        footerLinksPages.californiaTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.californiaTitle.getText(), "California carriers");
        footerLinksPages.topCarrierTitle.isDisplayed();
        footerLinksPages.topCarrierTitle.isEnabled();
        footerLinksPages.compareOffersTitle.isDisplayed();
        footerLinksPages.moveHouseTypeCal.isDisplayed();
        footerLinksPages.moveHouseTypeCal.isEnabled();
        footerLinksPages.moveApartmentTypeCal.isDisplayed();
        footerLinksPages.moveApartmentTypeCal.isEnabled();
        Helper.click(footerLinksPages.moveApartmentTypeCal);
        footerLinksPages.moveStorageTypeCal.isDisplayed();
        footerLinksPages.moveStorageTypeCal.isEnabled();
        footerLinksPages.getPreciseButtonCal.isDisplayed();
        footerLinksPages.getPreciseButtonCal.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.sanFranciscoLinkFromList);
        footerLinksPages.sanFranciscoLinkFromList.isDisplayed();
        Helper.click(footerLinksPages.sanFranciscoLinkFromList);
        footerLinksPages.sanFranciscoTitle.isDisplayed();
        footerLinksPages.totalListTitleSanFrancisco.isDisplayed();
    }

    @Test
    public void footerNewYorkStatePage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.newYorkStateMoversLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.newYorkStateMoversLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/new-york-movers/");
        footerLinksPages.newYorkTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.newYorkTitle.getText(), "New York carriers");
        footerLinksPages.topCarrierTitleNY.isDisplayed();
        footerLinksPages.topCarrierTitleNY.isEnabled();
        footerLinksPages.compareOffersTitleNY.isDisplayed();
        footerLinksPages.moveHouseTypeNY.isDisplayed();
        footerLinksPages.moveHouseTypeNY.isEnabled();
        footerLinksPages.moveApartmentTypeNY.isDisplayed();
        footerLinksPages.moveApartmentTypeNY.isEnabled();
        footerLinksPages.moveStorageTypeNY.isDisplayed();
        footerLinksPages.moveStorageTypeNY.isEnabled();
        Helper.click(footerLinksPages.moveStorageTypeNY);
        footerLinksPages.getPreciseButtonNY.isDisplayed();
        footerLinksPages.getPreciseButtonNY.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.brooklynLinkFromList);
        footerLinksPages.brooklynLinkFromList.isDisplayed();
        Helper.click(footerLinksPages.brooklynLinkFromList);
        footerLinksPages.brooklynTitle.isDisplayed();
        footerLinksPages.totalListTitleBrooklyn.isDisplayed();
    }

    @Test
    public void footerChicagoCityPage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.chicagoMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.chicagoMovingCompaniesLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/illinois-movers/chicago/");
        footerLinksPages.chicagoTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.chicagoTitle.getText(), "Chicago movers");
        footerLinksPages.compareQuotesButtonChicago.isDisplayed();
        Helper.click(footerLinksPages.compareQuotesButtonChicago);
        selectRandom.selectRandomOptionFromDropDown(footerLinksPages.moveOptionMiami);
        selectRandom.selectRandomOptionFromDropDown(footerLinksPages.moveSizeMiami);
        footerLinksPages.totalCarrierChicago.isDisplayed();
        footerLinksPages.totalCarrierChicago.isEnabled();
        Helper.javascriptScrollIntoView(footerLinksPages.moreDetailsButton);
        Helper.click(footerLinksPages.moreDetailsButton);
        footerLinksPages.moverNameText.isDisplayed();
        footerLinksPages.moversInfo.isDisplayed();
        footerLinksPages.ratingAndReview.isDisplayed();
        footerLinksPages.ratingAndReview.isEnabled();
        footerLinksPages.aboutUs.isDisplayed();
        footerLinksPages.aboutUs.isEnabled();

    }

    @Test
    public void footerSeeMoreMoversCityPage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.seeMoreMoversLinkCity);
        Helper.pause(1000);
        Helper.click(footerLinksPages.seeMoreMoversLinkCity);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/moving-companies/");
        footerLinksPages.ourCarriersTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.ourCarriersTitle.getText(), "Our Nationwide Network of Movers");
        Helper.javascriptScrollIntoView(footerLinksPages.moversScreenedText);
        footerLinksPages.moversScreenedText.isDisplayed();
        Assert.assertEquals(footerLinksPages.moversScreenedText.getText(), "Movers are Screened and Handpicked by Us");
        footerLinksPages.communityStandardsText.isDisplayed();
        footerLinksPages.communityStandardsText.isEnabled();
        Helper.click(footerLinksPages.communityStandardsText);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.imoving.com/imoving-standards/");
        footerLinksPages.trustAndTransparencyTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.trustAndTransparencyTitle.getText(), "Trust & Transparency");
        browserHelper.goBack(driver);
        Helper.javascriptScrollIntoView(footerLinksPages.lookForOurMoversByState);
        footerLinksPages.lookForOurMoversByState.isDisplayed();
        Assert.assertEquals(footerLinksPages.lookForOurMoversByState.getText(), "Look for our movers by state:");
        selectRandom.randomRadioSelectionFromForm(footerLinksPages.stateList);
        footerLinksPages.chosenStateTitle.isDisplayed();
        browserHelper.goBack(driver);
        Helper.javascriptScrollIntoView(footerLinksPages.howDoWeRateOurMovers);
        footerLinksPages.howDoWeRateOurMovers.isDisplayed();
        Assert.assertEquals(footerLinksPages.howDoWeRateOurMovers.getText(), "How Do We Rate Our Movers");
        Helper.javascriptScrollIntoView(footerLinksPages.servicesAndHandling);
        footerLinksPages.servicesAndHandling.isDisplayed();
        Assert.assertEquals(footerLinksPages.servicesAndHandling.getText(), "Services & Handling");
        selectRandom.randomRadioSelectionFromForm(footerLinksPages.servicesHandlingList);
        footerLinksPages.chosenServicesTitle.isDisplayed();
        browserHelper.goBack(driver);
        Helper.javascriptScrollIntoView(footerLinksPages.areYouAMoverText);
        footerLinksPages.areYouAMoverText.isDisplayed();
        Assert.assertEquals(footerLinksPages.areYouAMoverText.getText(), "Are you a Mover?\nJoin Our Network!");
        footerLinksPages.joinNowButton.isDisplayed();
        footerLinksPages.joinNowButton.isEnabled();
        Helper.click(footerLinksPages.joinNowButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/register-suppliers/");
        browserHelper.goBack(driver);
        Helper.javascriptScrollIntoView(footerLinksPages.movingFAQ);
        footerLinksPages.movingFAQ.isDisplayed();
        Assert.assertEquals(footerLinksPages.movingFAQ.getText(), "Moving FAQ");
    }

    @Test
    public void footerInterstatePage() {
        Helper.javascriptScrollDownThePage();
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(footerLinksPages.interstateMovingCompaniesLink);
        Helper.pause(1000);
        Helper.click(footerLinksPages.interstateMovingCompaniesLink);
        Helper.pause(2000);
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

    @Test
    public void footerBoxesPage() {
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

    @Test
    public void footerLonDistancePage() {
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

    @Test
    public void footerMovingPediaTest() {
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
