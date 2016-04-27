package lrosenberg.flashcards.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lrosenberg.flashcards.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    private AddFragment addFragment;
    private EditFragment editFragment;
    private ReviewFragment reviewFragment;

    public static MainMenuFragment newInstance(){
        MainMenuFragment fragment = new MainMenuFragment();
        return fragment;
    }

    public MainMenuFragment() {
        // Required empty public constructor
    }

    /*
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        final Button addButton = (Button)view.findViewById(R.id.addButton);
        final Button editButton = (Button)view.findViewById(R.id.editButton);
        final Button reviewButton = (Button)view.findViewById(R.id.reviewButton);

        addFragment = AddFragment.newInstance();
        editFragment = EditFragment.newInstance();
        reviewFragment = ReviewFragment.newInstance();


        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, addFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, editFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        reviewButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, reviewFragment);
                ft.addToBackStack(null);
                ft.commit();
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
