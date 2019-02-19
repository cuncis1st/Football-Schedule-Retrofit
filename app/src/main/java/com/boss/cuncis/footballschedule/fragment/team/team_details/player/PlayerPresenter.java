package com.boss.cuncis.footballschedule.fragment.team.team_details.player;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.model.PlayerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerPresenter {
    private PlayerView view;
    private TheSportDbApi theSportDbApi;

    public PlayerPresenter(PlayerView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllPlayer(String teamId) {
        view.showLoading();
        theSportDbApi.getPlayer(teamId)
                .enqueue(new Callback<PlayerResponse>() {
                    @Override
                    public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }

                    }

                    @Override
                    public void onFailure(Call<PlayerResponse> call, Throwable t) {
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }
}
