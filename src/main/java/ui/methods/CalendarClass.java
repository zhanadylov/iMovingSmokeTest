package ui.methods;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CalendarClass {
    WebDriver driver = Driver.getDriver();

    public static void getDateTest(){
        Random random = new Random();
        int ranValue = random.nextInt(31);
        System.out.println("Ran value is " + ranValue);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, ranValue);
        cal.add(Calendar.DATE, ranValue);
        cal.add(Calendar.YEAR, 0);

        Date date = cal.getTime();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = sdf.format(date);
        System.out.println(dateString);
    }

    public void selectDate(WebDriver driver, WebElement datepicker, List<WebElement> dates, String date) {
        // Открываем календарь
        datepicker.click();

        // Получаем список всех дат в календаре
//        List<WebElement> dates = datepicker;

        // Перебираем все даты и выбираем нужную
        for (WebElement element : dates) {
            if (element.getText().equals(date)) {
                element.click();
                break;
            }
        }
    }

    public void getDate(WebElement datePicker, WebElement monthPicker){
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
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthFull));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }
    }
}
