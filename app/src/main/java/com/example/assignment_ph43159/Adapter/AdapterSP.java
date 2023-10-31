package com.example.assignment_ph43159.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_ph43159.DAO.DaoSP;
import com.example.assignment_ph43159.DataBase.DBHelperSP;
import com.example.assignment_ph43159.Model.SanPham;
import com.example.assignment_ph43159.R;
import java.util.ArrayList;

public class AdapterSP extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<SanPham> list;
    DaoSP daoSP;

    public AdapterSP(Context context, ArrayList<SanPham> list, DaoSP daoSP) {
        this.context = context;
        this.list = list;
        this.daoSP = daoSP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tensp.setText(list.get(position).getTensp());
        holder.giasp.setText(String.valueOf(list.get(position).getGiasp()));
        holder.soluong.setText(String.valueOf(list.get(position).getSoluong()));

        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn xóa sản phẩm " + "'" + holder.tensp.getText().toString() + "'" + "?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = list.get(holder.getAdapterPosition()).getId();
                        daoSP.xoasp(id);
                        list.clear();
                        list.addAll(daoSP.danhsach());
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sp = list.get(holder.getAdapterPosition());
                update(sp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(SanPham sp){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View convertView = inflater.inflate(R.layout.item_update, null);
        builder.setView(convertView);
        Dialog dialog = builder.create();
        dialog.show();

        EditText udtensp = convertView.findViewById(R.id.udtensp);
        EditText udgiasp = convertView.findViewById(R.id.udgiasp);
        EditText udsoluong = convertView.findViewById(R.id.udsoluong);

        udtensp.setText(sp.getTensp());
        udgiasp.setText(String.valueOf(sp.getGiasp()));
        udsoluong.setText(String.valueOf(sp.getSoluong()));

        convertView.findViewById(R.id.btnupdate).setOnClickListener(v -> {
            String tensp = udtensp.getText().toString();
            String giasp = udgiasp.getText().toString();
            String soluong = udsoluong.getText().toString();

            if(tensp.isEmpty()||String.valueOf(giasp).isEmpty()||String.valueOf(soluong).isEmpty()){
                Toast.makeText(context, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }else{
                double gia;
                int soLuong;
                try {
                    gia = Double.parseDouble(giasp);
                    soLuong = Integer.parseInt(soluong);
                } catch (Exception e) {
                    Toast.makeText(context, "Giá và số lượng sản phẩm phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (gia <= 0) {
                    Toast.makeText(context, "Giá sản phẩm phải là số dương", Toast.LENGTH_SHORT).show();
                }

                if (soLuong <= 0) {
                    Toast.makeText(context, "Số lượng sản phẩm phải là số dương", Toast.LENGTH_SHORT).show();
                }

                SanPham sp1 = new SanPham(sp.getId(), tensp, Double.parseDouble(giasp), Integer.parseInt(soluong));

                daoSP.suasp(sp1);
                list.clear();
                list.addAll(daoSP.danhsach());
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });
    }
}
