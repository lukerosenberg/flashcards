package lrosenberg.flashcards.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import lrosenberg.flashcards.R;

public class ReviewFragment extends Fragment {

    private ImageView flashcardImage;
    private Button correctButton;
    private Button incorrectButton;
    private TextView cardText;

    public ReviewFragment() {
    }

    public static ReviewFragment newInstance(){
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review, container, false);
        correctButton = (Button) view.findViewById(R.id.correctButton);
        incorrectButton = (Button) view.findViewById(R.id.incorrectButton);
        cardText = (TextView) view.findViewById(R.id.textView);
        flashcardImage = (ImageView) view.findViewById(R.id.flashcard);

        correctButton.setVisibility(View.INVISIBLE);
        incorrectButton.setVisibility(View.INVISIBLE);

        cardText.setText("Front of Flashcard"); //Replace with call to function to get card front
        flashcardImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cardText.setText("Back of Flashcard"); //Replace with code to show back of text
                correctButton.setVisibility(View.VISIBLE);
                incorrectButton.setVisibility(View.VISIBLE);
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
