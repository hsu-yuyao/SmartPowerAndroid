package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.R;

import tw.org.iii.beaconcontentsdk.BeaconContent;
import tw.org.iii.beaconcontentsdk.OpenAlarm;
import tw.org.iii.beaconcontentsdk.json.push_message.Push_message;

//import com.smartpower.cilab.smartpower.MyService;

public class MainActivity extends AppCompatActivity {

    private ImageButton watch, earring, shoppingCart, hot;
    private TextView letter;
    private String TAG = "BeaconReceive";
//
    final private String server_ip = "iiibeacon.net";
    final private String app_key = "aa972f5d488cbb0c4c1316c939cb03de37a74d20";


    private Push_message push_message;
    private OpenAlarm openAlarm;
    private BeaconContent beaconContent;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, MyService.class);
//        this.startService(intent);

        /*-------------------beacon---------------*/
        openAlarm = new OpenAlarm(MainActivity.this);
        registerReceiver(broadcastReceiver, new IntentFilter("beaconDetect"));
        beaconContent = new BeaconContent(server_ip,app_key);

        openAlarm.getSdkData(server_ip, app_key, 5 * 1000);
        openAlarm.startSdkService();


        /*-------------------beacon---------------*/

        letter = (TextView) findViewById(R.id.title);

        watch = (ImageButton) findViewById(R.id.watch);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowWatch.class);
                startActivity(intent);
            }
        });

        earring = (ImageButton) findViewById(R.id.earring);
        earring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowEarring.class);
                startActivity(intent);
            }
        });

        hot = (ImageButton) findViewById(R.id.hotSale);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShowHotSale.class);
                startActivity(intent);
            }
        });

        shoppingCart = (ImageButton) findViewById(R.id.shoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("MainActivity", "shoppingCart");
//                final int notifyID = 1; // 通知的識別號碼
//                final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
//                final Notification notification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.flower).setContentTitle("內容標題").setContentText("內容文字").build(); // 建立通知
//                notificationManager.notify(notifyID, notification); // 發送通知

                Log.d("MainActivity", "change to ShoppingCart");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ShoppingCart.class);
                startActivity(intent);
            }
        });
    }

}
