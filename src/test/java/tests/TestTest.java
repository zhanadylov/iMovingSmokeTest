package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestTest {

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']//button[text()='Показать']")
        private WebElement btnCalculate;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']//input[@placeholder='Сумма']")
        private WebElement txtAmount;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[1]/div[3]/div[2]")
        private WebElement ddlConverterFrom;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[1]/div[3]/div[2]//span")
        private List<WebElement> converterFromOptions;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[1]/div[4]/div[2]")
        private WebElement ddlConverterTo;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-details-period']//button[text()='Показать']")
        private WebElement btnShowExchangeRates;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[1]/div[4]/div[2]//span")
        private List<WebElement> lstConverterToOptions;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[2]//input[@type='radio']")
        private List<WebElement> lstSource;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[3]//input[@type='radio']")
        private List<WebElement> lstDestination;

        @FindBy(how = How.XPATH, using = "//ul[@class='rates-tabs rates-right']/li[@data-view-mode='history']")
        private WebElement lnkDynamicsOfChangesInExchangeRate;

        @FindBy(how = How.XPATH, using = "//ul[@class='rates-tabs rates-right']/li[@data-view-mode='table']")
        private WebElement lnkExtendedRatesTable;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-links']//span[text()='Таблица изменения котировок']")
        private WebElement lnkTableOfQuotes;

        @FindBy(how = How.XPATH, using = "//div[@class='modal-dialog']//table/tbody/tr")
        private List<WebElement> tableOfQuotes;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-table-view-close']")
        private WebElement lnkClose;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[6]//label[2]")
        private WebElement rdoSelectDate;

        @FindBy(how = How.XPATH, using = "//div[@class='rates-aside-filter rates-container']/div[6]/div[@class='filter-datepicker input']/input")
        private WebElement inpSelectDate;

        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//span[@class='ui-datepicker-month']")
        private WebElement lblMonth;


        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//a[@class='ui-datepicker-prev ui-corner-all']")
        private WebElement btnMonthPrev;


        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//a[@class='ui-datepicker-next ui-corner-all']")
        private WebElement btnMonthNext;


        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//select[@data-handler='selectYear']")
        private WebElement ddlYear;


        @FindBy(how = How.XPATH, using = "//table[@class='ui-datepicker-calendar']/tbody//td")
        private List<WebElement> days;

        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//dd[@class='ui_tpicker_hour']//select")
        private WebElement ddlHour;

        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//dd[@class='ui_tpicker_minute']//select")
        private WebElement ddlMinute;

        @FindBy(how = How.XPATH, using = "id('ui-datepicker-div')//span[@class='button converter-datepicker-hide']")
        private WebElement btnSelectDateAndTime;

        @FindBy(how = How.XPATH, using = "//div[@class='converter-result']//h4/span[1]")
        private WebElement lblResult;

        private String defaultFormat = "dd.MM.yyyy HH:mm";


        public void selectDate(String date) {
            rdoSelectDate.click();
            inpSelectDate.click();

//        Year
            String requiredYear = getStringInCustomDateFormat(date, defaultFormat, "yyyy");
            Select dropdown = new Select(ddlYear);
            dropdown.selectByValue(requiredYear);

//        Month
            Date requiredMonth = getDateInCustomFormat(date, defaultFormat);
            Date actualMonth = getDateInCustomFormat(lblMonth.getText(), "MMMM");
            String requiredMonthInString = getStringInCustomDateFormat(date, defaultFormat, "MMMM");
            if (actualMonth.after(requiredMonth)) {
                while (!requiredMonthInString.equals(lblMonth.getText())) {
                    btnMonthNext.click();
                }
            } else {
                while (!requiredMonthInString.equals(lblMonth.getText())) {
                    btnMonthPrev.click();
                }
            }

//        Day
            String requiredDay = getStringInCustomDateFormat(date, defaultFormat, "d");
            for (int i = 0; i < days.size(); i++) {
                WebElement element = days.get(i);
                if (element.getText().equals(requiredDay)) {
                    element.click();
                    break;
                }
            }

//        Time
            String requiredHour = getStringInCustomDateFormat(date, defaultFormat, "HH");
            dropdown = new Select(ddlHour);
            dropdown.selectByVisibleText(requiredHour);

            String requiredMinute = getStringInCustomDateFormat(date, defaultFormat, "mm");
            dropdown = new Select(ddlMinute);
            dropdown.selectByVisibleText(requiredMinute);

//        Finally
            btnSelectDateAndTime.click();
        }

        private String getStringInCustomDateFormat(String date, String inputFormat, String outputFormat) {
            Date d = getDateInCustomFormat(date, inputFormat);
            SimpleDateFormat sdf = new SimpleDateFormat(outputFormat, new Locale("ru"));
            return sdf.format(d);
        }

        private Date getDateInCustomFormat(String date, String inputFormat) {
            SimpleDateFormat sdf = new SimpleDateFormat(inputFormat, new Locale("ru"));
            Date d = null;
            try {
                d = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return d;
        }

        public String getResultText() {
            return lblResult.getText().replaceAll("\\s", "");
        }
    }

