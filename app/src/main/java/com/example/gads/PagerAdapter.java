package com.example.gads;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int n; // Number of tabs on the tab layout
    // Constructor for the PageAdapter
    public PagerAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.n = numberOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem (int position) {
        switch (position){
            case 0:
                Learning_leader learning_leader = new Learning_leader ();
                return learning_leader;
            case 1:
                Skill_iq_leader skill_iq_leader = new Skill_iq_leader ();
                return skill_iq_leader;
            default:
                return null;
        }
    }
    @Override
    public int getCount () {
        return n;
    }
}
