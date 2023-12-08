package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FullInventoryPage {

    public FullInventoryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[contains(@ng-class,'scrollToMe')]//div[@class='flex-center']//img[contains(@title,'')]")
    public List<WebElement> imgItemLocators;
    @FindBy(xpath = "//h1[contains(normalize-space(text()),'Add Items on Each Room')]")
    public WebElement inventoryTitleText;
    @FindBy(xpath = "//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'Living Room')]")
    public WebElement livingRoomNameText;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'room-box')]//h3[text()='Bedroom']")
    public WebElement bedroomNameText;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div[3]/div[1]/div[2]/div/div[1]/div[1]/a")
    public WebElement addItemButton;

    @FindBy(xpath = "//div[contains(@class, 'custom-card room-card')]//a[contains(@class, 'icon-plus')]")
    public List<WebElement> addItemButtonList;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'')]")
    public List<WebElement> roomNameList;

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//a[contains(@class, 'custom-btn') and normalize-space(text())='Next Room']")
    public static WebElement nextRoomButton;

    @FindBy(xpath = "//a[contains(normalize-space(.), 'Next Room')]")
    public WebElement nextRoomButtonPopup;

    @FindBy(xpath = "//div[contains(@class, 'modal-buttons row')]//div[contains(@class, 'col-xs-12')]//a[contains(@class,'grey-btn')]")
    public WebElement dontHaveCabinetButton;

    @FindBy(xpath = "//div[contains(@class, 'modal-buttons row')]//div[contains(@class, 'col-xs-6')]//a[contains(@class,'blue-btn')]")
    public WebElement addCabinetButton;

    @FindBy(xpath = "(//ul[@class='full-trip-list list-inline']//div[@class='orderNumberCont']//*[contains(normalize-space(@class),'line2')])[position()=1]")
    public WebElement currentOrderNumber;

    @FindBy(xpath = "(//*[@id=\"login\"])[2]")
    public WebElement signInButton;

    @FindBy(xpath= "(//*[@id=\"loginModel_Username\"])[2]")
    public WebElement emailField;

    @FindBy(xpath = "/html/body/div/header/nav/div/div[2]/div/div/div/div/div[2]/form[1]/div/div[2]/input[1]")
    public WebElement passwordField;

    @FindBy(xpath = "(//*[@id=\"loginForm\"]/div/div[5]/button)[2]")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@id=\"userName\"])[2]")
    public WebElement userNameButton;

    @FindBy(xpath = "/html/body/div/header/nav/div/div[2]/ul[2]/li/div/ul[2]/li[3]/form/fieldset/button")
    public WebElement logOutButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div/a")
    public WebElement BoxesPopUpGotItButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/h2/span[1]")
    public WebElement recommendedRoomsText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/h2/span[2]")
    public WebElement cf64Storage2x4x8Text;

    @FindBy(xpath = "//h1[normalize-space(text())='Add Items on Each Room']")
    public WebElement addItemsOnEachRoomTitle;
    @FindBy(xpath = "//ul[@class='full-trip-list list-inline']//li[@class='trip-point storage']//div[@class='line2 dateDetails' and contains(normalize-space(text()),'')]")
    public WebElement storageSizeInHeader;
    @FindBy(xpath = "//td//select[@ng-model='sliderOption.Volume']")
    public WebElement storageDropdownOption;

    @FindBy(xpath = "//td//a[@id='dLabelStorageSizeAddPickup']")
    public WebElement storageDropdownOpenButton;

    @FindBy(xpath = "//td//ul[@class='dropdown-menu show']//li")
    public List<WebElement> storageDropdownList;
    @FindBy(xpath = "//div[@class='row items-row']//span[@ng-show='room.Amount>0']/following::figcaption[1]")
    public WebElement selectedStorageSizeInPop;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/div[1]/button")
    public WebElement saveAndGoToNextRoom;

    @FindBy(xpath = "//div[@class='itemsCountBlock']//*[contains(normalize-space(text()),'Show')]")
    public WebElement showButtonInInventory;
    @FindBy(xpath = "//div[@class='itemsCountBlock']//*[contains(normalize-space(text()),'Hide')]")
    public WebElement hideButtonInInventory;
    @FindBy(xpath = "//div[@class='removeItemBlock']//*[contains(normalize-space(text()),'Remove all')]")
    public WebElement removeAllButton;
    @FindBy(xpath = "//div[@class='room-box']//*[contains(normalize-space(@class),'icon-pen')]")
    public WebElement pencilButton;
    @FindBy(xpath = "//div[@class='room-box']//*[contains(normalize-space(@class),'icon-pen')]")
    public WebElement removeIconButton;
    //    @FindBy(xpath = "//h3[@class='room-name' and contains(normalize-space(text()),'7 Items or less')]//following::div[@class='room-box']")
    @FindBy(xpath = "//div[@class='room-box']//*[contains(normalize-space(@class),'room-name')]")
    public WebElement sevenItemsOrLessText;
    @FindBy(xpath = "(//div[@class='block-height-auto']//div[normalize-space(@class)='line2 dateDetails'])[position()=1]")
    public WebElement sevenItemsOrLessTextOnTopLeftSide;
    @FindBy(xpath = "//*[@id=\"mainHeaderInput\"]")
    public WebElement roomNameInputField;
    @FindBy(xpath = "//div[@class='itemsCountBlock']//span[contains(normalize-space(text()),'Items')]")
    public WebElement totalQuantityOfItemInRoom;

    @FindBy(xpath = "(//div[@class='block-height-auto']//div[normalize-space(@class)='line2 dateDetails'])[position()=2]")
    public WebElement totalQuantityUnderMyInventory;

    @FindBy(xpath = "//div[contains(@class,'custom-card')]//p[contains(text(),'')]")
    public WebElement iMovingIsCalculatingText;

    @FindBy(xpath = "//ul[@class='full-trip-list list-inline']//*[contains(normalize-space(@class),'icon-info')]")
    public WebElement infoIconInHeader;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/section[1]/div/a[2]")
    public WebElement NextButton;


    @FindBy(xpath = "/html/body/div/div/div/div[1]/section[2]/div/a[2]")
    public WebElement inventoryItemNextButton;

    @FindBy(xpath = "(//ul[@class='full-trip-list list-inline']//*[contains(normalize-space(@class),'icon-save')])[position()=1]")
    public WebElement saveOrderIconButton;

    @FindBy(xpath = "//h2[contains(text(),'Save and Continue Later')]")
    public WebElement saveAndContinueLaterTitle;

    @FindBy(id = "closeTutorial2")
    public WebElement OKbuttonPressThisButtonToSaveChoosedItems;

    @FindBy(xpath = "//a[@class='custom-btn-outline icon-plus' and contains(text(),'Manage')]")
    public WebElement manageRoomsLinkButton;
    @FindBy(xpath = "//a[@class='custom-btn col-xs-6' and contains(text(),'Confirm')]")
    public WebElement confirmButtonInManageRoomsPop;
    @FindBy(xpath = "(//h2[@class='modal-title' and contains(text(),'')])[position()=1]")
    public WebElement titleTextInManageAndPickUpPopup;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/p[1]")
    public WebElement manageRoomsPopupSubHeadingText;

    @FindBy(xpath = "//a[@class='custom-btn-outline icon-plus' and contains(text(),'Pickup')]")
    public WebElement addAdditionalPickupLocationLink;

    @FindBy(xpath = "//a[contains(normalize-space(.), 'Complete')]")
    public WebElement completeButton;

    @FindBy(xpath = "//div[@class='text-center']//a[contains(normalize-space(.), 'Continue')]")
    public WebElement continueButton;

    // These are recommended storages for a
    @FindBy(xpath = "//a[contains(normalize-space(@ng-click),'storage')]")
    public WebElement STORAGE;

    @FindBy(xpath = "//a[contains(normalize-space(@ng-click),'boxes')]")
    public WebElement BOXES;

    @FindBy(xpath = "//a[contains(normalize-space(@ng-click),'items')]")
    public WebElement ITEMS;


    // room name ex: Additional Items
    @FindBy(xpath = "//ul[@class='full-trip-list list-inline']//li[@class='trip-point']//*[contains(normalize-space(text()),'Additional Pickup')]")
    public WebElement additionalPickUpTitleInHeader;

    @FindBy(xpath = "(//h3[@class='room-name'][normalize-space()='Additional Items'])[1]")
    public WebElement additionalItems;

    @FindBy(xpath = "//div[contains(normalize-space(@class),'rooms-popup-buttons')]//a[contains(normalize-space(text()),'Add')]")
    public WebElement addButtonInAdditionalPopup;

    // Room name's
    @FindBy(xpath = "//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'Bedroom')]")
    public WebElement roomName;

    @FindBy(xpath = "//div[@class='input-group']//input[@type and @placeholder='Search Items']")
    public WebElement searchItemsInputInPopup;


    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[1]/section/div[2]/div/div[1]/div/div/figure/img")
    public WebElement sofa;

    @FindBy(xpath = "//span[normalize-space(text())='Additional Pickup']")
    public WebElement additionalPickUpTitle;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[1]/div[1]/div[5]/a")
    public WebElement addAdditionalPickUpBoxesButton;

    @FindBy(xpath = "//select[normalize-space(@ng-model)='sliderOption.Volume']")
    public WebElement chooseYourStorageSizeVolume;

    @FindBy(xpath = "//h2[@class='blue']")
    public WebElement didYourForgetSomethingPopUpTextInChooseYourStoragePage;

    @FindBy(xpath = "//h2[@class='modal-title' and contains(normalize-space(text()),'Did you forget something?')]")
    public WebElement didYourForgetSomethingPopUpText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/a[2]")
    public WebElement skipButtonInChooseYourStoragePage;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[1]/div/div/button[2]")
    public WebElement additionalPickupBoxesSmallBoxesPlusButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/main/div/div[2]/section[2]/ul/li[6]/div/div/button[2]")
    public WebElement additionalPickupBoxesKitchenBoxesPlusButton;

    //Create item
    @FindBy(xpath = "//div[@class='dropdown']//a[contains(normalize-space(@class),'select-chevron-down')]")
    public WebElement allDropdownButton;

    @FindBy(xpath = "//div[@class='dropdown show']//ul[contains(normalize-space(@class),'dropdown-menu show')]//li")
    public List<WebElement> allDropdownList;

    @FindBy(xpath = "//div[@ng-show='vm.showItemsView && vm.selectedstatus!=1']//div[@class='flex-center']//img[contains(@title,'')]")
    public List<WebElement> itemsImgLocator;
    @FindBy(xpath = "//div[@class='dropdown show']//*[contains(normalize-space(text()),'+ Add Custom Item')]")
    public WebElement addCustomItemButton;
    @FindBy(xpath = "//h2[contains(normalize-space(text()),'Add Custom Item')]")
    public WebElement addItemTextInPopUp;
    @FindBy(xpath = "//input[contains(normalize-space(@id),'customItemName')]")
    public WebElement addItemInputField;
    @FindBy(xpath = "//input[contains(normalize-space(@id),'customItemLength')]")
    public WebElement itemLength;
    @FindBy(xpath = "//input[contains(normalize-space(@id),'customItemWidth')]")
    public WebElement itemWidth;
    @FindBy(xpath = "//input[contains(normalize-space(@id),'customItemHeight')]")
    public WebElement itemHeight;
    @FindBy(xpath = "//div[contains(normalize-space(@class),'block-total')]")
    public WebElement totalCfValue;
    @FindBy(xpath = "//div[@class='modal-body']//a[contains(normalize-space(text()),'Add Item')]")
    public WebElement addItemButtonInPopup;
    @FindBy(xpath = "//table[@ng-repeat='item in room.Items']//p[contains(text(),'Test-123')]")
    public WebElement testCustomerNewItemInInventory;
    @FindBy(xpath = "//div[@class='flex-center']//img[contains(@title,'Test-123')]")
    public WebElement testCustomerNewItemInAddItemPopup;
}
