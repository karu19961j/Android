package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String fname;
    private String lname;
    private String mobile;

    protected Student(Parcel in) {
        fname = in.readString();
        lname = in.readString();
        mobile = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Student(String fname, String lname, String mobile) {
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
    }
    public Student(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(mobile);
    }
}
