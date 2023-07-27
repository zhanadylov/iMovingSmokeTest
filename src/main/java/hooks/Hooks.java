package hooks;

import helper.Helper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.Driver;

import java.io.File;


public class Hooks {



    public void setUp() {
        System.out.println(Helper.ANSI_GREEN+"Before hook started"+Helper.ANSI_RESET);
    }


    public static void FailedScreenshot(String teatMethodName){
        File srcFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File("D:\\ScreenTest\\"+teatMethodName+".png"));
        } catch (Exception e) {
            System.out.println(Helper.ANSI_YELLOW+"The error happened while cleaning up after the test: " +
                    e.getMessage()+Helper.ANSI_RESET);
        }
    }
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