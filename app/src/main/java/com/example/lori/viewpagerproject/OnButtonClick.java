package com.example.lori.viewpagerproject;

/**
 * Created by Hermes on 02/06/2017.
 *
 * We use the method of this interface as a callback to choose the next fragment in the viewpager
 * when the users clicks the next button.
 */

public interface OnButtonClick {

    void switchFragment(int target);
}
