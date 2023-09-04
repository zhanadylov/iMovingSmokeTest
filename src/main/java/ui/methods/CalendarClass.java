package ui.methods;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.time.LocalDate;

public class CalendarClass {
    WebDriver driver = Driver.getDriver();

    //For QABO change date
    public String pathDayFinal;
    public int dayInMonthRange;
    public void getRandomDate(WebElement datePicker, WebElement monthPicker){
        Helper.click(datePicker);
        Helper.click(monthPicker);
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int todayDate = date.getDayOfMonth();

        // Generate random month in next months
        int monthInYearRange = (int)Math.floor(Math.random() * (12 - currentMonth + 1) + currentMonth);
        // Generate random day from present day
        int dayInMonthRange;
        do {
            dayInMonthRange = (int) Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        } while (dayInMonthRange == todayDate);
        System.out.println("Chosen day in month range: "+dayInMonthRange);
        // Generate random day in month
        int dayInMonthFull = (int)Math.floor(Math.random() * (31 - 1 + 1) + 1);

        String pathMonth = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[2]/table/tbody/tr/td/span[MonthIndex]";
        String pathMonthFinal = pathMonth.replace("MonthIndex", String.valueOf(monthInYearRange));
        WebElement month = driver.findElement(By.xpath(pathMonthFinal));
        Helper.click(month);

        if(monthInYearRange == currentMonth){
//            String pathDay = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'DayIndex')]";
            String pathDay = "//td[@class='day' and text()='DayIndex']";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthRange));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }else{
//            String pathDay = "/html/body/div[1]/div/div/div[1]/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/table/tbody/tr/td[contains(text(),'DayIndex')]";
            String pathDay = "//td[@class='day' and text()='DayIndex']";
            String pathDayFinal = pathDay.replace("DayIndex", String.valueOf(dayInMonthFull));
            WebElement day = driver.findElement(By.xpath(pathDayFinal));
            Helper.click(day);
        }
    }

    public void getRandomDateInMonth(WebElement datePicker){
        LocalDate date = LocalDate.now();
        int todayDate = date.getDayOfMonth();
        int dayInMonthRange;
        do {
            dayInMonthRange = (int) Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        } while (dayInMonthRange == todayDate);

        Helper.click(datePicker);
        String pathDay = "//td[@class='day' and text()='INDEX']";
        String pathDayFinal = pathDay.replace("INDEX", String.valueOf(dayInMonthRange));
        System.out.println("Chosen day"+pathDayFinal);

//        WebElement tdButton = datePicker.findElement(By.xpath("(//td[@class='active day'] | //td[text()='30'])[2]"));
        WebElement tdButton = datePicker.findElement(By.xpath(pathDayFinal));
        Helper.click(tdButton);
    }

    public void getRandomDateInMonthQABO(WebElement datePicker){
        LocalDate date = LocalDate.now();
        int todayDate = date.getDayOfMonth();
//        int dayInMonthRange;
        do {
            dayInMonthRange = (int) Math.floor(Math.random() * (31 - todayDate + 1) + todayDate);
        } while (dayInMonthRange == todayDate);

        Helper.click(datePicker);
        String pathDay = "//td[@data-handler='selectDay']/a[@class='ui-state-default' and text()='INDEX']";
        pathDayFinal = pathDay.replace("INDEX", String.valueOf(dayInMonthRange));
        System.out.println("Chosen day"+pathDayFinal);

        WebElement tdButton = datePicker.findElement(By.xpath(pathDayFinal));
        Helper.click(tdButton);
    }

    public void getGivenDate(WebElement datePicker){
        Helper.click(datePicker);
        WebElement tdButton = datePicker.findElement(By.xpath("//td[@class='day' and text()='30']"));
        Helper.click(tdButton);
    }


}
