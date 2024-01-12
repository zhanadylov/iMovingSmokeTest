package org.example.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DropDownHelper {
    Random random = new Random();
    private static final Logger logger = LogManager.getLogger(DropDownHelper.class);


    public static List<String> list = new ArrayList<>();
    public static void selectUsingVisibleText(WebElement element,String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
    }

    public static void selectUsingVisibleText(List<WebElement> elements, String valueToSelect) {
        for (WebElement element : elements) {
            try{
                if (element.getText().equals(valueToSelect)) {
                    Helper.navigateToElement(element);
                    Helper.click(element);
                }
            }catch (Exception e){
//                e.printStackTrace();
                logger.warn("Couldn't select visible text");
            }
        }
    }

    public static String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        return value;
    }

    public static void selectUsingIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public static List<String> getAllDropDownValues(WebElement locator) {//TODO
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement element : elementList) {
            valueList.add(element.getText());
        }
        return valueList;
    }

    public static void chooseMoveFrom(WebDriver driver, String idName, int indexToSelect) {
        //"expireYear";
        String expirationDateDropDownList = "(//div[contains(@class,'expireMonth')]//ul[@class='dropdown-menu show']//following::li//label[contains(normalize-space(text()),'')])[position()>1 and position()<=13]";
        //addInventory - quickQuote
        String moveFromOption = "(//div[@id='"+idName+"']//ul[@class='dropdown-menu']//following::li//label[contains(normalize-space(text()),'')])[position()<=3]";

        if(idName.equals("addInventory")){
            WebElement itemizedQuoteOpenDropdown = driver.findElement(By.xpath("//a[@id='dLabel2' and contains(text(),'Move From')]"));
            Helper.click(itemizedQuoteOpenDropdown);
            WebElement radioButton = driver.findElements(By.xpath(moveFromOption)).get(indexToSelect);
//            List<WebElement> radioButton = driver.findElements(By.xpath(moveFromOption));
//            selectRandomOptionFromDropDown(radioButton);
            Helper.click(radioButton);
        }else if(idName.equals("quickQuote")){
            WebElement quickQuoteOpenDropdown = driver.findElement(By.xpath("//a[@id='dLabel' and contains(text(),'Move From')]"));
            Helper.click(quickQuoteOpenDropdown);
//            WebElement radioButton = driver.findElements(By.xpath(moveFromOption)).get(indexToSelect);
            List<WebElement> radioButton = driver.findElements(By.xpath(moveFromOption));
            selectRandomOptionFromDropDown(radioButton);
//            Helper.click(radioButton);
        }else if(idName.equals("yy")){
            WebElement expirationDateDropDownButtonLn = driver.findElement(By.xpath("//a[@id='dLabelYear1' and contains(text(),'')]"));
            Helper.click(expirationDateDropDownButtonLn);
            WebElement expirationDateDropDownListLn = driver.findElements(By.xpath(expirationDateDropDownList.replace("expireMonth","expireYear"))).get(indexToSelect);
            Helper.javascriptScrollIntoView(expirationDateDropDownListLn);
            Helper.click(expirationDateDropDownListLn);
        }else{
            WebElement expirationDateDropDownButtonLn = driver.findElement(By.xpath("//a[@id='dLabelMonth1' and contains(text(),'')]"));
            Helper.click(expirationDateDropDownButtonLn);
            WebElement expirationDateDropDownListLn = driver.findElements(By.xpath(expirationDateDropDownList)).get(indexToSelect);
            Helper.javascriptScrollIntoView(expirationDateDropDownListLn);
            Helper.click(expirationDateDropDownListLn);
        }
    }

    public static void chooseMoveSize(WebDriver driver, String addInventory, int indexToSelect) {
        WebElement quickQuoteSizeOpenDropdown = driver.findElement(By.xpath("//a[@id='dLabel1' and contains(text(),'Move Size')]"));
        WebElement itemizedQuoteSizeOpenDropdown = driver.findElement(By.xpath("(//div[@class='col-md-5 col-xs-12']//a[@id='dLabel3' and contains(text(),'Move Size') or contains(text(),'')])[position()=4]"));

        String moveSizeOption = "//div[@id='"+addInventory+"']//ul[@class='dropdown-menu']//following::li//label[normalize-space(text()) and //input[@name='move_size']]";

        if(addInventory.equals("addInventory")){
            Helper.click(itemizedQuoteSizeOpenDropdown);
        }else{
            Helper.click(quickQuoteSizeOpenDropdown);
        }
//        WebElement radioButton = driver.findElements(By.xpath(moveSizeOption)).get(indexToSelect);
        List<WebElement> radioButton = driver.findElements(By.xpath(moveSizeOption));
        selectRandomOptionFromDropDown(radioButton);
//        Helper.click(radioButton);
    }

    public static void selectRandomOptionFromDropDown(List<WebElement> allOptions) {
        int optionsCount = allOptions.size();
        int randomOptionIndex = (int) (Math.random() * optionsCount);
        WebElement randomOption = allOptions.get(0);//TODO
        String randomOptionText = allOptions.get(randomOptionIndex).getText();
        list.add(randomOptionText);
        System.out.println("Option value "+randomOption.getText());
        logger.info("Option value "+randomOption.getText());
        Helper.click(randomOption);
//        String randomOptionText = allOptions.get(randomOptionIndex).getText();
//        list.add(randomOptionText);
    }

    public void getRandomValueFromDropdown(List<WebElement> elements) {
        int randomIndex;
        String checkResult;
        do {
            randomIndex = random.nextInt(elements.size());
            checkResult = elements.get(randomIndex).getText();
        }while (checkResult.contains("+ Add Custom Item"));
        WebElement randomOption = elements.get(randomIndex);
        Helper.click(randomOption);
    }


    public String splitItemName(String fullText){
        String[] words = fullText.split(" ");
        return words[0].replace(",","");
    }
}
