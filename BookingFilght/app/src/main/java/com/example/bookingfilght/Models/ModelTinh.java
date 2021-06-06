package com.example.bookingfilght.Models;

public class ModelTinh {
    public String MaTinh;

    public String getMaTinh() {
        return MaTinh;
    }

    public ModelTinh(String maTinh, String tenTinh) {
        MaTinh = maTinh;
        TenTinh = tenTinh;
    }

    public void setMaTinh(String maTinh) {
        MaTinh = maTinh;
    }

    public String getTenTinh() {
        return TenTinh;
    }

    public void setTenTinh(String tenTinh) {
        TenTinh = tenTinh;
    }

   public String TenTinh;
}
