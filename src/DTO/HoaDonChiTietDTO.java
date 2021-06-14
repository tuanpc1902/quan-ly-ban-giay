/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import Model.HoaDonChiTiet;

/**
 *
 * @author TuanDuc
 */
public class HoaDonChiTietDTO implements Serializable{
    private HoaDonChiTiet hoaDonChiTiet;
    private double donGia;
    private double thanhTien;

    public HoaDonChiTietDTO() {
    }

    public HoaDonChiTietDTO(HoaDonChiTiet hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public HoaDonChiTietDTO(HoaDonChiTiet hoaDonChiTiet, double donGia, double thanhTien) {
        this.hoaDonChiTiet = hoaDonChiTiet;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTiet getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
