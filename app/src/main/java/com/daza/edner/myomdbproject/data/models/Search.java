package com.daza.edner.myomdbproject.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Search implements Serializable {

    @SerializedName("Response")
    private String response;
    @SerializedName("totalResults")
    private String totalresults;
    @SerializedName("Search")
    private List<SearchEntity> search;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public List<SearchEntity> getSearch() {
        return search;
    }

    public void setSearch(List<SearchEntity> search) {
        this.search = search;
    }
}
