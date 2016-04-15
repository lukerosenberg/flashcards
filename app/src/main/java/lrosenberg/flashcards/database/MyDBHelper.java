package lrosenberg.flashcards.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String dbName = "test.db";
    public static final String cardTableName = "cards";
    public static final String columnID = "_id";
    public static final String columnFront = "front";
    public static final String columnBack = "back";
    public static final String columnNtime = "ntime";
    public static final String columnPtime = "ptime";


    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + cardTableName + " (" +
                   columnID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                   columnFront + " TEXT, " +
                   columnBack + " TEXT, " +
                   columnNtime + " INTEGER, " +
                   columnPtime + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}