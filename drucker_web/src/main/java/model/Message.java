package model;

public class Message {
    private String title;
    private String content;
    private String username;
    private int id;

    public Message(String title, String content, String authorname, int id) {
        this.title = title;
        this.content = content;
        this.username = authorname;
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

    public String getTitle() {
        return title;
    }
}
