package com.example.assignment_ph43159.Model;

public class SanPham {
    private int id;
    private String tensp;
    private Double giasp;
    private int soluong;

    public SanPham() {
    }

    public SanPham(int id, String tensp, Double giasp, int soluong) {
        this.id = id;
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluong = soluong;
    }

    public SanPham(String tensp, Double giasp, int soluong) {
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Double getGiasp() {
        return giasp;
    }

    public void setGiasp(Double giasp) {
        this.giasp = giasp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
