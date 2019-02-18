package com.daza.edner.myomdbproject.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daza.edner.myomdbproject.R;
import com.daza.edner.myomdbproject.data.models.SearchEntity;
import com.daza.edner.myomdbproject.utils.CommonUtils;
import com.squareup.picasso.Picasso;


public class MovieDetailActivity extends AppCompatActivity {

    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewImdbId;
    private TextView textViewYear;
    private TextView textViewType;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetail);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageViewPoster = findViewById(R.id.main_backdrop);
        Intent intent = getIntent();
        SearchEntity searchEntity = (SearchEntity) intent.getSerializableExtra(CommonUtils.POST_KEY);
        Toast.makeText(this,
                searchEntity.getTitle()+" "+searchEntity.getYear(),
                Snackbar.LENGTH_LONG).show();
        if(!searchEntity.getPoster().isEmpty()) {
            Picasso.get()
                    .load(searchEntity.getPoster())
                    .placeholder(R.drawable.ic_image_black_48dp)
                    .error(R.drawable.ic_broken_image_black_48dp)
                    .into(this.imageViewPoster);
        }else{
            Picasso.get().load(R.drawable.poster).into(this.imageViewPoster);
        }
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(searchEntity.getTitle());

        textViewTitle = findViewById(R.id.grid_title);
        textViewTitle.setText(searchEntity.getTitle());
        textViewImdbId = findViewById(R.id.grid_imdbid);
        textViewImdbId.setText(searchEntity.getImdbid());
        textViewYear = findViewById(R.id.grid_year);
        textViewYear.setText(searchEntity.getYear());
        textViewType = findViewById(R.id.grid_type);
        textViewType.setText(searchEntity.getType());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
