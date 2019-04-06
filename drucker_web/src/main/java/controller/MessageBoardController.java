package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageBoardController {

    @GetMapping("/message-board")
    public String servePage(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String user = LoginManagement.getInstance().getUser(token);
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("token", token);
        /////////////////////////////////////////////////
        return "message_board";
    }

}
