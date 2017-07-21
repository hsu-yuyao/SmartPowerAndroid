package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.PHP.JSONcode;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private ImageButton watch,earring,list,hot,graph;
    private TextView letter;
    public int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter = (TextView) findViewById(R.id.letter);
        watch = (ImageButton) findViewById(R.id.watch);

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JSONcode item = new JSONcode("getWatch");
//                num = item.getItemData().size();
//                Log.d("MainActivity", "ArrayList numbers: " + num);
//                for(int i=0; i<num; i++) {
//                    try {
//                        Log.d("MainActivity", "Item: " + item.getItemData().get(i));
//                        Log.d("MainActivity", "Name: " + item.getItemData().get(i).getString("Name"));
//                        Log.d("MainActivity", "Price: " + item.getItemData().get(i).getString("Price"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }

                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_watch.class);
                startActivity(intent);
            }
        });

        earring = (ImageButton) findViewById(R.id.earring);
        //earring.setImageResource(R.drawable.earRing);

        earring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JSONcode item = new JSONcode("getEarring");
//                Log.d("MainActivity", "ArrayList numbers: " + item.getItemData().size());
//                for(int i=0; i<item.getItemData().size(); i++) {
//                    try {
//                        Log.d("MainActivity", "Item: " + item.getItemData().get(i));
//                        Log.d("MainActivity", "Item: " + item.getItemData().get(i).getString("Price"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_earring.class);
                startActivity(intent);
            }
        });

        hot = (ImageButton) findViewById(R.id.hot);

        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_hot.class);
                startActivity(intent);
            }
        });

        list = (ImageButton) findViewById(R.id.list);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JSONcode item = new JSONcode("getList");
//                Log.d("MainActivity", "ArrayList numbers: " + item.getItemData().size());
//                for(int i=0; i<item.getItemData().size(); i++) {
//                    try {
//                        Log.d("MainActivity", "Name: " + item.getItemData().get(i));
//                        Log.d("MainActivity", "Item: " + item.getItemData().get(i).getString("Price"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }

                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_list.class);
                startActivity(intent);
            }
        });

        graph = (ImageButton) findViewById(R.id.graph);

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_graph.class);
                startActivity(intent);
            }
        });



    }


}
