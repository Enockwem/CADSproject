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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Learning_leader extends Fragment {
    RecyclerView recyclerViewLeader;
    List<LearningLeaders> learningLeaders;
    ReturnedData returnedData;
    public Learning_leader(){} // Public empty constructor
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
       View leaderInflater =  inflater.inflate (R.layout.learning_leader_layout,container,false);

       // This is the recyclerView in the layout
        //setting the layout
       recyclerViewLeader = leaderInflater.findViewById (R.id.learning_leader_recyler);
       recyclerViewLeader.setLayoutManager (new LinearLayoutManager (getActivity ()));

       // Data to be loaded in the recyclerViewLeader
        returnedData = new ReturnedData ();
       learningLeaders = returnedData.returnLeader ();

       // setting the adapter
        AdapterLeader adapterLeader = new AdapterLeader (learningLeaders);
        recyclerViewLeader.setAdapter (adapterLeader);
        // setting item animator to default
        recyclerViewLeader.setItemAnimator (new DefaultItemAnimator ());

       return leaderInflater;
    }

}
