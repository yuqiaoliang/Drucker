package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {

    public static ArrayList<String> Titles = new ArrayList<String>();
    public static ArrayList<String> Contents = new ArrayList<String>();
    final EditText etTitle = findViewById(R.id.etTitle);
    final EditText etContents = findViewById(R.id.etContents);


    final ImageButton iBPostSubmit = findViewById(R.id.iBPostSubmit);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        iBPostSubmit.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBPostSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String contents = etContents.getText().toString();
                Titles.add(title);
                Contents.add(contents);
            }
        });



    }
}
