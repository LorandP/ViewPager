package com.example.lori.viewpagerproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Hermes on 31/05/2017.
 *
 * This class extends a fragment and returns a view group inflate with third_layout which will be
 * the third page in the viewpager
 */

public class ThirdFragment extends Fragment {

    OnButtonClick onButtonClick;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onButtonClick = (OnButtonClick)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" must implement OnButtonClick");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.third_layout,container, false);

        Button button_page3 = (Button)viewGroup.findViewById(R.id.button_page3);
        button_page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick.switchFragment(0);
            }
        });

        return viewGroup;
    }
}
