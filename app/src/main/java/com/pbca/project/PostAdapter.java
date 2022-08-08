package com.pbca.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

   Context context;
   List<Item> postList;

    public PostAdapter(Context context, List<Item> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.menu, parent,false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Item item  = postList.get(position);
        holder.setImageView(item.getImageUrl());
        holder.setmName(item.getName());
        holder.setmServings(item.getServings());
        holder.setmBottomtext(item.getBottomtext());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mName, mServings, mBottomtext;
        View view;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
         public void setImageView(String url){
            imageView = view.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(imageView);
         }
         public void setmName(String name){
            mName = view.findViewById(R.id.name);
            mName.setText(name);
         }
         public void setmServings(int price){
            mServings = view.findViewById(R.id.price);
            mServings.setText("Price: " + price + " " + "$");
         }
         public void setmBottomtext(String bottomtext){
            mBottomtext = view.findViewById(R.id.bottomtext);
            mBottomtext.setText(bottomtext);
         }

    }
}
