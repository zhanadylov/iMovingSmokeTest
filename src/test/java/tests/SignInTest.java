package tests;

import helper.Helper;
import helper.JavaFaker;
import hooks.Hooks;
import hooks.TestStatusListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.methods.SetUp;
import ui.pageObjectModel.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.getDriver;

@Listeners (TestStatusListener.class)
public class SignInTest extends Hooks implements SetUp{
//    private WebDriver driver;

    HomePage homePage = new HomePage();

//    public SignInTest() {
//    }
//    @BeforeSuite
//    public void openChrome(){
//        driver = getDriver();
//        driver.get(ConfigReader.getProperty("environmentBO"));
//    }
//
//    @AfterSuite
//    public void closeChrome(){
//        Driver.closeDriver(driver);
//    }
    @Test(priority = 1)
    public void loginWithValidData(){
        Helper.click(homePage.SignInButton);
        Helper.pause(2000);
        Helper.sendKeys(homePage.inputEmail, "qatestimoving@gmail.com");
        Helper.sendKeys(homePage.inputPassword, "QATest-2022");
//        homePage.eyeOnSignIn.isDisplayed();
        homePage.forgotPassword.isDisplayed();
        Helper.click(homePage.loginButtonInSignIn);
        Helper.pause(3000);
        Assert.assertTrue(homePage.userNameAfterLogin.getText().contains("Qa Test"));
        Helper.click(homePage.userNameAfterLogin);
        Helper.click(homePage.logOut);
    }

    @Test(priority = 2)
    public void SignUp(){
        Helper.click(homePage.SignInButton);
        Helper.click(homePage.signUpInLoginForm);
        String firstName = JavaFaker.fakeFirstName();
        Helper.sendKeys(homePage.newFirstName, firstName);
        String lastName = JavaFaker.fakeLastName();
        Helper.sendKeys(homePage.newLastName, lastName);
        Helper.sendKeys(homePage.newEmail, JavaFaker.fakeEmail());
        String password = JavaFaker.fakePassword();
        Helper.sendKeys(homePage.newPassword, password);
        Helper.sendKeys(homePage.confirmPassword, password);
        Helper.sendKeys(homePage.phoneNumber, "8003600037");
        Helper.click(homePage.sendMeVerificationButton);
        Helper.sendKeys(homePage.confirmCodeField, "331661584");
        Helper.click(homePage.verifyAndSignUpButton);
        Helper.pause(3000);
        Assert.assertTrue(homePage.userNameAfterLogin.getText().contains(firstName+" "+lastName));
        Helper.click(homePage.userNameAfterLogin);
        Helper.click(homePage.logOut);
    }

    @Test(alwaysRun = false)
    public void forgotPassword(){
        Helper.click(homePage.SignInButton);
        Helper.click(homePage.forgotPassword);
        Assert.assertEquals(homePage.forgotPasswordText.getText(), "Reset your password");
        homePage.sendButtonInReset.isDisplayed();
        homePage.backToLoginButtonInReset.isDisplayed();
        Helper.sendKeys(homePage.emailResetPassword, "qatestimoving@gmail.com");
        Helper.click(homePage.sendButtonInReset);
        Helper.pause(3000);
//        SetUp.refresh();
    }
}
