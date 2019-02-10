package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

public class League {

    @SerializedName("idLeague")
    private String id_league;

    @SerializedName("strLeague")
    private String leagueName;

    public League() {
    }

    public String getId_league() {
        return id_league;
    }

    public String getLeagueName() {
        return leagueName;
    }
}
