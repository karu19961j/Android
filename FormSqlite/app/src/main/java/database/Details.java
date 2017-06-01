package database;
public class Details {
    public static final String TABLE_NAME="student";
    public static final String COL_ID="id";
    public static final String COL_FNAME="fname";
    public static final String COL_LNAME="lname";
    public static final String COL_PHONE="phone";

    public static final String[] GET_ALLDATA={COL_ID,COL_FNAME,COL_LNAME,COL_PHONE};

    public static final String SQL_QUERY="CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY," + COL_FNAME + " TEXT," + COL_LNAME + " TEXT," + COL_PHONE + " TEXT" + ");";

}
