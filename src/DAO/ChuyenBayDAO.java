
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
import Model.ChuyenBay;
import Model.QuanLyKhachHang;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.TuyenBay;
import Model.QuanLyNhapHang;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class ChuyenBayDAO extends getConnection{
    public ArrayList<TuyenBay> layDS_TB(){
        ArrayList<TuyenBay> arr = new ArrayList<>();
        try {
            String sql = "select MaTuyenBay from TUYENBAY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                TuyenBay hk = new TuyenBay(rs.getString(1));
                arr.add(hk);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<QuanLyNhapHang> layDS_MB(){
        ArrayList<QuanLyNhapHang> arr = new ArrayList<>();
        try {
            String sql = "select MaNhapHang from NHAPHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                QuanLyNhapHang hk = new QuanLyNhapHang(rs.getString(1));
                arr.add(hk);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return arr;
    }
    
    public void loadTable(JTable tbl){
        try {
            String[] header = new String[]{"STT", "Mã chuyến bay", "Ngày đi", "Ngày đến", "Giờ khởi hành", "Giày cao cấp", "Giày phổ thông", "Mã tuyến bay", "Mã nhập hàng"};
            String sql = "select ROW_NUMBER() Over (Order by MaChuyenBay), * from CHUYENBAY";
            new DungChung().statement(sql, tbl, header);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public int them(ChuyenBay cb) {
        try {
            String sql = "set dateformat YMD insert into CHUYENBAY values(?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] obj = new Object[]{cb.getMaChuyenBay(), cb.getNgayDi(), cb.getNgayDen(), cb.getGioKhoiHanh(), cb.getSoGheThuongGia(), cb.getSoGhePhoThong(), cb.getMaTuyenBay(), cb.getMamayBay()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }
    
    public int sua(ChuyenBay cb) {
        try {
            String sql = "set dateformat YMD update CHUYENBAY set NgayDi = ?, NgayDen = ?, GioKhoiHanh = ?, Giaycaocap = ?, GiayPhoThong = ?, MaTuyenBay = ?, MaNhapHang = ? where MaChuyenBay = ?";
            Object[] obj = new Object[]{cb.getNgayDi(), cb.getNgayDen(), cb.getGioKhoiHanh(), cb.getSoGheThuongGia(), cb.getSoGhePhoThong(), cb.getMaTuyenBay(), cb.getMamayBay(), cb.getMaChuyenBay()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int xoa(ChuyenBay cb) {
        try {
            String sql = "delete from CHUYENBAY where MaChuyenBay = ?";
            Object[] obj = new Object[]{cb.getMaChuyenBay()};
            PreparedStatement ps =  new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }
    
    public void hienThi(JTable tbl, ChuyenBay cb, int q){
        cb.setMaChuyenBay(String.valueOf(tbl.getValueAt(q, 1)));
        cb.setNgayDi(String.valueOf(tbl.getValueAt(q, 2)));
        cb.setNgayDen(String.valueOf(tbl.getValueAt(q, 3)));
        cb.setGioKhoiHanh(String.valueOf(tbl.getValueAt(q, 4)));
        cb.setSoGheThuongGia(Integer.parseInt(String.valueOf(tbl.getValueAt(q, 5))));
        cb.setSoGhePhoThong(Integer.parseInt(String.valueOf(tbl.getValueAt(q, 6))));
        cb.setMaTuyenBay(String.valueOf(tbl.getValueAt(q, 7)));
        cb.setMamayBay(String.valueOf(tbl.getValueAt(q, 8)));
    }
    
    public ChuyenBay timCBToDen(String ma) {
        try {
            String sql = "select * from CHUYENBAY where MaChuyenBay = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ChuyenBay cb = new ChuyenBay(rs.getString(1));
                return cb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaChuyenBay), * from CHUYENBAY where MaChuyenBay like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã chuyến bay", "Ngày đi", "Ngày đến", "Giờ khởi hành", "Giày cao cấp", "Giày phổ thông", "Mã tuyến bay", "Mã nhập hàng"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                data.add(rs.getInt(6));
                data.add(rs.getInt(7));
                data.add(rs.getString(8));
                data.add(rs.getString(9));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
