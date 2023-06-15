package tests;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import helper.BrowserHelper;
import helper.Helper;
import hooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.*;
import ui.pageObjectModel.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class TestClass extends Hooks implements SetUp{
    static WebDriver driver;
    ArrayList<String> al;
    StorageOrder storageOrder = new StorageOrder();
    CalendarClass calendarClass = new CalendarClass();
    SelectRandom selectRandom = new SelectRandom();
    HomePage homePage = new HomePage();
    PopUps popUps = new PopUps();
    Full_inventory_Page full_inventory = new Full_inventory_Page();
    Moving_Detail_Page moving_detail_page = new Moving_Detail_Page();
    Moving_Result_Page moving_result_page = new Moving_Result_Page();
    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    PerformActionOnElements performActionOnElements = new PerformActionOnElements();

//    @BeforeTest
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.get("https://demoqa.com/automation-practice-form");
////        driver.get("https://qa.imoving.com/");
//    }

    @Test
    public void test67(){
        Helper.click(homePage.SignInButton);
        Helper.click(homePage.signUpInLoginForm);
        Helper.pause(2000);
        performActionOnElements.setValuesToFillFields("test1","test2","fizu@mailinator.com","QATest-2022","QATest-2022", "1234567890");
        performActionOnElements.fillCCFieldsElementTest(homePage.newFirstName, homePage.newLastName, homePage.newEmail, homePage.newPassword,homePage.confirmPassword,homePage.phoneNumber);
        Helper.pause(3000);
    }

    @Test
    public void testClickCheckRates(){
        Helper.pause(2000);
        selectRandom.selectRandomOptionFromDropDown(homePage.moveOptionList);
        selectRandom.selectRandomOptionFromDropDown(homePage.sizeOptionList);
        Helper.click(homePage.compareQuotes);
        Helper.click(popUps.continueButton);
        Helper.click(popUps.xButtonSecond);
        Helper.click(popUps.okButtonThird);
        AddItemsMethod.addItems(full_inventory.imageElement, 5);
        Helper.click(full_inventory.completeOrder);
        Helper.navigateToElement(boxCalculatingPopUp.addAndContinueButton);
        Helper.click(boxCalculatingPopUp.addAndContinueButton);
        if(boxCalculatingPopUp.skipButton.isDisplayed()){
            Helper.click(boxCalculatingPopUp.skipButton);
        }
        Helper.click(full_inventory.completeOrder);
        Helper.pause(2000);
        String pickUp = "1234 Wilshire Boulevard, Los Angeles, CA, 90017";
        String dropOff = "12340 Boggy Creek Road, Orlando, FL, 32824";
//        SetAddress.testMethod(pickUp, moving_detail_page.pickUpInput);
//        SetAddress.testMethod2(dropOff, moving_detail_page.dropOffInput);
        Helper.pause(2000);
//        Helper.javascriptScrollIntoView(moving_detail_page.chooseMoversButton);
//        Helper.navigateToElement(moving_detail_page.chooseMoversButton);
//        Helper.click(moving_detail_page.chooseMoversButton);
        Actions act = new Actions(driver);
        act.moveByOffset(1032, 731).click().build().perform();
        Helper.pause(4000);

    }

    @Test
    public void test(){
//        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
//        storageOrder.chooseFromSlideBar(slider);


//        Helper.pause(2000);
//        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div"));
        Helper.pause(3000);
//        List<WebElement> sugInput = driver.findElements(By.className("subjects-auto-complete__menu css-2613qy-menu"));
//        sendKeys(input, sugInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.com', '_blank');");
        browserHelper.goForward();

        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));

        sendKeys(input2, "d", Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void testNextMonth(WebElement datePicker, WebElement monthPicker){
        Helper.click(datePicker);
        Helper.click(monthPicker);
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int todayDate = date.getDayOfMonth();
        int monthInYearRange = (int)Math.floor(Math.random() * (8 - currentMonth + 1) + currentMonth);
        int dayInMonthRange = (int)Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        int dayInMonthFull = (int)Math.floor(Math.random() * (31 - 1 + 1) + 1);

        String pathMonth = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[2]/table/tbody/tr/td/span[MonthIndex]";
        String pathMonthFinal = pathMonth.replace("MonthIndex", String.valueOf(monthInYearRange));
        WebElement month = driver.findElement(By.xpath(pathMonthFinal));

        if(monthInYearRange == currentMonth){
            String pathDay = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),'DayIndex')]";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthRange));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }else{
            String pathDay = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),'DayIndex')]";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthFull));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }
    }

    public static void sendKeys(WebElement element, List<WebElement> suggesting){
        element.click();
        element.sendKeys("t");
        if(!suggesting.isEmpty()){
            suggesting.get(0).click();
        }
    }

    public static void sendKeys(WebElement element, String value, Keys button, Keys button2){
        element.click();
        element.sendKeys(value);
        element.sendKeys(button, button2);
    }

    public static void test45(){
        ArrayList<String> full = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        full.add("Moving Journey - 2524 Miles");
        full.add("Addresses Restrictions $0.00");
        full.add("Inventory - Items $479.99");
        full.add("Inventory - Boxes $966.19");
        full.add("Additional Services $-144.62");
        full.add("Fees $328.83");
        full.add("Total Price $1,630.38");


        for (String element : full) {
            int dollarIndex = element.lastIndexOf('$');
            if (dollarIndex != -1) {
                String word = element.substring(0, dollarIndex).trim();
                String number = element.substring(dollarIndex + 1).trim();

                // Проверка на наличие цифр и знака доллара в number
                if (!number.isEmpty() && (number.contains("$") || number.matches(".*\\d.*"))) {
                    words.add(word);
                    numbers.add(number);
                } else {
                    words.add(element);
                    numbers.add("");
                }
            } else {
                words.add(element);
                numbers.add("");
            }
        }

        System.out.println("Full list:");
        for (int i = 0; i < words.size(); i++) {
            System.out.println("Word: " + words.get(i) + ", Number: " + numbers.get(i));
        }

    }

    public static double calculatePercent(String price, double percent){
        double price3 = Double.parseDouble(price.replaceAll("[$,]",""));
        return (price3 * percent) / 100.0;
    }

    public static BigDecimal roundingsFee(double feePrice){
        return BigDecimal.valueOf(feePrice).setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Multimap<String, String> inventoryListInfo = ArrayListMultimap.create();
        List<String> priceList = new ArrayList<>();

        inventoryListInfo.put("Moving","2532");
        inventoryListInfo.put("Addresses","$0.00");
        inventoryListInfo.put("Inventory","$298.59");
        inventoryListInfo.put("Inventory","$16.05");
        inventoryListInfo.put("Additional","$-47.20");
        inventoryListInfo.put("Fees","$1,463.28");
        inventoryListInfo.put("Total","$1,730.73");

        priceList.add("$0.00");
        priceList.add("$479.99");
        priceList.add("341.52");
        priceList.add("$0");
        priceList.add("$2,463.28");

//        for (String price : priceList) {
//            if (inventoryListInfo.containsValue(price)) {
//                System.out.println("Элемент " + price + " содержится в inventoryListInfo.");
//            } else {
//                System.out.println("Элемент " + price + " отсутствует в inventoryListInfo.");
//            }
//        }

        int num = 0;
        while(num >= 5){
            System.out.println(num);
        }
    }

//    @AfterSuite
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//        driver.quit();
//    }

}
