/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import DungChung.DungChung;
import Model.QuanLyThuongHieuGiay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class QuanLyThuongHieuGiayDAO extends getConnection {
    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã hãng giày", "Tên hãng giày", "Quốc gia"};
            String sql = "select ROW_NUMBER() Over (Order by MaHang), * from THUONGHIEUGIAY";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int them(QuanLyThuongHieuGiay hmb) {
        try {
            String sql = "insert into THUONGHIEUGIAY values(?, ?, ?)";
            Object[] obj = new Object[]{hmb.getMaHang(), hmb.getTenHang(), hmb.getQuocGia()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int sua(QuanLyThuongHieuGiay hmb) {
        try {
            String sql = "update THUONGHIEUGIAY set TenHang = ?, QuocGia = ? where MaHang = ?";
            Object[] obj = new Object[]{hmb.getTenHang(), hmb.getQuocGia(), hmb.getMaHang()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int xoa(QuanLyThuongHieuGiay hmb) {
        try {
            String sql = "delete from THUONGHIEUGIAY where MaHang = ?";
            Object[] obj = new Object[]{hmb.getMaHang()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, QuanLyThuongHieuGiay hmb, int q) {
        hmb.setMaHang(String.valueOf(tbl.getValueAt(q, 1)));
        hmb.setTenHang(String.valueOf(tbl.getValueAt(q, 2)));
        hmb.setQuocGia(String.valueOf(tbl.getValueAt(q, 3)));
    }
    
    public QuanLyThuongHieuGiay timHMBToDen(String cmnd) {
        try {
            String sql = "select * from THUONGHIEUGIAY where MaHang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cmnd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QuanLyThuongHieuGiay lv = new QuanLyThuongHieuGiay(rs.getString(1));
                return lv;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaHang), * from THUONGHIEUGIAY where MaHang like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã hãng", "Tên hãng", "Quốc gia"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
