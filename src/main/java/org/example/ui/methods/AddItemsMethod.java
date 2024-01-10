package org.example.ui.methods;

import org.example.helper.AddItem;
import org.example.helper.GetInventoryValues;
import org.example.helper.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.ui.pageObjectModel.FullInventoryPage;
import org.example.utilities.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AddItemsMethod {
    static WebDriver driver = Driver.getDriver();
//    private static Logger logger = (Logger) LogManager.getLogger(Helper.class);
    private static final Logger logger = LoggerFactory.getLogger(AddItemsMethod.class);
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
        List<WebElement> roomNameList = driver.findElements(By.xpath("//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'')]"));

        for (int i = 0; i < roomNameList.size(); i++) {
            WebElement roomName = roomNameList.get(i);
            String roomNameText = roomName.getText();
            System.out.println("Room name " + roomName.getText());
            AddItem.clickOnAddItemButton(roomNameText);
            addItemElements(imageElements, numItems);
            closeAddItemsWindow();
        }

//        for (WebElement roomName : roomNameList) {
//            String roomNameText = roomName.getText();
//            System.out.println("Room name "+roomName.getText());
//            AddItem.clickOnAddItemButton(roomNameText);
//            addItemElements(imageElements, numItems);
//            closeAddItemsWindow();
//        }
    }
    public static void addItemElements(List<WebElement> imageElements, int numItems) {
        for (int i = 0; i < numItems; i++) {
            String itemImg = GetInventoryValues.getRandomItemName(imageElements);
            System.out.println("Adding item: " + itemImg);
            AddItem.hoverOverAndSelectRandomItem(itemImg);
        }
    }
    public static void closeAddItemsWindow() {
        Helper.javascriptScrollIntoView(fullinventory.nextRoomButtonPopup);
        Helper.navigateToElement(fullinventory.nextRoomButtonPopup);
        Helper.click(fullinventory.nextRoomButtonPopup);
        Helper.pause(1000);
        try {
            if (fullinventory.dontHaveCabinetButton.isDisplayed()) {
                Helper.navigateToElement(fullinventory.dontHaveCabinetButton);
                Helper.click(fullinventory.dontHaveCabinetButton);
            } else {
                System.out.println("Did you forget something popup not displayed");
            }
        }catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
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
