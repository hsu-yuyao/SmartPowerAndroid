package com.smartpower.cilab.smartpower;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by YuYao on 2017/8/23.
 */

public class ImageProcessing {
    public Bitmap fixXY(Bitmap bm, int newSize) {

        /* 獲得圖片的寬高 */
        int width = bm.getWidth();
        int height = bm.getHeight();

        float reSize = (width>height)? ((float)newSize/width):((float)newSize/height);

        /* Don't zoom in */
        if(reSize > 1)
            reSize = 1;

        /* 取得想要縮放的matrix參數 */
        Matrix matrix = new Matrix();
        matrix.postScale(reSize, reSize);

        /* 得到新的圖片 */
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);

        return newbm;
    }

    public Bitmap scaleImg(Bitmap bm, int newWidth, int newHeight) {

        /* 獲得圖片的寬高 */
        int width = bm.getWidth();
        int height = bm.getHeight();

        /* 設置想要的大小 */
        int newWidth1 = newWidth;
        int newHeight1 = newHeight;

        /* 計算縮放比例 */
        float scaleWidth = ((float) newWidth1) / width;
        float scaleHeight = ((float) newHeight1) / height;

        /* 取得想要縮放的matrix參數 */
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        /* 得到新的圖片 */
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;


    }
}
