package model;

import java.util.ArrayList;
import java.util.Date;

public class Post extends Message {
    private String title;
    private ArrayList<Message> comments;

    public Post(String title, String content, String authorname, Date time, int id, ArrayList<Message> comments) {
        super(content, authorname, time, id);
        this.comments = comments;
        this.title = title;
    }

    public ArrayList<Message> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }
}
