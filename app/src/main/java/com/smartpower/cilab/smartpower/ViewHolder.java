package com.smartpower.cilab.smartpower;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YuYao on 2017/8/22.
 */
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //        private View itemView;
    public TextView nameTextView, priceTextView;
    public TextView itemText;
    //        private int clickPosition;
    public ImageView itemImage;

    private List<Item> itemList;

    public ViewHolder(View itemView, List<Item> itemList){
        super(itemView);
        this.itemList = itemList;

        itemText = (TextView) itemView.findViewById(R.id.itemText);
        itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("!!!!!!!!!!!!!!!!!!!!!", "onClick: " + itemList.get(getAdapterPosition()).getName() );
    }
}
