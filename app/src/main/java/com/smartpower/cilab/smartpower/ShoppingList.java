package com.smartpower.cilab.smartpower;

import android.util.Log;

import com.smartpower.cilab.smartpower.RecyclerView.Item;

import java.util.ArrayList;

/**
 * Created by YuYao on 2017/8/23.
 */

public class ShoppingList {

    public static ArrayList<Item> shopping = new ArrayList<>();

    public static void showList() {
        for(int i=0; i<shopping.size(); i++) {
            Item list = shopping.get(i);
            Log.d("ShoppingList", "Item: " + list.getItem() + "-------No: " + list.getNo());
        }
    }




}


