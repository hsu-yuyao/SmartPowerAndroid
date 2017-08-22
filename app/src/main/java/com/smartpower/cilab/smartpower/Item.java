package com.smartpower.cilab.smartpower;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;

import com.smartpower.cilab.smartpower.PHP.JSONcode;
import com.smartpower.cilab.smartpower.PHP.URLPicture;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class Item {


    private String no;
    private String name;
    private String price;
    private Bitmap image;
    private String introduction;
    private String stock;
    private String counter;


    public Item() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    建表
    public List<Item> generateSampleList(String action){

        Log.d("Item", "action: " + action);
        JSONcode item = new JSONcode(action);           //action :  getWatch, getEarring, getHotSale
        List<Item> list = new ArrayList<>();
        int num = item.getItemData().size();
        for(int i=0; i<num; i++) {
            try {
//                Log.d("MainActivity", "Item: " + item.getItemData().get(i));
//                Log.d("MainActivity", "Name: " + item.getItemData().get(i).getString("Name"));
//                Log.d("MainActivity", "Price: " + item.getItemData().get(i).getString("Price"));
                Item itemDetail = new Item();

                /* get item's detail */
                itemDetail.setNo(item.getItemData().get(i).getString("No"));
                itemDetail.setName(item.getItemData().get(i).getString("Name") );
                itemDetail.setPrice(item.getItemData().get(i).getString("Price"));
                itemDetail.setIntroduction(item.getItemData().get(i).getString("Introduction"));
                itemDetail.setStock(item.getItemData().get(i).getString("Stock"));
                itemDetail.setCounter(item.getItemData().get(i).getString("Counter"));

                /* get item's image */
                URLPicture connect = new URLPicture(item.getItemData().get(i).getString("Image"));
                new Thread(connect).start();
                while(connect.getImage() == null);
                itemDetail.setImage(connect.getImage());

                list.add(itemDetail);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    protected Bitmap scaleImg(Bitmap bm, int newSize) {

        /* 獲得圖片的寬高 */
        int width = bm.getWidth();
        int height = bm.getHeight();

        float reSize = (width>height)? (((float)newSize)/width):(((float)newSize)/height);

        /* Don't zoom in */
        if(reSize > 1)
            reSize = 1;

        Log.d("Item-scaleImg", "reSize rate: " + reSize);

//        /* 取得想要縮放的matrix參數 */
        Matrix matrix = new Matrix();
        matrix.postScale(reSize, reSize);

// 得到新的圖片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }



}



