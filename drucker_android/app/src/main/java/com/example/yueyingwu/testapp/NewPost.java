package com.example.yueyingwu.testapp;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
public class NewPost extends AppCompatActivity {

   // public static ArrayList<String> Titles = new ArrayList<String>();
   // public static ArrayList<String> Contents = new ArrayList<String>();



    public class SinglePostInfo{
        String m_title;
        String m_contents;
        String m_author;
        String m_time;
        int m_commentNum;
        int m_pid;
        String m_stime;
        public SinglePostInfo(String title, String contents){
            m_title = title;
            m_contents = contents;
            m_author = "N.A.";
            m_time = "N.A.";
            m_commentNum = 0;
            m_pid = 0;
            m_stime = "N.A.";

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

                String tmp_title = etTitle.getText().toString();
                String tmp_contents = etContents.getText().toString();
                SinglePostInfo tmp = new SinglePostInfo(tmp_title, tmp_contents);
                AllPostDataArray.add(tmp);

            }
       });

}
    }