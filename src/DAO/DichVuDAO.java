/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import DungChung.DungChung;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import Model.DichVu;
import Model.QuanLyGiay;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TuanDuc
 */
public class DichVuDAO extends getConnection{
    public ArrayList<QuanLyGiay> layDS() {
        ArrayList<QuanLyGiay> arr = new ArrayList<>();
        try {
            String sql = "select MaGiay from GIAY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                QuanLyGiay sb = new QuanLyGiay(rs.getString(1));
                arr.add(sb);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã dịch vụ", "Mã giày", "Tên dịch vụ", "Giá dịch vụ (triệu)"};
            String sql = "select ROW_NUMBER() Over (Order by MaDichVu), * from DICHVU";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public int them(DichVu dv) {
        try {
            String sql = "insert into DICHVU values(?, ?, ?, ?)";
            Object[] obj = new Object[]{dv.getMaDichVu(), dv.getMaVe(), dv.getTenDichVu(), dv.getGiaDichVu()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int sua(DichVu dv) {
        try {
            String sql = "update DICHVU set MaGiay = ?, TenDichVu = ?, GiaDichVu = ? where MaDichVu = ?";
            Object[] obj = new Object[]{dv.getMaVe(), dv.getTenDichVu(), dv.getGiaDichVu(), dv.getMaDichVu()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int xoa(DichVu dv) {
        try {
            String sql = "delete from DICHVU where MaDichVu = ?";
            Object[] obj = new Object[]{dv.getMaDichVu()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, DichVu dv, int q) {
        dv.setMaDichVu(String.valueOf(tbl.getValueAt(q, 1)));
        dv.setMaVe(String.valueOf(tbl.getValueAt(q, 2)));
        dv.setTenDichVu(String.valueOf(tbl.getValueAt(q, 3)));
        dv.setGiaDichVu(Float.parseFloat(String.valueOf(tbl.getValueAt(q, 4))));
    }
    
    public DichVu timDVToDen(String ma) {
        try {
            String sql = "select * from DICHVU where MaDichVu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DichVu sb = new DichVu(rs.getString(1));
                return sb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaDichVu), * from DICHVU where MaDichVu like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã dịch vụ", "Mã giày", "Tên dịch vụ", "Giá dịch vụ (triệu)"};
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
    
    public double getTienDV(String maVe){
        try {
            double tong = 0.0;
            String sql = "select GiaDichVu from DICHVU where MaGiay = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maVe);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tong += rs.getDouble(1);
            }
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
