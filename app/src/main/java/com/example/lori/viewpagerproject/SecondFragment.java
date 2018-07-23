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
 * Created by Hermes on 31/05/2017.
 *
 * This fragment is going to be inflated with the layout that is created for the second page of the
 * view pager.
 */

public class SecondFragment extends Fragment {
    OnButtonClick onButtonClick;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onButtonClick = (OnButtonClick)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implement OnButtonClick");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.second_page, container,false);

        Button button_page2 = (Button)viewGroup.findViewById(R.id.button_page2);
        button_page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick.switchFragment(2);
            }
        });

        return viewGroup;
    }
}
