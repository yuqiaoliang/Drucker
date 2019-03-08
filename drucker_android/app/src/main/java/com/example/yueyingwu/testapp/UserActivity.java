package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etAge = findViewById(R.id.etAge);
        final TextView welcomeMessage = findViewById(R.id.tvWelcomeMsg);
        // create variables for each button
        final Button bMessageBox = findViewById(R.id.bMessageBox);
        final Button bPracticeGuide = findViewById(R.id.bPracticeGuide);
        final Button bTaining = findViewById(R.id.bTraining);
        final Button bDecision = findViewById(R.id.bDecision);




        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String username=intent.getStringExtra("username");
        int age =intent.getIntExtra("age",-1);

        String message=name+"Welcome to user aera!";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etAge.setText(age+"");


    }
}
