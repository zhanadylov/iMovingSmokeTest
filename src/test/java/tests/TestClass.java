//package tests;
//
//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;
//import helper.BrowserHelper;
//import helper.Helper;
//import hooks.Hooks;
//import org.openqa.selenium.*;
//import org.testng.annotations.Test;
//import ui.methods.*;
//import ui.pageObjectModel.*;
//
//import java.time.LocalDate;
//import java.util.*;
//
//public class TestClass extends Hooks implements SetUp{
//    static WebDriver driver;
//    ArrayList<String> al;
//    StorageOrder storageOrder = new StorageOrder();
//    CalendarClass calendarClass = new CalendarClass();
//    SelectRandom selectRandom = new SelectRandom();
//    HomePage homePage = new HomePage();
//    PopUpsPage popUpsPage = new PopUpsPage();
//    Full_inventory_Page full_inventory = new Full_inventory_Page();
//    Detail_Page _detail_page = new Detail_Page();
//    Marketplace_Page marketplace_page = new Marketplace_Page();
//    BoxCalculatingPopUp boxCalculatingPopUp = new BoxCalculatingPopUp();
//    BrowserHelper browserHelper = new BrowserHelper(driver);
//    PerformActionOnElements performActionOnElements = new PerformActionOnElements();
//
////    @BeforeTest
////    public void setUp() {
////        WebDriverManager.chromedriver().setup();
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
////        driver = new ChromeDriver(options);
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//////        driver.get("https://demoqa.com/automation-practice-form");
//////        driver.get("https://qa.imoving.com/");
////    }
//
//    @Test
//    public void test(){
////        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
////        storageOrder.chooseFromSlideBar(slider);
//
//
////        Helper.pause(2000);
////        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div"));
//        Helper.pause(3000);
////        List<WebElement> sugInput = driver.findElements(By.className("subjects-auto-complete__menu css-2613qy-menu"));
////        sendKeys(input, sugInput);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open('https://www.google.com', '_blank');");
//        browserHelper.goForward();
//
//        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
//
//        sendKeys(input2, "d", Keys.ARROW_DOWN, Keys.ENTER);
//    }
//
//    public static void sendKeys(WebElement element, List<WebElement> suggesting){
//        element.click();
//        element.sendKeys("t");
//        if(!suggesting.isEmpty()){
//            suggesting.get(0).click();
//        }
//    }
//
//    public static void sendKeys(WebElement element, String value, Keys button, Keys button2){
//        element.click();
//        element.sendKeys(value);
//        element.sendKeys(button, button2);
//    }
//
//    public static void test45(){
//        ArrayList<String> full = new ArrayList<>();
//        ArrayList<String> words = new ArrayList<>();
//        ArrayList<String> numbers = new ArrayList<>();
//        full.add("Moving Journey - 2524 Miles");
//        full.add("Addresses Restrictions $0.00");
//        full.add("Inventory - Items $479.99");
//        full.add("Inventory - Boxes $966.19");
//        full.add("Additional Services $-144.62");
//        full.add("Fees $328.83");
//        full.add("Total Price $1,630.38");
//
//
//        for (String element : full) {
//            int dollarIndex = element.lastIndexOf('$');
//            if (dollarIndex != -1) {
//                String word = element.substring(0, dollarIndex).trim();
//                String number = element.substring(dollarIndex + 1).trim();
//
//                // Проверка на наличие цифр и знака доллара в number
//                if (!number.isEmpty() && (number.contains("$") || number.matches(".*\\d.*"))) {
//                    words.add(word);
//                    numbers.add(number);
//                } else {
//                    words.add(element);
//                    numbers.add("");
//                }
//            } else {
//                words.add(element);
//                numbers.add("");
//            }
//        }
//
//        System.out.println("Full list:");
//        for (int i = 0; i < words.size(); i++) {
//            System.out.println("Word: " + words.get(i) + ", Number: " + numbers.get(i));
//        }
//
//    }
//
//    public static void test6(){
//        Multimap<String, String> inventoryListInfo = ArrayListMultimap.create();
//        List<String> priceList = new ArrayList<>();
//
//        inventoryListInfo.put("Moving","2532");
//        inventoryListInfo.put("Addresses","$0.00");
//        inventoryListInfo.put("Inventory","$298.59");
//        inventoryListInfo.put("Inventory","$16.05");
//        inventoryListInfo.put("Additional","$-47.20");
//        inventoryListInfo.put("Fees","$1,463.28");
//        inventoryListInfo.put("Total","$1,730.73");
//
//        priceList.add("$0.00");
//        priceList.add("$479.99");
//        priceList.add("341.52");
//        priceList.add("$0");
//        priceList.add("$2,463.28");
//
////        for (String price : priceList) {
////            if (inventoryListInfo.containsValue(price)) {
////                System.out.println("Элемент " + price + " содержится в inventoryListInfo.");
////            } else {
////                System.out.println("Элемент " + price + " отсутствует в inventoryListInfo.");
////            }
////        }
//
//        int num = 0;
//        while(num >= 5){
//            System.out.println(num);
//        }
//    }
//
//    public static void main(String[] args) {
//    }
//
////    @AfterSuite
////    public void tearDown() throws InterruptedException {
////        Thread.sleep(3000);
////        driver.close();
////        driver.quit();
////    }
//
//}
