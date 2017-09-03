package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BeaconProduct extends AppCompatActivity {

    private TextView name, description;
    private ImageView image;
    private String photoURL;
    private Bitmap bmp = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon_product);

        name = (TextView) findViewById(R.id.productName);
        description = (TextView) findViewById(R.id.productDescription);
        image = (ImageView) findViewById(R.id.productImage);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("SellerName"));
        description.setText(intent.getStringExtra("Description"));


        photoURL = intent.getStringExtra("PhotoUrl");

        new Thread(new Runnable() {
            @Override
            public void run() {
                getImage(photoURL);
            }
        }).start();
        while(bmp == null);
        image.setImageBitmap(bmp);


    }

    private void getImage(String photoURL) {
        HttpURLConnection urlConnection = null;
        InputStream is  = null;
        try {
            URL url = new URL(photoURL);
            urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();

            Log.d("URLPicture", "UrlConnect Successfully!!");
            InputStream input = urlConnection.getInputStream();
            Log.d("URLPicture", input.toString());
            Log.d("URLPicture", "Get Input Stream Successfully!!");
            bmp = BitmapFactory.decodeStream(input);
            Log.d("URLPicture", "decodeStream Successfully!!");
            urlConnection.disconnect();

        } catch (Exception e) {
            Log.e("URLPicture", "get Bitmap From URL error: ");
            e.printStackTrace();
            return;
        }
    }
}
