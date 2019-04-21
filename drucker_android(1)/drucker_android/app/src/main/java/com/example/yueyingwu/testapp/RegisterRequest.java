package com.example.yueyingwu.testapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//communicate with server
//public class RegisterRequest {
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = " ";//need to fill in
    private Map<String,String> params;

    public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        //put data into params;
        params=new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("age",age+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
