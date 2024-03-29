package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/section/div/ul/li[2]/div[1]/div")
    public WebElement addressInPickUpBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
    public WebElement editButtonInPickUp;

    @FindBy(xpath = "(//small[contains(text(),'Drop off')])[1]")
    public WebElement labelInDropOffBox;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/section/div/ul/li[3]/div[1]/div")
    public WebElement addressInDropOffBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[2]")
    public WebElement editButtonInDropOff;

    @FindBy(xpath = "(//small[contains(text(),'Date')])[1]")
    public WebElement labelInDateBox;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/section/div/ul/li[4]/div/div")
    public WebElement dateInDateBox;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[3]")
    public WebElement editButtonInDate;

    @FindBy(xpath = "(//small[contains(text(),'Inventory')])[1]")
    public WebElement labelInInventoryBox;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/section/div/ul/li[5]/div[2]/div")
    public WebElement itemsInInventory;
    @FindBy(xpath = "(//a[contains(text(),'Edit')])[5]")
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

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[3]/div/div/div[1]/div[4]/button[1]")
    public WebElement addPremiumPackingButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div/div/div[3]/div/div/div[2]/div[4]/button[1]")
    public WebElement addVipUnPackingButton;

    @FindBy(xpath = "//button[@class='btn btn-blue' and contains(text(),'Go to checkout')]")
    public WebElement goToCheckoutButton;
    @FindBy(xpath = "//button[@class='btn btn-outline' and contains(text(),'Choose Packing Services')]")
    public WebElement choosePackingServicesButton;

    @FindBy(xpath = "//button[@class='btn blueBtn' and contains(text(),'Check Out')]")
    public WebElement checkOutButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/section/div")
    public WebElement freeCancelationText;

}
