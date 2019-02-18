package com.daza.edner.myomdbproject.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daza.edner.myomdbproject.R;
import com.daza.edner.myomdbproject.data.models.SearchEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private int layout;
    private List<SearchEntity> movies;
    private MovieListListener movieListListener;

    public MovieListAdapter(Context context, int layout, List<SearchEntity> movies, MovieListListener movieListListener) {
        this.context = context;
        this.layout = layout;
        this.movies = movies;
        this.movieListListener = movieListListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(this.layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.bind(movies.get(position), movieListListener);
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

        private void bind(final SearchEntity movie, final MovieListListener movieListListener) {
            this.textViewMovie.setText(movie.getTitle().trim());
            //this.progressBarMovie.setVisibility(View.VISIBLE);
            if(!movie.getPoster().isEmpty()) {
                Picasso.get()
                        .load(movie.getPoster())
                        .placeholder(R.drawable.ic_image_black_48dp)
                        .error(R.drawable.ic_broken_image_black_48dp)
                        .into(this.imageViewPoster);
            }else{
                Picasso.get().load(R.drawable.poster).into(this.imageViewPoster);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieListListener.onItemClick(movie, getAdapterPosition());
                }
            });


        }

    }

}
