package com.example.yueyingwu.testapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TrainingActivity extends AppCompatActivity {
    boolean  flag1=false;
    boolean  flag2=false;
    String pdfName[]=new String[] {"Sustainability Guide","Landscaping Guide"};
    Integer picID[]=new Integer[] {R.drawable.sustainability,R.drawable.landscaping};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        final Button bQuiz=findViewById(R.id.btQuiz);

        ListView listview=findViewById(R.id.lv);
        customListview customlistview = new customListview(this,pdfName,picID);
        listview.setAdapter(customlistview);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pdfName);
//        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    flag1=true;
                    Intent trainSustainIntent  = new Intent(getApplicationContext(),TrainSustainActivity.class);
                    startActivity(trainSustainIntent);
                }
                if(position==1){
                    flag2=true;
                    Intent trainPoolIntent  = new Intent(getApplicationContext(),TrainPoolActivity.class);
                    startActivity(trainPoolIntent);
                }
            }
        });

        bQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1&&flag2) {
                    Intent quizIntent  = new Intent(getApplicationContext(),TrainQuizActivity.class);
                    startActivity(quizIntent);
                }else{
                    AlertDialog.Builder prompt1=new AlertDialog.Builder(TrainingActivity.this);
                    prompt1.setMessage("You should finish reading all pdf files").setNegativeButton("Keep Training", null).create().show();
                }
            }
        });
    }
}
