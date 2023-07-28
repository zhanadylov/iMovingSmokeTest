package hooks;

import helper.Helper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Driver;

import java.io.File;


public class Hooks {

    @BeforeClass
    public static void setUpClass() {
        System.out.println(Helper.ANSI_GREEN + "Before class hook started" + Helper.ANSI_RESET);
        // Здесь можно выполнить подготовительные действия перед всеми тестами класса CreateOrder
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(Helper.ANSI_GREEN + "Before method hook started" + Helper.ANSI_RESET);
        // Здесь можно выполнить подготовительные действия перед каждым тестовым методом
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println(Helper.ANSI_GREEN + "After method hook started" + Helper.ANSI_RESET);
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getMethod().getMethodName();
            FailedScreenshot(testName);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println(Helper.ANSI_GREEN + "After class hook started" + Helper.ANSI_RESET);
        // Здесь можно выполнить завершающие действия после всех тестов класса CreateOrder
    }

    public static void FailedScreenshot(String testName) {
        // Код для сохранения скриншота при возникновении ошибки в тесте
        // ...
        WebDriver driver = Driver.getDriver(); // Получаем экземпляр драйвера, предполагается, что он уже инициализирован

        if (driver instanceof TakesScreenshot) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("F:\\ScreenTest\\" + testName + ".png"));
            } catch (Exception e) {
                System.out.println(Helper.ANSI_YELLOW + "The error happened while cleaning up after the test: "
                        + e.getMessage() + Helper.ANSI_RESET);
            }
        } else {
            System.out.println(Helper.ANSI_YELLOW + "Failed to capture the screenshot. WebDriver does not support screenshots."
                    + Helper.ANSI_RESET);
        }
    }

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