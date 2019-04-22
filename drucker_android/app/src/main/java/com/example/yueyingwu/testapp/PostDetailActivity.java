package com.example.yueyingwu.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.text.DecimalFormat;
import java.util.*;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;

import static com.example.yueyingwu.testapp.LoginJBDCActivity.postComments;
import static com.example.yueyingwu.testapp.LoginJBDCActivity.postTitle;

public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        //We have our list view
        final ListView listViewPost = findViewById(R.id.listViewPost);
        String testTitle = "Hello World";
        String testAuthor = "TestAuthor";
        String testContent = "Today is a goooooooooooooooooooooooooooooooooooooooood dayyyyyyyyyyyyyyyyyy!";
        //Create an array of elements
        final ArrayList<String> postDetailList = new ArrayList<>();
        postDetailList.add("Title: " + testTitle);
        postDetailList.add("Author: " + testAuthor );
        postDetailList.add(testContent);
        //When you connect to server please use this code. If not connected, use the other piece.

        /**
         postDetailList.add("Title: " + LoginJBDCActivity.postTitle);
         postDetailList.add("Author: " + LoginJBDCActivity.postAuthor);
         //postDetailList.add(LoginJBDCActivity.postContent);
        for (int i = 0; i < postComments.size(); i++){
            postDetailList.add(postComments.get(i).getContent());
        }
         **/
        postDetailList.add("Comment:");
       for (int i = 0; i < 2/**Here you put the size of comments**/; i++){
            postDetailList.add(testContent);
       }


        //Create adapter for ArrayList
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, postDetailList);

        //Insert Adapter into List
        listViewPost.setAdapter(adapter);

        //set click functionality for each list item
        listViewPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("User clicked ", postDetailList.get(position));
            }
        });

    }
}
