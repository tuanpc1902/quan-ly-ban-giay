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
public class QuanLyGiay implements Serializable{
    private String maGiay;
    private String maHangGiay;
    private String maSize;
    private String maChuyenBay;
    private float giaBan;

    public QuanLyGiay() {
    }

    public QuanLyGiay(String maVe) {
        this.maGiay = maGiay;
    }

    public QuanLyGiay(String maVe, String maHangVe, String maLoaiVe, String maChuyenBay, float giaBan) {
        this.maGiay = maVe;
        this.maHangGiay = maHangGiay;
        this.maSize = maSize;
        this.maChuyenBay = maChuyenBay;
        this.giaBan = giaBan;
    }

    public String getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(String maVe) {
        this.maGiay = maVe;
    }

    public String getMaHangGiay() {
        return maHangGiay;
    }

    public void setMaHangGiay(String maHangVe) {
        this.maHangGiay = maHangGiay;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maLoaiVe) {
        this.maSize = maLoaiVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
}
