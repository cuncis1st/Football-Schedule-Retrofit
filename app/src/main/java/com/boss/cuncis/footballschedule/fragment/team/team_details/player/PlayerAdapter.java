package com.boss.cuncis.footballschedule.fragment.team.team_details.player;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.footballschedule.R;
import com.boss.cuncis.footballschedule.fragment.team.team_details.player.player_details.PlayerDetailsActivity;
import com.boss.cuncis.footballschedule.model.Player;
import com.boss.cuncis.footballschedule.model.PlayerDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> playerList;
    private Context context;

    public PlayerAdapter(List<Player> playerList, Context context) {
        this.playerList = playerList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_player, parent, false);

        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int i) {
        Picasso.get().load(playerList.get(i).getPlayerPoster()).placeholder(R.drawable.img_placeholder).into(holder.imgPoster);
        holder.tvPlayerName.setText(playerList.get(i).getPlayerName());
        holder.tvPlayerPosition.setText(playerList.get(i).getPlayerPosition());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvPlayerName, tvPlayerPosition;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_player);
            tvPlayerName = itemView.findViewById(R.id.tv_player_name);
            tvPlayerPosition = itemView.findViewById(R.id.tv_player_position);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PlayerDetailsActivity.class);
                    i.putExtra("KEY_PLAYER_ID", playerList.get(getAdapterPosition()).getPlayerId());
                    context.startActivity(i);
                }
            });
        }
    }

}
