package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
    @FindBy(xpath = "//ul[@class='list-unstyled']//a[contains(text(),'MovingPedia')]")
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
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(4) > a")
    public WebElement interstateMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(5) > a")
    public WebElement crossCountryMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(6) > a")
    public WebElement movingBoxesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(7) > a")
    public WebElement longDistanceMovingLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(8) > a")
    public WebElement bestMovingLaborCompaniesLink;

    //Carriers by State
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > h6")
    public WebElement carriersByState;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(1) > a")
    public WebElement moversInCaliforniaLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(2) > a")
    public WebElement floridaMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(3) > ul > li:nth-child(3) > a")
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
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(2) > a")
    public WebElement miamiMovingCompaniesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(3) > a")
    public WebElement nYCMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(4) > a")
    public WebElement houstonMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(5) > a")
    public WebElement chicagoMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(4) > ul > li:nth-child(6) > a")
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
    @FindBy(css = "#index > div > main > div > section.header-section.faq-header > figure > h1")
    public WebElement letsKeepInTouchTitle;
    @FindBy(css = "#index > div > main > div > section.faq-container > div > section > h2")
    public WebElement WeWouldLoveToHearFromYouTitle;
    @FindBy(xpath = "//*[@id=\"sendForm\"]")
    public WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"supportSection\"]/div/div[1]/ul/li[2]/a")
    public WebElement faqTab;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[1]/a/h4")
    public WebElement generalTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[2]/a/h4")
    public WebElement howDoesItWorkTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[3]/a/h4")
    public WebElement ourMoversTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[4]/a/h4")
    public WebElement bookingYourMoveTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[5]/a/h4")
    public WebElement onceYourMoveIsBookedTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[6]/a/h4")
    public WebElement postMoveTitle;
    @FindBy(xpath = "//*[@id=\"imMovingTabs\"]/li[7]/a/h4")
    public WebElement billingTitle;

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
}
