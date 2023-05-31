package ui.methods;

import java.util.Map;

public class GetOrderInfo {
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();

    public void getOrderNumber(){
        for(Map.Entry<String, String> item : saveOrderInfo.orderInfo.entrySet()){
            System.out.printf("Key: %s, Value: %s \n", item.getKey(), item.getValue());
        }
    }

    public String getMoveOptionName() {
        String firstOption = null;
        for(int i =0; i < saveOrderInfo.moveOptionName.size();i++){
            firstOption = (saveOrderInfo.moveOptionName.get(0));
        }
        return firstOption;
    }
}
