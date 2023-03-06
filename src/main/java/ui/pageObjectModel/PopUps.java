package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PopUps {
    public PopUps() {PageFactory.initElements(Driver.getDriver(),this);}

    //First pop-up
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")
    public WebElement recommendedRoomPopUpText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/button")
    public WebElement xButton;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    public WebElement continueButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[7]/div/a")
    public WebElement addRoomButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[5]/div[1]/div[1]/span[1]")
    public WebElement minusButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[5]/div[1]/div[1]/span[2]")
    public WebElement plusButton;

    @FindBy(xpath = "//p[contains(text(),'Add additional pickup location')]")
    public WebElement additionalPickUp;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[2]/div/ul/li[1]/a")
    public WebElement storageOnPopUp;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[2]/div/ul/li[2]/a")
    public WebElement boxesOnPopUp;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[2]/div/ul/li[3]/a")
    public WebElement itemsOnPopUp;

    //Second
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/span")
    public WebElement boxesTitleText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/p")
    public WebElement boxesText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div/a")
    public WebElement gotItbutton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/button")
    public WebElement xButtonSecond;

    //Third
    @FindBy(xpath = "/html/body/div/div/div/div[1]/section[1]/div/p[1]")
    public WebElement textInThird;
    @FindBy(xpath = "//*[@id=\"closeTutorial\"]")
    public WebElement okButtonThird;
    @FindBy(xpath = "//*[@id=\"nextInventoryTutorial\"]")
    public WebElement nextButtonThird;

    //Four
    @FindBy(xpath = "/html/body/div/div/div/div[1]/section[2]/div/p[1]")
    public WebElement textInFour;
    @FindBy(xpath = "//*[@id=\"closeTutorial1\"]")
    public WebElement okButtonFour;
    @FindBy(xpath = "//*[@id=\"nextNextRoomTutorial\"]")
    public WebElement nextButtonFour;

    //Five
    @FindBy(xpath = "/html/body/div/div/div/div[1]/section[3]/div/p[1]")
    public WebElement textInFive;
    @FindBy(xpath = "//*[@id=\"closeTutorial2\"]")
    public WebElement okButtonFive;
}
