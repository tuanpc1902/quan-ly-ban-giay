/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import DungChung.DungChung;
import Model.QuanLyKhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class QuanLyKhachHangDAO extends getConnection{
    public ArrayList<QuanLyKhachHang> abc(){
        try {
            String sql = "select * from KHACHHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<QuanLyKhachHang> arr = new ArrayList<>();
            while(rs.next()){
                QuanLyKhachHang hk = new QuanLyKhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6));
                arr.add(hk);
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void loadTable(JTable tbl){
        try {
            String[] header = new String[]{"STT", "CMND", "Họ tên", "Giới tính", "Điện thoại", "Email", "Địa chỉ"};
            String sql = "select ROW_NUMBER() Over (Order by CMND), * from KHACHHANG";
            new DungChung().statement(sql, tbl, header);
            for(int i = 0; i < tbl.getRowCount(); i++){
                if(tbl.getValueAt(i, 3).equals(true)){
                    tbl.setValueAt("Nam", i, 3);
                }else{
                    tbl.setValueAt("Nữ", i, 3);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public int them(QuanLyKhachHang hk) {
        try {
            String sql = "insert into KHACHHANG values(?, ?, ?, ?, ?, ?)";
            Object[] obj = new Object[]{hk.getCmnd(), hk.getHoTen(), hk.isGioiTinh(), hk.getSoDT(), hk.getEmail(), hk.getDiaChi()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }
    
    public int sua(QuanLyKhachHang hk) {
        try {
            String sql = "update KHACHHANG set HoTen = ?, GioiTinh = ?, DienThoai = ?, Email = ?, DiaChi = ? where CMND = ?";
            Object[] obj = new Object[]{hk.getHoTen(), hk.isGioiTinh(), hk.getSoDT(), hk.getEmail(), hk.getDiaChi(), hk.getCmnd()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }
    
    public int xoa(QuanLyKhachHang hk) {
        try {
            String sql = "delete from KHACHHANG where CMND = ?";
            Object[] obj = new Object[]{hk.getCmnd()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }
    
    public void hienThi(JTable tbl, QuanLyKhachHang hk, int q){
        hk.setCmnd(String.valueOf(tbl.getValueAt(q, 1)));
        hk.setHoTen(String.valueOf(tbl.getValueAt(q, 2)));
        hk.setGioiTinh(Boolean.parseBoolean(String.valueOf(tbl.getValueAt(q, 3).equals("Nam"))));
        hk.setSoDT(String.valueOf(tbl.getValueAt(q, 4)));
        hk.setEmail(String.valueOf(tbl.getValueAt(q, 5)));
        hk.setDiaChi(String.valueOf(tbl.getValueAt(q, 6)));
    }
    
    public QuanLyKhachHang timHKToDen(String ma) {
        try {
            String sql = "select * from KHACHHANG where CMND = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QuanLyKhachHang hk = new QuanLyKhachHang(rs.getString(1));
                return hk;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by CMND), * from KHACHHANG where CMND like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "CMND", "Họ tên", "Giới tính", "Điện thoại", "Email", "Địa chỉ"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getBoolean(4));
                data.add(rs.getString(5));
                data.add(rs.getString(6));
                data.add(rs.getString(7));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
            for(int i = 0; i < tbl.getRowCount(); i++){
                if(tbl.getValueAt(i, 3).equals(true)){
                    tbl.setValueAt("Nam", i, 3);
                }else{
                    tbl.setValueAt("Nữ", i, 3);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
