package com.boss.cuncis.footballschedule.api;

import com.boss.cuncis.footballschedule.model.MatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheSportDbApi {

    @GET("api/v1/json/1/eventspastleague.php?id=4328")
    Call<MatchResponse> getLastMatch();

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<MatchResponse> getNextMatch();
}
