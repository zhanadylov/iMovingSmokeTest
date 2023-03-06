package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui.methods.StorageOrder;

import java.time.Duration;
import java.util.ArrayList;

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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/slider");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void testSliderrr(){
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
//        storageOrder.chooseFromSlideBar(slider);
    }

}
