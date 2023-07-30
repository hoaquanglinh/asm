package com.example.assignment_ph43159;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.assignment_ph43159.Adapter.AdapterSP;
import com.example.assignment_ph43159.DAO.DaoSP;
import com.example.assignment_ph43159.DataBase.DBHelperSP;
import com.example.assignment_ph43159.Model.SanPham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ManHinhQLSP extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fac;
    SanPham sp;
    DaoSP daosp;
    AdapterSP adapter;
    ArrayList<SanPham> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View converView = inflater.inflate(R.layout.fragment_man_hinh_q_l_s_p, container, false);

        recyclerView = converView.findViewById(R.id.recyclerView);
        fac = converView.findViewById(R.id.fac);

        daosp = new DaoSP(getActivity(), new DBHelperSP(getActivity()));
        list = daosp.danhsach();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AdapterSP(getContext(), list, daosp);
        recyclerView.setAdapter(adapter);

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = new SanPham();
                dialogadd(sanPham);
            }
        });
        return converView;
    }

    public void dialogadd(SanPham sp){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_add, null);

        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText addtensp = convertView.findViewById(R.id.addtensp);
        EditText addgiasp = convertView.findViewById(R.id.addgiasp);
        EditText addsoluong = convertView.findViewById(R.id.addsoluong);

        convertView.findViewById(R.id.btnadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tensp = addtensp.getText().toString();
                String giasp = addgiasp.getText().toString();
                String soluong = addsoluong.getText().toString();

                SanPham sp1 = new SanPham(tensp, Double.parseDouble(giasp), Integer.parseInt(soluong));
//                sp.setTensp(tensp);
//                sp.setGiasp(Double.parseDouble(giasp));
//                sp.setSoluong(Integer.parseInt(soluong));

                daosp.themsp(sp1);
                list.clear();
                list.addAll(daosp.danhsach());
                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

    }
}