package com.daza.edner.myomdbproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daza.edner.myomdbproject.R;
import com.daza.edner.myomdbproject.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private Context context;
    private int layout;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, int layout, ArrayList<Movie> movies) {
        this.context = context;
        this.layout = layout;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(this.layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPoster;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.imageViewPoster = view.findViewById(R.id.ivPosterMovie);
        }

        private void bind(Movie movie){
            if(!movie.getPoster().isEmpty())
                Picasso.get().load(movie.getPoster()).fit().into(this.imageViewPoster);
        }

    }

}
