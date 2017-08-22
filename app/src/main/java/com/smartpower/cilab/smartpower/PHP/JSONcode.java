package com.smartpower.cilab.smartpower.PHP;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by YuYao on 2017/7/19.
 */

public class JSONcode {


    private ArrayList<JSONObject> itemData = new ArrayList<>();

    public JSONcode(String action) {

//      get information of item from database
        PHPConnect connect = new PHPConnect(action);
        Log.d("Thread", "start");
        new Thread(connect).start();
        Log.d("PHP", "Get php data.");
        while(connect.getResult() == "");           // wait thread
        JsonGenerator(connect.getResult());
    }


    private void JsonGenerator(String result) {
        try {
            JSONArray data = new JSONArray(result);

            Log.d("Test", "jsonArray.length(): " + data.length());
            for(int i = 0; i < data.length(); i++) {
                itemData.add(data.getJSONObject(i));
            }

        }catch(Exception e) {
            Log.e("JSONcode", "Get json error!");
            Log.e("JSONcode", e.toString());
        }
    }

    public ArrayList<JSONObject> getItemData() {
        return itemData;
    }

}
