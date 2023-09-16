package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Local_Moving_Page {
    public Local_Moving_Page() {PageFactory.initElements(Driver.getDriver(), this);}

    //first step
    @FindBy(css = "#step1 > div > div > h1")
    public WebElement mainTitleText;
    @FindBy(css = "#step1 > div > div > h3")
    public WebElement textUnderTitle;
    @FindBy(css = "#step1 > div > div > div > span")
    public WebElement startHereText;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[1]/section[2]/div[2]/div/div/div[1]/div/div/div/div/input[7]")
    public WebElement firstInputField;
    @FindBy(xpath = "//*[@id=\"step1\"]/div/div/div/button")
    public WebElement nextButton;

    //Second step
    @FindBy(css = "#step2 > div > div > div > span")
    public WebElement oneMoreText;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[1]/section[2]/div[2]/div/div/div[2]/div/div/div/div/input[7]")
    public WebElement secondInputField;
    @FindBy(xpath = "//*[@id=\"step2\"]/div/div/div/button")
    public WebElement secondNextButton;

    //Third step
    @FindBy(css = "#step3 > div > div.row > h2")
    public WebElement chooseCarrierText;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[1]/div/label/span")
    public WebElement blvdMoverName;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[2]/div/label/span")
    public WebElement air1MoverName;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[3]/div/label/span")
    public WebElement ldMovingName;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[2]/button")
    public WebElement compareQuotesButton;

    //Fourt step
    @FindBy(css = "#moving-widget-screen2 > div > div.modal-body > div > h2")
    public WebElement whenAreYouMovingTitle;
    @FindBy(xpath = "//button[@id='btnScreen2']")
    public WebElement fourthNextStep;
    @FindBy(xpath = "//*[@id=\"moving-widget-screen2\"]/div/div[1]/div/div/div[1]/div")
    public WebElement datePicker;

    //Fives step
    @FindBy(css = "#moving-widget-screen3 > div > div.modal-body > div > h2")
    public WebElement whatIsYourMoveSizeTitle;
    @FindBy(xpath = "//span[@class='checkmark-radio isChecked']")
    public List<WebElement> listOfSize;
    @FindBy(xpath = "//button[@id='btnScreen3']")
    public WebElement fivesNextButton;

    //Six step
    @FindBy(css = "#moving-widget-screen4 > div > div.modal-body > div > h2")
    public WebElement doYouNeedAdditionalTitle;
//    @FindBy(xpath = "//div[@class='row cp-checkbox-list']//span[@class='cp-checkbox-item-checkmark']")
    @FindBy(xpath = "(//span[@class='cp-checkbox-item-checkmark'])[position()<=5]")
    public List<WebElement> listOfAdditionalServices;
    @FindBy(xpath = "//button[@id='btnScreen4']")
    public WebElement sixNextButton;

    //Step Seven
    @FindBy(css = "#moving-widget-screen5 > div > div.modal-body > div > h2")
    public WebElement chooseYourCarrierBookOnlineTitle;
    @FindBy(xpath = "//span[@class='checkmark-radio select-mover']")
    public List<WebElement> listOfThreeCarrier;
    @FindBy(xpath = "(//span[@class='checkmark-radio select-mover'])[1] | (//span[@class='checkmark-radio select-mover'])[2]")
    public List<WebElement> listOfLDAndBlvdCarriers;
    @FindBy(xpath = "//button[@type='button' and contains(text(),'Book now')]")
    public WebElement bookNowButton;

    //Step Eight
    @FindBy(css = "#moving-widget-screen6 > div > div > div > h2")
    public WebElement yourMoveDetailsTitle;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[1]/section[2]/div[2]/div/div/div[8]/div/div/div/div/div[1]/div[5]/div[1]/img")
    public WebElement editCarrierButton;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[1]/section[2]/div[2]/div/div/div[8]/a")
    public WebElement backArrowButton;
    @FindBy(xpath = "//*[@id=\"full_packing\"]/span")
    public WebElement addFullPackingCheckbox;
    @FindBy(xpath = "//*[@id=\"i_agree\"]/span[1]")
    public WebElement checkboxUnderDetails;
    @FindBy(xpath = "//*[@id=\"moving-widget-screen6\"]/div/div/div/div/div[4]/button")
    public WebElement confirmPayButton;

    //SignIN
    @FindBy(xpath = "(//*[@id=\"login\"])[2]")
    public WebElement signInButton;
    @FindBy(xpath = "(//input[@id='loginModel_Username'])[2]")
    public WebElement loginEmailField;
    @FindBy(xpath = "(//input[@id='loginModel_Password'])[2]")
    public WebElement loginPasswordField;
    @FindBy(xpath = "(//*[@id=\"loginForm\"]/div/div[5]/button)[2]")
    public WebElement loginButton;
    @FindBy(xpath = "(//*[@id=\"userName\"])[2]")
    public WebElement userProfile;
}
