/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import DungChung.DungChung;
import Model.QuanLyKhachHang;

import Model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import Model.HoaDon;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class HoaDonDAO extends getConnection{
    public ArrayList<QuanLyKhachHang> layDS_HK(){
        ArrayList<QuanLyKhachHang> arr = new ArrayList<>();
        try {
            String sql = "select CMND, HoTen from KHACHHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                QuanLyKhachHang hk = new QuanLyKhachHang(rs.getString(1), rs.getString(2));
                arr.add(hk);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<NhanVien> layDS_NV(){
        ArrayList<NhanVien> arr = new ArrayList<>();
        try {
            String sql = "select MaNhanVien, HoTen from NHANVIEN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                arr.add(nv);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã hóa đơn", "Ngày lập", "Chứng minh nhân dân", "Mã nhân viên"};
            String sql = "select ROW_NUMBER() Over (Order by MaHoaDon), * from HOADON";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public int them(HoaDon hd) {
        try {
            String sql = "insert into HOADON values(?, ?, ?, ?)";
            Object[] obj = new Object[]{hd.getMaHoaDon(), hd.getNgayLap(), hd.getCmnd(), hd.getMaNhanVien()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int sua(HoaDon hd) {
        try {
            String sql = "update HOADON set NgayLap = ?, CMND = ?, MaNhanVien = ? where MaHoaDon = ?";
            Object[] obj = new Object[]{hd.getNgayLap(), hd.getCmnd(), hd.getMaNhanVien(), hd.getMaHoaDon()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int xoa(HoaDon hd) {
        try {
            String sql = "delete from HOADON where MaHoaDon = ?";
            Object[] obj = new Object[]{hd.getMaHoaDon()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, HoaDon hd, int q) {
        hd.setMaHoaDon(String.valueOf(tbl.getValueAt(q, 1)));
        hd.setNgayLap(String.valueOf(tbl.getValueAt(q, 2)));
        hd.setCmnd(String.valueOf(tbl.getValueAt(q, 3)));
        hd.setMaNhanVien(String.valueOf(tbl.getValueAt(q, 4)));
    }
    
    public HoaDon timHDToDen(String ma) {
        try {
            String sql = "select * from HOADON where MaHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDon sb = new HoaDon(rs.getString(1));
                return sb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaHoaDon), * from HOADON where MaHoaDon like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã hóa đơn", "Ngày lập", "Chứng minh nhân dân", "Mã nhân viên"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
