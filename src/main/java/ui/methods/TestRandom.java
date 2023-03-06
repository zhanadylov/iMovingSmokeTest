package ui.methods;

import helper.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}
