package lrosenberg.flashcards.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;


public class CardDB {
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    public CardDB(Context context) {
        dbHelper = new MyDBHelper(context, "deck.db", null, 1);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void addCard(Card newCard) {
        ContentValues vals = new ContentValues();
        vals.put(dbHelper.columnFront, newCard.getFront());
        vals.put(dbHelper.columnBack, newCard.getBack());
        vals.put(dbHelper.columnNtime, newCard.getNtime());
        vals.put(dbHelper.columnPtime, newCard.getPtime());

        db.insert(dbHelper.cardTableName, null, vals);
    }

    public void deleteCard(String front) {

        db.execSQL("Delete from " + dbHelper.cardTableName + " where " + dbHelper.columnFront + " = \"" + front + "\";");
        //db.delete(dbHelper.cardTableName, dbHelper.columnFront + " = " + front, null);
    }

    public Card getRandomCard() {
        String[] getCols = new String[] {dbHelper.columnFront, dbHelper.columnBack};

        Cursor cursor = db.query(dbHelper.cardTableName, getCols, null, null, null, null, "RANDOM()");
        if (!cursor.moveToFirst())
            return null;

        Card c = new Card(cursor.getString(cursor.getColumnIndex(dbHelper.columnFront)), cursor.getString(cursor.getColumnIndex(dbHelper.columnBack)), 0, 0);
        //Card c = new Card(cursor.getString(1), cursor.getString(2), 0, 0);
        return c;
    }
}