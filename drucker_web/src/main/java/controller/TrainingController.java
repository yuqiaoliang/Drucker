package controller;

import model.Link;
import model.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TrainingController {

    URL urlManagement = new URL();

    @GetMapping("/training")
    public String training(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String path = LoginManagement.validateUser("training", token, model);
        if (path != null) return path;
        /////////////////////////////////////////////////
        ArrayList<Link> links = urlManagement.getLinks();
        model.addAttribute("links", links);
        return "training";
    }

}
