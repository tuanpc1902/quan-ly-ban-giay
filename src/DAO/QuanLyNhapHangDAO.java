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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import Model.QuanLyNhapHang;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class QuanLyNhapHangDAO extends getConnection {

    public ArrayList<QuanLyThuongHieuGiay> layDS() {
        ArrayList<QuanLyThuongHieuGiay> arr = new ArrayList<>();
        try {
            String sql = "select MaHang, TenHang from THUONGHIEUGIAY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                QuanLyThuongHieuGiay hmb = new QuanLyThuongHieuGiay(rs.getString(1), rs.getString(2));
                arr.add(hmb);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }

    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã Nhập Hàng", "Mã thương hiệu giày"};
            String sql = "select ROW_NUMBER() Over (Order by MaNhapHang), * from NhapHang";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public int them(QuanLyNhapHang mb) {
        try {
            String sql = "insert into NhapHang values(?, ?)";
            Object[] obj = new Object[]{mb.getMaMaybay(), mb.getMaHang()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int sua(QuanLyNhapHang mb) {
        try {
            String sql = "update NhapHang set MaHang = ? where MaNhapHang = ?";
            Object[] obj = new Object[]{mb.getMaHang(), mb.getMaMaybay()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int xoa(QuanLyNhapHang mb) {
        try {
            String sql = "delete from NhapHang where MaNhapHang = ?";
            Object[] obj = new Object[]{mb.getMaMaybay()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, QuanLyNhapHang mb, int q) {
        mb.setMaMaybay(String.valueOf(tbl.getValueAt(q, 1)));
        mb.setMaHang(String.valueOf(tbl.getValueAt(q, 2)));
    }
    
    public QuanLyNhapHang timMBToDen(String cmnd) {
        try {
            String sql = "select * from NhapHang where MaNhapHang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cmnd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QuanLyNhapHang mb = new QuanLyNhapHang(rs.getString(1));
                return mb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaNhapHang), * from NhapHang where MaNhapHang like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã Nhập Hàng", "Mã thương hiệu giày"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
