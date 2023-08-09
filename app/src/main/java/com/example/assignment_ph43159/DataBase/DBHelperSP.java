package com.example.assignment_ph43159.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assignment_ph43159.Model.NguoiDung;

public class DBHelperSP extends SQLiteOpenHelper {
    private Context context;

    public DBHelperSP(Context context){
        super(context, "QLSPND", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table nguoidung(id integer primary key autoincrement, tendangnhap text, matkhau text, hoten text)");
        db.execSQL("insert into nguoidung values(1, 'admin', 'admin', 'Hoà Quang Linh')");
        db.execSQL("create table sanphamm(id integer  primary key autoincrement, tensp text, giasp real, soluong real)");
        db.execSQL("insert into sanphamm values(1, 'Bánh quy bơ LU Pháp', 45000, 10),"
                                            + "(2, 'Snack mực lăn muối ớt', 8000, 52),"
                                            + "(3, 'Bánh gạo One One', 30000, 11),"
                                            + "(4, 'Kẹo sửa sô cô la', 25000, 30)");
    }

    public NguoiDung getUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("nguoidung", null, "tendangnhap=? AND matkhau=?", new String[]{username, password}, null, null, null);
        NguoiDung user = null;

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                user = new NguoiDung(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return user;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
