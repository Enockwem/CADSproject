package com.example.gads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button submit;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Initializing the toolbar
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById (R.id.tablayout_for_gads_project);
        tabLayout.addTab (tabLayout.newTab ().setText (R.string.leader_text));
        tabLayout.addTab (tabLayout.newTab ().setText (R.string.skill_iq));

        final ViewPager viewPager = (ViewPager) findViewById (R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter (getSupportFragmentManager (),tabLayout.getTabCount ());

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

        submit = (Button) findViewById (R.id.submit_button);
        submit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (MainActivity.this,ProjectSubmission.class);
                startActivity (intent);
            }
        });
    }

}