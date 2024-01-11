package org.example.hooks;

import io.qameta.allure.Allure;
import org.example.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(WebDriver.class);
    private static WebDriver driver;
    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        driver = Driver.getDriver();
        Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        // Получаем аннотации этого метода
        Annotation[] annotations = method.getDeclaredAnnotations();
        // Логируем информацию об аннотациях
        logger.info("Annotations for test method {}: {}", method.getName(), Arrays.toString(annotations));
        // Продолжаем выполнение стандартной логики
        ITestListener.super.onTestStart(iTestResult);
//        ITestListener.super.onTestStart(iTestResult);
    }
    @Override
    public void onStart(ITestContext iTestContext) {
//        driver = Driver.getDriver();
        logger.info("Test started "+ iTestContext.getName());
        ITestListener.super.onStart(iTestContext);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().addAttachment("Screenshot on failed step", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Logs: ",
                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.warn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(iTestResult);

    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("Test finished "+iTestContext.getName());
        driver.manage().deleteAllCookies();
        ITestListener.super.onFinish(iTestContext);
//        Driver.closeDriver();
    }

//    @Override
//    public void onTestSuccess(ITestResult result) {
//        Allure.getLifecycle().addAttachment("Скриншот после успешного прохождения теста", "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//        Allure.addAttachment("Логи после успешного прохождения теста: ",
//                String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
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
