package com.daza.edner.myomdbproject.interfaces;

import com.daza.edner.myomdbproject.models.Movie;
import com.daza.edner.myomdbproject.models.Search;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieInterface {
    @GET("?")
    Call<Movie> getMovie(@Query("i") String imdbId, @Query("apikey") String apikey);

    @GET("?")
    Call<Search> getSearch(@Query("s") String textSearch, @Query("apikey") String apikey);
}
