package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.R;
import com.smartpower.cilab.smartpower.RecyclerView.Item;
import com.smartpower.cilab.smartpower.ShoppingList;

public class ItemDetail extends AppCompatActivity {

    private ImageView imageView;
    private TextView itemName, information;
    private ImageButton shoppingCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Log.d("ItemDetail", "onCreate");

        Bundle test = this.getIntent().getExtras();
        final Item item = test.getParcelable("Information");

        Log.d("ItemDetail", "Get the item information");

        itemName = (TextView) findViewById(R.id.itemName);
        imageView = (ImageView) findViewById(R.id.imageView);
        information = (TextView) findViewById(R.id.information);

        itemName.setText(item.getName());
        imageView.setImageBitmap(item.getImage());
        information.setText(item.getIntroduction());
        Log.d("ItemDetail", "Success set text of item!!");

        shoppingCart = (ImageButton) findViewById(R.id.shoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingList.addItem(item);
                ShoppingList.showList();
            }
        });


    }
}
