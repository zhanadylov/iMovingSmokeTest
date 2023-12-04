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

    @FindBy(xpath = "//div[contains(@class, 'custom-card room-card')]//a[contains(@class, 'icon-plus')]")
    public WebElement addItemButton;

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

    @FindBy(css = "body > div > div > div > div.shuffle-animation > div.rooms-panel.clearfix.visible-md-block.visible-lg-block > div.panel-left > div.rooms-list.orig > div.box-container.\\39 99 > a")
    public WebElement additionalItemsRoomHeader;

    @FindBy(css = "body > div > div > div > div.shuffle-animation > div.rooms-panel.clearfix.visible-md-block.visible-lg-block > div.panel-left > div.rooms-list.orig > div.box-container.additionalBoxesBlock > a")
    public WebElement additionalBoxesRoomHeader;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a")
    public WebElement editRoomsButton;

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

    @FindBy(xpath = "//div[contains(@ng-class,'scrollToMe')]//div[@class='flex-center']//img[contains(@title,'')]")
    public List<WebElement> imageElement;

    @FindBy(css = "itemTypeSelector")
    public List<WebElement> typeInElement;



    //Add/Remove Popup
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.modal-body > h2 > span:nth-child(2)")
    public WebElement theseAreRecommendedRoomsForaText;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.modal-body > h2 > span:nth-child(6)")
    public WebElement pleaseAddRemoveAndConfirmText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/button")
    public WebElement xButtonInPopup;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.modal-body > div.rooms > ul > li.room-block.anotherRoomAdd.hidden-xs > div > a")
    public WebElement plusButtonAddRoom;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.modal-body > div.hidden-xs.hidden-sm > h2 > div > p")
    public WebElement addAdditionalPickupLocationLink;
    @FindBy(css = "#collapseExample > ul > li.room-block.pickup.pickup-storage > a")
    public WebElement additionalStorage;
    @FindBy(css = "#collapseExample > ul > li.room-block.pickup.pickup-boxes > a")
    public WebElement additionalBoxes;
    @FindBy(css = "#collapseExample > ul > li.room-block.pickup.pickup-items > a")
    public WebElement additionalItems;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.divider-line > div > a.btn.btn-blue.col-xs-6 > span.col-sm-9.col-xs-12")
    public WebElement continueButtonPopup;
    @FindBy(css = "body > div.modal.fade.in > div > div > div > div.divider-line > div > span")
    public WebElement clearRoomsPopup;
}
