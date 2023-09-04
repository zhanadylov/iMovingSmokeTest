package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QaboDashBoardPage {
    public QaboDashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#logoutForm > ul > li:nth-child(2) > a")
    public WebElement logOffButton;
    @FindBy(css = "body > div.wrapper > div > section.content-header > h1 > div > a")
    public WebElement ordersDashboardTitle;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(1) > a")
    public WebElement dashboardLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(2) > a")
    public WebElement usersLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(3) > a")
    public WebElement companiesLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(4) > a")
    public WebElement branchesLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(5) > a")
    public WebElement affiliatesLabelInSideBar;

//    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(6) > a")
    @FindBy(xpath = "//a[normalize-space()='Orders']")
    public WebElement ordersLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(7) > a")
    public WebElement financialLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(8) > a")
    public WebElement supplierRequestsLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(9) > a")
    public WebElement calendarLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(10) > a")
    public WebElement reviewLabelInSideBar;

    //Pricing Tools
    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(11) > a")
    public WebElement pricingToolsSideBar;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(1) > a")
    public WebElement discountsPricingTool;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(2) > a")
    public WebElement feesPricingTool;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(3) > a")
    public WebElement flexibilityPricingTool;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(4) > a")
    public WebElement deliveryPricingTool;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(5) > a")
    public WebElement defaultPricingTool;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(6) > a")
    public WebElement servicePricingTool;

    //Tools
    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(12) > a")
    public WebElement toolsSideBar;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(1) > a")
    public WebElement carrierSearchTools;

    //Lists
    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(13) > a")
    public WebElement listsSideBar;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li.treeview > a")
    public WebElement merchantLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(2) > a")
    public WebElement feeTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(3) > a")
    public WebElement truckTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(4) > a")
    public WebElement licensesTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(5) > a")
    public WebElement insuranceTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(6) > a")
    public WebElement serviceTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(7) > a")
    public WebElement orderCancellingTypesLists;
    @FindBy(css = "body > div.wrapper > aside > section > ul > li.treeview.active > ul > li:nth-child(8) > a")
    public WebElement specialTypesLists;
}
