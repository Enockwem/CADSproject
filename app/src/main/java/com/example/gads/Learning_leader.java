package com.example.gads;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Learning_leader extends Fragment {

    private static final String TAG = LearningLeaders.class.getSimpleName();
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    AdapterLeader adapterLeader;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
       View leaderInflater =  inflater.inflate (R.layout.learning_leader_layout,container,false);
       recyclerView = leaderInflater.findViewById (R.id.learning_leader_recyler);

       progressDialog = new ProgressDialog (getActivity ());
       progressDialog.setMessage ("Loading...");
       progressDialog.show ();

       // Handle for Retrofit instance
       Getdata request_service = RetrofitClient.getRetrofitInstance ().create (Getdata.class);

        Call<List<LearningLeaders>> call = request_service.getAllLearningLeaders ();
        call.enqueue (new Callback<List<LearningLeaders>> () {
            @Override
            public void onResponse (Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                progressDialog.dismiss ();
                loadLeaderHours(response.body ());
            }

            @Override
            public void onFailure (Call<List<LearningLeaders>> call, Throwable t) {
                progressDialog.dismiss ();
                Toast.makeText (getContext (),"Sorry something went wrong!!!\n" +
                        "Try again later",Toast.LENGTH_SHORT).show ();
            }
        });
       return leaderInflater;
    }

    public void loadLeaderHours(List<LearningLeaders> learningLeaders){
        adapterLeader = new AdapterLeader (getContext (),learningLeaders);
        recyclerView.setLayoutManager (new LinearLayoutManager (getContext ()));
        recyclerView.setAdapter (adapterLeader);
    }
}