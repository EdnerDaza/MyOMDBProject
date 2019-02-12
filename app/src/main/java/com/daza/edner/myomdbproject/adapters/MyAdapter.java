package com.daza.edner.myomdbproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daza.edner.myomdbproject.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private int layout;
    private ArrayList<String> movies;

    public MyAdapter(Context context, int layout, ArrayList<String> movies) {
        this.context = context;
        this.layout = layout;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyAdapter.MyViewHolder(LayoutInflater.from(this.context).inflate(this.layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder viewHolder, int position) {
        viewHolder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPoster;
        private TextView textViewMovie;
        //private ProgressBar progressBarMovie;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.imageViewPoster = view.findViewById(R.id.ivPosterMovie);
            this.textViewMovie = view.findViewById(R.id.tvTitleMovie);
            //this.progressBarMovie = view.findViewById(R.id.pbImageDetail);
        }

        private void bind(String movie){
            this.textViewMovie.setText(movie.trim().toString());
            //this.progressBarMovie.setVisibility(View.VISIBLE);
            Picasso.get().load("http://www.omdbapi.com/src/poster.jpg").into(this.imageViewPoster, new Callback() {
                @Override
                public void onSuccess() {
                    //progressBarMovie.setVisibility(View.INVISIBLE);
                    imageViewPoster.setVisibility(View.VISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    //progressBarMovie.setVisibility(View.VISIBLE);
                    imageViewPoster.setVisibility(View.INVISIBLE);
                }
            });
        }

    }
}
