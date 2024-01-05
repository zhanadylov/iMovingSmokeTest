package tests.ui;

import org.example.helper.Helper;
import org.testng.annotations.Test;
import org.example.ui.pageObjectModel.PopUpsPage;

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
