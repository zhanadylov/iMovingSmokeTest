package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
    public static void sendKeys(WebElement element,Keys button){
        element.sendKeys(button);
    }

    public static String getAttributeByValue(WebElement element){
        waitForElementToBeDisplayed(element);
        return element.getAttribute("value");
    }


    public static void chooseDate(String date, WebElement calendarValue,
                                  WebElement forwardButton, WebElement backwardButton, WebElement day)
    {
        HashMap<String, String> monthKeeper = new HashMap<String, String>();
        monthKeeper.put("January","01" );monthKeeper.put("February","02");monthKeeper.put("March","03");
        monthKeeper.put("April","04");monthKeeper.put("May","05");monthKeeper.put("June","06");
        monthKeeper.put("July","07");monthKeeper.put("August","08");monthKeeper.put("September","09");
        monthKeeper.put("October","10");monthKeeper.put("November","11");monthKeeper.put("December","12");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd MM yyyy" );
        LocalDateTime now = LocalDateTime.now();
        String currentTimeString = formatter.format(now);
        boolean forward = true;

        String[] currentTimeSplitted = currentTimeString.split(" "),
                inputDateSplitted = date.split(" ");

        String neededDate = inputDateSplitted[1] + " " + inputDateSplitted[2];

        if(neededDate.equals(Helper.getTextValue(calendarValue)))
        {  Helper.click(day); }

        LocalDate inputDate = LocalDate.of(Integer.parseInt(inputDateSplitted[2]),
                Integer.parseInt(monthKeeper.get(inputDateSplitted[1])) ,Integer.parseInt(inputDateSplitted[0]));

        LocalDate currentDate = LocalDate.of(Integer.parseInt(currentTimeSplitted[2]),
                Integer.parseInt(currentTimeSplitted[1]), Integer.parseInt(currentTimeSplitted[0]));


        if(currentDate.isAfter(inputDate))
        {forward = false;}

        while(true)
        {
            String actualDate = Helper.getTextValue(calendarValue);
            if(neededDate.equals(actualDate))
            {
                break;
            }
            if(forward) {Helper.click(forwardButton);}
            else {Helper.click(backwardButton);}

        }

        String elementToString = day.toString();
        String path = elementToString.substring(elementToString.indexOf('/'));
        path= path.substring(0, path.length() - 1);
        path = path.replace("date", inputDateSplitted[0]);
        WebDriver driver = Driver.getDriver();

        driver.findElement(By.xpath(path)).click();
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

    public static String compareDate2(String date){
        String dateAfter = date.substring(11,22);
        return dateAfter;
    }
}
