package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strTeamBadge")
    private String teamLogo;

    @SerializedName("strDescriptionEN")
    private String teamDescription;

    @SerializedName("intFormedYear")
    private String teamYear;

    @SerializedName("strStadium")
    private String teamStadium;

    public Team() {
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public String getTeamYear() {
        return teamYear;
    }

    public String getTeamStadium() {
        return teamStadium;
    }
}
