package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderInfoQaBo {
    public OrderInfoQaBo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /*****************************************
     This class contains locator of inside orders
     *****************************************/

    @FindBy(xpath = "//li[@class='active']//a[contains(text(),'Order Details')]")
    public WebElement ordersDetailsTab;

//    @FindBy(xpath = "//li[@class='']//a[contains(text(),'Pricing')]")
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/section/div/div/div[3]/div/div/ul/li[2]/a")
    public WebElement pricingTab;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/section/div/div/div[3]/div/div/div/div[2]/div/div/div[1]")
    public WebElement pricingTabOrderInventoryList;

    @FindBy(xpath = "//li//a[contains(text(),'Inventory to deliver')]")
    public WebElement inventoryToDeliveryTab;

    @FindBy(xpath = "//li//a[contains(text(),'Changes')]")
    public WebElement changesTab;

    //Order Details
    @FindBy(xpath = "//*[@id=\"status\"]")
    public WebElement orderStatus;

    @FindBy(xpath = "//*[@id=\"tab_1\"]/div[1]/div[2]/div[2]/div[1]/div[1]")
    public WebElement carrierName;

    @FindBy(xpath = "//*[@id=\"tab_1\"]/div[1]/div[2]/div[2]/div[1]/div[3]")
    public WebElement carrierEmail;

    @FindBy(xpath = "//*[@id=\"newMoverBtn\"]")
    public WebElement selectMoverButton;

    @FindBy(xpath = "/html/body/div[1]/div/section[2]/section/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]")
    public WebElement pickUpAddress;
    @FindBy(xpath = "//button[@id='changePickupAddressModalButton']")
    public WebElement changePickUpAddressButton;
    @FindBy(xpath = "//button[@id='saveChgPickupAddress']")
    public WebElement changeAddressButtonInPopup;
    @FindBy(xpath = "//input[@id=\"autocompleteaddress_pickup\"]")
    public WebElement changeAddressInputInPopup;

    @FindBy(xpath = "//*[@id=\"changeDropOffAddressModalButton\"]")
    public WebElement changeDropOffAddressButton;
    @FindBy(xpath = "//*[@id=\"changeDateModalButton\"]")
    public WebElement changeDateButton;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[18]/div/div/div[2]/div[2]/input")
    public WebElement changeDateButtonDatePicker;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[18]/div/div/div[2]/div[2]/button")
    public WebElement changeDateButtonInPopup;
    @FindBy(xpath = "//*[@id=\"declineChangeDateMoverBtn\"]")
    public WebElement cancelChangeDateButtonInPopup;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/section/div/div/div[3]/div/div/div/div[1]/div[2]/div[1]/div[1]/span/span")
    public WebElement pickupDateValue;

    //Finance
    @FindBy(xpath = "//li//a[contains(text(),'Finance')]")
    public WebElement financeTab;
    @FindBy(xpath = "//*[@id=\"payByCheckModalBtn\"]")
    public WebElement addPaymentButton;

    @FindBy(xpath = "//li//a[contains(text(),'Payments to Carrier')]")
    public WebElement paymentToCarrierTab;

    @FindBy(xpath = "//li//a[contains(text(),'Documents')]")
    public WebElement documentsTab;

    @FindBy(xpath = "//li//a[contains(text(),'Active Log')]")
    public WebElement activeLogTab;

    @FindBy(xpath = "//li//a[contains(text(),'Inbox')]")
    public WebElement inboxTab;

    @FindBy(xpath = "//li//a[contains(text(),'Disputes')]")
    public WebElement disputesTab;

    @FindBy(xpath = "//li//a[contains(text(),'CF Calculation')]")
    public WebElement cfCalculatingTab;

    @FindBy(xpath = "//li//a[contains(text(),'Notes')]")
    public WebElement notesTab;

    //Carrier side
    @FindBy(xpath = "/html/body/div[1]/div/section[1]/div[2]/button[1]")
    public WebElement approveOrderButton;

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/div[2]/button[2]")
    public WebElement declineOrderButton;

    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/div/div/div[3]/button")
    public WebElement approveOrderButtonInPopUp;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[7]/div/div/div[3]/button[2]")
    public WebElement declineOrderButtonInPopUp;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[7]/div/div/div[3]/button[1]")
    public WebElement closeOrderButtonInPopUp;
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div[7]/div/div/div[1]/h4")
    public WebElement cantAcceptOrderTitleInPopUp;

    @FindBy(xpath = "//button[contains(text(),'Approve Change Date')]")
    public WebElement approveChangeDateButton;
}
