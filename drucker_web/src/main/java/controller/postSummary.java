package controller;

public class postSummary {
    private String title;
    private String stime;
    private String author;
    private int commentNum;
    private int pid;

    public postSummary(String title, String stime, String author, int commentNum, int pid) {
        this.title = title;
        this.stime = stime;
        this.author = author;
        this.commentNum = commentNum;
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public String getStime() {
        return stime;
    }

    public String getAuthor() {
        return author;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public int getPid() {
        return pid;
    }
}
