package com.example.assignment_ph43159.Adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_ph43159.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tensp, giasp, soluong;
    Button sua, xoa;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tensp = itemView.findViewById(R.id.tensp);
        giasp = itemView.findViewById(R.id.giasp);
        soluong = itemView.findViewById(R.id.soluong);
        sua = itemView.findViewById(R.id.update);
        xoa = itemView.findViewById(R.id.xoa);
    }
}
