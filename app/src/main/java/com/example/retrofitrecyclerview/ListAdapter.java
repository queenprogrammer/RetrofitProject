package com.example.retrofitrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    List<Posts> postsArrayList = new ArrayList<>();



    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Posts posts = postsArrayList.get(position);
        holder.tvUserId.setText(String.valueOf(posts.getUserId()));
        holder.tvId.setText(String.valueOf(posts.getId()));
        holder.tvTitle.setText(posts.getTitle());
        holder.tvBody.setText(posts.getBody());

    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }

    public void setList(List<Posts> list) {
        this.postsArrayList = list;
        notifyDataSetChanged();

    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId, tvId, tvTitle, tvBody;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.userIdTv);
            tvId = itemView.findViewById(R.id.idTv);
            tvTitle = itemView.findViewById(R.id.titleTv);
            tvBody = itemView.findViewById(R.id.bodyTv);
        }
    }
}
