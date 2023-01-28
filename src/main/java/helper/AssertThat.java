package helper;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AssertThat  {


    public static void assertText( String asMessage ,String expectedText, WebElement actualElement){
        Helper.waitForElementVisibilityOf(actualElement);
        Assert.assertEquals("Comparing: " + asMessage + " ",expectedText,Helper.getTextValue(actualElement));
    }




}
