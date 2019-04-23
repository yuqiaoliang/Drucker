package controller;

import model.Forum;
import model.Message;
import model.Post;
import model.DummyMessageBoard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

@Controller
public class androidMessageBoardController {

    //DummyMessageBoard msgBoard = new DummyMessageBoard();
    Forum liveMsgBoard = new Forum();

    @GetMapping(value="/forum")
    public @ResponseBody List<postSummary> forum(){
        List<postSummary> forumData = new ArrayList<>();
        try {
            List<Post> posts = liveMsgBoard.getMessage();
            for (Post post : posts) {
                forumData.add(new postSummary(post.getTitle(), post.getStime(), post.getUsername(), post.getCnum(), post.getId()));
            }
            return forumData;
        } catch (Exception e){
            System.out.println("get all posts error");
            return forumData;
        }

    }

    //localhost:8080/forum/post?postid=1
    @GetMapping(value="/forum/post")
    public @ResponseBody postDetail postDetail(@RequestParam("postid") String postid){
        try {
            //Integer pid = Integer.parseInt(postid);
            Post post = liveMsgBoard.getMessage(postid);

            //if no pid, return error
            if (post == null) {
                String title = "";
                String author = "";
                String time = "";
                String postContent = "";
                ArrayList<Message> comments = null;
                postDetail onePost = new postDetail("noPost", title, author, time, postContent, comments);
                return onePost;

            }
            //if have pid, return postDetail
            else {
                String title = post.getTitle();
                String author = post.getUsername();
                String time = post.getStime();
                String postContent = post.getContent();
                ArrayList<Message> comments = post.getComments();

                postDetail onePost = new postDetail("success", title, author, time, postContent, comments);
                return onePost;
            }
        } catch(Exception e){
            System.out.println("get post "+postid+" error");
            postDetail onePost = new postDetail("noPost", "", "", "", "", null);
            return onePost;
        }



    }



}
