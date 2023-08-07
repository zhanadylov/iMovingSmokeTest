package ui.methods;

import helper.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ui.methods.SetUp.driver;


public class SelectRandom {
    private static final Logger logger = (Logger) LogManager.getLogger(Helper.class);
    static Random random = new Random();

    public List<String> list = new ArrayList<>();

    //Random Dropdown Choose
    public void selectRandomOptionFromDropDown(WebElement element) {
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        int optionsCount = allOptions.size();
        int randomOptionIndex = (int) (Math.random() * optionsCount);
        String randomOptionText = allOptions.get(randomOptionIndex).getText();
        select.selectByIndex(randomOptionIndex);
        list.add(randomOptionText);

        if (list.contains("Move From") || list.contains("Move Size")) {
            list.remove(randomOptionText); // remove the current option from the list
            selectRandomOptionFromDropDown(element); // call the method again
        }
    }

    //Random Dropdown Choose Old
    public void getOptionFromDropDown(WebElement element){
        Random ran = new Random();
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        int num = 0;
        String firstOption = null;
        for(int i =1; i < allOptions.size();i++){
            num = ran.nextInt(i);
            Helper.pause(2000);
            firstOption = (allOptions.get(num).getText());
            allOptions.get(num).click();
        }
        selectUsingVisibleText(element, firstOption);
//        list.add(firstOption);
    }

    //Dropdown Helper
    public void selectUsingVisibleText(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
//        list.add(visibleText);
    }

    //Random select from selector
    public static void SelectHomePage(WebElement element, int cssSelector){
        Select select = new Select(element);
        int index = random.nextInt(cssSelector);
        select.selectByIndex(index);
    }

    //Random click Checkbox
//    public void clickOnRandomCheckBox(List<WebElement> element)
//    {
//        int index = random.nextInt(element.size());
//        if(!element.get(index).isSelected())
//        {
//            Helper.javascriptScrollIntoView(element.get(index));
//            element.get(index).click();
//        }
//    }

    public void clickOnRandomRadioButton(List<WebElement> radioButtons) {
        int index = random.nextInt(radioButtons.size());
        WebElement radioButton = radioButtons.get(index);

        if (!radioButton.isSelected()) {
            Helper.javascriptScrollIntoView(radioButton);

            if (radioButton.isDisplayed()) {
                radioButton.click();
            } else {
                // Perform scrolling or other actions to make the element visible
                // and then retry the click.
            }
        }
    }

    //Method for random select from div in form
//    public void randomRadioSelectionFromForm(List<WebElement> radioButtons){
//        int randomIndex = random.nextInt(radioButtons.size());
//        radioButtons.get(randomIndex).click();
//    }

    public void randomRadioSelectionFromForm(List<WebElement> radioButtons) {
        Random random = new Random();
        int randomIndex = random.nextInt(radioButtons.size());
        WebElement elementToClick = radioButtons.get(randomIndex);

        // Scroll the element into view if necessary
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToClick);

        // Use JavaScript click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
    }

    //Save Image
    public void saveImage(List<WebElement> img){
//        List<WebElement> img = driver.findElements(By.tagName("img"));
        int count = 0;
        URL imageURL = null;
        for(WebElement image : img)
        {
            String j = image.getAttribute("src");
            try{
                imageURL = new URL(j);
                BufferedImage images = ImageIO.read(imageURL);
                ImageIO.write(images, "jpg", new File("src/main/java/picture//"+count++ + ".jpg"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
