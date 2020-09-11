package com.example.gads;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Fragment[] childFragments;
    private int numberOfTabs;
    // Constructor for the PageAdapter
    public PagerAdapter (FragmentManager fm,int n) {
        super (fm);

        this.numberOfTabs = n;
    }

    @NonNull
    @Override
    public Fragment getItem (int position) {
        // return childFragments[position];
        switch (position) {
            case 0:
                return new Learning_leader ();
            case 1:
                return new Skill_iq_leader ();
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return numberOfTabs;
    }
}