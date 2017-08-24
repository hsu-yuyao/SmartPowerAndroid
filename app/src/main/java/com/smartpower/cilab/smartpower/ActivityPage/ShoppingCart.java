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

import com.smartpower.cilab.smartpower.R;
import com.smartpower.cilab.smartpower.RecyclerView.ContactsAdapter;
import com.smartpower.cilab.smartpower.ShoppingList;

public class ShoppingCart extends AppCompatActivity {


    private ImageButton scanButton;

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
                Intent intent = new Intent(ShoppingCart.this, Scanner.class);
                startActivityForResult(intent, 1);
            }
        });

        /* 宣告 recyclerView */
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        ContactsAdapter adapter = new ContactsAdapter(ShoppingList.getItemList());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}
