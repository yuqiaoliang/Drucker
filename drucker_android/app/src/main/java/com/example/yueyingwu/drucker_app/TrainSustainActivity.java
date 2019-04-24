package com.example.yueyingwu.drucker_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainSustainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_sustain);

        WebView sustainGuideView = (WebView)findViewById(R.id.SustainGuideView);
        //Log.i("Info","line20");
        sustainGuideView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        sustainGuideView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        sustainGuideView.loadUrl("https://drive.google.com/file/d/18iGcdDR7IpSGe0ofKiPk_xgYuBvVY5ZZ/view?usp=sharing");
    }
}
