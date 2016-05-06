package lrosenberg.flashcards.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter{
    private Context context;
    private String[] texts = {"These", "Are", "Flashcards", "Maybe?", "Flashcard 5",
            "Flashcard 6", "Flashcard 7", "Flashcard 8", "Flashcard 9"};

    public TextAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return texts.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = new TextView(context);
        }

        else {
            tv = (TextView) convertView;
        }

        tv.setText(texts[position]);
        return tv;
    }
}
