package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Moving_Result_Page {
    public Moving_Result_Page() { PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement editButtonInPickUp;

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  editButtonInDropOff;

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  editButtonInDate;

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  editButtonInInventory;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[4]/div/input")
    public List<WebElement>  deliveryWindowCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[2]/div/button")
    public List<WebElement>  flexibilityDropDown;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/div/div/ul/li[1]/div[3]/div[2]/div/select")
    public WebElement  flexibilityDropDown2;

    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  selectButton;

    @FindBy(xpath = "//ul[@class='movers-list']//li//div/*[@class='moverName'] | //ul[@class='movers-list']//li//div/*[@class='newPrice']")
//    @FindBy(xpath = "//ul[@class='movers-list']/li/div[@class='flexibility-block hidden-xs hidden-sm']/div/div[@class='moverName']|//ul[@class='movers-list']/li/div[@class='checkout-block']/span[@class='newPrice']")
    public List<WebElement> moverNameAndPrice;

    //Packing Services
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  selfPackingClick;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  fullPackingClick;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  packingUnpacking;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[1]/div/input")
    public List<WebElement>  packingServicesCheckboxSideBar;

    //pick-Up Flexibility
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  days3Flex;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  days2Flex;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  noFlexibility;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[2]/div/input")
    public List<WebElement>  flexibilityCheckboxSideBar;

    //Delivery Window
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  straight3_6Days;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  expedite4_14Days;
    @FindBy(xpath = "//span[contains(text(),'Congrats!')]")
    public WebElement  standard4_21Days;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/main/div[2]/section/aside/div/section[3]/div[2]/div[3]/div/input")
    public List<WebElement>  deliveryWindowCheckboxSideBar;
}


