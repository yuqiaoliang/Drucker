package com.example.yueyingwu.drucker_app;

import java.io.Serializable;

public class Message implements Serializable {
    private String content;
    private String shortContent;
    private String username;
//    private Date time;
    private String stime;
    private int id;

    public Message(String content, String authorname, String time, int id) {
        this.content = content;
        this.username = authorname;
        this.stime = time;
//        this.time = time;
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        this.stime = dateFormat.format(time);
        this.id = id;
        if (content.length() > 300) {
            this.shortContent = content.substring(0,300) + "...";
        } else {
            this.shortContent = content;
        }
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

//    public Date getTime() {
//        return time;
//    }

    public String getStime() {
        return stime;
    }

    public String getShortContent() {
        return shortContent;
    }

}
