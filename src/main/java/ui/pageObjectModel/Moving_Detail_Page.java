package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Moving_Detail_Page {
    public Moving_Detail_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  congratsFinishedText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[1]/div[2]/ul/li[1]/strong")
    public WebElement  orderNumber;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[1]/div[2]/ul/li[2]/strong")
    public WebElement  itemsQuantity;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[1]/div[2]/ul/li[3]/strong")
    public WebElement  boxesQuantity;

    @FindBy(xpath = "//a[normalize-space()='update my Inventory']")
    public WebElement  updateMyInventory;

//    @FindBy(xpath = "(//input-auto-complete-address[@name='googleAddress'])[1]")
@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[1]/address-selection/div/input-auto-complete-address/span/input")
public WebElement pickUpInput;


//    @FindBy(xpath = "(//input-auto-complete-address[@name='googleAddress'])[2]")
@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[2]/address-selection/div/input-auto-complete-address/span/input")
    public WebElement  dropOffInput;

    @FindBy(xpath = "(//button[text()='Restrictions'])[1]")
    public WebElement  restrictionsButton;

    //First restriction
    @FindBy(xpath = "(//button[text()='Restrictions'])[1]")
    public WebElement  flightOfStairsText;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[1]")
    public WebElement  flightQuantityMinusButton;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[1]")
    public WebElement  flightQuantityCounterButton;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[1]")
    public WebElement  flightQuantityPlusButton;

    @FindBy(xpath = "(//span[contains(text(),'Long Carry')])[1]")
    public WebElement  longCarryText;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[2]")
    public WebElement  CarryQuantityMinusButton;
    @FindBy(xpath = "(//strong[@class='quantity-counter ng-pristine ng-untouched ng-valid ng-not-empty'][normalize-space()='0-75'])[1]")
    public WebElement  CarryQuantityCounterButtonOfFlight;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[2]")
    public WebElement  CarryQuantityPlusButton;

    @FindBy(xpath = "(//span[contains(text(),'Elevator')])[1]")
    public WebElement  elevatorText;
    @FindBy(xpath = "(//label[@for='elevatorOpt1918'])[1]")
    public WebElement  elevatorYesNoButton;

    @FindBy(xpath = "(//span[contains(text(),'Need shuttle?')])[1]")
    public WebElement  shuttleText;
    @FindBy(xpath = "(//label[@for='18wheelerOpt1918'])[1]")
    public WebElement  shuttleYesNoButton;

    @FindBy(xpath = "(//span[contains(text(),'Does this building require a certificate of insurance?')])[1]")
    public WebElement  insuranceText;
    @FindBy(xpath = "(//label[@for='18wheelerOpt1918'])[1]")
    public WebElement  insuranceYesNoButton;

    @FindBy(xpath = "(//span[contains(text(),'Apt')])[1]")
    public WebElement  aptText;
    @FindBy(xpath = "(//input[@placeholder='Apt #'])[1]")
    public WebElement  aptInput;

    @FindBy(xpath = "(//span[contains(text(),'Any remarks?')])[1]")
    public WebElement  remarksText;
    @FindBy(xpath = "(//input[@placeholder='Please add address instructions'])[1]")
    public WebElement  remarksInput;

    @FindBy(xpath = "(//button[contains(text(),'Approve')])[1]")
    public WebElement  approveButton;

    @FindBy(xpath = "//button[normalize-space()='Add Additional Drop Off']")
    public WebElement  additionalDropOffButton;

    @FindBy(xpath = "//input[@placeholder='Choose Date']")
    public WebElement  calendarButton;

    @FindBy(xpath = "//button[@title='3 Days. Mar. 11 - Mar. 13']")
    public WebElement  flexibleWithDate;

    @FindBy(xpath = "//div[@id='storageSlider']")
    public WebElement  sliderInDetails;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement  confirmButton;

    @FindBy(xpath = "//img[@title='Full Packing Service not selected']")
    public WebElement  fullPucking;

    @FindBy(xpath = "//img[@title='Full Packing / Unpacking Service not selected']")
    public WebElement  unPackingButton;

//    @FindBy(xpath = "//button[normalize-space()='Choose Movers']")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[2]/button")
    public WebElement  chooseMoversButton;

    @FindBy(xpath = "(//button[contains(text(),'Approve')])[3]")
    public WebElement  approveButton2;

}
