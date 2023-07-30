package com.example.assignment_ph43159;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class ManHinhChinh extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                ManHinhChinh.this, drawerLayout, toolbar,
                R.string.open,
                R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.quanlysp){
                    fragment = new ManHinhQLSP();
                }else if(item.getItemId()== R.id.gioithieu){
                    fragment = new ManHinhGioiThieu();
                }else if(item.getItemId()== R.id.caidat){
                    fragment = new ManHinhCaiDat();
                }else{
                    Intent intent = new Intent(ManHinhChinh.this, ManHinhDangNhap.class);
                    startActivity(intent);
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit();
                drawerLayout.close();
                return true;
            }
        });
    }
}