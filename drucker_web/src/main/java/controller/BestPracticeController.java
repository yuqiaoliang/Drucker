package controller;

import model.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BestPracticeController {

    @GetMapping("/best-practice")
    public String bestPractice(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
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
    /*public ModelAndView getdata() {

        ArrayList<String> list = getList();

        //return back to index.jsp
        ModelAndView model = new ModelAndView("best_practice");
        model.addObject("lists", list);

        return model;

    }

    private  ArrayList<String> getList() {

        URL newURL= new URL();
        ArrayList<String> videoURLs=newURL.getUrl("video");

        return videoURLs;

    }*/

}
