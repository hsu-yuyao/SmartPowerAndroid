package com.smartpower.cilab.smartpower;

import android.util.Log;

import com.smartpower.cilab.smartpower.PHP.JSONcode;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class Earring_Contact {
    private String name;
    private String price;

    public Earring_Contact() {
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
    public static List<Earring_Contact> generateSampleList(){

        JSONcode item = new JSONcode("getEarring");           //action :  getWatch, getEarring, getHotSale
        List<Earring_Contact> list = new ArrayList<>();
        int num = item.getItemData().size();
        Log.d("MainActivity", "ArrayList numbers: " + num);
        for(int i=0; i<num; i++) {
            try {
                Log.d("MainActivity", "Item: " + item.getItemData().get(i));
                Log.d("MainActivity", "Name: " + item.getItemData().get(i).getString("Name"));
                Log.d("MainActivity", "Price: " + item.getItemData().get(i).getString("Price"));
                Earring_Contact contact = new Earring_Contact();
                contact.setName(item.getItemData().get(i).getString("Name") );
                contact.setPrice("$ - "+item.getItemData().get(i).getString("Price"));
                list.add(contact);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        return list;
    }

}



