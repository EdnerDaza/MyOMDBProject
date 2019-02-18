package com.daza.edner.myomdbproject.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchEntity implements Serializable {
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Type")
    private String type;
    @SerializedName("imdbID")
    private String imdbid;
    @SerializedName("Year")
    private String year;
    @SerializedName("Title")
    private String title;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
