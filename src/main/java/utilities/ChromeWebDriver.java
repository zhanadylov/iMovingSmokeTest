package utilities;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeWebDriver {
    public static WebDriver loadChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1020");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
//        Chromedriver имеет несколько аргументов по умолчанию,
//        используемых для запуска браузера. Если вы не хотите добавлять эти аргументы,
//        передайте их в excludeSwitches. Частым примером является включение блокировки всплывающих окон.
//        Полный список аргументов по умолчанию можно получить из исходного кода Chromium
        options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));

        if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//        driver.manage().window().setSize(new Dimension(1920,1020));
        driver.manage().window().maximize();



        return driver;
    }
}
