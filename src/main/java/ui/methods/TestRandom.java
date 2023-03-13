package ui.methods;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class TestRandom {
    static WebDriver driver = Driver.getDriver();
    private static Logger logger = (Logger) LogManager.getLogger(Helper.class);

    //    public void addRandomItemsFromDropdowns(WebDriver driver) {
//        // Находим все элементы с картинками
//        List<WebElement> imageElements = driver.findElements(By.cssSelector(".item-image"));
//
//        // Для каждого элемента с картинкой
//        for (WebElement imageElement : imageElements) {
//            // Создаем объект Actions для наведения на картинку
//            Actions actions = new Actions(driver);
//            actions.moveToElement(imageElement).build().perform();
//
//            // Находим кнопку "Добавить" и список элементов в дропдауне
//            WebElement addButton = driver.findElement(By.cssSelector(".add-button"));
//            List<WebElement> dropdownItems = driver.findElements(By.cssSelector(".dropdown-item"));
//
//            // Выбираем случайный элемент из дропдауна
//            Random random = new Random();
//            int randomIndex = random.nextInt(dropdownItems.size());
//            WebElement selectedItem = dropdownItems.get(randomIndex);
//
//            // Нажимаем кнопку "Добавить" и выбранный элемент из дропдауна
//            addButton.click();
//            selectedItem.click();
//        }
//    }

    public void addRandomItemsFromDropdowns(List<WebElement> imageElements, List<WebElement> dropdownTypeInElement, WebElement addButton) {
        // Находим все элементы с картинками
//        List<WebElement> imageElements = driver.findElements(By.cssSelector(".item-image"));

        // Для каждого элемента с картинкой
        for (WebElement imageElement : imageElements) {
            logger.info("Start loop");
            // Создаем объект Actions для наведения на картинку
            Actions actions = new Actions(driver);
            actions.moveToElement(imageElement).build().perform();
//            logger.info("Создаем объект Actions для наведения на картинку");
            // Находим кнопку "Добавить" и список элементов в дропдауне
//            WebElement addButton = driver.findElement(By.cssSelector(".add-button"));
//            List<WebElement> dropdownItems = driver.findElements(By.cssSelector(".dropdown-item"));

            // Выбираем случайный элемент из дропдауна
//            Random random = new Random();
//            int randomIndex = random.nextInt(dropdownTypeInElement.size());
            logger.info("Выбираем случайный элемент из дропдауна");
//            System.out.println("randomIndex "+randomIndex);
//            WebElement selectedItem = dropdownTypeInElement.get(randomIndex);
            logger.info("Выбираем случайный элемент из дропдауна 2");
//            System.out.println("selectedItem "+selectedItem.getText());
            // Нажимаем кнопку "Добавить" и выбранный элемент из дропдауна
            logger.info("Нажимаем кнопку \"Добавить\" и выбранный элемент из дропдауна");
//            selectedItem.click();
//            addButton.click();
            System.out.println(imageElement);
        }
    }


    public void selectRandomImage(List<WebElement> images, List<WebElement> dropdownTypeInElement, WebElement addButton) {
        // Находим все элементы с картинками на странице
//        List<WebElement> images = driver.findElements(By.tagName("img"));

        for (int i = 1; i < 4; i++) {
            // Выбираем случайную картинку из списка
            Random rand = new Random();
            int num = rand.nextInt(images.size());
//            WebElement randomImage = images.get(rand.nextInt(images.size()));
            WebElement randomImage = images.get(num);
            System.out.println("sdfsdfdsf" + num);
            if (num == 0) {
                num = rand.nextInt(images.size());
                Actions actions = new Actions(driver);
                actions.moveToElement(randomImage).perform();
                WebElement addButtonn = driver.findElement(By.cssSelector("div[class='" + num + "'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']"));
                System.out.println(addButtonn);
                Helper.click(addButtonn);
            } else {
                Actions actions = new Actions(driver);
                actions.moveToElement(randomImage).perform();
                WebElement addButtonn = driver.findElement(By.cssSelector("div[class='" + num + "'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']"));
                System.out.println(addButtonn);
                Helper.click(addButtonn);
            }
            // Наводим курсор мыши на картинку, чтобы появилась кнопка "Добавить"
//            Actions actions = new Actions(driver);
//            actions.moveToElement(randomImage).perform();
//            WebElement addButtonn = driver.findElement(By.cssSelector("div[class='"+num+"'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']"));
//            System.out.println(addButtonn);
//            Helper.click(addButtonn);
//            addButtonn.click();
        }

        // Ждем, пока кнопка "Добавить" появится
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add-button")));

        // Если у выбранной картинки есть дропдаун, то выбираем случайный вариант из списка
//        if (addButton.getAttribute("data-dropdown") != null) {
//            addButton.click();
//            List<WebElement> dropdownItems = driver.findElements(By.xpath("//div[@class='dropdown']//li"));
//            WebElement randomDropdownItem = dropdownTypeInElement.get(rand.nextInt(dropdownTypeInElement.size()));
//            randomDropdownItem.click();
//        } else {
        // Иначе просто нажимаем на кнопку "Добавить"
//            addButton.click();
//        }
    }

    public static void addRandomImages(List<WebElement> imageElements, List<WebElement> dropdownTypeInElement, WebElement addButton) {
        // Найти все элементы, содержащие изображения и названия
//        List<WebElement> imageElements = driver.findElements(By.cssSelector(".image-container"));

        // Создать список доступных изображений, начиная с изображений на виду
        List<WebElement> availableImages = new ArrayList<>();
        for (WebElement imageElement : imageElements) {
            availableImages.add(imageElement);
        }

        // Перейти к каждому доступному изображению и добавить его
        for (int i = 0; i < availableImages.size(); i++) {
            // Выбрать случайное доступное изображение для добавления
            WebElement selectedImage = availableImages.get(new Random().nextInt(availableImages.size()));

            // Навести курсор на выбранное изображение для отображения дропдауна, если он есть
            Actions actions = new Actions(driver);
            actions.moveToElement(selectedImage).perform();

            // Если появляется дропдаун-меню, выберите случайный элемент из меню и нажмите кнопку "Добавить"
//            List<WebElement> dropdownItems = selectedImage.findElements(By.cssSelector(".dropdown-menu .dropdown-item"));
            if (!dropdownTypeInElement.isEmpty()) {
                WebElement selectedItem = dropdownTypeInElement.get(new Random().nextInt(dropdownTypeInElement.size()));
                selectedItem.click();
                selectedImage.findElement(By.cssSelector(String.valueOf(addButton))).click();
            } else {
                // Если дропдаун-меню не появляется, просто нажмите кнопку "Добавить" на основном изображении
                selectedImage.findElement(By.cssSelector(String.valueOf(addButton))).click();
            }

            // Уберите выбранное изображение из списка доступных изображений
            availableImages.remove(selectedImage);
        }
    }

    public static void addRandomImagestest(List<WebElement> imageElements, List<WebElement> dropdownTypeInElement) {
        // Найти все элементы, содержащие изображения и названия
        WebElement selectedItem = null;
        WebElement addButton;
        // Перейти к каждому доступному изображению и добавить его
        for (int i = 0; i < imageElements.size(); i++) {
            // Выбрать случайное доступное изображение для добавления
            int count = new Random().nextInt(imageElements.size());
//            WebElement selectedImage = imageElements.get(new Random().nextInt(imageElements.size()));
            WebElement selectedImage = imageElements.get(count);

            // Навести курсор на выбранное изображение для отображения дропдауна, если он есть
            Actions actions = new Actions(driver);
            actions.moveToElement(selectedImage).perform();

            // Если появляется дропдаун-меню, выберите случайный элемент из меню и нажмите кнопку "Добавить"
//            List<WebElement> dropdownItems = selectedImage.findElements(By.cssSelector(".dropdown-menu .dropdown-item"));
            if (!dropdownTypeInElement.isEmpty()) {
                selectedItem = dropdownTypeInElement.get(new Random().nextInt(dropdownTypeInElement.size()));
                Helper.click(selectedItem);
//                selectedImage.findElement(By.cssSelector(String.valueOf(addButton))).click();
//                addButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/main/div/div[1]/section/div[2]/div/div["+count+"]/div/div/figure/div[2]/div[4]/div/a[1]"));
//                System.out.println("button is "+addButton);
//                Helper.click(addButton);
            } else {
                // Если дропдаун-меню не появляется, просто нажмите кнопку "Добавить" на основном изображении
//                addButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/main/div/div[1]/section/div[2]/div/div["+count+"]/div/div/figure/div[2]/div[4]/div/a[1]"));
//                System.out.println("else is "+addButton);
//                Helper.click(addButton);
//                selectedImage.findElement(By.cssSelector(String.valueOf(addButton))).click();
            }

            // Уберите выбранное изображение из списка доступных изображений
//            availableImages.remove(selectedImage);
        }
    }

    public static void addRandomImagesTest(List<WebElement> imageElements, WebElement addButton) {
        for (WebElement image : imageElements) {
            Actions actions = new Actions(driver);
            actions.moveToElement(image).build().perform();

//            WebElement addButton = image.findElement(By.xpath("./following-sibling::button[contains(@class, 'add-button')]"));
            addButton.click();
        }
    }

    public static void addRandomItemsToAllImages(List<WebElement> imageElements) {
//        List<WebElement> images = driver.findElements(By.xpath("//img"));
        Random random = new Random();
        String xpath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[";
        for (WebElement image : imageElements) {
            Actions actions = new Actions(driver);
            actions.moveToElement(image).build().perform();
            saveImage(image);
            int count = random.nextInt(imageElements.size());
            final String s = xpath + count + "]";
            WebElement addButton = image.findElement(By.xpath(s));
            System.out.println(count);
            System.out.println(s);
            for (int i = 0; i < 5; i++) {
                addButton.click();
            }
        }
    }

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

    public static void addRandomItemsToAllImages6(List<WebElement> imageElements, int numberOfItems) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Random random = new Random();
        String xpath = "(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[INDEX";
        for (int i = 0; i < 5; i++) {
            WebElement image = imageElements.get(i);
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(image).perform();
                int index = random.nextInt(imageElements.size()) + 1;
                String xpathWithIndex = xpath.replace("INDEX", String.valueOf(index));
                WebElement addButton = image.findElement(By.xpath(xpathWithIndex));
                for (int j = 0; j < numberOfItems; j++) {
                    addButton.click();
                }
                System.out.println("Added " + numberOfItems + " items for image " + image.getAttribute("src")+xpathWithIndex);
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                System.out.println("Unable to add items to image: " + image.getAttribute("src") + ", " + e.getMessage());
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
