package com.example.gads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Initializing the toolbar
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setting the tablayout in the main activity
        TabLayout tabLayout = (TabLayout) findViewById (R.id.tablayout);
        tabLayout.addTab (tabLayout.newTab ().setText (R.string.leader_text));
        tabLayout.addTab (tabLayout.newTab ().setText (R.string.skill_iq));
        // Setting the color of the texts in the toolbar
        tabLayout.setTabTextColors (Color.parseColor ("#FFF"),Color.parseColor ("#FFFF"));
        tabLayout.setTabGravity (TabLayout.GRAVITY_FILL);

        // Setting the ViewPager
        final ViewPager viewPager = (ViewPager) findViewById (R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter (
                getSupportFragmentManager (),tabLayout.getTabCount ()
        );
        viewPager.setAdapter (adapter);
        viewPager.addOnPageChangeListener (new TabLayout.TabLayoutOnPageChangeListener (tabLayout));

        tabLayout.setOnTabSelectedListener (new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected (TabLayout.Tab tab) {
                viewPager.setCurrentItem (tab.getPosition ());
            }

            @Override
            public void onTabUnselected (TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected (TabLayout.Tab tab) {
            }
        });
    }
}