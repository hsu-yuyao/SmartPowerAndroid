package com.smartpower.cilab.smartpower.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartpower.cilab.smartpower.ActivityPage.ItemDetail;
import com.smartpower.cilab.smartpower.R;

import java.util.List;

/**
 * Created by YuYao on 2017/8/22.
 */
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView itemText;
    public ImageView itemImage;
    private View itemView;

    private List<Item> itemList;

    public ViewHolder(View itemView, List<Item> itemList){
        super(itemView);
        this.itemList = itemList;
        this.itemView = itemView;
        itemText = (TextView) itemView.findViewById(R.id.itemText);
        itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("!!!!!!!!!!!!!!!!!!!!!", "onClick: " + itemList.get(getAdapterPosition()).getName() );

        /* item selected and get item's information */
        Item selectedItem = itemList.get(getAdapterPosition());
        Log.d("ViewHolder", "get itemView: " + itemView.getContext().getClass().getSimpleName());
        Intent intent = new Intent(itemView.getContext(), ItemDetail.class);

        /* can translate object like class "Item" */
        Bundle bundle = new Bundle();
        bundle.putParcelable("Information", selectedItem);
        bundle.putString("ClassName", itemView.getContext().getClass().getSimpleName().toString());
        intent.putExtras(bundle);

        /* change activity */
        itemView.getContext().startActivity(intent);
    }
}
