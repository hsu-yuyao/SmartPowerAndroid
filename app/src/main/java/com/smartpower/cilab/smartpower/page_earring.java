package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class page_earring extends AppCompatActivity {
    private Earring_ContactsAdapter adapter;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_earring);

        rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new Earring_ContactsAdapter( Earring_Contact.generateSampleList());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));



    }
}
