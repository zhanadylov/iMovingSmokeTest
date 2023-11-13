package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class GetInventoryValues {
    static WebDriver driver = Driver.getDriver();

    public WebElement getItemQuantityInRoomBox(String roomName){
        String stringLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name') and text()='"+roomName+"']]//div[@class='itemsCountBlock']//span[contains(normalize-space(text()),'Items')]";
        WebElement elementLocator = driver.findElement(By.xpath(stringLocator));
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        return elementLocator;
    }
    public void clickOnShowHideButton(String roomName){
        String stringLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name') and text()='"+roomName+"']]//div[@class='itemsCountBlock']//*[contains(normalize-space(text()),'Show')]";
        WebElement elementLocator = driver.findElement(By.xpath(stringLocator));
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        Helper.click(elementLocator);
    }
    public WebElement getRoomName(String roomName){
        String stringLocator = "//div[contains(normalize-space(@class),'room-box')]//h3[contains(normalize-space(text()),'"+roomName+"')]";
        WebElement elementLocator = driver.findElement(By.xpath(stringLocator));
        Helper.javascriptScrollIntoView(elementLocator);
        Helper.navigateToElement(elementLocator);
        return elementLocator;
    }
}
