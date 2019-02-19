package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

public class PlayerDetail {
    @SerializedName("strPlayer")
    private String playerName;

    @SerializedName("strWeight")
    private String playerWeight;

    @SerializedName("strHeight")
    private String playerHeight;

    @SerializedName("strPosition")
    private String playerPosition;

    @SerializedName("strFanart2")
    private String playerPoster;

    @SerializedName("strDescriptionEN")
    private String playerDescription;

    public PlayerDetail() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerWeight() {
        return playerWeight;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public String getPlayerPoster() {
        return playerPoster;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }
}
