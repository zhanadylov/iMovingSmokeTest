package org.example.ui.pageObjectModel;

import org.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Marketplace_Page {
    public Marketplace_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@ui-sref='fullInventory'and contains(@class,'circle')]")
    public WebElement myInventoryIcon;

    @FindBy(xpath = "//a[@ui-sref='moving-details'and contains(@class,'circle')]")
    public WebElement tripDetailsIcon;

    @FindBy(xpath = "//div[contains(@class,'circle active')]")
    public WebElement marketplaceIcon;
    @FindBy(xpath = "//a[@ui-sref='moving-results' and @itemprop='item']//span")
    public WebElement marketplaceLink;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'circle') and text()='4']")
    public WebElement summaryIcon;
    @FindBy(xpath = "//a[@itemprop='item']//span[contains(text(),'Summary')]")
    public WebElement summaryLink;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'circle') and text()='5']")
    public WebElement paymentIcon;
    @FindBy(xpath = "//a[@itemprop='item']//span[contains(text(),'Payment')]")
    public WebElement paymentLink;

    @FindBy(xpath = "//small[contains(text(),'Pick Up')]")
    public WebElement labelInPickUpBox;

    @FindBy(xpath = "(//small[contains(text(),'Drop off')])[1]")
    public WebElement labelInDropOffBox;

    @FindBy(xpath = "(//small[contains(text(),'Date')])[1]")
    public WebElement labelInDateBox;

    @FindBy(xpath = "(//small[contains(text(),'Inventory')])[1]")
    public WebElement labelInInventoryBox;

    @FindBy(xpath = "//p[contains(text(),'Need Help?')]")
    public WebElement needHelpTitle;
    @FindBy(xpath = "//span[contains(text(),'Call Now')]")
    public WebElement callNowText;
    @FindBy(xpath = "//span[contains(text(),'Schedule a Meeting')]")
    public WebElement scheduleMeetingText;

    //Book with iMoving

    @FindBy(xpath = "//span[contains(text(),'Inventory Control')]")
    public WebElement inventoryControlText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[2]")
    public WebElement inventoryControlTooltipIcon;
    @FindBy(xpath = "(//div[@class='tooltip-content'])[2]")
    public WebElement inventoryControlTooltipContent;

    @FindBy(xpath = "//span[contains(text(),'Secure Payment')]")
    public WebElement securePaymentText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[3]")
    public WebElement securePaymentTooltipIcon;

    //Filter titles
    @FindBy(xpath = "//p[contains(text(),'Packing Services')]")
    public WebElement packingServicesTitle;
    @FindBy(xpath = "//p[contains(text(),'Pick-Up Flexibility')]")
    public WebElement pickUpFlexibilityTitle;
    @FindBy(xpath = "//p[contains(text(),'Delivery Window')]")
    public WebElement deliveryWindowTitle;
    @FindBy(xpath = "//a[contains(text(),'Reset')]")
    public WebElement resetButton;
    //Packing Services
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement selfPackingClick;
    @FindBy(xpath = "//label[contains(text(),'Self Packing')]")
    public WebElement selfPackingText;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement fullPackingClick;
    @FindBy(xpath = "//label[contains(text(),'Full Packing')]")
    public WebElement fullPackingText;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement packingUnpackingClick;
    @FindBy(xpath = "//label[contains(text(),'Packing & unpacking')]")
    public WebElement packingUnpackingText;

//    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[1]/div/input")
    @FindBy(xpath = "//input[@type='radio'][@name='packing']")
    public List<WebElement> packingServicesCheckboxSideBar;

    //pick-Up Flexibility
    @FindBy(xpath = "(//label[text()='No Flexibility '])[1]")
    public WebElement noFlexibilityText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[2]/div/input")
//    @FindBy(xpath = "//input[@type='radio'][@name='flexibilityWindowAsPartFilter1_0' or @name='flexibilityWindowAsPartFilter1_1' or @name='flexibilityWindowAsPartFilter1_2']")
    public List<WebElement>  flexibilityCheckboxSideBar;

    //Delivery Window
    @FindBy(xpath = "//*[@id=\"flexibleWindowAsPart1_33462\"]")
    public WebElement straightSameDayClick;

//    @FindBy(xpath = "//input[@type='radio'][@name='deliveryWindowAsPartFilter1_0' or @name='deliveryWindowAsPartFilter1_1' or @name='deliveryWindowAsPartFilter1_2']")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[3]/div/input")
    public List<WebElement>  deliveryCheckboxSideBar;

    //Delivery Window Mover part
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[4]/div/input")
    public List<WebElement>  deliveryWindowCheckbox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[3]/div/input")
    public List<WebElement>  deliveryWindowCheckboxSideBar;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[2]/div/button")
    public List<WebElement>  flexibilityDropDown;


    @FindBy(xpath = "//div[contains(normalize-space(@class),'sticky-mover-info text-center active')]//a[@class='custom-btn'][normalize-space()='Select']")
    public WebElement selectButtonInPopup;

    @FindBy(xpath = "//ul[@class='movers-list']//li//div/*[@class='moverName']")
    public WebElement carrierNames;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[3]/div[1]/label")
    public WebElement packingFromRadioButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[3]/div[1]/input")
    public WebElement packingFromRadioButtonRealPath;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[3]/div[2]/label")
    public WebElement unpackingFromRadioButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[3]/div[2]/input")
    public WebElement unpackingFromRadioButtonRealPath;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[4]/div[1]")
    public WebElement zeroToFiftyCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[4]/div[2]")
    public WebElement fiftyOneToHundredCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[4]/div[3]")
    public WebElement hundredAndUpCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[4]/div[4]")
    public WebElement allMoversCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[4]/aside/div/section[4]/div[4]/input")
    public WebElement allMoversCheckboxRealPath;


    //from regress
    @FindBy(xpath = "//a[@ui-sref='fullInventory'and @itemprop='item']//span[contains(text(),'Inventory')]")
    public WebElement myInventoryLink;

    @FindBy(xpath = "//a[@ui-sref='moving-details' and span[contains(normalize-space(text()),'Details')]]//span")
    public WebElement tripDetailsLink;

    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'AdditionalPickup')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement addressInPickUpBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
    public WebElement editButtonInPickUp;

    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'AdditionalDropoff')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement addressInDropOffBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[2]")
    public WebElement editButtonInDropOff;

    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(@class,'trip-point')]//div[@class='line2 dateDetails']//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement dateInDateBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[3]")
    public WebElement editButtonInDate;

    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'OrderType')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement itemsInInventory;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'OrderType')]//a[contains(normalize-space(text()),'Edit')])[position()=1]")
    public WebElement editButtonInInventory;

    @FindBy(xpath = "//div[@class='searchContainer']//li[contains(normalize-space(@class),'trip-point')]//small[contains(normalize-space(text()),'Order')]")
    public WebElement orderNumberLabel;
    @FindBy(xpath = "//div[@class='searchContainer']//div[contains(normalize-space(@class),'orderNumberCont')]//div[contains(normalize-space(@class),'line2')]")
    public WebElement orderNumber;

    @FindBy(xpath = "//section[1]//div[contains(@class,'moving-results-header')]//h3[contains(normalize-space(text()),'')]")
    public WebElement movingInfoText;

    //Book with iMoving
    @FindBy(xpath = "//p[contains(text(),'Why Book with iMoving?')]")
    public WebElement whyBookWithIMovingTitle;

    @FindBy(xpath = "//span[contains(text(),'Binding Price')]")
    public WebElement bindingPriceText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[1]")
    public WebElement bindingPriceTooltipIcon;
    @FindBy(xpath = "(//div[@class='tooltip-content'])[1]")
    public WebElement bindingPriceTooltipContent;

    @FindBy(xpath = "(//div[@class='tooltip-content'])[3]")
    public WebElement securePaymentTooltipContent;

    @FindBy(xpath = "//span[contains(text(),'Price Match')]")
    public WebElement priceMatchText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[4]")
    public WebElement priceMatchTooltipIcon;
    @FindBy(xpath = "(//div[@class='tooltip-content'])[4]")
    public WebElement priceMatchTooltipContent;

    @FindBy(xpath = "//span[contains(text(),'Customer Support')]")
    public WebElement customerSupportText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[5]")
    public WebElement customerSupportTooltipIcon;
    @FindBy(xpath = "(//div[@class='tooltip-content'])[5]")
    public WebElement customerSupportTooltipContent;

    //Filter titles
    @FindBy(xpath = "//p[contains(text(),'Filters')]")
    public WebElement filterTitle;


    //pick-Up Flexibility
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement noFlexibilityClick;
    @FindBy(xpath = "//label[contains(text(),'Exact Date')]")
    public WebElement exactDateFlexibilityText;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement days2FlexClick;
    //    @FindBy(xpath = "(//label[text()='2 Days Flexibility '])[1]")
    @FindBy(xpath = "//label[contains(text(),'2 Days Flexibility')]")
    public WebElement days2FlexText;
    @FindBy(xpath = "(//input[@type='radio'])[6]")
    public WebElement days3FlexClick;
    //    @FindBy(xpath = "(//label[text()='3 Days Flexibility '])[1]")
    @FindBy(xpath = "//label[contains(text(),'3 Days Flexibility')]")
    public WebElement days3FlexText;


    //Delivery Window
    @FindBy(xpath = "(//input[@type='radio'])[7]")
    public WebElement standard4_21DaysClick;
    //    @FindBy(xpath = "(//label[text()='Standard, 4-21'])[1]")
    @FindBy(xpath = "//label[contains(text(),'Standard, 4-21')]")
    public WebElement standard4_21DaysText;
    @FindBy(xpath = "(//input[@type='radio'])[8]")
    public WebElement expedite4_14DaysClick;
    //    @FindBy(xpath = "(//label[text()='Expedite, 4-14'])[1]")
    @FindBy(xpath = "//label[contains(text(),'Expedite, 4-14')]")
    public WebElement expedite4_14DaysText;
    @FindBy(xpath = "(//input[@type='radio'])[9]")
    public WebElement straight3_6DaysClick;
    //    @FindBy(xpath = "(//label[text()='Straight, 3-6'])[1]")
    @FindBy(xpath = "//label[contains(text(),'Straight, 3-6')]")
    public WebElement straight3_6DaysText;
    @FindBy(xpath = "(//label[text()='Straight, Same day'])[1]")
    public WebElement straightSameDayText;

    //Delivery Window Mover part
    @FindBy(xpath = "//*[@id=\"deliveryWindowAsPart1_135031\"]")
    public WebElement  deliveryWindowExpedite;
    @FindBy(xpath = "//*[@id=\"deliveryWindowAsPart1_135032\"]")
    public WebElement  deliveryWindowStraight;

    @FindBy(xpath = "//*[@id=\"deliveryWindowAsPartFilter1_0\"]")
    public WebElement straightSameDayInputLocalSideBar;
    @FindBy(xpath = "(//label[contains(text(),'Straight, Same day')])[1]")
    public WebElement straightSameDayTextLocalSideBar;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[4]/div[2]/label")
    public WebElement straightSameDayTextLocalCarrierPart;
    @FindBy(xpath = "//div[@class='custom-card']//div[@class='col-lg-2 col-xs-2 text-center']//p[contains(normalize-space(text()),'miles')]")
    public WebElement distanceInLocal;

    @FindBy(xpath = "body > div.wrap > div > div > div.shuffle-animation > main > div.container > section > div.movers-block > div > div > div.custom-card.card-selected > div.sticky-mover-info.text-center.active > div > div.custom-checkbox.disable-select > div > button")
    public WebElement flexibilityButton;
    @FindBy(xpath = "//div[contains(normalize-space(@class),'sticky-mover-info text-center active')]//div[@class='checkout-block']//select[contains(normalize-space(@ng-model),'result.FlexibilityType')]")
    public WebElement flexibilityDropDown2;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'sticky-mover-info text-center active')]//div[@class='checkout-block']//select[contains(normalize-space(@ng-model),'result.DeliveryType')]")
    public WebElement deliveryWindowDropDown;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'sticky-mover-info text-center active')]//div[@class='checkout-block']//span[contains(normalize-space(text()),'Binding Price')]")
    public WebElement bindingPriceTitle;
    @FindBy(xpath = "//div[contains(normalize-space(@class),'movers-cards')]//div[@class='flex-wrap']//p[contains(normalize-space(@class),'text-price')]")
    public WebElement orderPrice;

    @FindBy(xpath = "//div[contains(normalize-space(@class), 'movers-cards')]//div[@class='flex-wrap' and .//p[contains(text(),'All In One Movi...')]]//p[contains(normalize-space(@class), 'text-price')]")
    public WebElement orderPriceByCarrierName;

    @FindBy(xpath = "//ul[@class='movers-list']//li//div/*[@class='moverName'] | //ul[@class='movers-list']//li//div/*[@class='newPrice']")
//    @FindBy(xpath = "//ul[@class='movers-list']/li/div[@class='flexibility-block hidden-xs hidden-sm']/div/div[@class='moverName']|//ul[@class='movers-list']/li/div[@class='checkout-block']/span[@class='newPrice']")
    public List<WebElement> moverNameAndPrice;

    @FindBy(xpath = "//div[@class='custom-card']//div/*[@class='moverName']")
    public List<WebElement> carrierNamesList;


/////////////

    @FindBy(xpath = "//div[contains(normalize-space(@class),'moving-results-header h-flex')]//h3[contains(normalize-space(text()),'')]")
    public WebElement textInMarketplace;
    @FindBy(xpath = "//p[contains(@class, 'moverName') and contains(normalize-space(text()),'Glass City Movers')]")
    public WebElement glassCityMoversBookNow;
    @FindBy(xpath = "//p[contains(@class, 'moverName') and contains(normalize-space(text()),'In & Out Moving')]")
    public WebElement inAndOutMovingBookNow;

    @FindBy(xpath = "(//p[contains(@class, 'moverName') and contains(normalize-space(text()),'')])[position()<=1]")
    public WebElement firstCarrierButton;

    @FindBy(xpath = "//div[@class='sticky-mover-info text-center']//p[contains(normalize-space(text()),'Air 1 Moving & Storage')]")
    public WebElement carrierNameInPopup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[11]/div[5]/button")
    public WebElement proMoversBookNow;

    //    @FindBy(xpath = "(//button[@class='btn btn-blue checkout'][normalize-space()='Select'])[2]")
    @FindBy(xpath = "//p[contains(@class, 'moverName') and contains(normalize-space(text()),'City Moving')]")
    public WebElement cityMovingBookNowButton;

    @FindBy(xpath = "//li[contains(., 'Best Quality Movers')]/div[@class='checkout-block']/button")
    public WebElement bestQualityMoversBookNowButton;

    @FindBy(xpath = "//li[contains(., 'Blue Bell Relocation')]/div[@class='checkout-block']/button")
    public WebElement blueBellRelocationBookNowButton;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/div/div/button")
    public WebElement signInButton;

    @FindBy(xpath= "/html/body/div[1]/header/nav/div/div[2]/div/div/div/div/div[2]/form[1]/div/div[1]/input")
    public WebElement emailField;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/div/div/div/div/div[2]/form[1]/div/div[2]/input[1]")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/div/div/div/div/div[2]/form[1]/div/div[5]/button")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@id=\"userName\"])[2]")
    public WebElement userNameButton;

    @FindBy(xpath = "/html/body/div/header/nav/div/div[2]/ul[2]/li/div/ul[2]/li[3]/form/fieldset/button")
    public WebElement logOutButton;
}
