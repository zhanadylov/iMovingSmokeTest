package tests;

import hooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui.methods.CalendarClass;
import ui.methods.SetUp;
import ui.methods.StorageOrder;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestClass {
    WebDriver driver;
    ArrayList<String> al;
    StorageOrder storageOrder = new StorageOrder();
    CalendarClass calendarClass = new CalendarClass();

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Test
    public void test(){
//        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
//        storageOrder.chooseFromSlideBar(slider);


        WebElement date = driver.findElement(By.xpath("(//input[@id='dateOfBirthInput'])[1]"));
        date.click();
//        List<WebElement> date2 = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'15')]"));
        WebElement date2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),'25')]"));
        date2.click();
    }

    public static void testDate(WebElement datePicker){

    }

    public static void main(String[] args) {
        Random rand = new Random();
        LocalDate date = LocalDate.now();
        String date2 = String.valueOf(date);
        date2 = date2.substring(date2.length()-2);
        int todayDate = Integer.parseInt(date2);
        int num = (int)Math.floor(Math.random() * (31 - todayDate + 1) + 17);
        System.out.println(num);
//        System.out.println(date3);
    }

}
