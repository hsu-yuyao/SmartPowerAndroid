package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.Result;
import com.smartpower.cilab.smartpower.ImageProcessing;
import com.smartpower.cilab.smartpower.PHP.JSONcode;
import com.smartpower.cilab.smartpower.PHP.URLPicture;
import com.smartpower.cilab.smartpower.R;
import com.smartpower.cilab.smartpower.RecyclerView.ContactsAdapter;
import com.smartpower.cilab.smartpower.RecyclerView.Item;
import com.smartpower.cilab.smartpower.ShoppingList;

import org.json.JSONArray;
import org.json.JSONObject;

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
                Toast.makeText(getApplicationContext(), "Open Camera", Toast.LENGTH_SHORT).show();
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
//        zXingScannerView.stopCamera();

    }

    @Override
    public void handleResult(Result result) {
        try {
            JSONArray jsonArray = new JSONArray(result.getText());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            int item = jsonObject.getInt("Item");
            int no = jsonObject.getInt("No");

            Log.d("ShoppingCart", "Item: " + item);
            Log.d("ShoppingCart", "No: " + no);

            String action = "getItem&item=" + item + "&no=" + no;
            JSONcode jsoNcode = new JSONcode(action);
            JSONObject jsonObject1 = jsoNcode.getItemData().get(0);

            Item itemDetail = new Item();

            /* get item's detail */
            itemDetail.setItem(jsonObject1.getInt("Item"));
            itemDetail.setNo(jsonObject1.getInt("No"));
            itemDetail.setName(jsonObject1.getString("Name") );
            itemDetail.setPrice(jsonObject1.getInt("Price"));
            itemDetail.setIntroduction(jsonObject1.getString("Introduction"));
            itemDetail.setStock(jsonObject1.getInt("Stock"));
            itemDetail.setCounter(jsonObject1.getInt("Counter"));

                /* get item's image */
            URLPicture connect = new URLPicture(jsonObject1.getString("Image"));
            new Thread(connect).start();
            while(connect.getImage() == null);
            itemDetail.setImage(new ImageProcessing().fixXY(connect.getImage(), 200));

            ShoppingList.addItem(itemDetail);
//            zXingScannerView.resumeCameraPreview(this);
            startActivity(getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        }catch(Exception e) {
            Log.e("JSONcode", "Get json error!");
            Log.e("JSONcode", e.toString());
            startActivity(getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }


//        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
//        Log.d("result", "handleResult: " + result.getText());
//        zXingScannerView.resumeCameraPreview(this);
//        onBackPressed();
    }
}
