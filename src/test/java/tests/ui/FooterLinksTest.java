package tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.*;
import org.example.helper.*;
import org.example.hooks.Hooks;
import org.example.ui.methods.CalendarClass;
import org.example.ui.methods.PerformActionOnElements;
import org.example.ui.methods.SelectRandom;
import org.example.ui.methods.SetAddress;
import org.example.ui.pageObjectModel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.ui.backOfficeTest.QaboOptionsTest;
import org.example.utilities.ConfigReader;
import org.example.utilities.Driver;

public class FooterLinksTest{
    private static WebDriver driver = Driver.getDriver();
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


    @BeforeClass
    public void setUp(){
            if (driver == null) {
                logger.info("Trying to open browser and url in footer class");
                driver = Driver.getDriver();
                driver.get(ConfigReader.getProperty("environment"));
            }else{
                driver.get(ConfigReader.getProperty("environment"));
            }
    }

    @Test
    public void footerMenuTest() {
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
        footerLinksPages.contactUsTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.contactUsTitle.getText(), "Contact Us");
        footerLinksPages.WeWouldLoveToHearFromYouTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.WeWouldLoveToHearFromYouTitle.getText(), "We would love to hear from you!");
        Helper.javascriptScrollIntoView(footerLinksPages.sendButton);
        Helper.click(footerLinksPages.sendButton);
        footerLinksPages.errorCaptchaMessage.isDisplayed();
        Assert.assertEquals(footerLinksPages.errorCaptchaMessage.getText(), "Please pass captcha");
        footerLinksPages.faqTab.isDisplayed();
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
        selectRandom.randomRadioSelectionFromForm(cost_calculating_page.listOfCarriers);
        Helper.click(cost_calculating_page.bookNowButton);
        AssertThat.assertText("Your Move Details", cost_calculating_page.yourMoveDetailsTitle);
        cost_calculating_page.textUnderdetails.isDisplayed();
        Helper.click(cost_calculating_page.checkboxOnText);
        Helper.click(cost_calculating_page.confirmButton);
        Helper.pause(1000);
        paymentPage.secureBookingText.isDisplayed();
        performActionOnElements.setValuesToFillFields(JavaFaker.fakeFirstName(), JavaFaker.fakeLastName(), JavaFaker.fakePhone(), JavaFaker.fakeFirstName(),
                "2223 0000 1030 9703", "2027", "123");
        performActionOnElements.fillCCFieldsElementTest(paymentPage.fistNameInputField, paymentPage.lastNameInputField, paymentPage.phoneInputField,
                paymentPage.cardNameInputField, paymentPage.cardNumberInputField, paymentPage.cardNumberInputField,
                paymentPage.expiryYearSelectField, paymentPage.cvvNumberInputField, paymentPage.billingAddressCheckBox);
        DropDownHelper.selectUsingVisibleText(paymentPage.expiryMonthSelectField, "May");
        Helper.javascriptScrollIntoView(paymentPage.emailInputField);
        Helper.sendKeys(paymentPage.emailInputField, JavaFaker.fakeEmail());
        Helper.javascriptScrollDownThePage();
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
        success_page.thankYouText.isDisplayed();
        success_page.customerName.isDisplayed();
        AssertThat.assertText("Thank You", success_page.thankYouText);
        AssertThat.assertText(success_page.text, success_page.textInSuccessPage);
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
        AssertThat.assertText("Find Local movers near you, Compare and Book Online", local_moving_page.mainTitleText);
        local_moving_page.textUnderTitle.isDisplayed();
        local_moving_page.startHereText.isDisplayed();
        AssertThat.assertText("Start here :", local_moving_page.startHereText);
        SetAddress.testMethod("12334 Cantura Street, Los Angeles, CA, USA, 91604", local_moving_page.firstInputField);
        Helper.click(local_moving_page.nextButton);
        local_moving_page.oneMoreText.isDisplayed();
        AssertThat.assertText("One more :", local_moving_page.oneMoreText);
        SetAddress.testMethod("12340 Boggy Creek Road, Orlando, FL, USA, 32824", local_moving_page.secondInputField);
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
        selectRandom.randomRadioSelectionFromForm(local_moving_page.listOfLDAndBlvdCarriers);
        Helper.click(local_moving_page.bookNowButton);
        performActionOnElements.setValuesToFillFields("qatestimoving@gmail.com", "QATest-2022");
        performActionOnElements.fillCCFieldsElementTest(local_moving_page.signInButton, local_moving_page.loginEmailField, local_moving_page.loginPasswordField, local_moving_page.loginButton);
        local_moving_page.userProfile.isDisplayed();
        driver.switchTo().newWindow(WindowType.TAB);
        Helper.pause(2000);
        qaboOptionsTest.loginToQaBO();
        if (qaboOptionsTest.endOfMonthFee()) {
            browserHelper.switchToParentWindow(driver);
            Helper.navigateToElement(local_moving_page.backArrowButton);
            Helper.click(local_moving_page.backArrowButton);
             AssertThat.assertText("Choose Your Carrier and book online", local_moving_page.chooseYourCarrierBookOnlineTitle);
            selectRandom.randomRadioSelectionFromForm(local_moving_page.listOfLDAndBlvdCarriers);
            Helper.click(local_moving_page.bookNowButton);
        }
        browserHelper.switchToParentWindow(driver);
        Helper.click(local_moving_page.checkboxUnderDetails);
        Helper.click(local_moving_page.confirmPayButton);
        Helper.waitForElementVisibilityOf(paymentPage.splitPaymentWithASecondCardButton);
        Helper.click(paymentPage.splitPaymentWithASecondCardButton);
        Helper.waitForElementVisibilityOf(paymentPage.firstCardPayment);
        Helper.multipleClick(paymentPage.firstCardPayment, 2);
        Helper.pause(1000);
        Helper.javascriptScrollIntoView(paymentPage.secondCardPayment);
        Helper.multipleClick(paymentPage.secondCardPayment, 2);
        double dividableSum = Double.parseDouble(paymentPage.totalPrice.getText().replaceAll("[$ ,]", ""));
        Helper.sendKeys(paymentPage.amountOfSplitSecond, String.valueOf(Helper.divideSum(dividableSum)).replaceAll("[$ ,]", ""));
        Helper.javascriptScrollIntoView(paymentPage.completeBookingButton);
        Helper.click(paymentPage.completeBookingButton);
        Helper.pause(3000);
        Helper.waitForElementVisibilityOf(success_page.thankYouText);
        success_page.thankYouText.isDisplayed();
        success_page.customerName.isDisplayed();
        success_page.textInSuccessPage.isDisplayed();
        browserHelper.SwitchToWindow(1, driver);
        qaboOptionsTest.changeCarrierProcess();
        browserHelper.switchToParentWithChildClose(driver);
        Helper.click(homePage.userNameAfterLogin);
        Helper.click(homePage.logOut);
    }

    @Test
    public void footerChecklistPage() {
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

    @Test
    public void footerCrossCountryPage() {
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
