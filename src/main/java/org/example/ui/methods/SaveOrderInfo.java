package org.example.ui.methods;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveOrderInfo {
    SelectRandom selectRandom = new SelectRandom();
    public List<String> moveOptionName = selectRandom.list;
    public Map<String, String> orderInfo = new LinkedHashMap<String, String>(); // Храниться данные ордера
//    public Map<String, String> inventoryListInfo = new LinkedHashMap<String, String>(); // Храниться элмементы и цены ордера
    public Multimap<String, String> inventoryListInfo = ArrayListMultimap.create();
    public List<String> priceListBo = new ArrayList<>();

    public SaveOrderInfo() {
    }

    public void setOrderInfo(String key, String value) {
        orderInfo.put(key, value);
    }

    public void setInventoryListInfo(String key, String value) {
        inventoryListInfo.put(key, value);
    }

//    public void setInventoryListInfo2(List<WebElement> listItems) {
//        for (WebElement listItem : listItems) {
//            String text = listItem.getText();
//            String word = text.replaceAll("[^a-zA-Z\\s-]", "").trim();
//            String number = text.replaceAll("[^\\d.,$-]", "").trim();
//
//            inventoryListInfo.put(word, number);
//        }
//    }

    public void setInventoryListInfo3(List<WebElement> listItems) {
        for (WebElement listItem : listItems) {
            String text = listItem.getText();
            String word = text.replaceAll("[^a-zA-Z\\s-]", "").trim();

            // Извлекаем значение number из строки
            String number = text.replaceAll("[^\\d.,$-]", "").trim();

            // Проверяем наличие символа "-" только в значении number и добавляем его при необходимости
            if (!number.isEmpty()) {
                if (number.startsWith("-")) {
                    inventoryListInfo.put(word, number);
                } else {
                    inventoryListInfo.put(word, number.replaceAll("-", ""));
                }
            }
        }
    }

//    public static String extractValue(String text) {
//        Pattern pattern = Pattern.compile("-?\\$?[0-9,.]+");
//        Matcher matcher = pattern.matcher(text);
//        if (matcher.find()) {
//            return matcher.group();
//        }
//        return "";
//    }

    public static String extractValue(String text) {
        Pattern pattern = Pattern.compile("([-\\$]?[0-9,.]+)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static String extractLabel(String list) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(list);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

}
