package com.smartpower.cilab.smartpower.ActivityPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;

import com.smartpower.cilab.smartpower.ContactsAdapter;
import com.smartpower.cilab.smartpower.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class page_shoppingList extends AppCompatActivity {

    private ContactsAdapter adapter;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton back,qr;
    private ZXingScannerView zXingScannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_list);

        Log.d("shopping list page", "onCreate!!");

        //  宣告 recyclerView
//        rvContacts = (RecyclerView) findViewById(R.id.recyclerview);
//        adapter = new ContactsAdapter( Item.generateSampleList("getHotSale"));
//        rvContacts.setAdapter(adapter);
//        rvContacts.setLayoutManager(new LinearLayoutManager(this));


//        rvContacts.addItemDecoration(new DividerItemDecoration(this, Divider.VERTICAL_LIST));
//        mLayoutManager = new StaggeredGridLayoutManager((1), StaggeredGridLayoutManager.VERTICAL);
//        rvContacts.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
//        rvContacts.setItemAnimator(new DefaultItemAnimator());

//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, Divider.VERTICAL_LIST);
//        rvContacts.addItemDecoration(itemDecoration);









//        rvContacts.setLayoutManager(new GridLayoutManager(this, 3));


       /* back = (ImageButton) findViewById(R.id.BACK);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_shoppingList.this , MainActivity.class);
                startActivity(intent);
            }
        });

        qr = (ImageButton) findViewById(R.id.QR);

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page_shoppingList.this , page_qr.class);
                startActivity(intent);

                zXingScannerView = new ZXingScannerView(getApplicationContext());
                setContentView(zXingScannerView);
                zXingScannerView.setResultHandler(this);
                zXingScannerView.startCamera();
            }
        });

    }
    public void scan(View view) {
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();

    }



   @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();

    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
        }*/

    }

}
