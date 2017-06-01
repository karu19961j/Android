package Data;

import java.util.ArrayList;
import java.util.List;


import model.Nutrition;

/**
 * Created by juhi bhatnagar on 3/9/2017.
 */
public class Therapist_data {
    private static List<Nutrition> nutrition = new ArrayList<>();

    public static List<Nutrition> getData() {
        return nutrition;
    }

    static {

        nutrition.add(new Nutrition("Physiotherapist","(Treatment by phyiscal methods)"));
        nutrition.add(new Nutrition("Psycologist","(Expert who study mind) "));
        nutrition.add(new Nutrition("Audiologist","(Expert in hearing problems)"));
        nutrition.add(new Nutrition("Dietitian/Nutritionist","(Expert in human nutrition)"));

    }
}
