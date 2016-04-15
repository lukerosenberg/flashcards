package lrosenberg.flashcards.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lrosenberg.flashcards.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {


    MenuListener activityCommander;
    public interface MenuListener{
        void loadMenu();
    }


    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        Button addButton = (Button)view.findViewById(R.id.addButton);
        Button editButton = (Button)view.findViewById(R.id.editButton);
        Button reviewButton = (Button)view.findViewById(R.id.reviewButton);
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
