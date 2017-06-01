package model;


import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import database.ItemsTable;

public class DataItem implements Parcelable{
    private String itemid;
    private String itemname;
    private String description;
    private String category;
    private int sortPosition;
    private double price;
    private String image;
    public DataItem()
    {

    }

    public DataItem(String itemid, String itemname, String description, String category, int sortPosition, double price, String image) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.description = description;
        this.category = category;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    public DataItem(Parcel in) {
        this.itemid = in.readString();
        this.itemname = in.readString();
        this.description = in.readString();
        this.category = in.readString();
        this.sortPosition = in.readInt();
        this.price = in.readDouble();
        this.image = in.readString();

    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentValues toValues()
    {
        ContentValues values = new ContentValues(7);

        values.put(ItemsTable.COLUMN_ID, itemid);
        values.put(ItemsTable.COLUMN_NAME, itemname);
        values.put(ItemsTable.COLUMN_DESCRIPTION, description);
        values.put(ItemsTable.COLUMN_CATEGORY, category);
        values.put(ItemsTable.COLUMN_POSITION, sortPosition);
        values.put(ItemsTable.COLUMN_PRICE, price);
        values.put(ItemsTable.COLUMN_IMAGE, image);
        return values;

    }
    @Override
    public String toString() {
        return "DataItem{" +
                "itemid='" + itemid + '\'' +
                ", itemname='" + itemname + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", sortPosition=" + sortPosition +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemid);
        dest.writeString(this.itemname);
        dest.writeString(this.description);
        dest.writeString(this.category);
        dest.writeInt(this.sortPosition);
        dest.writeDouble(this.price);
        dest.writeString(this.image);
    }
    public static final  Parcelable.Creator<DataItem>CREATOR=new Parcelable.Creator<DataItem>()
    {
        public DataItem createFromParcel(Parcel source) {
            return new DataItem(source);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

}

