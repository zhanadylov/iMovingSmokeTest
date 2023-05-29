package ui.pageObjectModel;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Moving_Result_Page {
    public Moving_Result_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[1]/ol/li[1]/a/span")
    public WebElement myInventoryLink;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[1]/ol/li[2]/a/span")
    public WebElement tripDetailsLink;

    @FindBy(xpath = "//small[contains(text(),'Pick Up')]")
    public WebElement labelInPickUpBox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[2]/div[1]/div")
    public WebElement addressInPickUpBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
    public WebElement editButtonInPickUp;

    @FindBy(xpath = "(//small[contains(text(),'Drop off')])[1]")
    public WebElement labelInDropOffBox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[3]/div[1]/div")
    public WebElement addressInDropOffBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[2]")
    public WebElement editButtonInDropOff;

    @FindBy(xpath = "(//small[contains(text(),'Date')])[1]")
    public WebElement labelInDateBox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[4]/div/div")
    public WebElement dateInDateBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[3]")
    public WebElement editButtonInDate;

    @FindBy(xpath = "(//small[contains(text(),'Inventory')])[1]")
    public WebElement labelInInventoryBox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[5]/div[2]/span")
    public WebElement itemsInInventory;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[5]")
    public WebElement editButtonInInventory;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[6]/div/small")
    public WebElement orderNumberLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[2]/div/section/div/ul/li[6]/div/div")
    public WebElement orderNumber;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/header/h3")
    public WebElement movingInfoText;

    @FindBy(xpath = "//p[contains(text(),'Need Help?')]")
    public WebElement needHelpTitle;
    @FindBy(xpath = "//span[contains(text(),'Call Now')]")
    public WebElement callNowText;
    @FindBy(xpath = "//span[contains(text(),'Schedule a Meeting')]")
    public WebElement scheduleMeetingText;

    //Book with iMoving
    @FindBy(xpath = "//p[contains(text(),'Why Book with iMoving?')]")
    public WebElement whyBookWithIMovingTitle;

    @FindBy(xpath = "//span[contains(text(),'Binding Price')]")
    public WebElement bindingPriceText;
    @FindBy(xpath = "(//div[@class='infoIcon'])[1]")
    public WebElement bindingPriceTooltipIcon;
    @FindBy(xpath = "(//div[@class='tooltip-content'])[1]")
    public WebElement bindingPriceTooltipContent;

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

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[1]/div/input")
    public List<WebElement> packingServicesCheckboxSideBar;

    //pick-Up Flexibility
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement noFlexibilityClick;
    @FindBy(xpath = "(//label[text()='No Flexibility '])[1]")
    public WebElement noFlexibilityText;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement days2FlexClick;
    @FindBy(xpath = "(//label[text()='2 Days Flexibility '])[1]")
    public WebElement days2FlexText;
    @FindBy(xpath = "(//input[@type='radio'])[6]")
    public WebElement days3FlexClick;
    @FindBy(xpath = "(//label[text()='3 Days Flexibility '])[1]")
    public WebElement days3FlexText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[2]/div/input")
    public List<WebElement>  flexibilityCheckboxSideBar;

    //Delivery Window
    @FindBy(xpath = "(//input[@type='radio'])[7]")
    public WebElement standard4_21DaysClick;
    @FindBy(xpath = "(//label[text()='Standard, 4-21'])[1]")
    public WebElement standard4_21DaysText;
    @FindBy(xpath = "(//input[@type='radio'])[8]")
    public WebElement expedite4_14DaysClick;
    @FindBy(xpath = "(//label[text()='Expedite, 4-14'])[1]")
    public WebElement expedite4_14DaysText;
    @FindBy(xpath = "(//input[@type='radio'])[9]")
    public WebElement straight3_6DaysClick;
    @FindBy(xpath = "(//label[text()='Straight, 3-6'])[1]")
    public WebElement straight3_6DaysText;
    @FindBy(xpath = "//*[@id=\"flexibleWindowAsPart1_33462\"]")
    public WebElement straightSameDayClick;
    @FindBy(xpath = "(//label[text()='Straight, Same day'])[1]")
    public WebElement straightSameDayText;

    //Delivery Window Mover part
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[4]/div/input")
    public List<WebElement>  deliveryWindowCheckbox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[3]/div/input")
    public List<WebElement>  deliveryWindowCheckboxSideBar;
    @FindBy(xpath = "//*[@id=\"deliveryWindowAsPart1_135031\"]")
    public WebElement  deliveryWindowExpedite;
    @FindBy(xpath = "//*[@id=\"deliveryWindowAsPart1_135032\"]")
    public WebElement  deliveryWindowStraight;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[2]/div/button")
    public List<WebElement>  flexibilityDropDown;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[2]/div/select")
    public WebElement flexibilityDropDown2;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[5]/button")
    public WebElement selectButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[5]/div[1]")
    public WebElement bindingPriceTitle;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[5]/span")
    public WebElement orderPrice;

    @FindBy(xpath = "//ul[@class='movers-list']//li//div/*[@class='moverName'] | //ul[@class='movers-list']//li//div/*[@class='newPrice']")
//    @FindBy(xpath = "//ul[@class='movers-list']/li/div[@class='flexibility-block hidden-xs hidden-sm']/div/div[@class='moverName']|//ul[@class='movers-list']/li/div[@class='checkout-block']/span[@class='newPrice']")
    public List<WebElement> moverNameAndPrice;

    @FindBy(xpath = "//ul[@class='movers-list']//li//div/*[@class='moverName']")
    public WebElement carrierNames;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[3]/div")
    public WebElement carrierName;

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

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[5]/button")
    public WebElement firstCompanyBookButton;


}
