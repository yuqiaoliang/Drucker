package com.example.yueyingwu.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_quiz);

        WebView quizView = (WebView)findViewById(R.id.QuizView);
        //Log.i("Info","line20");
        quizView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        quizView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        quizView.loadUrl("https://www.wenjuan.in/s/vEJ7Ffu/");
    }
}
