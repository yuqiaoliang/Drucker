package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BulbInputActivity extends AppCompatActivity {
    public void toPlumbingInput(View v) {
        Intent plumbingInputIntent = new Intent(getApplicationContext(), PlumbingInputActivity.class);
        startActivity(plumbingInputIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_input);

        final TextView display = findViewById(R.id.display);


        final EditText etElecRate = findViewById(R.id.etElecRate);
        final EditText etTaxRate = findViewById(R.id.etTaxRate);
        final EditText etMinReturn = findViewById(R.id.etMinReturn);
        final Spinner spinner1 = findViewById(R.id.spinner1);
        final Spinner spinner2 = findViewById(R.id.spinner2);
        final EditText etOldNumBulb = findViewById(R.id.etOldNumBulb);
        final EditText etNewNumBulb = findViewById(R.id.etNewNumBulb);
        final EditText etOldPrice = findViewById(R.id.etOldPrice);
        final EditText etNewPrice = findViewById(R.id.etNewPrice);
        final EditText etOldWattage = findViewById(R.id.etOldWattage);
        final EditText etNewWattage = findViewById(R.id.etNewWattage);
        final EditText etOldLumens = findViewById(R.id.etOldLumens);
        final EditText etNewLumens = findViewById(R.id.etNewLumens);
        final EditText etOldLifespan = findViewById(R.id.etOldLifespan);
        final EditText etNewLifespan = findViewById(R.id.etNewLifespan);
        final EditText etOldHoursWeekday = findViewById(R.id.etOldHoursWeekday);
        final EditText etNewHoursWeekday = findViewById(R.id.etNewHoursWeekday);
        final EditText etOldHoursWeekend = findViewById(R.id.etOldHoursWeekend);
        final EditText etNewHoursWeekend = findViewById(R.id.etNewHoursWeekend);


        final Button bMoreBulb = findViewById(R.id.bMoreBulb);
        final Button bPlumb = findViewById(R.id.bPlumb);


        bMoreBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String elecRate = etElecRate.getText().toString();
                final String taxRate = etTaxRate.getText().toString();
                final String minReturn = etMinReturn.getText().toString();
                final String spinnerOld = spinner1.getSelectedItem().toString();
                final String spinnerNew = spinner2.getSelectedItem().toString();
                final String oldNumBulb = etOldNumBulb.getText().toString();
                final String newNumBulb = etNewNumBulb.getText().toString();
                final String oldPrice = etOldPrice.getText().toString();
                final String newPrice = etNewPrice.getText().toString();
                final String oldWattage = etOldWattage.getText().toString();
                final String newWattage = etNewWattage.getText().toString();
                final String oldLumens = etOldLumens.getText().toString();
                final String newLumens = etNewLumens.getText().toString();
                final String oldLifespan = etOldLifespan.getText().toString();
                final String newLifespan = etNewLifespan.getText().toString();
                final String oldHoursWeekday = etOldHoursWeekday.getText().toString();
                final String newHoursWeekday = etNewHoursWeekday.getText().toString();
                final String oldHoursWeekend = etOldHoursWeekend.getText().toString();
                final String newHoursWeekend = etNewHoursWeekend.getText().toString();


                display.setText(spinnerOld);
            }
        });
    }

}
