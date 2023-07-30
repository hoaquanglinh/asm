package com.example.assignment_ph43159;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ManHinhDangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);
        EditText dnusename = findViewById(R.id.dnusename);
        EditText dnpassword = findViewById(R.id.dnpassword);

        findViewById(R.id.btnlogin).setOnClickListener(v -> {

        });

        findViewById(R.id.btnsignup).setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangNhap.this, ManHinhDangKy.class);
            startActivity(intent);
        });
    }
}