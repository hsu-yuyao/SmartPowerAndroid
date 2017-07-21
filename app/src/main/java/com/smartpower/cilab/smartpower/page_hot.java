package com.smartpower.cilab.smartpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class page_hot extends AppCompatActivity {

    private ContactsAdapter adapter;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_hot);

        rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new ContactsAdapter( Contact.generateSampleList());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


    }
}
