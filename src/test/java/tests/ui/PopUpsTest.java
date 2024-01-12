package tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.Helper;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.example.ui.pageObjectModel.PopUpsPage;

public class PopUpsTest {
    PopUpsPage popUpsPage = new PopUpsPage();
    private static final Logger logger = LogManager.getLogger(PopUpsTest.class);

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
            if(Helper.isElementPresent(popUpsPage.TitleTextOuSystemFound)){
                logger.info("Continue order popup appeared and going to click...");
                Helper.navigateToElement(popUpsPage.noButton);
                Helper.click(popUpsPage.noButton);
                logger.info("Continue order popup clicked");
            }
        }catch (NoSuchElementException e){
            logger.info("Continue order popup not appeared!");
        }
    }
}
