package com.devenis.mycity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class ville_visiter extends AppCompatActivity {
    static String city ;
    final String id_adress="address";
    final  String id_type="type";
    final String id_link="link";
    final String id_name ="name";
    final String id_website="website";
    final  String id_availability="availability";
    final String id_long="long" ;
    final  String id_lat="lat" ;
    final String id_phone ="contact" ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ville_visiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        String s=null;
        JsonTask js = new JsonTask();
        try {
            s =js.execute("http://51.255.40.20/accommodation/"+city).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String data="";
        try {
            JSONObject finalOject=new JSONObject(s);
            JSONArray city=finalOject.getJSONArray("accommodation");


            for (int i=0;i<city.length();i++){
                JSONObject jsonObject = city.getJSONObject(i);
                String adresse=jsonObject.optString(id_adress).toString();
                String City=jsonObject.optString("city").toString();
                String name=jsonObject.optString(id_name).toString();
                String Type=jsonObject.optString(id_type).toString();
             String availibility=jsonObject.optString(id_adress).toString();
                String contact=jsonObject.optString(id_phone).toString();
                String website=jsonObject.optString(id_website).toString();
                String id=jsonObject.optString("id").toString();
                data+=id_adress+":"+adresse+"\n"+"City"+City+"\n"+id_name+":"+name+"\n"+id_type+":"+Type+"\n"+availibility+":"+id_availability+"\n"+id_phone+":"+contact+"\n"+id_website+":"+website+"\n"+"id"+":"+id;







            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textView=(TextView)findViewById(R.id.riadh);
        textView.setText(data);









    }

}
