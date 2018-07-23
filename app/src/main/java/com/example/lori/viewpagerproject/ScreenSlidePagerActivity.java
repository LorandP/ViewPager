package com.example.lori.viewpagerproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Hermes on 30/05/2017.
 *
 * This class initialises a view pager and an adapter.
 * It will set a fragment instance to every page in the view pager and it will also specify
 * the number of instances that will be created.
 */

public class ScreenSlidePagerActivity extends FragmentActivity
        implements OnButtonClick{
    //The number of pages to show
    private static final int NUM_PAGES = 3;

    /*
    * The pager widget, which hadnles animation and allows swiping horizonally to access previus and
    * next wizard spes.
    * */
    private ViewPager mPager;

    /*
    * The pager adapter, which provides the pages to the view pager widget.
    * */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter and set the ScreenSlidePagerAdapter as
        // the adapter of the ViewPager which contains the representation of
        // 3 ScreenSlidePageFrament objects which will be displayed on a screen when swiping
        // in the ViewPager
        // We give it a fragment manager to interact with the other fragments associated with this activity
        mPager = (ViewPager)findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.dots);
        tabLayout.setupWithViewPager(mPager, true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // We are setting margins between the buttons in the tablayout
        for (int index = 0; index < tabLayout.getTabCount();index++){
            View tab = ((ViewGroup)tabLayout.getChildAt(0)).getChildAt(index);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams)tab.getLayoutParams();
            params.setMargins(0,0,30,0);
            tabLayout.requestLayout();
        }
    }

    // I use this method to set the current page in the viewpager
    // I then use this method in the onClickListener of the Next button on the first and second
    // page of the viewpager to go to the next page in the viewpager
    /*public void switchFragment(int target){
        mPager.setCurrentItem(target);
    }*/

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0){
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button.
            // This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        }else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem()-1);
        }

        super.onBackPressed();
    }

    /*
    * Implementam functia din interfata si asta va functina pe post de callback atunci cand
     * vom dori sa apelam functia din fiecare fragment separat.
    */
    @Override
    public void switchFragment(int target) {
        mPager.setCurrentItem(target);
    }


    /**
     * A simnple class that represents 3 ScreenSlidePageFragment objects in sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        public ScreenSlidePagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            // We are setting different fragments containing different layouts for every page
            // selected in the viewpager
            switch (position){
                case 0: return new ScreenSlidePageFragment();
                case 1: return new SecondFragment();
                case 2: return new ThirdFragment();
                default: return new SecondFragment();
            }
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}

