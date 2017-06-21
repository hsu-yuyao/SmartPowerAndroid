package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button watch,earring,list,hot,graph;
    private TextView letter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter = (TextView) findViewById(R.id.letter);
        watch = (Button) findViewById(R.id.watch);

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_watch.class);
                startActivity(intent);
            }
        });
        earring = (Button) findViewById(R.id.earring);

        earring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_earring.class);
                startActivity(intent);
            }
        });

        hot = (Button) findViewById(R.id.hot);

        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_hot.class);
                startActivity(intent);
            }
        });

        list = (Button) findViewById(R.id.list);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_list.class);
                startActivity(intent);
            }
        });

        graph = (Button) findViewById(R.id.watch);

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page_watch.class);
                startActivity(intent);
            }
        });



    }


}
