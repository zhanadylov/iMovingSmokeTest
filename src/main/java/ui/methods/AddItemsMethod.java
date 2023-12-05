package ui.methods;

import helper.AddItem;
import helper.GetInventoryValues;
import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui.pageObjectModel.FullInventoryPage;
import ui.pageObjectModel.Full_inventory_Page;
import utilities.Driver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddItemsMethod {
    static WebDriver driver = Driver.getDriver();
    private static Logger logger = (Logger) LogManager.getLogger(Helper.class);
    static FullInventoryPage fullinventory = new FullInventoryPage();

    public static void addItems(List<WebElement> imageElements, int numItems) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement a2ddItemButton = (WebElement) driver.findElements(By.xpath("//div[contains(@class, 'custom-card room-card')]//a[contains(@class, 'icon-plus')]"));
        String addButtonXPath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[INDEX]";

//        for (WebElement image : imageElements) {
        for (int i = 0; i < numItems; i++) {
            WebElement image = imageElements.get(i);
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(image).perform();

                WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                        image.findElement(By.xpath(addButtonXPath.replace("INDEX", String.valueOf(1))))
                ));
                for (int j = 0; j < numItems; j++) {
                    Helper.click(addButton);
                }
                System.out.println("Added " + numItems + " items for image " + image.getAttribute("src"));
            }
            catch (TimeoutException e) {
                System.out.println("Timeout while waiting for Add button in image: " + image.getAttribute("src") + ", " + e.getMessage());
            }
            catch (NoSuchElementException | ElementNotInteractableException e) {
                System.out.println("Unable to add items in image: " + image.getAttribute("src") + ", " + e.getMessage());
            }
        }
    }

    public static void addRandomItemsMethod(List<WebElement> imageElements, int numItems) {
        List<WebElement> addItemButtons = driver.findElements(By.xpath("//div[contains(@class, 'custom-card room-card')]//a[contains(@class, 'icon-plus')]"));
        for (WebElement addItemButton : addItemButtons) {
            addItemButton.click();
            AddItem.hoverOverAndSelectRandomItem(GetInventoryValues.getRandomItemName(imageElements));
            WebElement nextRoomButton = FullInventoryPage.nextRoomButton;
            if(fullinventory.dontHaveCabinetButton.isDisplayed()){
                Helper.click(fullinventory.dontHaveCabinetButton);
            }
            Helper.click(nextRoomButton);
        }
    }
    public static void saveImage(WebElement img){
//        List<WebElement> img = driver.findElements(By.tagName("img"));
        int count = 0;
        URL imageURL = null;
//        for(WebElement image : img)
//        {
            String j = img.getAttribute("src");
            try{
                imageURL = new URL(j);
                BufferedImage images = ImageIO.read(imageURL);
                ImageIO.write(images, "jpg", new File("src/main/java/picture//"+count++ + ".jpg"));
            }catch (IOException e){
                e.printStackTrace();
            }
//        }
    }

}
