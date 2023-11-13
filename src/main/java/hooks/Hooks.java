package hooks;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Driver;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Hooks extends Driver{
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    static WebDriver driver = Driver.getDriver();

    @BeforeTest
    public static void setUpClass() {
        driver = Driver.getDriver();
        logger.info("Before test hook started "+driver.getCurrentUrl()+"-"+driver.getTitle());
    }
    @BeforeMethod
    public static void setUpMethod() {
        logger.info("Before method hook started ");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.info("After method hook started and take screenshot if test failed");
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getMethod().getMethodName();
            FailedScreenshot(testName);
        }
    }

    @AfterTest
    public void tearDownClass() {
//        driver.close();
//        driver.quit();
        logger.info("After test hook started "+driver.getCurrentUrl()+driver.getTitle());
        Driver.closeDriver();
    }
    public static void FailedScreenshot(String testName) {
        WebDriver driver = Driver.getDriver();

        if (driver instanceof TakesScreenshot) {
            try {
                String screenshotDirectory = "build\\reports\\tests";
                File directory = new File(screenshotDirectory);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Очищаем содержимое каталога перед записью новых скриншотов и удалите старые файлы
                for (File file : directory.listFiles()) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (isOlderThanOneHour(fileName)) {
                            file.delete();
                        }
                    }
                }

                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                String screenshotFileName = testName + "_" + timestamp + ".png";
                File destFile = new File(screenshotDirectory, screenshotFileName);
                FileUtils.copyFile(srcFile, destFile);
                logger.info("Screenshot saved to: " + destFile.getAbsolutePath());
            } catch (Exception e) {
                logger.error("Error occurred while capturing the screenshot: " + e.getMessage());
            }
        } else {
            logger.warn("Failed to capture the screenshot. WebDriver does not support screenshots.");
        }
    }

    // Проверяет, старше ли файл чем 1 час
    private static boolean isOlderThanOneHour(String fileName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        try {
            Date fileDate = dateFormat.parse(fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf(".")));
//            Date oneHourAgo = new Date(System.currentTimeMillis() - 3600 * 1000); // 1 час назад
            Date fiveMinutesAgo = new Date(System.currentTimeMillis() - 5 * 60 * 1000); // 5 минут назад
            return fileDate.before(fiveMinutesAgo);
        } catch (ParseException e) {
            // Если не удается разобрать дату в имени файла, считаем его старым
            return true;
        }
    }
//    public static void FailedScreenshot(String testName) {
//        // Код для сохранения скриншота при возникновении ошибки в тесте
//        driver = Driver.getDriver();
//
//        if (driver instanceof TakesScreenshot) {
//            try {
//                String screenshotDirectory = "build\\reports\\tests";
//                File directory = new File(screenshotDirectory);
//
//                // Убедимся, что каталог существует, и если нет, то создадим его
////                if (!directory.exists()) {
////                    directory.mkdirs();
////                }
//
//                // Очищаем содержимое каталога перед записью новых скриншотов
////                for (File file : directory.listFiles()) {
////                    if (file.isFile()) {
////                        file.delete();
////                    }
////                }
//
//                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                String screenshotFileName = testName + "_" + timestamp + ".png";
//                File destFile = new File(screenshotDirectory, screenshotFileName);
//                FileUtils.copyFile(srcFile, destFile);
//                logger.info("Screenshot saved to: " + destFile.getAbsolutePath());
//            } catch (Exception e) {
//                logger.error("Error occurred while capturing the screenshot: " + e.getMessage());
//            }
//        } else {
//            logger.warn("Failed to capture the screenshot. WebDriver does not support screenshots.");
//        }
//    }

//    public static void FailedScreenshot(String testName) {
//        // Код для сохранения скриншота при возникновении ошибки в тесте
//        WebDriver driver = Driver.getDriver(); // Получаем экземпляр драйвера, предполагается, что он уже инициализирован
//
//        if (driver instanceof TakesScreenshot) {
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
////                FileUtils.copyFile(srcFile, new File("F:\\ScreenTest\\" + testName + ".png"));
//                FileUtils.copyFile(srcFile, new File("build\\reports\\tests" + testName + ".png"));
//            } catch (Exception e) {
//                System.out.println(Helper.ANSI_YELLOW + "The error happened while cleaning up after the test: "
//                        + e.getMessage() + Helper.ANSI_RESET);
//            }
//        } else {
//            System.out.println(Helper.ANSI_YELLOW + "Failed to capture the screenshot. WebDriver does not support screenshots."
//                    + Helper.ANSI_RESET);
//        }
//    }

//    public void setUp() {
//        System.out.println(Helper.ANSI_GREEN+"Before hook started"+Helper.ANSI_RESET);
//    }
//
//
//    public void performAction() {
//        try {
//            // Код выполнения действия
//            // ...
//            // В этом месте добавляем сохранение скриншота после успешного выполнения действия
//            FailedScreenshot("performAction");
//        } catch (Exception e) {
//            // Обработка ошибки
//            // ...
//            // В этом месте тоже сохраняем скриншот при ошибке
//            FailedScreenshot("performAction");
//        }
//    }
//
//    public void clickButton() {
//        try {
//            // Код нажатия кнопки
//            // ...
//            // Сохраняем скриншот после успешного нажатия кнопки
//            FailedScreenshot("clickButton");
//        } catch (Exception e) {
//            // Обработка ошибки
//            // ...
//            // Сохраняем скриншот при ошибке
//            FailedScreenshot("clickButton");
//        }
//    }
//
//    public static void FailedScreenshot(String teatMethodName) {
//        File srcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//
//        try {
//            FileUtils.copyFile(srcFile, new File("F:\\ScreenTest\\" + teatMethodName + ".png"));
//        } catch (Exception e) {
//            System.out.println(
//                    Helper.ANSI_YELLOW + "The error happened while cleaning up after the test: " + e.getMessage()
//                            + Helper.ANSI_RESET);
//        }
//    }
//

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//
//        try {
//            if (result.FAILURE==result.getStatus()) {
////                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
////                result.getName(screenshot, "image/png");
//                TakesScreenshot screenshot=(TakesScreenshot)Driver.getDriver();
//                File src=screenshot.getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(src, new File("F:\\ScreenTest\\test"+result.getName()+".image/png"));
//
//            }
//        } catch (Exception e) {
//            System.out.println(Helper.ANSI_YELLOW+"The error happened while cleaning up after the test: " +
//                    e.getMessage()+Helper.ANSI_RESET);
//        }
//
//        Driver.closeDriver();
//        System.out.println(Helper.ANSI_GREEN+"After hook driver is closed"+Helper.ANSI_RESET);
//    }
}