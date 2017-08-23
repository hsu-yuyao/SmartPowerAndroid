package com.smartpower.cilab.smartpower.RecyclerView;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.smartpower.cilab.smartpower.ImageProcessing;
import com.smartpower.cilab.smartpower.PHP.JSONcode;
import com.smartpower.cilab.smartpower.PHP.URLPicture;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class Item implements Parcelable{



    private int item;
    private int no;
    private String name;
    private int price;
    private Bitmap image;
    private String introduction;
    private int stock;
    private int counter;


    public Item() {

    }

    protected Item(Parcel in) {
        item = in.readInt();
        no = in.readInt();
        name = in.readString();
        price = in.readInt();
        image = in.readParcelable(Bitmap.class.getClassLoader());
        introduction = in.readString();
        stock = in.readInt();
        counter = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //    建表
    public List<Item> generateSampleList(String action){

        Log.d("Item", "action: " + action);
        JSONcode item = new JSONcode(action);           //action :  getWatch, getEarring, getHotSale
        ArrayList<Item> list = new ArrayList<>();
        int num = item.getItemData().size();
        for(int i=0; i<num; i++) {
            try {
                Item itemDetail = new Item();

                /* get item's detail */
                itemDetail.setItem(item.getItemData().get(i).getInt("Item"));
                itemDetail.setNo(item.getItemData().get(i).getInt("No"));
                itemDetail.setName(item.getItemData().get(i).getString("Name") );
                itemDetail.setPrice(item.getItemData().get(i).getInt("Price"));
                itemDetail.setIntroduction(item.getItemData().get(i).getString("Introduction"));
                itemDetail.setStock(item.getItemData().get(i).getInt("Stock"));
                itemDetail.setCounter(item.getItemData().get(i).getInt("Counter"));

                /* get item's image */
                URLPicture connect = new URLPicture(item.getItemData().get(i).getString("Image"));
                new Thread(connect).start();
                while(connect.getImage() == null);
                itemDetail.setImage(new ImageProcessing().fixXY(connect.getImage(), 400));

                Log.d("Item", "Get the " + itemDetail.getName()+ "\" data");
                list.add(itemDetail);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(item);
        dest.writeInt(no);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeParcelable(image, flags);
        dest.writeString(introduction);
        dest.writeInt(stock);
        dest.writeInt(counter);
    }
}



