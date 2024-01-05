package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

public class UserZonePage {
    public UserZonePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //User profile popup
    @FindBy(css = "#userMenuContainer > h3")
    public WebElement myLastMovePlansTitle;

    @FindBy(css = "#userMenuContainer > ul.plans-list.list-unstyled > li:nth-child(1) > a > span.plan-name")
    public WebElement firstOrderLink;

    @FindBy(xpath = "//span[contains(text(),'INDEX')]")
    public WebElement orderLinkByNumber;

    @FindBy(css = "#userMenuContainer > a")
    public WebElement seeAllText;

    @FindBy(css = "#userMenuContainer > ul.user-menu-list.list-unstyled > li:nth-child(1) > a > span")
    public WebElement messagesLink;

    @FindBy(css = "#userMenuContainer > ul.user-menu-list.list-unstyled > li:nth-child(2) > a > span")
    public WebElement accountSettingsLink;

    @FindBy(css = "#userMenuContainer > ul.user-menu-list.list-unstyled > li:nth-child(3) > form > fieldset > button > span")
    public WebElement logOutLink;

    //Order Detail
    @FindBy(css = "#index > main > div.container > div:nth-child(1) > div.col-xs-7 > div > a")
    public WebElement manageOrderButton;

    @FindBy(css = "#index > main > div.container > div:nth-child(1) > div.col-xs-7 > div > ul > li:nth-child(2) > a")
    public WebElement editJourneyButton;
    @FindBy(css = "#index > main > div.container > div:nth-child(1) > div.col-xs-7 > div > ul > li:nth-child(3) > a")
    public WebElement EditInventoryButton;
    @FindBy(css = "#index > main > div.container > div:nth-child(1) > div.col-xs-7 > div > ul > li:nth-child(4) > a")
    public WebElement copyInventoryButton;
    @FindBy(css = "#cancelModalBtn")
    public WebElement requestCancelButton;

    //PopUp
    @FindBy(css = "#editInventoryModal > div > div > div > img")
    public WebElement warningIcon;
    @FindBy(css = "#editInventoryModalLabel")
    public WebElement EditInventoryPopupTitle;
    String infoText = "Any changes made to this order may fluctuate your price.";
    @FindBy(css = "#editInventoryModal > div > div > div > p:nth-child(4)")
    public WebElement infoPopupText;
    @FindBy(css = "#editInventoryModal > div > div > div > div > div:nth-child(1) > button")
    public WebElement cancelButtonPopup;
    @FindBy(css = "#editInventoryModal > div > div > div > div > div:nth-child(2) > a")
    public WebElement editButtonPopup;

    @FindBy(css = "#index > main > div.container > div:nth-child(1) > div.col-xs-5 > a")
    public WebElement backButton;
    //Left side
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-4 > div > h2")
    public WebElement orderNumber;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-4 > div > h2 > span")
    public WebElement orderStatus;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-4 > div > h3")
    public WebElement pickUpAddress;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-4 > div > div > div.col-lg-12.col-sm-5.col-xs-12 > h3")
    public WebElement carrierName;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-4 > div > div > div.col-lg-12.col-sm-7.col-xs-12 > p > span")
    public WebElement paidPrice;

    //Moving Journey
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div:nth-child(1) > h4")
    public WebElement movingJourneyTitle;

    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div.col-lg-6.col-sm-6.col-xs-12.pickup-col > h2 > span")
    public WebElement orderMiles;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div.col-lg-6.col-sm-6.col-xs-12.pickup-col > time > span:nth-child(2)")
    public WebElement estimatedTime;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div:nth-child(3) > time > span:nth-child(2)")
    public WebElement estimatedDeliveryDate;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div.col-lg-6.col-sm-6.col-xs-12.pickup-col > address > span:nth-child(2)")
    public WebElement pickUpFullAddress;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(1) > div:nth-child(3) > address > span:nth-child(2)")
    public WebElement dropOffFullAddress;

    //Inventory Information
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(2) > div > h4")
    public WebElement inventoryInformationTitle;

    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(2) > div > div > div:nth-child(1) > div > span")
    public WebElement totalCFData;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(2) > div > div > div:nth-child(2) > div > span")
    public WebElement inventoryRoomsData;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(2) > div > div > div:nth-child(3) > div > span")
    public WebElement inventoryItemData;
    @FindBy(css = "#index > main > div.container > div:nth-child(2) > div.col-lg-8 > div:nth-child(2) > div > div > div:nth-child(4) > div > span")
    public WebElement inventoryBoxesData;
}
