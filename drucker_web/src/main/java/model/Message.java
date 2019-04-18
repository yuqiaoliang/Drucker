package model;

import java.util.Date;

public class Message {
    private String content;
    private String username;
    private Date time;
    private int id;

    public Message(String content, String authorname, Date time, int id) {
        this.content = content;
        this.username = authorname;
        this.time = time;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
