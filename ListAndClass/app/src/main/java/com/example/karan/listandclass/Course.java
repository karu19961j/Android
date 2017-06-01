package com.example.karan.listandclass;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    private String cname;
    private String desc;
    private int id;
    protected Course(Parcel in) {
        cname=in.readString();
        desc=in.readString();
        id=in.readInt();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public Course(String cname) {
        this.cname = cname;
    }

    public Course(String cname, String desc, int id) {
        this.cname = cname;
        this.desc = desc;
        this.id = id;
    }

    public Course() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cname);
        dest.writeString(desc);
        dest.writeInt(id);
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
   // public Course(){}
}
