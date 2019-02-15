package com.boss.cuncis.footballschedule.fragment.match;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.fragment.match.detail.DetailMatchActivity;
import com.boss.cuncis.footballschedule.model.Match;
import com.boss.cuncis.footballschedule.utils.Utils;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;
    private Context context;

    public MatchAdapter(List<Match> matchList, Context context) {
        this.matchList = matchList;
        this.context = context;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int i) {
        holder.tvDate.setText(Utils.getDate(matchList.get(i).getDateEvent()));
        holder.tvHomeTeam.setText(matchList.get(i).getStrHomeTeam());
        holder.tvHomeScore.setText(matchList.get(i).getIntHomeScore());
        holder.tvAwayTeam.setText(matchList.get(i).getStrAwayTeam());
        holder.tvAwayScore.setText(matchList.get(i).getIntAwayScore());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvHomeTeam, tvHomeScore, tvAwayTeam, tvAwayScore;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.date);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team);
            tvHomeScore = itemView.findViewById(R.id.tv_home_score);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team);
            tvAwayScore = itemView.findViewById(R.id.tv_away_score);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, DetailMatchActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }
}
