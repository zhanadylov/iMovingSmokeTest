package org.example.helper;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertThat  {


    public static void assertText(String expectedText, WebElement actualElement){
        Helper.waitForElementVisibilityOf(actualElement);
        Assert.assertEquals(Helper.getTextValue(actualElement), expectedText);
    }




}
