package tests.ui;

import org.example.helper.Helper;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.example.ui.pageObjectModel.PopUpsPage;

public class PopUpsTest {
    PopUpsPage popUpsPage = new PopUpsPage();
    private static final Logger logger = LoggerFactory.getLogger(PopUpsTest.class);

    @Test(enabled = false)
    public void passPopInSlashOne(){
        if(popUpsPage.gotItButton.isDisplayed()){
            Helper.click(popUpsPage.gotItButton);
            Helper.click(popUpsPage.okButton);
        }else{
            System.out.println("Popups not displayed");
        }
    }

    @Test
    public void continueOrderPopUp(){
        try{
            if(popUpsPage.TitleTextOuSystemFound.isDisplayed()){
                Helper.click(popUpsPage.xButton);
            }else{
                logger.info("Popup not displayed!");
            }
        }catch (NoSuchElementException e){
            logger.info("Popup not appeared!");
        }
    }
}
