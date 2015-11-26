package com.devenis.mycity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class Accommodation extends AppCompatActivity {
public static String result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list;
        String s=null;
        JsonTask js = new JsonTask();
        try {
            s =js.execute("http://51.255.40.20/accommodation/city").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] data={};
        try {
            JSONObject finalOject=new JSONObject(s);
            JSONArray city=finalOject.getJSONArray("cities");
            data=new String[city.length()];
            for (int i=0;i<city.length();i++){

                data[i]+=city.get(i);
                data[i]=data[i].replace("null","");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




        final String [] str = data;

        Integer[] imageId = {
                R.drawable.djerba,
                R.drawable.hamemt,
                R.drawable.tabarka,
                R.drawable.sfax,
                R.drawable.tozeur,

        };


        CustomAdapter adapter = new
                CustomAdapter(Accommodation.this, str, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                       ville_visiter.city=str[position];
                Intent i=new Intent(Accommodation.this,ville_visiter.class);
                startActivity(i);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
