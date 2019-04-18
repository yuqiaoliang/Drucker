package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Post extends Message implements Serializable {
    private String title;
    private ArrayList<Message> comments;
    private int cnum;

    public Post(String title, String content, String authorname, Date time, int id, ArrayList<Message> comments) {
        super(content, authorname, time, id);
        this.comments = comments;
        this.title = title;
        this.cnum = comments.size();
    }

    public ArrayList<Message> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public int getCnum() {
        return cnum;
    }
}
