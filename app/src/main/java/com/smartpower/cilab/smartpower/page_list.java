package com.smartpower.cilab.smartpower;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class page_list extends AppCompatActivity {

    private ContactsAdapter adapter;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton back,qr;
    private ZXingScannerView zXingScannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_list);



        //  宣告 recyclerView
        rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new ContactsAdapter( Contact.generateSampleList());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
//        rvContacts.addItemDecoration(new DividerItemDecoration(this, Divider.VERTICAL_LIST));
//        mLayoutManager = new StaggeredGridLayoutManager((1), StaggeredGridLayoutManager.VERTICAL);
//        rvContacts.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
//        rvContacts.setItemAnimator(new DefaultItemAnimator());

//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, Divider.VERTICAL_LIST);
//        rvContacts.addItemDecoration(itemDecoration);









//        rvContacts.setLayoutManager(new GridLayoutManager(this, 3));


       /* back = (ImageButton) findViewById(R.id.BACK);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_list.this , MainActivity.class);
                startActivity(intent);
            }
        });

        qr = (ImageButton) findViewById(R.id.QR);

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_list.this , page_qr.class);
                startActivity(intent);

                zXingScannerView = new ZXingScannerView(getApplicationContext());
                setContentView(zXingScannerView);
                zXingScannerView.setResultHandler(this);
                zXingScannerView.startCamera();
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
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
        }*/

    }

}
