package ui.methods;

import helper.Helper;

import java.util.*;

public class SaveOrderInfo {
    SelectRandom selectRandom = new SelectRandom();
    public String orderNumber;
    public List<String> moveOptionName = selectRandom.list;
    public Map<String, String> orderInfo = new LinkedHashMap<String, String>();
    public Map<String, String> inventoryListInfo = new LinkedHashMap<String, String>();

    public SaveOrderInfo() {
    }

    public void setOrderInfo(String key, String value) {
        orderInfo.put(key, value);
    }

    public void setInventoryListInfo(String key, String value) {
        inventoryListInfo.put(key, value);
    }



}
