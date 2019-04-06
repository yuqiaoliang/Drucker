package controller;

import model.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class BestPracticeController {

    @GetMapping("/best-practice")
    public String bestPractice(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        /////////////////////////////////////////////////
        // Handle login check, do not touch
        String user = LoginManagement.getInstance().getUser(token);
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("token", token);
        /////////////////////////////////////////////////

        URL newURL= new URL();
       // repository.save(newURL);
        model.addAttribute("urls",newURL);
        //ArrayList<String> pdfURLs=newURL.getUrl("pdf");
        ArrayList<String> pdfURLs=newURL.getUrl("pdf");
        //System.out.println(pdfURLs.get(0));
        //model.addAttribute("pdfUrls",pdfURLs);
        //String videoUrls0=videoURLs.get(0);
        //model.addAttribute("pdfUrls",pdfURLs);
        model.addAttribute("pdfUrls0",pdfURLs.get(0));
        model.addAttribute("pdfUrls1",pdfURLs.get(1));
        model.addAttribute("pdfUrls2",pdfURLs.get(2));
        model.addAttribute("pdfUrls3",pdfURLs.get(3));
        return "best_practice";//;+pdfURLs.get(1)+videoURLs.get(1);
    }


}
