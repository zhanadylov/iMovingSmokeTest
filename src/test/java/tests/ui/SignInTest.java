package tests.ui;

import io.cucumber.java.Before;
import org.example.email.EmailForResetPasswordTest;
import org.example.helper.Helper;
import org.example.helper.JavaFaker;
import org.example.hooks.TestListener;
import org.example.utilities.ConfigReader;
import org.example.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.ui.pageObjectModel.HomePage;

import java.io.IOException;
@Listeners(TestListener.class)
public class SignInTest{
    private static final Logger logger = LoggerFactory.getLogger(SignInTest.class);
    private static WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();

    @BeforeClass
    public void setUp(){
            if (driver == null) {
                logger.info("Trying to open browser and url in openChromeSingIN");
                driver = Driver.getDriver();
                driver.get(ConfigReader.getProperty("environment"));
            }else{
                driver.get(ConfigReader.getProperty("environment"));
            }
    }

//    @AfterClass
//    public void tearDown() {
//        logger.info("Closing driver after method CreateOrderTest started "+driver.getCurrentUrl()+driver.getTitle());
//        Driver.closeDriver();
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
        Helper.multipleClick(homePage.verifyAndSignUpButton,2);
        Helper.pause(3000);
        Assert.assertTrue(homePage.userNameAfterLogin.getText().contains(firstName+" "+lastName));
        Helper.click(homePage.userNameAfterLogin);
        Helper.click(homePage.logOut);
    }

//    @Test(priority = 2)
    public void forgotPassword() throws IOException {
        Helper.click(homePage.SignInButton);
        Helper.click(homePage.forgotPassword);
        Assert.assertEquals(homePage.forgotPasswordText.getText(), "Reset your password");
        homePage.sendButtonInReset.isDisplayed();
        homePage.backToLoginButtonInReset.isDisplayed();
        Helper.sendKeys(homePage.emailResetPassword, "qatestimoving@gmail.com");
        Helper.click(homePage.sendButtonInReset);
        Helper.pause(3000);
        EmailForResetPasswordTest.check_email_for_reset_password();
//        SetUp.refresh();
    }
}
