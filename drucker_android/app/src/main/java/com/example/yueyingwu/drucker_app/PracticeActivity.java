package com.example.yueyingwu.drucker_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
       // Log.i("Info","inPDFview");
        WebView guidepdfView = (WebView)findViewById(R.id.userguideView);
        //Log.i("Info","line20");
        guidepdfView.getSettings().setJavaScriptEnabled(true);
        //Log.i("Info","javascriptEnabled");
        guidepdfView.setWebViewClient(new WebViewClient());
        //Log.i("Info","setWebViewClient");
        guidepdfView.loadUrl("https://docs.google.com/document/d/1g8Dzz97gE_EouyIXxrbwPeYuhCPCkybnMfgRBcpl2Uw/edit?usp=sharing");
        //guidepdfView.loadUrl("https://drive.google.com/file/d/15d6uZYblFuQkoXR_3IeEofauZGxEVbeQ/view?usp=sharing");

    }
}
