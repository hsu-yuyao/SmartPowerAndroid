package com.smartpower.cilab.smartpower.ActivityPage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.ImageProcessing;
import com.smartpower.cilab.smartpower.R;

public class ItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.no_image);
        ImageView backgound = (ImageView) findViewById(R.id.image);

        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        Log.d("ItemDetail", "screen size: " + screenSize.x + " " + screenSize.y);
        backgound.setImageBitmap(new ImageProcessing().scaleImg(bmp, screenSize.x, screenSize.x));

        TextView information = (TextView) findViewById(R.id.information);
        information.setText("Tessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;sTessdfsdfjkla;sdjfkl;asdjfkl;asdfjkl;asdfjkla;sdfjkla;sdjfkla;sdjfkla;sdjfkjweifjlwsejifjeifjoejfioejfOSDjfk;s");

    }
}
