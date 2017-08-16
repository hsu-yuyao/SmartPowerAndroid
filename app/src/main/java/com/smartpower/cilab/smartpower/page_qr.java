package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class page_qr extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    public static TextView result;
    private Button scan_btn;
    private ZXingScannerView zXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_qr);

//        back = (ImageButton) findViewById(R.id.BACK);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(page_qr.this , page_list.class);
//                startActivity(intent);
//            }
//        });
        result = (TextView) findViewById(R.id.textView);
        scan_btn = (Button) findViewById(R.id.QR);

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent.setClass(page_qr.this , QR_activity.class);
//                    startActivity(intent);

//                zXingScannerView = new ZXingScannerView(getApplicationContext());
//                setContentView(zXingScannerView);
//                zXingScannerView.setResultHandler(this);
//                zXingScannerView.startCamera();
                scan(v);
            }
        });
        }
    public void scan(View view) {
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();

    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();

    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(),result.getText(), Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
    }
}

