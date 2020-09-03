package com.example.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Getdata {
    // This is the request type and  my relative URL /api/hours
    // Wrapping the response in a call object with the type of the expected result
    @GET("/api/hours")
    Call<List<LearningLeaders>> getAllLearningLeaders();

    // This is the request type and my relative URL /api/skilliq
    // Then wrapping the response in a call object with the type of the expected result
    @GET("/api/skilliq")
    Call<List<SkillIQ>> getSkillIQ();
}
