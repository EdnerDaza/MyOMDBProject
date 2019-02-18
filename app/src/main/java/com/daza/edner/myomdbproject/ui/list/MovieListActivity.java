package com.daza.edner.myomdbproject.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daza.edner.myomdbproject.R;
import com.daza.edner.myomdbproject.data.API;
import com.daza.edner.myomdbproject.data.models.Search;
import com.daza.edner.myomdbproject.data.models.SearchEntity;
import com.daza.edner.myomdbproject.interfaces.MovieInterface;
import com.daza.edner.myomdbproject.ui.detail.MovieDetailActivity;
import com.daza.edner.myomdbproject.utils.CommonUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity implements View.OnClickListener, MovieListListener {

    private Button searchButton;
    private ArrayList<String> arrayListMovies;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextInputEditText textInputEditText;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);
        textInputEditText = findViewById(R.id.tietSearchMovie);
        searchButton = findViewById(R.id.btnSearchMovie);
        searchButton.setOnClickListener(this);
        arrayListMovies = getAllMovies();
        recyclerView = findViewById(R.id.rvSearchMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new StaggeredGridLayoutManager(getResources().
                getInteger(R.integer.grid_column_count), StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                textInputEditText.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSearchMovie:
                if(CommonUtils.isNetworkAvailable(getApplicationContext())) {
                    //CommonUtils.hideSoftKeyboard(MovieListActivity.this);
                    String movieTitle = textInputEditText.getText().toString().trim();
                    if (!movieTitle.isEmpty()) {
                        getMovies(movieTitle);
                    }
                    else
                        Snackbar.make(recyclerView,
                                getResources().getString(R.string.snackbar_title_empty),
                                Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(recyclerView,
                            getResources().getString(R.string.network_not_available),
                            Snackbar.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    private void searchMovietitle(Search search) {
        adapter = new MovieListAdapter(this, R.layout.cardview_movie_items, search.getSearch(), this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getMovies(String textSearch) {
        MovieInterface service = API.getApi().create(MovieInterface.class);
        Call<Search> callSearch = service.getSearch(textSearch, API.API_KEY);
        callSearch.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                searchMovietitle(response.body());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Toast.makeText(MovieListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<String> getAllMovies() {
        return new ArrayList<String>(){{
            Long l = Long.valueOf(1);
            add("edner");
            add("enrique");
            add("daza");
            add("miranda");
            add("lisa");
            add("bart");
            add("homero");
            add("maggie");
            add("marge");
        }};
    }

    @Override
    public void onItemClick(SearchEntity entity, int position) {
        /*Snackbar.make(recyclerView,
               entity.getTitle()+" "+position,
                Snackbar.LENGTH_LONG).show();*/
        Intent intent = new Intent(MovieListActivity.this, MovieDetailActivity.class);
        //intent.putExtra("id", city.getId());
        intent.putExtra(CommonUtils.POST_KEY, entity);
        startActivity(intent);
    }
}
