package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.Student;

import static database.Details.COL_FNAME;
import static database.Details.COL_ID;
import static database.Details.COL_LNAME;
import static database.Details.COL_PHONE;
import static database.Details.DropTable;
import static database.Details.TABLE_NAME;


public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_FILENAME="student.db";
    public static final int DB_VERSION=1;
    private SQLiteDatabase msqlite;
    public DBhelper(Context context) {
        super(context,DB_FILENAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Details.SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropTable);
        onCreate(db);
    }
    public void InsertData(String firstname,String lastname,String mobile){
        msqlite=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_FNAME,firstname);
        values.put(COL_LNAME,lastname);
        values.put(COL_PHONE,mobile);
        msqlite.insert(TABLE_NAME,null,values);
        msqlite.close();
    }
    public List<Student> getAllData(){
        List<Student> std1=new ArrayList<>();
        msqlite=this.getReadableDatabase();
        Cursor cursor=msqlite.query(Details.TABLE_NAME,Details.GET_ALLDATA,null,null,null,null,null);
        while(cursor.moveToNext()){
            Student stds=new Student();
            stds.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
            stds.setFname(cursor.getString(cursor.getColumnIndex(COL_FNAME)));
            stds.setLname(cursor.getString(cursor.getColumnIndex(COL_LNAME)));
            stds.setMobile(cursor.getString(cursor.getColumnIndex(COL_PHONE)));
            std1.add(stds);
        }
        cursor.close();
        return std1;
    }
    public void StdnUpgrade(int id,String newFname,String newLname,String newPhone){
        msqlite=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_FNAME,newFname);
        cv.put(COL_LNAME,newLname);
        cv.put(COL_PHONE,newPhone);
        msqlite.update(TABLE_NAME,cv,COL_ID+ "=?",new String[]{String.valueOf(id)});

    }
    public void stdnDelete(int id1){
        msqlite=getWritableDatabase();
        msqlite.delete(TABLE_NAME,COL_ID+ "=?",new String[]{String.valueOf(id1)});
    }
}
