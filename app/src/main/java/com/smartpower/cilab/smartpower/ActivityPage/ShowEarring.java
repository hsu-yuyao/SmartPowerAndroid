package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.smartpower.cilab.smartpower.RecyclerView.Item;
import com.smartpower.cilab.smartpower.RecyclerView.ContactsAdapter;
import com.smartpower.cilab.smartpower.R;

public class ShowEarring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earring);

        Log.d("Earring Page", "onCreate!!");

        //  宣告 recyclerView
        Item item = new Item();

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
        ContactsAdapter adapter = new ContactsAdapter( item.generateSampleList("getEarring"));
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
