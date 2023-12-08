package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BoxCalculatingPopUp {
    public BoxCalculatingPopUp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Back to inventory')]")
    public WebElement backToInventoryButton;

    @FindBy(xpath = "(//a[contains(text(),'Clear boxes')])[1]")
    public WebElement clearBoxesButton;

    @FindBy(xpath = "(//a[contains(text(),'Recalculate boxes')])[1]")
    public WebElement recalculatingBoxesButton;

    @FindBy(xpath = "//a[@class='custom-btn']")
    public WebElement continueButton;

    @FindBy(xpath = "(//a[contains(text(),'How did we calculate it?')])[1]")
    public WebElement howDidWeCalculatingIt;

    //Did You Forget Something PopUP
    @FindBy(xpath = "//a[contains(text(),'Go back')]")
    public WebElement goBackButton;
    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement skipButton;

    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement addBoxesButton;
    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement addItemsButton;

    @FindBy(css = "body > div > div > div > div.shuffle-animation > main > div > div:nth-child(2) > section.room-header.clearfix > div > h1")
    public WebElement additionalPickupBoxesTitle;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[4]/div/div/button[1]")
    public WebElement largeBoxMinusButton;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[4]/div/div/strong")
    public WebElement largeBoxQuantity;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[4]/div/div/button[2]")
    public WebElement largeBoxPlusButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[9]/div/div/button[1]")
    public WebElement lampBoxMinusButton;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[9]/div/div/strong")
    public WebElement lampBoxQuantity;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[9]/div/div/button[2]")
    public WebElement lampBoxPlusButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[8]/div/div/button[1]")
    public WebElement tvBoxMinusButton;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[8]/div/div/strong")
    public WebElement tvBoxQuantity;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[8]/div/div/button[2]")
    public WebElement tvBoxPlusButton;


}
