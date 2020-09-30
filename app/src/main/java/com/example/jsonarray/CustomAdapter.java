package com.example.jsonarray;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArray;


    public CustomAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
         return jsonArray.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        }
        TextView Formula= (TextView) view.findViewById(R.id.txtFormula);
        TextView URL= (TextView) view.findViewById(R.id.txtURL);

        try {
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            Formula.setText(jsonObject.getString("formula"));
            URL.setText(jsonObject.getString("url"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }

}