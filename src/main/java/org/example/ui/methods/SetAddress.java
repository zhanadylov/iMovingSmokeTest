package org.example.ui.methods;

import org.example.helper.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetAddress {

    public static void testMethod(String address, WebElement element) {
        try{
            List<List<String>> data = new ArrayList<>();
            data.add(Collections.singletonList(address));
//            Helper.javascriptScrollIntoView(element);
            Helper.navigateToElement(element);
            Helper.sendKeys(element, data.get(0).toString());
            Helper.pause(1000);
            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.RETURN);
            Helper.pause(1000);
        }catch (Exception e){
            System.err.println("An error occurred while executing the test: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testMethod2(String address, WebElement element) {
        try{
            List<List<String>> data = new ArrayList<>();
            data.add(Collections.singletonList(address));
            Helper.javascriptScrollIntoView(element);
//            Helper.navigateToElement(element);
            Helper.sendKeys(element, data.get(0).toString());
            Helper.pause(1000);
            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.RETURN);
            Helper.javascriptScrollDownThePage();
            Helper.pause(1000);
        }catch (Exception e){
            System.err.println("An error occurred while executing the test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
