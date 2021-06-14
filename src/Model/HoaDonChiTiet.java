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
public class HoaDonChiTiet implements Serializable{
    private String maHoaDon;
    private String maVe;
    private int soGheDat;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HoaDonChiTiet(String maHoaDon, String maVe) {
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
    }

    public HoaDonChiTiet(String maHoaDon, String maVe, int soGheDat) {
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
        this.soGheDat = soGheDat;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public int getSoGheDat() {
        return soGheDat;
    }

    public void setSoGheDat(int soGheDat) {
        this.soGheDat = soGheDat;
    }
}
