package ui.qabo.ManualPayment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddPaymentPopUp {
    public AddPaymentPopUp(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"amountToPayAmount\"]")
    public WebElement sumToPay;

    @FindBy(xpath = "//button[text()='Add a Payment']")
    public WebElement addPaymentInBo;

    @FindBy(xpath = "//*[@id='addPaymentBtn']")
    public WebElement addPaymentBtnInPopUp;

    @FindBy(xpath = "//h4[text()='Add Payment:']")
    public WebElement addPaymentPopUpText;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    public WebElement inputSumInPopUp;

    @FindBy(xpath = "//*[@id=\"approveAmount\"]")
    public WebElement approveTheSum;

    @FindBy(xpath = "//*[@id='paymentId']")
    public WebElement paymentId;

    @FindBy(xpath = "//*[@id='customerName']")
    public WebElement nameOnCheck;

    @FindBy(xpath = "//input[@id='customerName']")
    public WebElement nameOnZelle;

    @FindBy(xpath = "//input[@id='authorization']")
    public WebElement zelleAuthNumber;

    @FindBy(xpath = "//*[@id='checkNumber']")
    public WebElement checkNumber;

    @FindBy(xpath = "//*[@id='creditCardNumber']")
    public WebElement ccNumber;

    @FindBy(xpath = "//*[@id='authorization']")
    public WebElement bankAuthNumber;

    @FindBy(xpath = "//*[@id='Details']")
    public WebElement detailsfield;

    @FindBy(xpath = "//*[@id=\"note\"]/div[12]/div/div/span/label")
    public WebElement uploadCheck;

    @FindBy(xpath = "//input[@id='check']")
    public WebElement uploadCheck2;

    @FindBy(xpath = "//*[@id='payType']")
    public WebElement paymentType;
}
