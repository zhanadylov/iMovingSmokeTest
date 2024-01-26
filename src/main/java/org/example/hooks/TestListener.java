package org.example.hooks;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.AlertHelper;
import org.example.ui.methods.BaseTest;
import org.example.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class TestListener extends BaseTest implements ITestListener{
    private static final Logger logger = LogManager.getLogger(WebDriver.class);
//    static WebDriver driver = Driver.getDriver();
    AlertHelper alertHelper = new AlertHelper(driver);

    private int count = 1;
    private int maxCount = 2;
    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
    private void captureScreenshotAndLogs(ITestResult result) {
        Allure.getLifecycle().addAttachment("Screenshot on test step", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Logs: ",
                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
    }

//    @Override
//    public boolean retry(ITestResult iTestResult) {
//        if(!iTestResult.isSuccess()){
//            if(count<maxCount) {
//                count++;
////                driver.navigate().refresh();
//                driver.manage().deleteAllCookies();
////                clearStorage("sessionStorage");
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Test suit started "+ iTestContext.getName());
        ITestListener.super.onStart(iTestContext);
//            for (ITestNGMethod method : iTestContext.getAllTestMethods()) {
//                method.setRetryAnalyzerClass(TestListener.class);
//            }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ITestListener.super.onTestStart(iTestResult);
        Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        logger.info("Test started "+ iTestResult.getMethod());
//        driver.manage().deleteAllCookies();
        Annotation[] annotations = method.getAnnotations();
        logger.info("Annotations for test method {}:", method.getName());
        alertHelper.DismissAlertIfPresent();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.debug("Test failed: "+result.getName());
//        driver.manage().deleteAllCookies();
        Allure.getLifecycle().addAttachment("Screenshot on failed step: ", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Logs: ",
                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
//        driver.close();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.warn("Test Skipped: " + getTestMethodName(iTestResult));
//        driver.manage().deleteAllCookies();
        Allure.getLifecycle().addAttachment("Screenshot on skipped step", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Logs: ",
                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(iTestResult);
        logger.warn("Test failed but withing success percentage: "+iTestResult.getTestName());
//        driver.manage().deleteAllCookies();
        Allure.getLifecycle().addAttachment("Screenshot on FailedButWithinSuccessPercentage step", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Logs: ",
                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
//        driver.close();
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        ITestListener.super.onFinish(iTestContext);
        logger.info("Test suit finished "+iTestContext.getName());
        logger.info("Clearing storage");
        clearStorage("localStorage");
        Driver.closeDriver();
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);

    }
    public static void clearStorage(String storageType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript(String.format("window.%s.clear();", storageType));
    }
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        Allure.getLifecycle().addAttachment("Скриншот после успешного прохождения теста", "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//        Allure.addAttachment("Логи после успешного прохождения теста: ",
//                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
//        logger.info("closing driver after success on "+getTestMethodName(result));
//        WebDriverManager.chromedriver().quit();
//        driver.close();
//    }

    //////////////////////////////
//

//
//    @Override
//    public void onStart(ITestContext context) {
//        logger.info("I am in onStart method "+context.getName());
//        context.setAttribute("WebDriver", Driver.getDriver());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        logger.info("I am in onFinish method "+context.getName());
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        logger.info("I am in onTestStart method "+getTestMethodName(result) + " start");
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        logger.warn("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
//    }
//
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        logger.error("Test "+getTestMethodName(result)+" failed");
//        takeScreenshotAndAttachToAllure(result,"failure");
//        attachBrowserLogsToAllure();
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        takeScreenshotAndAttachToAllure(result,"success");
//        attachBrowserLogsToAllure();
//    }
//
//    private void takeScreenshotAndAttachToAllure(ITestResult result,String type) {
//        String testName = result.getMethod().getMethodName();
//        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        String screenshotFileName = testName + "_" + timestamp + "_" + type + ".png";
//
//        Allure.getLifecycle().addAttachment(screenshotFileName + type, "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
////        Allure.addAttachment("Browser logs " + type,
////                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
//    }
//
//
//    private void attachBrowserLogsToAllure() {
//        Allure.addAttachment("Browser logs",
//                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
//    }
}
