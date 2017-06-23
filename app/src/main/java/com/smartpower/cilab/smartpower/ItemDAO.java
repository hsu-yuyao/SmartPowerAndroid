package com.smartpower.cilab.smartpower;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by edufor4g on 2017/6/22.
 */

public class ItemDAO {

    public static final String TABLE_NAME = "table";

    public static final String ITEM = "Item";
    public static final String DATE = "date";
    public static final String NO = "title";
    public static final String PRICE = "price";
    public static final String PHOTO = "photo";
    public static final String MODEL = "model";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            ITEM + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " INTEGER NOT NULL, "
            + NO + " TEXT NOT NULL, " + PRICE + " INTEGER " + PHOTO + "2D MODELS, " + MODEL
            + "3D MODELS)";

    private SQLiteDatabase DB;

    /*public ItemDAO(Context context) {
        DB = MyDBHelper.getDatabase(context);
    }*/

    public void close() {
        DB.close();
    }

    public Item insert(Item item) {

        ContentValues cv = new ContentValues();

        cv.put(DATE, item.getDate());
        cv.put(NO, item.getTitle());
        cv.put(PRICE, item.getPrice());

        long id = DB.insert(TABLE_NAME, null, cv);

        item.setId(id);

        return item;

    }

    public boolean update(Item item) {

        ContentValues cv = new ContentValues();

        cv.put(DATE, item.getDate());
        cv.put(NO, item.getTitle());
        cv.put(PRICE, item.getPrice());

        String where = ITEM + "=" + item.getId();

        return DB.update(TABLE_NAME, cv, where, null) > 0;

    }

    public boolean delete(long id) {
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = ITEM + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return DB.delete(TABLE_NAME, where , null) > 0;
    }

    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        Cursor cursor = DB.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        /*while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }*/

        cursor.close();
        return result;
    }



}
