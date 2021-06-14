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
import Model.NhanVien;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class NhanVienDAO extends getConnection {

    public void loadTable(JTable tbl) {
        try {
            String[] header = new String[]{"STT", "Mã NV", "Mật khẩu", "Vai trò", "Họ tên", "Giới tính", "Điện thoại", "Email", "Địa chỉ", "Hình"};
            String sql = "select ROW_NUMBER() Over (Order by MaNhanVien), * from NHANVIEN";
            new DungChung().statement(sql, tbl, header);
            for (int i = 0; i < tbl.getRowCount(); i++) {
                String str = String.valueOf(tbl.getValueAt(i, 5));
                if (str.equals("true")) {
                    tbl.setValueAt("Nam", i, 5);
                }else{
                    tbl.setValueAt("Nữ", i, 5);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public int them(NhanVien nv) {
        try {
            String sql = "insert into NHANVIEN values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] obj = new Object[]{nv.getMaNhanVien(), nv.getMatKhau(), nv.getVaiTro(), nv.getHoten(), nv.isGioiTinh(), nv.getSoDT(), nv.getEmail(), nv.getDiaChi(), nv.getHinh()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int sua(NhanVien nv) {
        try {
            String sql = "update NHANVIEN set MatKhau = ?, VaiTro = ?, HoTen = ?, GioiTinh= ?, DienThoai = ?, Email = ?, DiaChi = ?, Hinh = ? where MaNhanVien = ?";
            Object[] obj = new Object[]{nv.getMatKhau(), nv.getVaiTro(), nv.getHoten(), nv.isGioiTinh(), nv.getSoDT(), nv.getEmail(), nv.getDiaChi(), nv.getHinh(), nv.getMaNhanVien()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int xoa(NhanVien nv) {
        try {
            String sql = "delete from NHANVIEN where MaNhanVien = ?";
            Object[] obj = new Object[]{nv.getMaNhanVien()};
            PreparedStatement ps = new DungChung().prepareStatement(sql, obj);
            return ps.executeUpdate();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public void hienThi(JTable tbl, NhanVien nv, int q) {
        nv.setMaNhanVien(String.valueOf(tbl.getValueAt(q, 1)));
        nv.setMatKhau(String.valueOf(tbl.getValueAt(q, 2)));
        nv.setVaiTro(String.valueOf(tbl.getValueAt(q, 3)));
        nv.setHoten(String.valueOf(tbl.getValueAt(q, 4)));
        nv.setGioiTinh(Boolean.parseBoolean(String.valueOf(tbl.getValueAt(q, 5).equals("Nam"))));
        nv.setSoDT(String.valueOf(tbl.getValueAt(q, 6)));
        nv.setEmail(String.valueOf(tbl.getValueAt(q, 7)));
        nv.setDiaChi(String.valueOf(tbl.getValueAt(q, 8)));
        nv.setHinh(String.valueOf(tbl.getValueAt(q, 9)));
    }

    public NhanVien timNVToDen(String ma) {
        try {
            String sql = "select * from NHANVIEN where MaNhanVien = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NhanVien sb = new NhanVien(rs.getString(1));
                return sb;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void tim(JTable tbl, String ma) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by MaNhanVien), * from NHANVIEN where MaNhanVien like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            String[] header = new String[]{"STT", "Mã NV", "Mật khẩu", "Vai trò", "Họ tên", "Giới tính", "Điện thoại", "Email", "Địa chỉ", "Hình"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                data.add(rs.getBoolean(6));
                data.add(rs.getString(7));
                data.add(rs.getString(8));
                data.add(rs.getString(9));
                data.add(rs.getString(10));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
            for (int i = 0; i < tbl.getRowCount(); i++) {
                String str = String.valueOf(tbl.getValueAt(i, 5));
                if (str.equals("true")) {
                    tbl.setValueAt("Nam", i, 5);
                }else{
                    tbl.setValueAt("Nữ", i, 5);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
