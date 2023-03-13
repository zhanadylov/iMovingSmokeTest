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
import ui.methods.SetUp;
import ui.methods.StorageOrder;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestClass {
//    public static void main(String[] args) {
//        Random ran = new Random();
//        List<String> list = new ArrayList<>();
//        list.add("add-1");
//        list.add("add-2");
//        list.add("add-3");
//        list.add("add-4");
//        list.add("add-5");
//        list.add("add-6");
//        int num = 0;
//        String firstOption = null;
//        for(int i =1; i < list.size();i++){
//            num = ran.nextInt(i);
////            Helper.pause(2000);
//            firstOption = (list.get(num));
//        }
//        System.out.println(firstOption);
//    }
    WebDriver driver;
    ArrayList<String> al;
    StorageOrder storageOrder = new StorageOrder();

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

    }

}
