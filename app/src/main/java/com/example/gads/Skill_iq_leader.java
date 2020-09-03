package com.example.gads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Skill_iq_leader extends Fragment {
    private RecyclerView recyclerView;
    public List<SkillIQ> skillIQList;
    ReturnedData returnedData;
    // Constructor with no argument
    public Skill_iq_leader(){}
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View skillView = inflater.inflate (R.layout.skill_iq_leader_layout,container,false);
        recyclerView = skillView.findViewById (R.id.skill_score_recycler);

        // Setting layout for the recyclerView
        recyclerView.setLayoutManager (new LinearLayoutManager (getContext ()));

        // Data for the recyclerView
        returnedData = new ReturnedData ();
        skillIQList = returnedData.returnedSkill ();

        // Creating an adapter
        AdapterSkill adapterSkill = new AdapterSkill (skillIQList);
        recyclerView.setAdapter (adapterSkill);
        recyclerView.setItemAnimator (new DefaultItemAnimator ());

        return skillView;
    }
}
