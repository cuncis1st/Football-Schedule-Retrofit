package com.boss.cuncis.footballschedule.fragment.match.detail;

import com.boss.cuncis.footballschedule.model.DetailResponse;
import com.boss.cuncis.footballschedule.model.TeamResponse;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void showSuccess(DetailResponse result);
    void showHomeLogo(TeamResponse logoResult);
    void showAwayLogo(TeamResponse logoResult);
    void showError(String message);
}
