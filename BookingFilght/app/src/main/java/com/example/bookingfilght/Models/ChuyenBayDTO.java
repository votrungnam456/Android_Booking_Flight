package com.example.bookingfilght.Models;

import java.util.Date;

public class ChuyenBayDTO {

	private Long id;
	private Long tuyenBayId;
	private Long mayBayId;
	private Integer ghePhoThong;
	
	private Integer gheThuongGia;
	
	private Date ngayGio;
	private String ngay;
	private String gio;
	
	private Float thoiGianBay;
	private Boolean tinhTrang;
	
	
	private Long sanBayDiID;
	private Long sanBayDenID;
	private String ngayDi;
	private String ngayVe;
	private String HangVe;
	private String loaiVe;
	private String codeSanDi;
	private String codeSanDen;
	private String donGia;
	private Long idVe;
	private String tenSanBayDi;
	private String tenSanBayDen;
	private String thanhPhoDi;
	private String thanhPhoDen;

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
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Long getTuyenBayId() {
		return tuyenBayId;
	}

	public void setTuyenBayId(Long tuyenBayId) {
		this.tuyenBayId = tuyenBayId;
	}

	public Long getMayBayId() {
		return mayBayId;
	}

	public void setMayBayId(Long mayBayId) {
		this.mayBayId = mayBayId;
	}

	public Long getSanBayDiID() {
		return sanBayDiID;
	}

	public void setSanBayDiID(Long sanBayDiID) {
		this.sanBayDiID = sanBayDiID;
	}

	public Long getSanBayDenID() {
		return sanBayDenID;
	}

	public void setSanBayDenID(Long sanBayDenID) {
		this.sanBayDenID = sanBayDenID;
	}


	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getNgayVe() {
		return ngayVe;
	}

	public void setNgayVe(String ngayVe) {
		this.ngayVe = ngayVe;
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

	public String getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(String loaiVe) {
		this.loaiVe = loaiVe;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	public Long getIdVe() {
		return idVe;
	}

	public void setIdVe(Long idVe) {
		this.idVe = idVe;
	}

	public Integer getGhePhoThong() {
		return ghePhoThong;
	}

	public void setGhePhoThong(Integer ghePhoThong) {
		this.ghePhoThong = ghePhoThong;
	}

	public Integer getGheThuongGia() {
		return gheThuongGia;
	}

	public void setGheThuongGia(Integer gheThuongGia) {
		this.gheThuongGia = gheThuongGia;
	}

	public String getTenSanBayDi() {
		return tenSanBayDi;
	}

	public void setTenSanBayDi(String tenSanBayDi) {
		this.tenSanBayDi = tenSanBayDi;
	}

	public String getTenSanBayDen() {
		return tenSanBayDen;
	}

	public void setTenSanBayDen(String tenSanBayDen) {
		this.tenSanBayDen = tenSanBayDen;
	}

	public String getThanhPhoDi() {
		return thanhPhoDi;
	}

	public void setThanhPhoDi(String thanhPhoDi) {
		this.thanhPhoDi = thanhPhoDi;
	}

	public String getThanhPhoDen() {
		return thanhPhoDen;
	}

	public void setThanhPhoDen(String thanhPhoDen) {
		this.thanhPhoDen = thanhPhoDen;
	}

}
