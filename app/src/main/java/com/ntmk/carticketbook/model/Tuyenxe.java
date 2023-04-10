package com.ntmk.carticketbook.model;

public class Tuyenxe {
    String ThoiGianDi;
    String ThoiGianDen;
    String DiemDi;
    String DiemDen;
    int GiaVe;
    String LoaiXe;

    public Tuyenxe(String ThoiGianDi, String ThoiGianDen, String DiemDi, String DiemDen, int GiaVe, String LoaiXe) {
        this.ThoiGianDi = ThoiGianDi;
        this.ThoiGianDen = ThoiGianDen;
        this.DiemDi = DiemDi;
        this.DiemDen = DiemDen;
        this.GiaVe = GiaVe;
        this.LoaiXe = LoaiXe;
    }

    public Tuyenxe() {}

    public String getThoiGianDi() {
        return ThoiGianDi;
    }

    public String getThoiGianDen() {
        return ThoiGianDen;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public int getGiaVe() {
        return GiaVe;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }
}
