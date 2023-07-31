package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Login form
    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")
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

    @FindBy(xpath = "//*[@id=\"userName\"]")
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

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/ul/li[2]/div/div[1]/div[1]/form/div/div[9]/div[1]")
    public WebElement sendMeVerificationButton;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div/div[2]/ul/li[2]/div/div[1]/div[1]/form/div/div[9]/button")
    public WebElement verifyAndSignUpButton;

    //Forgot password
    @FindBy(xpath = "//*[@id=\"mainNavbar\"]/ul[1]/li/div/div/div/div[3]/div")
    public WebElement forgotPasswordText;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[3]/form/div/div[1]/input")
    public WebElement emailResetPassword;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/ul[1]/li/div/div/div/div[3]/form/div/div[3]/button")
    public WebElement sendButtonInReset;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/ul[1]/li/div/div/div/div[3]/form/div/div[4]/a")
    public WebElement backToLoginButtonInReset;

    //Select from dropdown and create
    @FindBy(xpath = "//*[@id=\"index\"]/main/div[1]/section[1]/div/div/ul/li[1]/a")
    public WebElement movingTab;
    @FindBy(xpath = "//*[@id=\"houseTypeSelectList\"]")
    public WebElement moveOptionList;
    @FindBy(xpath = "//*[@id=\"hp-nav-select-house\"]")
    public WebElement sizeOptionList;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement compareQuotes;

}
