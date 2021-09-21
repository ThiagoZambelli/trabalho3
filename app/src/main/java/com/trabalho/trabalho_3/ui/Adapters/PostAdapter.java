package com.trabalho.trabalho_3.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trabalho.trabalho_3.R;
import com.trabalho.trabalho_3.ui.Models.Post;
import com.trabalho.trabalho_3.ui.Models.Todo;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private List<Post> dadospost;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    public PostAdapter(List<Post> posts) {
        this.dadospost = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = dadospost.get(position);
        TextView tvp = holder.view.findViewById(R.id.tvPostTitulo);
        tvp.setText(post.getTitle());
        TextView tvp1 = holder.view.findViewById(R.id.tvPostIdUser);
        tvp1.setText(""+post.getUser_id());
        TextView tvp2 = holder.view.findViewById(R.id.tvPostBody);
        tvp2.setText(""+post.getBody());


    }

    @Override
    public int getItemCount() {
        return dadospost.size();
    }
}
