package com.shane.demo.models;

/**
 * Created by shane on 12/7/15.
 */
public class Video {
    private String title;
    private String timestamp;
    private int duration;
    private double rating;
    private User user;

    public Video(String title, String timestamp, int duration, double rating, User user) {
        this.title = title;
        this.timestamp = timestamp;
        this.duration = duration;
        this.rating = rating;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
