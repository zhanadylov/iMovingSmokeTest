package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UsersQabo {
    public UsersQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body > div > div > section.content-header > h1 > div > a")
    public WebElement usersTitle;

    @FindBy(css = "body > div > div > section.content > p > a")
    public WebElement createNewUserButton;
}
