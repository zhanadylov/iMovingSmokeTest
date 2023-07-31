package ui.methods;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.time.LocalDate;
import java.util.Random;

public class GetDate {
    WebDriver driver = Driver.getDriver();

    public void getRandomDate(WebElement datePicker, WebElement monthPicker) {
        Helper.click(datePicker);
        Helper.click(monthPicker);

        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int todayDate = date.getDayOfMonth();

        // Generate random month in next months
        int monthInYearRange = (int) Math.floor(Math.random() * (12 - currentMonth + 1) + currentMonth);

        // Generate random day from present day
        int dayInMonthRange;
        int dayInMonthFull;
        if (monthInYearRange == currentMonth) {
            dayInMonthRange = (int) Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
            dayInMonthFull = dayInMonthRange;
        } else {
            dayInMonthRange = 0;
            dayInMonthFull = (int) Math.floor(Math.random() * 31) + 1;
        }

        System.out.println("Chosen day in month range: " + dayInMonthRange);

        String pathMonth = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[2]/table/tbody/tr/td/span[" + monthInYearRange + "]";
        WebElement month = driver.findElement(By.xpath(pathMonth));
        Helper.click(month);

        String pathDay = "//td[@class='day' and text()='DayIndex']";
        String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthFull));
        WebElement day = driver.findElement(By.xpath(pathDayFinal));
        Helper.click(day);
    }

    public static void getDateFromToday(WebElement datePicker) {
        LocalDate date = LocalDate.now();
        int todayDate = date.getDayOfMonth();
        int lastDayOfMonth = date.lengthOfMonth();

        Random random = new Random();
        int dayInMonthRange;
        if (todayDate == lastDayOfMonth) {
            dayInMonthRange = todayDate;
        } else {
            do {
                dayInMonthRange = random.nextInt(lastDayOfMonth - todayDate) + todayDate;
            } while (dayInMonthRange == todayDate);
        }

        String pathDay = "//td[@class='day' and text()='INDEX']";
        String pathDayFinal = pathDay.replace("INDEX", String.valueOf(dayInMonthRange));
        System.out.println("Chosen day: " + dayInMonthRange);

        // Кликнуть на элемент с выбранной датой
        WebElement tdButton = datePicker.findElement(By.xpath(pathDayFinal));
        Helper.click(tdButton);
    }
    public static void getDateInMonthRange(WebElement datePicker){
        LocalDate date = LocalDate.now();
        int todayDate = date.getDayOfMonth();
        int lastDayOfMonth = date.lengthOfMonth();
//        int dayInMonthRange;
//        do {
//            dayInMonthRange = (int) Math.floor(Math.random() * (lastDayOfMonth - todayDate + 1) + todayDate);
//        } while (dayInMonthRange <= todayDate);
        Random random = new Random();
        int dayInMonthRange;
        do {
            dayInMonthRange = random.nextInt(lastDayOfMonth) + 1;
        } while (dayInMonthRange == todayDate);
        System.out.println(dayInMonthRange);
        String pathDay = "//td[@class='day' and text()='INDEX']";
        String pathDayFinal = pathDay.replace("INDEX", String.valueOf(dayInMonthRange));
        System.out.println("Chosen day"+pathDayFinal);

        // Кликнуть на элемент с выбранной датой
        WebElement tdButton = datePicker.findElement(By.xpath(pathDayFinal));
        Helper.click(tdButton);
    }

}
