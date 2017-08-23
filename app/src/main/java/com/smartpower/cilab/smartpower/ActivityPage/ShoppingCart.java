package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.Result;
import com.smartpower.cilab.smartpower.R;
import com.smartpower.cilab.smartpower.RecyclerView.ContactsAdapter;
import com.smartpower.cilab.smartpower.ShoppingList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ShoppingCart extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ImageButton scanButton;
    private ZXingScannerView zXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Log.d("shopping list page", "onCreate!!");
        scanButton = (ImageButton) findViewById(R.id.scan);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan(v);
            }
        });

        /* 宣告 recyclerView */
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        ContactsAdapter adapter = new ContactsAdapter(ShoppingList.getItemList());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

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
        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
        Log.d("result", "handleResult: " + result.getText());
        zXingScannerView.resumeCameraPreview(this);
        onBackPressed();
    }
}
