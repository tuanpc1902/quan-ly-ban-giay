/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DoanhThuTheoThangDAO;
import DungChung.DungChung;
import DungChung.ExportExcel;
import DungChung.ExportPDF;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class frmDoanhThuTheoThang extends javax.swing.JFrame {

    int showHide_Quy = 1;
    int showHide_Nam = 1;

    void loadTable_DoanhThu() {
        try {
            int quy = 0;
            int nam = 0;
            if (!txtQuy.getText().isEmpty()) {
                quy = Integer.parseInt(String.valueOf(txtQuy.getText().trim()));
            }
            if (!txtNam.getText().isEmpty()) {
                nam = Integer.parseInt(String.valueOf(txtNam.getText().trim()));
            }
            new DoanhThuTheoThangDAO().loadTable_DoanhThu(tblDoanhThuThang, quy, nam);
            int[] col = new int[]{40, 110, 120, 120, 110, 140};
            new DungChung().editColumnWidth(col, tblDoanhThuThang);
            double tongTien = 0.0;
            int tongGhe = 0;
            for (int i = 0; i < tblDoanhThuThang.getRowCount(); i++) {
                tongTien += Double.parseDouble(String.valueOf(tblDoanhThuThang.getValueAt(i, 5)));
                tongGhe += Integer.parseInt(String.valueOf(tblDoanhThuThang.getValueAt(i, 4)));
            }
            
            lblTongTien.setText(null);
            
            lblTongTien.setText("Tổng tiền: " + tongTien + " triệu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cbx_Quy() {
        int cao = 3;
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            for (int i = 1; i < 5; i++) {
                JLabel lbl = new JLabel(String.valueOf(i));
                lbl.setSize(pnlThang.getWidth(), 20);
                lbl.setName("lblThang;" + i);
                lbl.setLocation(10, cao);
                lbl.setForeground(Color.white);
                lbl.setFont(new Font("Segoe UI", 0, 14));
                lbl.setCursor(new Cursor(HAND_CURSOR));
                listLBL.add(lbl);
                lbl.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String[] s = e.toString().split(";");
                        String str = s[1];
                        txtQuy.setText(str);
                        pnlThang.setVisible(false);
                        showHide_Quy++;
                        loadTable_DoanhThu();
                        loadChart();
                        loadSLVe();
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
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });
                pnlThang.add(lbl);
                cao += 20;
            }
            pnlThang.setPreferredSize(new Dimension(sptMaHoaDon.getWidth(), 4 * 20 + 7));
            pnlThang.setVisible(false);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void cbx_Nam() {
        int cao = 3;
        ArrayList<JLabel> listLBL = new ArrayList<>();
        try {
            for (int i = 2009; i < 2020; i++) {
                JLabel lbl = new JLabel(String.valueOf(i));
                lbl.setSize(pnlNam.getWidth(), 20);
                lbl.setName("lblNam" + i);
                lbl.setLocation(10, cao);
                lbl.setForeground(Color.white);
                lbl.setFont(new Font("Segoe UI", 0, 14));
                lbl.setCursor(new Cursor(HAND_CURSOR));
                listLBL.add(lbl);
                lbl.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String[] s = e.toString().split(" ");
                        String str = s[s.length - 1].substring(6, 10);
                        txtNam.setText(str);
                        pnlNam.setVisible(false);
                        showHide_Nam++;
                        loadTable_DoanhThu();
                        loadChart();
                        loadSLVe();
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
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });
                pnlNam.add(lbl);
                cao += 20;
            }
            pnlNam.setPreferredSize(new Dimension(sptMaVe.getWidth(), listLBL.size() * 20 + 7));
            pnlNam.setVisible(false);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    void showHideCBX_Thang() {
        showHide_Quy++;
        if (showHide_Quy % 2 == 0) {
            pnlThang.setVisible(true);
        } else {
            pnlThang.setVisible(false);
        }
    }

    void showHideCBX_Nam() {
        showHide_Nam++;
        if (showHide_Nam % 2 == 0) {
            pnlNam.setVisible(true);
        } else {
            pnlNam.setVisible(false);
        }
    }

    void loadChart() {
        pnlBieuDo.removeAll();
        int quy = Integer.parseInt(String.valueOf(txtQuy.getText().trim()));
        int nam = Integer.parseInt(String.valueOf(txtNam.getText().trim()));
        new DoanhThuTheoThangDAO().loadChart(pnlBieuDo, quy, nam);
    }

    void exportExcel() {
        new ExportExcel().exportExcel("DANH SÁCH THỐNG KẾ DOANH THU THEO THÁNG", "Chuyến bay", tblDoanhThuThang, new int[]{1500, 5000, 5000, 6000, 5500, 5000, 5000, 5000, 6000});
        JOptionPane.showMessageDialog(this, "Xuất file excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    void exportPDF() {
        new ExportPDF().exportPDF("DANH SÁCH THỐNG KẾ DOANH THU THEO THÁNG", tblDoanhThuThang);
        JOptionPane.showMessageDialog(this, "Xuất file pdf thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    void loadSLVe() {
        int quy = 0;
        int nam = 0;
        if (!txtQuy.getText().isEmpty()) {
            quy = Integer.parseInt(String.valueOf(txtQuy.getText().trim()));
        }
        if (!txtNam.getText().isEmpty()) {
            nam = Integer.parseInt(String.valueOf(txtNam.getText().trim()));
        }
        int s1 = new DoanhThuTheoThangDAO().getSL_Ve(quy, nam, "HV01", "lV01");
        int s2 = new DoanhThuTheoThangDAO().getSL_Ve(quy, nam, "HV01", "lV02");
        int s3 = new DoanhThuTheoThangDAO().getSL_Ve(quy, nam, "HV02", "lV01");
        int s4 = new DoanhThuTheoThangDAO().getSL_Ve(quy, nam, "HV02", "lV02");
        
        
    }

    void in_ThongKe(){
        int quy = 0;
        int nam = 0;
        if (!txtQuy.getText().isEmpty()) {
            quy = Integer.parseInt(String.valueOf(txtQuy.getText().trim()));
        }
        if (!txtNam.getText().isEmpty()) {
            nam = Integer.parseInt(String.valueOf(txtNam.getText().trim()));
        }
        int tongTien = new DoanhThuTheoThangDAO().getTongTien(quy, nam);
        new DoanhThuTheoThangDAO().in_ThongKe(quy, nam, tongTien);
    }
    
    public frmDoanhThuTheoThang() {
        initComponents();
        setLocationRelativeTo(this);
        cbx_Quy();
        cbx_Nam();
        txtQuy.setText("3");
        txtNam.setText("2019");
        loadSLVe();
        loadTable_DoanhThu();
        loadChart();
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

        jPanel5 = new javax.swing.JPanel();
        pnlThang = new javax.swing.JPanel();
        pnlNam = new javax.swing.JPanel();
        sptMaVe = new javax.swing.JSeparator();
        txtNam = new javax.swing.JTextField();
        btnNam = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sptMaHoaDon = new javax.swing.JSeparator();
        btnThang = new javax.swing.JLabel();
        txtQuy = new javax.swing.JTextField();
        lblTongTien = new javax.swing.JLabel();
        splTable = new javax.swing.JScrollPane();
        tblDoanhThuThang = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        pnlBieuDo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnPDF = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlThang.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlThangLayout = new javax.swing.GroupLayout(pnlThang);
        pnlThang.setLayout(pnlThangLayout);
        pnlThangLayout.setHorizontalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        pnlThangLayout.setVerticalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(pnlThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        pnlNam.setBackground(new java.awt.Color(194, 194, 194));

        javax.swing.GroupLayout pnlNamLayout = new javax.swing.GroupLayout(pnlNam);
        pnlNam.setLayout(pnlNamLayout);
        pnlNamLayout.setHorizontalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        pnlNamLayout.setVerticalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(pnlNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));
        jPanel5.add(sptMaVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 390, 10));

        txtNam.setEditable(false);
        txtNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNam.setBorder(null);
        txtNam.setOpaque(false);
        txtNam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamKeyReleased(evt);
            }
        });
        jPanel5.add(txtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 360, -1));

        btnNam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNamMouseEntered(evt);
            }
        });
        jPanel5.add(btnNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("THỐNG KÊ DOANH THU THEO QUÝ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, -1));
        jPanel5.add(sptMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 360, 10));

        btnThang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down.png"))); // NOI18N
        btnThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThangMouseEntered(evt);
            }
        });
        jPanel5.add(btnThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        txtQuy.setEditable(false);
        txtQuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuy.setBorder(null);
        txtQuy.setOpaque(false);
        txtQuy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuyKeyReleased(evt);
            }
        });
        jPanel5.add(txtQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 330, -1));

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(51, 51, 51));
        lblTongTien.setText("Tổng tiền:");
        jPanel5.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, -1, -1));

        tblDoanhThuThang.setAutoCreateRowSorter(true);
        tblDoanhThuThang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDoanhThuThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Mã vé", "Giá bán (triệu)", "Số giày đặt", "Thành tiền (triệu)"
            }
        ));
        tblDoanhThuThang.setAutoscrolls(false);
        tblDoanhThuThang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDoanhThuThang.setFocusable(false);
        tblDoanhThuThang.setGridColor(new java.awt.Color(255, 255, 255));
        tblDoanhThuThang.setOpaque(false);
        tblDoanhThuThang.setRequestFocusEnabled(false);
        tblDoanhThuThang.setRowHeight(30);
        tblDoanhThuThang.setRowMargin(0);
        tblDoanhThuThang.setSelectionBackground(new java.awt.Color(55, 38, 91));
        tblDoanhThuThang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDoanhThuThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoanhThuThangMouseClicked(evt);
            }
        });
        splTable.setViewportView(tblDoanhThuThang);

        jPanel5.add(splTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 640, 290));

        jSeparator2.setBackground(new java.awt.Color(55, 38, 91));
        jSeparator2.setForeground(new java.awt.Color(55, 38, 91));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(40, 10));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 620, 10, 40));

        javax.swing.GroupLayout pnlBieuDoLayout = new javax.swing.GroupLayout(pnlBieuDo);
        pnlBieuDo.setLayout(pnlBieuDoLayout);
        pnlBieuDoLayout.setHorizontalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        pnlBieuDoLayout.setVerticalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        jPanel5.add(pnlBieuDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 280, 290));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Quý");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Năm");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

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
        jPanel5.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 620, -1, -1));

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
        jPanel5.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, -1, -1));

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/bgButtonIn.png"))); // NOI18N
        btnPrint.setBorder(null);
        btnPrint.setBorderPainted(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.setFocusPainted(false);
        btnPrint.setFocusable(false);
        btnPrint.setIconTextGap(0);
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamKeyReleased

    private void btnNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNamMouseClicked
        showHideCBX_Nam();
    }//GEN-LAST:event_btnNamMouseClicked

    private void btnNamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNamMouseEntered
        btnNam.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_btnNamMouseEntered

    private void txtQuyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuyKeyReleased

    private void tblDoanhThuThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoanhThuThangMouseClicked

    }//GEN-LAST:event_tblDoanhThuThangMouseClicked

    private void btnThangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThangMouseEntered
        btnThang.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_btnThangMouseEntered

    private void btnThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThangMouseClicked
        showHideCBX_Thang();
    }//GEN-LAST:event_btnThangMouseClicked

    private void btnPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseEntered
        new DungChung().hoverButton5(1, btnPDF, "bgButtonFPTHover.png");
    }//GEN-LAST:event_btnPDFMouseEntered

    private void btnPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseExited
        new DungChung().hoverButton5(2, btnPDF, "bgButtonFPT.png");
    }//GEN-LAST:event_btnPDFMouseExited

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        exportPDF();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseEntered
        new DungChung().hoverButton5(1, btnExcel, "bgButtonExcelHover.png");
    }//GEN-LAST:event_btnExcelMouseEntered

    private void btnExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseExited
        new DungChung().hoverButton5(2, btnExcel, "bgButtonExcel.png");
    }//GEN-LAST:event_btnExcelMouseExited

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        exportExcel();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        in_ThongKe();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        new DungChung().hoverButton5(1, btnPrint, "bgButtonInHover.png");
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        new DungChung().hoverButton5(2, btnPrint, "bgButtonIn.png");
    }//GEN-LAST:event_btnPrintMouseExited

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
            java.util.logging.Logger.getLogger(frmDoanhThuTheoThang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoanhThuTheoThang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoanhThuTheoThang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoanhThuTheoThang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDoanhThuTheoThang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JLabel btnNam;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel btnThang;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlBieuDo;
    private javax.swing.JPanel pnlNam;
    private javax.swing.JPanel pnlThang;
    private javax.swing.JScrollPane splTable;
    private javax.swing.JSeparator sptMaHoaDon;
    private javax.swing.JSeparator sptMaVe;
    private javax.swing.JTable tblDoanhThuThang;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtQuy;
    // End of variables declaration//GEN-END:variables
}
