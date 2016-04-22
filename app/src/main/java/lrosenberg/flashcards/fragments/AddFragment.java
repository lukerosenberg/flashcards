package lrosenberg.flashcards.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import lrosenberg.flashcards.R;

public class AddFragment extends Fragment {

    private EditText frontText;
    private EditText backText;

    public static AddFragment newInstance(){
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        frontText = (EditText)view.findViewById(R.id.frontText);
        backText = (EditText)view.findViewById(R.id.backText);
        Button addCardButton = (Button)view.findViewById(R.id.addCardButton);
        addCardButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

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
