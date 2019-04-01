package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.Account;

import java.sql.SQLException;

@Controller
public class AccountController {

    private Account myAccount = new Account();

    @GetMapping("/login")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws SQLException {
        model.addAttribute("name", name);
        System.out.println(myAccount.validateLogin("testuser", "testpassword"));
        return "login";
    }

    @GetMapping("/logout")
    public String logout(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws SQLException {
        model.addAttribute("name", name);
        System.out.println(myAccount.validateLogin("testuser", "testpasswort"));
        return "logout";
    }

}
