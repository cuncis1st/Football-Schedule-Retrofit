package com.boss.cuncis.footballschedule.model;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("idPlayer")
    private String playerId;

    @SerializedName("strCutout")
    private String playerPoster;

    @SerializedName("strPlayer")
    private String playerName;

    @SerializedName("strPosition")
    private String playerPosition;

    public Player() {
    }

    public String getPlayerPoster() {
        return playerPoster;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public String getPlayerId() {
        return playerId;
    }
}
