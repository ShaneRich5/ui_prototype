package com.shane.demo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 12/7/15.
 */
public class Article {
    private String title;
    private String timestamp;
    private User user;

    public Article(String title, String timestamp, User user) {
        this.title = title;
        this.timestamp = timestamp;
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
    }
}
