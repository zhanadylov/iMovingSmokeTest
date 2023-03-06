package ui.methods;

import java.util.ArrayList;
import java.util.List;

public class SaveOrderInfo {
    SelectRandom selectRandom = new SelectRandom();
    public String orderNumber;
    public List<String> moveOptionName = selectRandom.list;


    public SaveOrderInfo() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getMoveOptionName() {
        String firstOption = null;
        for(int i =0; i < moveOptionName.size();i++){
            firstOption = (moveOptionName.get(0));
        }
            return firstOption;
    }

}
