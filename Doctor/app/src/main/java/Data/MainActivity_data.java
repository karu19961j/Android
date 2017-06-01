package Data;

import java.util.ArrayList;
import java.util.List;

import model.ListItem;

/**
 * Created by juhi bhatnagar on 3/7/2017.
 */
public class MainActivity_data {
    private static List<ListItem> lists=new ArrayList<>();
    public static List<ListItem>getData()
    {
        return lists;
    }
    static
    {
        lists.add(new ListItem("Book an appointment",1,"(Find doctors,clincs,diagnostic labs)"));
        lists.add(new ListItem("Add a medical record",2,"(upload prescription,reports)"));
        lists.add(new ListItem("Set medicine reminder",3,"(get alerts)"));

    }
}

