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
public class QuanLyKhachHang implements Serializable{
    private String cmnd;
    private String hoTen;
    private boolean gioiTinh;
    private String soDT;
    private String email;
    private String diaChi;

    public QuanLyKhachHang() {
    }

    public QuanLyKhachHang(String cmnd) {
        this.cmnd = cmnd;
    }

    public QuanLyKhachHang(String cmnd, String hoTen) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
    }

    public QuanLyKhachHang(String cmnd, String hoTen, boolean gioiTinh, String soDT, String email, String diaChi) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
