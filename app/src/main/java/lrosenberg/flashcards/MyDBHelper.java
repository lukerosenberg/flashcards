package lrosenberg.flashcards;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String dbName = "test.db";
    public static final String cardTableName = "cards";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + cardTableName + " (" +
                   "_id INTEGER PRIMARY KEY AUTOINCREMENT, front TEXT, back TEXT, " +
                   "ntime INTEGER, ptime INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}