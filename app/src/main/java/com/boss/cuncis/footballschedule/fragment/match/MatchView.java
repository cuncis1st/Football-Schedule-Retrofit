package com.boss.cuncis.footballschedule.fragment.match;

import com.boss.cuncis.footballschedule.model.Match;
import com.boss.cuncis.footballschedule.model.MatchResponse;

import java.util.List;

public interface MatchView {
    void showLoading();
    void hideLoading();
    void showSuccess(MatchResponse result);
    void showError(String message);
}
