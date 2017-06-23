package com.smartpower.cilab.smartpower;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by edufor4g on 2017/6/22.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    // 資料庫名稱
    public static final String DATABASE_NAME = "mydata.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 1;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;


    public static final String TABLE_NAME = "table";
    private final static String ROW_ID = "rowId";
    public static final String ITEM = "Item";
    public static final String DATE = "date";
    public static final String NO = "NO. ";
    public static final String PRICE = "price";
    public static final String PHOTO = "photo";
    public static final String MODEL = "model";

    // 建構子，在一般的應用都不需要修改
    public MyDBHelper(Context context) {
        /*MyDBHelper(Context context, String name, CursorFactory factory,
                      int version);*/
        super(context, DATABASE_NAME, null, VERSION);
    }

    // 需要資料庫的元件呼叫這個方法，這個方法在一般的應用都不需要修改
    /*public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new MyDBHelper(context, DATABASE_NAME, null, VERSION).getWritableDatabase();
        }

        return database;
    }*/

    public void insterInfo(SQLiteDatabase db, String item, String date, String no, String price) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM, item);
        contentValues.put(DATE, date);
        contentValues.put(NO,no);
        contentValues.put(PRICE,price);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public void updateInfo(SQLiteDatabase db, String rowId, String item, String date, String no, String price) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM, item);
        contentValues.put(DATE, date);
        contentValues.put(NO,no);
        contentValues.put(PRICE,price);

        //問號對應到後面陣列的資料

        db.update(TABLE_NAME, contentValues, ROW_ID + "=?", new String[] {rowId});
    }

    public void removeInfo(SQLiteDatabase db, String rowId) {
        db.delete(TABLE_NAME, ROW_ID + "=?", new String[]{rowId});
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 建立應用程式需要的表格
        final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                ITEM + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " INTEGER NOT NULL, "
                + NO + " TEXT NOT NULL, " + PRICE + " INTEGER " + PHOTO + "2D MODELS, " + MODEL
                + "3D MODELS)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // 刪除原有的表格
        if (newVersion > oldVersion) {

            sqLiteDatabase.beginTransaction();

            if (oldVersion == 1) {
                try {
                    // 新增一個日期欄位，預設為NULL字串

                    sqLiteDatabase
                            .execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN "
                                    + DATE + " TEXT DEFAULT "
                                    + "NULL");

                    Log.d("SQLite", "版本更新成功!");
                    sqLiteDatabase.setTransactionSuccessful();
                    sqLiteDatabase.endTransaction();

                } catch (Exception e) {
                    Log.d("SQLite", "版本更新失敗!");
                    sqLiteDatabase.endTransaction();
                }
            } else {
                // 呼叫onCreate建立新版的表格
                onCreate(sqLiteDatabase);
            }
        }
    }
}