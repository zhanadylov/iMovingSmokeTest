package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.email.EmailsData;
import org.example.helper.Helper;
import org.example.helper.JavaFaker;
import org.example.ui.methods.BaseTest;
import org.example.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.ui.pageObjectModel.HomePage;

import java.io.IOException;
//@Listeners(TestListener.class)
@Feature("Sign in/up to web")
public class SignInTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(SignInTest.class);
    private static final Logger logger = LogManager.getLogger(SignInTest.class);

    private static WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();

    public SignInTest(){
        super("environment");
    }
    @Test(priority = 1)
    @Description("Sign in with valid data")
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
    @Description("Sign up to web")
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
        Helper.multipleClick(homePage.verifyAndSignUpButton,2);
        Helper.pause(3000);
        Assert.assertTrue(homePage.userNameAfterLogin.getText().contains(firstName+" "+lastName));
        Helper.click(homePage.userNameAfterLogin);
        Helper.click(homePage.logOut);
    }

    @Test(priority = 2)
    @Description("Check forgot password function")
    public void forgotPassword() throws IOException {
        Helper.click(homePage.SignInButton);
        Helper.click(homePage.forgotPassword);
        Assert.assertEquals(homePage.forgotPasswordText.getText(), "Reset your password");
        homePage.sendButtonInReset.isDisplayed();
        homePage.backToLoginButtonInReset.isDisplayed();
        Helper.sendKeys(homePage.emailResetPassword, "qatestimoving@gmail.com");
        Helper.click(homePage.sendButtonInReset);
        Helper.pause(3000);
        EmailsData.check_email_for_reset_password();
//        SetUp.refresh();
    }
}
