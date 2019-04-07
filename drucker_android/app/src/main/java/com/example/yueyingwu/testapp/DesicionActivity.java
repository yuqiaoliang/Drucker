package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesicionActivity extends AppCompatActivity {


    public void toQuestionMark(View v) {
        Intent questionMarkIntent = new Intent(getApplicationContext(), QuestionMarkActivity.class);
        startActivity(questionMarkIntent);
    }
    public void toBulbInput(View v) {
        Intent bulbInputIntent = new Intent(getApplicationContext(), BulbInputActivity.class);
        startActivity(bulbInputIntent);
    }

    public void toPlumbingInput(View v) {
        Intent plumbingInputIntent = new Intent(getApplicationContext(), PlumbingInputActivity.class);
        startActivity(plumbingInputIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desicion);
        final Button bQuestionMark = findViewById(R.id.bQuestionMark);
        final Button bBulb = findViewById(R.id.bBulb);
        final Button bPlumbing = findViewById(R.id.bPlumbing);
    }
}
