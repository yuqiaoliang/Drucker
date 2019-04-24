package controller;

import model.Forum;
import model.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class androidNewCommentController {
    Forum liveMsgBoard = new Forum();

    //localhost:8080/forum/newcomment?content=Thank+you+professor!&commenter=Minghui+Jiang&postid=6
    @GetMapping(value="/forum/newcomment")
    public @ResponseBody postDetail newComment(@RequestParam String content, @RequestParam String commenter, @RequestParam String postid){
        try {
            Integer pid = Integer.parseInt(postid);
            Message comment = new Message(content, commenter, new Date(), pid);
            liveMsgBoard.Addcomment(comment);
            Post currPost = liveMsgBoard.getMessage(postid);

            String title = currPost.getTitle();
            String authorname = currPost.getUsername();
            String time = currPost.getStime();
            String postContent = currPost.getContent();
            ArrayList<Message> comments = currPost.getComments();

            postDetail currPostDetail = new postDetail("success", title, authorname, time, postContent, comments);
            return currPostDetail;
        } catch(Exception e){
            System.out.println("new comment error");
            postDetail noPostDetail = new postDetail("noPost", "", "", "", "", null);
            return noPostDetail;
        }

    }

}
