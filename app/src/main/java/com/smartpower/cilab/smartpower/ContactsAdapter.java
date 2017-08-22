package com.smartpower.cilab.smartpower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edufor4g on 2017/6/28.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<Item> itemList;

    public ContactsAdapter(List<Item> itemList){
        this.itemList = itemList;
    }
    protected Bitmap scaleImg(Bitmap bm, int newSize) {

        /* 獲得圖片的寬高 */
        int width = bm.getWidth();
        int height = bm.getHeight();

        float reSize = (width>height)? ((float)newSize/width):((float)newSize/height);

        /* Don't zoom in */
        if(reSize > 1)
            reSize = 1;

        Log.d("Item-scaleImg", "reSize rate: " + reSize);



        /* 取得想要縮放的matrix參數 */
        Matrix matrix = new Matrix();
        matrix.postScale(reSize, reSize);

        /* 得到新的圖片 */
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);

        return newbm;
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

        holder.itemImage.setImageBitmap(scaleImg(item.getImage(), 80));
//        holder.itemImage.setImageBitmap(item.getImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
