package com.shane.demo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 12/7/15.
 */
public class Comment {
    String content;
    String timestamp;
    User user;

    public Comment(String content, String timestamp, User user) {
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public static List<Comment> getTestData() {
        List<Comment> comments = new ArrayList<>();

        User user1 = new User("Shadow");
        User user2 = new User("Dimples");
        User user3 = new User("Fearon");

        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "30 mins ago", user1));
        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "1 hr ago", user2));
        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "1 hr ago", user1));
        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "2 hr ago", user3));
        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "2 hr ago", user2));
        comments.add(new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing.", "3 hr ago", user3));

        return comments;
    }
}
