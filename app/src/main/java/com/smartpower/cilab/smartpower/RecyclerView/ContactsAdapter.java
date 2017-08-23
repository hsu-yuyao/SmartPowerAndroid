package com.smartpower.cilab.smartpower.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartpower.cilab.smartpower.ImageProcessing;
import com.smartpower.cilab.smartpower.R;

import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<Item> itemList;

    public ContactsAdapter(List<Item> itemList){
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView, itemList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemText.setText("商品：" + item.getName() + "\n價錢：$" + item.getPrice());

        try {
            Log.d("ContactsAdapter", "try to get the picture");
            holder.itemImage.setImageBitmap(new ImageProcessing().fixXY(item.getImage(), 80));
            Log.d("ContactsAdapter", "try to get the picture. Successfully!!");
        }catch (Exception e) {
            Log.d("ContactsAdapter", "try to get the no-image.");
            Bitmap bmp = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.no_image);
            holder.itemImage.setImageBitmap(new ImageProcessing().fixXY(bmp, 80));
            Log.d("ContactsAdapter", "try to get the no-image. Successfully!!");
        }

//        holder.itemImage.setImageBitmap(item.getImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
