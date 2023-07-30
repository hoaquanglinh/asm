package com.example.assignment_ph43159;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ManHinhDangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ky);

        EditText dkusename = findViewById(R.id.dkusename);
        EditText dkpassword = findViewById(R.id.dkpassword);

        findViewById(R.id.btnsign_up).setOnClickListener(v -> {
            String tk = dkusename.getText().toString();
            String mk = dkpassword.getText().toString();

            if(tk.isEmpty()||mk.isEmpty()){
                Toast.makeText(ManHinhDangKy.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ManHinhDangKy.this, ManHinhDangNhap.class);

                Bundle bundle = new Bundle();

            }
        });
    }
}