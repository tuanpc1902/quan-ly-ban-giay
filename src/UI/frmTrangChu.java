/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DoanhThuTheoNamDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * 
 */
public class frmTrangChu extends javax.swing.JFrame {
    void loadBieuDo(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str = "Doanh thu bán vé máy bay hằng năm";
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2019), str, "2019");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2018), str, "2018");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2017), str, "2017");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2016), str, "2016");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2015), str, "2015");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2014), str, "2014");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2013), str, "2013");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2012), str, "2012");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2011), str, "2011");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2010), str, "2010");
        dataset.addValue(new DoanhThuTheoNamDAO().getDoanhThu(2009), str, "2009");
        JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ DOANH THU THEO NĂM", "Năm", "Tiền (Triệu)", dataset , PlotOrientation.VERTICAL, true, true, true);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(pnlBieuDo.getWidth() - 10, pnlBieuDo.getHeight() - 10));
        pnlBieuDo.setLayout(new java.awt.BorderLayout());
        pnlBieuDo.add(chartPanel, BorderLayout.CENTER);
        pnlBieuDo.validate();
    }
    

    
    void loadPercentDT(){
        int nam2018 = Integer.parseInt(String.valueOf(Math.round(new DoanhThuTheoNamDAO().getDoanhThu(2018))));
        int nam2019 = Integer.parseInt(String.valueOf(Math.round(new DoanhThuTheoNamDAO().getDoanhThu(2019))));
        int per = nam2019 * 100 / nam2018;

        if(nam2019 < nam2018){
            ImageIcon icon = new ImageIcon("src//Icon//downHome.png");

        }else{
            ImageIcon icon = new ImageIcon("src//Icon//upHome.png");

        }
    }
    
    public frmTrangChu() {
        initComponents();
        setLocationRelativeTo(this);
        loadBieuDo();

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
        jPanel5 = new javax.swing.JPanel();
        pnlBieuDo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnlBieuDoLayout = new javax.swing.GroupLayout(pnlBieuDo);
        pnlBieuDo.setLayout(pnlBieuDoLayout);
        pnlBieuDoLayout.setHorizontalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        pnlBieuDoLayout.setVerticalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1010, 520));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("CHÀO MỪNG BẠN ĐẾN VỚI HỆ THỐNG BÁN GIÀY SNKA SHOES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

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
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pnlBieuDo;
    // End of variables declaration//GEN-END:variables
}
