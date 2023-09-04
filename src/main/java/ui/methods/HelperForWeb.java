package ui.methods;

import helper.DropDownHelper;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.qabo.*;

import java.util.List;

import static ui.methods.SetUp.driver;

public class HelperForWeb {
    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    UsersQabo usersQabo = new UsersQabo();

    public String email;

    public static String substringMoverName(String input){
        String staticPrefix = "Carrier Name: ";
        int startIndex = input.indexOf(staticPrefix) + staticPrefix.length();
        int endIndex = input.indexOf("/");
        return input.substring(startIndex, endIndex).trim();
    }

    public void navigateToSupplierEmail(List<WebElement> elements){
        if (elements.size() > 0) {
            // Вывести текст первого элемента
            email =  elements.get(0).getText();
            WebElement editButton = driver.findElement(By.xpath("//td[text()='" + email + "']/following-sibling::td/a[text()='Edit']"));
            if (editButton != null) {
                editButton.click();
                System.out.println("button 'Edit' clicked.");
            } else {
                System.out.println("Button 'Edit' not found.");
            }
        } else {
            System.out.println("Element not found");
        }
    }

    public void setCarrierNewPassword(String moverName, String moverPassword, String orderNumber){
        Helper.click(qaboDashBoardPage.usersLabelInSideBar);
        Helper.waitForElementToBeDisplayed(usersQabo.usersTitle);
        Helper.sendKeys(usersQabo.companyNameInputField, moverName);
        Helper.click(usersQabo.updateFilterButton);
        Helper.pause(2000);
        navigateToSupplierEmail(usersQabo.emailsWithRoleSupplier);
        Helper.waitForElementToBeDisplayed(usersQabo.changePasswordButton);
        Helper.javascriptScrollIntoView(usersQabo.changePasswordButton);
        Helper.click(usersQabo.changePasswordButton);
        Helper.waitForElementToBeDisplayed(usersQabo.newPasswordInputField);
        Helper.sendKeys(usersQabo.newPasswordInputField, moverPassword);
        Helper.click(usersQabo.saveButton);
        usersQabo.changePasswordButton.isDisplayed();
        Helper.click(qaboDashBoardPage.logOffButton);
    }
}
