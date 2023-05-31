package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div/div[1]")
    public WebElement iMovingManagementText;

    @FindBy(css = "#Email")
    public WebElement emailInputFieldBo;

    @FindBy(css = "#Password")
    public WebElement passwordInputFieldBo;

    @FindBy(css = "body > div > div.login-box-body > form > div:nth-child(4) > div:nth-child(2) > button")
    public WebElement signInButtonBo;

}
