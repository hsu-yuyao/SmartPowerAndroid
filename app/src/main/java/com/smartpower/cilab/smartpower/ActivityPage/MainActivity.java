package com.smartpower.cilab.smartpower.ActivityPage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
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
import com.smartpower.cilab.smartpower.Beacon.BeaconList;
import com.smartpower.cilab.smartpower.Beacon.MessageResult;
import com.smartpower.cilab.smartpower.Beacon.NearBeacon;
import com.smartpower.cilab.smartpower.R;
import tw.org.iii.beaconcontentsdk.BeaconContent;
import tw.org.iii.beaconcontentsdk.OpenAlarm;
import tw.org.iii.beaconcontentsdk.json.push_message.Push_message;

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
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();
            final String beaconID = bundle.getString("id");
            final String beaconUUID = bundle.getString("uuid");

            if(beaconID!=null) {

                Log.d("BroadcastReciver", "catch the beacon");
                Log.d("BroadcastReciver", "Beacon ID: " + beaconID );

                if(!BeaconList.nearBeaconsList.contains(beaconID)){

                    Log.d("BroadcastReciver", "Add beacon");

                    final NearBeacon beacon = new NearBeacon(beaconID, beaconUUID);

                    BeaconList.nearBeaconsList.add(beaconID);
                    BeaconList.nearBeacons.add(beacon);

                    Log.d("MainActivity", "shoppingCart");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            String TAG = "runOnUiThread";
                            MessageResult message = new MessageResult(server_ip, app_key, beaconUUID, BeaconList.nearBeaconsList.size());

                            final String messageType = message.getMessageType();
                            final tw.org.iii.beaconcontentsdk.json.push_message.Result_content Result_content = message.getResult_content();


                            /* notify information */
                            final int notifyID = message.getNotifyID(); // 通知的識別號碼
                            final int requestCode = notifyID; // PendingIntent的Request Code
                            final Intent intent = new Intent(); // 目前Activity的Intent
                            switch (messageType) {
                                case "Products":
                                    intent.setClass(MainActivity.this, ShoppingCart.class);
                                    break;
                                case "Texts":
                                    intent.setClass(MainActivity.this, ShowBeaconText.class);
                                    intent.putExtra("Name", message.getTexts().getName());
                                    intent.putExtra("Textcontent", message.getTexts().getTextcontent());
                                    Log.d(TAG, "Text's Name: " + message.getTexts().getName());
                                    Log.d(TAG, "Text's Textcontent: " + message.getTexts().getTextcontent());
                                    break;
                                default:
                                    intent.setClass(MainActivity.this, MainActivity.class);
                                    break;
                            }


                            final int flags = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                            final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestCode, intent, flags); // 取得PendingIntent
                            final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                            final Notification notification =
                                    new Notification.Builder(getApplicationContext())
                                            .setSmallIcon(R.drawable.icon)
                                            .setContentTitle(beaconID)
                                            .setContentText(beaconUUID)
                                            .setContentIntent(pendingIntent)
                                            .setAutoCancel(true).build(); // 建立通知
                            notificationManager.notify(notifyID, notification); // 發送通知
                        }
                    });


                }
            }else {
                Log.d("BroadcastReciver", "No scan successfully");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, RESULT_OK);
        }

            /*----------------Start scanning beacon---------------*/
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
