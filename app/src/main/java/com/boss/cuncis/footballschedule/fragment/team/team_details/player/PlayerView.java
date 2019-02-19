package com.boss.cuncis.footballschedule.fragment.team.team_details.player;

import com.boss.cuncis.footballschedule.model.PlayerResponse;

public interface PlayerView {
    void showLoading();
    void hideLoading();
    void showSuccess(PlayerResponse result);
    void showError(String message);
}
