package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

import java.util.List;

public class FooterLinksPages {
    public FooterLinksPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Menu
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > h6")
    public WebElement menuTitle;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1) > a")
    @FindBy(xpath = "//*[@id=\"index\"]/footer/div/div[1]/div[1]/ul/li[1]/a")
    public WebElement aboutUsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(2) > a")
    public WebElement ourMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(3) > a")
    public WebElement movingServicesLink;
    @FindBy(css = "#index > div > footer > div > div > div.firstFooterColumn > ul > li:nth-child(4) > a")
    public WebElement moversJoinUsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(5) > a")
    public WebElement iMovingStandardsLink;
    @FindBy(css = "#index > div > footer > div.container.newDesign > div:nth-child(1) > ul > li:nth-child(6) > a")
    public WebElement customerSupportLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(7) > a")
    public WebElement termsAndConditionsLink;
//    @FindBy(xpath = "//ul[@class='list-unstyled']//a[contains(text(),'MovingPedia')]")
    @FindBy(xpath = "//a[contains(text(),'MovingPedia')]")
    public WebElement movingPediaLink;

    //Usefull links
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > h6")
    public WebElement usefullLinksTitle;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(1) > a")
    public WebElement movingCostCalculatorLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(2) > a")
    public WebElement movingChecklistLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(3) > a")
    public WebElement localMovingCompaniesLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(4) > a")
    @FindBy(xpath = "//a[contains(text(),'Interstate moving companies')]")
    public WebElement interstateMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(5) > a")
    public WebElement crossCountryMovingCompaniesLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(6) > a")
    @FindBy(xpath = "//a[contains(text(),'Moving Boxes')]")
    public WebElement movingBoxesLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(7) > a")
    @FindBy(xpath = "//a[contains(text(),'Long Distance Moving')]")
    public WebElement longDistanceMovingLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(8) > a")
    public WebElement bestMovingLaborCompaniesLink;

    //Carriers by State
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > h6")
    public WebElement carriersByState;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(1) > a")
    @FindBy(xpath = "//a[contains(text(),'Movers in California')]")
    public WebElement moversInCaliforniaLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(2) > a")
    public WebElement floridaMoversLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(3) > a")
    @FindBy(xpath = "//a[contains(text(),'New York state Movers')]")
    public WebElement newYorkStateMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(4) > a")
    public WebElement texasMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(5) > a")
    public WebElement llinoisMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(6) > a")
    public WebElement seeMoreMoversLink;

    //Carriers by City
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > h6")
    public WebElement carriersByCity;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(1) > a")
    public WebElement losAngelesMoversLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(2) > a")
    @FindBy(xpath = "//a[contains(text(),'Chicago Movers')]")
    public WebElement chicagoMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(3) > a")
    public WebElement nYCMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(4) > a")
    public WebElement houstonMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(5) > a")
    public WebElement chicagoMoversLink;
//    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(6) > a")
    @FindBy(xpath = "(//a[contains(text(),'See more Movers...')])[2]")
    public WebElement seeMoreMoversLinkCity;

    //About Us
    @FindBy(css = "#index > div > main > article > div > div.about-paragraph.col-sm-12.rteSection > h1 > strong")
    public WebElement iMovingInaNutshellTitle;

    //Join Us
    @FindBy(css = "#index > div > main > div > section.header-section.how-to-header > figure > h1")
    public WebElement joiniMovingNetworkTitle;
    @FindBy(xpath = "//*[@id=\"sendForm\"]")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"captcha_error\"]")
    public WebElement redRequiredreCaptchaMessage;
    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    public WebElement reCaptchaCheckbox;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div/section[2]/div/form/div[2]/div[2]/div[4]/fieldset/span")
    public WebElement redRequiredFieldsMessage;

    //Customer support
    @FindBy(css = "#index > main > section.section-hero > div > h1")
    public WebElement contactUsTitle;
    @FindBy(css = "#index > main > section.section-hero > div > p")
    public WebElement WeWouldLoveToHearFromYouTitle;

    @FindBy(css = "#index > main > section.section-faq > div > h3")
    public WebElement faqTab;
    @FindBy(xpath = "//*[@id=\"Name\"]")
    public WebElement nameFieldContactUs;
    @FindBy(xpath = "//*[@id=\"Email\"]")
    public WebElement emailFieldContactUs;
    @FindBy(xpath = "//*[@id=\"mobile-mask\"]")
    public WebElement phoneNumberContactUs;
    @FindBy(xpath = "//*[@id=\"SelectedIssue\"]")
    public WebElement issuesFieldContactUs;
    @FindBy(xpath = "//*[@id=\"Message\"]")
    public WebElement yourMessageContactUs;
    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
    public WebElement reCaptchaCheckboxContactUs;
    @FindBy(xpath = "//*[@id=\"sendForm\"]")
    public WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"captcha_error\"]")
    public WebElement errorCaptchaMessage;
    @FindBy(xpath = "/html/body/div[1]/main/section[2]/div/div/form/div/fieldset[3]/span")
    public WebElement errorFieldMessage;

    //Moving Pedia
    @FindBy(css = "body > div.blog.other > h1")
    public WebElement theiMovingBlogTitle;
    @FindBy(css = "body > div.blog.other > div:nth-child(1) > div > div > a:nth-child(1)")
    public WebElement movingTipsHeader;
    @FindBy(css = "body > div.blog.other > h1")
    public WebElement movingTipsTitle;
    @FindBy(css = "body > div.blog.other > div:nth-child(1) > div > div > a:nth-child(2)")
    public WebElement howToHeader;
    @FindBy(css = "body > div.blog.other > div:nth-child(1) > div > div > a:nth-child(3)")
    public WebElement beforeYourMoveHeader;
    @FindBy(css = "body > div.blog.other > div:nth-child(1) > div > div > a:nth-child(4)")
    public WebElement afterYourMoveHeader;
    @FindBy(css = "body > div.blog.other > h1")
    public WebElement afterYourMoveTitle;
    @FindBy(css = "body > div.blog.other > div:nth-child(1) > div > div > a:nth-child(5)")
    public WebElement checklistsHeader;
    @FindBy(css = "#input-search > div > input")
    public WebElement inputSearchField;

    //Moving Checklist
    @FindBy(css = "#index > main > div > section.sectionHero > div > div > div.col-lg-8.col-md-8.col-sm-7.col-xs-12 > h1")
    public WebElement movingChecklistTitle;
    @FindBy(css = "#index > main > div > section.sectionHero > div > div > div.col-lg-8.col-md-8.col-sm-7.col-xs-12 > p")
    public WebElement textUnderTitle;
    @FindBy(css = "#btnDownloadCL")
    public WebElement downloadChecklistButton;
    @FindBy(css = "#btnCreateCL")
    public WebElement customizedChecklistButton;
    @FindBy(css = "#index > main > div > section:nth-child(2) > div > div > div > h3")
    public WebElement checklistOf2021;
    @FindBy(css = "#\\36 Weeks > div:nth-child(1) > div > div > h3")
    public WebElement checklistForSixWeek;
    @FindBy(css = "#\\31 Day > div:nth-child(1) > div > div > h3")
    public WebElement dayBeforeMove;

    //Moving Interstate
    @FindBy(css = "#index > div > main > div > section.header-section.discount-header > figure > div.main-title")
    public WebElement interstateTitle;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[1]/div/button")
    public WebElement moveOptionSelector;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[2]/div/button")
    public WebElement moveSizeSelector;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[3]/button")
    public WebElement compareQuotesButton;
    @FindBy(css = "#ppElement1 > h1")
    public WebElement bestInterstateTitle;
    @FindBy(css = "#ppElement6 > h2")
    public WebElement servicesOfferedByInterstateTitle;
    @FindBy(css = "#ppElement8 > h2")
    public WebElement faqTitle;

    //Moving Cross Country
    @FindBy(css = "#index > div > main > div > section.header-section.discount-header > figure > div.main-title")
    public WebElement crossCountryMoving;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[1]/div/button")
    public WebElement moveOptionSelectorCross;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[2]/div/button")
    public WebElement moveSizeSelectorCross;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[3]/button")
    public WebElement compareQuotesButtonCross;
    @FindBy(css = "#ppElement1 > h1")
    public WebElement ourCrossCountryTitle;
    @FindBy(css = "#ppElement4 > h2")
    public WebElement obtainMovingEstimateTitle;
    @FindBy(css = "#ppElement7 > h2")
    public WebElement faqTitleCross;

    //Moving boxes
    @FindBy(css = "#index > div > main > div > section.header-section.discount-header > figure > div.main-title")
    public WebElement boxesMoving;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[1]/div/button")
    public WebElement moveOptionSelectorBoxes;
    @FindBy(xpath = "(//*[@id=\"roomsForm\"]/div[2]/div/button)[1]")
    public WebElement moveSizeSelectorBoxes;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[3]/button")
    public WebElement compareQuotesButtonBoxes;
    @FindBy(css = "#ppElement1 > h1")
    public WebElement boxesUpcomingTitle;

    //Moving Long Distance
    @FindBy(css = "#index > div > main > div > section.header-section.discount-header > figure > div.main-title")
    public WebElement longDistanceTitle;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[1]/div/button")
    public WebElement moveOptionSelectorLong;
    @FindBy(xpath = "(//*[@id=\"roomsForm\"]/div[2]/div/button)[1]")
    public WebElement moveSizeSelectorLong;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[3]/button")
    public WebElement compareQuotesButtonLong;
    @FindBy(css = "#ppElement1 > h1")
    public WebElement bestLongDistanceTitle;

    //Moving Labor Companies
    @FindBy(css = "#index > div > main > div > section.headerSection > div.container-fluid > div > div.col-lg-7.col-xs-12 > h1")
    public WebElement laborTitle;
    @FindBy(css = "#index > div > main > div > section.headerSection > div.container-fluid > div > div.col-lg-7.col-xs-12 > div")
    public WebElement textUnderTitleLabor;
    @FindBy(xpath = "(//*[@id=\"movingFrom\"])[1]")
    public WebElement moveAddressLabor;
    @FindBy(xpath = "(//*[@id=\"sendPhonePhone\"])[1]")
    public WebElement moveDatePickerLabor;
    @FindBy(xpath = "//*[@id=\"tab_2\"]/div[4]/button")
    public WebElement getLaborButtonLabor;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div/section[2]/div[2]/div/div[2]/div/div[1]/ul/li[1]/a")
    public WebElement movingButtonOnLabor;
    @FindBy(xpath = "//*[@id=\"tab_1\"]/div/h4")
    public WebElement whatAreYouMovingTitle;
    @FindBy(xpath = "//*[@id=\"roomsForm3\"]/div[1]/div[1]")
    public WebElement moveHouseTypeLabor;
    @FindBy(xpath = "//*[@id=\"roomsForm3\"]/div[1]/div[2]")
    public WebElement moveApartmentTypeLabor;
    @FindBy(xpath = "//*[@id=\"roomsForm3\"]/div[1]/div[3]")
    public WebElement moveStorageTypeLabor;
    @FindBy(xpath = "//*[@id=\"roomsForm3\"]/div[2]/div/button")
    public WebElement moveOptionLaborLabor;
    @FindBy(xpath = "//*[@id=\"roomsForm3\"]/div[3]/button")
    public WebElement compareQuotesButtonLabor;

    //California in state
    @FindBy(css = "#index > div > main > section > figure > div")
    public WebElement californiaTitle;
    @FindBy(css = "#index > div > main > div.row.container-fluid.rteSection.stateMovers > div:nth-child(1) > section > div > div.branchesData.TopMovers > div > div > div.TopMoversTitle > div > div > a")
    public WebElement topCarrierTitle;
    @FindBy(css = "#index > div > main > div.row.container-fluid.rteSection.stateMovers > div.col-sm-12.col-lg-4.col-xs-12 > div > div.compare-offers-container > h2")
    public WebElement compareOffersTitle;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[2]/a")
    public WebElement moveHouseTypeCal;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[3]/a")
    public WebElement moveApartmentTypeCal;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[4]/a")
    public WebElement moveStorageTypeCal;
    @FindBy(xpath = "//*[@id=\"roomsFormCompareOffers\"]/div/button")
    public WebElement getPreciseButtonCal;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div[3]/div[3]/div[1]/table/tbody/tr[1]/td[2]/a/span")
    public WebElement sanFranciscoLinkFromList;
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > section.header-section.discount-header > figure > div.main-title")
    public WebElement sanFranciscoTitle;
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > div.container-fluid.row > section > div:nth-child(2) > div.total-title > h1")
    public WebElement totalListTitleSanFrancisco;

    //New York in state
    @FindBy(css = "#index > div > main > section > figure > div")
    public WebElement newYorkTitle;
    @FindBy(css = "#index > div > main > div.row.container-fluid.rteSection.stateMovers > div:nth-child(1) > section > div > div.branchesData.TopMovers > div > div > div.TopMoversTitle > div > div > a")
    public WebElement topCarrierTitleNY;
    @FindBy(css = "#index > div > main > div.row.container-fluid.rteSection.stateMovers > div.col-sm-12.col-lg-4.col-xs-12 > div > div.compare-offers-container > h2")
    public WebElement compareOffersTitleNY;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[2]/a")
    public WebElement moveHouseTypeNY;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[3]/a")
    public WebElement moveApartmentTypeNY;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div[2]/div/div[1]/form/ul/li[4]/a")
    public WebElement moveStorageTypeNY;
    @FindBy(xpath = "//*[@id=\"roomsFormCompareOffers\"]/div/button")
    public WebElement getPreciseButtonNY;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div[3]/div[3]/div[1]/table/tbody/tr[1]/td[1]/a/span")
    public WebElement brooklynLinkFromList;
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > section.header-section.discount-header > figure > div.main-title")
    public WebElement brooklynTitle;
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > div.container-fluid.row > section > div:nth-child(2) > div.total-title > h1")
    public WebElement totalListTitleBrooklyn;

    //Miami city
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > section.header-section.discount-header > figure > div.main-title")
    public WebElement chicagoTitle;
    @FindBy(css = "#index > div > main > div.cityMovers.mover-page-bg\\.jpg > div.container-fluid.row > section > div:nth-child(2) > div.total-title > h1")
    public WebElement totalCarrierChicago;
    @FindBy(xpath = "//*[@id=\"houseTypeSelectList\"]")
    public WebElement moveOptionMiami;
    @FindBy(xpath = "//*[@id=\"hp-nav-select-house\"]")
    public WebElement moveSizeMiami;
    @FindBy(xpath = "//*[@id=\"roomsForm\"]/div[3]/button")
    public WebElement compareQuotesButtonChicago;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div[2]/div[1]/section/div[2]/div[2]/div/div/div[2]/a")
    public WebElement moreDetailsButton;
    @FindBy(css = "#index > div > main > div > section.header-section.our-movers-header.bg > figure > div > h1")
    public WebElement moverNameText;
    @FindBy(xpath = "//*[@id=\"index\"]/div/main/div/section[1]/figure/div/ul")
    public WebElement moversInfo;
    @FindBy(css = "#imMovingTabs > li.our-moversr-tab.active > a > h4")
    public WebElement ratingAndReview;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[2]/a/h4")
    public WebElement aboutUs;

    //See More Movers
    @FindBy(css = "#index > main > section.section-hero.text-center > div > h1")
    public WebElement ourCarriersTitle;
    @FindBy(css = "#index > main > section.section-purple-bg.section-our-movers > div > div > div:nth-child(1) > p")
    public WebElement moversScreenedText;
    @FindBy(css = "#index > main > section.section-purple-bg.section-our-movers > div > div > div:nth-child(1) > ul > li:nth-child(5) > a")
    public WebElement communityStandardsText;
    @FindBy(css = "#index > div > main > section.header-section.how-to-header > figure > div")
    public WebElement trustAndTransparencyTitle;
    @FindBy(xpath = "(//span[@itemprop='name'])[position()>=3]")
    public List<WebElement> stateList;
    @FindBy(css = "#index > div > main > section > figure > div")
    public WebElement chosenStateTitle;
    @FindBy(css = "#index > main > section.section-state-movers > div > div > h2")
    public WebElement lookForOurMoversByState;
    @FindBy(css = "#index > main > section.section-how-we-rate-our-movers.section-purple-bg > div > h2")
    public WebElement howDoWeRateOurMovers;

    @FindBy(css = "#index > main > section.section-our-services > div > h2")
    public WebElement servicesAndHandling;
    @FindBy(xpath = "//a[@class='service-card box-shadow-card  ']")
    public List<WebElement> servicesHandlingList;
    @FindBy(css = "#index > div > main > section.header-section.how-to-header > figure > div")
    public WebElement chosenServicesTitle;
    @FindBy(css = "#index > main > section.section-join-us > div > h2")
    public WebElement areYouAMoverText;
    @FindBy(xpath = "//*[@id=\"index\"]/main/section[6]/div/a")
    public WebElement joinNowButton;
    @FindBy(css = "#index > main > section.section-faq > div > h2")
    public WebElement movingFAQ;
}
