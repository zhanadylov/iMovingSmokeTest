package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Full_inventory_Page {
    public Full_inventory_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[1]/div[1]/span[1]")
    public WebElement roomNameText;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[4]/div/div")
    public WebElement recommendedItemsText;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[4]/div/drop-down-select/div")
    public WebElement recommendedItemsButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/div[1]/span")
    public WebElement clearThisRoomButton;

    @FindBy(xpath = "//div[contains(text(),'Save and go to next')]")
    public WebElement saveAndGoToNextButton;

    @FindBy(xpath = "//h3[contains(text(),'Complete Order')]")
    public WebElement completeOrder;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a")
    public WebElement editRoomsButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/a/div")
    public WebElement orderNumber;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[3]")
    public WebElement saveOrder;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[2]/div[1]/div/div[1]/input")
    public WebElement searchInput;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[1]/div[1]/span[2]")
    public WebElement pencilIconBUtton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[1]/div[1]/div[2]")
    public WebElement newRoomNameInput;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[1]/div[1]/span[2]")
    public WebElement saveNewName;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div[1]/div[2]")
    public WebElement myInventoryButtonOnRightSide;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div[1]/div[1]")
    public WebElement leftArrowButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div[2]/div[2]/div[2]")
    public WebElement printButton;

    @FindBy(xpath = "//h2[contains(text(),'Review Your List')]")
    public WebElement reviewYourListText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[1]/button")
    public WebElement xButtonOnPrint;

    //Element
//    @FindBy(xpath = "figure img[class = 'hidden-xs']")
//    @FindBy(css = "figure img[class = \"hidden-xs\"]")
    @FindBy(css = "figure img.hidden-xs")
    public List<WebElement> imageElement;

    @FindBy(css = "itemTypeSelector")
    public List<WebElement> typeInElement;

//    @FindBy(css = "div a[class = 'btn btn-blue']")
//    @FindBy(css = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[4]")
    @FindBy(css = "/html/body/div/div/div/div[1]/main/div/div[1]/section/div[2]/div/div[2]/div/div/figure/div[2]/div[4]/div/a[1]")
    public WebElement addToInventoryButton;
}
