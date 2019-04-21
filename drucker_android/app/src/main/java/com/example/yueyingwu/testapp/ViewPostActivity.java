package com.example.yueyingwu.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;

import android.widget.*;


public class ViewPostActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        final ArrayList AllPostData = NewPost.AllPostDataArray;
        //ArrayList<String> foods = new ArrayList<String>();
        //foods.add("Bacon");
        ArrayList<String> allTitles = new ArrayList<String>();

        for (int i = 0; i < AllPostData.size(); i++){
            NewPost.SinglePostInfo tmp = (NewPost.SinglePostInfo)AllPostData.get(i);

           allTitles.add(tmp.m_title);

       }
        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allTitles);
       ListView buckyListView = (ListView) findViewById(R.id.buckyListView);
       buckyListView.setAdapter(buckysAdapter);



    }

}
