package com.example.yueyingwu.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainPoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_pool);

        WebView poolGuideView = (WebView)findViewById(R.id.PoolGuideView);
        //Log.i("Info","line20");
        poolGuideView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        poolGuideView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        poolGuideView.loadUrl("https://drive.google.com/file/d/11o4j2eP2jU6Oa6YDSBS8tJVn4ELuAn4A/view?usp=sharing");
    }
}
