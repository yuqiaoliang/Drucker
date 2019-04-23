package controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class androidAccountController {

    //url type: /loginStatus?username=testuser1&password=00000000
    @GetMapping(value="/loginStatus")
    public @ResponseBody validation loginStatus(@RequestParam("username") String username,
                                              @RequestParam("password") String password){

        Account userAccount = new Account();
        validation valid = new validation();
        try{
            System.out.println(username + " "+password);
            String sta = userAccount.validateLogin(username, password);
           // System.out.println("in controller: status=" + sta);
            valid.setStatus(sta);
            System.out.println("android connected with server: "+valid.getStatus());
            return valid;

        } catch(Exception e){
            System.out.println("validation error");
            return valid;
        }

    }

}
