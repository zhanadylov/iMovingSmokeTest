package org.example.ui.methods;

import com.google.common.collect.Multimap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.utilities.Driver;

import java.util.List;
import java.util.Map;

public class GetOrderInfo {
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    static WebDriver driver = Driver.getDriver();

    public void getOrderNumber(){
        for(Map.Entry<String, String> item : saveOrderInfo.orderInfo.entrySet()){
            System.out.println("Order number is "+saveOrderInfo.orderInfo.get("Order #"));
        }
    }

    public String getMoveOptionName() {
        String firstOption = null;
        for(int i =0; i < saveOrderInfo.moveOptionName.size();i++){
            firstOption = (saveOrderInfo.moveOptionName.get(0));
        }
        return firstOption;
    }

    public void getOrderInfo(Map<String,String> list){
        for(Map.Entry<String, String> item : list.entrySet()){
            System.out.printf("Key: %s, Value: %s \n", item.getKey(), item.getValue());
        }
    }

    public void getOrderInfoMulti(Multimap<String, String> list) {
        for (String key : list.keySet()) {
            System.out.printf("Key: %s\n", key);
            for (String value : list.get(key)) {
                System.out.printf("Values: %s\n", value);
            }
            System.out.println();
        }
    }

    public void getOrderData(List<WebElement> listItems){
        for (WebElement item : listItems) {
            String data = item.getText();
//            String word = SaveOrderInfo.extractLabel(data);
            String number = SaveOrderInfo.extractValue(data);
            System.out.println("Value: "+ number);
        }
    }

    public void comparePriceWebBo(List<String> listItems, Multimap<String, String> inventoryListInfo){
        for (String price : listItems) {
            if (inventoryListInfo.containsValue(price)) {
                System.out.println("Element " + price + " exist on inventoryListInfo.");
            } else {
                System.out.println("Element " + price + " not exist on inventoryListInfo.");
            }
        }
    }

    public String getOrderPriceByCarrierName(String carrierName){
        String priceLocatorString = "//div[contains(normalize-space(@class), 'movers-cards')]//div[@class='flex-wrap' and .//p[contains(text(),'"+carrierName+"')]]//p[contains(normalize-space(@class), 'text-price')]";
        WebElement priceLocator = driver.findElement(By.xpath(priceLocatorString));
        return priceLocator.getText();
    }
}
