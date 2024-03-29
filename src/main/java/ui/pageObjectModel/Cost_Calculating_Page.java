package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Cost_Calculating_Page {
    public Cost_Calculating_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[2]/h1")
    public WebElement titleInCalculatingPage;

    @FindBy(xpath = "(//*[@id=\"step1\"]/div[1]/div[1]/div/input[7])[1]")
    public WebElement pickUpInputField;
    @FindBy(xpath = "(//*[@id=\"step1\"]/div[1]/div[2]/div/input[7])[1]")
    public WebElement dropOffInputField;
    @FindBy(xpath = "//*[@id=\"dropdownMenuDate\"]")
    public WebElement calendarIcon;
//    @FindBy(xpath = "(//*[@id=\"collapseMoveSize\"]/div[3]/label)[1]")
    @FindBy(xpath = "//label[@for='calcDesktop-2Bedroom']/i")
    public WebElement moveSizeOption;
    @FindBy(xpath = "(//i[@class='icon-circle'])[position()<=5]")
    public List<WebElement> moveSizeOptions;
    @FindBy(xpath = "(//i[@class='icon-check'])[position()<=5]")
    public List<WebElement> additionalServicesOptions;
    @FindBy(xpath = "(//*[@id=\"step1\"]/div[3]/div[2]/label)[1]")
    public WebElement additionalServicesElevator;
    @FindBy(xpath = "(//*[@id=\"step1\"]/div[3]/div[4]/label)[1]")
    public WebElement additionalServicesShuttle;
    @FindBy(xpath = "(//*[@id=\"step1\"]/button)[1]")
    public WebElement showCostEstimationButton;
    //Step 2
    @FindBy(xpath = "(//*[@id=\"step2\"]/h2)[1]")
    public WebElement yourCostForaTitle;
    @FindBy(xpath = "(//*[@id=\"step2\"]/input)[1]")
    public WebElement priceBoxShouldDisplayed;
    @FindBy(xpath = "(//*[@id=\"step2\"]/p[1])[1]")
    public WebElement textUnderPrice;
    @FindBy(xpath = "(//button[contains(text(),'Continue')])[1]")
    public WebElement continueButton;
    //Step 3
    @FindBy(xpath = "(//*[@id=\"step3\"]/h2)[1]")
    public WebElement chooseYourCarrierTitle;
//    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[4]/div/div/div[2]/input")
    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[4]/div/div/div[2]/label/i")
    public WebElement chooseCarrier;
//    @FindBy(xpath = "(//div[contains(@class, 'col-lg-4 col-md-4 col-sm-4 col-xs-12')]//i[@class='icon-circle'])[position()<=3]")
//    @FindBy(xpath = "(//i[@class='icon-circle'])[position()>=6 and position()<=8]")
    @FindBy(xpath = "(//input[@class='moverId'])[position()<=3]")
    public List<WebElement> listOfCarriers;
    @FindBy(xpath = "(//*[@id=\"step3\"]/button)[1]")
    public WebElement bookNowButton;
    @FindBy(xpath = "//*[@id=\"step3\"]/a")
    public WebElement leftArrowButton;
    //Step 4 - Move Details
    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[5]/h2")
    public WebElement yourMoveDetailsTitle;
    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[5]/div[3]/div[1]/label/p")
    public WebElement textUnderdetails;
    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[5]/div[3]/div[1]/label/i")
    public WebElement checkboxOnText;
    @FindBy(xpath = "/html/body/div[1]/main/section[1]/div/div[5]/button")
    public WebElement confirmButton;

}
