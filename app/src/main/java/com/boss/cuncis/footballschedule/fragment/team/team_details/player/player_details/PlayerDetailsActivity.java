package com.boss.cuncis.footballschedule.fragment.team.team_details.player.player_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.model.PlayerDetailResponse;
import com.squareup.picasso.Picasso;

public class PlayerDetailsActivity extends AppCompatActivity implements PlayerDetailView{

    TextView tvWeight, tvHeight, tvPosition, tvDesc;
    ImageView imgPoster;
    ProgressBar progressBar;

    PlayerDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        initView();

        String playerId = getIntent().getStringExtra("KEY_PLAYER_ID");

        presenter = new PlayerDetailPresenter(this);
        presenter.getAllPlayerDetails(playerId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        tvWeight = findViewById(R.id.tv_player_detail_weight);
        tvHeight = findViewById(R.id.tv_player_detail_height);
        tvPosition = findViewById(R.id.tv_player_detail_position);
        tvDesc = findViewById(R.id.tv_player_detail_description);
        imgPoster = findViewById(R.id.poster_player_detail);
        progressBar = findViewById(R.id.progressbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
    public void showSuccess(PlayerDetailResponse result) {
        getSupportActionBar().setTitle(result.getPlayerDetails().get(0).getPlayerName());

        String weight = result.getPlayerDetails().get(0).getPlayerWeight();
        String height = result.getPlayerDetails().get(0).getPlayerHeight();
        String position = result.getPlayerDetails().get(0).getPlayerPosition();
        String description = result.getPlayerDetails().get(0).getPlayerDescription();
        String poster = result.getPlayerDetails().get(0).getPlayerPoster();

        if (height.length() < 4) {
            String fixWeight = weight.substring(0, 4);
            tvHeight.setText(height);
            tvWeight.setText(fixWeight);

        } else if (weight.length() < 4) {
            String fixHeight = height.substring(0, 4);
            tvWeight.setText(weight);
            tvHeight.setText(fixHeight);

        } else {
            String fixWeight = weight.substring(0, 4);
            String fixHeight = height.substring(0, 4);

            tvWeight.setText(fixWeight);
            tvHeight.setText(fixHeight);
        }

        tvPosition.setText(position);
        tvDesc.setText(description);
        Picasso.get().load(poster).placeholder(R.drawable.img_placeholder).into(imgPoster);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
