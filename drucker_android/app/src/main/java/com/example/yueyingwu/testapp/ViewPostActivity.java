package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.*;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;

import android.widget.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ViewPostActivity extends AppCompatActivity {
    static ArrayList<String> allTitles =new ArrayList<String>();
    static ArrayList<String> allAuthors=new ArrayList<String>();
    static ArrayList<String> allTimes=new ArrayList<String>();
    static ArrayList<String> allComments=new ArrayList<String>();
    static ArrayList<Integer> allID=new ArrayList<Integer>();
//    static ArrayList<Integer> allComments = new ArrayList<Integer>();
//    static ArrayList<Integer> allID = new ArrayList<Integer>();
    static ListView buckyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        buckyListView = (ListView) findViewById(R.id.buckyListView);
        viewTitle showTitle=new viewTitle();
        showTitle.execute();

        buckyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==1){
                    Intent PostIntent  = new Intent(getApplicationContext(),LoginJBDCActivity.class);
                    startActivity(PostIntent);
                }
            }
        });



    }

    private class viewTitle extends AsyncTask<Void,Void,Void> {
        private String receiveTitle = "";
        @Override
        protected Void doInBackground(Void... voids) {
            String sendURL="http://192.168.1.9:8080/forum";
            String method = "GET";
            fetchResult postTitle = new fetchResult(sendURL,method);
            receiveTitle = postTitle.getResult();
            System.out.println(receiveTitle);
            try {
                JSONArray arrayString=new JSONArray(receiveTitle);
                for(int i=0;i<arrayString.length();i++){
                    JSONObject jsonTemp=arrayString.getJSONObject(i);
                    String tmpTitle=jsonTemp.getString("title");
                    String tmpTime=jsonTemp.getString("stime");
                    String tmpAuthor=jsonTemp.getString("author");
                    int tmpCommentNum=jsonTemp.getInt("commentNum");
                    int tmpID=jsonTemp.getInt("pid");
                    allTitles.add(tmpTitle);
                    allTimes.add(tmpTime);
                    allAuthors.add(tmpAuthor);
                    allComments.add(Integer.toString(tmpCommentNum));
                    allID.add(tmpID);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayAdapter buckysAdapter =new ArrayAdapter<String>(com.example.yueyingwu.testapp.ViewPostActivity.this,android.R.layout.simple_list_item_1,allTitles);
            buckyListView.setAdapter(buckysAdapter);
        }
    }

}
