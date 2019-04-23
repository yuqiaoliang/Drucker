package controller;

import model.DummyMessageBoard;
import model.Message;
import model.Post;

import java.sql.SQLException;
import java.util.Date;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import model.Forum;
import controller.LoginManagement;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageBoardController {

    DummyMessageBoard messageBoard = new DummyMessageBoard();
    Forum newforum= new Forum();

    @GetMapping("/message-board")
    public String servePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("message-board", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////

        List<Post> posts = messageBoard.getPosts();
        model.addAttribute("posts", posts);
        return "message-board";
    }


    @RequestMapping(value="/message-board", method=RequestMethod.POST)
    public String createPost(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                             @RequestParam String title, @RequestParam String content) throws SQLException {
        System.out.println("in the createPost");
        String user = LoginManagement.getInstance().getUser(token);
        Date date = new Date();
        //try{
            Post newpost= new Post(title,content,user,date,103,new ArrayList<>(0));
            System.out.println("in the createPost");
            newforum.postMessage(newpost);
            System.out.println("CREATE POST SUCCESS.");
        /*} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }*/

        return "redirect:/message-board"+"?token="+token;

    }

    @GetMapping("/message-board/post")
    public String servePostPage(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                                @RequestParam(name="postid", required=true, defaultValue="no-token") String postid,
                                Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("message-board", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////


        // get data from server.
        Integer pid = Integer.parseInt(postid);
        Post post = messageBoard.getPost(pid);
        if(post == null) {
            return "redirect:/message-board";
        }

        // add data in the model.
        String title = post.getTitle();
        String author = post.getUsername();
        String time = post.getStime();

        String content = post.getContent();

        ArrayList<Message> comments = post.getComments();

        model.addAttribute("title", title);
        model.addAttribute("author", author);
        model.addAttribute("time", time);
        model.addAttribute("content", content);
        model.addAttribute("comments", comments);

        return "post-detail";
    }
}
