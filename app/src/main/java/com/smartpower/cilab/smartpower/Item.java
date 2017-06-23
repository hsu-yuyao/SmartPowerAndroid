package com.smartpower.cilab.smartpower;
import java.io.Serializable;

/**
 * Created by edufor4g on 2017/6/22.
 */

public class Item implements Serializable {

    private long item;
    private String title;
    private String date;
    private int price;

    public Item(long item,String title,String date,int price){
        this.item=item;
        this.title=title;
        this.date=date;
        this.price=price;
    }

    public void setId(long id){
        this.item=id;
    }
    public long getId(){
        return this.item;
    }
    public void setTitle(String name){
        this.title=name;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDate(String number){
        this.date=number;
    }
    public String getDate(){
        return this.date;
    }
    public void setPrice(int cost){
        this.price=cost;
    }
    public int getPrice(){
        return this.price;
    }

}
