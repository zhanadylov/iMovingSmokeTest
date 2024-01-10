package org.example.ui.pageObjectModel;

import org.example.helper.Helper;
import org.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//div/h1[contains(text(),'Secure Booking')]")
    public WebElement secureBookingText;

    @FindBy(xpath = "//div/p[contains(text(),'Who’s Moving?')]")
    public WebElement whosMovingText;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInputField;

    @FindBy(xpath = "(//input[@id='pass'])[1]")
    public WebElement createPasswordField;

    @FindBy(xpath = "(//input[@id='confPassword'])[1]")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"ccCardName2\"]")
    public WebElement secondCardNameInputField;

    @FindBy(xpath = "//input[@id='ccCardNumber']")
    public WebElement cardNumberInputField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[1]/form[1]/div[3]/div[2]/label")
    public WebElement newCardnumber;


    @FindBy(xpath = "//input[@id='ccCardVerificationNumber']")
    public WebElement cvvNumberInputField;

    //    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div[2]/div[3]/div[1]/form/div[2]/div[7]/div[1]/div/input")
    @FindBy(xpath = "//div[@class='checkbox-updaddr']//input[@ng-model='vm.confirmBillingAddress']")
    public WebElement billingAddressCheckBox;

    @FindBy(xpath = "//div//div[@class='payButtonContainer']//a[contains(normalize-space(.),'Complete Booking')]")
    public WebElement completeBookingButton;

    @FindBy(xpath = "//div[contains(@class,'hidden-xs')]//div[@class='payp-table-row' and contains(normalize-space(.),'Order price')]//div[contains(@class,'bold')][not(normalize-space(.)='')]")
    public WebElement orderPriceValue;

    @FindBy(xpath = "//div[contains(@class,'hidden-xs')]//div[@class='payp-table-row' and contains(normalize-space(.),'Service Fee')]//div[contains(@class,'bold')][not(normalize-space(.)='')]")
    public WebElement serviceFeeValue;

    @FindBy(xpath = "//div[@class='payp-tp test']//strong[contains(@class,'total-price')][not(normalize-space(.)='')]")
    public WebElement totalPriceValue;

    @FindBy(xpath = "//ul[contains(@class,'nav-tabs')]//a[contains(normalize-space(text()),'Split Payment')]")
    public WebElement splitPaymentWithASecondCardButton;

    @FindBy(xpath = "//*[@id=\"ccCardNumber2\"]")
    public WebElement secondCardInputField;

    //    @FindBy(xpath = "//*[@id=\"ccSplitAmount2\"]")
    @FindBy(xpath = "//form[contains(@ng-show,'vm.isSplit')]//input[@name='ccSplitAmount2']")
    public WebElement secondAmountOfSplitInputField;

    @FindBy(xpath = "//*[@id=\"ccExpirationMonth2\"]")
    public WebElement ccExpirationMonth2Select;

    @FindBy(id = "ccExpirationYear2")
    public WebElement ccExpirationYear2Select;

    @FindBy(xpath = "//*[@id=\"ccCardVerificationNumber2\"]")
    public WebElement CVVSecond;

    @FindBy(xpath = "//div[@class='checkbox-updaddr']//input[contains(@ng-model,'confirmBillingAddress2')]")
    public WebElement secondBillingAddressCheckBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/div/div[2]/div[1]/form[1]/div[4]/fieldset[1]/div[2]/span/input")
    public WebElement amountOfSplitFirst;

    @FindBy(xpath = "//div[@class='payment-tab-content']//div[@class='customerProfileContainer row']//label[@ng-show='cp.Active && vm.data.Plan.TotalPrice >= 0']//span[@class='checkmark-radio']")
    public List<WebElement> visaDebitCardCheckBoxList;

    //    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[4]/div[2]/label/input")
    @FindBy(xpath = "//input[@type='radio' and @value=\"0\"]")
    public WebElement newPaymentCard;

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

    @FindBy(xpath = "//input[@id='ccCardName']")
    public WebElement cardNameInputField;

    @FindBy(xpath = "//select[@id='ccExpirationMonth']")
    public WebElement expiryMonthSelectField;

    @FindBy(xpath = "//select[@id='ccExpirationYear']")
    public WebElement expiryYearSelectField;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[4]/div[2]/label[2]/span[1]")
    public WebElement firstCardPayment;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[8]/div[1]/label/span[1]")
    public WebElement secondCardPayment;


    @FindBy(xpath = "/html/body/div/div/div/div[1]/section/div[2]/div[2]/div[1]/form/div[2]/div[8]/div[1]/span/input")
    public WebElement amountOfSplitSecond;


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