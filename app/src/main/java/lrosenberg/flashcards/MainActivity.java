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

import lrosenberg.flashcards.database.CardDB;
import lrosenberg.flashcards.fragments.AddFragment;
import lrosenberg.flashcards.fragments.MainMenuFragment;

public class MainActivity extends AppCompatActivity {

    private MainMenuFragment mainMenuFragment;
    private AddFragment addFragment;
    private CardDB db = new CardDB(this);

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainMenuFragment = MainMenuFragment.newInstance();
        addFragment = AddFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, mainMenuFragment)
                .commit();

    }
}