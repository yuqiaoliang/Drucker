package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    public void toMsgBox(View view){
        Intent msgIntent  = new Intent(getApplicationContext(),MessageBoxActivity.class);
        startActivity(msgIntent);
    }
    public void toPracticePage(View v){
        Intent pracPageIntent = new Intent(getApplicationContext(),PracticeActivity.class);
        startActivity(pracPageIntent);
    }
    public void toTraining(View v){
        Intent trainPageIntent = new Intent(getApplicationContext(),TrainingActivity.class);
        startActivity(trainPageIntent);
    }
    public void toDes(View v){
        Intent DesPageIntent = new Intent(getApplicationContext(),DesicionActivity.class);
        startActivity(DesPageIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etAge = findViewById(R.id.etAge);
        final TextView welcomeMessage = findViewById(R.id.tvWelcomeMsg);
        // create variables for each button
        final Button bMessageBox = findViewById(R.id.bMessageBox);
        final Button bPracticeGuide = findViewById(R.id.bPracticeGuide);
        final Button bTaining = findViewById(R.id.bTraining);
        final Button bDecision = findViewById(R.id.bDecision);


	/*	bMessageBox.setOnClickListener(new View.onClickListener() {

			public void onClick(View v){
				Intent msgIntent  = new Intent(getApplicationContext(),MessageBoxActivity.class);
				startActivity(msgIntent);
 
			}		
		});
		
		bPracticeGuide.setOnClickListener(new View.onClickListener(){

			public void onClick(View v){
				Intent pracPageIntent = new Intent(getApplicationContext(),PracticeActivity.class);
				startActivity(pracPageIntent);
			}			
		});*/

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String username=intent.getStringExtra("username");
        //int age =intent.getIntExtra("age",20);

        String message="Welcome to user area!";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        //etAge.setText(age+"");
        etAge.setText("Property Manager");


    }
}
