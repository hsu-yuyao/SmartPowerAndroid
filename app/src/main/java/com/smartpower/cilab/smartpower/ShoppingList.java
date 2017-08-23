package com.smartpower.cilab.smartpower;

import android.util.Log;

import com.smartpower.cilab.smartpower.RecyclerView.Item;

import java.util.ArrayList;

/**
 * Created by YuYao on 2017/8/23.
 */

public class ShoppingList {

    private static ArrayList<Item> shoppingList = new ArrayList<>();

    public static void addItem(Item item) {
        for(int i = 0; i< shoppingList.size(); i++) {
            Item haved = shoppingList.get(i);
            if( (haved.getItem()==item.getItem()) && (haved.getNo()==item.getNo()) ) {
                return;
            }
        }
        shoppingList.add(item);
    }

    public static void removeItem(Item item) {
        for(int i = 0; i< shoppingList.size(); i++) {
            Item haved = shoppingList.get(i);
            if( (haved.getItem()==item.getItem()) && (haved.getNo()==item.getNo()) ) {
                shoppingList.remove(i);
                return;
            }
        }

    }

    public static ArrayList<Item> getItemList() {
        return shoppingList;
    }

    public static void showList() {
        for(int i = 0; i< shoppingList.size(); i++) {
            Item list = shoppingList.get(i);
            Log.d("ShoppingList", "Item: " + list.getItem() + "-------No: " + list.getNo());
        }
    }




}


