package com.example.yueyingwu.testapp;

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

public class PlumbingInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_input);

        final TextView display2 = findViewById(R.id.display2);

        final EditText etWaterCost = findViewById(R.id.etWaterCost);
        final EditText etTaxRate = findViewById(R.id.etTaxRate);
        final Spinner spinner3 = findViewById(R.id.spinner3);
        final Spinner spinner4 = findViewById(R.id.spinner4);
        final EditText etOldNumFixture = findViewById(R.id.etOldNumFixture);
        final EditText etNewNumFixture = findViewById(R.id.etNewNumFixture);

        final EditText etOldPrice = findViewById(R.id.etOldPrice);
        final EditText etNewPrice = findViewById(R.id.etNewPrice);
        final EditText etOldFlowRate = findViewById(R.id.etOldFlowRate);
        final EditText etNewFlowRate = findViewById(R.id.etNewFlowRate);
        final EditText etOldEstimatedHoursPerDay = findViewById(R.id.etOldEstimatedHoursPerDay);
        final EditText etNewEstimatedHoursPerDay = findViewById(R.id.etNewEstimatedHoursPerDay);
        final Button bSubmit = findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String waterCost = etWaterCost.getText().toString();
                final String taxRate = etTaxRate.getText().toString();
                final String spinnerOld3 = spinner3.getSelectedItem().toString();
                final String spinnerNew4 = spinner4.getSelectedItem().toString();
                final String oldNumFixture = etOldNumFixture.getText().toString();
                final String newNumFixture = etNewNumFixture.getText().toString();
                final String oldPrice = etOldPrice.getText().toString();
                final String newPrice = etNewPrice.getText().toString();
                final String oldFlowRate = etOldFlowRate.getText().toString();
                final String newFlowRate = etNewFlowRate.getText().toString();

                final String oldEstimatedHoursPerDay = etOldEstimatedHoursPerDay.getText().toString();
                final String newEstimatedHoursPerDay = etNewEstimatedHoursPerDay.getText().toString();


                display2.setText(spinnerOld3);
            }
        });

    }
}
