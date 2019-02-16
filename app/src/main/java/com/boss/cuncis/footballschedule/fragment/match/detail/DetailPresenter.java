package com.boss.cuncis.footballschedule.fragment.match.detail;

import android.widget.Toast;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.fragment.match.MatchView;
import com.boss.cuncis.footballschedule.model.DetailResponse;
import com.boss.cuncis.footballschedule.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;
    private TheSportDbApi theSportDbApi;

    public DetailPresenter(DetailView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllDetail(String idEvent) {
        view.showLoading();
        theSportDbApi.getDetail(idEvent)
                .enqueue(new Callback<DetailResponse>() {
                    @Override
                    public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailResponse> call, Throwable t) {
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }

    public void getHomeLogo(String id) {
        theSportDbApi.getTeamLogo(id)
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        view.showHomeLogo(response.body());
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }

    public void getAwayLogo(String id) {
        theSportDbApi.getTeamLogo(id)
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        view.showAwayLogo(response.body());
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }
}
