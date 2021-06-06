package com.example.bookingfilght.Models;

public class ModelsTicket {
    public double GiaVe;

    public String getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(String ngayDi) {
        NgayDi = ngayDi;
    }
    public int HangBay;
    public String NoiDi;
    public String NoiDen;
    public String ThoiGianBay;
    public String NgayDi;
    public ModelsTicket(double giaVe, String noiDi, String noiDen, String thoiGianBay, String thoiGianDen, String time, String hinhThucBay,String ngayDi,int hangBay) {
        GiaVe = giaVe;
        NoiDi = noiDi;
        NoiDen = noiDen;
        ThoiGianBay = thoiGianBay;
        ThoiGianDen = thoiGianDen;
        Time = time;
        HinhThucBay = hinhThucBay;
        NgayDi = ngayDi;
        HangBay = hangBay;
    }

    public String ThoiGianDen;
    public String Time;

    public double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(double giaVe) {
        GiaVe = giaVe;
    }

    public String getNoiDi() {
        return NoiDi;
    }

    public void setNoiDi(String noiDi) {
        NoiDi = noiDi;
    }

    public String getNoiDen() {
        return NoiDen;
    }

    public void setNoiDen(String noiDen) {
        NoiDen = noiDen;
    }

    public String getThoiGianBay() {
        return ThoiGianBay;
    }

    public void setThoiGianBay(String thoiGianBay) {
        ThoiGianBay = thoiGianBay;
    }

    public String getThoiGianDen() {
        return ThoiGianDen;
    }

    public void setThoiGianDen(String thoiGianDen) {
        ThoiGianDen = thoiGianDen;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getHinhThucBay() {
        return HinhThucBay;
    }

    public void setHinhThucBay(String hinhThucBay) {
        HinhThucBay = hinhThucBay;
    }

    public String HinhThucBay;
}
