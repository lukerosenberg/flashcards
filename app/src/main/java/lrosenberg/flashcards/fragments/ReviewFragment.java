package lrosenberg.flashcards.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import lrosenberg.flashcards.MainActivity;
import lrosenberg.flashcards.R;
import lrosenberg.flashcards.database.Card;

public class ReviewFragment extends Fragment {

    private ImageView flashcardImage;
    private ImageButton deleteButton;
    private Button correctButton;
    private Button incorrectButton;
    private TextView cardText;
    private ReviewFragment reviewFragment;

    public MainActivity main_activity;


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
        main_activity = (MainActivity)getActivity();
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        correctButton = (Button) view.findViewById(R.id.correctButton);
        incorrectButton = (Button) view.findViewById(R.id.incorrectButton);
        cardText = (TextView) view.findViewById(R.id.textView);
        flashcardImage = (ImageView) view.findViewById(R.id.flashcard);
        deleteButton = (ImageButton)view.findViewById(R.id.deleteButton);

        correctButton.setVisibility(View.INVISIBLE);
        incorrectButton.setVisibility(View.INVISIBLE);

        final Card testCard;

        testCard = main_activity.db.getRandomCard();
        cardText.setText(testCard.getFront());

        flashcardImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cardText.setText(testCard.getBack());
                correctButton.setVisibility(View.VISIBLE);
                incorrectButton.setVisibility(View.VISIBLE);
            }
        });

        reviewFragment = reviewFragment.newInstance();

        correctButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, reviewFragment);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, reviewFragment);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setMessage("Are you sure you want to delete this flashcard?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Delete",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Code to delete flashcard from database
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
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
