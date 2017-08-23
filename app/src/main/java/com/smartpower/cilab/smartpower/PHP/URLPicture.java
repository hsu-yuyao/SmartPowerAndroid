package com.smartpower.cilab.smartpower.PHP;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by YuYao on 2017/8/22.
 */

public class URLPicture implements Runnable {

    private Bitmap image = null;
    private String imageName = "";


    public URLPicture(String imageName) {
        this.imageName = imageName;
    }
    private Bitmap getBitmapFromURL() {

        HttpURLConnection urlConnection = null;
        InputStream is  = null;

        try {
            URL url = new URL("http://140.115.51.178/smartPower/file/picture/" + this.imageName);
            urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            Log.d("URLPicture", "UrlConnect Successfully!!");
            InputStream input = urlConnection.getInputStream();
            Log.d("URLPicture", "Get Input Stream Successfully!!");
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            Log.d("URLPicture", "decodeStream Successfully!!");
            urlConnection.disconnect();

            return bitmap;

        } catch (Exception e) {
            Log.e("URLPicture", "get Bitmap From URL error: ");
            e.printStackTrace();
            return null;
        }
    }

    public Bitmap getImage() {
        return image;
    }

    @Override
    public void run() {
        image = getBitmapFromURL();
    }
}
