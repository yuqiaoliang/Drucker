package model;

import java.io.Serializable;

public class Link implements Serializable {
    private String title;
    private String url;
    private String type;

    public Link(String title, String url, String type) {
        this.title = title;
        this.url = url;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }
}
