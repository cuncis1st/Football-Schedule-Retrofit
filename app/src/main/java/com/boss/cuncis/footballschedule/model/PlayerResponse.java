package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerResponse {

    @SerializedName("player")
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }
}
