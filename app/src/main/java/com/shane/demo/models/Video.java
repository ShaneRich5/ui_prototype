package com.shane.demo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 12/7/15.
 */
public class Video {
    private String title;
    private String timestamp;
    private int duration;
    private double rating;
    private User user;

    public Video(String title, double rating, String timestamp, int duration,  User user) {
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

    public static List<Video> getTestData() {
        List<Video> videos = new ArrayList<>();

        User user1 = new User("Shadow");
        User user2 = new User("Dimples");
        User user3 = new User("Fearon");

        videos.add(new Video("My Story", 4, "4 hrs ago", 360, user3));
        videos.add(new Video("28 Days", 3, "today", 400, user1));
        videos.add(new Video("Something", 6, "yesterday", 230, user2));
        videos.add(new Video("Placeholder", 4, "2 days", 700, user2));
        videos.add(new Video("248", 5, "today", 400, user1));
        videos.add(new Video("Llamas with Hats", 7, "today", 540, user3));
        videos.add(new Video("Gone", 6, "today", 630, user1));
        videos.add(new Video("Hero", 2, "today", 700, user1));

        return videos;
    }
}
