package controller;

import model.Message;
import model.Post;
import model.DummyMessageBoard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.*;

@Controller
public class androidMessageBoardController {

    DummyMessageBoard msgBoard = new DummyMessageBoard();

    @GetMapping(value="/forum")
    public @ResponseBody List<postSummary> forum(){
        List<postSummary> forumData = new ArrayList<>();
        List<Post> posts = msgBoard.getPosts();
        for(Post post: posts){
            forumData.add(new postSummary(post.getTitle(), post.getStime(), post.getUsername(), post.getCnum(), post.getId()));
        }
        return forumData;
    }

    //localhost:8080/forum/post?postid=1
    @GetMapping(value="/forum/post")
    public @ResponseBody postDetail postDetail(@RequestParam("postid") String postid){
        Integer pid = Integer.parseInt(postid);
        Post post = msgBoard.getPost(pid);

        //if no pid, return error
       // if(post==null){}
        //if have pid, return postDetail
     //   else{
            String title = post.getTitle();
            String author = post.getUsername();
            String time = post.getStime();
            String postContent = post.getContent();
            ArrayList<Message> comments = post.getComments();

            postDetail onePost = new postDetail(title, author, time, postContent, comments);
            return onePost;
     //   }



    }



}
