package com.example.lori.viewpagerproject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Hermes on 30/05/2017.
 *
 * This class returns the layout that we created for whichj will be the content of this frament.
 * We then can create new instances of this fragment in the parent activity whenever we need
 * a new page to display to the user.
 */

public class ScreenSlidePageFragment extends Fragment {

    OnButtonClick onButtonClick;

    // Verificam in onAttach daca s-a facut implementarea in Activity-ul cu care acest fragment
    // va fi asociat. Daca nu s-a facut atuni aruncam o exceptie.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onButtonClick = (OnButtonClick)context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement OnButtonClick");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide, container, false);

        Button button_page1 = (Button)rootView.findViewById(R.id.button_page1);
        button_page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementand in acest fel, noi luam tot activity-ul in loc sa luam datele doar
                // pentru fragmentul nostru in plus, daca sistemul scapa de activity printr-un
                // anumit fel, noua aplicatia o sa ne crape fiind ca atunci cand dam getActivity
                // nu o sa aiba ce sa ne dea.
                //((ScreenSlidePagerActivity)getActivity()).switchFragment(1);
                onButtonClick.switchFragment(1);
            }
        });

        return rootView;
    }
}
