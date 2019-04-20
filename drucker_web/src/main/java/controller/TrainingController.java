package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainingController {

    @GetMapping("/training")
    public String training(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("training", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////
        return "training";
    }

}
