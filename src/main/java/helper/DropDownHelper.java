package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DropDownHelper {
    Random random = new Random();


    public List<String> list = new ArrayList<>();
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
                e.printStackTrace();
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
    public static List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement element : elementList) {
            valueList.add(element.getText());
        }
        return valueList;
    }

    public void selectRandomOptionFromDropDown(List<WebElement> allOptions) {
//        allOptions.removeIf(option -> option.getText().equals("Select Type"));

        int optionsCount = allOptions.size();
        int randomOptionIndex = (int) (Math.random() * optionsCount);
        WebElement randomOption = allOptions.get(randomOptionIndex);

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

    public String getRandomItemName(List<WebElement> elements){
        int randomIndex = random.nextInt(elements.size());
        WebElement randomOption = elements.get(randomIndex);
        return randomOption.getAttribute("title");
    }

    public String splitItemName(String fullText){
        String[] words = fullText.split(" ");
        return words[0].replace(",","");
    }
}
