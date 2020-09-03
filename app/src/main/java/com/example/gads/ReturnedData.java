package com.example.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnedData {
    public List<LearningLeaders> learningLeaders;
    public List<SkillIQ> skillIQS;

    // Initialize Leaders
    // Handler for the Retrofit Instance interface
    Getdata service = RetrofitClient.getRetrofitInstance ().create (Getdata.class);

    //Making an api call
    //Here we are using the api method that we created inside the api interface
    Call<List<LearningLeaders>> call = service.getAllLearningLeaders ();
    Call<List<SkillIQ>> call1 = service.getSkillIQ ();

    // Method to return the list of leaders
    public List returnLeader(){
        // Execute the request asynchronously
        call.enqueue (new Callback<List<LearningLeaders>> () {
            // Handle a successful response
            @Override
            public void onResponse (Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                // In this point i get my list
                learningLeaders = response.body ();
                // loadDataListLearn(response.body ());
            }

            // Handle execution failures
            @Override
            public void onFailure (Call<List<LearningLeaders>> call, Throwable t) {
                // If the request fails, then display the following toast

            }
        });
        return learningLeaders;
    }

    public List returnedSkill(){

        call1.enqueue (new Callback<List<SkillIQ>> () {
            // Handle a successful response
            @Override
            public void onResponse (Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                skillIQS = response.body ();
            }

            // Handle execution failures
            @Override
            public void onFailure (Call<List<SkillIQ>> call, Throwable t) {
                // If the request fails, then display the following toast

            }
        });
        return skillIQS;
    }
}
