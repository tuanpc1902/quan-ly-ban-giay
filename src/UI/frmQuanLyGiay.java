/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.QuanLyGiayDAO;
import DungChung.DungChung;
import DungChung.ExportExcel;
import DungChung.ExportPDF;
import Model.ChuyenBay;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import Model.HangVe;
import Model.LoaiVe;
import Model.QuanLyGiay;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author TuanDuc
 */
public class frmQuanLyGiay extends javax.swing.JFrame {

    String chucVu = "";
    int showHide_HV = 1;
    int showHide_LV = 1;
    int showHide_CB = 1;
    int dong = -1;

    private void cbx_HV() {
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            int cao = 3;
            ArrayList<HangVe> arr_HV = new QuanLyGiayDAO().layDS_HV();
            for (int i = 0; i < arr_HV.size(); i++) {
                JLabel lbl = new JLabel(arr_HV.get(i).getMaHangVe() + " - " + arr_HV.get(i).getTenHangVe());
                lbl.setSize(pnlhangVe.getWidth(), 20);
                lbl.setLocation(10, cao);
                lbl.setName("lbl" + arr_HV.get(i).getMaHangVe());
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
                                txtHangVe.setText(listLBL.get(i).getText());
                                pnlhangVe.setVisible(false);
                                showHide_HV++;
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
                pnlhangVe.add(lbl);
                listLBL.add(lbl);
                cao += 20;
            }
            pnlhangVe.setPreferredSize(new Dimension(sptHangVe.getWidth(), listLBL.size() * 20 + 7));
            pnlhangVe.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cbx_LV() {
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            int cao = 3;
            ArrayList<LoaiVe> arr_HV = new QuanLyGiayDAO().layDS_LV();
            for (int i = 0; i < arr_HV.size(); i++) {
                JLabel lbl = new JLabel(arr_HV.get(i).getMaLoaiVe() + " - " + arr_HV.get(i).getTenLoaiVe());
                lbl.setSize(pnlLoaiVe.getWidth(), 20);
                lbl.setLocation(10, cao);
                lbl.setName("lbl" + arr_HV.get(i).getMaLoaiVe());
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
                                txtMaLoaiVe.setText(listLBL.get(i).getText());
                                pnlLoaiVe.setVisible(false);
                                showHide_LV++;
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
                pnlLoaiVe.add(lbl);
                listLBL.add(lbl);
                cao += 20;
            }
            pnlLoaiVe.setPreferredSize(new Dimension(sptLoaiVe.getWidth(), listLBL.size() * 20 + 7));
            pnlLoaiVe.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cbx_CB() {
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            int cao = 3;
            ArrayList<ChuyenBay> arr_CB = new QuanLyGiayDAO().layDS_CB();
            for (int i = 0; i < arr_CB.size(); i++) {
                JLabel lbl = new JLabel(arr_CB.get(i).getMaChuyenBay());
                lbl.setSize(pnlChuyenBay.getWidth(), 20);
                lbl.setLocation(10, cao);
                lbl.setName("lbl" + arr_CB.get(i).getMaChuyenBay());
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
                                txtMaChuyenBay.setText(listLBL.get(i).getText());
                                pnlChuyenBay.setVisible(false);
                                showHide_CB++;
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
                pnlChuyenBay.add(lbl);
                listLBL.add(lbl);
                cao += 20;
            }
            pnlChuyenBay.setPreferredSize(new Dimension(sptChuyenBay.getWidth(), listLBL.size() * 20 + 7));
            pnlChuyenBay.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showHideCBX_HV() {
        showHide_HV++;
        if (showHide_HV % 2 == 0) {
            pnlhangVe.setVisible(true);
        } else {
            pnlhangVe.setVisible(false);
        }
    }

    private void showHideCBX_LV() {
        showHide_LV++;
        if (showHide_LV % 2 == 0) {
            pnlLoaiVe.setVisible(true);
        } else {
            pnlLoaiVe.setVisible(false);
        }
    }

    private void showHideCBX_CB() {
        showHide_CB++;
        if (showHide_CB % 2 == 0) {
            pnlChuyenBay.setVisible(true);
        } else {
            pnlChuyenBay.setVisible(false);
        }
    }

    private void an() {
        new DungChung().hideLBLError(new JLabel[]{lblLoiMaVe, lblLoiMaHangVe, lblLoiMaLoai, lblLoiMaChuyenBay, lblLoiGiaBan});
    }

    private boolean check() {
        JLabel[] lbl = new JLabel[]{lblLoiMaVe, lblLoiMaHangVe, lblLoiMaLoai, lblLoiMaChuyenBay, lblLoiGiaBan};
        JTextField[] txt = new JTextField[]{txtMaVeMayBay, txtHangVe, txtMaLoaiVe, txtMaChuyenBay, txtGiaBan};
        return new DungChung().check(lbl, txt);
    }

    private void moi() {
        new DungChung().reset(new JTextField[]{txtMaVeMayBay, txtHangVe, txtMaLoaiVe, txtMaChuyenBay, txtGiaBan});
        an();
        lblSTT.setText("0");
        dong = -1;
        txtGiaBan.setText("0");
    }

    private void bang() {
        new QuanLyGiayDAO().loadTable(tblVeMB);
    }

    private void editColumnWidth() {
        int[] col = new int[]{40, 180, 180, 180, 180, 180};
        new DungChung().editColumnWidth(col, tblVeMB);
    }

    private void them() {
        if (check()) {
            String mave = txtMaVeMayBay.getText().trim();
            String[] hang = txtHangVe.getText().trim().split("-");
            String mahang = hang[0].trim();
            String[] loai = txtMaLoaiVe.getText().trim().split("-");
            String maloai = loai[0].trim();
            String machuyenbay = txtMaChuyenBay.getText().trim();
            String gia = txtGiaBan.getText().trim();
            float giaf = Float.parseFloat(gia);
            int kt = new QuanLyGiayDAO().them(new QuanLyGiay(mave, mahang, maloai, machuyenbay, giaf));
            if (kt == 1) {
                bang();
                QuanLyGiay vmb = new QuanLyGiayDAO().timDVToDen(mave);
                for (int i = 0; i < tblVeMB.getRowCount(); i++) {
                    String id = String.valueOf(tblVeMB.getValueAt(i, 1));
                    if (id.equals(vmb.getMaGiay())) {
                        tblVeMB.setRowSelectionInterval(i, i);
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
        if (!txtMaVeMayBay.getText().isEmpty()) {
            String mave = txtMaVeMayBay.getText().trim();
            String[] hang = txtHangVe.getText().trim().split("-");
            String mahang = hang[0].trim();
            String[] loai = txtMaLoaiVe.getText().trim().split("-");
            String maloai = loai[0].trim();
            String machuyenbay = txtMaChuyenBay.getText().trim();
            String gia = txtGiaBan.getText().trim();
            float giaf = Float.parseFloat(gia);
            int kt = new QuanLyGiayDAO().sua(new QuanLyGiay(mave, mahang, maloai, machuyenbay, giaf));
            if (kt == 1) {
                bang();
                tblVeMB.setRowSelectionInterval(dong, dong);
                an();
                editColumnWidth();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void xoa() {
        if (dong >= 0) {
            int r = JOptionPane.showConfirmDialog(this, "Bạn cần xóa vé " + tblVeMB.getValueAt(dong, 1) + "?", "Thông báo", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                String mave = txtMaVeMayBay.getText().trim();
                int kt = new QuanLyGiayDAO().xoa(new QuanLyGiay(mave));
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
        QuanLyGiay vmb = new QuanLyGiay();
        new QuanLyGiayDAO().hienThi(tblVeMB, vmb, row);
        txtMaVeMayBay.setText(vmb.getMaGiay());
        txtHangVe.setText(vmb.getMaGiay());
        txtMaLoaiVe.setText(vmb.getMaGiay());
        txtMaChuyenBay.setText(vmb.getMaChuyenBay());
        txtGiaBan.setText(vmb.getGiaBan() + "");
        txtMaVeMayBay.setEditable(false);
        lblSTT.setText(String.valueOf(tblVeMB.getValueAt(dong, 0)));
    }

    private void exportExcel() {
        new ExportExcel().exportExcel("DANH SÁCH BẢNG VÉ MÁY BAY", "Vé máy bay", tblVeMB, new int[]{1500, 5000, 5000, 6000, 5500, 5000});
        JOptionPane.showMessageDialog(this, "Xuất file excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportPDF() {
        new ExportPDF().exportPDF("DANH SÁCH BẢNG VÉ MÁY BAY", tblVeMB);
        JOptionPane.showMessageDialog(this, "Xuất file pdf thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void chucNang(String str) {
        try {
            if (str.equals("dau")) {
                dong = 0;
            } else if (str.equals("cuoi")) {
                dong = tblVeMB.getRowCount() - 1;
            } else if (str.equals("pre")) {
                dong--;
                if (dong < 0) {
                    JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách!");
                    dong += 1;
                    return;
                }
            } else if (str.equals("next")) {
                dong++;
                if (dong >= tblVeMB.getRowCount()) {
                    JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách!");
                    dong -= 1;
                    return;
                }
            }

            tblVeMB.setRowSelectionInterval(dong, dong);
            lblSTT.setText(String.valueOf(tblVeMB.getValueAt(dong, 0)));
            hienThi(dong);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public frmQuanLyGiay() {
        initComponents();
        setLocationRelativeTo(this);
        cbx_HV();
        cbx_LV();
        cbx_CB();
        new DungChung().transTXT(new JTextField[]{txtMaVeMayBay, txtHangVe, txtMaLoaiVe, txtMaChuyenBay, txtGiaBan, txtTimKiem});
        an();
        bang();
        editColumnWidth();
        splTable.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
    }

    public frmQuanLyGiay(String vt) {
        initComponents();
        setLocationRelativeTo(this);
        cbx_HV();
        cbx_LV();
        cbx_CB();
        new DungChung().transTXT(new JTextField[]{txtMaVeMayBay, txtHangVe, txtMaLoaiVe, txtMaChuyenBay, txtGiaBan, txtTimKiem});
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

        jPanel1 = new javax.swing.JPanel();
        pnlhangVe = new javax.swing.JPanel();
        pnlLoaiVe = new javax.swing.JPanel();
        pnlChuyenBay = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaVeMayBay = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHangVe = new javax.swing.JTextField();
        sptHangVe = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaLoaiVe = new javax.swing.JTextField();
        sptLoaiVe = new javax.swing.JSeparator();
        txtGiaBan = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtMaChuyenBay = new javax.swing.JTextField();
        sptChuyenBay = new javax.swing.JSeparator();
        lblSTT = new javax.swing.JLabel();
        lblLoiMaVe = new javax.swing.JLabel();
        lblLoiMaLoai = new javax.swing.JLabel();
        lblLoiMaHangVe = new javax.swing.JLabel();
        lblLoiMaChuyenBay = new javax.swing.JLabel();
        lblLoiGiaBan = new javax.swing.JLabel();
        splTable = new javax.swing.JScrollPane();
        tblVeMB = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLoaiVe = new javax.swing.JButton();
        btnHangVe = new javax.swing.JButton();
        btnChuyenBay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlhangVe.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlhangVeLayout = new javax.swing.GroupLayout(pnlhangVe);
        pnlhangVe.setLayout(pnlhangVeLayout);
        pnlhangVeLayout.setHorizontalGroup(
            pnlhangVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        pnlhangVeLayout.setVerticalGroup(
            pnlhangVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(pnlhangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        pnlLoaiVe.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlLoaiVeLayout = new javax.swing.GroupLayout(pnlLoaiVe);
        pnlLoaiVe.setLayout(pnlLoaiVeLayout);
        pnlLoaiVeLayout.setHorizontalGroup(
            pnlLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        pnlLoaiVeLayout.setVerticalGroup(
            pnlLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(pnlLoaiVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        pnlChuyenBay.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlChuyenBayLayout = new javax.swing.GroupLayout(pnlChuyenBay);
        pnlChuyenBay.setLayout(pnlChuyenBayLayout);
        pnlChuyenBayLayout.setHorizontalGroup(
            pnlChuyenBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        pnlChuyenBayLayout.setVerticalGroup(
            pnlChuyenBayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("QUẢN LÝ GIÀY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tìm kiếm");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiem.setOpaque(false);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 196, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã giày");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txtMaVeMayBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaVeMayBay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaVeMayBay.setOpaque(false);
        txtMaVeMayBay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaVeMayBayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaVeMayBayKeyTyped(evt);
            }
        });
        jPanel1.add(txtMaVeMayBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 360, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Mã chuyến bay");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, -1));

        txtHangVe.setEditable(false);
        txtHangVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHangVe.setBorder(null);
        txtHangVe.setOpaque(false);
        jPanel1.add(txtHangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 360, -1));
        jPanel1.add(sptHangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 390, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Mã hạng giày");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Size giày");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtMaLoaiVe.setEditable(false);
        txtMaLoaiVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaLoaiVe.setBorder(null);
        txtMaLoaiVe.setOpaque(false);
        txtMaLoaiVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiVeActionPerformed(evt);
            }
        });
        txtMaLoaiVe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaLoaiVeKeyReleased(evt);
            }
        });
        jPanel1.add(txtMaLoaiVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 330, -1));
        jPanel1.add(sptLoaiVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 360, 10));

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaBan.setText("0");
        txtGiaBan.setBorder(null);
        txtGiaBan.setOpaque(false);
        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyTyped(evt);
            }
        });
        jPanel1.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 320, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 360, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Giá bán");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtMaChuyenBay.setEditable(false);
        txtMaChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaChuyenBay.setBorder(null);
        txtMaChuyenBay.setOpaque(false);
        jPanel1.add(txtMaChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 360, 20));
        jPanel1.add(sptChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 390, 10));

        lblSTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSTT.setForeground(new java.awt.Color(55, 38, 91));
        lblSTT.setText("0");
        jPanel1.add(lblSTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, -1, -1));

        lblLoiMaVe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMaVe.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMaVe.setText("Mã vé máy bay không chính xác");
        jPanel1.add(lblLoiMaVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 220, -1));

        lblLoiMaLoai.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMaLoai.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMaLoai.setText("Loại vé không chính xác");
        jPanel1.add(lblLoiMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 190, -1));

        lblLoiMaHangVe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMaHangVe.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMaHangVe.setText("Hạng vé không chính xác");
        jPanel1.add(lblLoiMaHangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 160, -1));

        lblLoiMaChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiMaChuyenBay.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiMaChuyenBay.setText("Mã chuyến bay không chính xác");
        jPanel1.add(lblLoiMaChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 200, -1));

        lblLoiGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLoiGiaBan.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiGiaBan.setText("GIá không chính xác");
        jPanel1.add(lblLoiGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, -1));

        tblVeMB.setAutoCreateRowSorter(true);
        tblVeMB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVeMB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã giày", "Mã hạng giày", "Size giày", "Mã chuyến bay", "Giá bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblVeMB.setAutoscrolls(false);
        tblVeMB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblVeMB.setFocusable(false);
        tblVeMB.setGridColor(new java.awt.Color(255, 255, 255));
        tblVeMB.setOpaque(false);
        tblVeMB.setRequestFocusEnabled(false);
        tblVeMB.setRowHeight(30);
        tblVeMB.setRowMargin(0);
        tblVeMB.setSelectionBackground(new java.awt.Color(55, 38, 91));
        tblVeMB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVeMB.setShowHorizontalLines(false);
        tblVeMB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeMBMouseClicked(evt);
            }
        });
        splTable.setViewportView(tblVeMB);

        jPanel1.add(splTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 920, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Triệu");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

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
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

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
        jPanel1.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

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
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

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
        jPanel1.add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

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
        jPanel1.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, -1, -1));

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
        jPanel1.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 640, -1, -1));

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
        jPanel1.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, -1, -1));

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
        jPanel1.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, -1));

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
        jPanel1.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, -1, -1));

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
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, -1, -1));

        btnLoaiVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnLoaiVe.setBorder(null);
        btnLoaiVe.setBorderPainted(false);
        btnLoaiVe.setContentAreaFilled(false);
        btnLoaiVe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoaiVe.setDefaultCapable(false);
        btnLoaiVe.setFocusPainted(false);
        btnLoaiVe.setFocusable(false);
        btnLoaiVe.setIconTextGap(0);
        btnLoaiVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnLoaiVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        btnHangVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnHangVe.setBorder(null);
        btnHangVe.setBorderPainted(false);
        btnHangVe.setContentAreaFilled(false);
        btnHangVe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHangVe.setDefaultCapable(false);
        btnHangVe.setFocusPainted(false);
        btnHangVe.setFocusable(false);
        btnHangVe.setIconTextGap(0);
        btnHangVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, -1, -1));

        btnChuyenBay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnChuyenBay.setBorder(null);
        btnChuyenBay.setBorderPainted(false);
        btnChuyenBay.setContentAreaFilled(false);
        btnChuyenBay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenBay.setDefaultCapable(false);
        btnChuyenBay.setFocusPainted(false);
        btnChuyenBay.setFocusable(false);
        btnChuyenBay.setIconTextGap(0);
        btnChuyenBay.setInheritsPopupMenu(true);
        btnChuyenBay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenBayActionPerformed(evt);
            }
        });
        jPanel1.add(btnChuyenBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        chucNang("cuoi");
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        new DungChung().hoverButton5(2, btnNext, "bgCuoi.png");
    }//GEN-LAST:event_btnNextMouseExited

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        new DungChung().hoverButton5(1, btnNext, "bgCuoiHover.png");
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        chucNang("next");
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseExited
        new DungChung().hoverButton5(2, btnLast, "bgNext.png");
    }//GEN-LAST:event_btnLastMouseExited

    private void btnLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseEntered
        new DungChung().hoverButton5(1, btnLast, "bgNextHover.png");
    }//GEN-LAST:event_btnLastMouseEntered

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        chucNang("pre");
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseExited
        new DungChung().hoverButton5(2, btnFirst, "bgPre.png");
    }//GEN-LAST:event_btnFirstMouseExited

    private void btnFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseEntered
        new DungChung().hoverButton5(1, btnFirst, "bgPreHover.png");
    }//GEN-LAST:event_btnFirstMouseEntered

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        chucNang("dau");
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnPreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseExited
        new DungChung().hoverButton5(2, btnPre, "bgDau.png");
    }//GEN-LAST:event_btnPreMouseExited

    private void btnPreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseEntered
        new DungChung().hoverButton5(1, btnPre, "bgDauHover.png");
    }//GEN-LAST:event_btnPreMouseEntered

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        exportPDF();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseExited
        new DungChung().hoverButton5(2, btnPDF, "bgButtonFPT.png");
    }//GEN-LAST:event_btnPDFMouseExited

    private void btnPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseEntered
        new DungChung().hoverButton5(1, btnPDF, "bgButtonFPTHover.png");
    }//GEN-LAST:event_btnPDFMouseEntered

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        exportExcel();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseExited
        new DungChung().hoverButton5(2, btnExcel, "bgButtonExcel.png");
    }//GEN-LAST:event_btnExcelMouseExited

    private void btnExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseEntered
        new DungChung().hoverButton5(1, btnExcel, "bgButtonExcelHover.png");
    }//GEN-LAST:event_btnExcelMouseEntered

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        moi();
        tblVeMB.clearSelection();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseExited
        new DungChung().hoverButton5(2, btnMoi, "bgButtonMoi.png");
    }//GEN-LAST:event_btnMoiMouseExited

    private void btnMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseEntered
        new DungChung().hoverButton5(1, btnMoi, "bgButtonMoiHover.png");
    }//GEN-LAST:event_btnMoiMouseEntered

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (chucVu.equals("Trưởng phòng")) {
            xoa();
        } else {
            JOptionPane.showMessageDialog(this, "Chỉ admin được phép xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseExited
        new DungChung().hoverButton5(2, btnXoa, "bgButtonXoa.png");
    }//GEN-LAST:event_btnXoaMouseExited

    private void btnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseEntered
        new DungChung().hoverButton5(1, btnXoa, "bgButtonXoaHover.png");
    }//GEN-LAST:event_btnXoaMouseEntered

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (tblVeMB.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Chọn vé cần cập nhật.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            capNhat();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnCapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseExited
        new DungChung().hoverButton5(2, btnCapNhat, "bgButtonCapNhat.png");
    }//GEN-LAST:event_btnCapNhatMouseExited

    private void btnCapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseEntered
        new DungChung().hoverButton5(1, btnCapNhat, "bgButtonCapNhatHover.png");
    }//GEN-LAST:event_btnCapNhatMouseEntered

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        new DungChung().hoverButton5(2, btnThem, "bgButtonThem.png");
    }//GEN-LAST:event_btnThemMouseExited

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
        new DungChung().hoverButton5(1, btnThem, "bgButtonThemHover.png");
    }//GEN-LAST:event_btnThemMouseEntered

    private void tblVeMBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeMBMouseClicked
        txtTimKiem.setText(null);
        dong = tblVeMB.getSelectedRow();
        hienThi(dong);
    }//GEN-LAST:event_tblVeMBMouseClicked

    private void txtGiaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyReleased
        new DungChung().xetSo(txtGiaBan);
    }//GEN-LAST:event_txtGiaBanKeyReleased

    private void txtMaLoaiVeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLoaiVeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiVeKeyReleased

    private void txtMaVeMayBayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaVeMayBayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaVeMayBayKeyReleased

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        new QuanLyGiayDAO().tim(tblVeMB, txtTimKiem.getText().trim());
        editColumnWidth();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtGiaBanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyTyped
        if (txtGiaBan.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGiaBanKeyTyped

    private void txtMaVeMayBayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaVeMayBayKeyTyped
        if (txtMaVeMayBay.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaVeMayBayKeyTyped

    private void btnLoaiVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiVeActionPerformed
        showHideCBX_LV();
        pnlhangVe.setVisible(false);
        pnlChuyenBay.setVisible(false);
    }//GEN-LAST:event_btnLoaiVeActionPerformed

    private void btnHangVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangVeActionPerformed
        showHideCBX_HV();
        pnlLoaiVe.setVisible(false);
        pnlChuyenBay.setVisible(false);
    }//GEN-LAST:event_btnHangVeActionPerformed

    private void btnChuyenBayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenBayActionPerformed
        showHideCBX_CB();
        pnlhangVe.setVisible(false);
        pnlLoaiVe.setVisible(false);
    }//GEN-LAST:event_btnChuyenBayActionPerformed

    private void txtMaLoaiVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiVeActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLyGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyGiay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChuyenBay;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHangVe;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLoaiVe;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblLoiGiaBan;
    private javax.swing.JLabel lblLoiMaChuyenBay;
    private javax.swing.JLabel lblLoiMaHangVe;
    private javax.swing.JLabel lblLoiMaLoai;
    private javax.swing.JLabel lblLoiMaVe;
    private javax.swing.JLabel lblSTT;
    private javax.swing.JPanel pnlChuyenBay;
    private javax.swing.JPanel pnlLoaiVe;
    private javax.swing.JPanel pnlhangVe;
    private javax.swing.JScrollPane splTable;
    private javax.swing.JSeparator sptChuyenBay;
    private javax.swing.JSeparator sptHangVe;
    private javax.swing.JSeparator sptLoaiVe;
    private javax.swing.JTable tblVeMB;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtHangVe;
    private javax.swing.JTextField txtMaChuyenBay;
    private javax.swing.JTextField txtMaLoaiVe;
    private javax.swing.JTextField txtMaVeMayBay;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
