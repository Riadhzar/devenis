package com.devenis.mycity;

/**
 * Created by riadhzar on 22/11/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.widget.Toast.*;

/**
 * Created by riadhzar on 22/11/2015.
 */
public class JsonTask extends AsyncTask<String,String, String> {
    static String result="";


    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuffer buffer=new StringBuffer();

        try {
            URL url=new URL(params[0]);
            connection=(HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream stream=connection.getInputStream();
            reader=new BufferedReader(new InputStreamReader(stream));
            String line="";
            while ((line=reader.readLine())!=null){
                buffer.append(line);
            }

// parsi w testi
            // mettre les données dans list



            return buffer.toString();

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                
                connection.disconnect();
            }

            try {
                if(reader!=null){
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Accommodation.result = s;



    }
}
