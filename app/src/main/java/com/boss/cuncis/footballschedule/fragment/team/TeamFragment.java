package com.boss.cuncis.footballschedule.fragment.team;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.model.League;
import com.boss.cuncis.footballschedule.model.LeagueResponse;
import com.boss.cuncis.footballschedule.model.Team;
import com.boss.cuncis.footballschedule.model.TeamResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment implements TeamView {
    private static final String TAG = "TeamFragment";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Spinner spinner;

    private TeamPresenter presenter;
    private TeamAdapter adapter;

    private List<Team> teams;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        spinner = view.findViewById(R.id.spinner);
        recyclerView = view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.progressbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        teams = new ArrayList<>();


        presenter = new TeamPresenter(this);

//        presenter.getAllTeams("4328");
        presenter.getAllLeague();


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
        Toast.makeText(getActivity(), "Success...", Toast.LENGTH_SHORT).show();
        teams.addAll(result.getTeams());

        adapter = new TeamAdapter(teams, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSuccess(LeagueResponse result) {
        final List<League> leagueList = new ArrayList<>();
        List<String> spinList = new ArrayList<>();

        leagueList.addAll(result.getLeagues());
        for (int i = 0; i < leagueList.size(); i++) {
            spinList.add(leagueList.get(i).getLeagueName());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                teams.clear();
                presenter.getAllTeams(leagueList.get(i).getId_league());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
    }
}
