package com.boss.cuncis.footballschedule.fragment.team.team_details;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.api.ApiClient;
import com.boss.cuncis.footballschedule.api.TheSportDbApi;
import com.boss.cuncis.footballschedule.fragment.team.team_details.overview.OverviewFragment;
import com.boss.cuncis.footballschedule.fragment.team.team_details.player.PlayerFragment;
import com.boss.cuncis.footballschedule.model.TeamResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        String teamId = getIntent().getStringExtra("KEY_TEAM_ID");
        Toast.makeText(this, "" + teamId, Toast.LENGTH_SHORT).show();

        getDetailToolbar(teamId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getDetailToolbar(String id) {
        final ImageView imgLogoToobar = findViewById(R.id.img_logo_toolbar);
        final TextView tvTeamName = findViewById(R.id.tv_team_name_toolbar);
        final TextView tvTeamYear = findViewById(R.id.tv_team_year_toolbar);
        final TextView tvTeamStadium = findViewById(R.id.tv_team_stadium_toolbar);

        TheSportDbApi theSportDbApi = new ApiClient().getClient();
        theSportDbApi.getTeamDetail(id)
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        String name = response.body().getTeams().get(0).getTeamName();
                        String year = response.body().getTeams().get(0).getTeamYear();
                        String stadium = response.body().getTeams().get(0).getTeamStadium();
                        String logo = response.body().getTeams().get(0).getTeamLogo();
                        tvTeamName.setText(name);
                        tvTeamYear.setText(year);
                        tvTeamStadium.setText(stadium);
                        Picasso.get().load(logo).placeholder(R.drawable.img_placeholder).into(imgLogoToobar);
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {

                    }
                });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_team_detail, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new OverviewFragment();
                case 1:
                    return new PlayerFragment();
                default:
                    return new OverviewFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
