package com.example.assignment_ph43159;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_ph43159.DAO.DaoSP;
import com.example.assignment_ph43159.DataBase.DBHelperSP;
import com.example.assignment_ph43159.Model.NguoiDung;

public class ManHinhDangNhap extends AppCompatActivity {
    DBHelperSP dbHelperSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);
        EditText dnusername = findViewById(R.id.dnusename);
        EditText dnpassword = findViewById(R.id.dnpassword);

        dbHelperSP = new DBHelperSP(ManHinhDangNhap.this);

        findViewById(R.id.btnlogin).setOnClickListener(v -> {
            String taikhoan = dnusername.getText().toString();
            String matkhau = dnpassword.getText().toString();
            NguoiDung user = dbHelperSP.getUser(taikhoan, matkhau);
            if (user != null) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManHinhDangNhap.this, ManHinhChinh.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnsignup).setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangNhap.this, ManHinhDangKy.class);
            startActivity(intent);
        });
    }
}