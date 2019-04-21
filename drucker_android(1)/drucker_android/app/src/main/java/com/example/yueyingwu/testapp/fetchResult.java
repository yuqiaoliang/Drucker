package com.example.yueyingwu.testapp;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchResult {
    String destURL;
    String method;

    private String result = "";
    private String hasError;
    private boolean success;

    public fetchResult(String destURL, String method){
        this.destURL = destURL;
        this.method = method;
        try {
            URL url = new URL(destURL);//successful
            HttpURLConnection response = (HttpURLConnection) url.openConnection();
            response.setRequestMethod(method);

            InputStream input = response.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while(line != null){
                line = buffer.readLine();
                result= result+line;
            }
        }  catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*
   private class fetchHelper extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... params) {
            try{
                URL url = new URL(destURL);
                HttpURLConnection response = null;
                try{
                    response = (HttpURLConnection) url.openConnection();
                    response.setRequestMethod(method);
                    response.setUseCaches(false);

                    int code = response.getResponseCode();

                    Log.i("error code:", String.valueOf(code));

                    if(code<400){
                        //on success, update result and success
                        InputStream input = response.getInputStream();
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                        String line = "";
                        while((line = buffer.readLine()) != null){
                            //line = buffer.readLine();
                            result = result+line;
                        }
                        buffer.close();
                        Log.i("result: ", result);
                        success = true;
                        return null;
                    }

                    else{
                        //http request fail, write hsaError message
                        InputStream input = response.getInputStream();
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                        String line = "";
                        String data = "";
                        while((line = buffer.readLine()) != null){
                            //line = buffer.readLine();
                            hasError = hasError+line;
                        }

                        Log.i("error: ", hasError);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } finally {
                    if(response != null){
                        response.disconnect();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
*/

    public String getResult() {
        return result;
    }

    public String getHasError() {
        return hasError;
    }

    public boolean isSuccess() {
        return success;
    }
}
