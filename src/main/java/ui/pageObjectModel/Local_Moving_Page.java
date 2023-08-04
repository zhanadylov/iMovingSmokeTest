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
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[4]/div/label/span")
    public WebElement air1MoverName;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[2]/div/label/span")
    public WebElement blvdMoverName;
    @FindBy(xpath = "//*[@id=\"step3\"]/div/div[1]/div[5]/div/label/span")
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
    @FindBy(xpath = "//div[@class='row cp-checkbox-list']//span[@class='cp-checkbox-item-checkmark']")
    public List<WebElement> listOfAdditionalServices;
    @FindBy(xpath = "//button[@id='btnScreen4']")
    public WebElement sixNextButton;

    //Step Seven
    @FindBy(css = "#moving-widget-screen5 > div > div.modal-body > div > h2")
    public WebElement chooseYourCarrierBookOnlineTitle;
    @FindBy(xpath = "//span[@class='checkmark-radio select-mover']")
    public List<WebElement> listOfThreeCarrier;
    @FindBy(xpath = "//button[@type='button' and contains(text(),'Book now')]")
    public WebElement bookNowButton;
}
