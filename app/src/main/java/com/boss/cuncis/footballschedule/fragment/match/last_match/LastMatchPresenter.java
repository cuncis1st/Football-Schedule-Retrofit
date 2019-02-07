package com.boss.cuncis.footballschedule.fragment.match.last_match;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.fragment.match.MatchView;
import com.boss.cuncis.footballschedule.model.MatchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastMatchPresenter {
    private MatchView view;
    private TheSportDbApi theSportDbApi;

    public LastMatchPresenter(MatchView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllLastMatch() {
        theSportDbApi.getLastMatch()
                .enqueue(new Callback<MatchResponse>() {
                    @Override
                    public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<MatchResponse> call, Throwable t) {
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }
}
