package com.boss.cuncis.footballschedule.fragment.team.team_details.player;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.model.Player;
import com.boss.cuncis.footballschedule.model.PlayerResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment implements PlayerView{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private PlayerPresenter presenter;
    private PlayerAdapter adapter;

    private List<Player> players;

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        progressBar = view.findViewById(R.id.progressbar);
        recyclerView = view.findViewById(R.id.rv_player);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        players = new ArrayList<>();


        presenter = new PlayerPresenter(this);

        String teamId = getActivity().getIntent().getStringExtra("KEY_TEAM_ID");

        presenter.getAllPlayer(teamId);

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
    public void showSuccess(PlayerResponse result) {
        Toast.makeText(getActivity(), "Success...", Toast.LENGTH_SHORT).show();
        players.addAll(result.getPlayers());
        adapter = new PlayerAdapter(players, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
    }
}


















