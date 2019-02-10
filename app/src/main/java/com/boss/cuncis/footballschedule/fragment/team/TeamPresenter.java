package com.boss.cuncis.footballschedule.fragment.team;

import android.widget.Spinner;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.model.LeagueResponse;
import com.boss.cuncis.footballschedule.model.Team;
import com.boss.cuncis.footballschedule.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamPresenter {
    private TeamView view;
    private TheSportDbApi theSportDbApi;

    public TeamPresenter(TeamView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllTeams(String id) {
        view.showLoading();
        theSportDbApi.getTeam(id)
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }

    public void getAllLeague() {
        theSportDbApi.getLeague()
                .enqueue(new Callback<LeagueResponse>() {
                    @Override
                    public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<LeagueResponse> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }
}
