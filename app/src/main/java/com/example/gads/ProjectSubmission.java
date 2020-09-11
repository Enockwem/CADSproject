package com.example.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

public class ProjectSubmission extends AppCompatActivity {

    ImageButton submit_project;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_project_submission);

        // Setting a Tablayout
        TabLayout tabLayout = (TabLayout) findViewById (R.id.tablayout_for_project);
        tabLayout.addTab (tabLayout.newTab ().setText (R.string.submit_project));
        // Adding a listener to the submit button
        submit_project = (ImageButton) findViewById (R.id.return_to_main);

        submit_project.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (ProjectSubmission.this, MainActivity.class);
                startActivity (intent);
            }
        });
    }
}