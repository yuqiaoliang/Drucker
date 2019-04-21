package controller;

import model.DummyMessageBoard;
import model.Message;
import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageBoardController {

    DummyMessageBoard messageBoard = new DummyMessageBoard();

    @GetMapping("/message-board")
    public String servePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
//        /////////////////////////////////////////////////
//        // Handle login check, do not touch
        String user = LoginManagement.getInstance().getUser(token);
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("token", token);
//        /////////////////////////////////////////////////

        List<Post> posts = messageBoard.getPosts();
        System.out.println(posts.size());
        model.addAttribute("posts", posts);
        return "message-board";
    }

    @GetMapping("/message-board/post")
    public String servePostPage(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                                @RequestParam(name="postid", required=true, defaultValue="no-token") String postid,
                                Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String user = LoginManagement.getInstance().getUser(token);
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("token", token);
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
