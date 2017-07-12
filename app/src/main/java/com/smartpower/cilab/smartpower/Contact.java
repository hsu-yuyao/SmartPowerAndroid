package com.smartpower.cilab.smartpower;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class Contact {
    private String name;
    private String price;

    public Contact() {
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
    public static List<Contact> generateSampleList(){
        List<Contact> list = new ArrayList<>();
        for(int i=0; i < 12; i++){
            Contact contact = new Contact();
            contact.setName(" Name - " + i );
            contact.setPrice("$1000");
            list.add(contact);
        }
        return list;
    }

}



