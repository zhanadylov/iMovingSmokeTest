package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class GetInventoryValues {
    static WebDriver driver = Driver.getDriver();
    static Random random = new Random();

    public WebElement getItemQuantityInRoomBox(String roomName){
        String stringLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name') and text()='"+roomName+"']]//div[@class='itemsCountBlock']//span[contains(normalize-space(text()),'Items')]";
        WebElement elementLocator = driver.findElement(By.xpath(stringLocator));
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        return elementLocator;
    }
    public void clickOnShowHideButton(String roomName){ //Show/Hide button in FullInventory
        String roomNameLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name') and text()='"+roomName+"']]//div[@class='itemsCountBlock']//*[contains(normalize-space(text()),'Show')]";
        String addPickupLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name')] and .//span[contains(text(),'"+roomName+"')]]//*[contains(normalize-space(text()),'Show')]";
        WebElement elementLocator;
        if(roomName.equals("Additional Pickup")){
            elementLocator = driver.findElement(By.xpath(addPickupLocator));
        }else{
            elementLocator = driver.findElement(By.xpath(roomNameLocator));
        }
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        Helper.click(elementLocator);
    }
    public WebElement getRoomName(String roomName){ //Method to get room name in FullInventory
        String stringLocator = "//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'"+roomName+"')]";
        WebElement elementLocator = driver.findElement(By.xpath(stringLocator));
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        return elementLocator;
    }
    public static String getBoxesQuantity(String getItemName) {//Method to get box quantity in boxes page
        Helper.pause(1000);
        String boxImgLocatorPlusButton = "(//div[@class='flex-center']//img[contains(@title,'" + getItemName + "')]//following::input[contains(@class,'counter') or contains(@class, 'ng-invalid')])[position()<=1]";

        WebElement counterOfBoxes = driver.findElement(By.xpath(boxImgLocatorPlusButton));
        return Helper.getAttributeByValue(counterOfBoxes);
    }
    public static String getRandomItemName(List<WebElement> elements){//Method to get item name by title
        int randomIndex = random.nextInt(elements.size());
        WebElement randomOption = elements.get(randomIndex);
        return randomOption.getAttribute("title");
    }
}
