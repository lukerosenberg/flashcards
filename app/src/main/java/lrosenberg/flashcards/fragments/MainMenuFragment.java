package lrosenberg.flashcards.fragments;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import lrosenberg.flashcards.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    private AddFragment addFragment;
    private EditFragment editFragment;
    private ReviewFragment reviewFragment;
   // private ImageView add;
   // private ImageView edit;
   // private ImageView review;
    private ImageButton add;
    private ImageButton edit;
    private ImageButton review;


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
        //final Button addButton = (Button)view.findViewById(R.id.addButton);
        final ImageButton addButton = (ImageButton)view.findViewById(R.id.addImage);
        //final Button editButton = (Button)view.findViewById(R.id.editButton);
        final ImageButton editButton= (ImageButton)view.findViewById(R.id.editImage);
        //final Button reviewButton = (Button)view.findViewById(R.id.reviewButton);
        final ImageButton reviewButton = (ImageButton)view.findViewById(R.id.reviewImage);

        addFragment = AddFragment.newInstance();
        editFragment = EditFragment.newInstance();
        reviewFragment = ReviewFragment.newInstance();
        //add = (ImageView)view.findViewById(R.id.add);



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
