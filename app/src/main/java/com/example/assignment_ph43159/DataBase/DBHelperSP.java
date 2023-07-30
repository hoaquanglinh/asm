package com.example.assignment_ph43159.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperSP extends SQLiteOpenHelper {
    private Context context;

    public DBHelperSP(Context context){
        super(context, "sanphamm", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sanphamm(id integer  primary key autoincrement, tensp text, giasp real, soluong real)");
        db.execSQL("insert into sanphamm values(1, 'Bánh quy bơ LU Pháp', 45000, 10),"
                                            + "(2, 'Snack mực lăn muối ớt', 8000, 52),"
                                            + "(3, 'Bánh gạo One One', 30000, 11),"
                                            + "(4, 'Kẹo sửa sô cô la', 25000, 30)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
