package controller;

import model.Account;
import java.util.HashMap;

public class LoginManagement {

    private static LoginManagement loginManagement = null;

    private HashMap<String, String> accessTokens;
    private HashMap<String, String> loggedInUsers;
    private Account accountManagement;

    private LoginManagement() {
        accessTokens = new HashMap<>();
        loggedInUsers = new HashMap<>();
        accountManagement = new Account();
    }

    public static LoginManagement getInstance() {
        if (loginManagement == null) {
            loginManagement = new LoginManagement();
        }
        return loginManagement;
    }

    private String generateToken() {
        String charset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String generatedString = "";
        for (int i = 0; i < 8; i++) {
            generatedString += charset.charAt((int)(Math.random() * charset.length()));
        }
        return generatedString;
    }

    private String assignAccessToken(String user_name) {
        // check whether already has record of user
        String token = loggedInUsers.get(user_name);
        if (token != null) {
            accessTokens.remove(token);
            loggedInUsers.remove(user_name);
        }
        // assign new token
        token = generateToken();
        while (accessTokens.get(token) != null) { // prevent the presence of duplicate token
            token = generateToken();
        }
        accessTokens.put(token, user_name);
        loggedInUsers.put(user_name, token);
        return token;
    }

    String handleLogin(String user_name, String password) {
        try {
            String status = accountManagement.validateLogin(user_name, password);
            if (status.equals("true")) {
                System.out.println("validation success");
                return assignAccessToken(user_name);
            } else {
                System.out.println("validation fail");
                return "no-token";
            }
        } catch (Exception e) {
            System.out.println("validation error");
            return "error";
        }
    }

    void handleLogout(String token) {
        String user = accessTokens.get(token);
        if (user != null) {
            accessTokens.remove(token);
            loggedInUsers.remove(user);
        }
    }

    String getUser(String token) { // returns null if no such user is logged in
        return accessTokens.get(token);
    }

    public String getToken(String user_name) {
        return loggedInUsers.get(user_name);
    }
}
