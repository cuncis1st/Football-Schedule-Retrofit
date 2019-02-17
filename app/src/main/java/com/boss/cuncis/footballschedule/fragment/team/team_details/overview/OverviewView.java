package com.boss.cuncis.footballschedule.fragment.team.team_details.overview;

import com.boss.cuncis.footballschedule.model.LeagueResponse;
import com.boss.cuncis.footballschedule.model.TeamResponse;

public interface OverviewView {
    void showLoading();
    void hideLoading();
    void showSuccess(TeamResponse result);
    void showError(String message);
}
