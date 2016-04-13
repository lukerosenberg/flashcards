package lrosenberg.flashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class DBTest {
        public static abstract class CardEntry implements BaseColumns {
            public static final String TABLE_NAME = "cards";
            public static final String FRONT = "front";
            public static final String BACK = "back";
            public static final String NTIME = "ntime";
            public static final String PTIME = "ptime";
        }

        private static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + CardEntry.TABLE_NAME + " (" +
                        CardEntry._ID + " INTEGER PRIMARY KEY, " +
                        CardEntry.FRONT + " TEXT, " +
                        CardEntry.BACK + " TEXT, " +
                        CardEntry.NTIME + " INTEGER, " +
                        CardEntry.PTIME + " INTEGER)";

        private static final String SQL_DROP_TABLE =
                "DROP TABLE IF EXISTS " + CardEntry.TABLE_NAME;

        public class CardDBHelper extends SQLiteOpenHelper {

            public CardDBHelper(Context context) {
                super(context, "deck.db", null, 1);
            }

            public void onCreate(SQLiteDatabase db) {

            }

            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
            public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

            public void createDB(SQLiteDatabase db) {
                db.execSQL(SQL_CREATE_TABLE);
            }

            public long newCard(SQLiteDatabase db, String front, String back, int ntime, int ptime) {
                this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(CardEntry.FRONT, front);
                values.put(CardEntry.BACK, back);
                values.put(CardEntry.NTIME, ntime);
                values.put(CardEntry.PTIME, ptime);

                long newRowId;
                newRowId = db.insert(
                        CardEntry.TABLE_NAME,
                        null,
                        values
                );
                return newRowId;
            }
        }



}