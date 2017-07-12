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

import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>  {

    private static LayoutInflater mLayoutInflater;
    private static Context context;
    private String[] mTitles;

    public static class ViewHolder extends RecyclerView.ViewHolder{
//        private View itemView;
        public TextView nameTextView, priceTextView;
        public ViewHolder(View itemView){
            super(itemView);
//            this.itemView = itemView;
            nameTextView = (TextView) itemView.findViewById(R.id.tv_name);
            priceTextView = (TextView) itemView.findViewById(R.id.tv_price);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
//                }
//            });
        }
    }
//拿表
    private List<Contact> mContacts;

    public ContactsAdapter(List<Contact> contacts){
        mContacts = contacts;
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
//        nameTextView.setText(contact.getName());


    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
