package com.boss.cuncis.footballschedule.fragment.match.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.fragment.match.MatchView;
import com.boss.cuncis.footballschedule.fragment.team.TeamPresenter;
import com.boss.cuncis.footballschedule.model.Detail;
import com.boss.cuncis.footballschedule.model.DetailResponse;
import com.boss.cuncis.footballschedule.model.Team;
import com.boss.cuncis.footballschedule.model.TeamResponse;
import com.boss.cuncis.footballschedule.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailMatchActivity extends AppCompatActivity implements DetailView {
    private static final String TAG = "DetailMatchActivity";

    private TextView tvDate, tvHomeTeam, tvAwayTeam, tvHomeScore, tvAwayScore;
    private TextView tvHomeGoalDetail, tvAwayGoalDetail, tvHomeShot, tvAwayShot;
    private TextView tvHomeKeeper, tvAwayKeeper, tvHomeDefense, tvAwayDefense, tvHomeMidfield, tvAwayMidfield;
    private TextView tvHomeForward, tvAwayForward, tvHomeSubtitutes, tvAwaySubtitutes;
    private ImageView imgHomeTeam, imgAwayTeam;
    private ProgressBar progressBar;

    private DetailPresenter presenter;
    private List<Detail> details;

    String homeId;
    String awayId;

    private boolean isAdded = false;
    private MenuItem addToFavorite;
    private MenuItem removeFavorite;
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_match);
        initView();

        details = new ArrayList<>();

        presenter = new DetailPresenter(this);

        String idEvent = getIntent().getStringExtra("KEY_EVENT_ID");
        presenter.getAllDetail(idEvent);

        homeId = getIntent().getStringExtra("KEY_HOME_TEAM_ID");
        presenter.getHomeLogo(homeId);
        awayId = getIntent().getStringExtra("KEY_AWAY_TEAM_ID");
        presenter.getAwayLogo(awayId);


    }

    private void initListener() {
        tvDate.setText(Utils.getDate(details.get(0).getDateEvent()));
        tvHomeTeam.setText(details.get(0).getStrHomeTeam());
        tvAwayTeam.setText(details.get(0).getStrAwayTeam());
        tvHomeScore.setText(details.get(0).getIntHomeScore());
        tvAwayScore.setText(details.get(0).getIntAwayScore());
        tvHomeGoalDetail.setText(details.get(0).getStrHomeGoalDetails());
        tvAwayGoalDetail.setText(details.get(0).getStrAwayGoalDetails());
        tvHomeShot.setText(details.get(0).getIntHomeShots());
        tvAwayShot.setText(details.get(0).getIntAwayScore());
        tvHomeKeeper.setText(details.get(0).getStrHomeLineupGoalkeeper());
        tvAwayKeeper.setText(details.get(0).getStrAwayLineupGoalkeeper());
        tvHomeDefense.setText(details.get(0).getStrHomeLineupDefense());
        tvAwayDefense.setText(details.get(0).getStrAwayLineupDefense());
        tvHomeMidfield.setText(details.get(0).getStrHomeLineupMidfield());
        tvAwayMidfield.setText(details.get(0).getStrAwayLineupMidfield());
        tvHomeForward.setText(details.get(0).getStrHomeLineupForward());
        tvAwayForward.setText(details.get(0).getStrAwayLineupForward());
        tvHomeSubtitutes.setText(details.get(0).getStrHomeLineupSubstitutes());
        tvAwaySubtitutes.setText(details.get(0).getStrAwayLineupSubstitutes());
    }

    private void initView() {
        imgHomeTeam = findViewById(R.id.img_homeTeam);
        imgAwayTeam = findViewById(R.id.img_awayTeam);
        progressBar = findViewById(R.id.progressbar);
        tvDate = findViewById(R.id.tv_date);
        tvHomeTeam = findViewById(R.id.tv_homeTeam);
        tvAwayTeam = findViewById(R.id.tv_awayTeam);
        tvHomeScore = findViewById(R.id.tv_homeScore);
        tvAwayScore = findViewById(R.id.tv_awayScore);
        tvHomeGoalDetail = findViewById(R.id.tv_homeGoalDetail);
        tvAwayGoalDetail = findViewById(R.id.tv_awayGoalDetail);
        tvHomeShot = findViewById(R.id.tv_homeShots);
        tvAwayShot = findViewById(R.id.tv_awayShots);
        tvHomeKeeper = findViewById(R.id.tv_homeLineupKeeper);
        tvAwayKeeper = findViewById(R.id.tv_awayLineupKeeper);
        tvHomeDefense = findViewById(R.id.tv_homeLineupDefense);
        tvAwayDefense = findViewById(R.id.tv_awayLineupDefense);
        tvHomeMidfield = findViewById(R.id.tv_homeLineupMidfield);
        tvAwayMidfield = findViewById(R.id.tv_awayLineupMidfield);
        tvHomeForward = findViewById(R.id.tv_homeLineupForward);
        tvAwayForward = findViewById(R.id.tv_awayLineupForward);
        tvHomeSubtitutes = findViewById(R.id.tv_homeLineupSubstitutes);
        tvAwaySubtitutes = findViewById(R.id.tv_awayLineupSubstitutes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isAdded) {
            item.setIcon(R.drawable.ic_favorite_border);
            isAdded = false;
            Toast.makeText(this, "Remove from Favorite", Toast.LENGTH_SHORT).show();
        } else {
            item.setIcon(R.drawable.ic_favorite);
            isAdded = true;
            Toast.makeText(this, "Added to Favorite", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
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
    public void showSuccess(DetailResponse result) {
        details.addAll(result.getEvents());
        initListener();
    }

    @Override
    public void showHomeLogo(TeamResponse logoResult) {
        List<Team> teams = new ArrayList<>();
        teams.addAll(logoResult.getTeams());
        Picasso.get().load(teams.get(0).getTeamLogo()).into(imgHomeTeam);
    }

    @Override
    public void showAwayLogo(TeamResponse logoResult) {
        List<Team> teams = new ArrayList<>();
        teams.addAll(logoResult.getTeams());
        Picasso.get().load(teams.get(0).getTeamLogo()).into(imgAwayTeam);
    }


    @Override
    public void showError(String message) {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }
}















