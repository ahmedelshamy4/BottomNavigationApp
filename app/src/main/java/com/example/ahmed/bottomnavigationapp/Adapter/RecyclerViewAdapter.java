package com.example.ahmed.bottomnavigationapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ahmed.bottomnavigationapp.Data.Movie;
import com.example.ahmed.bottomnavigationapp.R;

import java.util.List;

/**
 * Created by Ahmed on 2/21/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {
    List<Movie> movieList;
    Context context;

    public RecyclerViewAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.name.setText(movie.getTitle());
        holder.price.setText(movie.getPrice());
        Glide.with(context).load(movie.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView imageView;

        public myViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.title_tv);
            price = itemView.findViewById(R.id.price_tv);

        }
    }
}
