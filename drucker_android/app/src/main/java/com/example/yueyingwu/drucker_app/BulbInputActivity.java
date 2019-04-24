package com.example.yueyingwu.drucker_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class BulbInputActivity extends AppCompatActivity {
    static String elecRate;
    static String taxRate;
    static String minReturn;
    static String spinnerOld;
    static String spinnerNew;
    static String oldNumBulb;
    static String newNumBulb;
    static String oldPrice;
    static String newPrice;
    static String oldWattage;
    static String newWattage;
    static String oldLumens;
    static String newLumens;
    static String oldLifespan;
    static String newLifespan;
    static String oldHoursWeekday;
    static String newHoursWeekday;
    static String oldHoursWeekend;
    static String newHoursWeekend;
    static String rebates;

    static Double escaltingRate = 0.0;
    static Double npv = 0.0;
    static Double irr = 0.0;
    static Double simplyPaybackPeriod = 0.0;

    static TextView display;

    public void toPlumbingInput(View v) {
        Intent plumbingInputIntent = new Intent(getApplicationContext(), PlumbingInputActivity.class);
        startActivity(plumbingInputIntent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { //do something
            Intent BulbbackToUserUI = new Intent(getApplicationContext(), DesicionActivity.class);
            BulbInputActivity.this.startActivity(BulbbackToUserUI);
        }
//        } else if (keyCode == KeyEvent.KEYCODE_MENU) {//do something
//        } else if (keyCode == KeyEvent.KEYCODE_HOME) {//no return result
//        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_input);

        display = findViewById(R.id.display);
        final ImageButton iBquestion = findViewById(R.id.iBquestion);
        iBquestion.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manualIntent = new Intent(getApplicationContext(), TrainLightActivity.class);
                startActivity(manualIntent);
            }
        });


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
        final EditText etRebates = findViewById(R.id.etRebate);

        etElecRate.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);


        final Button bMoreBulb = findViewById(R.id.bMoreBulb);
        final Button bPlumb = findViewById(R.id.bPlumb);
        final Button bClearBulb = findViewById(R.id.bClearBulb);

        bClearBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etElecRate.getText().clear();
                etTaxRate.getText().clear();
                etMinReturn.getText().clear();
                etOldNumBulb.getText().clear();
                etNewNumBulb.getText().clear();
                etOldPrice.getText().clear();
                etNewPrice.getText().clear();
                etOldWattage.getText().clear();
                etNewWattage.getText().clear();
                etOldLumens.getText().clear();
                etNewLumens.getText().clear();
                etOldLifespan.getText().clear();
                etNewLifespan.getText().clear();
                etOldHoursWeekday.getText().clear();
                etNewHoursWeekday.getText().clear();
                etOldHoursWeekend.getText().clear();
                etNewHoursWeekend.getText().clear();
                etRebates.getText().clear();
            }
        });


        bMoreBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 DecimalFormat df=new DecimalFormat("#.###");
//                 if((escaltingRate!=0 )&&(npv!=0)&&(irr!=0)&&(simplyPaybackPeriod!=0)){
//                     display.setText("Escalting Rate="+df.format(escaltingRate)+"\n"+"NPV="+df.format(npv)+"\n"+"IRR="+df.format(irr)+"\n"+"Simple Payback period (year)="+df.format(simplyPaybackPeriod));
//                 }

                elecRate = etElecRate.getText().toString();
                taxRate = etTaxRate.getText().toString();
                minReturn = etMinReturn.getText().toString();
                spinnerOld = spinner1.getSelectedItem().toString();
                spinnerNew = spinner2.getSelectedItem().toString();
                oldNumBulb = etOldNumBulb.getText().toString();
                newNumBulb = etNewNumBulb.getText().toString();
                oldPrice = etOldPrice.getText().toString();
                newPrice = etNewPrice.getText().toString();
                oldWattage = etOldWattage.getText().toString();
                newWattage = etNewWattage.getText().toString();
                oldLumens = etOldLumens.getText().toString();
                newLumens = etNewLumens.getText().toString();
                oldLifespan = etOldLifespan.getText().toString();
                newLifespan = etNewLifespan.getText().toString();
                oldHoursWeekday = etOldHoursWeekday.getText().toString();
                newHoursWeekday = etNewHoursWeekday.getText().toString();
                oldHoursWeekend = etOldHoursWeekend.getText().toString();
                newHoursWeekend = etNewHoursWeekend.getText().toString();
                rebates = etRebates.getText().toString();

                if (spinnerOld.equals("Edison Base")) {
                    spinnerOld = "Edison+Base";
                }
                if (spinnerOld.equals("4 Pins")) {
                    spinnerOld = "4+Pins";
                }
                if (spinnerOld.equals("2 Pins")) {
                    spinnerOld = "2+Pins";
                }
                if (spinnerNew.equals("Edison Base")) {
                    spinnerNew = "Edison+Base";
                }
                if (spinnerNew.equals("4 Pins")) {
                    spinnerNew = "4+Pins";
                }
                if (spinnerNew.equals("2 Pins")) {
                    spinnerNew = "2+Pins";
                }
                System.out.println(taxRate);
                if (spinnerNew.matches("") || spinnerOld.matches("") || taxRate.matches("") || elecRate.matches("") || minReturn.matches("") || rebates.matches("") ||
                        oldNumBulb.matches("") || newNumBulb.matches("") || oldPrice.matches("") || newPrice.matches("") || oldWattage.matches("") || newWattage.matches("") ||
                        oldLifespan.matches("") || newLifespan.matches("") || oldLumens.matches("") || newLumens.matches("") ||
                        oldHoursWeekday.matches("") || newHoursWeekday.matches("") || oldHoursWeekend.matches("") || newHoursWeekend.matches("")) {
                    System.out.println(Boolean.toString(newNumBulb.matches("")));
                    AlertDialog.Builder builder = new AlertDialog.Builder(BulbInputActivity.this);
                    builder.setMessage("Need to finish the whole table").setNegativeButton("Continue", null).create().show();
                } else {
                    System.out.println("Connect to Server");
                    bulbToServer connect = new bulbToServer();
                    connect.execute();
                }

//                display.setText(spinnerOld);
            }
        });
    }

    private class bulbToServer extends AsyncTask<Void, Void, Void> {
        private String receivedData = "";

        @Override
        protected Void doInBackground(Void... voids) {
//            String sendURL="http://10.197.189.82:8080/lightModul?x1="+elecRate+"&x2="+taxRate+"&x3="+minReturn+"&s1="+spinnerOld+"&s2="+spinnerNew+"&x4="+oldNumBulb+"&x11="+newNumBulb+"&x5="+oldPrice+"&x12="+newPrice+"&x6="+oldWattage+"&x13="+newWattage+"&x7="+oldLumens+"&x14="+newLumens+"&x8="+oldLifespan+"&x15="+newLifespan+"&x9="+oldHoursWeekday+"&x16="+newHoursWeekday+"&x10="+oldHoursWeekend+"&x17="+newHoursWeekend+"&x18="+rebates;
            String sendURL = "http://192.168.1.9:8080/lightModul?x1=" + elecRate + "&x2=" + taxRate + "&x3=" + minReturn + "&s1=" + spinnerOld + "&s2=" + spinnerNew + "&x4=" + oldNumBulb + "&x11=" + newNumBulb + "&x5=" + oldPrice + "&x12=" + newPrice + "&x6=" + oldWattage + "&x13=" + newWattage + "&x7=" + oldLumens + "&x14=" + newLumens + "&x8=" + oldLifespan + "&x15=" + newLifespan + "&x9=" + oldHoursWeekday + "&x16=" + newHoursWeekday + "&x10=" + oldHoursWeekend + "&x17=" + newHoursWeekend + "&x18=" + rebates;

            String method = "GET";
            fetchResult lightingCall = new fetchResult(sendURL, method);
            receivedData = lightingCall.getResult();
            try {
                JSONObject receivedString = new JSONObject(receivedData);
                escaltingRate = receivedString.getDouble("escaltingRate");
                npv = receivedString.getDouble("npv");
                irr = receivedString.getDouble("irr");
                simplyPaybackPeriod = receivedString.getDouble("simplyPaybackPeriod");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
//            try {
//                URL url=new URL(sendURL);
//                try {
//                    HttpURLConnection response=(HttpURLConnection) url.openConnection();
//                    InputStream input = response.getInputStream();
//                    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
//                    String line = "";
//                    while(line != null){
//                        line = buffer.readLine();
//                        receivedData = receivedData+line;
//                    }
//                    try {
//                        JSONObject receivedString=new JSONObject(receivedData);
//                        escaltingRate+=receivedString.getDouble("escaltingRate");
//                        npv+=receivedString.getDouble("npv");
//                        irr+=receivedString.getDouble("irr");
//                        simplyPaybackPeriod+=receivedString.getDouble("simplyPaybackPeriod");
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            DecimalFormat df = new DecimalFormat("#.###");
            if ((escaltingRate != 0) && (npv != 0) && (irr != 0) && (simplyPaybackPeriod != 0)) {
                display.setText("\n" + "Escalting Rate=" + df.format(escaltingRate) + "\n" + "NPV=" + df.format(npv) + "\n" + "IRR=" + df.format(irr) + "\n" + "Simple Payback period (year)=" + df.format(simplyPaybackPeriod));
            }
//            display.setText("Escalting Rate: "+String.format("%.3f",Double.toString(escaltingRate))+"\n"+"NPV"+String.format("%.3f",Double.toString(npv))+"\n"+"IRR"+String.format("%.3f",Double.toString(irr))+"\n"+"Simple Payback period (year)"+String.format("%.3f",Double.toString(simplyPaybackPeriod)+"\n"));
        }
    }

}
