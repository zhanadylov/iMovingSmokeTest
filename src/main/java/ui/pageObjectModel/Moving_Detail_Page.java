package ui.pageObjectModel;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Moving_Detail_Page {

    public Moving_Detail_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


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

    @FindBy(xpath = "(//*[@id=\"userMenuContainer\"]/ul[2]/li[3]/form/fieldset/button)[2]")
    public WebElement logOutButton;

    @FindBy(xpath = "//h1[contains(text(),'Set Your Road')]")
    public WebElement congratsText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[1]/div[1]/h1/span[2]")
    public WebElement YouFinishedYourInventoryList;

    @FindBy(xpath = "(//input[@name='addressInput'])[1]")
    public WebElement pickUpFromInputField;

    @FindBy(xpath = "(//input[@name='addressInput'])[2]")
    public WebElement dropOffAtInputField;

    @FindBy(xpath = "(//button[normalize-space()='Check Rates'])[1]")
    public WebElement checkRatesButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/button")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[1]/a/img")
    public WebElement iMovingLogo;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/a")
    public WebElement  datePicker;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/thead/tr[2]/th[1]")
    public WebElement  monthInDate;


    @FindBy(xpath = "//a[@id='dropdownMenuTime']")
    public WebElement  pickUpTime;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/a")
    public WebElement calendarIcon;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[2]/div[1]/date-picker/div/p/div/ul/li/div/table/thead/tr[1]/th[3]/button")
    public WebElement calendarNextMonthButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[2]/div[1]/date-picker/div/p/div/ul/li/div/table/thead/tr[2]/th[2]/small")
    public WebElement calendarMondayText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[2]/div[1]/date-picker/div/p/div/ul/li/div/table/thead/tr[1]/th[1]/button")
    public WebElement calendarPreviousMonthButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[1]/address-selection/div/h3/span/span[1]")
    public WebElement requiredFieldText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[2]/label/a")
    public WebElement pickUpTimeByDefault;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[2]/label/div/label[1]")
    public WebElement pickUpDate8to12RadioLabelButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[2]/label/div/input[1]")
    public WebElement pickUpDate8to12RealPath;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[2]/label/div/label[2]")
    public WebElement pickUpDate12to4RadioLabelButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[2]/label/div/input[2]")
    public WebElement pickUpDate12to4RealPath;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[1]/div[1]/ol/li[1]/a/span")
    public WebElement myInventoryLink;

    @FindBy(xpath = "(//input[@name='addressInput'])[1]")
    public WebElement pickUpAtGetValue;
    @FindBy(xpath = "(//input[@name='addressInput'])[2]")
    public WebElement dropOffAtGetValue;


    // Pickup Form
    @FindBy(xpath = "(//input[@placeholder='APT #'])[1]")
    public WebElement aptNumInputField;
    @FindBy(xpath = "(//input[@placeholder='Any remarks for this location?'])[1]")
    public WebElement anyRemarksInputField;
    @FindBy(xpath = "(//p[text()='Please add restriction if any to make sure your moving day will go smoothly.'])[1]")
    public WebElement restrictionTextOnPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[1]")
    public WebElement flightOfStairsLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[1]")
    public WebElement flightOfStairsMinusButtonPickup;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[1]")
    public WebElement flightOfStairsQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[1]")
    public WebElement flightOfStairsPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[2]")
    public WebElement longCarryLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[2]")
    public WebElement longCarryMinusButtonPickup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[1]/address-selection/div/address-instructions/div/div/ul/li[2]/div/div/strong")
    public WebElement longCarryQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[2]")
    public WebElement longCarryPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[3]")
    public WebElement elevatorLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[1]")
    public WebElement elevatorYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[1]")
    public WebElement elevatorNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[4]")
    public WebElement NeedShuttleLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[2]")
    public WebElement NeedShuttleYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[2]")
    public WebElement NeedShuttleNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[5]")
    public WebElement BuildingInsuranceLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[3]")
    public WebElement BuildingInsuranceYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[3]")
    public WebElement BuildingInsuranceNoPickup;

    //Additional pickUp
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[2]/button")
    public WebElement addAdditionalPickUpLink;
//    @FindBy(xpath = "(//input[@name='addressInput'])[2]")
//    public WebElement addAdditionalPickUpField;
    @FindBy(xpath = "(//input[@placeholder='APT #'])[2]")
    public WebElement addAdditionalAptNumInputField;
    @FindBy(xpath = "(//input[@placeholder='Any remarks for this location?'])[2]")
    public WebElement addAdditionalAnyRemarksInputField;
    @FindBy(xpath = "(//p[text()='Please add restriction if any to make sure your moving day will go smoothly.'])[2]")
    public WebElement addAdditionalRestrictionTextOnPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[6]")
    public WebElement addAdditionalFlightOfStairsLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[3]")
    public WebElement addAdditionalFlightOfStairsMinusButtonPickup;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[2]")
    public WebElement addAdditionalFlightOfStairsQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[3]")
    public WebElement addAdditionalFlightOfStairsPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[7]")
    public WebElement addAdditionalLongCarryLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[4]")
    public WebElement addAdditionalLongCarryMinusButtonPickup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[2]/address-selection/div/address-instructions/div/div/ul/li[2]/div/div/strong")
    public WebElement addAdditionalLongCarryQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[4]")
    public WebElement addAdditionalLongCarryPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[8]")
    public WebElement addAdditionalElevatorLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[4]")
    public WebElement addAdditionalElevatorYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[4]")
    public WebElement addAdditionalElevatorNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[9]")
    public WebElement addAdditionalNeedShuttleLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[5]")
    public WebElement addAdditionalNeedShuttleYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[5]")
    public WebElement addAdditionalNeedShuttleNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[10]")
    public WebElement addAdditionalBuildingInsuranceLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[6]")
    public WebElement addAdditionalBuildingInsuranceYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[6]")
    public WebElement addAdditionalBuildingInsuranceNoPickup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[2]/a")
    public WebElement removeAdditionalPickUpLink;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/h2")
    public WebElement headerAdditionalPickUpText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/a[1]")
    public WebElement keepAdditionalPickUp;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/a[2]")
    public WebElement deleteAdditionalPickUp;

    //Drop Off
    @FindBy(xpath = "(//input[@placeholder='Any remarks for this location?'])[2]")
    public WebElement anyRemarksInputFieldDropOff;
    @FindBy(xpath = "(//input[@placeholder='APT #'])[2]")
    public WebElement aptNumInputFieldDropOff;
    @FindBy(xpath = "(//p[text()='Please add restriction if any to make sure your moving day will go smoothly.'])[2]")
    public WebElement restrictionTextOnDropOff;
    @FindBy(xpath = "(//span[@class='instruction'])[6]")
    public WebElement flightOfStairsLabelDropOff;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[2]")
    public WebElement flightOfStairsMinusButtonAddDropOff;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[2]")
    public WebElement flightOfStairsQuantityDropOff;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[3]")
    public WebElement flightOfStairsPlusButtonDropOff;
    @FindBy(xpath = "(//span[@class='instruction'])[7]")
    public WebElement dropOffLongCarryLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[4]")
    public WebElement dropOffLongCarryMinusButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[1]/address-selection/div/address-instructions/div/div/ul/li[2]/div/div/strong")
    public WebElement dropOffLongCarryQuantity;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[4]")
    public WebElement longCarryPlusButtonDropOff;
    @FindBy(xpath = "(//span[@class='instruction'])[8]")
    public WebElement dropOffElevatorLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[4]")
    public WebElement dropOffElevatorYes;
    @FindBy(xpath = "(//span[text()='No'])[4]")
    public WebElement dropOffElevatorNo;
    @FindBy(xpath = "(//span[@class='instruction'])[9]")
    public WebElement dropOffNeedShuttleLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[5]")
    public WebElement dropOffNeedShuttleYes;
    @FindBy(xpath = "(//span[text()='No'])[5]")
    public WebElement dropOffNeedShuttleNo;
    @FindBy(xpath = "(//span[@class='instruction'])[10]")
    public WebElement dropOffBuildingInsuranceLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[6]")
    public WebElement dropOffBuildingInsuranceYes;
    @FindBy(xpath = "(//span[text()='No'])[6]")
    public WebElement dropOffBuildingInsuranceNo;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[2]/button")
    public WebElement addAdditionalDropOffLink;
    //Additional drop off start
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[2]/address-selection/div/div/div[1]/input-auto-complete-address/input")
    public WebElement additionalDropOffInputField;
    @FindBy(xpath = "(//input[@placeholder='APT #'])[3]")
    public WebElement addAdditionalDropOffAptNumInputField;
    @FindBy(xpath = "(//input[@placeholder='Any remarks for this location?'])[3]")
    public WebElement addAdditionalDropOffAnyRemarksInputField;
    @FindBy(xpath = "(//p[text()='Please add restriction if any to make sure your moving day will go smoothly.'])[3]")
    public WebElement addAdditionalDropOffRestrictionTextOnPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[11]")
    public WebElement addAdditionalDropOffFlightOfStairsLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[5]")
    public WebElement addAdditionalDropOffFlightOfStairsMinusButtonPickup;
    @FindBy(xpath = "(//strong[@class='quantity-counter'])[3]")
    public WebElement addAdditionalDropOffFlightOfStairsQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[5]")
    public WebElement addAdditionalDropOffFlightOfStairsPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[12]")
    public WebElement addAdditionalDropOffLongCarryLabel;
    @FindBy(xpath = "(//button[@class='quantity-minus'])[6]")
    public WebElement addAdditionalDropOffLongCarryMinusButtonPickup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[2]/address-selection/div/address-instructions/div/div/ul/li[2]/div/div/strong")
    public WebElement addAdditionalDropOffLongCarryQuantityPickup;
    @FindBy(xpath = "(//button[@class='quantity-plus'])[6]")
    public WebElement addAdditionalDropOffLongCarryPlusButtonPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[13]")
    public WebElement addAdditionalDropOffElevatorLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[7]")
    public WebElement addAdditionalDropOffElevatorYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[7]")
    public WebElement addAdditionalDropOffElevatorNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[14]")
    public WebElement addAdditionalDropOffNeedShuttleLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[8]")
    public WebElement addAdditionalDropOffNeedShuttleYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[8]")
    public WebElement addAdditionalDropOffNeedShuttleNoPickup;
    @FindBy(xpath = "(//span[@class='instruction'])[15]")
    public WebElement addAdditionalDropOffBuildingInsuranceLabel;
    @FindBy(xpath = "(//span[text()='Yes'])[9]")
    public WebElement addAdditionalDropOffBuildingInsuranceYesPickup;
    @FindBy(xpath = "(//span[text()='No'])[9]")
    public WebElement addAdditionalDropOffBuildingInsuranceNoPickup;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[3]/div[2]/a")
    public WebElement removeAdditionalDropOffLink;
    //Additional drop off ends

    @FindBy(xpath = "//address-selection[@title='Additional Drop off at']//li[1]//div[1]//div[1]//button[2]")
    public WebElement flightOfStairsPlusButtonAddDropOff;

    @FindBy(xpath = "//address-selection[@title='Additional Drop off at']//li[2]//div[1]//div[1]//button[2]")
    public WebElement longCarryPlusButtonAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[3]/div/div/label")
    public WebElement elevatorButtonAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[4]/div/div/label")
    public WebElement needShuttleButtonAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[5]/div/div/label")
    public WebElement doesThisBuildingAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[6]/span[2]/input")
    public WebElement aptNumAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[7]/input")
    public WebElement anyRemarksInputFieldAddDropOff;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div/section[2]/div[1]/div[1]/div[3]/address-selection/div/address-instructions/div/div[2]/ul/li[9]/div/button")
    public WebElement approveAddDropOffButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[2]/div[2]/a")
    public WebElement removeAdditionalPickupLink;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/a[2]")
    public WebElement deleteAdditionalPickupButtonInPopUp;

    @FindBy(xpath = "(//input[@name='addressInput'])[2]")
    public WebElement AdditionalPickUpField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section[2]/div/div[2]/div/button[3]")
    public WebElement continueToPaymentUpdate;

}
