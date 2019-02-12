package com.daza.edner.myomdbproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.daza.edner.myomdbproject.R;
import com.daza.edner.myomdbproject.adapters.MovieAdapter;
import com.daza.edner.myomdbproject.adapters.SearchAdapter;
import com.daza.edner.myomdbproject.interfaces.MovieInterface;
import com.daza.edner.myomdbproject.models.Movie;
import com.daza.edner.myomdbproject.models.Search;
import com.daza.edner.myomdbproject.utils.API;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<Movie> arrayListMovies;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        arrayListMovies = new ArrayList<Movie>();
        recyclerView = findViewById(R.id.rvMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new StaggeredGridLayoutManager(getResources().
                getInteger(R.integer.grid_column_count), StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                this.onResume();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fillInfo(Movie movie) {
        arrayListMovies.add(movie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new StaggeredGridLayoutManager(getResources().
                getInteger(R.integer.grid_column_count), StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(this, R.layout.cardview_items, arrayListMovies);
        recyclerView.setAdapter(adapter);
    }

    private void fillMovieList(Search search) {
        //arrayListMovies.add(movie);
        adapter = new SearchAdapter(this, R.layout.cardview_items, search.getSearch());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getMovie() {
        MovieInterface service = API.getApi().create(MovieInterface.class);
        Call<Movie> callMovie = service.getMovie();
        callMovie.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Toast.makeText(DetailActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                fillInfo(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getMovies() {
        MovieInterface service = API.getApi().create(MovieInterface.class);
        Call<Search> callSearch = service.getSearch("inception", API.API_KEY);
        callSearch.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Toast.makeText(DetailActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                fillMovieList(response.body());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
