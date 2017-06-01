package com.example.karan.classtextview;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String sdnm;
    private  int rollno;
    private int marks;
    public String getSdnm() {
        return sdnm;
    }

    public void setSdnm(String sdnm) {
        this.sdnm = sdnm;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public static final Parcelable.Creator<Student>CREATOR=new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
//            Student s = new Student();
//            s.sdnm = source.readString();
//            s.rollno = source.readInt();
//            s.marks = source.readInt();
            return new Student(source);
        }


        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sdnm);
        dest.writeInt(rollno);
        dest.writeInt(marks);
    }
    public Student(Parcel in)
    {
        sdnm=in.readString();
        rollno=in.readInt();
        marks=in.readInt();
    }
    public  Student(){}
}
