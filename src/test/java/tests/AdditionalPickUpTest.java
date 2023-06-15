package tests;

import helper.Helper;
import hooks.Hooks;
import org.testng.annotations.Test;
import ui.methods.PerformActionOnElements;
import ui.methods.SetUp;
import ui.pageObjectModel.HomePage;

public class AdditionalPickUpTest extends Hooks implements SetUp {
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
    HomePage homePage = new HomePage();

    @Test
    public void addAdditionalPickUp(){
        performActionOnElements.setValuesToFillFields("shirley.orn@gmail.com","Sj9QjDXR");
        performActionOnElements.fillCCFieldsElementTest(homePage.SignInButton,homePage.inputEmail, homePage.inputPassword, homePage.loginButtonInSignIn);
        Helper.pause(2000);
        homePage.userNameAfterLogin.isDisplayed();
    }

}
