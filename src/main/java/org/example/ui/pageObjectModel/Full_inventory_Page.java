package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

import java.util.List;

public class Full_inventory_Page {
    public Full_inventory_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[contains(@class, 'custom-card room-card')]//a[contains(@class, 'icon-plus')]")
    public WebElement addItemButton;

    @FindBy(xpath = "//h1[contains(text(),'Add Items on Each Room')]")
    public WebElement fullInventoryTitle;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[4]/div/div")
    public WebElement recommendedItemsText;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[4]/div/drop-down-select/div")
    public WebElement recommendedItemsButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/div[1]/span")
    public WebElement clearThisRoomButton;

    @FindBy(xpath = "//div[contains(text(),'Save and go to next')]")
    public WebElement saveAndGoToNextButton;


    @FindBy(xpath = "//a[contains(text(),'Complete')]")
    public WebElement completeOrder;

    @FindBy(xpath = "//h4[contains(text(),'Select items')]")
    public WebElement additionalItemsRoomHeader;

    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.boxes-container.container-animate.animate > div.row.select-items-row > div > h4")
    public WebElement additionalBoxesRoomHeader;

    @FindBy(xpath = "//a[contains(text(),'Manage Rooms')]")
    public WebElement manageRoomsButton;
    @FindBy(xpath = "//a[contains(text(),'Confirm')]")
    public WebElement confirmButtonInManageRoomPopup;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/a/h3")
    public WebElement orderNumberLabel;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/a/div")
    public WebElement orderNumber;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[3]")
    public WebElement saveOrder;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[2]/div[1]/div/div[1]/input")
    public WebElement searchInput;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/section/div/div[1]/div[1]/span[2]")
    public WebElement pencilIconButton;

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

    @FindBy(xpath = "//div[contains(@ng-class,'InShoppingCart')]//div[@class='flex-center']//img[contains(@title,'')]")
    public List<WebElement> imageElement;

    @FindBy(css = "itemTypeSelector")
    public List<WebElement> typeInElement;



    //Add/Remove Popup
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > h2")
    public WebElement theseAreRecommendedRoomsForaText;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > p:nth-child(3)")
    public WebElement addOrRemoveAsYouNeedText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/button")
    public WebElement xButtonInPopup;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.modal-body > div.rooms > ul > li.room-block.anotherRoomAdd.hidden-xs > div > a")
    public WebElement plusButtonAddRoom;
    @FindBy(css = "body > div > div.body-container.bg-white > div > div.shuffle-animation > main > div.container > div.row.addItemRow > div.col-lg-6.col-sm-6.col-xs-8 > a")
    public WebElement addAdditionalPickupLocationLink;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.header-animate-block > div > div.col-lg-3.col-xs-12 > a")
    public WebElement additionalStorage;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.header-animate-block > div > div.col-lg-4.col-xs-12.custom-row > a:nth-child(1)")
    public WebElement additionalBoxes;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.header-animate-block > div > div.col-lg-4.col-xs-12.custom-row > a:nth-child(2)")
    public WebElement additionalItems;
    @FindBy(xpath = "//a[contains(text(),'Next Room')]")
    public WebElement nextRoomButtonPopup;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.divider-line > div > span")
    public WebElement clearRoomsPopup;
}
