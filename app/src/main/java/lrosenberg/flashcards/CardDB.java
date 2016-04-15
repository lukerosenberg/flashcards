package lrosenberg.flashcards;

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
    }

    public void deleteCard(int id) {
    }
}
