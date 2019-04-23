package com.example.yueyingwu.testapp;

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

public class TestNewCommentActivity extends AppCompatActivity implements NewCommentDialog.CommentDialogListener {
   private Button button;
   public TextView tvNewCommentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_new_comment);
       // Button button;
        //TextView tvNewCommentView;
        button = (Button) findViewById(R.id.bNewComment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }
    public void openDialog(){
        NewCommentDialog newCommentDialog = new NewCommentDialog();
        newCommentDialog.show(getSupportFragmentManager(), "New Comment Dialog");

    }

    @Override
    public void applyTexts(String newComment) {
        tvNewCommentView.setText(newComment);
    }
}
