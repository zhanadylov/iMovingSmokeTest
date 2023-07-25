package tests;

import helper.Helper;
import org.testng.annotations.Test;
import ui.pageObjectModel.PopUpsPage;

public class PopUpsTest {
    PopUpsPage popUpsPage = new PopUpsPage();

    @Test(enabled = false)
    public void passPopInSlashOne(){
        if(popUpsPage.gotItButton.isDisplayed()){
            Helper.click(popUpsPage.gotItButton);
            Helper.click(popUpsPage.okButton);
        }else{
            System.out.println("Popups not displayed");
        }
    }
}
