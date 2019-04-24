package controller;


import model.Message;
import java.util.ArrayList;
import java.util.List;

public class postDetail {
    private String errorMsg;
    private String title;
    private String author;
    private String time;
    private String content;
    private ArrayList<Message> comments;

    public postDetail(String errorMsg, String title, String author, String time, String content, ArrayList<Message> comments) {
        this.errorMsg = errorMsg;
        this.title = title;
        this.author = author;
        this.time = time;
        this.content = content;
        this.comments = comments;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Message> getComments() {
        return comments;
    }
}
