package lrosenberg.flashcards;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String front = "Front of Flashcard";
    String back = "Back of Flashcard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button addButton = (Button) findViewById(R.id.addButton);
        final Button editButton = (Button) findViewById(R.id.editButton);
        final Button reviewButton = (Button) findViewById(R.id.reviewButton);
    }
}