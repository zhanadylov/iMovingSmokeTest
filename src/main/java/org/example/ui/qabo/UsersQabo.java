package org.example.ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

import java.util.List;

public class UsersQabo {
    public UsersQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body > div > div > section.content-header > h1 > div > a")
    public WebElement usersTitle;

    @FindBy(xpath = "//input[@id='Email' and @name='Email']")
    public WebElement emailInputField;
    @FindBy(xpath = "//input[@id='CompanyName' and @name='CompanyName']")
    public WebElement companyNameInputField;

    @FindBy(xpath = "//td[contains(text(), 'supplier')]/preceding-sibling::td[5]")
    public List<WebElement> emailsWithRoleSupplier;

    @FindBy(xpath = "//button[@id='update-companies']")
    public WebElement updateFilterButton;

    @FindBy(css = "body > div > div > section.content > p > a")
    public WebElement createNewUserButton;

    //Edit Page
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]/div/form/a[2]")
    public WebElement changePasswordButton;
    @FindBy(xpath = "//*[@id=\"NewPassword\"]")
    public WebElement newPasswordInputField;
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]/div/form/button")
    public WebElement saveButton;
}
