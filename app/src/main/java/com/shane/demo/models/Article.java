package com.shane.demo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 12/7/15.
 */
public class Article {
    private String title;
    private double rating;
    private String timestamp;
    private User user;

    public Article(String title, double rating, String timestamp, User user) {
        this.title = title;
        this.rating = rating;
        this.timestamp = timestamp;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static List<Article> getTestData() {
        List<Article> articles = new ArrayList<>();

        User user1 = new User("Shadow");
        User user2 = new User("Dimples");
        User user3 = new User("Fearon");

        articles.add(new Article("My Story", 4, "4 hrs ago", user3));
        articles.add(new Article("28 Days", 3, "today", user1));
        articles.add(new Article("Something", 6, "yesterday", user2));
        articles.add(new Article("Placeholder", 4, "2 days", user2));
        articles.add(new Article("248", 5, "today", user1));
        articles.add(new Article("Llamas with Hats", 7, "today", user3));
        articles.add(new Article("Gone", 6, "today", user1));
        articles.add(new Article("Hero", 2, "today", user1));

        return articles;
    }
}
