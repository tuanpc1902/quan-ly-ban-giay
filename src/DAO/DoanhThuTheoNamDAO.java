/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import Model.DoanhThuTheoNam;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * 
 */
public class DoanhThuTheoNamDAO extends getConnection {

    public String checkHangVe(String ma) {
        try {
            String sql = "select MaHangGiay from GIAY where MaGiay = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public String checkLoaiVe(String ma) {
        try {
            String sql = "select MaSize from Giay where MaGiay = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    
    public double getDoanhThu(int n) {
        try {
            String sql = "select GIAY.MaGiay, YEAR(NgayLap), (GiaBan * SoGheDat)"
                    + " from Giay, HOADONCHITIET, HOADON"
                    + " where HOADONCHITIET.MaGiay = Giay.MaGiay and HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and YEAR(NgayLap) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();
            ArrayList<DoanhThuTheoNam> arr = new ArrayList<>();
            while (rs.next()) {
                String maVe = rs.getString(1);
                int nam = Integer.parseInt(String.valueOf(rs.getInt(2)));
                double thanhTien = Double.parseDouble(String.valueOf(rs.getDouble(3)));
                String hang = checkHangVe(maVe);
                String loai = checkLoaiVe(maVe);
                if (hang.equals("HV01") && loai.equals("LV01")) {
                    thanhTien = thanhTien * 1.5 * 1.9;
                } else if (hang.equals("HV01") && loai.equals("LV02")) {
                    thanhTien = thanhTien * 1.5;
                } else if (hang.equals("HV02") && loai.equals("LV01")) {
                    thanhTien = thanhTien * 1.1 * 1.9;
                } else if (hang.equals("HV02") && loai.equals("LV02")) {
                    thanhTien = thanhTien * 1.1;
                }
                DoanhThuTheoNam dt = new DoanhThuTheoNam(maVe, nam, thanhTien);
                arr.add(dt);
            }

            double tongCong = 0.0;
            for (int i = 0; i < arr.size(); i++) {
                tongCong += arr.get(i).getThanhTien();
            }
            return Math.round(tongCong);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0.0;
    }

    public int getTongNV() {
        try {
            String sql = "select count(*) from NHANVIEN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1) * 1847;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public int getTongHK() {
        try {
            String sql = "select count(*) from KHACHHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1) * 12433;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

    public void loadTable_DoanhThu(JTable tbl, int nam) {
        try {
            String sql = "select ROW_NUMBER() Over (Order by hoadon.MaHoaDon), hoadon.MaHoaDon, NgayLap,"
                    + " GiaBan, SoGheDat,"
                    + " (GiaBan * SoGheDat)"
                    + " from GIAY, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = VEMAYBAY.MaGiay"
                    + " and Year(NgayLap) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nam);
            String[] header = new String[]{"STT", "Mã hóa đơn", "Ngày lập", "Giá bán (triệu)", "Số ghế đặt", "Thành tiền (triệu)"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            tbl.setDefaultEditor(Object.class, null);
            tbl.getTableHeader().setCursor(new Cursor(HAND_CURSOR));
            tbl.getTableHeader().setFont(new Font("Segoe UI", 1, 13));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getDouble(4));
                data.add(rs.getInt(5));
                data.add(rs.getDouble(6));
                model.addRow(data);
            }
            tbl.removeAll();
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSL_Ve(int nam, String maHang, String maLoai) {
        try {
            int tong = 0;
            String sql = "select COUNT(VEMAYBAY.MaGiay)"
                    + " from Giay, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = VEMAYBAY.MaGiay"
                    + " and YEAR(NgayLap) = ?"
                    + " and MaHangGiay = ?"
                    + " and MaSize = ?"
                    + " group by VEMAYBAY.MaGiay";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nam);
            ps.setString(2, maHang);
            ps.setString(3, maLoai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(1);
            }
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTongTien(int nam) {
        try {
            int tong = 0;
            String sql = "select hoadon.MaHoaDon, SUM(GiaBan * SoGheDat)"
                    + " from GIAY,HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = VEMAYBAY.MaGiay"
                    + " and YEAR(NgayLap) = ?"
                    + " group by hoadon.MaHoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(2);
            }
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public void in_ThongKe(int nam, int tongTien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBanGiayFinal";
            Connection con = DriverManager.getConnection(url, "admin1", "123");
            String file = "src\\Report\\rptDoanhThuTheoNam.jrxml";
            InputStream in = new FileInputStream(file);
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "select ROW_NUMBER() Over (Order by hoadon.MaHoaDon) as STT, hoadon.MaHoaDon, NgayLap, GiaBan, SoGheDat,"
                    + " (GiaBan * SoGheDat) as 'thanh tien',"
                    + " YEAR(NgayLap) as namNgayLap, GiaBan as tongTien,"
                    + " SoGheDat as slThuongGiaKhuHoi, SoGheDat as slThuongGiaMotChieu,"
                    + " SoGheDat as slPhoThongKhuHoi, SoGheDat as slPhoThongMotChieu"
                    + " from GIAY, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon "
                    + " and HOADONCHITIET.MaGiay = Giay.MaGiay"
                    + " and YEAR(NgayLap) = " + nam;
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            HashMap<String, Object> params = new HashMap<>();
            params.put("nam_NgayLap", nam);
            params.put("tongTien", tongTien);
            params.put("slThuongGiaKhuHoi", getSL_Ve(nam, "HV01", "LV01"));
            params.put("slThuongGiaMotChieu", getSL_Ve(nam, "HV01", "LV02"));
            params.put("slPhoThongKhuHoi", getSL_Ve(nam, "HV02", "LV01"));
            params.put("slPhoThongMotChieu", getSL_Ve(nam, "HV02", "LV02"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, con);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
