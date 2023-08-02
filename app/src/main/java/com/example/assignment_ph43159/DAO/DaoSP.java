package com.example.assignment_ph43159.DAO;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.assignment_ph43159.DataBase.DBHelperSP;
import com.example.assignment_ph43159.Model.NguoiDung;
import com.example.assignment_ph43159.Model.SanPham;

import java.util.ArrayList;

public class DaoSP {
    Context context;
    DBHelperSP dbHelperSP;

    public DaoSP(Context context, DBHelperSP dbHelperSP) {
        this.context = context;
        this.dbHelperSP = dbHelperSP;
    }

    public ArrayList<SanPham> danhsach(){
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from sanphamm", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new SanPham(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getDouble(2),
                            cursor.getInt(3)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public ArrayList<NguoiDung> taikhoan(){
        ArrayList<NguoiDung> list = new ArrayList<>();
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from nguoidung", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    list.add(new NguoiDung(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3)
                    ));
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi", e);
        }
        return list;
    }

    public boolean themnd(NguoiDung nd){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tendangnhap", nd.getTaikhoan());
        contentValues.put("matkhau", nd.getMatkhau());

        long check = db.insert("nguoidung", null, contentValues);

        return check != 1;
    }

    public void xoasp(int id){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

//        long check = db.delete("sanphamm", "tensp = ? OR tensp IS NULL", new String[]{""});
        long check = db.delete("sanphamm", "id = ?", new String[]{String.valueOf(id)});
        if (check > 0){
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    public void themsp(SanPham sp){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("tensp", sp.getTensp());
        values.put("giasp", sp.getGiasp());
        values.put("soluong", sp.getSoluong());

        long check = db.insert("sanphamm", null, values);

        if (check > 0)
            Toast.makeText(context, "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Thêm thất bại",
                Toast.LENGTH_SHORT).show();
    }

    public void suasp(SanPham sp){
        SQLiteDatabase db = dbHelperSP.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("tensp", sp.getTensp());
        values.put("giasp", sp.getGiasp());
        values.put("soluong", sp.getSoluong());

        long check = db.update("sanphamm", values, "id = ?", new String[]{String.valueOf(sp.getId())});

        if (check > 0)
            Toast.makeText(context, "Sửa thành công",
                    Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Sửa thất bại",
                Toast.LENGTH_SHORT).show();
    }
}
