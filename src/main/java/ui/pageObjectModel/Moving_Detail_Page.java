package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Moving_Detail_Page {
    public Moving_Detail_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Set Your Road')]")
    public WebElement  setYourRoadText;

    //    @FindBy(xpath = "//input[@placeholder='Choose Date']")
    @FindBy(xpath = "(//a[@id='dropdownMenuDate'])[1]")
    public WebElement  datePicker;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/thead/tr[2]/th[1]")
    public WebElement  monthInDate;


    @FindBy(xpath = "//a[@id='dropdownMenuTime']")
    public WebElement  pickUpTime;

    @FindBy(xpath = "(//input[@name='addressInput'])[1]")
//    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/address-selection[1]/div[1]/div[1]/div[1]/input-auto-complete-address[1]/span[1]/input[1]")
    public WebElement pickUpInput;

//    @FindBy(xpath = "(//input[@name='addressInput'])[2]")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[1]/address-selection/div/div/div[1]/input-auto-complete-address/span/input")
    public WebElement  dropOffInput;

    @FindBy(xpath = "(//button[text()='Restrictions'])[1]")
    public WebElement  restrictionsButton;

    //First restriction
    @FindBy(xpath = "(//input[@placeholder='APT #'])[1]")
    public WebElement  aptInput;

    @FindBy(xpath = "(//label[contains(text(),'Remarks')])[1]")
    public WebElement  remarksText;
    @FindBy(xpath = "(//input[@placeholder='Any remarks for this location?'])[1]")
    public WebElement  remarksInput;

    @FindBy(xpath = "(//h2[contains(text(),'Restrictions')])[1]")
    public WebElement  restrictionsText;

    @FindBy(xpath = "(//span[@class='instruction'])[1]")
    public WebElement  flightOfStairsText;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[1]")
    public WebElement  flightQuantityMinusButton;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[1]")
    public WebElement  flightQuantityCounterButton;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[1]")
    public WebElement  flightQuantityPlusButton;

    @FindBy(xpath = "(//span[@class='instruction'])[2]")
    public WebElement  longCarryText;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[2]")
    public WebElement  CarryQuantityMinusButton;
    @FindBy(xpath = "(//strong[@class='quantity-counter ng-pristine ng-untouched ng-valid ng-not-empty'][normalize-space()='0 - 75'])[1]")
    public WebElement  CarryQuantityCounterButtonOfFlight;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[2]")
    public WebElement  CarryQuantityPlusButton;

    @FindBy(xpath = "(//span[@class='instruction'])[3]")
    public WebElement  elevatorText;
    @FindBy(xpath = "(//span[@class='switch-yes'])[1]")
    public WebElement  elevatorYesButton;
    @FindBy(xpath = "(//span[@class='switch-no'])[1]")
    public WebElement  elevatorNoButton;

    @FindBy(xpath = "(//span[@class='instruction'])[4]")
    public WebElement  shuttleText;
    @FindBy(xpath = "(//span[@class='switch-yes'])[2]")
    public WebElement  shuttleYesButton;
    @FindBy(xpath = "(//span[@class='switch-no'])[2]")
    public WebElement  shuttleNoButton;

    @FindBy(xpath = "(//span[@class='instruction'])[5]")
    public WebElement  insuranceText;
    @FindBy(xpath = "(//span[@class='switch-yes'])[3]")
    public WebElement  insuranceYesButton;
    @FindBy(xpath = "(//span[@class='switch-no'])[3]")
    public WebElement  insuranceNoButton;

    @FindBy(xpath = "(//button[@class='btn btn-gray'])[1]")
    public WebElement  additionalDropOffButton;


    //Additional pick-up
    @FindBy(xpath = "//a[normalize-space()='remove additional pickup']")
    public WebElement  removeAdditionalPickUp;

    @FindBy(xpath = "//button[normalize-space()='Check Rates']")
//    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[2]/button")
    public WebElement  chooseMoversButton;

}
