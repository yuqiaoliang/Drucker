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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;


public class PostDetailActivity extends AppCompatActivity {
    static String postError;
    static String postTitle;
    static String postAuthor;
    static String postTime;
    static String postContent;
    static ArrayList<Message> postComments=new ArrayList<Message>();
    static int postPID;
    static int postCommentNum;

    static ListView listViewPost;
    static ArrayList<String> postDetailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        //We have our list view

        listViewPost = findViewById(R.id.listViewPost);

        Intent receivedIntent=getIntent();
        postPID=receivedIntent.getIntExtra("postID",1);
        System.out.println(Integer.toString(postPID));
        postCommentNum=receivedIntent.getIntExtra("postCommentNum",1);
        System.out.println(Integer.toString(postCommentNum));

        viewPostDetail viewPost=new viewPostDetail();
        viewPost.execute();


//        String testTitle = "Hello World";
//        String testAuthor = "TestAuthor";
//        String testContent = "Today is a goooooooooooooooooooooooooooooooooooooooood dayyyyyyyyyyyyyyyyyy!";
        //Create an array of elements

//        postDetailList.add("Title: " + testTitle);
//        postDetailList.add("Author: " + testAuthor );
//        postDetailList.add(testContent);
        //When you connect to server please use this code. If not connected, use the other piece.




//        postDetailList.add("Comment:");
//       for (int i = 0; i < 2/**Here you put the size of comments**/; i++){
//            postDetailList.add(testContent);
//       }


        //Create adapter for ArrayList
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, postDetailList);
//
//        //Insert Adapter into List
//        listViewPost.setAdapter(adapter);

        //set click functionality for each list item
//        listViewPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("User clicked ", postDetailList.get(position));
//            }
//        });

    }

    private class viewPostDetail extends AsyncTask<Void,Void,Void> {
        private String receiveDetailInfo = "";
        @Override
        protected Void doInBackground(Void... voids) {
            String sendURL="http://192.168.1.9:8080/forum/post?postid="+Integer.toString(postPID);
            String method = "GET";
            fetchResult postDetail = new fetchResult(sendURL,method);
            receiveDetailInfo = postDetail.getResult();
//            System.out.println(receiveDetailInfo);
            try {
                JSONObject postInfo=new JSONObject(receiveDetailInfo);
                postError=postInfo.getString("errorMsg");
                if(postError.equals("success")){
                    postTitle=postInfo.getString("title");
                    postAuthor=postInfo.getString("author");
                    postTime=postInfo.getString("time");
                    postContent=postInfo.getString("content");
                    JSONArray jsonComments=postInfo.getJSONArray("comments");
                    for(int i=0;i<jsonComments.length();i++){
                        JSONObject tmpCommentObj=jsonComments.getJSONObject(i);
                        String tmpContent=tmpCommentObj.getString("content");
//                        String tmpShortContent=tmpCommentObj.getString("shortContent");
                        String tmpAuthor=tmpCommentObj.getString("username");
                        String tmpTime=tmpCommentObj.getString("stime");
                        int tmpID=tmpCommentObj.getInt("id");
                        Message commentTmp=new Message(tmpContent,tmpAuthor,tmpTime,tmpID);
                        postComments.add(commentTmp);
                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            postDetailList.add("Title: " + postTitle);
            postDetailList.add("Author: " + postAuthor);
            postDetailList.add("Time: "+ postTime);
            postDetailList.add("Content: ");
            postDetailList.add(postContent);
            postDetailList.add("Comment:");
            for (int i = 0; i < postComments.size(); i++){
                postDetailList.add(postComments.get(i).getContent());
            }
            ArrayAdapter<String> adapterPostDetail = new ArrayAdapter<>(com.example.yueyingwu.testapp.PostDetailActivity.this,android.R.layout.simple_list_item_1, postDetailList);
            listViewPost.setAdapter(adapterPostDetail);

//            tVTitle.setText(postTitle);
//            tVContent.setText(postContent);
//            tVAuthor.setText(postAuthor);
//            tVTime.setText(postTime);
//            tVComment1.setText(postComments.get(0).getContent());
//            tVComment2.setText(postComments.get(1).getContent());

        }
    }
}
