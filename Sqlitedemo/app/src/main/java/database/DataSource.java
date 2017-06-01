package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.DataItem;

public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDBhelper;

    public DataSource(Context context){
        this.mContext=context;
        mDBhelper=new DBHelper(mContext);
        mDatabase=mDBhelper.getWritableDatabase();
    }
    public void open(){
        mDatabase=mDBhelper.getWritableDatabase();
    }
    public void close(){
        mDBhelper.close();
    }
    public DataItem createItem(DataItem item){
        ContentValues values=item.toValues();
        mDatabase.insert(ItemsTable.TABLE_ITEMS,null,values);
        return item;
    }
    public long getDataItemsCount(){
        return DatabaseUtils.queryNumEntries(mDatabase,ItemsTable.TABLE_ITEMS);
    }
    public void seedDatabase(List<DataItem> dataItemList){
        long numItems=getDataItemsCount();
        if(numItems==0){
            for(DataItem item: dataItemList){
                try{
                    createItem(item);
                }
                catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public List<DataItem>getAllItems(){
        List<DataItem>dataItems=new ArrayList<>();
        Cursor cursor=mDatabase.query(ItemsTable.TABLE_ITEMS,ItemsTable.ALL_COLUMNS,null,null,null,null,null);
        while(cursor.moveToNext()){
            DataItem item=new DataItem();
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setDescription(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setCategory(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            item.setSortPosition(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_POSITION)));
            item.setPrice(cursor.getDouble(cursor.getColumnIndex(ItemsTable.COLUMN_PRICE)));
            item.setImage(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_IMAGE)));
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}
