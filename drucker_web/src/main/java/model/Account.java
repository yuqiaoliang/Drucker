package model;

import java.util.HashMap;

public class Account {

    private HashMap<String, String> users;

    public Account() {
        // this is a placeholder constructor for account information
        users = new HashMap<>();
        users.put("testuser", "testpassword");
    }

    public String validateLogin(String username, String password) {
        String pwd = users.get(username);
        if (pwd.equals(password)) {
            return "yah!";
        } else if (users.get(username) == null) {
            return "wha?";
        } else {
            return "nay!";
        }
    }
}
