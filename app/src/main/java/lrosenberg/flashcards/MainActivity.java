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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TextView textView = (TextView) findViewById(R.id.textView);
        setSupportActionBar(toolbar);

        final Button changeButton = (Button) findViewById(R.id.button);
        changeButton.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              textView.setText("Back of Flashcard");

          }
        });

    }
}