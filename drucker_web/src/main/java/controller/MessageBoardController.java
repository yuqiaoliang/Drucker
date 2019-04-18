package controller;

import model.DummyMessageBoard;
import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageBoardController {

    DummyMessageBoard messageBoard = new DummyMessageBoard();

    @GetMapping("/message-board")
    public String servePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
//        /////////////////////////////////////////////////
//        // Handle login check, do not touch
//        String user = LoginManagement.getInstance().getUser(token);
//        if (user == null) {
//            return "redirect:/login";
//        }
//        model.addAttribute("user", user);
//        model.addAttribute("token", token);
//        /////////////////////////////////////////////////

        List<Post> posts = messageBoard.getPosts();
        System.out.println(posts.size());
        model.addAttribute("posts", posts);
        return "message_board";
    }

    @GetMapping("/message-board/post/")
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

        // add data in the model.


        return "post_detail";
    }
}
