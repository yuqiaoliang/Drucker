package com.example.yueyingwu.drucker_app;



import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class NewPost extends AppCompatActivity {

   // public static ArrayList<String> Titles = new ArrayList<String>();
   // public static ArrayList<String> Contents = new ArrayList<String>();



    public class SinglePostInfo{
        String m_title;
        String m_contents;
        String m_author;
        String m_time;

        public SinglePostInfo(String title, String author,String contents,String time){
            m_title = title;
            m_contents = contents;
            m_author = author;
            m_time = time;
        }

    }

    public static ArrayList<SinglePostInfo> AllPostDataArray = new ArrayList<SinglePostInfo>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        final EditText etTitle = findViewById(R.id.etTitle);
        final EditText etContents = findViewById(R.id.etContents);
        final ImageButton iBPostSubmit = findViewById(R.id.iBPostSubmit);
        iBPostSubmit.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBPostSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllPostDataArray.clear();
                String tmp_title = etTitle.getText().toString();
                String tmp_contents = etContents.getText().toString();
                if (tmp_contents.equals("") || (tmp_title.equals(""))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(NewPost.this);
                    builder.setMessage("Cannot post empty content or title").setNegativeButton("Re-enter title or content", null).create().show();
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    String tmp_time = dateFormat.format(new Date());
                    SinglePostInfo tmp = new SinglePostInfo(tmp_title, UserActivity.username, tmp_contents, tmp_time);
                    AllPostDataArray.add(tmp);
                    newPOSTtoSERVER postTOserver = new newPOSTtoSERVER();
                    postTOserver.execute();
                }

            }
       });

}

    private class newPOSTtoSERVER extends AsyncTask<Void,Void,Void> {
        private String receivedData = "";
        String testPost="";
        @Override
        protected Void doInBackground(Void... voids) {
            String encodeTitle= URLEncoder.encode(AllPostDataArray.get(0).m_title);
            String encodeAuthor=URLEncoder.encode(AllPostDataArray.get(0).m_author);
            String encodeContent=URLEncoder.encode(AllPostDataArray.get(0).m_contents);

            String sendURL="http://10.197.189.82:8080/forum/newpost?title="+encodeTitle+"&content="+encodeContent+"&author="+encodeAuthor;
            String method = "GET";
            fetchResult lightingCall = new fetchResult(sendURL,method);
            receivedData = lightingCall.getResult();
            try {
                JSONObject receivedString=new JSONObject(receivedData);
                testPost=receivedString.getString("status");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(testPost.equals("success")){
                Toast.makeText(getApplicationContext(),"Successfully Send Post",Toast.LENGTH_SHORT).show();
                Intent intentPostToMainUI = new Intent(NewPost.this, MessageBoxActivity.class);
                NewPost.this.startActivity(intentPostToMainUI);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(NewPost.this);
                builder.setMessage("Post Error").setNegativeButton("Retry", null).create().show();
            }
        }
    }
    }