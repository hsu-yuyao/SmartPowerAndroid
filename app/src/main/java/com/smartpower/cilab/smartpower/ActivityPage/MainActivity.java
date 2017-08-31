package com.smartpower.cilab.smartpower.ActivityPage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.MyService;
import com.smartpower.cilab.smartpower.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton watch, earring, shoppingCart, hot;
    private TextView letter;

    private MyService.MyBinder myBinder;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {
            myBinder = (MyService.MyBinder) binder;
            myBinder.startDownload();
        }
        @Override
        public void onServiceDisconnected(ComponentName className) {
            Log.e("Service Connection", "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MyService.class);
        this.startService(intent);



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

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = new Intent(this, MyService.class);
        this.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    public void onPause() {
        super.onPause();
        this.unbindService(mServiceConnection);
    }
}
