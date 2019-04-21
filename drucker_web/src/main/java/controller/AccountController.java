package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/login")
    public String login(@RequestParam(name="token", required=false, defaultValue="no-token") String token,
                        @RequestParam(name="error", required=false, defaultValue="no-error") String error, Model model) {
        String user = LoginManagement.getInstance().getUser(token);
        if (user != null) {
            System.out.println(user);
            return "redirect:/?token=" + token;
        } else if (error.equals("login_fail")) {
            model.addAttribute("error_msg", "User name or password incorrect");
        }
        return "login";
    }

    @RequestMapping(value="/validate-login",method= RequestMethod.POST)
    public String validateLogin(@RequestParam String user_name,
                                @RequestParam String password, Model model) {
        String token = LoginManagement.getInstance().handleLogin(user_name, password);
        if (token.equals("no-token")) {
            return "redirect:/login?error=login_fail";
        } else if (token.equals("error")) {
            return "redirect:/error";
        }
        return "redirect:/?token=" + token;
    }

    @GetMapping("/logout")
    public String logout(@RequestParam(name="token", required=false, defaultValue="no-token") String token, Model model) {
        if (!token.equals("no-token")) {
            LoginManagement.getInstance().handleLogout(token);
            return "redirect:/logout";
        }
        return "logout";
    }

}
