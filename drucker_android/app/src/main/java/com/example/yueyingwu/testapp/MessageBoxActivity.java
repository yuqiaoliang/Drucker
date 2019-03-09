package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MessageBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_box);

        final Button back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent userIntent  = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(userIntent);
            }

        });

    }
}
