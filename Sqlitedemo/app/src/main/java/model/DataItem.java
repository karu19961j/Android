package model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import database.ItemsTable;

public class DataItem implements Parcelable{
    private String itemId;
    private String itemName;
    private String description;
    private String category;
    private int sortPosition;
    private double price;
    private String image;


    public DataItem() {
    }

    protected DataItem(Parcel in) {
        itemId = in.readString();
        itemName = in.readString();
        description = in.readString();
        category = in.readString();
        sortPosition = in.readInt();
        price = in.readDouble();
        image = in.readString();
    }

    public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

    public DataItem(String itemId, String itemName, String description, String category, int sortPosition, double price, String image) {
        if(itemId==null)
        {
            itemId= UUID.randomUUID().toString();
        }
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", sortPosition=" + sortPosition +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(itemName);
        dest.writeString(description);
        dest.writeString(category);
        dest.writeInt(sortPosition);
        dest.writeDouble(price);
        dest.writeString(image);
    }
    public ContentValues toValues(){
        ContentValues values=new ContentValues(7);
        values.put(ItemsTable.COLUMN_ID,itemId);
        values.put(ItemsTable.COLUMN_NAME,itemName);
        values.put(ItemsTable.COLUMN_DESCRIPTION,description);
        values.put(ItemsTable.COLUMN_CATEGORY,category);
        values.put(ItemsTable.COLUMN_POSITION,sortPosition);
        values.put(ItemsTable.COLUMN_PRICE,price);
        values.put(ItemsTable.COLUMN_IMAGE,image);
        return values;
    }
}
