package org.example.ui.methods;

import org.example.helper.DropDownHelper;
import org.example.helper.Helper;
import org.example.helper.JavaFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.ui.pageObjectModel.PaymentPage;
import org.example.utilities.Driver;

import java.util.List;
import java.util.Random;

public class PerformActionOnElements {
    PaymentPage paymentPage = new PaymentPage();
    Random random = new Random();

    private String[] valuesToFillFields;

    WebDriver driver = Driver.getDriver();

    public String returnName(){
        return JavaFaker.fakeFirstName();
    }

    public void fillCCFieldsInPayment(){
        Helper.javascriptScrollIntoView(paymentPage.newPaymentCard);
        Helper.click(paymentPage.newPaymentCard);
        Helper.sendKeys(paymentPage.cardNameInputField, "clientFirstName");
        Helper.javascriptScrollIntoView(paymentPage.cardNumberInputField);
        Helper.sendKeys(paymentPage.cardNumberInputField, "5424 0000 0000 0015");
        DropDownHelper.chooseMoveFrom(driver, "mm", 5);
        DropDownHelper.chooseMoveFrom(driver, "yy", 4);
//        DropDownHelper.selectUsingVisibleText(paymentPage.expiryMonthSelectField, "05");
//        DropDownHelper.selectUsingVisibleText(paymentPage.expiryYearSelectField, "27");
        Helper.sendKeys(paymentPage.cvvNumberInputField, "123");
        Helper.pause(3000);
        Helper.javascriptScrollIntoView(paymentPage.billingAddressCheckBox);
        Helper.javascriptClick(paymentPage.billingAddressCheckBox);
        Helper.pause(3000);
    }

    public void fillCCFieldsElementTest(WebElement... elements) {
        Helper.pause(1000);
        int valueIndex = 0; // Индекс значения в массиве valuesToFillFields
        String value = "";

        for (WebElement element : elements) {
            String elementType = element.getTagName();
            System.out.println("elementType "+elementType);
            String inputType = element.getAttribute("type");
            System.out.println("inputType is "+inputType);
            String clickType = element.getAttribute("class");
            System.out.println("clickType is "+clickType);
            Helper.pause(1000);

            if (elementType.equalsIgnoreCase("input") && !inputType.equals("radio") && !inputType.equals("checkbox")) {
                if (valueIndex < valuesToFillFields.length) {
                    value = valuesToFillFields[valueIndex];
                    if (inputType.equals("text") || inputType.equals("password") || inputType.equals("number")) {
                        Helper.pause(1000);
                        Helper.javascriptScrollIntoView(element);
                        Helper.pause(1000);
//                        Helper.navigateToElement(element);
                        Helper.sendKeys(element, value);
                    }
                    valueIndex++; // Увеличение индекса для следующего значения
                }
            } else if (elementType.equalsIgnoreCase("button") || (elementType.equalsIgnoreCase("input") && inputType.equals("checkbox") ||
                    inputType.equals("radio")) || elementType.equalsIgnoreCase("a") || (elementType.equalsIgnoreCase("h3") && clickType.contains("restrictions-title"))) {
                Helper.pause(1000);
                Helper.javascriptScrollIntoView(element);
//                Helper.javascriptClick(element);
                Helper.click(element);
            } else if (elementType.equalsIgnoreCase("select")) {
                Helper.pause(1000);
                Helper.javascriptScrollIntoView(element);
                DropDownHelper.selectUsingVisibleText(element, value);
            } else {
                throw new IllegalArgumentException("Undefined type of element");
            }
        }
    }

    public void setValuesToFillFields(String... values) {
        valuesToFillFields = values;
    }

    public void clickRandomCreditCard(List<WebElement> elements) {
        if (!elements.isEmpty()) {
            int randomIndex = random.nextInt(elements.size());
            WebElement randomElement = elements.get(randomIndex);
            Helper.javascriptScrollDownThePage();
            Helper.pause(2000);
            Helper.javascriptScrollIntoView(randomElement);
            Helper.click(randomElement);
        } else {
            Helper.pause(2000);
            fillCCFieldsInPayment();
        }
    }
}
