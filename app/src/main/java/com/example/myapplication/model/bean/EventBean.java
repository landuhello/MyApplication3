package com.example.myapplication.model.bean;

public class EventBean {
    public int movieId;

    public EventBean(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
