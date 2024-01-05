package org.example.hooks;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.example.utilities.Driver;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks implements WebDriverEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebDriver.class);
//    static WebDriver driver = Driver.getDriver();

    @BeforeTest
    public static void setUpDriver() {
//        driver = Driver.getDriver();
//        logger.info("Before test hook started "+driver.getCurrentUrl()+"-"+driver.getTitle());
    }
//    @BeforeMethod
//    public static void setUpMethod() {
//        logger.info("Before method hook started ");
//    }
//    @AfterMethod
//    public void tearDownDriver(ITestResult result) {
//        logger.info("After method hook started and take screenshot if test failed");
////        if (result.getStatus() == ITestResult.FAILURE) {
////            String testName = result.getMethod().getMethodName();
////            FailedScreenshot(testName);
////        }
//    }

    @AfterTest
    public void tearDownDriver() {
//        driver.close();
//        driver.quit();
//        logger.info("After test hook started "+driver.getCurrentUrl()+driver.getTitle());
//        Driver.closeDriver();
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
                        if (isOlderFile(fileName)) {
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

    // Проверяет, старше ли файл чем указанное время
    private static boolean isOlderFile(String fileName) {
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


    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Allure.step("Clicking on " + element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}