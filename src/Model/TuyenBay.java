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
public class TuyenBay implements Serializable{
    private String maTuyenBay;
    private String tenTuyenBay;
    

    public TuyenBay() {
    }

    public TuyenBay(String maTuyenBay) {
        this.maTuyenBay = maTuyenBay;
    }

    public TuyenBay(String maTuyenBay, String tenTuyenBay) {
        this.maTuyenBay = maTuyenBay;
        this.tenTuyenBay = tenTuyenBay;
        
    }

    public String getMaTuyenBay() {
        return maTuyenBay;
    }

    public void setMaTuyenBay(String maTuyenBay) {
        this.maTuyenBay = maTuyenBay;
    }

    public String gettenTuyenBay() {
        return tenTuyenBay;
    }

    public void settenTuyenBay(String maSanBayDi) {
        this.tenTuyenBay = tenTuyenBay;
    }

  
}
