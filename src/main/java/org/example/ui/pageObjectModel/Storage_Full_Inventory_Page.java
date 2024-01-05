package org.example.ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.Driver;

public class Storage_Full_Inventory_Page {
    public Storage_Full_Inventory_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"unitSlider\"]")
    public WebElement  sliderLine;

    @FindBy(xpath = "//div[@class='slider-track']")
    public WebElement sliderLine2;

    @FindBy(xpath = "//span[text()='Choose your storage size']")
    public WebElement chooseStorageSizeText;

    @FindBy(xpath = "//div[@class='addStorageBlock']")
    public WebElement addMainStorageButton;

    @FindBy(xpath = "//div[@class='removeStorageBlock']")
    public WebElement removeStorageButton;

    @FindBy(xpath = "//label[normalize-space()='My Storage is Partially Loaded']")
    public WebElement partiallyLoadedCheckbox;

    //Storage pop-up
    @FindBy(xpath = "//span[text()='Main Storage Calculator']")
    public WebElement storageCalculatorPopUpText;

    @FindBy(xpath = "//h3[text()='Up to 50% loaded']")
    public WebElement up50LoadedButton;

    @FindBy(xpath = "//h3[text()='Up to 75% loaded']")
    public WebElement up75LoadedButton;

    @FindBy(xpath = "//h3[text()='Fully loaded']")
    public WebElement fullyLoadedButton;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    public WebElement continueButtonInPopUp;

    @FindBy(xpath = "//div[@id='modalStorageLoaded']//button[@id='closeSaveModal']")
    public WebElement xButtonInPopUpStorage;

}
