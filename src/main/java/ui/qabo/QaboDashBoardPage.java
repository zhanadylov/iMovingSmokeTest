package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QaboDashBoardPage {
    public QaboDashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(6) > a")
    public WebElement ordersLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(7) > a")
    public WebElement financialLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(8) > a")
    public WebElement supplierRequestsLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(9) > a")
    public WebElement calendarLabelInSideBar;

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(10) > a")
    public WebElement reviewLabelInSideBar;

    @FindBy(xpath = "")
    public WebElement passwordInputFieldBo;

    @FindBy(css = "")
    public WebElement signInButtonBo;

}
