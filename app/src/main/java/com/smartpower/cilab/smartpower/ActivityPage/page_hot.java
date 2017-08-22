package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.smartpower.cilab.smartpower.Item;
import com.smartpower.cilab.smartpower.ContactsAdapter;
import com.smartpower.cilab.smartpower.R;

public class page_hot extends AppCompatActivity {

    private ContactsAdapter adapter;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_hot);

        //  宣告 recyclerView
        rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        Item contact = new Item();
        adapter = new ContactsAdapter( contact.generateSampleList("getHotSale"));
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


    }
}
