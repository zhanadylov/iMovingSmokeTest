package ui.qabo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrdersPageInQabo {
    public OrdersPageInQabo() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/h1/div/a")
    public WebElement ordersTitleText;

    @FindBy(xpath = "//*[@id=\"StatusId\"]")
    public WebElement ordersStatusFilter;

    @FindBy(xpath = "//*[@id=\"OrderId\"]")
    public WebElement orderNumFilterField;

    @FindBy(xpath = "//*[@id=\"search-orders\"]")
    public WebElement filterButton;

    @FindBy(xpath = "//*[@id=\"reset-filters\"]")
    public WebElement clearFiltersButton;

    @FindBy(xpath = "/html/body/div[1]/div/section[2]/section/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")
    public WebElement orderNumberLink;

}
