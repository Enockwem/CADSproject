package com.example.gads;

import com.google.gson.annotations.SerializedName;

/*
 provides the getter and setter methods for each field I'm
 expecting in the response object.
 AM also going to use the @SerializedName annotation,
 which indicates that the field should be serialized with the provided name rather than the standard API field name.
 */
public class LearningLeaders {
    // Giving the fields
    @SerializedName ("rank")
    private int rank;
    @SerializedName ("name")
    private String name;
    @SerializedName ("country")
    private String country;
    @SerializedName ("learningHours")
    private String learningHours;
    @SerializedName ("TotalPoint")
    private int TotalPoint;
    @SerializedName ("collaboration_points")
    private int collaboration_points;
    @SerializedName ("skill_score")
    private int skill_score;

    public LearningLeaders(int rank,String name,String country, String learningHours){
        this.rank = rank;
        this.name = name;
        this.country = country;
        this.learningHours = learningHours;
    }

    // Retrieving the data using the setters/getters methods

    public int getRank () {
        return rank;
    }

    public void setRank (int rank) {
        this.rank = rank;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public String getLearningHours () {
        return learningHours;
    }

    public void setLearningHours (String learningHours) {
        this.learningHours = learningHours;
    }
}
