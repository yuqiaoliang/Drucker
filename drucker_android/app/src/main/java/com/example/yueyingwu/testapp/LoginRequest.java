package com.example.yueyingwu.testapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
//public class LoginRequest{
public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "https://api.myjson.com/bins/o87cq";//need to fill in
    private Map<String,String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        //put data into params;
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
