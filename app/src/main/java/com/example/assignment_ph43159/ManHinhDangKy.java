package com.example.assignment_ph43159;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_ph43159.DAO.DaoSP;
import com.example.assignment_ph43159.DataBase.DBHelperSP;
import com.example.assignment_ph43159.Model.NguoiDung;

import java.util.ArrayList;

public class ManHinhDangKy extends AppCompatActivity {
    DaoSP daoSP;
    ArrayList<NguoiDung> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ky);

        EditText dkusename = findViewById(R.id.dkusename);
        EditText dkpassword = findViewById(R.id.dkpassword);

        findViewById(R.id.btnback).setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangKy.this, ManHinhDangNhap.class);
            startActivity(intent);
        });

        findViewById(R.id.btnsign_up).setOnClickListener(v -> {
            String tk = dkusename.getText().toString();
            String mk = dkpassword.getText().toString();
            NguoiDung nd = new NguoiDung(tk, mk);

            if(tk.isEmpty()||mk.isEmpty()){
                Toast.makeText(ManHinhDangKy.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
            }else{
                daoSP = new DaoSP(ManHinhDangKy.this, new DBHelperSP(ManHinhDangKy.this));
                if (daoSP.themnd(nd)){
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.clear();
                    list.addAll(daoSP.taikhoan());
                    Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ManHinhDangKy.this, ManHinhDangNhap.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}