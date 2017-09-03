package com.smartpower.cilab.smartpower.Beacon;

import android.util.Log;

import java.util.List;

import tw.org.iii.beaconcontentsdk.BeaconContent;
import tw.org.iii.beaconcontentsdk.json.push_message.Push_message;

/**
 * Created by YuYao on 2017/9/3.
 */

public class MessageResult {

    Push_message push_message;
    tw.org.iii.beaconcontentsdk.json.push_message.Result_content Result_content;
    List<tw.org.iii.beaconcontentsdk.json.push_message.Coupons> Coupons;
    List<tw.org.iii.beaconcontentsdk.json.push_message.Products> Products;
    List<tw.org.iii.beaconcontentsdk.json.push_message.Links> Links;
    List<tw.org.iii.beaconcontentsdk.json.push_message.Texts> Texts;

    private String TAG = "MessageResult";
    private int notifyID;
    private String messageType = "";

    public MessageResult(String server_ip, String app_key, String beaconUUID, int notifyID) {
        this.notifyID = notifyID;
        Log.d(TAG, "MessageResult: Here");
        BeaconContent BC = new BeaconContent(server_ip, app_key);
        push_message = BC.beaconContent(beaconUUID);

        Result_content = push_message.getResult_content();
        Log.e("receive_data_info", "getResource: " + String.valueOf(push_message.getResource()
                + "\ngetMethod: " + push_message.getMethod()
                + "\ngetError_msg: " + push_message.getError_msg()
                + "\ngetResult: " + push_message.getResult()
                + "\ngetResult_content: " + push_message.getResult_content()));

        Coupons = Result_content.getCoupons();
        Products = Result_content.getProducts();
        Links = Result_content.getLinks();
        Texts = Result_content.getTexts();

        if (Coupons != null) {
            Log.d(TAG, "Coupons.size(): " + Coupons.size());
            messageType = "Coupons";
        }
        if (Products != null) {
            Log.d(TAG, "Products.size(): " + Products.size());
            messageType = "Products";
        }
        if (Links != null) {
            Log.d(TAG, "Links.size(): " + Links.size());
            messageType = "Links";
        }
        if (Texts != null) {
            Log.d(TAG, "Texts.size(): " + Texts.size());
            messageType = "Texts";
        }
    }

    public int getNotifyID() {
        return notifyID;
    }

    public String getMessageType() {
        return messageType;
    }

    public tw.org.iii.beaconcontentsdk.json.push_message.Result_content getResult_content() {
        return Result_content;
    }

    public tw.org.iii.beaconcontentsdk.json.push_message.Coupons getCoupons() {

        return Coupons.get(Coupons.size()-1);
    }
    public tw.org.iii.beaconcontentsdk.json.push_message.Products getProducts() {
        return Products.get(Products.size()-1);
    }
    public tw.org.iii.beaconcontentsdk.json.push_message.Links getLinks() {
        return Links.get(Links.size()-1);
    }
    public tw.org.iii.beaconcontentsdk.json.push_message.Texts getTexts() {
        return Texts.get(Texts.size()-1);
    }
}
