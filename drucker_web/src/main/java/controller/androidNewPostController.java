package controller;

import model.Forum;
import model.Message;
import model.Post;
import model.DummyMessageBoard;
import java.net.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

@Controller
public class androidNewPostController {
    Forum liveMsgBoard = new Forum();

//localhost:8080/forum/newpost?title=3No+Class+tomorrow&content=Next+week+will+be+reading+week&author=Ric
    @RequestMapping(value="/forum/newpost",method= RequestMethod.GET)
    public @ResponseBody validation newPost(@RequestParam String title, @RequestParam String content,
                              @RequestParam String author){
        validation errorMsg = new validation();
        try {
            Integer pid = liveMsgBoard.newPostNumber();
            //System.out.println("postid="+pid);
            Post newpost = new Post(title, content, author, new Date(), pid, new ArrayList<>());
            System.out.println("post time:"+newpost.getStime());
            liveMsgBoard.postMessage(newpost);
            errorMsg.setStatus("success");
            return errorMsg;
        } catch(Exception e){
            System.out.println("new post error");
            return errorMsg;
        }
    }

}
