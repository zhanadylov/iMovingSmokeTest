package ui.methods;

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
import utilities.Driver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AddItemsMethod {
    static WebDriver driver = Driver.getDriver();
    private static Logger logger = (Logger) LogManager.getLogger(Helper.class);


    public static void addRandomItemsToAllImages5(List<WebElement> imageElements) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String xpath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[";
        for (WebElement image : imageElements) {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(image).perform();
                int clickCount = random.nextInt(1, 6);
                final String s = xpath + clickCount + "]";
                System.out.println(clickCount);
                System.out.println(s);
                WebElement addButton = image.findElement(By.xpath(s));
                System.out.println("Clicking add button " + clickCount + " times for image " + image.getAttribute("src"));
                for (int i = 0; i < clickCount; i++) {
                    addButton.click();
                }
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                System.out.println("Unable to add item to image: " + image.getAttribute("src") + ", " + e.getMessage());
            }
        }
    }

    public static void addRandomItemsToAllImages6(List<WebElement> imageElements) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Random random = new Random();
        String xpath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[INDEX]";
        for (int i = 0; i <= 5; i++) {
            WebElement image = imageElements.get(i);
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(image).perform();
//                int index = random.nextInt(imageElements.size()) + 1;

                String xpathWithIndex = xpath.replace("INDEX", String.valueOf(i));
                WebElement addButton = image.findElement(By.xpath(xpathWithIndex));
                    addButton.click();
                System.out.println("Added " + i + " items for image " + image.getAttribute("src")+xpathWithIndex);
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                System.out.println("Unable to add items to image: " + image.getAttribute("src") + ", " + e.getMessage());
            }
        }
    }

    public static void addItems(List<WebElement> imageElements, int numItems) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
