package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton watch, earring, shoppingCart, hot;
    private TextView letter;
    public int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter = (TextView) findViewById(R.id.title);

        watch = (ImageButton) findViewById(R.id.watch);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowWatch.class);
                startActivity(intent);
            }
        });

        earring = (ImageButton) findViewById(R.id.earring);
        earring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowEarring.class);
                startActivity(intent);
            }
        });

        hot = (ImageButton) findViewById(R.id.hotSale);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowHotSale.class);
                startActivity(intent);
            }
        });

        shoppingCart = (ImageButton) findViewById(R.id.shoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "change to ShoppingCart");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShoppingCart.class);
                startActivity(intent);
            }
        });
    }


}
