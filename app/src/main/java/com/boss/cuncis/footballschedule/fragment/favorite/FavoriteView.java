package com.boss.cuncis.footballschedule.fragment.favorite;

import com.boss.cuncis.footballschedule.model.MatchResponse;

public interface FavoriteView {
    void showLoading();
    void hideLoading();
    void showSuccess(MatchResponse result);
    void showError(String message);
}
