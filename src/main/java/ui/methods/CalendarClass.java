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

    //Get The Current Day
    public String getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
    }
    //Get The Current Day plus days. You can change this method based on your needs.
    public String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }
    //Click to given day
    public void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
//        elementList.stream()
//                .filter(element -> element.getText().contains(day))
//                .findFirst()
//                .ifPresent(WebElement::click);
        /**Non-functional JAVA version of this method.*/
//        for (
//            WebElement cell : elementList) {
//            String cellText = cell.getText();
//            if (cellText.contains(day)) {
//                cell.click();
//                break;
//            }
//        }
//        List<WebElement> elementList = driver.findElements(datePickerLocator);
        for (WebElement cell : elementList) {
            String cellText = cell.getText();
            System.out.println("cellText is "+cellText);
            if (cellText.contains(day)) {
                cell.click();
                break;
            }
        }
    }
}
