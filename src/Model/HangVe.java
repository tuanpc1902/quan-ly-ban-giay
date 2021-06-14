/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author TuanDuc
 */
public class HangVe implements Serializable{
    private String maHangVe;
    private String tenHangVe;

    public HangVe() {
    }

    public HangVe(String maHangVe) {
        this.maHangVe = maHangVe;
    }

    public HangVe(String maHangVe, String tenHangVe) {
        this.maHangVe = maHangVe;
        this.tenHangVe = tenHangVe;
    }

    public String getMaHangVe() {
        return maHangVe;
    }

    public void setMaHangVe(String maHangVe) {
        this.maHangVe = maHangVe;
    }

    public String getTenHangVe() {
        return tenHangVe;
    }

    public void setTenHangVe(String tenHangVe) {
        this.tenHangVe = tenHangVe;
    }
}
