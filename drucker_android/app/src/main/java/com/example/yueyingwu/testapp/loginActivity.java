package com.example.yueyingwu.testapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        final Button bLogin = findViewById(R.id.bLogin);
        final TextView registerLink = findViewById(R.id.tvRegisterHere);


        //connect registerLink to the register page
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(loginActivity.this, RegisterActivity.class);
                loginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info","Button press");
                final String username=etUsername.getText().toString();
                final String password=etPassword.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse =new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");
                            if(success){
                                Log.i("Info","success");
                                String name=jsonResponse.getString("name");//need modify
                                int age=jsonResponse.getInt("age");//need modify

                                Intent intent=new Intent(loginActivity.this,UserActivity.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("age",age);

                                loginActivity.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(loginActivity.this);
                                builder.setMessage("Wrong username or password").setNegativeButton("Retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest=new LoginRequest(username,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(loginActivity.this);
                queue.add(loginRequest);
            }
        });


    }
}
