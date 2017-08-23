package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartpower.cilab.smartpower.R;
import com.smartpower.cilab.smartpower.RecyclerView.Item;
import com.smartpower.cilab.smartpower.ShoppingList;

public class ItemDetail extends AppCompatActivity {

    private ImageView imageView;
    private TextView itemName, information;
    private ImageButton shoppingCart;
    private String className;
    private Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Log.d("ItemDetail", "onCreate");

        Bundle bundle = this.getIntent().getExtras();
        this.item = bundle.getParcelable("Information");
        this.className = bundle.getString("ClassName");
        
        Log.d("ItemDetail", "Get the item information");

        itemName = (TextView) findViewById(R.id.itemName);
        imageView = (ImageView) findViewById(R.id.imageView);
        information = (TextView) findViewById(R.id.information);

        itemName.setText(item.getName());
        imageView.setImageBitmap(item.getImage());
        information.setText(item.getIntroduction());
        Log.d("ItemDetail", "Success set text of item!!");

        shoppingCart = (ImageButton) findViewById(R.id.shoppingCart);

        Log.d("ItemDetail", "onCreate: " + className);
        if(className.equals("ShoppingCart")) {
            Log.d("sdfsdfsdfsdfsdf", "onCreate: ");
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.delete_shopping);
            shoppingCart.setImageBitmap(bmp);
        }

        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!className.equals("ShoppingCart")) {
                    Toast.makeText(getApplicationContext(), "加入購物車", Toast.LENGTH_SHORT).show();
                    ShoppingList.addItem(item);
                    ShoppingList.showList();
                }else {
                    Toast.makeText(getApplicationContext(), "取消購物", Toast.LENGTH_SHORT).show();
                    ShoppingList.removeItem(item);
                    ShoppingList.showList();


                    /* change activity*/
                    Intent intent = new Intent();
                    intent.setClass(ItemDetail.this , ShoppingCart.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

            }
        });


    }
}
