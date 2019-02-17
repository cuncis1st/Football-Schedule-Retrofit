package com.boss.cuncis.footballschedule.fragment.team.team_details.overview;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewPresenter {
    private OverviewView view;
    private TheSportDbApi theSportDbApi;

    public OverviewPresenter(OverviewView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getDetails(String teamId) {
        view.showLoading();
        theSportDbApi.getTeamDetail(teamId)
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
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }
}
