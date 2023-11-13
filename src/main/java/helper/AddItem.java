package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class AddItem {
    static WebDriver driver = Driver.getDriver();
    static DropDownHelper dropDownHelper = new DropDownHelper();

    public static void clickOnAddItemButton(String roomName){
        String addItemLocator = "//div[contains(@class, 'custom-card room-card') and .//h3[contains(@class, 'room-name') and text()='"+roomName+"']]//a[contains(@class, 'btn-add')]";
        WebElement addItemButton = driver.findElement(By.xpath(addItemLocator));
        Helper.javascriptScrollIntoView(addItemButton);
//        Helper.navigateToElement(addItemButton);
        Helper.click(addItemButton);
    }
    public static void addItemMethod(WebElement elementImg, WebElement elementDropClick, List<WebElement> elementList,WebElement elementClick){
        Helper.navigateToElement(elementImg);
        Helper.click(elementDropClick);
        dropDownHelper.selectRandomOptionFromDropDown(elementList);
        Helper.navigateToElement(elementImg);
        Helper.click(elementClick);
    }

    public static void addItems(List<WebElement> imageElements, int numItems) {//TODO
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String addButtonXPath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[INDEX]";
        String itemsImgLocator = "//div[@ng-show='vm.showItemsView && vm.selectedstatus!=1']//div[@class='flex-center']//img[contains(@title,'')]";

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

    public static void hoverOverAndSelectRandomItem(String getItemName) {
        Helper.pause(1000);
        String itemImgLocatorString = "//div[@class='flex-center']//img[contains(@title,'" + getItemName + "')]";
//        String itemTypeLocator = "//following::div[@class='showItemTypes'])[position()=1]";
        String itemTypeLocator = "//following::div[contains(@class,'dropdown')])[position()=1]";
        String itemPlusButton = "//following::button[contains(text(),'+')])[position()<=1]";

        WebElement hoverElement = driver.findElement(By.xpath(itemImgLocatorString));
        Helper.navigateToElement(hoverElement);

        String combinedLocatorDropdown = "("+itemImgLocatorString + itemTypeLocator;
        String combinedLocatorPlus = "("+itemImgLocatorString + itemPlusButton;

//        boolean hasItemTypeLocator = driver.findElements(By.xpath(itemTypeLocator)).size() > 0;
        boolean hasItemTypeLocator = driver.findElement(By.xpath(combinedLocatorDropdown)).isDisplayed();
        boolean hasItemPlusButton = driver.findElement(By.xpath(combinedLocatorPlus)).isDisplayed();
        if (hasItemTypeLocator) {
            WebElement itemWithItemType = driver.findElement(By.xpath(combinedLocatorDropdown));
            itemWithItemType.click();

//            List<WebElement> dropdownItems = itemWithItemType.findElements(By.xpath("//div[@class='search-results-list']"));
            List<WebElement> dropdownItems = itemWithItemType.findElements(By.xpath("//div[@class='dropdown-menu show']//div[contains(@ng-repeat,'typeAttr.Guid')]"));
            Helper.pause(1000);
            dropDownHelper.selectRandomOptionFromDropDown(dropdownItems);

//            driver.findElement(By.xpath(combinedLocatorPlus)).click();
        } else if (hasItemPlusButton) {
            driver.findElement(By.xpath(combinedLocatorPlus)).click();
        }
    }


    public static void hoverOverAndSelectRandomItem(String getItemName, String givenDropdown) {//Method to choose given item
        String itemImgLocatorString = "//div[@class='flex-center']//img[contains(@title,'" + getItemName + "')]";
        String itemTypeLocator = "//following::div[@class='dropdown '])[position()=1]";
        String itemPlusButton = "//following::button[contains(text(),'+')])[position()<=1]";

        WebElement hoverElement = driver.findElement(By.xpath(itemImgLocatorString));
        Helper.navigateToElement(hoverElement);

        String combinedLocatorDropdown = "("+itemImgLocatorString + itemTypeLocator;
        String combinedLocatorPlus = "("+itemImgLocatorString + itemPlusButton;

        boolean hasItemTypeLocator = driver.findElement(By.xpath(combinedLocatorDropdown)).isDisplayed();
        boolean hasItemPlusButton = driver.findElement(By.xpath(combinedLocatorPlus)).isDisplayed();
        if (hasItemTypeLocator) {
            WebElement itemWithItemType = driver.findElement(By.xpath(combinedLocatorDropdown));
            itemWithItemType.click();

//            List<WebElement> dropdownItems = itemWithItemType.findElements(By.xpath("//div[@class='search-results-list']//following::div[@class='search-result-container']"));
            List<WebElement> dropdownItems = itemWithItemType.findElements(By.xpath("//div[@class='dropdown-menu show']//div[@ng-repeat='typeAttr in item.TypesAttr track by typeAttr.Guid']"));
            DropDownHelper.selectUsingVisibleText(dropdownItems, givenDropdown);

            driver.findElement(By.xpath(combinedLocatorPlus)).click();
        } else if (hasItemPlusButton) {
            driver.findElement(By.xpath(combinedLocatorPlus)).click();
        }
    }


    public static void hoverOverAndAddItem(String getItemName, String getOperator, int counter) {//Method to add or remove item in inventory page
        Helper.pause(1000);
        String boxImgLocatorPlusButton = "(//div[@class='table-responsive']//img[contains(@title,'" + getItemName + "')]//following::button[contains(text(),'"+getOperator+"')])[position()<=1]";

        WebElement clickPlusMinusInBox = driver.findElement(By.xpath(boxImgLocatorPlusButton));
        Helper.javascriptScrollIntoView(clickPlusMinusInBox);
        Helper.multipleClick(clickPlusMinusInBox,counter);
    }


    public static void hoverOverAndAddBoxes(String getItemName, String getOperator, int counter) {//Method to add or remove box in boxes page
        Helper.pause(1000);
        String boxImgLocatorPlusButton = "(//div[@class='flex-center']//img[contains(@title,'" + getItemName + "')]//following::button[contains(text(),'"+getOperator+"')])[position()<=1]";

        WebElement clickPlusMinusInBox = driver.findElement(By.xpath(boxImgLocatorPlusButton));
        Helper.javascriptScrollIntoView(clickPlusMinusInBox);
        Helper.multipleClick(clickPlusMinusInBox,counter);
    }


    public static String getBoxesQuantity(String getItemName) {//Method to get box quantity in boxes page
            Helper.pause(1000);
            String boxImgLocatorPlusButton = "(//div[@class='flex-center']//img[contains(@title,'" + getItemName + "')]//following::input[contains(@class,'counter')])[position()<=1]";

            WebElement counterOfBoxes = driver.findElement(By.xpath(boxImgLocatorPlusButton));
            return Helper.getAttributeByValue(counterOfBoxes);
    }

    public static void hoverOverAndClickMinusPlusManageRooms(String getItemName, String getOperator) {//Method to add or remove item in inventory page
        Helper.pause(1000);
        String boxImgLocatorPlusButton = "(//div[@class='flex-center']//following::figcaption[@title='" + getItemName + "']//following::button[contains(text(),'"+getOperator+"')])[position()=1]";

        WebElement clickPlusMinusInBox = driver.findElement(By.xpath(boxImgLocatorPlusButton));
        Helper.javascriptScrollIntoView(clickPlusMinusInBox);
        Helper.click(clickPlusMinusInBox);
    }
}
