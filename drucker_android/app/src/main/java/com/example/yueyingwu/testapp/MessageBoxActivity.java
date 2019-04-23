package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MessageBoxActivity extends AppCompatActivity {
  //  public void toNewPost(View v) {
  //    Intent newPostIntent = new Intent(getApplicationContext(), NewPost.class);
 //      startActivity(newPostIntent);
 // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_box);
        final ImageButton iBNewPost = findViewById(R.id.iBNewPost);
        final ImageButton iBViewPost = findViewById(R.id.iBViewPost);

        iBNewPost.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newPostIntent = new Intent(getApplicationContext(), NewPost.class);
                startActivity(newPostIntent);
            }
        });

        iBViewPost.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewPostActivity.allTitles.clear();
                ViewPostActivity.allAuthors.clear();
                ViewPostActivity.allComments.clear();
                ViewPostActivity.allTimes.clear();
                ViewPostActivity.allID.clear();
                //Intent viewPostIntent = new Intent(getApplicationContext(), ViewPostActivity.class);

                Intent viewPostIntent = new Intent(getApplicationContext(), TestNewCommentActivity.class);
                startActivity(viewPostIntent);

//                Intent viewPostIntent = new Intent(getApplicationContext(), PostDetailActivity.class);
//                startActivity(viewPostIntent);
            }
        });


       /* final Button msgBack = findViewById(R.id.msgBack);
        msgBack.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent userIntent  = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(userIntent);
            }

        });*/

    }
}
