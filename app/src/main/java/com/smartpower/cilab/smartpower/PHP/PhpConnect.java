package com.smartpower.cilab.smartpower.PHP;

/**
 * Created by YuYao on 2017/7/12.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PHPConnect implements Runnable {

    private String result = "";
    private String action;

    public PHPConnect(String action) {
        this.action = action;
    }

    private String executeQuery() {
        String result = "";
        HttpURLConnection urlConnection=null;
        InputStream is =null;
        try {
            URL url = new URL("http://140.115.51.178/smartPower/?action="+this.action);                  //php的位置
            urlConnection=(HttpURLConnection) url.openConnection();                                 //對資料庫打開連結
            is=urlConnection.getInputStream();                                                      //從database 開啟 stream

            Log.d("PHPConnect", "executeQuert: URL connect success!!");

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
            StringBuilder builder = new StringBuilder();
            String line = null;

            while((line = bufReader.readLine()) != null) {
                builder.append(line + "\n");
            }

            Log.d("PHPConnect", "executeQuery: Finish readLine!!");

            is.close();
            result = builder.toString();

            Log.d("PHPConnect", "executeQuery: Finish!!");

        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }

        return result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public void run() {
        result = executeQuery();

    }
}
