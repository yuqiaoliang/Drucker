package com.example.yueyingwu.testapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginJBDCActivity extends AppCompatActivity {
    static String postError;
    static String postTitle;
    static String postAuthor;
    static String postTime;
    static String postContent;
    static ArrayList<Message> postComments=new ArrayList<Message>();
    static TextView tVTitle;
    static TextView tVContent;
    static TextView tVAuthor;
    static TextView tVTime;
    static TextView tVComment1;
    static TextView tVComment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_jbdc);

        tVTitle= findViewById(R.id.tVtitle);
        tVContent=findViewById(R.id.tVcontent);
        tVAuthor=findViewById(R.id.tVauthor);
        tVTime=findViewById(R.id.tVtime);
        tVComment1=findViewById(R.id.tVcomment1);
        tVComment2=findViewById(R.id.tVcomment2);

      //  viewPost viewTest=new viewPost();
       // viewTest.execute();




    }
    private class viewPost extends AsyncTask<Void,Void,Void> {
        private String receiveDetailInfo = "";
        @Override
        protected Void doInBackground(Void... voids) {
            String sendURL="http://192.168.1.9:8080/forum/post?postid=3";
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

            tVTitle.setText(postTitle);
            tVContent.setText(postContent);
            tVAuthor.setText(postAuthor);
            tVTime.setText(postTime);
            tVComment1.setText(postComments.get(0).getContent());
            tVComment2.setText(postComments.get(1).getContent());

        }
    }
}
