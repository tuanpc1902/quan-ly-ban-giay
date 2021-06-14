/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import DungChung.DungChung;
import Model.ChuyenBay;
import Model.HangVe;
import Model.LoaiVe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import Model.QuanLyGiay;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class QuanLyGiayDAO extends getConnection{
    public ArrayList<HangVe> layDS_HV(){
        ArrayList<HangVe> arr = new ArrayList<>();
        try {
            String sql = "select MaHangGiay, TenHangGiay from HANGGIAY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                HangVe hv = new HangVe(rs.getString(1), rs.getString(2));
                arr.add(hv);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<LoaiVe> layDS_LV(){
        ArrayList<LoaiVe> arr = new ArrayList<>();
        try {
            String sql = "select MaSize,TenSize from SizeGiay";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                LoaiVe lv = new LoaiVe(rs.getString(1), rs.getString(2));
                arr.add(lv);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ChuyenBay> layDS_CB(){
        ArrayList<ChuyenBay> arr = new ArrayList<>();
        try {
            String sql = "select MaChuyenBay from CHUYENBAY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ChuyenBay cb = new ChuyenBay(rs.getString(1));
                arr.add(cb);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã giày", "Mã hạng giày", "Size giày", "Mã chuyến bay", "Giá bán (triệu)"};
            String sql = "select ROW_NUMBER() Over (Order by MaGiay), * from GIAY";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public int them(QuanLyGiay vmb) {
        try {
            String sql = "insert into GIAY values(?, ?, ?, ?, ?)";
            Object[] obj = new Object[]{vmb.getMaGiay(), vmb.getMaHangGiay(), vmb.getMaSize(), vmb.getMaChuyenBay(), vmb.getGiaBan()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int sua(QuanLyGiay vmb) {
        try {
            String sql = "update GIAY set MaHangGiay = ?, MaSize = ?, MaChuyenBay = ?, GiaBan = ? where MaGiay = ?";
            Object[] obj = new Object[]{vmb.getMaHangGiay(), vmb.getMaSize(), vmb.getMaChuyenBay(), vmb.getGiaBan(), vmb.getMaGiay()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int xoa(QuanLyGiay vmb) {
        try {
            String sql = "delete from GIAY where MaGiay = ?";
            Object[] obj = new Object[]{vmb.getMaGiay()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, QuanLyGiay vmb, int q) {
        vmb.setMaGiay(String.valueOf(tbl.getValueAt(q, 1)));
        vmb.setMaHangGiay(String.valueOf(tbl.getValueAt(q, 2)));
        vmb.setMaSize(String.valueOf(tbl.getValueAt(q, 3)));
        vmb.setMaChuyenBay(String.valueOf(tbl.getValueAt(q, 4)));
        vmb.setGiaBan(Float.parseFloat(String.valueOf(tbl.getValueAt(q, 5))));
    }
    
    public QuanLyGiay timDVToDen(String ma) {
        try {
            String sql = "select * from GIAY where MaGiay = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QuanLyGiay sb = new QuanLyGiay(rs.getString(1));
                return sb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaVe), * from GIAY where MaGiay like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã vé", "Mã hạng vé", "Mã loại vé", "Mã chuyến bay", "Giá bán (triệu)"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                data.add(rs.getFloat(6));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
