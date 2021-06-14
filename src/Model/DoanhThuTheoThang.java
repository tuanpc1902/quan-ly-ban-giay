/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * 
 */
public class DoanhThuTheoThang implements Serializable{
    private String maHoaDon;
    private String maGiay;
    private String maNhanVien;
    private String cmnd;
    private String ngayLap;
    private double giaBan;
    private int sogheDat;
    private double thanhTien;

    public DoanhThuTheoThang() {
    }

    public DoanhThuTheoThang(String maHoaDon, String maVe, String maNhanVien, String cmnd, String ngayLap, double giaBan, int sogheDat) {
        this.maHoaDon = maHoaDon;
        this.maGiay = maGiay;
        this.maNhanVien = maNhanVien;
        this.cmnd = cmnd;
        this.ngayLap = ngayLap;
        this.giaBan = giaBan;
        this.sogheDat = sogheDat;
        this.thanhTien = giaBan * sogheDat;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() {
        return maGiay;
    }

    public void setMaVe(String maVe) {
        this.maGiay = maGiay;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSogheDat() {
        return sogheDat;
    }

    public void setSogheDat(int sogheDat) {
        this.sogheDat = sogheDat;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
