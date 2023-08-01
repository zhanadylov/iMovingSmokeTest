package ui.pageObjectModel;

import helper.Helper;
import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void signIn(String email, String password) {
        Helper.click(signInButton);
        Helper.sendKeys(emailFieldLogin, email);
        Helper.sendKeys(passwordFieldLogin, password);
        Helper.click(loginButton);
    }

    @FindBy(xpath = "//span[contains(text(),'My inventory')]")
    public WebElement myInventoryLink;
    @FindBy(xpath = "//span[contains(text(),'Trip details')]")
    public WebElement tripDetailsLink;
    @FindBy(xpath = "//span[contains(text(),'My prices')]")
    public WebElement myPricesLink;
    @FindBy(xpath = "//span[contains(text(),'Confirmation')]")
    public WebElement confirmationLink;

//    @FindBy(xpath = "//button[normalize-space()='Login']")
    @FindBy(xpath = "(//button[normalize-space()='Login'])[2]")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@id=\"loginModel_Password\"])[2]")
    public WebElement passwordFieldLogin;

    @FindBy(xpath = "(//*[@id=\"loginModel_Username\"])[2]")
    public WebElement emailFieldLogin;

    @FindBy(xpath = "(//*[@id=\"login\"])[2]")
    public WebElement signInButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[1]/div[2]/div/section/div/h1")
    public WebElement secureBookingText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[4]/div[1]/label[2]/input")
    public WebElement cCRadioButton;

    @FindBy(xpath = "//input[@id='ccFirstName']")
    public WebElement fistNameInputField;

    @FindBy(xpath = "//input[@id='ccLastName']")
    public WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='baPhone']")
    public WebElement phoneInputField;

    @FindBy(xpath = "//input[@id='baSecPhone']")
    public WebElement secondaryPhoneInputField;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInputField;

    @FindBy(xpath = "(//input[@id='pass'])[1]")
    public WebElement createPasswordField;

    @FindBy(xpath = "(//input[@id='confPassword'])[1]")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@id='ccCardName']")
    public WebElement cardNameInputField;

    @FindBy(xpath = "//*[@id=\"ccCardName2\"]")
    public WebElement secondCardNameInputField;

    @FindBy(xpath = "//input[@id='ccCardNumber']")
    public WebElement cardNumberInputField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[1]/form[1]/div[3]/div[2]/label")
    public WebElement newCardnumber;

    @FindBy(xpath = "//select[@id='ccExpirationMonth']")
    public WebElement expiryMonthSelectField;

    @FindBy(xpath = "//select[@id='ccExpirationYear']")
    public WebElement expiryYearSelectField;

    @FindBy(xpath = "//input[@id='ccCardVerificationNumber']")
    public WebElement cvvNumberInputField;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[7]/div[1]/div/input")
    public WebElement billingAddressCheckBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/a")
    public WebElement completeBookingButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]")
    public WebElement orderPriceValue;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]")
    public WebElement serviceFeeValue;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[2]/div/div[2]/div[2]/strong")
    public WebElement totalPriceValue;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[1]/ul/li[2]/a")
    public WebElement splitPaymentWithASecondCardButton;

    @FindBy(xpath = "//*[@id=\"ccCardNumber2\"]")
    public WebElement secondCardInputField;

//    @FindBy(xpath = "//*[@id=\"ccSplitAmount2\"]")
    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[9]/form/fieldset[1]/div[2]/div[2]/span/input")
    public WebElement secondAmountOfSplitInputField;

    @FindBy(id = "ccExpirationYear2")
    public WebElement ccExpirationYear2Select;

    @FindBy(xpath = "//*[@id=\"ccCardVerificationNumber2\"]")
    public WebElement CVVSecond;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[11]/div[1]/div/input")
    public WebElement secondBillingAddressCheckBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[1]/form[1]/div[4]/fieldset[1]/div[2]/span/input")
    public WebElement amountOfSplitFirst;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[4]/div[1]/label[2]/input")
    public WebElement visaDebitCardCheckBox;

    @FindBy(xpath = "(//input[@type='radio' and following-sibling::span[@class='blueText' and text()='New payment card']])[1]")
    public WebElement newPaymentCard;

    //Order Summary
    @FindBy(xpath = "(//div[contains(text(),'Order price')])[2]")
    public WebElement orderPriceLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]")
    public WebElement orderPrice;
    @FindBy(xpath = "(//div[contains(text(),'Service Fee')])[2]")
    public WebElement serviceFeeLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]")
    public WebElement serviceFeePrice;
    @FindBy(xpath = "(//div[contains(text(),'Total Price')])[2]")
    public WebElement totalPriceLabel;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[2]/div[2]/div/div[2]/div[2]/strong")
    public WebElement totalPrice;
}