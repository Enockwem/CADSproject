package com.example.gads;

import com.google.gson.annotations.SerializedName;

public class SkillIQ {
    @SerializedName ("rank")
    private int rank;
    @SerializedName ("name")
    private String name;
    @SerializedName ("country")
    private String country;
    @SerializedName ("skilliqscore")
    private String skilliqscore;

    public SkillIQ(int rank,String name,String country,String skilliqscore){
        this.rank = rank;
        this.name = name;
        this.country = country;
        this.skilliqscore = skilliqscore;
    }

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

    public String getSkilliqscore () {
        return skilliqscore;
    }

    public void setSkilliqscore (String skilliqscore) {
        this.skilliqscore = skilliqscore;
    }
}
