package ui.methods;

import helper.DropDownHelper;
import helper.Helper;
import helper.JavaFaker;
import org.openqa.selenium.WebElement;
import ui.pageObjectModel.PaymentPage;

public class PerformActionOnElements {
    PaymentPage paymentPage = new PaymentPage();
    private String[] valuesToFillFields;


    public String returnName(){
        return JavaFaker.fakeFirstName();
    }

    public void fillCCFieldsInPayment(){
        Helper.javascriptScrollIntoView(paymentPage.newPaymentCard);
        Helper.click(paymentPage.newPaymentCard);
        Helper.sendKeys(paymentPage.cardNameInputField, "clientFirstName");
        Helper.javascriptScrollIntoView(paymentPage.cardNumberInputField);
        Helper.sendKeys(paymentPage.cardNumberInputField, "5424 0000 0000 0015");
        Helper.sendKeys(paymentPage.cvvNumberInputField, "123");
        DropDownHelper.selectUsingVisibleText(paymentPage.expiryMonthSelectField, "May");
        DropDownHelper.selectUsingVisibleText(paymentPage.expiryYearSelectField, "2027");
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
            String inputType = element.getAttribute("type");
            System.out.println("inputType is "+inputType);
            String clickType = element.getAttribute("ng-class");
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
            } else if (elementType.equalsIgnoreCase("button") || (elementType.equalsIgnoreCase("input") && inputType.equals("checkbox") || inputType.equals("radio")) || elementType.equalsIgnoreCase("a")|| elementType.equalsIgnoreCase("h3")&& clickType.contains("myaddress.showRestr")) {
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

    public void getValuesToFillFields2() {
        for (String value : valuesToFillFields) {
            System.out.println(value);
        }
    }
}
