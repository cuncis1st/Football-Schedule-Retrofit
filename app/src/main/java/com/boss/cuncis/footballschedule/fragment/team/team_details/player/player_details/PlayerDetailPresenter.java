package com.boss.cuncis.footballschedule.fragment.team.team_details.player.player_details;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.model.PlayerDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerDetailPresenter {
    private PlayerDetailView view;
    private TheSportDbApi theSportDbApi;

    public PlayerDetailPresenter(PlayerDetailView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllPlayerDetails(String playerId) {
        view.showLoading();
        theSportDbApi.getPlayerDetail(playerId)
                .enqueue(new Callback<PlayerDetailResponse>() {
                    @Override
                    public void onResponse(Call<PlayerDetailResponse> call, Response<PlayerDetailResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PlayerDetailResponse> call, Throwable t) {
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }
}



