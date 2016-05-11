package lrosenberg.flashcards.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import lrosenberg.flashcards.MainActivity;
import lrosenberg.flashcards.R;
import lrosenberg.flashcards.database.Card;

public class AddFragment extends Fragment {

    private EditText frontText;
    private EditText backText;

    public MainActivity main_activity;

    public static AddFragment newInstance(){
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        main_activity = (MainActivity)getActivity();
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        frontText = (EditText)view.findViewById(R.id.frontText);
        backText = (EditText)view.findViewById(R.id.backText);

        Button addCardButton = (Button)view.findViewById(R.id.addCardButton);
        addCardButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                main_activity.db.addCard(new Card(frontText.getText().toString(),
                                                      backText.getText().toString(),
                                                      (int)(System.currentTimeMillis()/1000),
                                                      (int)(System.currentTimeMillis()/1000)));
                frontText.setText("");
                backText.setText("");

                Toast.makeText(getActivity(),"Card Added to Database",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
