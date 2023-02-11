package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Login form
    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/button[1]")
    public WebElement SignInButton;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/header[1]/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    public WebElement inputEmail;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[2]/form[1]/div/div[2]/input[1]")
    public WebElement inputPassword;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[5]/button[1]")
    public WebElement loginButtonInSignIn;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/a[1]")
    public WebElement forgotPassword;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/i[1]")
    public WebElement eyeOnSignIn;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/ul[2]/li[1]/a[1]")
    public WebElement userNameAfterLogin;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/ul[2]/li/div/ul[2]/li[3]/form/fieldset/button/span")
    public WebElement logOut;

    //Sign Up form
    @FindBy(xpath = "//*[@id=\"mainNavbar\"]/div[2]/div/div/div/ul/li[2]")
    public WebElement signUpInLoginForm;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[1]/input")
    public WebElement newFirstName;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[2]/input")
    public WebElement newLastName;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[3]/input[1]")
    public WebElement newEmail;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[4]/input")
    public WebElement newPassword;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[5]/input")
    public WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div[2]/div/header/nav/div/div[2]/div[2]/div/div/div/div[1]/form[1]/div/div[6]/input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/input[1]")
    public WebElement confirmCodeField;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]")
    public WebElement sendMeVerificationButton;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/button[1]")
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
}
