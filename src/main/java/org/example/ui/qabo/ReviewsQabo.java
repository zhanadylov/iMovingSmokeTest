package org.example.ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

public class ReviewsQabo {
    public ReviewsQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body > div.wrapper > div > section.content-header > h1 > div > a")
    public WebElement reviewsTitle;

}
