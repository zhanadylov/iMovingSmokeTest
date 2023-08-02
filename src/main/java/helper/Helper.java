package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static ui.methods.SetUp.driver;

public class Helper {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void click(WebElement element){

        try {
            waitForElementToBeDisplayed(element);
            waitForElementToBeClickable(element);
            navigateToElement(element);
            highLighterMethod(element);
            element.click();
        }catch (ElementClickInterceptedException e){
            javascriptClick(element);
        }

    }
    public static void drugAnDrop(WebElement sourceLocator, WebElement destinationLocator){
        waitForElementToBeDisplayed(sourceLocator);
        waitForElementToBeDisplayed(destinationLocator);
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(sourceLocator, destinationLocator).build().perform();
    }

    public static void highLighterMethod( WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void multipleClick(WebElement element,int howManyTimes)
    {
        int counter = howManyTimes;
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        try {

            while (counter > 0) {
                element.click();
                counter--;
                Helper.pause(3000);
            }
        }
        catch (ElementClickInterceptedException e){
            javascriptClick(element);
        }
    }
    public static void multipleClickWithOutThread(WebElement element,int howManyTimes)
    {
        int counter = howManyTimes;
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        while (counter > 0)
        {
            element.click();
            counter--;
        }
    }

    public static void clickWithOutWait(WebElement element){
        element.click();
    }


    public static void waitForElementToBeDisplayed(WebElement element) {
        pause(500);
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clearExistingText(WebElement element, String newText) {
        element.clear();
        element.sendKeys(newText);
    }

    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTextValue(WebElement element){
        waitForElementToBeDisplayed(element);
        String text = element.getText();
        return text;
    }

    public static Boolean isDisplayedWithWait(WebElement element)
    {
        waitForElementToBeDisplayed(element);
        Boolean isDisplayed = element.isDisplayed();
        return isDisplayed;
    }

    public static Boolean isSelectedWithWait(WebElement element)
    {
        waitForElementToBeDisplayed(element);
        Boolean isSelected = element.isSelected();
        return  isSelected;
    }

    public static void waitForElementVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    public static boolean avoidStaleElementClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                Actions actions = new Actions(Driver.getDriver());
                actions.click().perform();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public static void javascriptClick(WebElement element) {
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void javascriptScrollDownThePage() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.scrollBy(0,800)");
    }

    public static void clearField(WebElement element) {
        waitForElementToBeDisplayed(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.chord(Keys.DELETE));
    }

    public static void navigateToElement( WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        try {
            actions.moveToElement(element).perform();
        }catch (JsonException e){
            System.out.println();
        }

    }

    public static void javascriptScrollIntoView(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element );
    }

    public static boolean retryingFindClick(By by) {
        boolean result = false;
        WebDriver driver = Driver.getDriver();
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public static void sendKeys(WebElement element,String value){
        element.sendKeys(value);
    }

    // We can press keyboard buttons
    public static void sendKeys(WebElement element,Keys button,Keys button2){
        element.sendKeys(button,button2);
    }

    public static String getAttributeByValue(WebElement element){
        waitForElementToBeDisplayed(element);
        return element.getAttribute("value");
    }

    public static Boolean compareDates(String olderDate, String soonerDate)
    {
        String[] firstDateSplitted = olderDate.split("/");
        int year1, month1, day1;
        year1 = Integer.parseInt(firstDateSplitted[2]);
        month1 = Integer.parseInt((firstDateSplitted[0]));
        day1 = Integer.parseInt(firstDateSplitted[1]);

        String[] secondDateSplitted = soonerDate.split("/");
        int year2, month2, day2;
        year2 = Integer.parseInt(secondDateSplitted[2]);
        month2 = Integer.parseInt((secondDateSplitted[0]));
        day2 = Integer.parseInt(secondDateSplitted[1]);

        LocalDate older = LocalDate.of(year1, month1,day1 );
        LocalDate sooner = LocalDate.of(year2, month2, day2);

        return sooner.isAfter(older);
    }
    public static String color(String color){

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        switch (color){
            case "reset":
                return ANSI_RESET;
            case "black":
                return ANSI_BLACK;
            case "red":
                return ANSI_RED;
            case "green":
                return ANSI_GREEN;
            case "yellow":
                return ANSI_YELLOW;
            case "blue":
                return ANSI_BLUE;
            case "purple":
                return ANSI_PURPLE;
            case "cyan":
                return ANSI_CYAN;
            case "white":
                return ANSI_WHITE;
            default: return "No color!";
        }
    }

    public static String color(String color, boolean continueColor) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        String colorCode;
        switch (color) {
            case "reset":
                colorCode = ANSI_RESET;
                break;
            case "black":
                colorCode = ANSI_BLACK;
                break;
            case "red":
                colorCode = ANSI_RED;
                break;
            case "green":
                colorCode = ANSI_GREEN;
                break;
            case "yellow":
                colorCode = ANSI_YELLOW;
                break;
            case "blue":
                colorCode = ANSI_BLUE;
                break;
            case "purple":
                colorCode = ANSI_PURPLE;
                break;
            case "cyan":
                colorCode = ANSI_CYAN;
                break;
            case "white":
                colorCode = ANSI_WHITE;
                break;
            default:
                return "No color!";
        }

        return continueColor ? colorCode : colorCode + ANSI_RESET;
    }

    public static String compareDate2(String date){
        return date.substring(11,22);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

        //        Helper.takeSnapShot(Driver.getDriver(),"F:\\ScreenTest//Test.png");

    }

    public static double divideSum(double sum) {
        sum = sum / 4;
        return sum;
    }

    public static String getLastN(String s, int n) {
        if (s == null || n > s.length()) {
            return s;
        }
        return s.substring(s.length() - n);
    }

    public static double calculatePercent(WebElement price, double percent){
        double price3 = Double.parseDouble(price.getText().replace("[$,]",""));
        return (price3 * percent) / 100.0;
    }

    public static double roundingsFee(double feePrice){
        BigDecimal price = BigDecimal.valueOf(feePrice).setScale(2, RoundingMode.HALF_UP);
        return price.doubleValue();
    }
    public static String getGrantTotalBO(String price, String sFee){
        return formatDouble(roundingsFee(Double.parseDouble(price.replaceAll("[$,]","")) + Double.parseDouble(sFee.replaceAll("[$,]",""))));
    }
    public static String formatDouble(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return "$"+decimalFormat.format(value);
    }

    public static void numberComparison(double expected, double actual) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedExpected = decimalFormat.format(expected);
        String formattedActual = decimalFormat.format(actual);

        // Compare the formatted strings
        Assert.assertEquals(String.valueOf(formattedExpected), formattedActual);
    }
//    public static void clickButtonIfDisplayed(WebElement element) {
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10); // Wait for up to 10 seconds
//            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(element));
//            button.click();
//            System.out.println("Clicked on the 'Add and Continue' button.");
//        } catch (Exception e) {
//            System.out.println("Continue button not displayed or could not be clicked: " + e.getMessage());
//        }
//    }
    public static void clickButtonIfDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // Wait for up to 10 seconds
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(element));
            button.click();
            System.out.println("Clicked on the 'Appeared' button.");
        } catch (Exception e) {
            System.out.println("Button not displayed or could not be clicked:");
            e.printStackTrace();
        }
    }
    public static boolean isElementPresent(WebElement element) {
        try {
//            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
