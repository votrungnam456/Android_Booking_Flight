package com.example.bookingfilght.Models;

import java.io.Serializable;
import java.util.Date;

public class ChuyenBayDTO implements Serializable {

	
	private Date ngayGio;
	private String ngay;
	private String gio;

	private Float thoiGianBay;
	private String HangVe;
	private String codeSanDi;
	private String codeSanDen;
	private String donGia;

	public ChuyenBayDTO(String ngay, String gio, Float thoiGianBay, String hangVe, String codeSanDi, String codeSanDen, String donGia, Integer image) {

		this.ngay = ngay;
		this.gio = gio;
		this.thoiGianBay = thoiGianBay;
		HangVe = hangVe;
		this.codeSanDi = codeSanDi;
		this.codeSanDen = codeSanDen;
		this.donGia = donGia;
		this.image = image;
	}

	public Integer getImage() {
		return image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	private Integer image;

	public Float getThoiGianBay() {
		return thoiGianBay;
	}

	public void setThoiGianBay(Float thoiGianBay) {
		this.thoiGianBay = thoiGianBay;
	}

	public Date getNgayGio() {
		return ngayGio;
	}

	public void setNgayGio(Date ngayGio) {
		this.ngayGio = ngayGio;
	}

	public String getCodeSanDi() {
		return codeSanDi;
	}

	public void setCodeSanDi(String codeSanDi) {
		this.codeSanDi = codeSanDi;
	}

	public String getCodeSanDen() {
		return codeSanDen;
	}

	public void setCodeSanDen(String codeSanDen) {
		this.codeSanDen = codeSanDen;
	}

	public String getHangVe() {
		return HangVe;
	}

	public void setHangVe(String hangVe) {
		HangVe = hangVe;
	}

	

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getGio() {
		return gio;
	}

	public void setGio(String gio) {
		this.gio = gio;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

}
