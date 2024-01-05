package org.example.ui.qabo;

import org.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarQabo {
    public CalendarQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body > div > div > section.content-header > h1 > div > a")
    public WebElement calendarTitle;

}
