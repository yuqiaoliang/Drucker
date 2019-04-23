package com.example.yueyingwu.testapp;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DecimalFormat;

public class TestNewCommentActivity extends AppCompatActivity {
   //private Button button;
   //public TextView tvNewCommentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_new_comment);

        final Button button = (Button) findViewById(R.id.bNewComment);
        final TextView tvNewCommentView = findViewById(R.id.tvNewCommentView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestNewCommentActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.new_comment_dialog, null);
                final EditText etNewComment = (EditText)mView.findViewById(R.id.etNewComment);
                /**
                Button bPostComment = (Button)mView.findViewById(R.id.bPostComment);
               /bPostComment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvNewCommentView.setText(etNewComment.getText().toString());
                    }
                });
                //openDialog();
                **/
                builder.setView(mView)
                        .setTitle("New Comment")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Post Comment", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvNewCommentView.setText(etNewComment.getText().toString());
                                //Here you add new comment to ArrayList
                                //CommentArraylist.add(etNewComment);
                            }
                        })
                ;
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

}
