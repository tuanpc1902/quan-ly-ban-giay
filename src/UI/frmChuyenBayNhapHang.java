/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.ChuyenBayDAO;
import DungChung.DungChung;
import DungChung.ExportExcel;
import DungChung.ExportPDF;
import Model.ChuyenBay;
import Model.QuanLyNhapHang;
import Model.TuyenBay;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class frmChuyenBayNhapHang extends javax.swing.JFrame {

    String chucVu = "";
    int showHide_TuyenBay = 1;
    int showHide_MayBay = 1;
    int showHide_NgayDi = 1;
    int showHide_NgayDen = 1;
    int hourTime = 0;
    int minuteTime = 0;
    int dong = -1;

    private void cbx_TuyenBay() {
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            int cao = 3;
            ArrayList<TuyenBay> arr_TB = new ChuyenBayDAO().layDS_TB();
            for (int i = 0; i < arr_TB.size(); i++) {
                JLabel lbl = new JLabel(arr_TB.get(i).getMaTuyenBay());
                lbl.setSize(pnlTuyenBay.getWidth(), 20);
                lbl.setLocation(10, cao);
                lbl.setName("lbl" + arr_TB.get(i).getMaTuyenBay());
                lbl.setForeground(Color.white);
                lbl.setFont(new Font("Segoe UI", 0, 14));
                lbl.setCursor(new Cursor(HAND_CURSOR));
                lbl.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                txtMaTuyenBay.setText(listLBL.get(i).getText());
                                pnlTuyenBay.setVisible(false);
                                showHide_TuyenBay++;
                            }
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                listLBL.get(i).setForeground(new Color(55, 38, 91));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                listLBL.get(i).setForeground(Color.white);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                });
                pnlTuyenBay.add(lbl);
                listLBL.add(lbl);
                cao += 20;
            }
            pnlTuyenBay.setPreferredSize(new Dimension(sptTuyenBay.getWidth(), listLBL.size() * 20 + 7));
            pnlTuyenBay.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cbx_MayBay() {
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            int cao = 3;
            ArrayList<QuanLyNhapHang> arr_MB = new ChuyenBayDAO().layDS_MB();
            for (int i = 0; i < arr_MB.size(); i++) {
                JLabel lbl = new JLabel(arr_MB.get(i).getMaMaybay());
                lbl.setSize(pnlMayBay.getWidth(), 20);
                lbl.setLocation(10, cao);
                lbl.setName("lbl" + arr_MB.get(i).getMaMaybay());
                lbl.setForeground(Color.white);
                lbl.setFont(new Font("Segoe UI", 0, 14));
                lbl.setCursor(new Cursor(HAND_CURSOR));
                lbl.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                txtMaMayBay.setText(listLBL.get(i).getText());
                                pnlMayBay.setVisible(false);
                                showHide_MayBay++;
                            }
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                listLBL.get(i).setForeground(new Color(55, 38, 91));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1];
                        for (int i = 0; i < listLBL.size(); i++) {
                            if (listLBL.get(i).getName().equals(str)) {
                                listLBL.get(i).setForeground(Color.white);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                });
                pnlMayBay.add(lbl);
                listLBL.add(lbl);
                cao += 20;
            }
            pnlMayBay.setPreferredSize(new Dimension(sptMayBay.getWidth(), listLBL.size() * 20 + 7));
            pnlMayBay.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showHideCBX_TuyenBay() {
        showHide_TuyenBay++;
        if (showHide_TuyenBay % 2 == 0) {
            pnlTuyenBay.setVisible(true);
        } else {
            pnlTuyenBay.setVisible(false);
        }
    }

    private void showHideCBX_MayBay() {
        showHide_MayBay++;
        if (showHide_MayBay % 2 == 0) {
            pnlMayBay.setVisible(true);
        } else {
            pnlMayBay.setVisible(false);
        }
    }

    private void showHideDate_NgayDi() {
        showHide_NgayDi++;
        if (showHide_NgayDi % 2 == 0) {
            dcplNgayDi.setVisible(true);
        } else {
            dcplNgayDi.setVisible(false);
        }
    }

    private void showHideDate_NgayDen() {
        showHide_NgayDen++;
        if (showHide_NgayDen % 2 == 0) {
            dcplNgayDen.setVisible(true);
        } else {
            dcplNgayDen.setVisible(false);
        }
    }

    private void hourTime(int so) {
        if (so == 1) {
            hourTime++;
            if (hourTime < 10) {
                txtHour.setText("0" + hourTime);
            } else if (hourTime > 23) {
                hourTime--;
                txtHour.setText(hourTime + "");
            } else {
                txtHour.setText(hourTime + "");
            }
        } else {
            hourTime--;
            if (hourTime < 0) {
                hourTime++;
                txtHour.setText("0" + hourTime);
            } else if (hourTime < 10) {
                txtHour.setText("0" + hourTime);
            } else {
                txtHour.setText(hourTime + "");
            }
        }
    }

    private void minuteTime(int so) {
        if (so == 1) {
            minuteTime++;
            if (minuteTime < 10) {
                txtMinute.setText("0" + minuteTime);
            } else if (minuteTime > 59) {
                minuteTime--;
                txtMinute.setText(minuteTime + "");
            } else {
                txtMinute.setText(minuteTime + "");
            }
        } else {
            minuteTime--;
            if (minuteTime < 0) {
                minuteTime++;
                txtMinute.setText("0" + minuteTime);
            } else if (minuteTime < 10) {
                txtMinute.setText("0" + minuteTime);
            } else {
                txtMinute.setText(minuteTime + "");
            }
        }
    }

    private void an() {
        new DungChung().hideLBLError(new JLabel[]{lblLoiMaCB, lblLoiNgayDi, lblLoiNgayDen, lblLoiGheThuongGia, lblLoiGhePhoThong, lblLoiTuyenBay, lblLoiMayBay});
    }

    private boolean check() {
        if (txtMaChuyenBay.getText().trim().isEmpty()) {
            lblLoiMaCB.setVisible(true);
            txtMaChuyenBay.requestFocus();
            return false;
        }
        if (txtNgayDi.getText().trim().isEmpty()) {
            lblLoiNgayDi.setVisible(true);
            txtNgayDi.requestFocus();
            return false;
        }
        if (txtNgayDen.getText().trim().isEmpty()) {
            lblLoiNgayDen.setVisible(true);
            txtNgayDen.requestFocus();
            return false;
        }
        if (txtMaTuyenBay.getText().trim().isEmpty()) {
            lblLoiTuyenBay.setVisible(true);
            txtMaTuyenBay.requestFocus();
            return false;
        }
        if (txtGheThuongGia.getText().trim().isEmpty() || Integer.parseInt(txtGheThuongGia.getText().trim()) <= 0) {
            lblLoiGheThuongGia.setVisible(true);
            txtGheThuongGia.requestFocus();
            return false;
        }
        if (txtGhePhoThong.getText().trim().isEmpty() || Integer.parseInt(txtGhePhoThong.getText().trim()) <= 0) {
            lblLoiGhePhoThong.setVisible(true);
            txtGhePhoThong.requestFocus();
            return false;
        }
        if (txtMaMayBay.getText().trim().isEmpty()) {
            lblLoiMayBay.setVisible(true);
            txtMaMayBay.requestFocus();
            return false;
        }
        return true;
    }

    private void moi() {
        new DungChung().reset(new JTextField[]{txtMaChuyenBay, txtNgayDi, txtNgayDen, txtGheThuongGia, txtGhePhoThong, txtMaTuyenBay, txtMaMayBay});
        an();
        lblSTT.setText("0");
        dong = -1;
        txtGheThuongGia.setText("0");
        txtGhePhoThong.setText("0");
    }

    private void bang() {
        new ChuyenBayDAO().loadTable(tblChuyenBay);
    }

    private void editColumnWidth() {
        int[] col = new int[]{40, 120, 115, 115, 110, 120, 120, 105, 105};
        new DungChung().editColumnWidth(col, tblChuyenBay);
    }

    private void them() {
        if (check()) {
            String macb = txtMaChuyenBay.getText().trim();
            String ngaydi = txtNgayDi.getText().trim();
            String ngayden = txtNgayDen.getText().trim();
            String gio = txtHour.getText().trim() + ":" + txtMinute.getText().trim() + ":00";
            String thuongia = txtGheThuongGia.getText().trim();
            String phothong = txtGhePhoThong.getText().trim();
            String tuyenbay = txtMaTuyenBay.getText().trim();
            String maybay = txtMaMayBay.getText().trim();
            int kt = new ChuyenBayDAO().them(new ChuyenBay(macb, ngaydi, ngayden, gio, Integer.parseInt(thuongia), Integer.parseInt(phothong), tuyenbay, maybay));
            if (kt == 1) {
                bang();
                ChuyenBay hk = new ChuyenBayDAO().timCBToDen(macb);
                for (int i = 0; i < tblChuyenBay.getRowCount(); i++) {
                    String ma = String.valueOf(tblChuyenBay.getValueAt(i, 1));
                    if (ma.equals(hk.getMaChuyenBay())) {
                        tblChuyenBay.setRowSelectionInterval(i, i);
                    }
                }
                moi();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại! Trùng khóa chính.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        editColumnWidth();
    }

    private void capNhat() {
        if (!txtMaChuyenBay.getText().isEmpty()) {
            String macb = txtMaChuyenBay.getText().trim();
            String ngaydi = txtNgayDi.getText().trim();
            String ngayden = txtNgayDen.getText().trim();
            String gio = txtHour.getText().trim() + ":" + txtMinute.getText().trim();
            String thuongia = txtGheThuongGia.getText().trim();
            String phothong = txtGhePhoThong.getText().trim();
            String tuyenbay = txtMaTuyenBay.getText().trim();
            String maybay = txtMaMayBay.getText().trim();
            int kt = new ChuyenBayDAO().sua(new ChuyenBay(macb, ngaydi, ngayden, gio, Integer.parseInt(thuongia), Integer.parseInt(phothong), tuyenbay, maybay));
            if (kt == 1) {
                bang();
                tblChuyenBay.setRowSelectionInterval(dong, dong);
                an();
                editColumnWidth();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void xoa() {
        if (dong >= 0) {
            int r = JOptionPane.showConfirmDialog(this, "Bạn cần xóa chuyến bay " + tblChuyenBay.getValueAt(dong, 1) + "?", "Thông báo", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                String macb = txtMaChuyenBay.getText().trim();
                int kt = new ChuyenBayDAO().xoa(new ChuyenBay(macb));
                if (kt == 1) {
                    bang();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        editColumnWidth();
    }

    private void hienThi(int row) {
        ChuyenBay cb = new ChuyenBay();
        new ChuyenBayDAO().hienThi(tblChuyenBay, cb, row);
        txtMaChuyenBay.setText(cb.getMaChuyenBay());
        txtNgayDi.setText(cb.getNgayDi());
        txtNgayDen.setText(cb.getNgayDen());
        String[] gio = cb.getGioKhoiHanh().split(":");
        hourTime = Integer.parseInt(gio[0]);
        minuteTime = Integer.parseInt(gio[1]);
        txtHour.setText(hourTime + "");
        txtMinute.setText(minuteTime + "");
        txtGheThuongGia.setText(cb.getSoGheThuongGia() + "");
        txtGhePhoThong.setText(cb.getSoGhePhoThong() + "");
        txtMaTuyenBay.setText(cb.getMaTuyenBay());
        txtMaMayBay.setText(cb.getMamayBay());
        txtMaChuyenBay.setEditable(false);
        if (hourTime < 10) {
            txtHour.setText("0" + hourTime);
        }
        if (minuteTime < 10) {
            txtMinute.setText("0" + minuteTime);
        }
        lblSTT.setText(String.valueOf(tblChuyenBay.getValueAt(dong, 0)));
    }

    private void exportExcel() {
        new ExportExcel().exportExcel("DANH SÁCH BẢNG CHUYẾN BAY", "Chuyến bay", tblChuyenBay, new int[]{1500, 5000, 5000, 6000, 5500, 5000, 5000, 5000, 5000});
        JOptionPane.showMessageDialog(this, "Xuất file excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportPDF() {
        new ExportPDF().exportPDF("DANH SÁCH BẢNG CHUYẾN BAY", tblChuyenBay);
        JOptionPane.showMessageDialog(this, "Xuất file pdf thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void chucNang(String str) {
        try {
            if (str.equals("dau")) {
                dong = 0;
            } else if (str.equals("cuoi")) {
                dong = tblChuyenBay.getRowCount() - 1;
            } else if (str.equals("pre")) {
                dong--;
                if (dong < 0) {
                    JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách!");
                    dong += 1;
                    return;
                }
            } else if (str.equals("next")) {
                dong++;
                if (dong >= tblChuyenBay.getRowCount()) {
                    JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách!");
                    dong -= 1;
                    return;
                }
            }

            tblChuyenBay.setRowSelectionInterval(dong, dong);
            lblSTT.setText(String.valueOf(tblChuyenBay.getValueAt(dong, 0)));
            hienThi(dong);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public frmChuyenBayNhapHang() {
        initComponents();
        setLocationRelativeTo(this);
        cbx_TuyenBay();
        cbx_MayBay();
        dcplNgayDi.setVisible(false);
        dcplNgayDen.setVisible(false);
        txtHour.setBackground(new Color(0, 0, 0, 0));
        txtHour.setText("0" + hourTime);
        txtMinute.setText("0" + minuteTime);
        new DungChung().transTXT(new JTextField[]{txtMaChuyenBay, txtNgayDi, txtNgayDen, txtGheThuongGia, txtGhePhoThong, txtMaTuyenBay, txtMaMayBay});
        an();
        bang();
        editColumnWidth();
        splTable.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
    }

    public frmChuyenBayNhapHang(String vt) {
        initComponents();
        setLocationRelativeTo(this);
        cbx_TuyenBay();
        cbx_MayBay();
        dcplNgayDi.setVisible(false);
        dcplNgayDen.setVisible(false);
        txtHour.setBackground(new Color(0, 0, 0, 0));
        txtHour.setText("0" + hourTime);
        txtMinute.setText("0" + minuteTime);
        new DungChung().transTXT(new JTextField[]{txtMaChuyenBay, txtNgayDi, txtNgayDen, txtGheThuongGia, txtGhePhoThong, txtMaTuyenBay, txtMaMayBay});
        an();
        bang();
        editColumnWidth();
        chucVu = vt;
        splTable.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnlTuyenBay = new javax.swing.JPanel();
        pnlMayBay = new javax.swing.JPanel();
        dcplNgayDi = new datechooser.beans.DateChooserPanel();
        dcplNgayDen = new datechooser.beans.DateChooserPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        lblLoiMaCB = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblLoiNgayDi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGheThuongGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblLoiNgayDen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGhePhoThong = new javax.swing.JTextField();
        lblLoiGhePhoThong = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lblLoiGheThuongGia = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaTuyenBay = new javax.swing.JTextField();
        sptTuyenBay = new javax.swing.JSeparator();
        lblLoiTuyenBay = new javax.swing.JLabel();
        txtMaMayBay = new javax.swing.JTextField();
        sptMayBay = new javax.swing.JSeparator();
        lblSTT = new javax.swing.JLabel();
        splTable = new javax.swing.JScrollPane();
        tblChuyenBay = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lblLoiMayBay = new javax.swing.JLabel();
        btnMayBay = new javax.swing.JLabel();
        txtMaChuyenBay = new javax.swing.JTextField();
        txtNgayDi = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtNgayDen = new javax.swing.JTextField();
        txtMinute = new javax.swing.JTextField();
        btnMinuteUp = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnHourUp = new javax.swing.JLabel();
        btnMinuteDown = new javax.swing.JLabel();
        btnHourDown = new javax.swing.JLabel();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnTuyenBay = new javax.swing.JButton();
        btnNgayDi = new javax.swing.JButton();
        btnNgayDen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTuyenBay.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlTuyenBayLayout = new javax.swing.GroupLayout(pnlTuyenBay);
        pnlTuyenBay.setLayout(pnlTuyenBayLayout);
        pnlTuyenBayLayout.setHorizontalGroup(
            pnlTuyenBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        pnlTuyenBayLayout.setVerticalGroup(
            pnlTuyenBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(pnlTuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        pnlMayBay.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlMayBayLayout = new javax.swing.GroupLayout(pnlMayBay);
        pnlMayBay.setLayout(pnlMayBayLayout);
        pnlMayBayLayout.setHorizontalGroup(
            pnlMayBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        pnlMayBayLayout.setVerticalGroup(
            pnlMayBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(pnlMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        dcplNgayDi.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dcplNgayDiOnSelectionChange(evt);
            }
        });
        dcplNgayDi.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcplNgayDiOnCommit(evt);
            }
        });
        jPanel2.add(dcplNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        dcplNgayDen.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dcplNgayDenOnSelectionChange(evt);
            }
        });
        jPanel2.add(dcplNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 38, 91));
        jLabel3.setText("QUẢN LÝ CHUYẾN BAY NHẬP GIÀY");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tìm kiếm");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiem.setOpaque(false);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        jPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 196, -1));

        lblLoiMaCB.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMaCB.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMaCB.setText("Mã chuyến bay không chinh xác");
        jPanel2.add(lblLoiMaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Mã chuyến bay");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Giờ khởi hành");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        lblLoiNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiNgayDi.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiNgayDi.setText("Chưa chọn ngày đi");
        jPanel2.add(lblLoiNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ngày đi");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        txtGheThuongGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGheThuongGia.setText("0");
        txtGheThuongGia.setBorder(null);
        txtGheThuongGia.setOpaque(false);
        txtGheThuongGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGheThuongGiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGheThuongGiaKeyTyped(evt);
            }
        });
        jPanel2.add(txtGheThuongGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 220, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Ngày đến");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        lblLoiNgayDen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiNgayDen.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiNgayDen.setText("Chưa chọn ngày đến");
        jPanel2.add(lblLoiNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Giày phổ thông");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, -1));

        txtGhePhoThong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGhePhoThong.setText("0");
        txtGhePhoThong.setBorder(null);
        txtGhePhoThong.setOpaque(false);
        txtGhePhoThong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGhePhoThongKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGhePhoThongKeyTyped(evt);
            }
        });
        jPanel2.add(txtGhePhoThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 220, 20));

        lblLoiGhePhoThong.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiGhePhoThong.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiGhePhoThong.setText("Ghế phổ thông không chính xác");
        jPanel2.add(lblLoiGhePhoThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 190, -1));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 220, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Giày cao cấp");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 220, 10));

        lblLoiGheThuongGia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiGheThuongGia.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiGheThuongGia.setText("Ghế thương gia không chính xác");
        jPanel2.add(lblLoiGheThuongGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 180, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Mã tuyến bay");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtMaTuyenBay.setEditable(false);
        txtMaTuyenBay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaTuyenBay.setBorder(null);
        txtMaTuyenBay.setOpaque(false);
        jPanel2.add(txtMaTuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 190, 20));
        jPanel2.add(sptTuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 220, 10));

        lblLoiTuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiTuyenBay.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiTuyenBay.setText("Chưa chọn mã tuyến bay");
        jPanel2.add(lblLoiTuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, -1));

        txtMaMayBay.setEditable(false);
        txtMaMayBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaMayBay.setBorder(null);
        txtMaMayBay.setOpaque(false);
        jPanel2.add(txtMaMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 190, 20));
        jPanel2.add(sptMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 220, 10));

        lblSTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSTT.setForeground(new java.awt.Color(55, 38, 91));
        lblSTT.setText("0");
        jPanel2.add(lblSTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, -1, -1));

        tblChuyenBay.setAutoCreateRowSorter(true);
        tblChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblChuyenBay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã chuyến bay", "Ngày đi", "Ngày đến", "Giờ khởi hành", "Giày cao cấp", "Giày phổ thông", "Mã tuyến bay", "Mã máy bay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblChuyenBay.setAutoscrolls(false);
        tblChuyenBay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblChuyenBay.setFocusable(false);
        tblChuyenBay.setGridColor(new java.awt.Color(255, 255, 255));
        tblChuyenBay.setOpaque(false);
        tblChuyenBay.setRequestFocusEnabled(false);
        tblChuyenBay.setRowHeight(30);
        tblChuyenBay.setRowMargin(0);
        tblChuyenBay.setSelectionBackground(new java.awt.Color(55, 38, 91));
        tblChuyenBay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblChuyenBay.setShowHorizontalLines(false);
        tblChuyenBay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenBayMouseClicked(evt);
            }
        });
        splTable.setViewportView(tblChuyenBay);

        jPanel2.add(splTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 950, 230));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Mã Nhập Hàng");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        lblLoiMayBay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMayBay.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMayBay.setText("Chưa chọn mã máy bay");
        jPanel2.add(lblLoiMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 150, -1));

        btnMayBay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnMayBay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMayBayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMayBayMouseEntered(evt);
            }
        });
        jPanel2.add(btnMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        txtMaChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaChuyenBay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaChuyenBay.setOpaque(false);
        txtMaChuyenBay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaChuyenBayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaChuyenBayKeyTyped(evt);
            }
        });
        jPanel2.add(txtMaChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 220, -1));

        txtNgayDi.setEditable(false);
        txtNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayDi.setBorder(null);
        txtNgayDi.setOpaque(false);
        jPanel2.add(txtNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 190, 20));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 220, 10));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 220, 10));

        txtNgayDen.setEditable(false);
        txtNgayDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayDen.setBorder(null);
        txtNgayDen.setOpaque(false);
        jPanel2.add(txtNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 190, 20));

        txtMinute.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMinute.setForeground(new java.awt.Color(255, 255, 255));
        txtMinute.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinute.setText("30");
        txtMinute.setBorder(null);
        txtMinute.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtMinute.setOpaque(false);
        txtMinute.setPreferredSize(new java.awt.Dimension(40, 40));
        txtMinute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinuteActionPerformed(evt);
            }
        });
        jPanel2.add(txtMinute, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        btnMinuteUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/choiceTime.png"))); // NOI18N
        btnMinuteUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinuteUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinuteUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinuteUpMouseExited(evt);
            }
        });
        jPanel2.add(btnMinuteUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/timeHour1.png"))); // NOI18N
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        txtHour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHour.setForeground(new java.awt.Color(255, 255, 255));
        txtHour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHour.setText("00");
        txtHour.setBorder(null);
        txtHour.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtHour.setOpaque(false);
        txtHour.setPreferredSize(new java.awt.Dimension(40, 40));
        txtHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHourActionPerformed(evt);
            }
        });
        jPanel2.add(txtHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/timeHour1.png"))); // NOI18N
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        btnHourUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/choiceTime.png"))); // NOI18N
        btnHourUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHourUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHourUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHourUpMouseExited(evt);
            }
        });
        jPanel2.add(btnHourUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        btnMinuteDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/choiceTimeDown.png"))); // NOI18N
        btnMinuteDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinuteDownMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinuteDownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinuteDownMouseExited(evt);
            }
        });
        jPanel2.add(btnMinuteDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        btnHourDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/choiceTimeDown.png"))); // NOI18N
        btnHourDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHourDownMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHourDownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHourDownMouseExited(evt);
            }
        });
        jPanel2.add(btnHourDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        btnMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonMoi.png"))); // NOI18N
        btnMoi.setBorder(null);
        btnMoi.setBorderPainted(false);
        btnMoi.setContentAreaFilled(false);
        btnMoi.setDefaultCapable(false);
        btnMoi.setFocusPainted(false);
        btnMoi.setFocusable(false);
        btnMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMoiMouseExited(evt);
            }
        });
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonXoa.png"))); // NOI18N
        btnXoa.setBorder(null);
        btnXoa.setBorderPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setDefaultCapable(false);
        btnXoa.setFocusPainted(false);
        btnXoa.setFocusable(false);
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoaMouseExited(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonCapNhat.png"))); // NOI18N
        btnCapNhat.setBorder(null);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setContentAreaFilled(false);
        btnCapNhat.setDefaultCapable(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setFocusable(false);
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseExited(evt);
            }
        });
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonThem.png"))); // NOI18N
        btnThem.setBorder(null);
        btnThem.setBorderPainted(false);
        btnThem.setContentAreaFilled(false);
        btnThem.setDefaultCapable(false);
        btnThem.setFocusPainted(false);
        btnThem.setFocusable(false);
        btnThem.setIconTextGap(0);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMouseExited(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonExcel.png"))); // NOI18N
        btnExcel.setBorder(null);
        btnExcel.setBorderPainted(false);
        btnExcel.setContentAreaFilled(false);
        btnExcel.setFocusPainted(false);
        btnExcel.setFocusable(false);
        btnExcel.setIconTextGap(0);
        btnExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcelMouseExited(evt);
            }
        });
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, -1, -1));

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonFPT.png"))); // NOI18N
        btnPDF.setBorder(null);
        btnPDF.setBorderPainted(false);
        btnPDF.setContentAreaFilled(false);
        btnPDF.setFocusPainted(false);
        btnPDF.setFocusable(false);
        btnPDF.setIconTextGap(0);
        btnPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPDFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPDFMouseExited(evt);
            }
        });
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        jPanel2.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 640, -1, -1));

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgDau.png"))); // NOI18N
        btnPre.setBorder(null);
        btnPre.setBorderPainted(false);
        btnPre.setContentAreaFilled(false);
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.setDefaultCapable(false);
        btnPre.setFocusPainted(false);
        btnPre.setFocusable(false);
        btnPre.setIconTextGap(0);
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPreMouseExited(evt);
            }
        });
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        jPanel2.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, -1, -1));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgPre.png"))); // NOI18N
        btnFirst.setBorder(null);
        btnFirst.setBorderPainted(false);
        btnFirst.setContentAreaFilled(false);
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.setDefaultCapable(false);
        btnFirst.setFocusPainted(false);
        btnFirst.setFocusable(false);
        btnFirst.setIconTextGap(0);
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstMouseExited(evt);
            }
        });
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel2.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, -1));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgNext.png"))); // NOI18N
        btnLast.setBorder(null);
        btnLast.setBorderPainted(false);
        btnLast.setContentAreaFilled(false);
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.setDefaultCapable(false);
        btnLast.setFocusPainted(false);
        btnLast.setFocusable(false);
        btnLast.setIconTextGap(0);
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastMouseExited(evt);
            }
        });
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel2.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, -1, -1));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgCuoi.png"))); // NOI18N
        btnNext.setBorder(null);
        btnNext.setBorderPainted(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setDefaultCapable(false);
        btnNext.setFocusPainted(false);
        btnNext.setFocusable(false);
        btnNext.setIconTextGap(0);
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel2.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, -1, -1));

        btnTuyenBay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnTuyenBay.setBorder(null);
        btnTuyenBay.setBorderPainted(false);
        btnTuyenBay.setContentAreaFilled(false);
        btnTuyenBay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTuyenBay.setDefaultCapable(false);
        btnTuyenBay.setFocusPainted(false);
        btnTuyenBay.setFocusable(false);
        btnTuyenBay.setIconTextGap(0);
        btnTuyenBay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuyenBayActionPerformed(evt);
            }
        });
        jPanel2.add(btnTuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        btnNgayDi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnNgayDi.setBorder(null);
        btnNgayDi.setBorderPainted(false);
        btnNgayDi.setContentAreaFilled(false);
        btnNgayDi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNgayDi.setDefaultCapable(false);
        btnNgayDi.setFocusPainted(false);
        btnNgayDi.setFocusable(false);
        btnNgayDi.setIconTextGap(0);
        btnNgayDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayDiActionPerformed(evt);
            }
        });
        jPanel2.add(btnNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        btnNgayDen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnNgayDen.setBorder(null);
        btnNgayDen.setBorderPainted(false);
        btnNgayDen.setContentAreaFilled(false);
        btnNgayDen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNgayDen.setDefaultCapable(false);
        btnNgayDen.setFocusPainted(false);
        btnNgayDen.setFocusable(false);
        btnNgayDen.setIconTextGap(0);
        btnNgayDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayDenActionPerformed(evt);
            }
        });
        jPanel2.add(btnNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaChuyenBayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaChuyenBayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChuyenBayKeyReleased

    private void btnMayBayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMayBayMouseClicked
        showHideCBX_MayBay();
        pnlTuyenBay.setVisible(false);
        dcplNgayDi.setVisible(false);
        dcplNgayDen.setVisible(false);
    }//GEN-LAST:event_btnMayBayMouseClicked

    private void btnMayBayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMayBayMouseEntered
        btnMayBay.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_btnMayBayMouseEntered

    private void dcplNgayDiOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcplNgayDiOnCommit

    }//GEN-LAST:event_dcplNgayDiOnCommit

    private void dcplNgayDiOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dcplNgayDiOnSelectionChange
        try {
            String s = String.valueOf(dcplNgayDi.getSelection()).substring(1, String.valueOf(dcplNgayDi.getSelection()).length() - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String d = sdf.format(new Date(s));
            txtNgayDi.setText(d);
            dcplNgayDi.setVisible(false);
            showHide_NgayDi++;
        } catch (Exception e) {
            dcplNgayDi.setVisible(false);
            showHide_NgayDi++;
        }
    }//GEN-LAST:event_dcplNgayDiOnSelectionChange

    private void dcplNgayDenOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dcplNgayDenOnSelectionChange
        try {
            String s = String.valueOf(dcplNgayDen.getSelection()).substring(1, String.valueOf(dcplNgayDen.getSelection()).length() - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String d = sdf.format(new Date(s));
            txtNgayDen.setText(d);
            dcplNgayDen.setVisible(false);
            showHide_NgayDen++;
        } catch (Exception e) {
            dcplNgayDen.setVisible(false);
            showHide_NgayDen++;
        }
    }//GEN-LAST:event_dcplNgayDenOnSelectionChange

    private void txtGheThuongGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGheThuongGiaKeyReleased
        new DungChung().xetSo(txtGheThuongGia);
    }//GEN-LAST:event_txtGheThuongGiaKeyReleased

    private void txtGhePhoThongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGhePhoThongKeyReleased
        new DungChung().xetSo(txtGhePhoThong);
    }//GEN-LAST:event_txtGhePhoThongKeyReleased

    private void btnHourUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourUpMouseClicked
        hourTime(1);
    }//GEN-LAST:event_btnHourUpMouseClicked

    private void btnHourUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourUpMouseEntered
        new DungChung().hoverButton(1, btnHourUp, "choiceTimeHover.png");
    }//GEN-LAST:event_btnHourUpMouseEntered

    private void btnHourUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourUpMouseExited
        new DungChung().hoverButton(2, btnHourUp, "choiceTime.png");
    }//GEN-LAST:event_btnHourUpMouseExited

    private void btnHourDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourDownMouseEntered
        new DungChung().hoverButton(1, btnHourDown, "choiceTimeDownHover.png");
    }//GEN-LAST:event_btnHourDownMouseEntered

    private void btnHourDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourDownMouseClicked
        hourTime(2);
    }//GEN-LAST:event_btnHourDownMouseClicked

    private void btnHourDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHourDownMouseExited
        new DungChung().hoverButton(2, btnHourDown, "choiceTimeDown.png");
    }//GEN-LAST:event_btnHourDownMouseExited

    private void btnMinuteUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteUpMouseClicked
        minuteTime(1);
    }//GEN-LAST:event_btnMinuteUpMouseClicked

    private void btnMinuteUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteUpMouseEntered
        new DungChung().hoverButton(1, btnMinuteUp, "choiceTimeHover.png");
    }//GEN-LAST:event_btnMinuteUpMouseEntered

    private void btnMinuteUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteUpMouseExited
        new DungChung().hoverButton(2, btnMinuteUp, "choiceTime.png");
    }//GEN-LAST:event_btnMinuteUpMouseExited

    private void btnMinuteDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteDownMouseClicked
        minuteTime(2);
    }//GEN-LAST:event_btnMinuteDownMouseClicked

    private void btnMinuteDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteDownMouseEntered
        new DungChung().hoverButton(1, btnMinuteDown, "choiceTimeDownHover.png");
    }//GEN-LAST:event_btnMinuteDownMouseEntered

    private void btnMinuteDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinuteDownMouseExited
        new DungChung().hoverButton(2, btnMinuteDown, "choiceTimeDown.png");
    }//GEN-LAST:event_btnMinuteDownMouseExited

    private void txtHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourActionPerformed
        hourTime = Integer.parseInt(txtHour.getText().trim());
        if (Integer.parseInt(txtHour.getText().trim()) > 23 || Integer.parseInt(txtHour.getText().trim()) < 0) {
            hourTime = 0;
            txtHour.setText("0" + hourTime);
        }
    }//GEN-LAST:event_txtHourActionPerformed

    private void txtMinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinuteActionPerformed
        minuteTime = Integer.parseInt(txtMinute.getText().trim());
        if (Integer.parseInt(txtMinute.getText().trim()) > 59 || Integer.parseInt(txtMinute.getText().trim()) < 0) {
            minuteTime = 0;
            txtMinute.setText("0" + minuteTime);
        }
    }//GEN-LAST:event_txtMinuteActionPerformed

    private void tblChuyenBayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenBayMouseClicked
        txtTimKiem.setText(null);
        dong = tblChuyenBay.getSelectedRow();
        hienThi(dong);
    }//GEN-LAST:event_tblChuyenBayMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        new ChuyenBayDAO().tim(tblChuyenBay, txtTimKiem.getText().trim());
        editColumnWidth();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseEntered
        new DungChung().hoverButton5(1, btnMoi, "bgButtonMoiHover.png");
    }//GEN-LAST:event_btnMoiMouseEntered

    private void btnMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseExited
        new DungChung().hoverButton5(2, btnMoi, "bgButtonMoi.png");
    }//GEN-LAST:event_btnMoiMouseExited

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        moi();
        tblChuyenBay.clearSelection();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseEntered
        new DungChung().hoverButton5(1, btnXoa, "bgButtonXoaHover.png");
    }//GEN-LAST:event_btnXoaMouseEntered

    private void btnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseExited
        new DungChung().hoverButton5(2, btnXoa, "bgButtonXoa.png");
    }//GEN-LAST:event_btnXoaMouseExited

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (chucVu.equals("Trưởng phòng")) {
            xoa();
        } else {
            JOptionPane.showMessageDialog(this, "Chỉ admin được phép xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseEntered
        new DungChung().hoverButton5(1, btnCapNhat, "bgButtonCapNhatHover.png");
    }//GEN-LAST:event_btnCapNhatMouseEntered

    private void btnCapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseExited
        new DungChung().hoverButton5(2, btnCapNhat, "bgButtonCapNhat.png");
    }//GEN-LAST:event_btnCapNhatMouseExited

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (tblChuyenBay.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Chọn chuyến bay cần cập nhật.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            capNhat();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        new DungChung().hoverButton5(1, btnThem, "bgButtonThemHover.png");
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        new DungChung().hoverButton5(2, btnThem, "bgButtonThem.png");
    }//GEN-LAST:event_btnThemMouseExited

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseEntered
        new DungChung().hoverButton5(1, btnExcel, "bgButtonExcelHover.png");
    }//GEN-LAST:event_btnExcelMouseEntered

    private void btnExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseExited
        new DungChung().hoverButton5(2, btnExcel, "bgButtonExcel.png");
    }//GEN-LAST:event_btnExcelMouseExited

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        exportExcel();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseEntered
        new DungChung().hoverButton5(1, btnPDF, "bgButtonFPTHover.png");
    }//GEN-LAST:event_btnPDFMouseEntered

    private void btnPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseExited
        new DungChung().hoverButton5(2, btnPDF, "bgButtonFPT.png");
    }//GEN-LAST:event_btnPDFMouseExited

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        exportPDF();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnPreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseEntered
        new DungChung().hoverButton5(1, btnPre, "bgDauHover.png");
    }//GEN-LAST:event_btnPreMouseEntered

    private void btnPreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseExited
        new DungChung().hoverButton5(2, btnPre, "bgDau.png");
    }//GEN-LAST:event_btnPreMouseExited

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        chucNang("dau");
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseEntered
        new DungChung().hoverButton5(1, btnFirst, "bgPreHover.png");
    }//GEN-LAST:event_btnFirstMouseEntered

    private void btnFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseExited
        new DungChung().hoverButton5(2, btnFirst, "bgPre.png");
    }//GEN-LAST:event_btnFirstMouseExited

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        chucNang("pre");
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseEntered
        new DungChung().hoverButton5(1, btnLast, "bgNextHover.png");
    }//GEN-LAST:event_btnLastMouseEntered

    private void btnLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseExited
        new DungChung().hoverButton5(2, btnLast, "bgNext.png");
    }//GEN-LAST:event_btnLastMouseExited

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        chucNang("next");
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        new DungChung().hoverButton5(1, btnNext, "bgCuoiHover.png");
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        new DungChung().hoverButton5(2, btnNext, "bgCuoi.png");
    }//GEN-LAST:event_btnNextMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        chucNang("cuoi");
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtMaChuyenBayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaChuyenBayKeyTyped
        if (txtMaChuyenBay.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaChuyenBayKeyTyped

    private void txtGheThuongGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGheThuongGiaKeyTyped
        if (txtGheThuongGia.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGheThuongGiaKeyTyped

    private void txtGhePhoThongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGhePhoThongKeyTyped
        if (txtGhePhoThong.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGhePhoThongKeyTyped

    private void btnTuyenBayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuyenBayActionPerformed
        showHideCBX_TuyenBay();
        dcplNgayDi.setVisible(false);
        dcplNgayDen.setVisible(false);
        pnlMayBay.setVisible(false);
    }//GEN-LAST:event_btnTuyenBayActionPerformed

    private void btnNgayDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayDiActionPerformed
        showHideDate_NgayDi();
        pnlTuyenBay.setVisible(false);
        dcplNgayDen.setVisible(false);
        pnlMayBay.setVisible(false);
    }//GEN-LAST:event_btnNgayDiActionPerformed

    private void btnNgayDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayDenActionPerformed
        showHideDate_NgayDen();
        pnlTuyenBay.setVisible(false);
        dcplNgayDi.setVisible(false);
        pnlMayBay.setVisible(false);
    }//GEN-LAST:event_btnNgayDenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmChuyenBayNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChuyenBayNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChuyenBayNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChuyenBayNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChuyenBayNhapHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JLabel btnHourDown;
    private javax.swing.JLabel btnHourUp;
    private javax.swing.JButton btnLast;
    private javax.swing.JLabel btnMayBay;
    private javax.swing.JLabel btnMinuteDown;
    private javax.swing.JLabel btnMinuteUp;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNgayDen;
    private javax.swing.JButton btnNgayDi;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTuyenBay;
    private javax.swing.JButton btnXoa;
    private datechooser.beans.DateChooserPanel dcplNgayDen;
    private datechooser.beans.DateChooserPanel dcplNgayDi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblLoiGhePhoThong;
    private javax.swing.JLabel lblLoiGheThuongGia;
    private javax.swing.JLabel lblLoiMaCB;
    private javax.swing.JLabel lblLoiMayBay;
    private javax.swing.JLabel lblLoiNgayDen;
    private javax.swing.JLabel lblLoiNgayDi;
    private javax.swing.JLabel lblLoiTuyenBay;
    private javax.swing.JLabel lblSTT;
    private javax.swing.JPanel pnlMayBay;
    private javax.swing.JPanel pnlTuyenBay;
    private javax.swing.JScrollPane splTable;
    private javax.swing.JSeparator sptMayBay;
    private javax.swing.JSeparator sptTuyenBay;
    private javax.swing.JTable tblChuyenBay;
    private javax.swing.JTextField txtGhePhoThong;
    private javax.swing.JTextField txtGheThuongGia;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtMaChuyenBay;
    private javax.swing.JTextField txtMaMayBay;
    private javax.swing.JTextField txtMaTuyenBay;
    private javax.swing.JTextField txtMinute;
    private javax.swing.JTextField txtNgayDen;
    private javax.swing.JTextField txtNgayDi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
