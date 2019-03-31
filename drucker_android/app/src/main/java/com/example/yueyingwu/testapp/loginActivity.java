package com.example.yueyingwu.testapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class loginActivity extends AppCompatActivity {
    //public static String isSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        final Button bLogin = findViewById(R.id.bLogin);
        final TextView registerLink = findViewById(R.id.tvRegisterHere);

        //connect registerLink to the register page
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(loginActivity.this, RegisterActivity.class);
                loginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info","Button press");
                final String username=etUsername.getText().toString();
                final String password=etPassword.getText().toString();
                if(username.matches("") || password.matches("")){
                    Toast.makeText(getApplicationContext(),"Username and password are required.",Toast.LENGTH_SHORT).show();
                }else {
                    requestLogin process = new requestLogin();
                    process.execute();
                }
            }
        });


    }

    private class requestLogin extends AsyncTask<Void,Void,Void> {
        private String data = "";
        private boolean isValid;
        private String username;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL("https://api.myjson.com/bins/myjwu");//successful
                //URL url = new URL("https://api.myjson.com/bins/8snfi");//fail
                HttpURLConnection response = (HttpURLConnection) url.openConnection();
                InputStream input = response.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                String line = "";
                while(line != null){
                    line = buffer.readLine();
                    data = data+line;
                }
                JSONObject validation = new JSONObject(data);
                username = validation.getString("username");
                isValid = validation.getBoolean("valid");
                //System.out.println(Boolean.toString(isValid));

                //Log.i("inParsing",dataParsed); //comment line38,43; uncomment line40,41,44 to check dataParsed
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(isValid){
                Log.i("Info", "log in successful");
                Intent intent = new Intent(loginActivity.this, UserActivity.class);
                intent.putExtra("username",username);
                loginActivity.this.startActivity(intent);

            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                builder.setMessage("Wrong username or password").setNegativeButton("Retry", null).create().show();
            }

        }
    }

}
