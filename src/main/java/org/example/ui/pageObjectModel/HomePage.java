package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Login form
    @FindBy(xpath = "//a[@class=\"dropdown-toggle btn btn-blue\"]")
    public WebElement SignInButton;

    @FindBy(xpath = "//*[@id=\"loginModel_Username\"]")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"loginModel_Password\"]")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/button")
    public WebElement loginButtonInSignIn;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/i[1]")
    public WebElement eyeOnSignIn;

    @FindBy(xpath = "//a[@id=\"userName\"]")
    public WebElement userNameAfterLogin;

    @FindBy(xpath = "//span[text()='Log Out']")
    public WebElement logOut;

    //Sign Up form
    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement signUpInLoginForm;

    @FindBy(xpath = "//input[@class='form-control first-name-signUp' and @name='gg.Name']")
    public WebElement newFirstName;

    @FindBy(xpath = "//input[@class='form-control last-name-signUp' and @name='gg.LastName']")
    public WebElement newLastName;

    @FindBy(xpath = "//input[@class='form-control email email-signUp' and @name='gg.Email']")
    public WebElement newEmail;

    @FindBy(xpath = "//input[@class='form-control password-signUp' and @name='gg.Password']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@class='form-control confirm-password-signUp' and @name='gg.ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@class='form-control phone phone-signUp' and @name='gg.Phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@class='form-control phone-verifyCode-signUp' and @name='gg.PhoneVerifyCode']")
    public WebElement confirmCodeField;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/div/div[1]/div[1]/form/div/div[9]/div[1]")
    public WebElement sendMeVerificationButton;

    @FindBy(xpath = "//button[contains(@class,'signUpButton')]")
    public WebElement verifyAndSignUpButton;

    //Forgot password
    @FindBy(xpath = "//p[contains(text(),'Reset your password')]")
    public WebElement forgotPasswordText;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/ul/li[2]/div/div[2]/form/div/input")
    public WebElement emailResetPassword;

    @FindBy(xpath = "//button[contains(text(),'Send')]")
    public WebElement sendButtonInReset;

    @FindBy(xpath = "//a[contains(text(),'Back to login')]")
    public WebElement backToLoginButtonInReset;

    //Select from dropdown and create
    @FindBy(xpath = "//*[@id=\"index\"]/main/div[1]/section[1]/div/div/ul/li[1]/a")
    public WebElement movingTab;
//    @FindBy(xpath = "//*[@id=\"houseTypeSelectList\"]")
    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[1]/div/select")
    public WebElement moveOptionList;
//    @FindBy(xpath = "//*[@id=\"hp-nav-select-house\"]")
    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[2]/div/select")
    public WebElement sizeOptionList;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement compareQuotes;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"loginModel_Username\"]")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginModel_Password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "(//*[@id=\"loginForm\"]/div/div[2]/i)[2]")
    public WebElement passwordEyeButton;

    @FindBy(xpath = "//*[@id=\"userName\"]")
    public WebElement userNameButton;

    @FindBy(xpath = "//*[@id=\"userMenuContainer\"]/ul[2]/li[3]/form/fieldset/button")
    public WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"index\"]/header/nav/div/div[1]/a/img")
    public WebElement iMovingLogo;

    @FindBy(xpath = "//a[contains(text(),'Itemized Quote')]")
    public WebElement itemizedQuoteButtonHomePage;
    @FindBy(xpath = "//p[contains(text(),'5-Minute Process Can Save You ')]")
    public WebElement titleTextFullQuoteButtonHomePage;
    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[2]/div/button")
    public WebElement moveSizeListForClick;

    //    @FindBy(xpath = "/html/body/div[2]/div/main/section[1]/figure/div/div/div[2]/div[1]/form/div[2]/div/select")
//    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[2]/div/select")
    @FindBy(xpath = "(//select[@id='hp-nav-select-house'])[2]")
    public  WebElement moveSizeList;

    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[2]/form/div/div[1]/div/a")
    public WebElement moveSizeMyApartment;

    //    @FindBy(id = "houseTypeSelectList")
    @FindBy(xpath = "(//select[@id='houseTypeSelectList'])[2]")
    public WebElement houseTypeSelectList;

    //    @FindBy(xpath = "//div[@id='addInventory']//ul[@class='dropdown-menu']//input[@name='move_from']")
    @FindBy(xpath = "(//div[@id='addInventory']//ul[@class='dropdown-menu']//following::li//label[contains(normalize-space(text()),'')])[position()<=3]")
    public WebElement moveSizeDropDownList;
    @FindBy(xpath = "(//select[@id='houseTypeSelectList'])[1]")
    public WebElement quickQuoteTypeSelectList;

    @FindBy(xpath = "//*[@id=\"quickQuote\"]/p")
    public WebElement findMoversText;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]")
    public WebElement failedLoginText;

    @FindBy(xpath = "//*[@id=\"index\"]/main/div[1]/section[1]/div/div/ul/li[2]/a")
    public WebElement laborTab;

    @FindBy(xpath = "//div[@id='addInventory']//div//a[contains(normalize-space(text()),'Move From')]")
    public WebElement moveFromSearchDropDownMenu;

    @FindBy(xpath = "//div[@id='addInventory']//div//a[contains(normalize-space(text()),'Move Size')]")
    public WebElement moveSizeDropdownMenu;

    @FindBy(xpath = "//button[contains(text(),'Add Items')]")
    public WebElement addItemsButton;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement continueButton;
    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[1]/div/div/ul/li[2]/a")
    public WebElement myHouse;

    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section[1]/div/div/div/div[1]/div/div[1]/div/form/div/div[2]/div/div/ul/li[2]/a/span[1]")
    public WebElement just_A_FewItems;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/a")
    public WebElement needHelpContactUs24_7Link;

    @FindBy(id = "#dLabel3")
    public WebElement moveSizeSelectValues;

    @FindBy(id = "movingFrom")
    public WebElement enterAddressField;

    @FindBy(xpath = "//*[@id=\"sendPhonePhone\"]")
    public WebElement moveDateField;

    @FindBy(xpath = "//a[contains(text(),'Quick Quote')]")
    public WebElement searchFullServiceMovers;

    @FindBy(xpath = "//*[@id=\"goToOrderProcessModal-label\"]")
    public WebElement ourSystemFoundOrderInProcess;

    @FindBy(xpath = "//*[@id=\"goToOrderProcessModal\"]/div/div/div[2]/p")
    public WebElement doYouWantToContinueTheOrderProcess;

    @FindBy(xpath = "//*[@id=\"notGoToInventory\"]")
    public WebElement noButton;

    @FindBy(xpath = "//*[@id=\"goToInventory\"]")
    public WebElement yesButton;

    @FindBy(id = "hp-nav-select-house")
    public WebElement selectMyStorageByVisibleText;

    @FindBy(id = "notGoToInventory")
    public WebElement notGoToInventoryButton;

    //Forgot password popup
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/p/a")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id=\"mainNavbar\"]/div[2]/div/div/div/div[3]/div")
    public WebElement resetYourPasswordText;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    public WebElement resetPasswordInputEmailField;

    @FindBy(xpath = "//*[@id=\"resetPasswordForm\"]/div/button")
    public WebElement resetSendButton;

    @FindBy(xpath = "//*[@id=\"resetPasswordForm\"]/div/a")
    public WebElement resetBackToLoginButton;
}
