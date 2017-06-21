package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page_list extends AppCompatActivity {

    private Button back,qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_list);

        back = (Button) findViewById(R.id.BACK);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_list.this , MainActivity.class);
                startActivity(intent);
            }
        });

        qr = (Button) findViewById(R.id.QR);

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_list.this , page_qr.class);
                startActivity(intent);
            }
        });

    }
}
