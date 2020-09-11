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
public class Skill_iq_leader extends Fragment {
    private List<SkillIQ> skillIQS;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    AdapterSkill adapterSkill;
    private static final String TAG = Skill_iq_leader.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View skillView =(ViewGroup) inflater.inflate (R.layout.skill_iq_leader_layout,container,false);
         recyclerView = skillView.findViewById (R.id.skill_score_recycler);
        progressDialog = new ProgressDialog (getActivity ());
        progressDialog.setMessage ("Loading...");
        progressDialog.show ();

        // Handle for the RetrofitInstance interface
        Getdata request = RetrofitClient.getRetrofitInstance ().create (Getdata.class);
        Call<List<SkillIQ>> call = request.getSkillIQ ();

        call.enqueue (new Callback<List<SkillIQ>> () {
            @Override
            public void onResponse (Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                progressDialog.dismiss ();
                loadSkillScoreData(response.body ());
            }

            @Override
            public void onFailure (Call<List<SkillIQ>> call, Throwable t) {
                progressDialog.dismiss ();
                Toast.makeText (getActivity (),"Something went wrong... Please try later", Toast.LENGTH_SHORT).show ();
            }
        });
        return skillView;
    }

    public void loadSkillScoreData(List<SkillIQ> skillIQS){
        adapterSkill = new AdapterSkill (getActivity (),skillIQS);
        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));
        recyclerView.setAdapter (adapterSkill);
    }
}
