package com.example.karan.androidphpmysql;

import com.google.gson.annotations.SerializedName;
public class Ddetails {

    @SerializedName("doctor_id")
    public int doctor_id;

    @SerializedName("speciality")
    public String speciality;

    @SerializedName("name")
    public String name;

    @SerializedName("address")
    public String address;

    @SerializedName("phone")
    public String phone;

}
