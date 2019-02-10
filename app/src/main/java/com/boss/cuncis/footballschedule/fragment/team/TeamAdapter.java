package com.boss.cuncis.footballschedule.fragment.team;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.model.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    List<Team> teamList;
    Context context;

    public TeamAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);

        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int i) {
        holder.tvTeamName.setText(teamList.get(i).getTeamName());
        Picasso.get().load(teamList.get(i).getTeamLogo()).into(holder.imgTeamLogo);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName;
        ImageView imgTeamLogo;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tv_team_name);
            imgTeamLogo = itemView.findViewById(R.id.img_team_logo);
        }
    }
}
