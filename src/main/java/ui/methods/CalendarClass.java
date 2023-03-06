package ui.methods;

import helper.Helper;
import org.openqa.selenium.By;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CalendarClass {

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

    public static String[] getMonthYear(String monthYearValue){
        return monthYearValue.split(" ");
    }

    public static void selectDate(String day, String month, String year){
//        String monthYearValue = DetailPage.dateCalendarTitle.getText();
//        while(!(getMonthYear(monthYearValue)[0].equals(month)
//            &&
//                getMonthYear(monthYearValue)[1].equals(year))){
//            Helper.click(DetailPage.nextButton);
//            monthYearValue = DetailPage.dateCalendarTitle.getText();
//        }
//        try{
//            Helper.click(Driver.getDriver().findElement(By.xpath(DetailPage.dateNumber+day+"']")));
//        }catch (Exception e){
//            System.out.println("Wrong date: "+month+" : "+day);
//        }
    }

//    public void selectDate(WebDriver driver, WebElement datepicker, String date) {
//        // Открываем календарь
//        datepicker.click();
//
//        // Получаем список всех дат в календаре
//        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
//
//        // Перебираем все даты и выбираем нужную
//        for (WebElement element : dates) {
//            if (element.getText().equals(date)) {
//                element.click();
//                break;
//            }
//        }
//    }
}
