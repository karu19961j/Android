package model;

/**
 * Created by juhi bhatnagar on 3/9/2017.
 */

public class Address {
    private int docid;
    private String title;
    private String address;
    private int fee;
    private String phone;

    public Address(String title, String address, int fee) {
        this.title = title;
        this.address = address;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
