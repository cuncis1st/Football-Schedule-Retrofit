package com.boss.cuncis.footballschedule.fragment.team;

import com.boss.cuncis.footballschedule.model.LeagueResponse;
import com.boss.cuncis.footballschedule.model.MatchResponse;
import com.boss.cuncis.footballschedule.model.TeamResponse;

public interface TeamView {
    void showLoading();
    void hideLoading();
    void showSuccess(TeamResponse result);
    void showSuccess(LeagueResponse result);
    void showError(String message);
}
