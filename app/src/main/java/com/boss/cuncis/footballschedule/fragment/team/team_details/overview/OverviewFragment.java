package com.boss.cuncis.footballschedule.fragment.team.team_details.overview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.model.Team;
import com.boss.cuncis.footballschedule.model.TeamResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment implements OverviewView{

    private ProgressBar progressBar;
    private OverviewPresenter presenter;
    private TextView tvTeamDesciption;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        tvTeamDesciption = view.findViewById(R.id.tv_team_descriptions);
        progressBar = view.findViewById(R.id.progressbar);

        presenter = new OverviewPresenter(this);

        String teamId = getActivity().getIntent().getStringExtra("KEY_TEAM_ID");
        Toast.makeText(getActivity(), "" + teamId, Toast.LENGTH_SHORT).show();

        presenter.getDetails(teamId);

        return view;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(TeamResponse result) {
        String team = result.getTeams().get(0).getTeamDescription();
        tvTeamDesciption.setText(team);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_SHORT).show();
    }
}
