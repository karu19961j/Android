package Data;

import java.util.ArrayList;
import java.util.List;

import model.Find;

/**
 * Created by juhi bhatnagar on 3/7/2017.
 */
public class Doctors_data {
    private static List<Find> find=new ArrayList<>();
    public static List<Find>getData()
    {
        return find;
    }
    static
    {

        find.add(new Find("Opthalmologist","(Eye Specialist)"));
        find.add(new Find("Dermatologist","(Skin Specialist)"));
        find.add(new Find("Cardiologist","(Heart Specialist)"));
        find.add(new Find("Psychiatrist","(Mental Health Specialist)"));
        find.add(new Find("ENT","(Ear-Nose-Throat Specialist)"));
        find.add(new Find("Gynecologist","(Women Health Specialist)"));
        find.add(new Find("Neurologist","(Neuro Specialist)"));

    }
}
