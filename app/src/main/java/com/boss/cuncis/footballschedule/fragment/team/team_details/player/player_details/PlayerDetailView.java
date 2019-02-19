package com.boss.cuncis.footballschedule.fragment.team.team_details.player.player_details;

import com.boss.cuncis.footballschedule.model.PlayerDetailResponse;

public interface PlayerDetailView {
    void showLoading();
    void hideLoading();
    void showSuccess(PlayerDetailResponse result);
    void showError(String message);
}
