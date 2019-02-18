package com.daza.edner.myomdbproject.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    @SerializedName("Response")
    private String response;
    @SerializedName("Website")
    private String website;
    @SerializedName("Production")
    private String production;
    @SerializedName("BoxOffice")
    private String boxoffice;
    @SerializedName("DVD")
    private String dvd;
    @SerializedName("Type")
    private String type;
    @SerializedName("imdbID")
    private String imdbid;
    @SerializedName("imdbVotes")
    private String imdbvotes;
    @SerializedName("imdbRating")
    private String imdbrating;
    @SerializedName("Metascore")
    private String metascore;
    @SerializedName("Ratings")
    private List<RatingsEntity> ratings;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Country")
    private String country;
    @SerializedName("Language")
    private String language;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("Director")
    private String director;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Released")
    private String released;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Year")
    private String year;
    @SerializedName("Title")
    private String title;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getBoxoffice() {
        return boxoffice;
    }

    public void setBoxoffice(String boxoffice) {
        this.boxoffice = boxoffice;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
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

    public String getImdbvotes() {
        return imdbvotes;
    }

    public void setImdbvotes(String imdbvotes) {
        this.imdbvotes = imdbvotes;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public List<RatingsEntity> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingsEntity> ratings) {
        this.ratings = ratings;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
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
