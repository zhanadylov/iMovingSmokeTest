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

    @FindBy(css = "body > div.wrapper > aside > section > ul > li:nth-child(6) > a")
    public WebElement ordersLabelInSideBar;

    @FindBy(xpath = "")
    public WebElement passwordInputFieldBo;

    @FindBy(css = "")
    public WebElement signInButtonBo;

}
