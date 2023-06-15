package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Success_Page {
    public Success_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String text = "Your payment was successful.\n" +
            "Your order is awaiting carrier confirmation and an\n" +
            "email with your moving details will be sent shortly.";


    @FindBy(css = "#index > main > section > div > div > div.col-md-6.col-sm-6.col-xs-12 > h1")
    public WebElement thankYouText;

    @FindBy(css = "#index > main > section > div > div > div.col-md-6.col-sm-6.col-xs-12 > h2")
    public WebElement customerName;

    @FindBy(css = "#index > main > section > div > div > div.col-md-6.col-sm-6.col-xs-12 > p")
    public WebElement textInSuccessPage;
}
