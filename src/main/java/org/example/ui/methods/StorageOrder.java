package org.example.ui.methods;

import org.example.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import org.example.utilities.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class StorageOrder {
//    private static Logger logger = (Logger) LogManager.getLogger(Helper.class);
    private static final Logger logger = LoggerFactory.getLogger(StorageOrder.class);

    WebDriver driver = Driver.getDriver();

    public void selectRandomValueFromSlider(WebElement slider, int minValue, int maxValue) {
        int randomValue = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
        Actions actions = new Actions(driver);
//        actions.dragAndDropBy(slider, randomValue, 0).build().perform();
        try {
            logger.info("Trying to choose from slider...");
//            actions.moveToElement(slider).perform();
            actions.dragAndDropBy(slider, randomValue, 0).build().perform();
        }catch (JsonException e){
            logger.info("Couldn't choose from slider!");
            System.out.println();
        }
    }
}
