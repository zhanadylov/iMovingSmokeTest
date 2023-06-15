package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AffiliatesQabo {
    public AffiliatesQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body > div.wrapper > div > section.content-header > h1 > div > a")
    public WebElement affiliatesTitle;

    @FindBy(css = "body > div.wrapper > div > section.content > p > a")
    public WebElement createNewAffiliatesButton;

}
