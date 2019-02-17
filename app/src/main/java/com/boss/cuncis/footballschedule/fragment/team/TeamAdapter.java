package com.boss.cuncis.footballschedule.fragment.team;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.fragment.team.team_details.TeamDetailActivity;
import com.boss.cuncis.footballschedule.model.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> implements Filterable {

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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
//                    teamListFiltered = teamList;
                } else {
                    List<Team> filteredList = new ArrayList<>();
                    for (Team row: teamList) {
                        if (row.getTeamName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    // still mistery
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = teamList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                teamList = (ArrayList<Team>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName;
        ImageView imgTeamLogo;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tv_team_name);
            imgTeamLogo = itemView.findViewById(R.id.img_team_logo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, TeamDetailActivity.class);
                    i.putExtra("KEY_TEAM_ID", teamList.get(getAdapterPosition()).getIdTeam());
                    context.startActivity(i);
                }
            });
        }
    }

}
