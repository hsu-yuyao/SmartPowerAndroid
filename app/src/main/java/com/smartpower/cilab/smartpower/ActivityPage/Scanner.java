package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;
import com.smartpower.cilab.smartpower.ImageProcessing;
import com.smartpower.cilab.smartpower.PHP.JSONcode;
import com.smartpower.cilab.smartpower.PHP.URLPicture;
import com.smartpower.cilab.smartpower.RecyclerView.Item;
import com.smartpower.cilab.smartpower.ShoppingList;

import org.json.JSONArray;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    static final String SCAN_RESULT = "scan_result";
    static final String SCAN_FORMAT = "scan_format";

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this);
        mScannerView.setAutoFocus(true);

        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        try {
            String action = getActionCommand(result);

            if(!action.equals("")) {
                JSONcode jsoncode = new JSONcode(action);
                JSONObject itemObject = jsoncode.getItemData().get(0);

                Item item = objectToItem(itemObject);
                if(!item.equals(null) && item != null){
                    if(ShoppingList.addItem(item))
                        Toast.makeText(getApplicationContext(), item.getName() + " 加入購物車", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), item.getName() + " 已經在購物車", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(getApplicationContext(), "Error：00002", Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(getApplicationContext(), "請掃螢幕上的QRcode", Toast.LENGTH_SHORT).show();

        }catch(Exception e) {
            Log.e("JSONcode", e.toString());
            Log.e("JSONcode", "Get json error!");
            Toast.makeText(getApplicationContext(), "Error：00003", Toast.LENGTH_SHORT).show();
        }

        Intent returnIntent = new Intent();
        returnIntent.setClass(Scanner.this , ShoppingCart.class);
        returnIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(returnIntent);
    }

    private String getActionCommand(Result result) {
        try {
            JSONObject jsonObject = new JSONArray(result.getText()).getJSONObject(0);

            int item = jsonObject.getInt("Item");
            int no = jsonObject.getInt("No");

            Log.d("ShoppingCart", "Item: " + item);
            Log.d("ShoppingCart", "No: " + no);

            String action = "getItem&item=" + item + "&no=" + no;
            return action;

        }catch(Exception e){
            Log.e("ShoppingCart", "getActionCommand ERROR");
            return "";
        }

    }

    private Item objectToItem(JSONObject itemObject){
        try {
            Item item = new Item();

            /* get item's detail */
            item.setItem(itemObject.getInt("Item"));
            item.setNo(itemObject.getInt("No"));
            item.setName(itemObject.getString("Name") );
            item.setPrice(itemObject.getInt("Price"));
            item.setIntroduction(itemObject.getString("Introduction"));
            item.setStock(itemObject.getInt("Stock"));
            item.setCounter(itemObject.getInt("Counter"));

                /* get item's image */
            URLPicture connect = new URLPicture(itemObject.getString("Image"));
            new Thread(connect).start();
            while(connect.getImage() == null);
            item.setImage(new ImageProcessing().fixXY(connect.getImage(), 200));

            return item;
        } catch (Exception e) {

            return null;
        }
    }


}
