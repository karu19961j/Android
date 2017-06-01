package Data;

import java.util.ArrayList;
import java.util.List;

import model.Address;

public class Doctor_Eye_data {
    private static List<Address> address = new ArrayList<>();

    public static List<Address> getData() {
        return address;
    }

    static {

        address.add(new Address("Dr. Mohit Grover","Grover Eye Laser & ENT Hospital\n Sector 35,Chandigarh",500));
        address.add(new Address("Dr. Raman Mittal","Landmark Hospital\n Sector 33,Chandigarh",300));
        address.add(new Address("Dr. Sujata Grover","Grover Eye Laser & ENT Hospital\n Sector 35,Chandigarh",500));
        address.add(new Address("Dr. Amandeep Kaur Sangha","Aman Eye Care Hospital\n Zirakpur ",250));



    }
}
