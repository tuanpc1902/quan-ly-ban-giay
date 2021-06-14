/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.getConnection;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JPanel;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * 
 */
public class DoanhThuTheoThangDAO extends getConnection {

    private int[] checkQuy(int quy) {
        int[] so = new int[3];
        switch (quy) {
            case 1:
                // 1, 2, 3
                so[0] = quy;
                so[1] = quy + 1;
                so[2] = quy + 2;
                break;
            case 2:
                //4, 5, 6
                so[0] = quy + 2;
                so[1] = quy + 3;
                so[2] = quy + 4;
                break;
            case 3:
                //7, 8, 9
                so[0] = quy + 4;
                so[1] = quy + 5;
                so[2] = quy + 6;
                break;
            case 4:
                //10, 11, 12
                so[0] = quy + 6;
                so[1] = quy + 7;
                so[2] = quy + 8;
                break;
        }
        return so;
    }

    public void loadTable_DoanhThu(JTable tbl, int quy, int nam) {
        try {
            int[] so = checkQuy(quy);
            String sql = "select ROW_NUMBER() Over (Order by hoadon.MaHoaDon), hoadon.MaHoaDon, NgayLap,"
                    + " GiaBan, SoGheDat,"
                    + " (GiaBan * SoGheDat)"
                    + " from Giay, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = GIAY.MaGiay"
                    + " and Month(NgayLap) in (?, ?, ?)"
                    + " and Year(NgayLap) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, so[0]);
            ps.setInt(2, so[1]);
            ps.setInt(3, so[2]);
            ps.setInt(4, nam);
            String[] header = new String[]{"STT", "Mã hóa đơn", "Ngày lập", "Giá bán (triệu)", "Số giày đặt", "Thành tiền (triệu)"};
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

    public int getTien(int quy, int nam) {
        try {
            int tong = 0;
            String sql = "select hoadon.MaHoaDon, SUM(GiaBan * SoGheDat)"
                    + " from GIAY, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = GIAY.MaGiay"
                    + " and MONTH(NgayLap) = ?"
                    + " and YEAR(NgayLap) = ?"
                    + " group by hoadon.MaHoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quy);
            ps.setInt(2, nam);
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

    public void loadChart(JPanel pnl, int quy, int nam) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int[] q = checkQuy(quy);
        for (int i = 0; i < q.length; i++) {
            dataset.setValue("Tháng " + q[i], getTien(q[i], nam));
        }
        JFreeChart chart = ChartFactory.createPieChart("Doanh thu quý", dataset, false, false, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(chartPanel, BorderLayout.CENTER);
        pnl.validate();
    }

    public int getSL_Ve(int quy, int nam, String maHang, String maLoai) {
        try {
            int[] so = checkQuy(quy);
            int tong = 0;
            String sql = "select COUNT(GIAY.MaGiay)"
                    + " from GIAY, HOADON, HOADONCHITIET"
                    + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = GIAY.MaGiay"
                    + " and MONTH(NgayLap) in (?, ?, ?)"
                    + " and YEAR(NgayLap) = ?"
                    + " and MaHangGiay = ?"
                    + " and MaSize = ?"
                    + " group by GIAY.MaGiay";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, so[0]);
            ps.setInt(2, so[1]);
            ps.setInt(3, so[2]);
            ps.setInt(4, nam);
            ps.setString(5, maHang);
            ps.setString(6, maLoai);
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

    public int getTongTien(int quy, int nam) {
        try {
            int tong = 0;
            int[] so = checkQuy(quy);
            for (int i = 0; i < 3; i++) {
                String sql = "select hoadon.MaHoaDon, SUM(GiaBan * SoGheDat)"
                        + " from GIAY, HOADON, HOADONCHITIET"
                        + " where HOADON.MaHoaDon = HOADONCHITIET.MaHoaDon"
                        + " and HOADONCHITIET.MaGiay = GIAY.MaGiay"
                        + " and MONTH(NgayLap) = ?"
                        + " and YEAR(NgayLap) = ?"
                        + " group by hoadon.MaHoaDon";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, so[i]);
                ps.setInt(2, nam);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    tong += rs.getInt(2);
                }
            }
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private int getTT(int thang, int nam) {
        try {
            int tong = 0;
            String sql = "select sum(GiaBan * SoGheDat) as thanhtien"
                    + " from HOADONCHITIET, HOADON, GIAY"
                    + " where HOADONCHITIET.MaHoaDon = HOADON.MaHoaDon"
                    + " and HOADONCHITIET.MaGiay = GIAY.MaGiay"
                    + " and MONTH(NgayLap) = ?"
                    + " and YEAR(NgayLap) = ?"
                    + " group by HOADON.MaHoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, thang);
            ps.setInt(2, nam);
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

    public void in_ThongKe(int quy, int nam, int tongTien) {
        try {
            int[] so = checkQuy(quy);
            String file = "src//Report//rptDoanhThuTheoThang.jrxml";
            InputStream in = new FileInputStream(file);
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "select ROW_NUMBER() Over (Order by HOADONCHITIET.MaHoaDon) as STT,"
                    + " SoGheDat as thangS1, SoGheDat as thangS2, SoGheDat as thangS3,"
                    + " SoGheDat as quyNam, SoGheDat as nam_NgayLap, GiaBan as tongTien,"
                    + " GiaBan as thanhTienS1, GiaBan as thanhTienS2, GiaBan as thanhTienS3,"
                    + " SoGheDat as slThuongGiaKhuHoi, SoGheDat as slThuongGiaMotChieu,"
                    + " SoGheDat as slPhoThongKhuHoi, SoGheDat as slPhoThongMotChieu"
                    + " from HOADONCHITIET, GIAY"
                    + " where HOADONCHITIET.MaGiay = GIAY.MaGiay";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            HashMap<String, Object> params = new HashMap<>();
            params.put("thangS1", so[0]);
            params.put("thangS2", so[1]);
            params.put("thangS3", so[2]);
            params.put("quyNam", quy);
            params.put("nam_NgayLap", nam);
            params.put("tongTien", tongTien);
            params.put("thanhTienS1", getTT(so[0], nam));
            params.put("thanhTienS2", getTT(so[1], nam));
            params.put("thanhTienS3", getTT(so[2], nam));
            params.put("slThuongGiaKhuHoi", getSL_Ve(quy, nam, "HV01", "LV01"));
            params.put("slThuongGiaMotChieu", getSL_Ve(quy, nam, "HV01", "LV02"));
            params.put("slPhoThongKhuHoi", getSL_Ve(quy, nam, "HV02", "LV01"));
            params.put("slPhoThongMotChieu", getSL_Ve(quy, nam, "HV02", "LV02"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, con);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
