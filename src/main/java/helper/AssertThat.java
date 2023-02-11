package helper;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertThat  {


    public static void assertText( String asMessage ,String expectedText, WebElement actualElement){
        Helper.waitForElementVisibilityOf(actualElement);
        Assert.assertEquals("Comparing: " + asMessage + " ",expectedText,Helper.getTextValue(actualElement));
    }




}
