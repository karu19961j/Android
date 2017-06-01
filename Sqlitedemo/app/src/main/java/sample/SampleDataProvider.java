package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DataItem;

public class SampleDataProvider {
    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();
addItem(new DataItem(null,"iii","kkkk","hhhh",2,34.0,"apple_pie.jpg"));
        //addItem(new DataItem(null,"Quinoa Salmon Salad","Salads","Our quinoa salad",1,12.0,"image_10101.png"));  
       // addItem(new DataItem(null,"Chef's Salad", "Salads","The chef’s salad has cucumber, tomatoes, red onions, mushrooms, hard-boiled eggs",1,23,"image_10102.png"));

    }
private static void addItem(DataItem item) {
    dataItemList.add(item);
    dataItemMap.put(item.getItemId(),item);
    }
}
