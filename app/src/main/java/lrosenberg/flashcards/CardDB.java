package lrosenberg.flashcards;

import android.content.ContentValues;
import android.content.Context;
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

    public void deleteCard(int id) {
        db.delete(dbHelper.cardTableName, dbHelper.columnID + " = " + id, null);
    }
}