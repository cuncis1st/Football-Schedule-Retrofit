package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strTeamBadge")
    private String teamLogo;

    public Team() {
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }
}
