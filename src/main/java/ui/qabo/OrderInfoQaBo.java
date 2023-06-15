package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderInfoQaBo {
    public OrderInfoQaBo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(xpath = "//li//a[contains(text(),'Finance')]")
    public WebElement FinanceTab;

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

}
