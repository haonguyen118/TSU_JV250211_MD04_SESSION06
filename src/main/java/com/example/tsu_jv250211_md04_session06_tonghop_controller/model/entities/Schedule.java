package com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


public class Schedule {
    private Long id;
    private String movieTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showTime;
    private Long screenRoomId;
    private Integer availableSeat;
    private String format;

    public Schedule() {
    }

    public Schedule(Long id, String movieTitle, Date showTime, Long screenRoomId, Integer availableSeat, String format) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.screenRoomId = screenRoomId;
        this.availableSeat = availableSeat;
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Long getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(Long screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public Integer getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

