package com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities;

public class Movie {
    private Long movieId;
    private String movieTitle;
    private String director;
    private String genre;
    private String description;
    private Integer duration;
    private  String language;

    public Movie() {
    }

    public Movie(Long movieId, String movieTitle, String director, String genre, String description, Integer duration, String language) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.language = language;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
