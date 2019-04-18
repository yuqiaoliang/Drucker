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
import java.util.*;
import java.lang.*;

public class ViewPostActivity extends AppCompatActivity {
    final TextView titleDisplay = findViewById(R.id.titleDisplay);
    final ArrayList viewTitles = PostActivity.Titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        for (int i = 0; i < viewTitles.size(); i++)
            titleDisplay.setText(titleDisplay.getText() + viewTitles.get(i).toString() + " , ");

        }



    }
//}
