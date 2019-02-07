package com.boss.cuncis.footballschedule.fragment.match.next_match;


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
import com.boss.cuncis.footballschedule.fragment.match.MatchAdapter;
import com.boss.cuncis.footballschedule.fragment.match.MatchView;
import com.boss.cuncis.footballschedule.model.Match;
import com.boss.cuncis.footballschedule.model.MatchResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextMatch extends Fragment implements MatchView {

    private RecyclerView recyclerView;

    private List<Match> matches;
    private MatchAdapter adapter;
    private NextMatchPresenter presenter;
    private ProgressBar progressBar;

    public NextMatch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_match, container, false);

        matches = new ArrayList<>();
        presenter = new NextMatchPresenter(this);

        progressBar = view.findViewById(R.id.progressbar);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MatchAdapter(matches, getActivity());

        presenter.getAllNextMatch();

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
    public void showSuccess(MatchResponse result) {
        Toast.makeText(getActivity(), "Success...", Toast.LENGTH_SHORT).show();
        matches.addAll(result.getEvents());
        adapter = new MatchAdapter(matches, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
    }
}
