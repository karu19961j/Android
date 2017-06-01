package Data;

import java.util.ArrayList;
import java.util.List;

import model.Ayurved;
import model.Find;

/**
 * Created by juhi bhatnagar on 3/8/2017.
 */
public class AyurvedicDoctors_data {
    private static List<Ayurved> ayurved = new ArrayList<>();

    public static List<Ayurved> getData() {
        return ayurved;
    }

    static {

        ayurved.add(new Ayurved("Siddha"));
        ayurved.add(new Ayurved("Yoga"));
        ayurved.add(new Ayurved("Naturopathy"));

    }
}
