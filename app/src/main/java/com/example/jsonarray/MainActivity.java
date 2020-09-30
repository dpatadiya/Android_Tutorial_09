package com.example.jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    CustomAdapter adapter;
    ListView lstdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstdata= (ListView) findViewById(R.id.lstdata);
        adapter=new CustomAdapter(this,generateData());
        lstdata.setAdapter(adapter);
    }

    private JSONArray generateData() {
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();
        try {
            InputStream is=getAssets().open("data.json");
            int size=0;
            size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            String json=new String(buffer,"UTF-8");
            Log.i("json",json);
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("formulas");
        }
        catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return jsonArray;
    }
}