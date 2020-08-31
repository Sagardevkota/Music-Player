package com.sagardev.musicplayer.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sagardev.musicplayer.R;
import com.sagardev.musicplayer.models.AudioModel;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private List<AudioModel> audioModelList;
    private Context context;
    public MusicAdapter(List<AudioModel> audioModelList, Context context)
    {
        this.audioModelList=audioModelList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_music_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AudioModel audioModel=audioModelList.get(position);
        holder.tvMusicName.setText(audioModel.getName());
    }

    @Override
    public int getItemCount() {
        return audioModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMusicName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMusicName=itemView.findViewById(R.id.rvMusicName);
        }
    }
}
