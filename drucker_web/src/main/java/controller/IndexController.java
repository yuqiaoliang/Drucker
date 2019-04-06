package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String user = LoginManagement.getInstance().getUser(token);
        if (user == null) {
            token = "no-token";
        }
        model.addAttribute("user", user);
        model.addAttribute("token", token);
        /////////////////////////////////////////////////
        return "index";
    }
}
