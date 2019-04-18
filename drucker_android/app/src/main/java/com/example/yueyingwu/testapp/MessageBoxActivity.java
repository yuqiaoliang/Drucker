package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MessageBoxActivity extends AppCompatActivity {

  //     public void toPost(View v) {
   //   Intent postIntent = new Intent(getApplicationContext(), PostActivity.class);
   //    startActivity(postIntent);
  // }
      //public void toComment(View v) {
      // Intent commentIntent = new Intent(getApplicationContext(), CommentActivity.class);
      // startActivity(commentIntent);
 //  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_box);


        final ImageButton iBPost=findViewById(R.id.iBPost);
        final ImageButton iBComment=findViewById(R.id.iBComment);

        iBPost.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(getApplicationContext(), PostActivity.class);
                startActivity(postIntent);
            }
        });
        iBComment.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentIntent = new Intent(getApplicationContext(), CommentActivity.class);
                startActivity(commentIntent);
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
