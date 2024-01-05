package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

public class Summary_Page {
    public Summary_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'My inventory')]")
    public WebElement myInventoryLink;

    @FindBy(xpath = "//span[contains(text(),'Trip details')]")
    public WebElement tripDetailsLink;

    @FindBy(xpath = "//span[contains(text(),'My prices')]")
    public WebElement myPricesLink;

    @FindBy(xpath = "//small[contains(text(),'Pick Up')]")
    public WebElement labelInPickUpBox;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'AdditionalPickup')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement addressInPickUpBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
    public WebElement editButtonInPickUp;

    @FindBy(xpath = "(//small[contains(text(),'Drop off')])[1]")
    public WebElement labelInDropOffBox;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'AdditionalDropoff')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement addressInDropOffBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[2]")
    public WebElement editButtonInDropOff;

    @FindBy(xpath = "(//small[contains(text(),'Date')])[1]")
    public WebElement labelInDateBox;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(@class,'trip-point')]//div[@class='line2 dateDetails']//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement dateInDateBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[3]")
    public WebElement editButtonInDate;

    @FindBy(xpath = "(//small[contains(text(),'Inventory')])[1]")
    public WebElement labelInInventoryBox;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'OrderType')]//span[contains(normalize-space(.),'')])[position()=1]")
    public WebElement itemsInInventory;
    @FindBy(xpath = "(//div[@class='searchContainer']//li[contains(normalize-space(@ng-class),'OrderType')]//a[contains(normalize-space(text()),'Edit')])[position()=1]")
    public WebElement editButtonInInventory;

//    @FindBy(xpath = "(//small[contains(text(),'Order #')])[1]")
//    @FindBy(xpath = "(//div[@class='orderNumberCont'] | //small[@class='point-type' and contains(text(),'Order')])[3]")
    @FindBy(xpath = "//small[@class='point-type' and contains(text(),'Order')]")
    public WebElement orderNumberLabel;
//    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div/div[2]/div/section/div/ul/li[6]/div/div")
//    @FindBy(xpath = "(//div[@class='line2 number blue'] | //small[@class='point-type' and contains(text(),'Order')])[3]")
    @FindBy(xpath = "//div[@class='line2 number blue' and contains(text(),'Order')]")
    public WebElement orderNumber;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[1]/a/span")
    public WebElement movingJourneyLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[1]/a/span")
    public WebElement movingJourneyMiles;
    @FindBy(xpath = "//span[contains(text(),'Addresses Restriction')]")
    public WebElement addressesRestrictionsLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[2]/a/span[2]")
    public WebElement addressesRestrictionsPrice;
    @FindBy(xpath = "//span[contains(text(),'Inventory - Items')]")
    public WebElement inventoryItemsLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[3]/a/span[2]")
    public WebElement inventoryItemsPrice;
    @FindBy(xpath = "//span[contains(text(),'Inventory - Main Storage')]")
    public WebElement inventoryMainStorageLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[4]/a/span[2]")
    public WebElement inventoryMainStoragePrice;
    @FindBy(xpath = "//span[contains(text(),'Inventory - Boxes')]")
    public WebElement inventoryBoxesLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[4]/a/span[2]")
    public WebElement inventoryBoxesPrice;
    @FindBy(xpath = "//span[contains(text(),'Additional Services')]")
    public WebElement additionalServicesLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[5]/a/span[2]")
    public WebElement additionalServicesPrice;
    @FindBy(xpath = "//span[contains(text(),'Fees')]")
    public WebElement feesLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[6]/a/span[2]")
    public WebElement feesPrice;
    @FindBy(xpath = "//span[contains(text(),'Discount')]")
    public WebElement discountLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[7]/a/span[2]")
    public WebElement discountPrice;
    @FindBy(xpath = "(//span[contains(text(),'Total Price')])[1]")
    public WebElement totalPriceLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[7]/div/div/div")
    public WebElement totalPrice;

//    @FindBy(css = "body > div > div > div > div.shuffle-animation > div > price-details > section > div > ul")
    @FindBy(css = "body > div > div > div > div.shuffle-animation > div > section > div > div > div.col-lg-8.col-md-8.col-xs-12.price-details-col > price-details > div.custom-card.custom-list-group")
    public WebElement ulListOfElements;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[3]/div/div/div[2]/div[4]/button[1]")
    public WebElement addVipUnPackingButton;
    @FindBy(xpath = "//button[@class='btn btn-outline' and contains(text(),'Choose Packing Services')]")
    public WebElement choosePackingServicesButton;

    @FindBy(xpath = "//a[@class='custom-btn' and contains(text(),'Check Out')]")
    public WebElement checkOutButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div")
    public WebElement freeCancelationText;

    //From Regress
    @FindBy(xpath = "//h4[contains(normalize-space(text()),'Packing')]")
    public WebElement packingTitleText;


    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section[2]/div/div[1]/p[1]/input")
    public WebElement iHaveReadAndAgreedCheckBoxRealPath;

    @FindBy(xpath = "//a[contains(text(),'Check Out') and @class='custom-btn']")
    public WebElement CheckOutButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[2]/div/ul/li[6]/span[1]")
    public WebElement totalToPayText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div")
    public WebElement termsAndConditionsWindow;

    @FindBy(xpath = "//div[contains(normalize-space(@ng-click),'vm.addPacking()')]")
    public WebElement addPremiumPackingButton;
    @FindBy(xpath = "//div[contains(normalize-space(@ng-show),'unpackingCost')]//button[contains(normalize-space(text()),'Add') and contains(normalize-space(@class),'btn-add')]")
    public WebElement addVipPackingButton;

    @FindBy(xpath = "//h4[@class='modal-title' and contains(text(),'Check out without full packing service?')]")
    public WebElement checkOutTitleInPackingPopup;

    @FindBy(xpath = "//a[contains(text(),'Go to checkout')]")
    public WebElement goToCheckoutButton;

    @FindBy(xpath = "(//div//button[@class='close']//span[@class='icon-close'])[position()=7]")
    public WebElement xButtonInPopup;

    @FindBy(xpath = "(//div[@class='custom-card custom-list-group']//a[@class='btn-details '])[1]")
    public WebElement movingJourneyButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[2]/div/ul/li[1]/div/div/div[1]/ul/li[1]/h4")
    public WebElement pickUpTextInJourney;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[2]/div/ul/li[1]/div/div/div[2]/button")
    public WebElement showOnMapButton;

    @FindBy(xpath = "(//div[@class='custom-card custom-list-group']//a[@class='btn-details'])[1]")
    public WebElement addressesRestrictionsButton;

    @FindBy(xpath = "//*[@id=\"restrictionsModal\"]/div/div/div/div/table")
    public WebElement addressesChart;

    //    @FindBy(xpath = "//li[@class='detail-tab inventoryItems-tab']//a[@class='btn tab-header collapsed']")
    @FindBy(xpath = "(//div[@class='custom-card custom-list-group']//a[@class='btn-details'])[2]")
    public WebElement inventoryItemsButton;

    @FindBy(xpath = "//span[contains(text(),'7 Items or less')]")
    public WebElement sevenItemsText;

    //    @FindBy(xpath = "//span[normalize-space()='Inventory - Boxes']")
    @FindBy(xpath = "(//div[@class='custom-card custom-list-group']//a[@class='btn-details'])[3]")
    public WebElement inventoryBoxesButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div/div/table")
    public WebElement inventoryBoxesChart;

    //    @FindBy(xpath = "(//div[@class='custom-card custom-list-group']//a[@class='btn-details'])[4]")
    @FindBy(xpath = "//div[@class='custom-card custom-list-group']//*[contains(normalize-space(text()),'Fees')]")
    public WebElement feesButton;

    @FindBy(xpath = "//*[@id=\"feeModal\"]/div/div/div/div/table")
    public WebElement feesChart;

    @FindBy(xpath = "//a[@ui-sref='moving-results' and span[contains(normalize-space(text()),'Marketplace')]]")
    public WebElement marketplaceLinkInTitle;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[1]/div/div[2]/div[3]/div/div/span")
    public WebElement guaranteedPriceValue2;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[1]/div/div[2]/div[3]/div/div/div/span")
    public WebElement guaranteedPriceValue1;

    //    @FindBy(xpath = "//*[@id=\"itemsModalLabel\"]/span")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[1]/price-details/div[9]/a[3]/div/div[2]")
    public WebElement inventoryItemsTotalPrice;

    @FindBy(xpath = "//*[@id=\"itemsModalLabel\"]/span")
    public WebElement inventoryItemsTotalPriceInPopUp;

    //    @FindBy(xpath = "//*[@id=\"boxesModalLabel\"]/span")
    @FindBy(xpath = "//*[@id=\"boxesModalLabel\"]/span")
    public WebElement inventoryBoxesTotalPrice;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section/div/ul/li[6]/a/span[2]")
    public WebElement feesTotalPrice;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[2]/div[1]/p[3]/span")
    public WebElement totalToPayIncludingAllTaxesValue2;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[2]/div[1]/p[1]/span")
    public WebElement orderPriceInSummary;

    //    @FindBy(xpath = "(//button[@class='close'])[8]")
    @FindBy(xpath = "/html/body/div[5]/div/div/div/button[1]")
    public WebElement xButtonInItemsPopup;
    @FindBy(xpath = "(//button[contains(text(),'Close')])[7]")
    public WebElement closeButtonInItemsPopup;
    @FindBy(xpath = "/html/body/div[6]/div/div/div/button[1]")
    public WebElement xButtonInBoxesPopup;
    @FindBy(xpath = "(//button[contains(text(),'Close')])[7]")
    public WebElement closeButtonInBoxesPopup;

    @FindBy(xpath = "//*[@id=\"itemsModal\"]/div/div/div/div[6]/span")
    public WebElement bathroomTitle;
    //    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[2]/div/ul/li[6]/div/div/div")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/price-details/section[2]/div/ul/li[7]/div/div/div")
    public WebElement totalToPayIncludingAllTaxesValue;
}
