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
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1) > a")
//    @FindBy(xpath = "//*[@id=\"index\"]/footer/div/div[1]/div[1]/ul/li[1]/a")
    public WebElement aboutUsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(2) > a")
    public WebElement ourMoversLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(3) > a")
    public WebElement movingServicesLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(4) > a")
    public WebElement moversJoinUsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(5) > a")
    public WebElement iMovingStandardsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(6) > a")
    public WebElement customerSupportLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(7) > a")
    public WebElement termsAndConditionsLink;
    @FindBy(css = "#index > footer > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(8) > a")
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
}
