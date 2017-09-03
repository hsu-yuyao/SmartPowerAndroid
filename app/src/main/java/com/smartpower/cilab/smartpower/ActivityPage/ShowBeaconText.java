package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.R;

public class ShowBeaconText extends AppCompatActivity {
    
    private TextView name, textcontent;
    private String TAG = "ShowBeaconText";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_beacon_text);

        Log.d(TAG, "onCreate: ");
        name = (TextView) findViewById(R.id.messageName);
        textcontent = (TextView) findViewById(R.id.meaageTextcontent);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("Name"));
        textcontent.setText(intent.getStringExtra("Textcontent"));




        
    }
}
