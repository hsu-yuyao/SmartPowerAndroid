package com.smartpower.cilab.smartpower;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private View view;
    public TextView nameTextView, priceTextView,txt_description;
    private ItemClickListener itemClickListener;
    public ViewHolder(View itemView){
        super(itemView);
//            this.itemView = itemView;
        nameTextView = (TextView) itemView.findViewById(R.id.tv_name);
        priceTextView = (TextView) itemView.findViewById(R.id.tv_price);
        itemView.setOnClickListener(this);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
//                }
//            });
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }


}

public class ContactsAdapter extends RecyclerView.Adapter<ViewHolder>  {


    private static Context context;



//拿表
    public List<Contact> mContacts;

    public ContactsAdapter(List<Contact> contacts){
        mContacts = contacts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View contactView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.nameTextView.setText(contact.getName());
        holder.priceTextView.setText(contact.getPrice());
        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Log.d("Tag","Value");
                Toast.makeText(context, "item click: "+mContacts, Toast.LENGTH_SHORT).show();
            }

        });
//        nameTextView.setText(contact.getName());


    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
