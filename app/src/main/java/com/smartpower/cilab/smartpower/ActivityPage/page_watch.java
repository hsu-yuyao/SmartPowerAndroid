package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;

import com.smartpower.cilab.smartpower.Item;
import com.smartpower.cilab.smartpower.ContactsAdapter;
import com.smartpower.cilab.smartpower.R;

public class page_watch extends AppCompatActivity {
//    private ContactsAdapter adapter;
//    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_watch);

        Log.d("Watch Page", "onCreate!!");

        //  宣告 recyclerView
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        Item item = new Item();
        ContactsAdapter adapter = new ContactsAdapter( item.generateSampleList("getWatch"));
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));



    }
}
