package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerDetailResponse {
    @SerializedName("players")
    private List<PlayerDetail> playerDetails;

    public List<PlayerDetail> getPlayerDetails() {
        return playerDetails;
    }
}
