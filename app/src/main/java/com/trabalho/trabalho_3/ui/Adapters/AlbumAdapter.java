package com.trabalho.trabalho_3.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trabalho.trabalho_3.R;
import com.trabalho.trabalho_3.ui.Models.Album;
import com.trabalho.trabalho_3.ui.Models.Post;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    private List<Album> dadosalbum;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    public AlbumAdapter(List<Album> album) {
        this.dadosalbum = album;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);
        return new AlbumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        Album album = dadosalbum.get(position);
        TextView tva = holder.view.findViewById(R.id.tvAlbumTitle);
        tva.setText(album.getTitle());
        TextView tva1 = holder.view.findViewById(R.id.tvAlbumIdUser);
        tva1.setText(""+album.getUser_id());

    }

    @Override
    public int getItemCount() {
        return dadosalbum.size();
    }
}
