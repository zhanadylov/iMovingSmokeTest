package ui.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BoxCalculatingPopUp {
    public BoxCalculatingPopUp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Back to inventory')]")
    public WebElement backToInventoryButton;

    @FindBy(xpath = "(//a[contains(text(),'Clear boxes')])[1]")
    public WebElement clearBoxesButton;

    @FindBy(xpath = "(//a[contains(text(),'Recalculate boxes')])[1]")
    public WebElement recalculatingBoxesButton;

    @FindBy(xpath = "(//a[contains(text(),'Add and Continue')])[1]")
    public WebElement addAndContinueButton;

    @FindBy(xpath = "(//a[contains(text(),'How did we calculate it?')])[1]")
    public WebElement howDidWeCalculatingIt;

    //Did You Forget Something PopUP
    @FindBy(xpath = "//a[contains(text(),'Go back')]")
    public WebElement goBackButton;
    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement skipButton;

    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement addBoxesButton;
    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    public WebElement addItemsButton;

}
