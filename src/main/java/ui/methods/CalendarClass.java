package ui.methods;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarClass {
    WebDriver driver = Driver.getDriver();

    public void getRandomDate(WebElement datePicker, WebElement monthPicker){
        Helper.click(datePicker);
        Helper.click(monthPicker);
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int todayDate = date.getDayOfMonth();

        // Generate random month in next 6 month
        int monthInYearRange = (int)Math.floor(Math.random() * (8 - currentMonth + 1) + currentMonth);
        // Generate random day from present day
        int dayInMonthRange = (int)Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        // Generate random day in month
        int dayInMonthFull = (int)Math.floor(Math.random() * (31 - 1 + 1) + 1);

        String pathMonth = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[2]/table/tbody/tr/td/span[MonthIndex]";
        String pathMonthFinal = pathMonth.replace("MonthIndex", String.valueOf(monthInYearRange));
        WebElement month = driver.findElement(By.xpath(pathMonthFinal));
        Helper.click(month);

        if(monthInYearRange == currentMonth){
            String pathDay = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'DayIndex')]";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthRange));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }else{
            String pathDay = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'DayIndex')]";
//            String pathDay = "(/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'DayIndex')])[2]";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthFull));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }
    }

    public void getGivenDate(WebElement datePicker){
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int todayDate = date.getDayOfMonth();
        // Generate random day from present day
        int dayInMonthRange = (int)Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        Helper.click(datePicker);
//        String pathDay = "//td[text()='INDEX']";
        String pathDay = "(//td[text()='INDEX'])[2]";
        String pathDayFinal = pathDay.replace("INDEX", String.valueOf(dayInMonthRange));
        WebElement tdButton = datePicker.findElement(By.xpath(pathDayFinal));
        Helper.click(tdButton);

        //Helper.click(moving_detail_page.datePicker);
        //WebElement tdButton = moving_detail_page.datePicker.findElement(By.xpath("//td[text()='9']"));
        //Helper.click(tdButton);
    }

}
