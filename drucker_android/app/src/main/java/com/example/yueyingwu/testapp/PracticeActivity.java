package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

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
        guidepdfView.loadUrl("https://drive.google.com/file/d/18iGcdDR7IpSGe0ofKiPk_xgYuBvVY5ZZ/view?usp=sharing");
        //guidepdfView.loadUrl("https://drive.google.com/file/d/15d6uZYblFuQkoXR_3IeEofauZGxEVbeQ/view?usp=sharing");
		
      /*  final Button pracBack = findViewById(R.id.pracBack);
        pracBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent userIntent  = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(userIntent);
            }

        });*/
    }
}
