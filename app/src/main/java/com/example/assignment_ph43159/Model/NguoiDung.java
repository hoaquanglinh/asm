package com.example.assignment_ph43159.Model;

public class NguoiDung {
    int id;
    private String taikhoan;
    private String matkhau;
    private String hoten;

    public NguoiDung() {
    }

    public NguoiDung(int id, String taikhoan, String matkhau, String hoten) {
        this.id = id;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.hoten = hoten;
    }

    public NguoiDung(int id, String taikhoan, String matkhau) {
        this.id = id;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public NguoiDung(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
