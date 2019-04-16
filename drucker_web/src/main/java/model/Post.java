package model;

import java.util.ArrayList;

public class Post extends Message {
    private ArrayList<Message> comments;

    public Post(String title, String content, String authorname, int id, ArrayList<Message> comments) {
        super(title, content, authorname, id);
        this.comments = comments;
    }

    public ArrayList<Message> getComments() {
        return comments;
    }
}
