package controller;

import model.DummyMessageBoard;
import model.Message;
import model.Post;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
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

//        List<Post> posts = messageBoard.getPosts();
        try {
            List<Post> posts = newforum.getMessage();
            model.addAttribute("posts", posts);
            return "message-board";
        } catch (Exception e) {
            return "error";
        }
    }


    @RequestMapping(value="/message-board",method=RequestMethod.POST)
    public String createPost(@RequestParam(name="token", required=true, defaultValue="no-token") String token,
                             @RequestParam String title, @RequestParam String content) {
        System.out.println("in the createPost");
        String user = LoginManagement.getInstance().getUser(token);
        Date date = new Date();
        try{
            Post newpost= new Post(title,content,user,date,103,new ArrayList<>(0));
            System.out.println("in the createPost");
            int pid=newforum.postMessage(newpost);
            System.out.println("CREATE POST SUCCESS.");
            System.out.println("redirect:/message-board/post/?token="+token+"&postid="+pid);
            return "redirect:/message-board/post/?token="+token+"&postid="+pid;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


    @RequestMapping(value="/create-comment",method=RequestMethod.POST)
    public String createComment(@RequestParam(name="token", required=true, defaultValue="no-token") String token,
                                @RequestParam(name="postid", required=true, defaultValue="no-pid") String postid,
                             @RequestParam String content) {
        System.out.println("in the createComment");
        String user = LoginManagement.getInstance().getUser(token);
        Date date = new Date();
        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        dateFormat_min.format(date);
        try{
            Integer pid = Integer.parseInt(postid);
            Message msg= new Message(content, user, date, pid);
            System.out.println("in the createComment");
            newforum.Addcomment(msg);
            System.out.println("CREATE COMMENT SUCCESS.");
            return "redirect:/message-board/post/?token="+token+"&postid="+pid;
            //return "post-detail";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }



    @GetMapping("/message-board/post")
    public String servePostPage(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                                @RequestParam(name="postid", required=true, defaultValue="no-pid") String postid,
                                Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("message-board", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////


        // get data from server.
        try {
            Integer pid = Integer.parseInt(postid);
            Post post = newforum.getMessage(pid.toString());
            if (post == null) {
                return "redirect:/message-board";
            }

            // add data in the model.
            String title = post.getTitle();
            String author = post.getUsername();
            String time = post.getStime();
            System.out.println(postid);
            String content = post.getContent();

            ArrayList<Message> comments = post.getComments();

            model.addAttribute("title", title);
            model.addAttribute("author", author);
            model.addAttribute("time", time);
            model.addAttribute("content", content);
            model.addAttribute("comments", comments);
            model.addAttribute("postid",postid);
            return "post-detail";
        } catch (Exception e) {
            return "error";
        }











//        // get data from server.
//        Integer pid = Integer.parseInt(postid);
//        Post post = messageBoard.getPost(pid);
//        if(post == null) {
//            return "redirect:/message-board";
//        }
//
//        // add data in the model.
//        String title = post.getTitle();
//        String author = post.getUsername();
//        String time = post.getStime();
//
//        String content = post.getContent();
//
//        ArrayList<Message> comments = post.getComments();
//
//        model.addAttribute("title", title);
//        model.addAttribute("author", author);
//        model.addAttribute("time", time);
//        model.addAttribute("content", content);
//        model.addAttribute("comments", comments);
//
//        return "post-detail";
    }
}
