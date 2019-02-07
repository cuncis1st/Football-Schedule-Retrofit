package com.boss.cuncis.footballschedule.fragment.match.next_match;

import android.widget.Toast;

import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.fragment.match.MatchView;
import com.boss.cuncis.footballschedule.model.MatchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NextMatchPresenter {
    private MatchView view;
    private TheSportDbApi theSportDbApi;

    public NextMatchPresenter(MatchView view) {
        this.view = view;
        theSportDbApi = new ApiClient().getClient();
    }

    public void getAllNextMatch() {
        theSportDbApi.getNextMatch()
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
