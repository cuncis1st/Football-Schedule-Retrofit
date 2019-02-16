package com.boss.cuncis.footballschedule.api;

import com.boss.cuncis.footballschedule.model.DetailResponse;
import com.boss.cuncis.footballschedule.model.LeagueResponse;
import com.boss.cuncis.footballschedule.model.MatchResponse;
import com.boss.cuncis.footballschedule.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheSportDbApi {

    @GET("api/v1/json/1/eventspastleague.php?id=4328")
    Call<MatchResponse> getLastMatch();

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<MatchResponse> getNextMatch();

    @GET("api/v1/json/1/lookup_all_teams.php")
    Call<TeamResponse> getTeam(@Query("id") String id);

    @GET("api/v1/json/1/all_leagues.php")
    Call<LeagueResponse> getLeague();

    @GET("api/v1/json/1/lookupevent.php")
    Call<DetailResponse> getDetail(@Query("id") String idEvent);

    @GET("api/v1/json/1/lookupteam.php")
    Call<TeamResponse> getTeamLogo(@Query("id") String id);
}
